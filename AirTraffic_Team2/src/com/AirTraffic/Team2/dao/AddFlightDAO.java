package com.AirTraffic.Team2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.AirTraffic.Team2.Models.AirplaneBean;
import com.AirTraffic.Team2.Models.FlightBean;
import com.AirTraffic.Team2.Models.FlightSegmentBean;

public class AddFlightDAO extends AbstractDAO{

	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	public String addFlight(FlightBean flightBean, String departureAirport,
			String arrivalAirport) throws SQLException {
		
		String returnmsg = null;
		String query = "select flightsegment_id from flightsegment where origin = ? and destination = ?";
		String query1 = "insert into flightsegment(flightsegment_numberofmiles, origin, destination) values(?, ?, ?)";
		String query2 = "insert into flight values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		String query3 = "insert into flightday values(?, ?)";
		
		try (Connection connection = getConnection()) {
			//checking if a flight segment already exists
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, departureAirport);
			preparedStatement.setString(2, arrivalAirport);
			resultSet = preparedStatement.executeQuery();
			//if no flight segment exists already, we add a new flight segment
			if(!resultSet.next()){
				preparedStatement = connection.prepareStatement(query1);
				//setting the number of miles to be 0 because this does not fall under current scope
				preparedStatement.setInt(1, 0);
				preparedStatement.setString(2, departureAirport);
				preparedStatement.setString(3, arrivalAirport);
				preparedStatement.executeUpdate();
				//re querying to fetch the flight segment id of the last insert
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, departureAirport);
				preparedStatement.setString(2, arrivalAirport);
				resultSet = preparedStatement.executeQuery();
				while(resultSet.next()){
				FlightSegmentBean flightSegmentBean = new FlightSegmentBean();
				flightSegmentBean.setFlightsegment_id(resultSet.getInt(1));
				flightBean.setFlightSegmentBean(flightSegmentBean);
				}
			}
			//if a flight segment exists, then we use the same
			else{
				//while(resultSet.next()){
					FlightSegmentBean flightSegmentBean = new FlightSegmentBean();
					flightSegmentBean.setFlightsegment_id(resultSet.getInt(1));
					flightBean.setFlightSegmentBean(flightSegmentBean);
				//}
			}
			
			//we now set up the values to be inserted into the flight table
			preparedStatement = connection.prepareStatement(query2);
			
			preparedStatement.setString(1, flightBean.getFlight_Id());
			preparedStatement.setTime(2, flightBean.getFlight_scheduled_departure_time());
			preparedStatement.setTime(3, flightBean.getFlight_scheduled_arrival_time());
			preparedStatement.setInt(4, flightBean.getFlight_first_class_cabin_luggage_limit());
			preparedStatement.setInt(5, flightBean.getFlight_business_class_cabin_luggage_limit());
			preparedStatement.setInt(6, flightBean.getFlight_economy_class_cabin_luggage_limit());
			preparedStatement.setInt(7, flightBean.getFlight_first_class_checkin_luggage_limit());
			preparedStatement.setInt(8, flightBean.getFlight_business_class_checkin_luggage_limit());
			preparedStatement.setInt(9, flightBean.getFlight_economy_class_checkin_luggage_limit());
			preparedStatement.setInt(10, flightBean.getFlightSegmentBean().getFlightsegment_id());
			
			if(preparedStatement.executeUpdate() != 0){
				preparedStatement = connection.prepareStatement(query3);
				//setting up the values to be inserted into the flight days table
				for(int i = 0; i < flightBean.getFlightDaysList().size(); i++){
					preparedStatement.setString(1, flightBean.getFlight_Id());
					preparedStatement.setString(2, flightBean.getFlightDaysList().get(i));
				if(preparedStatement.executeUpdate() != 0){
					returnmsg = "success";
				}else{
					returnmsg = "false";
					connection.rollback();
				}
				}
				connection.commit();
			}else{
				returnmsg = "false";
				connection.rollback();
			}
			
				
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			}
		return returnmsg;
	}
	
	public List<AirplaneBean> getAirplaneIDs() throws SQLException {
		
		String query = "select airplane_id from airplane";
		List<AirplaneBean> airplaneBeanList = new ArrayList<AirplaneBean>();
		try (Connection connection = getConnection()) {
			preparedStatement = connection.prepareStatement(query);
			try (ResultSet resultSet1 = preparedStatement.executeQuery();){ 
			//if(resultSet.next()){
			while(resultSet1.next()){
					AirplaneBean airplaneBean = new AirplaneBean();
					airplaneBean.setAirplane_id(resultSet1.getString(1));
					airplaneBeanList.add(airplaneBean);
				}
			}catch (SQLException e) {
					throw e;
			}
		
	}catch (SQLException e) {
		throw e;
	}
		return airplaneBeanList;
}
}