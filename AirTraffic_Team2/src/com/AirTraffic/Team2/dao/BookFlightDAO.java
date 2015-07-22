package com.AirTraffic.Team2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.AirTraffic.Team2.Models.*;


public class BookFlightDAO extends AbstractDAO {

  public List<BookingBean> getPersonDetails(String personId) throws BooikngPersonNotFoundException,
      SQLException, ParseException {


    String query =
        "with person_details as (select p.person_id, p.person_fname,p.person_lname,"
            + " p.person_gender as gender,p.person_official_id as id ,p.person_official_id_type as id_type"
            + " ,p.person_dob as dob,p.person_mobile as mobile,p.person_email as email,COALESCE(p.person_telephone,'0') as telephone_number,p.location_id"
            + " from person p inner join personrole pr on p.person_id=pr.person_id"
            + " where (pr.role_id=1 and p.person_official_id=?))"
            + " select person_details.*,l.location_line_1,l.location_line_2,l.city,COALESCE(l.state,'0') as state"
            + " ,l.country,l.zipcode from person_details inner join location l on person_details.location_id=l.location_id;";

    List<BookingBean> bookPersonDetails = new ArrayList<BookingBean>();



    try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);) {

      preparedStatement.setString(1, personId);


      try (ResultSet resultSet = preparedStatement.executeQuery();) {

        if (resultSet.next()) {
          do {

            BookingBean bookingBean = new BookingBean();
            PersonBean personBean = new PersonBean();
            LocationBean locationBean = new LocationBean();

            personBean.setPerson_id(resultSet.getInt(1));
            personBean.setPerson_fname(resultSet.getString(2));
            personBean.setPerson_lname(resultSet.getString(3));
            personBean.setPerson_gender(resultSet.getString(4));
            personBean.setPerson_official_id(resultSet.getString(5));
            personBean.setPerosn_official_id_type(resultSet.getString(6));
            personBean.setPerson_dob(resultSet.getDate(7));
            personBean.setPerson_mobile(resultSet.getString(8));
            personBean.setPerson_email(resultSet.getString(9));
            personBean.setPerson_telephone(resultSet.getString(10));

            locationBean.setLocation_line_1(resultSet.getString(12));
            locationBean.setLocation_line_2(resultSet.getString(13));
            locationBean.setCity(resultSet.getString(14));
            locationBean.setState(resultSet.getString(15));
            locationBean.setCountry(resultSet.getString(16));
            locationBean.setZipcode(resultSet.getString(17));

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

}
