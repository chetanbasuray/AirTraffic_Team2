package com.AirTraffic.Team2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractDAO {

    protected Connection getConnection() throws SQLException {
    	try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		};

        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/airtraffic_final", "postgres", "adnan25");

    }
}
