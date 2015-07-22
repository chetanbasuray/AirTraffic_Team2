package com.AirTraffic.Team2.Servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AirTraffic.Team2.Models.BookingBean;
import com.AirTraffic.Team2.Models.LocationBean;
import com.AirTraffic.Team2.Models.PersonBean;
import com.AirTraffic.Team2.dao.BookFlightDAO;




@SuppressWarnings("serial")

public class BookFlightServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("newCustAdded", "No");

		} catch (Throwable e) {
			request.setAttribute("error", e.getMessage());
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/BookFlight.jsp");		
		dispatcher.forward(request, response);
	}
	
	

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			
		BookFlightDAO bookFlightDAO = new BookFlightDAO();
		 try {
			 if(request.getParameter("yesno").toString().equals("existing")){
			    String customerId = request.getParameter("existingCustomerID").toString();
				
				List<BookingBean> bookPersonDetails = bookFlightDAO.getPersonDetails(customerId);
				request.setAttribute("existingTab", "True");
			    request.setAttribute("personDetails", bookPersonDetails);
			    request.setAttribute("newCustAdded", "No");
			 }else{
				 //String customerId= request.getParameter("newCustomerID").toString();
				 PersonBean personBean = new PersonBean();
				 personBean.setPerson_fname(request.getParameter("firstName").toString());
				 personBean.setPerson_lname(request.getParameter("lastName").toString());
				 personBean.setPerson_gender(request.getParameter("genderDdl").toString());
				 personBean.setPerosn_official_id_type(request.getParameter("idTypeDdl"));
				 personBean.setPerson_official_id(request.getParameter("newCustomerID"));
				 personBean.setPerson_official_id(request.getParameter("newCustomerID"));
				 //DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
				 DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				 
				 Date dob = (Date) format.parse(request.getParameter("dob"));
				 personBean.setPerson_dob(dob);
				 personBean.setPerson_mobile(request.getParameter("custMobile"));
				 personBean.setPerson_email(request.getParameter("custEmail"));
				 personBean.setPerson_telephone(request.getParameter("custTelephone"));
				 LocationBean locationBean = new LocationBean();
				 locationBean.setLocation_line_1(request.getParameter("custAdl1"));
				 locationBean.setLocation_line_2(request.getParameter("custAdl2"));
				 locationBean.setCity(request.getParameter("custCity"));
				 locationBean.setCountry(request.getParameter("custCountry"));
				 locationBean.setState(request.getParameter("custState"));
				 locationBean.setZipcode(request.getParameter("custZipcode"));
				 request.setAttribute("newCustAdded", "No");
				 
				 boolean newCustomerAdded = bookFlightDAO.savePersonDetails(locationBean, personBean);
				 
				 if(newCustomerAdded == true)
				 {
					 //String customerId = request.getParameter("newCustomerID").toString();
					 List<BookingBean> bookPersonDetails = bookFlightDAO.getPersonDetails(request.getParameter("newCustomerID"));			
					 request.setAttribute("personDetails", bookPersonDetails);
					 request.setAttribute("newCustAdded", "Yes");
				 }
			 }
             
         } catch (Throwable e) {
             request.setAttribute("error", e.getMessage());
         }         
		RequestDispatcher dispatcher = request.getRequestDispatcher("/BookFlight.jsp");
		dispatcher.forward(request, response);
	}
}