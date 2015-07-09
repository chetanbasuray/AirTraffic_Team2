package com.AirTraffic.Team2.Models;

/**
 * @author Chetan
 *
 */
public class LuggageBean {
	
	private String luggage_id;
	private double luggage_weight;
	private String luggage_type;
	private CounterBean counter; 
	
	public String getLuggage_id() {
		return luggage_id;
	}
	public void setLuggage_id(String luggage_id) {
		this.luggage_id = luggage_id;
	}
	public double getLuggage_weight() {
		return luggage_weight;
	}
	public void setLuggage_weight(double luggage_weight) {
		this.luggage_weight = luggage_weight;
	}
	public String getLuggage_type() {
		return luggage_type;
	}
	public void setLuggage_type(String luggage_type) {
		this.luggage_type = luggage_type;
	}
	public CounterBean getCounter() {
		return counter;
	}
	public void setCounter(CounterBean counter) {
		this.counter = counter;
	}
	
}
