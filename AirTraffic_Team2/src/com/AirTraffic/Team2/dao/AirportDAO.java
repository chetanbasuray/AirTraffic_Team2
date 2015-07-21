package com.AirTraffic.Team2.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import javax.servlet.ServletException;

import com.AirTraffic.Team2.Servlets.SearchFlightServlet;
import com.AirTraffic.Team2.Models.*;


public class AirportDAO extends AbstractDAO{

	public List<AirportBean> getAirportIata() throws AirportNotFoundException,SQLException, ParseException {

//		java.util.Date date = new java.util.Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		
		String query = "select airport_iata from airport order by airport_iata";
		
		List<AirportBean> airportIataList = new ArrayList<AirportBean>();		
		

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			
			
			try (ResultSet resultSet = preparedStatement.executeQuery();) {

				if(resultSet.next()){
					do {						
						AirportBean airportIata= new AirportBean();						
						
						airportIata.setAirport_iata(resultSet.getString(1));						
						
						airportIataList.add(airportIata);

					} while (resultSet.next());
				}
				else {
					throw new AirportNotFoundException("Database has no airport!");
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

		return airportIataList;
	}


	@SuppressWarnings("serial")
	public static class AirportNotFoundException extends Throwable {
		AirportNotFoundException(String message){
			super(message);
		}
	}

		public static void main(String args[]) throws SQLException, AirportNotFoundException, ServletException, IOException, ParseException{
			/*String str_date = "2015-07-28";
			java.util.Date date ;
		    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		    date = formatter.parse(str_date);
			DateFormat df = new SimpleDateFormat("EEEE");
//			df.setTimeZone(TimeZone.getTimeZone("GMT"));
			System.out.println(df.format(date).toUpperCase());*/
			

			AirportDAO airportDAO = new AirportDAO();
	
			List<AirportBean> airportIataList = airportDAO.getAirportIata();
			System.out.println(airportIataList.size());
			for (int i = 0; i< airportIataList.size(); i++) {
				System.out.println(airportIataList.get(i).getAirport_iata());
				
			}
	SearchFlightServlet sfs = new SearchFlightServlet();
	//		PartServlet cos = new PartServlet();
	//		cos.doGet(null, null);
//	sfs.doGet(null,null);
		}

}
