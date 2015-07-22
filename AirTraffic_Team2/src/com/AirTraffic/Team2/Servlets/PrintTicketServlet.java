package com.AirTraffic.Team2.Servlets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AirTraffic.Team2.Models.FlightBean;
import com.AirTraffic.Team2.Models.PersonBean;
import com.AirTraffic.Team2.Models.TicketBean;
import com.AirTraffic.Team2.dao.TicketDAO;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@SuppressWarnings("serial")
public class PrintTicketServlet extends HttpServlet {
  
  private Font boldTitle = FontFactory.getFont("Arial", 13, Font.BOLD);
  private Font tableColumnHeading = FontFactory.getFont("Arial", 10, Font.BOLD);
  private Font tableCellFont = FontFactory.getFont("Arial", 10, Font.NORMAL);
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    RequestDispatcher dispatcher = request.getRequestDispatcher("PrintTicket.jsp");
    dispatcher.forward(request, response);

  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      String error = null;
      TicketBean ticket = new TicketBean();
      try {
        if (request.getParameterMap().containsKey("pnr")) {
          ticket.setTicket_pnr(request.getParameter("pnr"));
        }
        String lName = null;
        if (request.getParameterMap().containsKey("lastname")) {
          lName = request.getParameter("lastname");
        }
        TicketDAO ticketDao = new TicketDAO();
        ticket = ticketDao.getTicket(ticket.getTicket_pnr(), lName);
      } catch (Throwable e) {
        error = e.getMessage();
      }
      Document document = new Document();
      
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      PdfWriter.getInstance(document, baos);
      document.open();
      Paragraph date = new Paragraph();
      date.setAlignment(Element.ALIGN_RIGHT);;
      DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
      Date printDate = new Date();
      date.add("Print Time: "+dateFormat.format(printDate));
      document.add(date);
      Image image1 = Image.getInstance(new URL("http://www.locanto.info/classifieds/images/airplane.png"));
      image1.scaleAbsolute(100f, 100f);
      image1.setAlignment(Element.ALIGN_CENTER);
      document.add(image1);
      document.addTitle("Ticket");
      Paragraph paragraph = new Paragraph();
      Font heading = FontFactory.getFont("Arial", 15, Font.BOLD);
      paragraph.setFont(heading);
      paragraph.setAlignment(Element.ALIGN_CENTER);
      paragraph.add("Ticket");
      document.add(paragraph);
      if (error == null && ticket != null) {
        
        document.add(makeHeading("Ticket Info"));
        PdfPTable table = new PdfPTable(5);
        table.setPaddingTop(10f);
        table.addCell(makeHeadingColumn("PNR"));
        table.addCell(makeHeadingColumn("Booking Date"));
        table.addCell(makeHeadingColumn("Price"));
        table.addCell(makeHeadingColumn("PaymentType"));
        table.addCell(makeHeadingColumn("Booking Status"));
        table.addCell(new Phrase(ticket.getTicket_pnr(), tableCellFont));
        table.addCell(new Phrase(ticket.getTicket_booking_date().toString(), tableCellFont));
        table.addCell(new Phrase(ticket.getTicket_price()+" "+ticket.getCurrency(), tableCellFont));
        table.addCell(new Phrase(ticket.getPaymenttype(), tableCellFont));
        table.addCell(new Phrase(ticket.getBookingstatus(), tableCellFont));
        document.add(table);
        
        document.add(makeHeading("Passengers Info"));
        PdfPTable table1 = new PdfPTable(6);
        table1.setPaddingTop(10f);
        table1.addCell(makeHeadingColumn("Firstname"));
        table1.addCell(makeHeadingColumn("Lastname"));
        table1.addCell(makeHeadingColumn("Gender"));
        table1.addCell(makeHeadingColumn("DOB"));
        table1.addCell(makeHeadingColumn("Id No."));
        table1.addCell(makeHeadingColumn("Id Type"));
        for (PersonBean passenger : ticket.getPassangers()) {
          table1.addCell(new Phrase(passenger.getPerson_fname(), tableCellFont));
          table1.addCell(new Phrase(passenger.getPerson_lname(), tableCellFont));
          table1.addCell(new Phrase(passenger.getPerson_gender(), tableCellFont));
          table1.addCell(new Phrase(passenger.getPerson_dob().toString(), tableCellFont));
          table1.addCell(new Phrase(passenger.getPerson_official_id(), tableCellFont));
          table1.addCell(new Phrase(passenger.getPerosn_official_id_type(), tableCellFont));
        }
        document.add(table1);
        
        document.add(makeHeading("Flight/Seats Info"));
        PdfPTable table3 = new PdfPTable(8);
        table3.setPaddingTop(10f);
        table3.addCell(makeHeadingColumn("Flight Id"));
        table3.addCell(makeHeadingColumn("Origin"));
        table3.addCell(makeHeadingColumn("Dest."));
        table3.addCell(makeHeadingColumn("Date"));
        table3.addCell(makeHeadingColumn("Dep.Time"));
        table3.addCell(makeHeadingColumn("Arr. Time"));
        table3.addCell(makeHeadingColumn("Seat No."));
        table3.addCell(makeHeadingColumn("Class"));
        for (FlightBean flight : ticket.getFlights()) {
          table3.addCell(new Phrase(flight.getFlight_Id(), tableCellFont));
          table3.addCell(new Phrase(flight.getFlightSegmentBean().getOriginAirport().getAirport_iata(), tableCellFont));
          table3.addCell(new Phrase(flight.getFlightSegmentBean().getDestinationAirport().getAirport_iata(), tableCellFont));
          table3.addCell(new Phrase(flight.getFlight_date().toString(), tableCellFont));
          table3.addCell(new Phrase(flight.getFlight_scheduled_arrival_time().toString(), tableCellFont));
          table3.addCell(new Phrase(flight.getFlight_scheduled_departure_time().toString(), tableCellFont));
          table3.addCell(new Phrase(flight.getSeatNumber(), tableCellFont));
          table3.addCell(new Phrase(flight.getSeatClass(), tableCellFont));
        }
        document.add(table3);
      } else {
        document.add(new Paragraph("An Error occured: "));
        document.add(new Paragraph(error));
      }
      document.close();

      response.setHeader("Expires", "0");
      response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
      response.setHeader("Pragma", "public");
      response.setContentType("application/pdf");
      response.setContentLength(baos.size());
      OutputStream os = response.getOutputStream();
      baos.writeTo(os);

      os.flush();
      os.close();
    } catch (DocumentException e) {
      e.printStackTrace();
    }
  }
  
  private Element makeHeading(String heading) {
    Paragraph ticketHeading = new Paragraph();
    ticketHeading.setFont(boldTitle);
    ticketHeading.setSpacingAfter(15f);
    ticketHeading.setSpacingBefore(15f);
    ticketHeading.add(heading);
    return ticketHeading;
  }

  private PdfPCell makeHeadingColumn(String text){
    Paragraph title = new Paragraph();
    title.setAlignment(Element.ALIGN_CENTER);
    title.setFont(tableColumnHeading);
    title.add(text);
    PdfPCell cell = new PdfPCell(title);
    cell.setColspan(1);
    return cell;
  }
}
