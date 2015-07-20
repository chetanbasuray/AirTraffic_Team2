package com.AirTraffic.Team2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.AirTraffic.Team2.Models.AirportBean;
import com.AirTraffic.Team2.Models.FlightBean;
import com.AirTraffic.Team2.Models.FlightSegmentBean;
import com.AirTraffic.Team2.Models.PersonBean;
import com.AirTraffic.Team2.Models.TicketBean;

public class TicketDAO extends AbstractDAO {

  public TicketBean getTicket(String ticket_pnr, String lName) throws Exception {
    TicketBean ticket = new TicketBean();
    ticket.setTicket_pnr(ticket_pnr);

    String ticketInfoQuery =
        "Select t.ticket_id, t.ticket_pnr, t.ticket_price, t.ticket_bookingdate, pt.paymenttype, bs.bookingstatus, c.currency"
            + " from ticket t, currency c, bookingstatus bs, paymenttype pt"
            + " where t.ticket_pnr=? and t.ticket_paymenttype_id=pt.paymenttype_id and"
            + " t.ticket_bookingstatus_id=bs.bookingstatus_id and t.ticket_currency_id=c.currency_id";

    String passengersInfoQuery =
        "Select p.person_fname, p.person_lname, p.person_gender, p.person_official_id, "
            + "p.person_official_id_type, p.person_dob from ticketpassengerflight tpf, person p "
            + "where tpf.ticket_id=? and p.person_lname=? and p.person_id=tpf.passenger_id";

    String flightsInfoQuery =
        "Select tpf.seatnumber, tpf.seat_class, "
            + "f.flight_id, aj.airplanejournal_journeystartdate as scheduleddeparture, aj.airplanejournal_journeystartdate "
            + "+ (aj.airplanejournal_totaljourneyduration * interval '1 minute') as scheduledarrival, fs.origin, fs.destination"
            + " from ticketpassengerflight tpf, flight f, flightsegment fs , airplanejournal aj"
            + " where tpf.ticket_id=? "
            + "and f.flight_id=tpf.flight_id and f.flightsegment_id=fs.flightsegment_id and f.flight_id=aj.airplanejournal_flightid";


    try (Connection connection = getConnection();) {
      connection.setAutoCommit(false);
      PreparedStatement preparedStatement = connection.prepareStatement(ticketInfoQuery);
      preparedStatement.setString(1, ticket_pnr);
      try (ResultSet resultSet = preparedStatement.executeQuery();) {
        if (resultSet.next()) {
          ticket.setTicket_id(resultSet.getInt("ticket_id"));
          ticket.setTicket_price(resultSet.getDouble("ticket_price"));
          ticket.setTicket_booking_date(resultSet.getDate("ticket_bookingdate"));
          ticket.setBookingstatus(resultSet.getString("bookingstatus"));
          ticket.setCurrency(resultSet.getString("currency"));
          ticket.setPaymenttype(resultSet.getString("paymenttype"));

          PreparedStatement passengersInfo = connection.prepareStatement(passengersInfoQuery);
          passengersInfo.setInt(1, ticket.getTicket_id());
          passengersInfo.setString(2, lName);
          try (ResultSet resultSet1 = passengersInfo.executeQuery();) {
            List<PersonBean> passengers = new ArrayList<PersonBean>();
            while (resultSet1.next()) {
              PersonBean passenger = new PersonBean();
              passenger.setPerson_fname(resultSet1.getString("person_fname"));
              passenger.setPerson_lname(resultSet1.getString("person_lname"));
              passenger.setPerson_gender(resultSet1.getString("person_gender"));
              passenger.setPerson_dob(resultSet1.getDate("person_dob"));
              passenger.setPerson_official_id(resultSet1.getString("person_official_id"));
              passenger.setPerosn_official_id_type(resultSet1.getString("person_official_id_type"));
              passengers.add(passenger);
            }
            ticket.setPassangers(passengers);
            resultSet1.close();
          } catch (SQLException e) {
            e.printStackTrace();
            throw e;
          }

          PreparedStatement flightsInfo = connection.prepareStatement(flightsInfoQuery);
          flightsInfo.setInt(1, ticket.getTicket_id());
          try (ResultSet resultSet2 = flightsInfo.executeQuery();) {
            connection.commit();
            List<FlightBean> flights = new ArrayList<FlightBean>();
            while (resultSet2.next()) {
              FlightBean flight = new FlightBean();
              flight.setFlight_Id(resultSet2.getString("flight_id"));
              flight.setSeatNumber(resultSet2.getString("seatnumber"));
              flight.setSeatClass(resultSet2.getString("seat_class"));
              flight.setFlight_scheduled_arrival_timestamp(resultSet2
                  .getTimestamp("scheduledarrival"));
              flight.setFlight_scheduled_departure_timestamp(resultSet2
                  .getTimestamp("scheduleddeparture"));
              FlightSegmentBean flightSegment = new FlightSegmentBean();
              AirportBean originAirport = new AirportBean();
              originAirport.setAirport_iata(resultSet2.getString("origin"));
              AirportBean destinationAirport = new AirportBean();
              destinationAirport.setAirport_iata(resultSet2.getString("destination"));
              flightSegment.setOriginAirport(originAirport);
              flightSegment.setDestinationAirport(destinationAirport);
              flight.setFlightSegmentBean(flightSegment);
              flights.add(flight);
            }
            ticket.setFlights(flights);
            resultSet2.close();

          } catch (SQLException e) {
            e.printStackTrace();
            throw e;
          }
        } else {
          connection.rollback();
          connection.close();
          throw new Exception("Failed to find ticket.");
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
    return ticket;
  }
}
