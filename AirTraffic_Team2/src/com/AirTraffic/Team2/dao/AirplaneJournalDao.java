package com.AirTraffic.Team2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.AirTraffic.Team2.Models.FlightBean;
import com.AirTraffic.Team2.Models.RunwayBean;

public class AirplaneJournalDao extends AbstractDAO {
  /**
   * @return the incoming flights within 20 mins of current time at flight controller's airport
   * @throws SQLException
   */
  public List<FlightBean> getIncomingFlights() throws SQLException {
    // TODO replace destination with session variable
    String query =
        "select airplanejournal_flightid from airplanejournal "
            + "where (Extract(epoch from ((airplanejournal_journeystartdate+ "
            + "(airplanejournal_totaljourneyduration * interval '1 minute'))"
            + "-localtimestamp))/60) between 0 and 20 and airplanejournal_flightid "
            + "in (select flight_id from flight where flightsegment_id "
            + "in (Select flightsegment_id from flightsegment where destination='MUC')) "
            + "and airplanejournal_flightid not in (select flightlog_flightid from flightlog "
            + "where (Extract(epoch from (localtimestamp-flightlog_date))/3600)<=6);";
    List<FlightBean> incomingFlights = new ArrayList<FlightBean>();
    try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);) {
      try (ResultSet resultSet = preparedStatement.executeQuery();) {
        while (resultSet.next()) {
          FlightBean flight = new FlightBean();
          flight.setFlight_Id(resultSet.getString(1));
          incomingFlights.add(flight);
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
    return incomingFlights;
  }

  public FlightBean getFlightInfo(FlightBean flight) throws Exception {
    String query =
        "SELECT airplanejournal_journeystartdate, " + "airplanejournal_journeystartdate+ ("
            + "airplanejournal_totaljourneyduration * interval"
            + " '1 minute') FROM airplanejournal where airplanejournal_flightid=?";
    try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);) {
      preparedStatement.setString(1, flight.getFlight_Id());
      try (ResultSet resultSet = preparedStatement.executeQuery();) {
        if (resultSet.next()) {
          flight.setFlight_scheduled_departure_timestamp(resultSet.getTimestamp(1));
          flight.setFlight_scheduled_arrival_timestamp(resultSet.getTimestamp(2));
        } else {
          throw new Exception("No flight found with flight id " + flight.getFlight_Id());
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
    return flight;
  }

}
