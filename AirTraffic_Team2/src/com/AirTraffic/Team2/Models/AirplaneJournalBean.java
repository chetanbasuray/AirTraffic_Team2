/**
 * 
 */
package com.AirTraffic.Team2.Models;

import java.util.Date;

/**
 * @author JOY
 *
 */
public class AirplaneJournalBean {
private AirplaneBean airplaneBean;
private FlightBean flightBean;
private CrewBean crewBean;
private Date airplaneJournal_journeyStartDate;
private int airplaneJournal_totalJourneyDuration;
private MaintenanceTeamBean maintenanceTeamBean;
private String airplaneJournal_maintenanceTeamRemarks;
/**
 * @return the airplaneBean
 */
public AirplaneBean getAirplaneBean() {
	return airplaneBean;
}
/**
 * @param airplaneBean the airplaneBean to set
 */
public void setAirplaneBean(AirplaneBean airplaneBean) {
	this.airplaneBean = airplaneBean;
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
 * @return the crewBean
 */
public CrewBean getCrewBean() {
	return crewBean;
}
/**
 * @param crewBean the crewBean to set
 */
public void setCrewBean(CrewBean crewBean) {
	this.crewBean = crewBean;
}
/**
 * @return the airplaneJournal_journeyStartDate
 */
public Date getAirplaneJournal_journeyStartDate() {
	return airplaneJournal_journeyStartDate;
}
/**
 * @param airplaneJournal_journeyStartDate the airplaneJournal_journeyStartDate to set
 */
public void setAirplaneJournal_journeyStartDate(
		Date airplaneJournal_journeyStartDate) {
	this.airplaneJournal_journeyStartDate = airplaneJournal_journeyStartDate;
}
/**
 * @return the airplaneJournal_totalJourneyDuration
 */
public int getAirplaneJournal_totalJourneyDuration() {
	return airplaneJournal_totalJourneyDuration;
}
/**
 * @param airplaneJournal_totalJourneyDuration the airplaneJournal_totalJourneyDuration to set
 */
public void setAirplaneJournal_totalJourneyDuration(
		int airplaneJournal_totalJourneyDuration) {
	this.airplaneJournal_totalJourneyDuration = airplaneJournal_totalJourneyDuration;
}
/**
 * @return the maintenanceTeamBean
 */
public MaintenanceTeamBean getMaintenanceTeamBean() {
	return maintenanceTeamBean;
}
/**
 * @param maintenanceTeamBean the maintenanceTeamBean to set
 */
public void setMaintenanceTeamBean(MaintenanceTeamBean maintenanceTeamBean) {
	this.maintenanceTeamBean = maintenanceTeamBean;
}
/**
 * @return the airplaneJournal_maintenanceTeamRemarks
 */
public String getAirplaneJournal_maintenanceTeamRemarks() {
	return airplaneJournal_maintenanceTeamRemarks;
}
/**
 * @param airplaneJournal_maintenanceTeamRemarks the airplaneJournal_maintenanceTeamRemarks to set
 */
public void setAirplaneJournal_maintenanceTeamRemarks(
		String airplaneJournal_maintenanceTeamRemarks) {
	this.airplaneJournal_maintenanceTeamRemarks = airplaneJournal_maintenanceTeamRemarks;
}
}