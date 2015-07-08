package com.AirTraffic.Team2.Models.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.AirTraffic.Team2.Models.RunwayBean;


public class RunwayDao extends AbstractDao {
  public List<RunwayBean> getAvailableRunways() throws SQLException{
    String query = "SELECT runway_id FROM RUNWAY WHERE runway_status=true";
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
}
