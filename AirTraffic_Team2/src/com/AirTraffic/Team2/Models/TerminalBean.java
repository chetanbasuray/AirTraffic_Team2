/**
 * 
 */
package com.AirTraffic.Team2.Models;

/**
 * @author Chetan
 *
 */
public class TerminalBean {
  private int terminal_id;
  private LocationBean terminal_location;
  private String terminal_type;
  private AirportBean airport_iata;
  private CounterBean counterBean;
  
  
  /**
 * @return the counterBean
 */
public CounterBean getCounterBean() {
	return counterBean;
}
/**
 * @param counterBean the counterBean to set
 */
public void setCounterBean(CounterBean counterBean) {
	this.counterBean = counterBean;
}
/**
   * @return the terminal_id
   */
  public int getTerminal_id() {
    return terminal_id;
  }
  /**
   * @param terminal_id the terminal_id to set
   */
  public void setTerminal_id(int terminal_id) {
    this.terminal_id = terminal_id;
  }
  /**
   * @return the terminal_location
   */
  public LocationBean getTerminal_location() {
    return terminal_location;
  }
  /**
   * @param terminal_location the terminal_location to set
   */
  public void setTerminal_location(LocationBean terminal_location) {
    this.terminal_location = terminal_location;
  }
  /**
   * @return the terminal_type
   */
  public String getTerminal_type() {
    return terminal_type;
  }
  /**
   * @param terminal_type the terminal_type to set
   */
  public void setTerminal_type(String terminal_type) {
    this.terminal_type = terminal_type;
  }
  /**
   * @return the airport_iata
   */
  public AirportBean getAirport_iata() {
    return airport_iata;
  }
  /**
   * @param airport_iata the airport_iata to set
   */
  public void setAirport_iata(AirportBean airport_iata) {
    this.airport_iata = airport_iata;
  }
}
