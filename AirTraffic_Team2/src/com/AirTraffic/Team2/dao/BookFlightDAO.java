package com.AirTraffic.Team2.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.AirTraffic.Team2.Models.*;

public class BookFlightDAO extends AbstractDAO {

	public List<BookingBean> getPersonDetails(String personId)
			throws BooikngPersonNotFoundException, SQLException, ParseException {

		String query = "with person_details as (select p.person_fname,p.person_lname,"
				+ " p.person_gender as gender,p.person_official_id as id ,p.person_official_id_type as id_type"
				+ " ,p.person_dob as dob,p.person_mobile as mobile,p.person_email as email,COALESCE(p.person_telephone,'0')" +
				"as telephone_number,p.location_id"
				+ " from person p inner join personrole pr on p.person_id=pr.person_id"
				+ " where (pr.role_id=1 and p.person_official_id=?))"
				+ " select person_details.*,l.location_line_1,l.location_line_2,l.city,COALESCE(l.state,'0') as state"
				+ " ,l.country,l.zipcode from person_details inner join location l on person_details.location_id=l.location_id;";

		List<BookingBean> bookPersonDetails = new ArrayList<BookingBean>();

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(query);) {

			preparedStatement.setString(1, personId);

			try (ResultSet resultSet = preparedStatement.executeQuery();) {

				if (resultSet.next()) {
					do {
						BookingBean bookingBean = new BookingBean();
						PersonBean personBean = new PersonBean();
						LocationBean locationBean = new LocationBean();

						personBean.setPerson_fname(resultSet.getString(1));
						personBean.setPerson_lname(resultSet.getString(2));
						personBean.setPerson_gender(resultSet.getString(3));
						personBean
								.setPerson_official_id(resultSet.getString(4));
						personBean.setPerosn_official_id_type(resultSet
								.getString(5));
						personBean.setPerson_dob(resultSet.getDate(6));
						personBean.setPerson_mobile(resultSet.getString(7));
						personBean.setPerson_email(resultSet.getString(8));
						personBean.setPerson_telephone(resultSet.getString(9));

						locationBean
								.setLocation_line_1(resultSet.getString(11));
						locationBean
								.setLocation_line_2(resultSet.getString(12));
						locationBean.setCity(resultSet.getString(13));
						locationBean.setState(resultSet.getString(14));
						locationBean.setCountry(resultSet.getString(15));
						locationBean.setZipcode(resultSet.getString(16));

						bookingBean.setPersonBean(personBean);
						bookingBean.setLocationBean(locationBean);

						bookPersonDetails.add(bookingBean);
					} while (resultSet.next());
				} else {
					throw new BooikngPersonNotFoundException(
							"Database does not have this person information!");
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

		return bookPersonDetails;
	}

	@SuppressWarnings("serial")
	public static class BooikngPersonNotFoundException extends Throwable {
		BooikngPersonNotFoundException(String message) {
			super(message);
		}
	}

	public boolean savePersonDetails(LocationBean locationBean,
			PersonBean personBean) throws SQLException{
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		//Connection connection = null;
		String query = "insert into location values(?, ?, ?, ?, ?, ?, DEFAULT) returning location_id";
		String query1 = "insert into person values(DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) returning person_id";
		String query2 = "insert into personrole values(?, ?)";
		
		boolean returnmsg = false;
		
		try (Connection connection = getConnection()){
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, locationBean.getLocation_line_1());
			preparedStatement.setString(2, locationBean.getLocation_line_2());
			preparedStatement.setString(3, locationBean.getCity());
			preparedStatement.setString(4, locationBean.getState());
			preparedStatement.setString(5, locationBean.getCountry());
			preparedStatement.setString(6, locationBean.getZipcode());
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			locationBean.setLocation_id(resultSet.getInt(1));
			personBean.setLocation_id(locationBean);
			
			//inserting into person table
			preparedStatement = connection.prepareStatement(query1);
			preparedStatement.setString(1, personBean.getPerson_fname());
			preparedStatement.setString(2, personBean.getPerson_lname());
			preparedStatement.setString(3, personBean.getPerson_gender());
			preparedStatement.setString(4, personBean.getPerson_official_id());
			preparedStatement.setString(5, personBean.getPerosn_official_id_type());
			java.util.Date person_dob = personBean.getPerson_dob();
			Date dob = new Date(person_dob.getTime());
			preparedStatement.setDate(6, dob);
			preparedStatement.setString(7, personBean.getPerson_mobile());
			preparedStatement.setString(8, personBean.getPerson_email());
			preparedStatement.setString(9, personBean.getPerson_telephone());
			preparedStatement.setInt(10, personBean.getLocation_id().getLocation_id());
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			personBean.setPerson_id(resultSet.getInt(1));
			
			//inserting into personrole table with role as customer
			preparedStatement = connection.prepareStatement(query2);
			preparedStatement.setInt(1, personBean.getPerson_id());
			preparedStatement.setInt(2, 1); //Role id for customer is 1
			preparedStatement.executeUpdate();
			
			connection.commit();
			returnmsg = true;
			
	}catch (SQLException e) {
		returnmsg = false;
		e.printStackTrace();
		throw e;
	}
	finally
		{
		resultSet.close();
		return returnmsg;
		}
}
	}