/**
 * 
 */
package com.AirTraffic.Team2.Models;

import java.util.Date;

/**
 * @author JOY
 *
 */
public class FlightBean {
private String flight_Id;
private Date flight_scheduled_departure_time;
private Date flight_scheduled_arrival_time;
private int flight_first_class_cabin_luggage_limit;
private int flight_business_class_cabin_luggage_limit;
private int flight_economy_class_cabin_luggage_limit;
private int flight_first_class_checkin_luggage_limit;
private int flight_business_class_checkin_luggage_limit;
private int flight_economy_class_checkin_luggage_limit;
private FlightSegmentBean flightSegmentBean;
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
public Date getFlight_scheduled_departure_time() {
	return flight_scheduled_departure_time;
}
/**
 * @param flight_scheduled_departure_time the flight_scheduled_departure_time to set
 */
public void setFlight_scheduled_departure_time(
		Date flight_scheduled_departure_time) {
	this.flight_scheduled_departure_time = flight_scheduled_departure_time;
}
/**
 * @return the flight_scheduled_arrival_time
 */
public Date getFlight_scheduled_arrival_time() {
	return flight_scheduled_arrival_time;
}
/**
 * @param flight_scheduled_arrival_time the flight_scheduled_arrival_time to set
 */
public void setFlight_scheduled_arrival_time(Date flight_scheduled_arrival_time) {
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
}
