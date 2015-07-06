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

import com.AirTraffic.Team2.Models.AirportBean;
import com.AirTraffic.Team2.Models.BookingBean;
import com.AirTraffic.Team2.Models.FlightBean;
import com.AirTraffic.Team2.dao.AirportDAO;
import com.AirTraffic.Team2.dao.BookFlightDAO;
import com.AirTraffic.Team2.dao.FlightDAO;




@SuppressWarnings("serial")
@WebServlet("/searchFlight")

public class SearchFlightServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			AirportDAO airportDAO = new AirportDAO();			
			List<AirportBean> airportIataList = airportDAO.getAirportIata();
			request.setAttribute("allIata", airportIataList);

		} catch (Throwable e) {
			request.setAttribute("error", e.getMessage());
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("SearchFlight.jsp");		
		dispatcher.forward(request, response);
	}
	
	

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		 try {
			    String departureAirport = request.getParameter("departureAirportDdl").toString();
			    String arrivalAirport = request.getParameter("arrivalAirportDdl").toString();
			    String departureDate = request.getParameter("departureDate").toString();
			    String arrivalDate = request.getParameter("arrivalDate").toString();
			    
				FlightDAO flightDAO = new FlightDAO(); 		
				
				List<FlightBean> flightList = flightDAO.getFlights(departureAirport, arrivalAirport, departureDate, arrivalDate);			
			    
				AirportDAO airportDAO = new AirportDAO();			
				List<AirportBean> airportIataList = airportDAO.getAirportIata();
				
				
				request.setAttribute("allIata", airportIataList);				
				request.setAttribute("flights", flightList);
             
         } catch (Throwable e) {
             request.setAttribute("error", e.getMessage());
         }         
		RequestDispatcher dispatcher = request.getRequestDispatcher("SearchFlight.jsp");
		dispatcher.forward(request, response);
	}
}