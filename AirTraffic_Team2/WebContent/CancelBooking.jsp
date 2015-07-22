<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.AirTraffic.Team2.Models.RunwayBean"%>
<%@page import="com.AirTraffic.Team2.Models.FlightBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
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
<title>Cancel Booking</title>
</head>
<body>
	<div class="container">
		<div class="btn-group">
			<button type="button" class="btn btn-success" class="active"
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
			<button type="button" class="btn btn-warning"
				onclick="location.href='./assignRunway';">
				<span class="glyphicon glyphicon-king" aria-hidden="true">
					Assign Runway </span>
			</button>
		</div>
	</div>

	<div class="container">
		<div class="panel panel-default">
			<div class="panel-body"
				style="background: url(https://lh3.googleusercontent.com/proxy/mvLixCPJj8P7mAONpA43N1iasEkd-iTnz957KlREkjoIHnT52rSn55GTdpLSYh713ITk3V-HWmdxH24K9nuBdCjpR7E3GymiQhKqJolJeYqLMYUMITtfTtsOvRzsdj_wX8GmTUmTEw=w426-h239-p); background-size: cover;">

				<form role="form" method="post" action="cancelBooking" onSubmit="alert('Ticket has been Cancelled');
					accept-charset="UTF-8">
					<%
						if (request.getAttribute("error") != null) {
					%>
					<h3><label>PNR doesnot exist or the ticket has been cancelled already</label></h3>
					<!-- <%=request.getAttribute("error")%> -->
					<%
						} else {
							if(request.getAttribute("returnmsg")!=null && request.getAttribute("returnmsg").equals("success")){
					%>
					<h3><label>Ticket has been cancelled</label> </h3><br>
					<% 
						}									
							if(request.getAttribute("returnmsg")!=null && request.getAttribute("returnmsg").equals("false")){
								%>
								<h3><label>PNR doesnot exist or the ticket has been cancelled already</label></h3><br>
								<% 
							}
						}
					%>


					<div style="width: 40%; padding: 50px;">

						<div class="form-group">
							<span class="badge">Please Enter Your PNR</span>
							<input type="text" id="ticketPNR" name="ticketPNR" class="form-control">
						</div>
						<div class="form-group">
						<input type="submit" class="btn btn-info" value="Cancel Booking" style="font-face: 'Comic Sans MS'; font-size: larger; color: black;"  >
			</button>
						</div>
				</form>
			</div>

		</div>
	</div>
	</div>
	</div>
</body>
</html>