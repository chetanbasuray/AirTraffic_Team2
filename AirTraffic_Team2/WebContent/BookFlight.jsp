<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.AirTraffic.Team2.Models.BookingBean"%>
<%@page import="com.AirTraffic.Team2.Models.FlightBean"%>
<%@page import="com.AirTraffic.Team2.Models.LocationBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.AirTraffic.Team2.Servlets.BookFlightServlet"%>


<jsp:useBean id="booking" scope="request"
	class="com.AirTraffic.Team2.Models.BookingBean" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>AirTraffic</title>

</head>

<body>
	<a href="index.html">Home Page</a>
	<form method="get" action="booking">
		<h1 align="center">Booking Information Details</h1>
		<table width="600" height="300" align=center cellspacing=0 border="0"
			cellpadding=0>
			<tr>
				<td>
					<fieldset id="fieldhead">
						<legend>Booking Information</legend>
						<BR>

						<table align=center cellspacing=1 cellpadding=3>

							<div align="center">
								<table border="1" cellpadding="5">
									<caption>
										<h2>Details of Booking</h2>
									</caption>
									<%
										if (request.getAttribute("error") != null) {
									%>
									<h3>No Flight Found</h3>
									<%=request.getAttribute("error")%>
									<%
										} 
									else {
										if (request.getAttribute("personDetails") != null
												&& !request.getAttribute("personDetails").equals("")) {
											
											List<FlightBean> flightList = (ArrayList<FlightBean>) request
													.getAttribute("flights");
									%>
									<tr>
										<th>First Name</th>
										<th>Last Name</th>
										<th>Gender</th>
										<th>Unique Id</th>
										<th>Id Type</th>
										<th>DOB</th>
										<th>Mobile</th>
                                        <th>Email</th>
                                        <th>Telephone</th>
										<th>Address Line 1</th>
										<th>Address Line 2</th>
                                        <th>City</th>
                                        <th>State</th>
                                        <th>Zip code</th>
                                        <th>Country</th>
									</tr>
									<%
									
										List<BookingBean> bookPersonDetails = (ArrayList<BookingBean>) request
														.getAttribute("personDetails");

												for (int i = 0; i < bookPersonDetails.size(); i++) {
									%>
									<tr>

										<td><%=bookPersonDetails.get(i).getPersonBean().getPerson_fname()%></td>
										<td><%=bookPersonDetails.get(i).getPersonBean().getPerson_lname()%></td>
										<td><%=bookPersonDetails.get(i).getPersonBean().getPerson_gender()%></td>
										<td><%=bookPersonDetails.get(i).getPersonBean().getPerson_official_id()%></td>
										<td><%=bookPersonDetails.get(i).getPersonBean().getPerosn_official_id_type()%></td>
										<td><%=bookPersonDetails.get(i).getPersonBean().getPerson_dob()%></td>
										<td><%=bookPersonDetails.get(i).getPersonBean().getPerson_mobile()%></td>
										<td><%=bookPersonDetails.get(i).getPersonBean().getPerson_email()%></td>
										<td><%=bookPersonDetails.get(i).getPersonBean().getPerson_telephone()%></td>
										<td><%=bookPersonDetails.get(i).getLocationBean().getLocation_line_1()%></td>
										<td><%=bookPersonDetails.get(i).getLocationBean().getLocation_line_2()%></td>
										<td><%=bookPersonDetails.get(i).getLocationBean().getCity()%></td>
										<td><%=bookPersonDetails.get(i).getLocationBean().getState()%></td>
										<td><%=bookPersonDetails.get(i).getLocationBean().getZipcode()%></td>
										<td><%=bookPersonDetails.get(i).getLocationBean().getCountry()%></td>
                                        
									</tr>
									<%
										}
									%>
									<%
										}
									}
									%>
								</table>
							</div>

						</table>
				</td>
			</tr>
		</table>

		<br>


<table width="600" height="300" align=center cellspacing=0 border="0"
			cellpadding=0>
			<tr>
				<td>
					<fieldset id="fieldhead">
						<legend>Flight Information</legend>
						<BR>

						<table align=center cellspacing=1 cellpadding=3>

							<div align="center">
								<table border="1" cellpadding="5">
									<caption>
										<h2>Flight Details</h2>
									</caption>
									<%
										if (request.getAttribute("error") != null) {
									%>
									<h3>No Flight Found</h3>
									<%=request.getAttribute("error")%>
									<%
										} 
									else {
									
									%>
									<tr>
										<th>Flight Name</th>
										<th>Departure Time</th>
										<th>Arrival Time</th>
										<th>Departure Airport</th>
										<th>Arrival Airport</th>
										<th>Departure Date</th>
										<th>Arrival Date</th>                                        
									</tr>
									<%
									
										List<FlightBean> flightList = (List<FlightBean> )session.getAttribute("flight");

												for (int i = 0; i < flightList.size(); i++) {
									%>
									<tr>

										<td><%=flightList.get(i).getFlight_Id()%></td>
										<td><%=flightList.get(i)
								.getFlight_scheduled_departure_time()%></td>
										<td><%=flightList.get(i)
								.getFlight_scheduled_arrival_time()%></td>
										<td><%=flightList.get(i).getFlightSegmentBean()
								.getOriginAirport().getAirport_iata()%></td>
										<td><%=flightList.get(i).getFlightSegmentBean()
								.getDestinationAirport().getAirport_iata()%></td>
										<td><%=flightList.get(i).getDepartureDate()%></td>
										<td><%=flightList.get(i).getArrivalDate()%></td>
                                        
									</tr>
									<%
										}
									%>
									<%								
									
									}
									%>
								</table>
							</div>

						</table>
				</td>
			</tr>
		</table>

		<br>

					
	</form>

</body>


</html>