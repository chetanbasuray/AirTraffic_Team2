/**
 * 
 */
package com.AirTraffic.Team2.Models;

/**
 * @author JOY
 *
 */
public class GateBean {
  private int gate_id;
  private String gate_location;
  private String gate_type;
  private TerminalBean terminal_id;
  /**
   * @return the gate_id
   */
  public int getGate_id() {
    return gate_id;
  }
  /**
   * @param gate_id the gate_id to set
   */
  public void setGate_id(int gate_id) {
    this.gate_id = gate_id;
  }
  /**
   * @return the gate_location
   */
  public String getGate_location() {
    return gate_location;
  }
  /**
   * @param gate_location the gate_location to set
   */
  public void setGate_location(String gate_location) {
    this.gate_location = gate_location;
  }
  /**
   * @return the gate_type
   */
  public String getGate_type() {
    return gate_type;
  }
  /**
   * @param gate_type the gate_type to set
   */
  public void setGate_type(String gate_type) {
    this.gate_type = gate_type;
  }
  /**
   * @return the terminal_id
   */
  public TerminalBean getTerminal_id() {
    return terminal_id;
  }
  /**
   * @param terminal_id the terminal_id to set
   */
  public void setTerminal_id(TerminalBean terminal_id) {
    this.terminal_id = terminal_id;
  }
}
