package com.AirTraffic.Team2.Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AirTraffic.Team2.Models.AirportBean;
import com.AirTraffic.Team2.Models.FlightBean;
import com.AirTraffic.Team2.dao.AirportDAO;
import com.AirTraffic.Team2.dao.FlightDAO;




@SuppressWarnings("serial")

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
		RequestDispatcher dispatcher = request.getRequestDispatcher("/SearchFlight.jsp");		
		dispatcher.forward(request, response);
	}
	
	

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		 try {
			    String departureAirport = request.getParameter("departureAirportDdl").toString();
			    String arrivalAirport = request.getParameter("arrivalAirportDdl").toString();
			    String departureDate = request.getParameter("departureDate").toString();
			    String arrivalDate = request.getParameter("arrivalDate").toString();
			    String seatClass = request.getParameter("class").toString();
			    			    
				FlightDAO flightDAO = new FlightDAO(); 		
				
				List<FlightBean> flightList_departure = flightDAO.getFlights_departure(departureAirport, arrivalAirport, departureDate, arrivalDate, seatClass);			
				List<FlightBean> flightList_return = flightDAO.getFlights_return(departureAirport, arrivalAirport, departureDate, arrivalDate, seatClass);			

				AirportDAO airportDAO = new AirportDAO();			
				List<AirportBean> airportIataList = airportDAO.getAirportIata();
				
				request.setAttribute("allIata", airportIataList);				
				request.setAttribute("flights", flightList_departure);
				request.setAttribute("flights_return", flightList_return);


             
         } catch (Throwable e) {
             request.setAttribute("error", e.getMessage());
         }         
		RequestDispatcher dispatcher = request.getRequestDispatcher("/SearchFlight.jsp");
		dispatcher.forward(request, response);
	}
}