package com.AirTraffic.Team2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CancelTicketDAO extends AbstractDAO {
	public String cancelTicket(String ticket_pnr) throws Exception{
		String returnmsg = null;

	    String findPNR= "select * from ticket where ticket_pnr=?";
	    String ticketCancelQuery =
	    		"update ticket set ticket_bookingstatus_id=1 where ticket_pnr=? AND ticket_bookingstatus_id!=1";
	    try (Connection connection = getConnection();) {
	        connection.setAutoCommit(false);
	        PreparedStatement preparedStatement1 = connection.prepareStatement(findPNR);
	        preparedStatement1.setString(1, ticket_pnr);
	        try (ResultSet resultSet1 = preparedStatement1.executeQuery();) {
	          if (resultSet1.next()) {
	  	        PreparedStatement preparedStatement2 = connection.prepareStatement(ticketCancelQuery);
		        preparedStatement2.setString(1, ticket_pnr);
		        //ResultSet resultSet2 = preparedStatement2.executeQuery();
		        if(preparedStatement2.executeUpdate() != 0){
					returnmsg = "success";
				}else{
					returnmsg = "false";
					connection.rollback();
				  }
				}
	          else{
	        	  returnmsg = "false";
				  connection.rollback();
	          }
				connection.commit();
			}		
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			}
		return returnmsg;

}
}




