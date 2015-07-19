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
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<title>Assign Runway</title>
</head>
<body>
	<div class="container">
		<%
		  if (request.getAttribute("error") != null) {
		%>
		<h1>Error while fetching runways!</h1>
		<%=request.getAttribute("error")%>
		<%
		  } else {
		    if (request.getAttribute("success") != null) {
		%>
		<h1>Error in creating log!</h1>
		<%=request.getAttribute("success")%>
		<%
		  }
		    List<RunwayBean> availRunways = (ArrayList<RunwayBean>) request.getAttribute("runways");
		    List<FlightBean> incomingFlights = (ArrayList<FlightBean>) request.getAttribute("flights");
		%>


		<div style="width: 40%; padding: 50px;">
			<form role="form" method="post" action="./assignRunway"
				accept-charset="UTF-8">
				<div class="form-group">
					<input type="text" id="empId" name="empId" class="form-control"
						value="1">
				</div>

				<div class="form-group col-md-5">
					<label for="incomingFlight">Select incoming Flight:</label> <select
						class="form-control" id="incomingFlight" name="incomingFlight"
						size="5">
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
					<label for="availableRunway">Select available runway:</label> <select
						class="form-control" id="availableRunway" name="availableRunway"
						size="5">

						<%
						  for (RunwayBean runway : availRunways) {
						%>
						<option value="<%=runway.getRunway_id()%>"><%=runway.getRunway_id()%></option>
						<%
						  }
						  }
						%>
					</select>
				</div>

				<button class="btn btn-default" type="submit">Assign</button>
			</form>
		</div>
	</div>
</body>
</html>