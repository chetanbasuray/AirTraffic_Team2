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
<meta name="viewport" content="width=device-width, initial-scale=1">


  
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">


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

var adultcount = 1; //Initializing adultcount with 1 because atleast 1 adult should travel
var childcount = 0;
var infantcount = 0;

function editcount(element){
	
	switch(element.id){
	
	case "Adultplus":  
	adultcount++;
	break;
	
	case "Adultminus":
	if(adultcount > 1)
		adultcount--;
	break;
	
	case "Childplus":  
	childcount++;
	break;
		
	case "Childminus":
	if(childcount > 0)
		childcount--;
	break;

	case "Infantplus":  
	infantcount++;
	break;
		
	case "Infantminus":
	if(infantcount > 0)
		infantcount--;
	break;

	}
	
	$('#Adultcount').text(adultcount);
	$('#Infantcount').text(infantcount);
	$('#Childcount').text(childcount);
		
}

</script>
<script>
$(document).ready(function(){  
  $("select").change(function() {   
    $("select").not(this).find("option[value="+ $(this).val() + "]").attr('disabled', true);
  }); 
}); 
</script>

<script>
function startEndDateValidator(){    
	var startDate = document.getElementById("departureDate").value;
	var endDate = document.getElementById("arrivalDate").value;
    if ((Date.parse(startDate,"yy-mm-dd") >= Date.parse(endDate,"yy-mm-dd"))) {
    	
        alert("Return date should be greater than Departure date");
        document.getElementById("arrivalDate").value = "";
    }
}
</script>


<title>Search FLight</title>
</head>
<body>
<div class="container">
<div class="btn-group">
			<button type="button" class="btn btn-warning" class="active"
				onclick="location.href='./searchFlight';">
				<span class="glyphicon glyphicon-plane" aria-hidden="true">Book
					Flight </span>
			</button>
			<button type="button" class="btn btn-success"
				onclick="location.href='./printTicket';">
				<span class="glyphicon glyphicon-print" aria-hidden="true">
					Print Ticket </span>
			</button>
			<button type="button" class="btn btn-success"
				onclick="location.href='./cancelBooking';">
				<span class="glyphicon glyphicon-scissors" aria-hidden="true">
					Cancel Booking </span>
			</button>
			<button type="button" class="btn btn-success"
				onclick="location.href='./addFlights';">
				<span class="glyphicon glyphicon-plus-sign" aria-hidden="true">
					Add Flights </span>
			</button>
			<button type="button" class="btn btn-success"
				onclick="location.href='./assignRunway';">
				<span class="glyphicon glyphicon-king" aria-hidden="true">
					Assign Runway </span>
			</button>
		</div>
</div>

<div class="container">
<div class="panel panel-default">
  <div class="panel-body" style="background: url(http://nyulocal.com/wp-content/uploads/2013/10/The-plane-flying-at-sunset-airliner-photography_1920x1080.jpg);background-size: cover;">

	<form method=post action="searchFlight">

		
	<%
										if (request.getAttribute("error") != null) {
									%>
									<h3>No Airport Found</h3>
									<%=request.getAttribute("error")%>
									<%
										} else {	  
	    List<AirportBean> airportIataList = (ArrayList<AirportBean>) request.getAttribute("allIata");							
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
				
				%>
			<%}%>			
			</select> 
				
			<br> <br> 
			<label >Departure Date</label> <input
				type="text" id="departureDate"  name="departureDate"> <br> 
			<label >Return Date</label> <input
				type="text" id="arrivalDate" name="arrivalDate" onchange="startEndDateValidator()">  <br> 
<table class = "table">
<tr align="center"><td colspan="4">
  <div class="alert alert-default" role="alert">Please input the number of travellers according to their ages and the class of travel</div>
  </td></tr>
  <tr>
  <td align = "center"><span class="badge">ADULT: (12+ YRS )</span></td>
  <td align = "center"><span class="badge">CHILD: (2-11 YRS )</span></td>
  <td align = "center"><span class="badge">INFANT: (0-2 YRS )</span></td>
  <td align = "center"><span class="badge">Class</span></td>
  </tr>
  <tr>
  <td align = "center">
	<button class="btn btn-primary btn-sm" id="Adultminus" type="button" onclick="editcount(this)"><span class="glyphicon glyphicon-minus" aria-hidden="true"></span></button>
	<span id="Adultcount" name = "adultNumber" class="label label-warning">1</span>
    <button class="btn btn-primary btn-sm" id="Adultplus" type="button" onclick="editcount(this)" ><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></button>
  </td>
  <td align = "center">
	<button class="btn btn-primary btn-sm" id="Childminus" type="button" onclick="editcount(this)"><span class="glyphicon glyphicon-minus" aria-hidden="true"></span></button>
	<span id="Childcount" name = "childNumber" class="label label-warning">0</span>
    <button class="btn btn-primary btn-sm" id="Childplus" type="button" onclick="editcount(this)"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></button>
    </td>
    <td align = "center">
    <button class="btn btn-primary btn-sm" id="Infantminus" type="button" onclick="editcount(this)"><span class="glyphicon glyphicon-minus" aria-hidden="true"></span></button>
	<span id="Infantcount" name = "infantNumber" class="label label-warning">0</span>
    <button class="btn btn-primary btn-sm" id="Infantplus" type="button" onclick="editcount(this)"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></button>
    </td>
    <td align = "center" valign="bottom">
<select name="class">
  <option value="economy">Economy</option>
  <option value="business">Business</option>
  <option value="first">First Class</option>
</select>
    </td>
	</tr>
</table>
<br><br>
<button type="submit" class="btn btn-info"> <span class="glyphicon glyphicon-search" aria-hidden="true"> Search </span></button>
			
		</div>
	</form>
	</div>
</div>
</div>
<% if((request.getAttribute("flights")!=null && !(request.getAttribute("flights")==""))){ %>
<div class="container">
<div class="alert alert-info" role="alert">
<table width="600" height="300" align=center cellspacing=0 border="0"
		cellpadding=0>
		<tr>
			<td>
					<div class="panel panel-default"><div class="panel-body">Flight Information
					
					<table class="table" align=center cellspacing=1 cellpadding=3>					
							<div align="center">
								<table class="table" cellpadding="5">
									<%
										if (request.getAttribute("error") != null) {
									%>
									<div class="alert alert-danger" role="alert">
									<%=request.getAttribute("error")%>
									</div>
									<%
										} else {
											if((request.getAttribute("flights")!=null && !(request.getAttribute("flights")=="")))
											{
											List<FlightBean> flightList = (ArrayList<FlightBean>) request.getAttribute("flights");
																						
									%>
									</div>
									<div class="panel-footer">

									<tr>
										<th>Flight ID</th>
										<th>Departure Time</th>
										<th>Arrival Time</th>
										<th>Departure Airport</th>
										<th>Arrival airport</th>
										<th>Departure Date</th>
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
										<td><a
											href="booking?flightId=<%=flightList.get(i).getFlight_Id()%>">Book Flight</a></td>
									
									</tr>
									
									<%
										}
									session.setAttribute("flight", flightList);
									session.setAttribute("adultCount", request.getAttribute("adultNumber"));
									session.setAttribute("childCount", request.getAttribute("childNumber"));
									session.setAttribute("infantCount", request.getAttribute("infantNumber"));
								
									}
									
								}								
									
									%>
									
								</table>
								</div>
					</table>
			</td>
		</tr>
	</table>
	</div>
	</div>
	</div>
	<% } %>
	<% if((request.getAttribute("flights_return")!=null && !(request.getAttribute("flights_return")==""))){ %>
<div class="container">
<div class="alert alert-info" role="alert">
<table width="600" height="300" align=center cellspacing=0 border="0"
		cellpadding=0>
		<tr>
			<td>
					<div class="panel panel-default"><div class="panel-body">Flight Information
					
					<table class="table" align=center cellspacing=1 cellpadding=3>					
							<div align="center">
								<table class="table" cellpadding="5">
									<%
										if (request.getAttribute("error") != null) {
									%>
									<div class="alert alert-danger" role="alert">
									<%=request.getAttribute("error")%>
									</div>
									<%
										} else {
											if((request.getAttribute("flights_return")!=null && !(request.getAttribute("flights_return")=="")))
											{
											List<FlightBean> flightList = (ArrayList<FlightBean>) request.getAttribute("flights");
																						
									%>
									</div>
									<div class="panel-footer">

									<tr>
										<th>Flight ID</th>
										<th>Departure Time</th>
										<th>Arrival Time</th>
										<th>Departure Airport</th>
										<th>Arrival airport</th>
										<th>Return Date</th>
										<th>Book Flight</th>
										

									</tr>
									<%
											for (int i = 0; i < flightList.size(); i++) {
									%>
									
									<tr>	
																		
										<td><%=flightList.get(i).getFlight_Id()%></td>
										<td><%=flightList.get(i).getFlight_scheduled_departure_time()%></td>
										<td><%=flightList.get(i).getFlight_scheduled_arrival_time()%></td>										
										<td><%=flightList.get(i).getFlightSegmentBean().getDestinationAirport().getAirport_iata()%></td>
										<td><%=flightList.get(i).getFlightSegmentBean().getOriginAirport().getAirport_iata()%></td>
										<td><%=flightList.get(i).getArrivalDate()%></td>
										<td><a
											href="booking?flightId=<%=flightList.get(i).getFlight_Id()%>">Book Flight</a></td>
									
									</tr>
									
									<%
										}
									session.setAttribute("flight", flightList);
									session.setAttribute("adultCount", request.getAttribute("adultNumber"));
									session.setAttribute("childCount", request.getAttribute("childNumber"));
									session.setAttribute("infantCount", request.getAttribute("infantNumber"));
								
									}
									
								}								
									
									%>
									
								</table>
								</div>
					</table>
			</td>
		</tr>
	</table>
	</div>
	</div>
	</div>
	<% } %>
</body>
</html>