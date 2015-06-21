/**
 * 
 */
package com.AirTraffic.Team2.Models;

import java.util.Date;

/**
 * @author Chetan
 *
 */
public class FlightLogBean {
private int flightlog_id;
private Date flightlog_date;
private FlightBean flightBean;
private RunwayBean runwayBean;
private Date flightlog_scheduleddeparturetime;
private Date flightlog_scheduledarrivaltime;
private Date flightlog_actualdeparturetime;
private Date flightlog_actualdarrivaltime;
private EmployeeBean employeeBean;
/**
 * @return the flightlog_id
 */
public int getFlightlog_id() {
	return flightlog_id;
}
/**
 * @param flightlog_id the flightlog_id to set
 */
public void setFlightlog_id(int flightlog_id) {
	this.flightlog_id = flightlog_id;
}
/**
 * @return the flightlog_date
 */
public Date getFlightlog_date() {
	return flightlog_date;
}
/**
 * @param flightlog_date the flightlog_date to set
 */
public void setFlightlog_date(Date flightlog_date) {
	this.flightlog_date = flightlog_date;
}
/**
 * @return the flightBean
 */
public FlightBean getFlightBean() {
	return flightBean;
}
/**
 * @param flightBean the flightBean to set
 */
public void setFlightBean(FlightBean flightBean) {
	this.flightBean = flightBean;
}
/**
 * @return the runwayBean
 */
public RunwayBean getRunwayBean() {
	return runwayBean;
}
/**
 * @param runwayBean the runwayBean to set
 */
public void setRunwayBean(RunwayBean runwayBean) {
	this.runwayBean = runwayBean;
}
/**
 * @return the flightlog_scheduleddeparturetime
 */
public Date getFlightlog_scheduleddeparturetime() {
	return flightlog_scheduleddeparturetime;
}
/**
 * @param flightlog_scheduleddeparturetime the flightlog_scheduleddeparturetime to set
 */
public void setFlightlog_scheduleddeparturetime(
		Date flightlog_scheduleddeparturetime) {
	this.flightlog_scheduleddeparturetime = flightlog_scheduleddeparturetime;
}
/**
 * @return the flightlog_scheduledarrivaltime
 */
public Date getFlightlog_scheduledarrivaltime() {
	return flightlog_scheduledarrivaltime;
}
/**
 * @param flightlog_scheduledarrivaltime the flightlog_scheduledarrivaltime to set
 */
public void setFlightlog_scheduledarrivaltime(
		Date flightlog_scheduledarrivaltime) {
	this.flightlog_scheduledarrivaltime = flightlog_scheduledarrivaltime;
}
/**
 * @return the flightlog_actualdeparturetime
 */
public Date getFlightlog_actualdeparturetime() {
	return flightlog_actualdeparturetime;
}
/**
 * @param flightlog_actualdeparturetime the flightlog_actualdeparturetime to set
 */
public void setFlightlog_actualdeparturetime(Date flightlog_actualdeparturetime) {
	this.flightlog_actualdeparturetime = flightlog_actualdeparturetime;
}
/**
 * @return the flightlog_actualdarrivaltime
 */
public Date getFlightlog_actualdarrivaltime() {
	return flightlog_actualdarrivaltime;
}
/**
 * @param flightlog_actualdarrivaltime the flightlog_actualdarrivaltime to set
 */
public void setFlightlog_actualdarrivaltime(Date flightlog_actualdarrivaltime) {
	this.flightlog_actualdarrivaltime = flightlog_actualdarrivaltime;
}
/**
 * @return the employeeBean
 */
public EmployeeBean getEmployeeBean() {
	return employeeBean;
}
/**
 * @param employeeBean the employeeBean to set
 */
public void setEmployeeBean(EmployeeBean employeeBean) {
	this.employeeBean = employeeBean;
}
}
