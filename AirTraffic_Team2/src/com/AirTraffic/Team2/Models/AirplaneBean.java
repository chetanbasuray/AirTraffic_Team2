package com.AirTraffic.Team2.Models;

import java.util.Date;

public class AirplaneBean {

	private String airplane_id;
	private int airplane_range_of_tank;
	private String airplane_model;
	private String airplane_make;
	private String airplane_starting_seat_number;
	private String airplane_ending_seat_number;
	private String airplane_starting_seat_class;
	private String airplane_ending_seat_class;
	private AirlineBean airlineBean;
	private int seatversion_id;
	private int seatversion_first_class_seats;
	private int seatversion_business_class_seats;
	private int seatversion_economy_class_seats;
	private Date airplane_last_maintenance_date;
	/**
	 * @return the airplane_id
	 */
	public String getAirplane_id() {
		return airplane_id;
	}
	/**
	 * @param airplane_id the airplane_id to set
	 */
	public void setAirplane_id(String airplane_id) {
		this.airplane_id = airplane_id;
	}
	/**
	 * @return the airplane_range_of_tank
	 */
	public int getAirplane_range_of_tank() {
		return airplane_range_of_tank;
	}
	/**
	 * @param airplane_range_of_tank the airplane_range_of_tank to set
	 */
	public void setAirplane_range_of_tank(int airplane_range_of_tank) {
		this.airplane_range_of_tank = airplane_range_of_tank;
	}
	/**
	 * @return the airplane_model
	 */
	public String getAirplane_model() {
		return airplane_model;
	}
	/**
	 * @param airplane_model the airplane_model to set
	 */
	public void setAirplane_model(String airplane_model) {
		this.airplane_model = airplane_model;
	}
	/**
	 * @return the airplane_make
	 */
	public String getAirplane_make() {
		return airplane_make;
	}
	/**
	 * @param airplane_make the airplane_make to set
	 */
	public void setAirplane_make(String airplane_make) {
		this.airplane_make = airplane_make;
	}
	/**
	 * @return the airplane_starting_seat_number
	 */
	public String getAirplane_starting_seat_number() {
		return airplane_starting_seat_number;
	}
	/**
	 * @param airplane_starting_seat_number the airplane_starting_seat_number to set
	 */
	public void setAirplane_starting_seat_number(
			String airplane_starting_seat_number) {
		this.airplane_starting_seat_number = airplane_starting_seat_number;
	}
	/**
	 * @return the airplane_ending_seat_number
	 */
	public String getAirplane_ending_seat_number() {
		return airplane_ending_seat_number;
	}
	/**
	 * @param airplane_ending_seat_number the airplane_ending_seat_number to set
	 */
	public void setAirplane_ending_seat_number(String airplane_ending_seat_number) {
		this.airplane_ending_seat_number = airplane_ending_seat_number;
	}
	/**
	 * @return the airplane_starting_seat_class
	 */
	public String getAirplane_starting_seat_class() {
		return airplane_starting_seat_class;
	}
	/**
	 * @param airplane_starting_seat_class the airplane_starting_seat_class to set
	 */
	public void setAirplane_starting_seat_class(String airplane_starting_seat_class) {
		this.airplane_starting_seat_class = airplane_starting_seat_class;
	}
	/**
	 * @return the airplane_ending_seat_class
	 */
	public String getAirplane_ending_seat_class() {
		return airplane_ending_seat_class;
	}
	/**
	 * @param airplane_ending_seat_class the airplane_ending_seat_class to set
	 */
	public void setAirplane_ending_seat_class(String airplane_ending_seat_class) {
		this.airplane_ending_seat_class = airplane_ending_seat_class;
	}
	/**
	 * @return the airlineBean
	 */
	public AirlineBean getAirlineBean() {
		return airlineBean;
	}
	/**
	 * @param airlineBean the airlineBean to set
	 */
	public void setAirlineBean(AirlineBean airlineBean) {
		this.airlineBean = airlineBean;
	}
	/**
	 * @return the seatversion_id
	 */
	public int getSeatversion_id() {
		return seatversion_id;
	}
	/**
	 * @param seatversion_id the seatversion_id to set
	 */
	public void setSeatversion_id(int seatversion_id) {
		this.seatversion_id = seatversion_id;
	}
	/**
	 * @return the seatversion_first_class_seats
	 */
	public int getSeatversion_first_class_seats() {
		return seatversion_first_class_seats;
	}
	/**
	 * @param seatversion_first_class_seats the seatversion_first_class_seats to set
	 */
	public void setSeatversion_first_class_seats(int seatversion_first_class_seats) {
		this.seatversion_first_class_seats = seatversion_first_class_seats;
	}
	/**
	 * @return the seatversion_business_class_seats
	 */
	public int getSeatversion_business_class_seats() {
		return seatversion_business_class_seats;
	}
	/**
	 * @param seatversion_business_class_seats the seatversion_business_class_seats to set
	 */
	public void setSeatversion_business_class_seats(
			int seatversion_business_class_seats) {
		this.seatversion_business_class_seats = seatversion_business_class_seats;
	}
	/**
	 * @return the seatversion_economy_class_seats
	 */
	public int getSeatversion_economy_class_seats() {
		return seatversion_economy_class_seats;
	}
	/**
	 * @param seatversion_economy_class_seats the seatversion_economy_class_seats to set
	 */
	public void setSeatversion_economy_class_seats(
			int seatversion_economy_class_seats) {
		this.seatversion_economy_class_seats = seatversion_economy_class_seats;
	}
	/**
	 * @return the airplane_last_maintenance_date
	 */
	public Date getAirplane_last_maintenance_date() {
		return airplane_last_maintenance_date;
	}
	/**
	 * @param airplane_last_maintenance_date the airplane_last_maintenance_date to set
	 */
	public void setAirplane_last_maintenance_date(
			Date airplane_last_maintenance_date) {
		this.airplane_last_maintenance_date = airplane_last_maintenance_date;
	}
}
