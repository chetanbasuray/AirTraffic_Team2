package com.AirTraffic.Team2.Models;

/**
 * @author Chetan
 *
 */
public class LocationBean {
	
	private int location_id;
	private String location_line_1;
	private String location_line_2;
	private String city;
	private String state;
	private String country;
	private String zipcode;  
	
	public int getLocation_id() {
		return location_id;
	}
	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}
	public String getLocation_line_1() {
		return location_line_1;
	}
	public void setLocation_line_1(String location_line_1) {
		this.location_line_1 = location_line_1;
	}
	public String getLocation_line_2() {
		return location_line_2;
	}
	public void setLocation_line_2(String location_line_2) {
		this.location_line_2 = location_line_2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	
}
