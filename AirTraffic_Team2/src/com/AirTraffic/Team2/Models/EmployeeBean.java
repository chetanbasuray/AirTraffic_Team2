/**
 * 
 */
package com.AirTraffic.Team2.Models;

/**
 * @author JOY
 *
 */
public class EmployeeBean {
private PersonBean personBean;
private String employee_bankAccountNumber;
private String employee_division;
private double employee_salary;
private AirportBean airportBean;
/**
 * @return the personBean
 */
public PersonBean getPersonBean() {
	return personBean;
}
/**
 * @param personBean the personBean to set
 */
public void setPersonBean(PersonBean personBean) {
	this.personBean = personBean;
}
/**
 * @return the employee_bankAccountNumber
 */
public String getEmployee_bankAccountNumber() {
	return employee_bankAccountNumber;
}
/**
 * @param employee_bankAccountNumber the employee_bankAccountNumber to set
 */
public void setEmployee_bankAccountNumber(String employee_bankAccountNumber) {
	this.employee_bankAccountNumber = employee_bankAccountNumber;
}
/**
 * @return the employee_division
 */
public String getEmployee_division() {
	return employee_division;
}
/**
 * @param employee_division the employee_division to set
 */
public void setEmployee_division(String employee_division) {
	this.employee_division = employee_division;
}
/**
 * @return the employee_salary
 */
public double getEmployee_salary() {
	return employee_salary;
}
/**
 * @param employee_salary the employee_salary to set
 */
public void setEmployee_salary(double employee_salary) {
	this.employee_salary = employee_salary;
}
/**
 * @return the airportBean
 */
public AirportBean getAirportBean() {
	return airportBean;
}
/**
 * @param airportBean the airportBean to set
 */
public void setAirportBean(AirportBean airportBean) {
	this.airportBean = airportBean;
}
}