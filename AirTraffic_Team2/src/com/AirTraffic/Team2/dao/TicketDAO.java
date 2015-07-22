package com.AirTraffic.Team2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
        "Select tpf.seatnumber, tpf.seat_class, f.flight_id, "
            + "fs.origin, fs.destination, tpf.ticket_journeydate,"
            + " f.flight_scheduleddeparturetime, f.flight_scheduledarrivaltime from"
            + " ticketpassengerflight tpf, flight f, flightsegment fs " + "where tpf.ticket_id=?"
            + " and f.flight_id=tpf.flight_id and f.flightsegment_id=fs.flightsegment_id";


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
              flight.setFlight_date(resultSet2.getDate("ticket_journeydate"));
              flight.setFlight_scheduled_arrival_time(resultSet2
                  .getTime("flight_scheduledarrivaltime"));
              flight.setFlight_scheduled_departure_time(resultSet2
                  .getTime("flight_scheduleddeparturetime"));
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

  public String generateTicket(String flightId, int personId, int currency, int paymentMethod,
      double flightPrice, Date journeyDate, String seatClass) throws Exception {
    
    String insertTicket =
        "INSERT into ticket values ((Select max(ticket_id)+1 from ticket),?,current_date,?,?,3,?,?,NULL,NULL,NULL) RETURNING ticket_id";
    String insertTicketPassFlight = "INSERT into ticketpassengerflight values (?,?,?,?,?,?)";
    int randomNum = 100 + (int) (Math.random() * 999);
    String pnr = "TICK" + randomNum;
    try (Connection connection = getConnection()) {
      //connection.setAutoCommit(false);
      PreparedStatement generateTicket = connection.prepareStatement(insertTicket);
      generateTicket.setDouble(1, flightPrice);
      generateTicket.setString(2, pnr);
      generateTicket.setInt(3, paymentMethod);
      generateTicket.setInt(4, currency);
      generateTicket.setInt(5, personId);
      try (ResultSet resultSet = generateTicket.executeQuery()) {
        if (resultSet.next()) {
          String checkSeats =
              "select s.seatversion_"+seatClass+"class_seats-(Select count(seatnumber)"
                  + " from ticketpassengerflight where seat_class=? and flight_id=?)"
                  + " as availableSeats from flight f, airplane a, airplanebecomesflight abf,"
                  + " seatversion s where f.flight_id=? and f.flight_id=abf.flight_id and"
                  + " a.airplane_id=abf.airplane_id and a.seatversion_id=s.seatversion_id;";
          PreparedStatement getSeatNumber = connection.prepareStatement(checkSeats);
          String temp =seatClass.substring(0, 1).toUpperCase();
          seatClass = temp+seatClass.substring(1);
          getSeatNumber.setString(1, seatClass);
          getSeatNumber.setString(2, flightId);
          getSeatNumber.setString(3, flightId);
          try (ResultSet resultSet1 = getSeatNumber.executeQuery()) {
            if (resultSet1.next()) {
              String seatNumber = resultSet1.getString(1);
              int ticketId = resultSet.getInt(1);
              PreparedStatement insertPassengerFlightInfo =
                  connection.prepareStatement(insertTicketPassFlight);
              insertPassengerFlightInfo.setInt(1, ticketId);
              insertPassengerFlightInfo.setInt(2, personId);
              insertPassengerFlightInfo.setString(3, flightId);
              insertPassengerFlightInfo.setString(4, seatNumber);
              
              insertPassengerFlightInfo.setString(5, seatClass);
              insertPassengerFlightInfo.setDate(6, new java.sql.Date(journeyDate.getTime()));
              if (insertPassengerFlightInfo.executeUpdate() != 0) {
                //connection.commit();
                return pnr;
              } else {
                //connection.rollback();
                throw new Exception("Sorry, couldn't generate Ticket");
              }
            } else {
              //connection.rollback();
              throw new Exception("Seats not available");
            }
          } catch (SQLException e) {
            //connection.rollback();
            e.printStackTrace();
            throw e;
          }
        }
      } catch (SQLException e) {
        //connection.rollback();
        e.printStackTrace();
        throw e;
      }
      //connection.rollback();
      throw new Exception("Sorry, couldn't generate Ticket");
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    }
  }
}
