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

public class FlightLogDao extends AbstractDAO {
  public boolean createLog(FlightBean flight, RunwayBean runway, int FlightControllerId)
      throws Exception {
    AirplaneJournalDao airplaneJournalDao = new AirplaneJournalDao();
    flight = airplaneJournalDao.getFlightInfo(flight);
    RunwayDao runwayDao = new RunwayDao();
    String selectFlightLog =
        "select flightlog_flightid from flightlog "
            + "where (Extract(epoch from (localtimestamp-flightlog_date))/3600)<=6 and flightlog_flightid=?";

    String query = "INSERT into flightlog values (DEFAULT,localtimestamp,?,?,?,?,null,null,?)";
    try (Connection connection = getConnection()) {
      connection.setAutoCommit(false);
      if (runwayDao.assignRunway(runway, connection)) {
        PreparedStatement preparedStatement1 = connection.prepareStatement(selectFlightLog);
        preparedStatement1.setString(1, flight.getFlight_Id());
        ResultSet logs = preparedStatement1.executeQuery();
        if (!logs.next()) {
          PreparedStatement preparedStatement = connection.prepareStatement(query);
          preparedStatement.setString(1, flight.getFlight_Id());
          preparedStatement.setInt(2, runway.getRunway_id());
          preparedStatement.setTimestamp(3, flight.getFlight_scheduled_departure_timestamp());
          preparedStatement.setTimestamp(4, flight.getFlight_scheduled_arrival_timestamp());
          preparedStatement.setInt(5, FlightControllerId);
          if (preparedStatement.executeUpdate() != 0) {
            connection.commit();
            return true;
          }
        }
        connection.rollback();
        return false;
      } else {
        connection.rollback();
        return false;
      }
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    }
  }
}
