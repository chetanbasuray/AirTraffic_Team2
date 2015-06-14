/**
 * 
 */
package com.AirTraffic.Team2.Models;

/**
 * @author JOY
 *
 */
public class FlightSegmentBean {
private int flightsegment_id;
private double flightsegment_numberofmiles;
private AirportBean originAirport;
private AirportBean destinationAirport;
/**
 * @return the flightsegment_id
 */
public int getFlightsegment_id() {
	return flightsegment_id;
}
/**
 * @param flightsegment_id the flightsegment_id to set
 */
public void setFlightsegment_id(int flightsegment_id) {
	this.flightsegment_id = flightsegment_id;
}
/**
 * @return the flightsegment_numberofmiles
 */
public double getFlightsegment_numberofmiles() {
	return flightsegment_numberofmiles;
}
/**
 * @param flightsegment_numberofmiles the flightsegment_numberofmiles to set
 */
public void setFlightsegment_numberofmiles(double flightsegment_numberofmiles) {
	this.flightsegment_numberofmiles = flightsegment_numberofmiles;
}
/**
 * @return the originAirport
 */
public AirportBean getOriginAirport() {
	return originAirport;
}
/**
 * @param originAirport the originAirport to set
 */
public void setOriginAirport(AirportBean originAirport) {
	this.originAirport = originAirport;
}
/**
 * @return the destinationAirport
 */
public AirportBean getDestinationAirport() {
	return destinationAirport;
}
/**
 * @param destinationAirport the destinationAirport to set
 */
public void setDestinationAirport(AirportBean destinationAirport) {
	this.destinationAirport = destinationAirport;
}
}
