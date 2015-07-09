package com.AirTraffic.Team2.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.AirTraffic.Team2.Models.FlightBean;
import com.AirTraffic.Team2.Models.RunwayBean;

public class FlightLogDao extends AbstractDAO{
  public boolean createLog(FlightBean flight, RunwayBean runway, int FlightControllerId) throws Exception{
    AirplaneJournalDao airplaneJournalDao = new AirplaneJournalDao();
    flight=airplaneJournalDao.getFlightInfo(flight);
    System.out.print(flight.getFlight_scheduled_arrival_time());
    System.out.println(flight.getFlight_scheduled_departure_time());
    System.out.println(flight.getFlight_Id());
    System.out.println(runway.getRunway_id());
    System.out.println(FlightControllerId);
    System.out.println("OK");
    String query =
        "INSERT into flightlog values (DEFAULT,localtimestamp,?,?,?,?,null,null,?)";
    try (Connection connection = getConnection()){
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, flight.getFlight_Id());
        preparedStatement.setInt(2, runway.getRunway_id());
        preparedStatement.setTimestamp(3, flight.getFlight_scheduled_departure_timestamp());
        preparedStatement.setTimestamp(4, flight.getFlight_scheduled_arrival_timestamp());
        preparedStatement.setInt(5, FlightControllerId);
      if(preparedStatement.executeUpdate()!=0) {
        return true;
      }
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    }
    return false;
  }
}
