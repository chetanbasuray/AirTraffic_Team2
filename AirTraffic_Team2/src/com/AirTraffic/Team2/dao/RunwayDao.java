package com.AirTraffic.Team2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.AirTraffic.Team2.Models.RunwayBean;


public class RunwayDao extends AbstractDAO {
  public List<RunwayBean> getAvailableRunways() throws SQLException {
    // TODO get airport_iata from session variable
    String query = "SELECT runway_id FROM RUNWAY WHERE runway_status=true and airport_iata='MUC'";
    List<RunwayBean> availableRunways = new ArrayList<RunwayBean>();
    try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);) {
      try (ResultSet resultSet = preparedStatement.executeQuery();) {
        while (resultSet.next()) {
          RunwayBean runway = new RunwayBean();
          runway.setRunway_id(resultSet.getInt(1));
          availableRunways.add(runway);
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
    return availableRunways;
  }

  public boolean assignRunway(RunwayBean runway, Connection connection) {
    try {
      String selectRunway =
          "Select runway_status from runway where runway_id=" + runway.getRunway_id();
      PreparedStatement preparedStatement1 = connection.prepareStatement(selectRunway);
      ResultSet runways = preparedStatement1.executeQuery();
      if (runways.next()) {
        if (runways.getBoolean(1)) {
          String query = "UPDATE runway set runway_status=false where runway_id=?";
          PreparedStatement preparedStatement = connection.prepareStatement(query);
          preparedStatement.setInt(1, runway.getRunway_id());
          if (preparedStatement.executeUpdate() != 0) {
            return true;
          }
        }
        return false;
      } else
        return false;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }
}
