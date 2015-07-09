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
import com.AirTraffic.Team2.dao.FlightLogDao;
import com.AirTraffic.Team2.dao.RunwayDao;

@SuppressWarnings("serial")
public class AssignRunwayServlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    RunwayDao runwayDao = new RunwayDao();
    try {
      request.setAttribute("runways", runwayDao.getAvailableRunways());
    } catch (Throwable e) {
      request.setAttribute("error", e.getMessage());
    }
    AirplaneJournalDao airplaneJournalDao = new AirplaneJournalDao();
    try {
      request.setAttribute("flights", airplaneJournalDao.getIncomingFlights());
    } catch (Throwable e) {
      request.setAttribute("error", e.getMessage());
    }
    RequestDispatcher dispatcher = request.getRequestDispatcher("assignRunway.jsp");
    dispatcher.forward(request, response);
  }
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    try {
    FlightLogDao flightLogDao = new FlightLogDao();
    FlightBean flight = new FlightBean();
    if (request.getParameterMap().containsKey("incomingFlight")){
      flight.setFlight_Id(request.getParameter("incomingFlight"));
    }
    RunwayBean runway = new RunwayBean();
    if (request.getParameterMap().containsKey("availableRunway")){
      runway.setRunway_id(Integer.parseInt(request.getParameter("availableRunway")));
    }
    // TODO add flightcontroller id from session variables
    if(flightLogDao.createLog(flight, runway, 1))
      request.setAttribute("success", "Log Created");
    else
      request.setAttribute("success", "Failed to create Log");
    }catch (Throwable e) {
      request.setAttribute("error", e.getMessage());
    }
    RunwayDao runwayDao = new RunwayDao();
    try {
      request.setAttribute("runways", runwayDao.getAvailableRunways());
    } catch (Throwable e) {
      request.setAttribute("error", e.getMessage());
    }
    AirplaneJournalDao airplaneJournalDao = new AirplaneJournalDao();
    try {
      request.setAttribute("flights", airplaneJournalDao.getIncomingFlights());
    } catch (Throwable e) {
      request.setAttribute("error", e.getMessage());
    }
    RequestDispatcher dispatcher = request.getRequestDispatcher("assignRunway.jsp");
    dispatcher.forward(request, response);
  }
}
