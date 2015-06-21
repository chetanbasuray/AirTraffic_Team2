/**
 * 
 */
package com.AirTraffic.Team2.Models;

import java.util.Date;

/**
 * @author Chetan
 *
 */
public class BoardingPassBean {
private int boardingPass_id;
private Date boarding_Time;
private PersonBean checkInPerson;
private PersonBean passenger;
private LuggageBean luggageBean;
private TicketBean ticketBean;
private FlightBean flightBean;
private GateBean gateBean;
private TerminalBean terminalBean;
/**
 * @return the passenger
 */
public PersonBean getPassenger() {
  return passenger;
}
/**
 * @param passenger the passenger to set
 */
public void setPassenger(PersonBean passenger) {
  this.passenger = passenger;
}
/**
 * @return the boardingPass_id
 */
public int getBoardingPass_id() {
	return boardingPass_id;
}
/**
 * @param boardingPass_id the boardingPass_id to set
 */
public void setBoardingPass_id(int boardingPass_id) {
	this.boardingPass_id = boardingPass_id;
}
/**
 * @return the boarding_Time
 */
public Date getBoarding_Time() {
	return boarding_Time;
}
/**
 * @param boarding_Time the boarding_Time to set
 */
public void setBoarding_Time(Date boarding_Time) {
	this.boarding_Time = boarding_Time;
}
/**
 * @return the checkInPerson
 */
public PersonBean getCheckInPerson() {
	return checkInPerson;
}
/**
 * @param checkInPerson the checkInPerson to set
 */
public void setCheckInPerson(PersonBean checkInPerson) {
	this.checkInPerson = checkInPerson;
}
/**
 * @return the luggageBean
 */
public LuggageBean getLuggageBean() {
	return luggageBean;
}
/**
 * @param luggageBean the luggageBean to set
 */
public void setLuggageBean(LuggageBean luggageBean) {
	this.luggageBean = luggageBean;
}
/**
 * @return the ticketBean
 */
public TicketBean getTicketBean() {
	return ticketBean;
}
/**
 * @param ticketBean the ticketBean to set
 */
public void setTicketBean(TicketBean ticketBean) {
	this.ticketBean = ticketBean;
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
 * @return the gateBean
 */
public GateBean getGateBean() {
	return gateBean;
}
/**
 * @param gateBean the gateBean to set
 */
public void setGateBean(GateBean gateBean) {
	this.gateBean = gateBean;
}
/**
 * @return the terminalBean
 */
public TerminalBean getTerminalBean() {
	return terminalBean;
}
/**
 * @param terminalBean the terminalBean to set
 */
public void setTerminalBean(TerminalBean terminalBean) {
	this.terminalBean = terminalBean;
}
}
