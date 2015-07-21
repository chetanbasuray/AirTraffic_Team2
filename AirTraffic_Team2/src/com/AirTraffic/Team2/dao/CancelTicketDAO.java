package com.AirTraffic.Team2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CancelTicketDAO extends AbstractDAO {
	public static void main(String args[]){
		CancelTicketDAO da=new CancelTicketDAO();
		try {
			da.cancelTicket("123");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	boolean cancelTicket(String ticket_pnr) throws Exception{
	    String findPNR= "select * from ticket where ticket_pnr=?";
	    String ticketCancelQuery =
	    		"update ticket set ticket_bookingstatus_id=1 where ticket_pnr=?";
	    try (Connection connection = getConnection();) {
	        connection.setAutoCommit(false);
	        PreparedStatement preparedStatement1 = connection.prepareStatement(findPNR);
	        preparedStatement1.setString(1, ticket_pnr);
	        try (ResultSet resultSet1 = preparedStatement1.executeQuery();) {
	          if (resultSet1.next()) {
	        	  System.out.println(resultSet1.toString());
	  	        PreparedStatement preparedStatement2 = connection.prepareStatement(ticketCancelQuery);
		        preparedStatement2.setString(1, ticket_pnr);
		        //ResultSet resultSet2 = preparedStatement2.executeQuery();
		        if (preparedStatement2.executeUpdate() != 0) {
	  	    	  System.out.println("success");
	  	        connection.setAutoCommit(true);

	              return true;
	              
	            }
	          }
	          else
	          return false;
	        } 
	      } catch (SQLException e) {
	        e.printStackTrace();
	      }
	      return false;
}
}





