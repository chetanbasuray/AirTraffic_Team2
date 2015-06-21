/**
 * 
 */
package com.AirTraffic.Team2.Models;

import java.util.Date;

/**
 * @author Chetan
 *
 */
public class TicketBean {
	private int ticket_id;
	private double ticket_price;
	private Date ticket_booking_date;
	private String ticket_pnr;
	private int ticket_paymentType_id;
	private String paymenttype;
	private int ticket_bookingStatus_id;
	private String bookingstatus;
	private int ticket_currency_id;
	private String currency;
	private PersonBean customer_id;
	private CounterBean ticket_counter_id;
	private Date ticket_verificationTime;
	private boolean checkInStatus;


	/**
	 * @return the ticket_id
	 */
	public int getTicket_id() {
		return ticket_id;
	}

	/**
	 * @param ticket_id
	 *            the ticket_id to set
	 */
	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}

	/**
	 * @return the ticket_price
	 */
	public double getTicket_price() {
		return ticket_price;
	}

	/**
	 * @param ticket_price
	 *            the ticket_price to set
	 */
	public void setTicket_price(double ticket_price) {
		this.ticket_price = ticket_price;
	}

	/**
	 * @return the ticket_booking_date
	 */
	public Date getTicket_booking_date() {
		return ticket_booking_date;
	}

	/**
	 * @param ticket_booking_date
	 *            the ticket_booking_date to set
	 */
	public void setTicket_booking_date(Date ticket_booking_date) {
		this.ticket_booking_date = ticket_booking_date;
	}

	/**
	 * @return the ticket_pnr
	 */
	public String getTicket_pnr() {
		return ticket_pnr;
	}

	/**
	 * @param ticket_pnr
	 *            the ticket_pnr to set
	 */
	public void setTicket_pnr(String ticket_pnr) {
		this.ticket_pnr = ticket_pnr;
	}

	/**
	 * @return the ticket_paymentType_id
	 */
	public int getTicket_paymentType_id() {
		return ticket_paymentType_id;
	}

	/**
	 * @param ticket_paymentType_id
	 *            the ticket_paymentType_id to set
	 */
	public void setTicket_paymentType_id(int ticket_paymentType_id) {
		this.ticket_paymentType_id = ticket_paymentType_id;
	}

	/**
	 * @return the paymenttype
	 */
	public String getPaymenttype() {
		return paymenttype;
	}

	/**
	 * @param paymenttype
	 *            the paymenttype to set
	 */
	public void setPaymenttype(String paymenttype) {
		this.paymenttype = paymenttype;
	}

	/**
	 * @return the ticket_bookingStatus_id
	 */
	public int getTicket_bookingStatus_id() {
		return ticket_bookingStatus_id;
	}

	/**
	 * @param ticket_bookingStatus_id
	 *            the ticket_bookingStatus_id to set
	 */
	public void setTicket_bookingStatus_id(int ticket_bookingStatus_id) {
		this.ticket_bookingStatus_id = ticket_bookingStatus_id;
	}

	/**
	 * @return the bookingstatus
	 */
	public String getBookingstatus() {
		return bookingstatus;
	}

	/**
	 * @param bookingstatus
	 *            the bookingstatus to set
	 */
	public void setBookingstatus(String bookingstatus) {
		this.bookingstatus = bookingstatus;
	}

	/**
	 * @return the ticket_currency_id
	 */
	public int getTicket_currency_id() {
		return ticket_currency_id;
	}

	/**
	 * @param ticket_currency_id
	 *            the ticket_currency_id to set
	 */
	public void setTicket_currency_id(int ticket_currency_id) {
		this.ticket_currency_id = ticket_currency_id;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency
	 *            the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * @return the customer_id
	 */
	public PersonBean getCustomer_id() {
		return customer_id;
	}

	/**
	 * @param customer_id
	 *            the customer_id to set
	 */
	public void setCustomer_id(PersonBean customer_id) {
		this.customer_id = customer_id;
	}

	/**
	 * @return the ticket_counter_id
	 */
	public CounterBean getTicket_counter_id() {
		return ticket_counter_id;
	}

	/**
	 * @param ticket_counter_id
	 *            the ticket_counter_id to set
	 */
	public void setTicket_counter_id(CounterBean ticket_counter_id) {
		this.ticket_counter_id = ticket_counter_id;
	}

	/**
	 * @return the ticket_verificationTime
	 */
	public Date getTicket_verificationTime() {
		return ticket_verificationTime;
	}

	/**
	 * @param ticket_verificationTime
	 *            the ticket_verificationTime to set
	 */
	public void setTicket_verificationTime(Date ticket_verificationTime) {
		this.ticket_verificationTime = ticket_verificationTime;
	}

	/**
	 * @return the checkInStatus
	 */
	public boolean isCheckInStatus() {
		return checkInStatus;
	}

	/**
	 * @param checkInStatus
	 *            the checkInStatus to set
	 */
	public void setCheckInStatus(boolean checkInStatus) {
		this.checkInStatus = checkInStatus;
	}
}