/**
 * 
 */
package com.AirTraffic.Team2.Models;

import java.util.Date;
import java.util.List;

/**
 * @author Chetan
 *
 */
public class CateringBean {
private int catering_Id;
private String catering_type;
private double catering_price;
private String catering_drink;
private List<AirportBean> airportBeanList;
private List<FlightBean> flightBeanList;
private List<Integer> quantityList;
private List<Date> orderDateList;


/**
 * @return the flightBeanList
 */
public List<FlightBean> getFlightBeanList() {
	return flightBeanList;
}
/**
 * @param flightBeanList the flightBeanList to set
 */
public void setFlightBeanList(List<FlightBean> flightBeanList) {
	this.flightBeanList = flightBeanList;
}
/**
 * @return the quantityList
 */
public List<Integer> getQuantityList() {
	return quantityList;
}
/**
 * @param quantityList the quantityList to set
 */
public void setQuantityList(List<Integer> quantityList) {
	this.quantityList = quantityList;
}
/**
 * @return the orderDateList
 */
public List<Date> getOrderDateList() {
	return orderDateList;
}
/**
 * @param orderDateList the orderDateList to set
 */
public void setOrderDateList(List<Date> orderDateList) {
	this.orderDateList = orderDateList;
}
/**
 * @return the catering_Id
 */
public int getCatering_Id() {
	return catering_Id;
}
/**
 * @param catering_Id the catering_Id to set
 */
public void setCatering_Id(int catering_Id) {
	this.catering_Id = catering_Id;
}
/**
 * @return the catering_type
 */
public String getCatering_type() {
	return catering_type;
}
/**
 * @param catering_type the catering_type to set
 */
public void setCatering_type(String catering_type) {
	this.catering_type = catering_type;
}
/**
 * @return the catering_price
 */
public double getCatering_price() {
	return catering_price;
}
/**
 * @param catering_price the catering_price to set
 */
public void setCatering_price(double catering_price) {
	this.catering_price = catering_price;
}
/**
 * @return the catering_drink
 */
public String getCatering_drink() {
	return catering_drink;
}
/**
 * @param catering_drink the catering_drink to set
 */
public void setCatering_drink(String catering_drink) {
	this.catering_drink = catering_drink;
}
/**
 * @return the airportBeanList
 */
public List<AirportBean> getAirportBeanList() {
	return airportBeanList;
}
/**
 * @param airportBeanList the airportBeanList to set
 */
public void setAirportBeanList(List<AirportBean> airportBeanList) {
	this.airportBeanList = airportBeanList;
}
}
