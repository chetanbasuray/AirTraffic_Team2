package com.AirTraffic.Team2.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AirTraffic.Team2.Models.FlightBean;
import com.AirTraffic.Team2.Models.RunwayBean;
import com.AirTraffic.Team2.dao.AirplaneJournalDao;
import com.AirTraffic.Team2.dao.CancelTicketDAO;
import com.AirTraffic.Team2.dao.FlightLogDao;
import com.AirTraffic.Team2.dao.RunwayDao;

@SuppressWarnings("serial")
public class CancelBookingServlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
	try{  
    RequestDispatcher dispatcher = request.getRequestDispatcher("/CancelBooking.jsp");
    dispatcher.forward(request, response);
  }catch (Throwable e) {
		request.setAttribute("error", e.getMessage());
	}
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
     String ticket_pnr= request.getParameter("ticketPNR").toString();
     CancelTicketDAO ticketDao=new CancelTicketDAO();
    String returnmsg= ticketDao.cancelTicket(ticket_pnr);
	request.setAttribute("returnmsg", returnmsg);
    }catch(Throwable e){
    	request.setAttribute("error", e.getMessage());    }
    RequestDispatcher dispatcher = request.getRequestDispatcher("/CancelBooking.jsp");
    dispatcher.forward(request, response);
  }
}
