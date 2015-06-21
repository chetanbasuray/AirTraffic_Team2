/**
 * 
 */
package com.AirTraffic.Team2.Models;

import java.util.List;

/**
 * @author Chetan
 *
 */
public class AirportBean {
private String airport_iata;
private String airport_name;
private String airport_icao;
private String airport_type;
private LocationBean locationBean;
private List<AirlineBean> airlineList;
private List<CateringBean> cateringList;
/**
 * @return the airport_iata
 */
public String getAirport_iata() {
	return airport_iata;
}
/**
 * @param airport_iata the airport_iata to set
 */
public void setAirport_iata(String airport_iata) {
	this.airport_iata = airport_iata;
}
/**
 * @return the airport_name
 */
public String getAirport_name() {
	return airport_name;
}
/**
 * @param airport_name the airport_name to set
 */
public void setAirport_name(String airport_name) {
	this.airport_name = airport_name;
}
/**
 * @return the airport_icao
 */
public String getAirport_icao() {
	return airport_icao;
}
/**
 * @param airport_icao the airport_icao to set
 */
public void setAirport_icao(String airport_icao) {
	this.airport_icao = airport_icao;
}
/**
 * @return the airport_type
 */
public String getAirport_type() {
	return airport_type;
}
/**
 * @param airport_type the airport_type to set
 */
public void setAirport_type(String airport_type) {
	this.airport_type = airport_type;
}
/**
 * @return the locationBean
 */
public LocationBean getLocationBean() {
	return locationBean;
}
/**
 * @param locationBean the locationBean to set
 */
public void setLocationBean(LocationBean locationBean) {
	this.locationBean = locationBean;
}
/**
 * @return the airlineList
 */
public List<AirlineBean> getAirlineList() {
	return airlineList;
}
/**
 * @param airlineList the airlineList to set
 */
public void setAirlineList(List<AirlineBean> airlineList) {
	this.airlineList = airlineList;
}
/**
 * @return the cateringList
 */
public List<CateringBean> getCateringList() {
	return cateringList;
}
/**
 * @param cateringList the cateringList to set
 */
public void setCateringList(List<CateringBean> cateringList) {
	this.cateringList = cateringList;
}
}