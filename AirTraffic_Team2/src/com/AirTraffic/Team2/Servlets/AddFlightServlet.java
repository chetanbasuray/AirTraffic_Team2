package com.AirTraffic.Team2.Servlets;

import java.io.IOException;
import java.util.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AirTraffic.Team2.Models.AirplaneBean;
import com.AirTraffic.Team2.Models.AirportBean;
import com.AirTraffic.Team2.Models.FlightBean;
import com.AirTraffic.Team2.dao.AddFlightDAO;
import com.AirTraffic.Team2.dao.AirportDAO;


@SuppressWarnings("serial")
public class AddFlightServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			AirportDAO airportDAO = new AirportDAO();			
			List<AirportBean> airportIataList = airportDAO.getAirportIata();
			
			AddFlightDAO addFlightDAO = new AddFlightDAO();
			List<AirplaneBean> airplaneList = addFlightDAO.getAirplaneIDs();

			request.setAttribute("airportIataList", airportIataList);
			request.setAttribute("airplaneList", airplaneList);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/addFlights.jsp");		
			dispatcher.forward(request, response);
			
		} catch (Throwable e) {
			request.setAttribute("error", e.getMessage());
		}
	}
	
	

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		 try {
			    
			    String departureAirport = request.getParameter("departureAirport").toString();
			    String arrivalAirport = request.getParameter("arrivalAirport").toString();
			    
			    FlightBean flightBean = new FlightBean();
			    
			    String arrivalHour = request.getParameter("scheduledArrivalHour").toString();
			    String arrivalMin = request.getParameter("scheduledArrivalMin").toString();
			    String arrivalSec = request.getParameter("scheduledArrivalSec").toString();
			    
			    SimpleDateFormat sdf = new SimpleDateFormat("kk:mm:ss");
			    
			    Date arrDate = (Date) sdf.parse(arrivalHour+":"+arrivalMin+":"+arrivalSec);
			    Time arrTime = new Time(arrDate.getTime());
			    
			    flightBean.setFlight_scheduled_arrival_time(arrTime);
			    
			    String departureHour = request.getParameter("scheduledDepartureHour").toString();
			    String departureMin = request.getParameter("scheduledDepartureMin").toString();
			    String departureSec = request.getParameter("scheduledDepartureSec").toString();
			    
			    Date deptDate = (Date) sdf.parse(departureHour+":"+departureMin+":"+departureSec);
			    
			    Time deptTime = new Time(deptDate.getTime());
			    flightBean.setFlight_scheduled_departure_time(deptTime);
			    
			    flightBean.setFlight_Id(request.getParameter("flightId").toString());
			    
			    flightBean.setFlight_first_class_cabin_luggage_limit(Integer.parseInt(request.getParameter("firstclasscabinluggage")));			    
			    flightBean.setFlight_business_class_cabin_luggage_limit(Integer.parseInt(request.getParameter("businessclasscabinluggage")));
			    flightBean.setFlight_economy_class_cabin_luggage_limit(Integer.parseInt(request.getParameter("economyclasscabinluggage")));
			    flightBean.setFlight_first_class_checkin_luggage_limit(Integer.parseInt(request.getParameter("firstclasscheckinluggage")));
			    flightBean.setFlight_business_class_checkin_luggage_limit(Integer.parseInt(request.getParameter("businessclasscheckinluggage")));
			    flightBean.setFlight_economy_class_cabin_luggage_limit(Integer.parseInt(request.getParameter("economyclasscheckinluggage")));
			    flightBean.setFlight_first_class_price(Double.parseDouble(request.getParameter("firstclassPrice")));
			    flightBean.setFlight_economy_class_price(Double.parseDouble(request.getParameter("economyclassPrice")));
			    flightBean.setFlight_business_class_price(Double.parseDouble(request.getParameter("businessclassPrice")));
    			    
			    List<AirplaneBean> airplanebeanList = new ArrayList<AirplaneBean>();
			    
			    AirplaneBean airplane = new AirplaneBean();
			    airplane.setAirplane_id(request.getParameter("airplaneId"));
			    
			    airplanebeanList.add(airplane);
			    
			    flightBean.setAirplaneBeanList(airplanebeanList);
			    
			    List<String> daysList = new ArrayList<String>();
			    
			    String[] flightDays = request.getParameterValues("flightDays");
			    
			    for (int i = 0; i < flightDays.length; i++) {
			    	daysList.add(flightDays[i]+"DAY");
			    }
			    
			    flightBean.setFlightDaysList(daysList);
			    
			    AddFlightDAO addFlightDAO = new AddFlightDAO(); 		
				
				String returnmsg = addFlightDAO.addFlight(flightBean, departureAirport, arrivalAirport );			
			    
				AirportDAO airportDAO = new AirportDAO();			
				List<AirportBean> airportIataList = airportDAO.getAirportIata();
				
		
				List<AirplaneBean> airplaneList = addFlightDAO.getAirplaneIDs();

				request.setAttribute("airportIataList", airportIataList);
				request.setAttribute("airplaneList", airplaneList);
				request.setAttribute("returnmsg", returnmsg);
			  
      } catch (Throwable e) {
          request.setAttribute("error", e.getMessage());
      }

			RequestDispatcher dispatcher = request.getRequestDispatcher("/addFlights.jsp");
			dispatcher.forward(request, response);

		}

	}
