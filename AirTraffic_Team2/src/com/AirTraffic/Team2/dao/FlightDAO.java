package com.AirTraffic.Team2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.AirTraffic.Team2.Models.*;


public class FlightDAO extends AbstractDAO {

  public List<FlightBean> getFlights_departure(String departureAirport, String arrivalAirport,
      String departureDate, String arrivalDate, String seatClass) throws FlightNotFoundException,
      SQLException, ParseException {

    // java.util.Date date = new java.util.Date();
    // SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    String query_departure =
        "With flightdetails as (select f.flight_id,f.flight_scheduleddeparturetime as departure_time,"
            + " f.flight_scheduledarrivaltime as arrival_time,fs.origin,fs.destination, f.flight_price_"
            + seatClass
            + " from flight f "
            + " inner join flightsegment fs on f.flightsegment_id=fs.flightsegment_id  )"
            + " select flightdetails.*,flightday.flight_dayofweek from flightdetails inner join flightday on flightdetails.flight_id="
            + "flightday.flight_id"
            + " where (flightdetails.origin=? and flightdetails.destination=? and flightday.flight_dayofweek=?);";
   

    List<FlightBean> flightList = new ArrayList<FlightBean>();

    String departureDay = departureDate;
    java.util.Date date;
    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    date = formatter.parse(departureDate);
    DateFormat df = new SimpleDateFormat("EEEE");
    departureDate = df.format(date).toUpperCase();

    try (Connection connection = getConnection();
        PreparedStatement preparedStatement1 = connection.prepareStatement(query_departure);
) {

      preparedStatement1.setString(1, departureAirport);
      preparedStatement1.setString(2, arrivalAirport);
      preparedStatement1.setString(3, departureDate);
      
      try (ResultSet resultSet1 = preparedStatement1.executeQuery();) {
        if (resultSet1.next()) {
          do {
            FlightBean flight = new FlightBean();
            FlightSegmentBean flightSegmentBean = new FlightSegmentBean();
            AirportBean origin = new AirportBean();
            AirportBean destination = new AirportBean();
            flight.setFlight_Id(resultSet1.getString(1));
            flight.setFlight_scheduled_departure_time(resultSet1.getTime(2));
            flight.setFlight_scheduled_arrival_time(resultSet1.getTime(3));
            flight.setDepartureDay(resultSet1.getString(7));
            flight.setFlight_price(resultSet1.getDouble(6));
            flight.setDepartureDate(departureDay);
            flight.setArrivalDate(arrivalDate);
            origin.setAirport_iata(resultSet1.getString(4));
            destination.setAirport_iata(resultSet1.getString(5));
            flightSegmentBean.setOriginAirport(origin);
            flightSegmentBean.setDestinationAirport(destination);
            flight.setFlightSegmentBean(flightSegmentBean);
            flight.setSeatClass(seatClass);
            flightList.add(flight);
          } while (resultSet1.next());
        } else {
          throw new FlightNotFoundException("Database has no flights!");
        }
        resultSet1.close();
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
  public static class FlightNotFoundException extends Throwable {
    FlightNotFoundException(String message) {
      super(message);
    }
  }
  public List<FlightBean> getFlights_return(String departureAirport, String arrivalAirport,
	      String departureDate, String arrivalDate, String seatClass) throws FlightNotFoundException,
	      SQLException, ParseException {
	  String query_return =
	            "With flightdetails as (select f.flight_id,f.flight_scheduleddeparturetime as departure_time,"
	                + " f.flight_scheduledarrivaltime as arrival_time,fs.origin,fs.destination, f.flight_price_"
	                + seatClass
	                + " from flight f "
	                + " inner join flightsegment fs on f.flightsegment_id=fs.flightsegment_id  )"
	                + " select flightdetails.*,flightday.flight_dayofweek from flightdetails inner join flightday on flightdetails.flight_id="
	                + "flightday.flight_id"
	                + " where (flightdetails.origin=? and flightdetails.destination=? and flightday.flight_dayofweek=?);";
	  List<FlightBean> flightList = new ArrayList<FlightBean>();

	    String departureDay = arrivalDate;
	    java.util.Date date;
	    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    date = formatter.parse(arrivalDate);
	    DateFormat df = new SimpleDateFormat("EEEE");
	    arrivalDate = df.format(date).toUpperCase();
	  
	  try (Connection connection = getConnection();
		       PreparedStatement preparedStatement2 = connection.prepareStatement(query_return);) {

		  preparedStatement2.setString(1, arrivalAirport);
	      preparedStatement2.setString(2, departureAirport);
	      preparedStatement2.setString(3, arrivalDate);
	   try (ResultSet resultSet1 = preparedStatement2.executeQuery();) {
	        if (resultSet1.next()) {
	          do {
	            FlightBean flight = new FlightBean();
	            FlightSegmentBean flightSegmentBean = new FlightSegmentBean();
	            AirportBean origin = new AirportBean();
	            AirportBean destination = new AirportBean();
	            flight.setFlight_Id(resultSet1.getString(1));
	            flight.setFlight_scheduled_departure_time(resultSet1.getTime(2));
	            flight.setFlight_scheduled_arrival_time(resultSet1.getTime(3));
	            flight.setDepartureDay(resultSet1.getString(7));
	            flight.setFlight_price(resultSet1.getDouble(6));
	            flight.setDepartureDate(arrivalDate);
	            flight.setArrivalDate(departureDay);
	            origin.setAirport_iata(resultSet1.getString(4));
	            destination.setAirport_iata(resultSet1.getString(5));
	            flightSegmentBean.setOriginAirport(destination);
	            flightSegmentBean.setDestinationAirport(origin);
	            flight.setFlightSegmentBean(flightSegmentBean);;
	            flightList.add(flight);
	          } while (resultSet1.next());
	        } else {
	          throw new FlightNotFoundException("Database has no flights!");
	        }
	        resultSet1.close();
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
  }

