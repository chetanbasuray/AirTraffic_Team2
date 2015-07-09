package com.AirTraffic.Team2.Models;

import java.util.List;

/**
 * @author Chetan
 *
 */
public class AirlineBean {

	private String airline_id;
	private String airline_name;
	private String airline_type;
	private List<AirportBean> airportList;
	private LocationBean locationBean;
	
	
	/**
	 * @return the airline_iata
	 */
	public String getAirline_id() {
		return airline_id;
	}
	/**
	 * @param airline_iata the airline_iata to set
	 */
	public void setAirline_id(String airline_id) {
		this.airline_id = airline_id;
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
	 * @return the airline_name
	 */
	public String getAirline_name() {
		return airline_name;
	}
	/**
	 * @param airline_name the airline_name to set
	 */
	public void setAirline_name(String airline_name) {
		this.airline_name = airline_name;
	}
	/**
	 * @return the airline_type
	 */
	public String getAirline_type() {
		return airline_type;
	}
	/**
	 * @param airline_type the airline_type to set
	 */
	public void setAirline_type(String airline_type) {
		this.airline_type = airline_type;
	}
	/**
	 * @return the airportList
	 */
	public List<AirportBean> getAirportList() {
		return airportList;
	}
	/**
	 * @param airportList the airportList to set
	 */
	public void setAirportList(List<AirportBean> airportList) {
		this.airportList = airportList;
	}
}
