/**
 * 
 */
package com.AirTraffic.Team2.Models;

import java.util.Date;

/**
 * @author Chetan
 *
 */
public class CounterBean {
private int counter_id;
private String counter_type;
private Date counter_opening_time;
private Date counter_closing_time;
private boolean counter_hasCash;
private String counter_status;
private TerminalBean terminalBean;

/**
 * @return the counter_id
 */
public int getCounter_id() {
	return counter_id;
}
/**
 * @param counter_id the counter_id to set
 */
public void setCounter_id(int counter_id) {
	this.counter_id = counter_id;
}
/**
 * @return the counter_type
 */
public String getCounter_type() {
	return counter_type;
}
/**
 * @param counter_type the counter_type to set
 */
public void setCounter_type(String counter_type) {
	this.counter_type = counter_type;
}
/**
 * @return the counter_opening_time
 */
public Date getCounter_opening_time() {
	return counter_opening_time;
}
/**
 * @param counter_opening_time the counter_opening_time to set
 */
public void setCounter_opening_time(Date counter_opening_time) {
	this.counter_opening_time = counter_opening_time;
}
/**
 * @return the counter_closing_time
 */
public Date getCounter_closing_time() {
	return counter_closing_time;
}
/**
 * @param counter_closing_time the counter_closing_time to set
 */
public void setCounter_closing_time(Date counter_closing_time) {
	this.counter_closing_time = counter_closing_time;
}
/**
 * @return the counter_hasCash
 */
public boolean isCounter_hasCash() {
	return counter_hasCash;
}
/**
 * @param counter_hasCash the counter_hasCash to set
 */
public void setCounter_hasCash(boolean counter_hasCash) {
	this.counter_hasCash = counter_hasCash;
}
/**
 * @return the counter_status
 */
public String getCounter_status() {
	return counter_status;
}
/**
 * @param counter_status the counter_status to set
 */
public void setCounter_status(String counter_status) {
	this.counter_status = counter_status;
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