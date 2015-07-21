package com.AirTraffic.Team2.Servlets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

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
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@SuppressWarnings("serial")
public class PrintTicketServlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    /*
     * try{ TicketBean ticket = new TicketBean(); if (request.getParameterMap().containsKey("pnr"))
     * { ticket.setTicket_pnr(request.getParameter("pnr")); } String lName=null; if
     * (request.getParameterMap().containsKey("lastname")) { lName=request.getParameter("lastname");
     * } TicketDAO ticketDao = new TicketDAO(); ticket = ticketDao.getTicket(ticket.getTicket_pnr(),
     * lName); }catch(Throwable e){ request.setAttribute("error", e.getMessage()); }
     * RequestDispatcher dispatcher = request.getRequestDispatcher("printTicket.jsp");
     * dispatcher.forward(request, response);
     */

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
      if (error == null && ticket != null) {
        document.add(new Paragraph(String.format("PNR Number: %s", ticket.getTicket_pnr())));
        for (PersonBean passenger : ticket.getPassangers()) {
          document.add(new Paragraph(String.format("Passenger Name: %s",
              passenger.getPerson_fname())));
        }
        for (FlightBean flight : ticket.getFlights()) {
          document.add(new Paragraph(String.format("Flight: %s", flight.getFlight_Id())));
        }
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
}
