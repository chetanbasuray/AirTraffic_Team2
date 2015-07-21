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
				style="background: url(http://www.airarabia.com/sites/airarabia/files/styles/medium_coupon/public/Cancel_Flight_360X170_pxl.jpg?itok=Y8y671G-); background-size: cover;">

				<form role="form" method="post" action="./cancelBooking"
					accept-charset="UTF-8">
					<%
					  if (request.getAttribute("error") != null) {
					%>
					<div class="alert alert-warning alert-dismissible" role="alert">
						<button type="button" class="close" data-dismiss="alert"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<%=request.getAttribute("error")%></div>

					<%
					  }
					  if (request.getAttribute("success") != null) {
					%>

					<div class="alert alert-warning alert-dismissible" role="alert">
						<button type="button" class="close" data-dismiss="alert"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<%=request.getAttribute("success")%></div>
					<%
					  }
					%>


					<div style="width: 40%; padding: 50px;">

						<div class="form-group">
							<span class="badge">Please Enter Your PNR</span>
							<input type="text" id="ticketPNR" name="ticketPNR" class="form-control">
						</div>
						<div class="form-group">
						<button type="button" class="btn btn-info"
				onclick="location.href='./cancelBooking';">
				<span class="glyphicon glyphicon-scissors" aria-hidden="true">
					Cancel Booking </span>
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