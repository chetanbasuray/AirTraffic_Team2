package com.AirTraffic.Team2.Models.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractDao {

    protected Connection getConnection() throws SQLException {
    	try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		};
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/IntegratedSchema", "postgres", "matchbox91");
    }
}
