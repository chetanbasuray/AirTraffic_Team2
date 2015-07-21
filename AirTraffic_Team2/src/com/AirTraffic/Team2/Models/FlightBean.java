package com.AirTraffic.Team2.Models;

import java.sql.Timestamp;
import java.sql.Time;
import java.util.Date;
import java.util.List;

/**
 * @author Chetan
 *
 */
public class FlightBean {
private String flight_Id;
private Time flight_scheduled_departure_time;
private Time flight_scheduled_arrival_time;
private Date flight_date;
/**
 * @return the flight_date
 */
public Date getFlight_date() {
  return flight_date;
}
/**
 * @param flight_date the flight_date to set
 */
public void setFlight_date(Date flight_date) {
  this.flight_date = flight_date;
}
private Timestamp flight_scheduled_departure_timestamp;
private Timestamp flight_scheduled_arrival_timestamp;
private int flight_first_class_cabin_luggage_limit;
private String seatNumber;
private String seatClass;

/**
 * @return the seatNumber
 */
public String getSeatNumber() {
  return seatNumber;
}
/**
 * @param seatNumber the seatNumber to set
 */
public void setSeatNumber(String seatNumber) {
  this.seatNumber = seatNumber;
}
/**
 * @return the seatClass
 */
public String getSeatClass() {
  return seatClass;
}
/**
 * @param seatClass the seatClass to set
 */
public void setSeatClass(String seatClass) {
  this.seatClass = seatClass;
}

private double flight_first_class_price;
private double flight_business_class_price;
private double flight_economy_class_price;
private int flight_business_class_cabin_luggage_limit;
private int flight_economy_class_cabin_luggage_limit;
private int flight_first_class_checkin_luggage_limit;
private int flight_business_class_checkin_luggage_limit;
private int flight_economy_class_checkin_luggage_limit;
private FlightSegmentBean flightSegmentBean;
private List<String> flightDaysList;
private List<AirplaneBean> airplaneBeanList;
private GateBean gateBean;
private List<CateringBean> cateringBeanList;
private String departureDay;
private String departureDate;
private String arrivalDay;
private String arrivalDate;


public Timestamp getFlight_scheduled_departure_timestamp() {
	return flight_scheduled_departure_timestamp;
}
public void setFlight_scheduled_departure_timestamp(
		Timestamp flight_scheduled_departure_timestamp) {
	this.flight_scheduled_departure_timestamp = flight_scheduled_departure_timestamp;
}
public Timestamp getFlight_scheduled_arrival_timestamp() {
	return flight_scheduled_arrival_timestamp;
}
public void setFlight_scheduled_arrival_timestamp(
		Timestamp flight_scheduled_arrival_timestamp) {
	this.flight_scheduled_arrival_timestamp = flight_scheduled_arrival_timestamp;
}

public String getArrivalDate() {
	return arrivalDate;
}
public void setArrivalDate(String arrivalDate) {
	this.arrivalDate = arrivalDate;
}
public String getDepartureDate() {
	return departureDate;
}
public void setDepartureDate(String departureDate) {
	this.departureDate = departureDate;
}
public String getArrivalDay() {
	return arrivalDay;
}
public void setArrivalDay(String arrivalDay) {
	this.arrivalDay = arrivalDay;
}
public String getDepartureDay() {
	return departureDay;
}
public void setDepartureDay(String departureDay) {
	this.departureDay = departureDay;
}
/**
 * @return the flight_first_class_price
 */
public double getFlight_first_class_price() {
  return flight_first_class_price;
}
/**
 * @param flight_first_class_price the flight_first_class_price to set
 */
public void setFlight_first_class_price(double flight_first_class_price) {
  this.flight_first_class_price = flight_first_class_price;
}
/**
 * @return the flight_business_class_price
 */
public double getFlight_business_class_price() {
  return flight_business_class_price;
}
/**
 * @param flight_business_class_price the flight_business_class_price to set
 */
public void setFlight_business_class_price(double flight_business_class_price) {
  this.flight_business_class_price = flight_business_class_price;
}
/**
 * @return the flight_economy_class_price
 */
public double getFlight_economy_class_price() {
  return flight_economy_class_price;
}
/**
 * @param flight_economy_class_price the flight_economy_class_price to set
 */
public void setFlight_economy_class_price(double flight_economy_class_price) {
  this.flight_economy_class_price = flight_economy_class_price;
}
/**
 * @return the cateringBeanList
 */
public List<CateringBean> getCateringBeanList() {
	return cateringBeanList;
}
/**
 * @param cateringBeanList the cateringBeanList to set
 */
public void setCateringBeanList(List<CateringBean> cateringBeanList) {
	this.cateringBeanList = cateringBeanList;
}
/**
 * @return the gateBeanList
 */
public GateBean getGateBean() {
	return gateBean;
}
/**
 * @param gateBeanList the gateBeanList to set
 */
public void setGateBean(GateBean gateBean) {
	this.gateBean = gateBean;
}
/**
 * @return the flight_Id
 */
public String getFlight_Id() {
	return flight_Id;
}
/**
 * @param flight_Id the flight_Id to set
 */
public void setFlight_Id(String flight_Id) {
	this.flight_Id = flight_Id;
}
/**
 * @return the flight_scheduled_departure_time
 */
public Time getFlight_scheduled_departure_time() {
	return flight_scheduled_departure_time;
}
/**
 * @param flight_scheduled_departure_time the flight_scheduled_departure_time to set
 */
public void setFlight_scheduled_departure_time(
		Time flight_scheduled_departure_time) {
	this.flight_scheduled_departure_time = flight_scheduled_departure_time;
}
/**
 * @return the flight_scheduled_arrival_time
 */
public Time getFlight_scheduled_arrival_time() {
	return flight_scheduled_arrival_time;
}
/**
 * @param flight_scheduled_arrival_time the flight_scheduled_arrival_time to set
 */
public void setFlight_scheduled_arrival_time(Time flight_scheduled_arrival_time) {
	this.flight_scheduled_arrival_time = flight_scheduled_arrival_time;
}
/**
 * @return the flight_first_class_cabin_luggage_limit
 */
public int getFlight_first_class_cabin_luggage_limit() {
	return flight_first_class_cabin_luggage_limit;
}
/**
 * @param flight_first_class_cabin_luggage_limit the flight_first_class_cabin_luggage_limit to set
 */
public void setFlight_first_class_cabin_luggage_limit(
		int flight_first_class_cabin_luggage_limit) {
	this.flight_first_class_cabin_luggage_limit = flight_first_class_cabin_luggage_limit;
}
/**
 * @return the flight_business_class_cabin_luggage_limit
 */
public int getFlight_business_class_cabin_luggage_limit() {
	return flight_business_class_cabin_luggage_limit;
}
/**
 * @param flight_business_class_cabin_luggage_limit the flight_business_class_cabin_luggage_limit to set
 */
public void setFlight_business_class_cabin_luggage_limit(
		int flight_business_class_cabin_luggage_limit) {
	this.flight_business_class_cabin_luggage_limit = flight_business_class_cabin_luggage_limit;
}
/**
 * @return the flight_economy_class_cabin_luggage_limit
 */
public int getFlight_economy_class_cabin_luggage_limit() {
	return flight_economy_class_cabin_luggage_limit;
}
/**
 * @param flight_economy_class_cabin_luggage_limit the flight_economy_class_cabin_luggage_limit to set
 */
public void setFlight_economy_class_cabin_luggage_limit(
		int flight_economy_class_cabin_luggage_limit) {
	this.flight_economy_class_cabin_luggage_limit = flight_economy_class_cabin_luggage_limit;
}
/**
 * @return the flight_first_class_checkin_luggage_limit
 */
public int getFlight_first_class_checkin_luggage_limit() {
	return flight_first_class_checkin_luggage_limit;
}
/**
 * @param flight_first_class_checkin_luggage_limit the flight_first_class_checkin_luggage_limit to set
 */
public void setFlight_first_class_checkin_luggage_limit(
		int flight_first_class_checkin_luggage_limit) {
	this.flight_first_class_checkin_luggage_limit = flight_first_class_checkin_luggage_limit;
}
/**
 * @return the flight_business_class_checkin_luggage_limit
 */
public int getFlight_business_class_checkin_luggage_limit() {
	return flight_business_class_checkin_luggage_limit;
}
/**
 * @param flight_business_class_checkin_luggage_limit the flight_business_class_checkin_luggage_limit to set
 */
public void setFlight_business_class_checkin_luggage_limit(
		int flight_business_class_checkin_luggage_limit) {
	this.flight_business_class_checkin_luggage_limit = flight_business_class_checkin_luggage_limit;
}
/**
 * @return the flight_economy_class_checkin_luggage_limit
 */
public int getFlight_economy_class_checkin_luggage_limit() {
	return flight_economy_class_checkin_luggage_limit;
}
/**
 * @param flight_economy_class_checkin_luggage_limit the flight_economy_class_checkin_luggage_limit to set
 */
public void setFlight_economy_class_checkin_luggage_limit(
		int flight_economy_class_checkin_luggage_limit) {
	this.flight_economy_class_checkin_luggage_limit = flight_economy_class_checkin_luggage_limit;
}
/**
 * @return the flightSegmentBean
 */
public FlightSegmentBean getFlightSegmentBean() {
	return flightSegmentBean;
}
/**
 * @param flightSegmentBean the flightSegmentBean to set
 */
public void setFlightSegmentBean(FlightSegmentBean flightSegmentBean) {
	this.flightSegmentBean = flightSegmentBean;
}
/**
 * @return the flightDaysList
 */
public List<String> getFlightDaysList() {
	return flightDaysList;
}
/**
 * @param flightDaysList the flightDaysList to set
 */
public void setFlightDaysList(List<String> flightDaysList) {
	this.flightDaysList = flightDaysList;
}
/**
 * @return the airplaneBeanList
 */
public List<AirplaneBean> getAirplaneBeanList() {
	return airplaneBeanList;
}
/**
 * @param airplaneBeanList the airplaneBeanList to set
 */
public void setAirplaneBeanList(List<AirplaneBean> airplaneBeanList) {
	this.airplaneBeanList = airplaneBeanList;
}
}
