package com.AirTraffic.Team2.Models;

/**
 * @author Chetan
 *
 */
public class RunwayBean {
  private int runway_id;
  private double runway_length;
  private double runway_width;
  private String runway_status;
  private AirportBean airportIata;
  /**
   * @return the runway_id
   */
  public int getRunway_id() {
    return runway_id;
  }
  /**
   * @param runway_id the runway_id to set
   */
  public void setRunway_id(int runway_id) {
    this.runway_id = runway_id;
  }
  /**
   * @return the runway_length
   */
  public double getRunway_length() {
    return runway_length;
  }
  /**
   * @param runway_length the runway_length to set
   */
  public void setRunway_length(double runway_length) {
    this.runway_length = runway_length;
  }
  /**
   * @return the runway_width
   */
  public double getRunway_width() {
    return runway_width;
  }
  /**
   * @param runway_width the runway_width to set
   */
  public void setRunway_width(double runway_width) {
    this.runway_width = runway_width;
  }
  /**
   * @return the runway_status
   */
  public String getRunway_status() {
    return runway_status;
  }
  /**
   * @param runway_status the runway_status to set
   */
  public void setRunway_status(String runway_status) {
    this.runway_status = runway_status;
  }
  /**
   * @return the airportIata
   */
  public AirportBean getAirportIata() {
    return airportIata;
  }
  /**
   * @param airportIata the airportIata to set
   */
  public void setAirportIata(AirportBean airportIata) {
    this.airportIata = airportIata;
  }
}
