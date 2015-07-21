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
<title>Assign Runway</title>
</head>
<body>
	<div class="container">
		<div>
			<div class="btn-group">
				<button type="button" class="btn btn-success">
					<span class="glyphicon glyphicon-plane" aria-hidden="true">
						Book Flight </span>
				</button>
				<button type="button" class="btn btn-success">
					<span class="glyphicon glyphicon-tasks" aria-hidden="true">
						Manage Booking </span>
				</button>
				<button type="button" class="btn btn-success">
					<span class="glyphicon glyphicon-scissors" aria-hidden="true">
						Cancel Booking </span>
				</button>
				<button type="button" class="btn btn-success">
					<span class="glyphicon glyphicon-king" aria-hidden="true">
						Admin Privileges </span>
				</button>
			</div>
			<div class="btn-group" style="float: right">
				<button type="button" class="btn btn-danger" class="active">
					<span class="glyphicon glyphicon-off" aria-hidden="true"></span>
					Sign Out
				</button>
				<button type="button" class="btn btn-danger" class="active">
					<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
					Log In
				</button>
			</div>
		</div>
		<br>

		<div class="btn-group">
			<button type="button" class="btn btn-success" class="active"
				onclick="location.href='./searchFlight';">
				<span class="glyphicon glyphicon-plane" aria-hidden="true">Book
					Flight </span>
			</button>
			<button type="button" class="btn btn-success"
				onclick="location.href='./#';">
				<span class="glyphicon glyphicon-print" aria-hidden="true">
					Print Ticket </span>
			</button>
			<button type="button" class="btn btn-success"
				onclick="location.href='./#';">
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
				style="background: url(https://upload.wikimedia.org/wikipedia/commons/e/e1/Landing_at_Zurich_International_Airport.jpg); background-size: cover;">

				<form role="form" method="post" action="./assignRunway"
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
					  List<RunwayBean> availRunways = (ArrayList<RunwayBean>) request.getAttribute("runways");
					  List<FlightBean> incomingFlights = (ArrayList<FlightBean>) request.getAttribute("flights");
					%>


					<div style="width: 40%; padding: 50px;">

						<div class="form-group">
							<input type="text" id="empId" name="empId" class="form-control"
								value="1">
						</div>

						<div class="form-group col-md-5">
							<label for="incomingFlight" style="color: white">Select
								incoming Flight:</label> <select class="form-control"
								id="incomingFlight" name="incomingFlight" size="5">
								<%
								  for (FlightBean flight : incomingFlights) {
								%>
								<option value="<%=flight.getFlight_Id()%>"><%=flight.getFlight_Id()%></option>
								<%
								  }
								%>
							</select>
						</div>
						<div class="col-md-2"></div>
						<div class="form-group col-md-5">
							<label for="availableRunway" style="color: white">Select
								available runway:</label> <select class="form-control"
								id="availableRunway" name="availableRunway" size="5">

								<%
								  for (RunwayBean runway : availRunways) {
								%>
								<option value="<%=runway.getRunway_id()%>"><%=runway.getRunway_id()%></option>
								<%
								  }
								%>
							</select>
						</div>

						<button type="submit" class="btn btn-info">
							<span class="glyphicon glyphicon-ok-circle" aria-hidden="true">
								Assign </span>
						</button>
				</form>
			</div>

		</div>
	</div>
	</div>
</body>
</html>