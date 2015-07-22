package com.AirTraffic.Team2.Servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AirTraffic.Team2.dao.TicketDAO;

@SuppressWarnings("serial")
public class GenerateTicketServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {
    String flightId = null, lastname= null, pnr=null, seatClass=null; 
    Date journeyDate=null;
    int personId=0, currency=0, paymentMethod=0;
    double flightPrice=0;
    try {
      
      if (request.getParameterMap().containsKey("flightId")) {
        flightId = request.getParameter("flightId");
      }
      if (request.getParameterMap().containsKey("seatClass")) {
        seatClass = request.getParameter("seatClass");
      }
      if (request.getParameterMap().containsKey("personId")) {
        personId = Integer.parseInt(request.getParameter("personId"));
      }
      if (request.getParameterMap().containsKey("currency")) {
        currency = Integer.parseInt(request.getParameter("currency"));
      }
      if (request.getParameterMap().containsKey("paymentMethod")) {
        paymentMethod = Integer.parseInt(request.getParameter("paymentMethod"));
      }
      if (request.getParameterMap().containsKey("flightPrice")) {
        flightPrice = Double.parseDouble(request.getParameter("flightPrice"));
      }
      if (request.getParameterMap().containsKey("journeyDate")) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        journeyDate = format.parse(request.getParameter("journeyDate"));
      }
      TicketDAO ticketDao= new TicketDAO();
      if (request.getParameterMap().containsKey("lastname")) {
        lastname = request.getParameter("lastname");
      }
      pnr=ticketDao.generateTicket(flightId, personId, currency, paymentMethod, flightPrice, journeyDate, seatClass);
    }catch(Exception e){
      e.printStackTrace();
    }
   // pnr="TICK123";
   // lastname="Dylan";
    RequestDispatcher dispatcher = request.getRequestDispatcher("printTicket?pnr="+pnr+"&lastname="+lastname);
    dispatcher.forward(request, response);
  }
}
