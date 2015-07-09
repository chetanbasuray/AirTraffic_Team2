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
public class CrewBean {
private int crew_Id;
private Date crew_start_working_time;
private Date crew_end_working_time;
private List<EmployeeBean> employeeBeanList;
/**
 * @return the crew_Id
 */
public int getCrew_Id() {
	return crew_Id;
}
/**
 * @param crew_Id the crew_Id to set
 */
public void setCrew_Id(int crew_Id) {
	this.crew_Id = crew_Id;
}
/**
 * @return the crew_start_working_time
 */
public Date getCrew_start_working_time() {
	return crew_start_working_time;
}
/**
 * @param crew_start_working_time the crew_start_working_time to set
 */
public void setCrew_start_working_time(Date crew_start_working_time) {
	this.crew_start_working_time = crew_start_working_time;
}
/**
 * @return the crew_end_working_time
 */
public Date getCrew_end_working_time() {
	return crew_end_working_time;
}
/**
 * @param crew_end_working_time the crew_end_working_time to set
 */
public void setCrew_end_working_time(Date crew_end_working_time) {
	this.crew_end_working_time = crew_end_working_time;
}
/**
 * @return the employeeBeanList
 */
public List<EmployeeBean> getEmployeeBeanList() {
	return employeeBeanList;
}
/**
 * @param employeeBeanList the employeeBeanList to set
 */
public void setEmployeeBeanList(List<EmployeeBean> employeeBeanList) {
	this.employeeBeanList = employeeBeanList;
}
}
