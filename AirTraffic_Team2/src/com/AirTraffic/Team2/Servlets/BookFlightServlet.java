package com.AirTraffic.Team2.Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AirTraffic.Team2.Models.BookingBean;
import com.AirTraffic.Team2.dao.BookFlightDAO;




@SuppressWarnings("serial")

public class BookFlightServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			

		} catch (Throwable e) {
			request.setAttribute("error", e.getMessage());
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("BookFlight.jsp");		
		dispatcher.forward(request, response);
	}
	
	

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		 try {
			    String customerId = request.getParameter("existingCustomerID").toString();
				BookFlightDAO bookFlightDAO = new BookFlightDAO(); 		
				
				List<BookingBean> bookPersonDetails = bookFlightDAO.getPersonDetails(customerId);			
			    request.setAttribute("personDetails", bookPersonDetails);
             
         } catch (Throwable e) {
             request.setAttribute("error", e.getMessage());
         }         
		RequestDispatcher dispatcher = request.getRequestDispatcher("BookFlight.jsp");
		dispatcher.forward(request, response);
	}
}