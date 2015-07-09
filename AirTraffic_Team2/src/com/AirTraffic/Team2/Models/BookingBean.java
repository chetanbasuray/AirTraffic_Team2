package com.AirTraffic.Team2.Models;

public class BookingBean {
	
	private FlightBean flightBean;
	private PersonBean personBean;
	private LocationBean locationBean;
	
	public LocationBean getLocationBean() {
		return locationBean;
	}
	public void setLocationBean(LocationBean locationBean) {
		this.locationBean = locationBean;
	}
	public FlightBean getFlightBean() {
		return flightBean;
	}
	public void setFlightBean(FlightBean flightBean) {
		this.flightBean = flightBean;
	}
	public PersonBean getPersonBean() {
		return personBean;
	}
	public void setPersonBean(PersonBean personBean) {
		this.personBean = personBean;
	}
	
	
	
   }

