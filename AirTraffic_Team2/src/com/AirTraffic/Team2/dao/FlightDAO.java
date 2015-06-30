package com.AirTraffic.Team2.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import com.AirTraffic.Team2.Servlets.SearchFlightServlet;
import com.AirTraffic.Team2.Models.*;


public class FlightDAO extends AbstractDAO{

	public List<FlightBean> getFlights() throws FlighNotFoundException,SQLException {

//		java.util.Date date = new java.util.Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		
		String query = "select f.flight_id,f.flight_scheduleddeparturetime as departure_time,"
				+"f.flight_scheduledarrivaltime as arrival_time,"
				+"fs.origin,fs.destination from flight f inner join flightsegment fs"
				+" on f.flightsegment_id=fs.flightsegment_id;";
		
		List<FlightBean> flightList =new ArrayList<FlightBean>();


		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {



			try (ResultSet resultSet = preparedStatement.executeQuery();) {

				if(resultSet.next()){
					do {
						FlightBean flight = new FlightBean();	
						FlightSegmentBean flightSegmentBean= new FlightSegmentBean();
						AirportBean origin= new AirportBean();
						AirportBean destination= new AirportBean();
						
						flight.setFlight_Id(resultSet.getString(1));
						flight.setFlight_scheduled_departure_time(resultSet.getTime(2));
						flight.setFlight_scheduled_arrival_time(resultSet.getTime(3));
						
						origin.setAirport_iata(resultSet.getString(4));
						destination.setAirport_iata(resultSet.getString(5));
						
						flightSegmentBean.setOriginAirport(origin);
						flightSegmentBean.setDestinationAirport(destination);
						
						flight.setFlightSegmentBean(flightSegmentBean);;
						
						flightList.add(flight);

					} while (resultSet.next());
				}
				else {
					throw new FlighNotFoundException("Database has no flights!");
				}
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}

		return flightList;
	}


	@SuppressWarnings("serial")
	public static class FlighNotFoundException extends Throwable {
		FlighNotFoundException(String message){
			super(message);
		}
	}

		public static void main(String args[]) throws SQLException, FlighNotFoundException, ServletException, IOException{
			FlightDAO flightDAO = new FlightDAO();
	
			List<FlightBean> flightList = flightDAO.getFlights();
			System.out.println(flightList.size());
			for (int i = 0; i< flightList.size(); i++) {
				System.out.println(flightList.get(i).getFlight_Id());
				System.out.println(flightList.get(i).getFlight_scheduled_departure_time());
				System.out.println(flightList.get(i).getFlight_scheduled_arrival_time());
				System.out.println(flightList.get(i).getFlightSegmentBean().getOriginAirport().getAirport_iata());
				System.out.println(flightList.get(i).getFlightSegmentBean().getDestinationAirport().getAirport_iata());
				  
			}
	//OrderServlet ods = new OrderServlet();
	//		PartServlet cos = new PartServlet();
	//		cos.doGet(null, null);
	//		//		ods.doGet(null,null);
		}

}
