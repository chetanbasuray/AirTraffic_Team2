<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="com.AirTraffic.Team2.Models.AirportBean"%>
<%@page import="com.AirTraffic.Team2.Models.FlightBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.AirTraffic.Team2.Servlets.SearchFlightServlet"%>

<jsp:useBean id="searchFlight" scope="request"
	class="com.AirTraffic.Team2.Models.FlightBean" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/ui-lightness/jquery-ui.css"
	rel="stylesheet" type="text/css" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
<script type="text/javascript">

$(document).ready(function() {
	$("#departureDate").datepicker({
		dateFormat : "yy-mm-dd"
	});		
	$("#arrivalDate").datepicker({
		dateFormat : "yy-mm-dd"
	});	
});
</script>

<title>Flights Information</title>
</head>
<body>
	<a href="index.html">Home Page</a>
	<h1 align="center">Flight details</h1>
	<form method=post action="searchFlight">

		<table width="600" height="300" align=center cellspacing=0 border="0"
		cellpadding=0>
		<tr>
			<td>
				<fieldset id="fieldhead">
					<legend>Flights Information</legend>
					<BR>
					<table align=center cellspacing=1 cellpadding=3>					
							<div align="center">
								<table border="1" cellpadding="5">
									<caption>
										<h2>List of flights</h2>
									</caption>
									<%
										if (request.getAttribute("error") != null) {
									%>
									<h3>No Flights Found</h3>
									<%=request.getAttribute("error")%>
									<%
										} else {
											if((request.getAttribute("flights")!=null && !(request.getAttribute("flights")=="")))
											{
											List<FlightBean> flightList = (ArrayList<FlightBean>) request
													.getAttribute("flights");
																						
									%>
									<tr>
										<th>Flight ID</th>
										<th>Departure Time</th>
										<th>Arrival Time</th>
										<th>Departure Airport</th>
										<th>Arrival airport</th>
										<th>Departure Date</th>
										<th>Arrival Date</th>
										<th>Book Flight</th>
										

									</tr>
									<%
									
										
											for (int i = 0; i < flightList.size(); i++) {
									%>
									<tr>										
										<td><%=flightList.get(i).getFlight_Id()%></td>
										<td><%=flightList.get(i).getFlight_scheduled_departure_time()%></td>
										<td><%=flightList.get(i).getFlight_scheduled_arrival_time()%></td>										
										<td><%=flightList.get(i).getFlightSegmentBean().getOriginAirport().getAirport_iata()%></td>
										<td><%=flightList.get(i).getFlightSegmentBean().getDestinationAirport().getAirport_iata()%></td>
										<td><%=flightList.get(i).getDepartureDate()%></td>
										<td><%=flightList.get(i).getArrivalDate()%></td>
										<td><a
											href="booking?flightId=<%=flightList.get(i).getFlight_Id()%>">Book Flight</a></td>

									</tr>
									<%
										}
									session.setAttribute("flight", flightList);
									}
									
								}								
									
									
									%>
								</table>
							</div>
						</form>
					</table>
			</td>
		</tr>
	</table>
	<%
										if (request.getAttribute("error") != null) {
									%>
									<h3>No Airport Found</h3>
									<%=request.getAttribute("error")%>
									<%
										} else {	  
	    List<AirportBean> airportIataList = (ArrayList<AirportBean>) request
		.getAttribute("allIata");							
		%>

		<div align="center">
			Departure Airport<select name="departureAirportDdl">
				<% for (int i = 0; i < airportIataList.size(); i++) {	 %>		
				<option value="<%=airportIataList.get(i).getAirport_iata()%>"><%=airportIataList.get(i).getAirport_iata()%></option>
				<%}%>				
			</select> 
			<br>
			
			Arrival Airport<select name="arrivalAirportDdl">		
			<% for (int i = 0; i < airportIataList.size(); i++) {	 %>				
				<option value="<%=airportIataList.get(i).getAirport_iata()%>"><%=airportIataList.get(i).getAirport_iata()%></option>
				<%}
				
				}%>				
			</select> 
			
			<br> <br> 
			<label >Departure Date</label> <input
				type="text" id="departureDate" name="departureDate"> <br> 
			<label >Return Date</label> <input
				type="text" id="arrivalDate" name="arrivalDate"> <br> 
			

			<input type="submit" value="Submit">
		</div>
	</form>
</body>
</html>
