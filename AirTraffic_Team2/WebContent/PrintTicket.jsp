<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Print Ticket</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
</head>
<body>
<div class = "pageheader">
<div class="container">
<div>
<div class="btn-group">
  <button type="button" class="btn btn-success"> <span class="glyphicon glyphicon-home" aria-hidden="true"> Home </span></button>
  <button type="button" class="btn btn-success"> <span class="glyphicon glyphicon-plane" aria-hidden="true"> Book Flight </span></button>
  <button type="button" class="btn btn-success"> <span class="glyphicon glyphicon-tasks" aria-hidden="true"> Manage Booking </span></button>
  <button type="button" class="btn btn-success"> <span class="glyphicon glyphicon-scissors" aria-hidden="true"> Cancel Booking </span></button>
  <button type="button" class="btn btn-success"> <span class="glyphicon glyphicon-king" aria-hidden="true"> Admin Privileges </span></button>
  </div>
  <div class="btn-group" style="float:right">
  <button type="button" class="btn btn-danger" class="active">  <span class="glyphicon glyphicon-off" aria-hidden="true"></span> Sign Out </button>
<button type="button" class="btn btn-danger" class="active">  <span class="glyphicon glyphicon-user" aria-hidden="true"></span> Log In</button>
</div>
</div>
<br>

<div class="btn-group">
  <button type="button" class="btn btn-success" class="active"
				onclick="location.href='./searchFlight';">
				<span class="glyphicon glyphicon-plane" aria-hidden="true">Book
					Flight </span>
			</button>
			<button type="button" class="btn btn-warning"
				onclick="location.href='./printTicket';">
				<span class="glyphicon glyphicon-print" aria-hidden="true">
					Print Ticket </span>
			</button>
			<button type="button" class="btn btn-success"
				onclick="location.href='./#';">
				<span class="glyphicon glyphicon-scissors" aria-hidden="true">
					Cancel Booking </span>
			</button>
			<button type="button" class="btn btn-success"
				onclick="location.href='./#';">
				<span class="glyphicon glyphicon-plus-sign" aria-hidden="true">
					Add Flights </span>
			</button>
			<button type="button" class="btn btn-success"
				onclick="location.href='./assignRunway';">
				<span class="glyphicon glyphicon-king" aria-hidden="true">
					Assign Runway </span>
			</button></div>
</div>
</div>

<div class="container">
<div class="row">
  <div class="col-lg-6">
  <div class="panel panel-default">
    <div class="panel-body" style="background: url(https://media1.giphy.com/media/LeoQs1lygBc1W/200_s.gif);background-size: cover;">
<form action="#">

<div class="input-group">
  <span class="input-group-addon" id="basic-addon1">PNR</span>
  <input type="text" class="form-control" placeholder="PNR" aria-describedby="basic-addon1">
</div>
<br>
<div class="input-group">
  <span class="input-group-addon" id="basic-addon1">Last Name</span>
  <input type="text" class="form-control" placeholder="Last Name" aria-describedby="basic-addon1">
</div>
<br>
<button type="button" class="btn btn-info"> <span class="glyphicon glyphicon-print" aria-hidden="true"> Print </span></button>
</form>
</div>
</div>
</div>
</div>
</div>

</body>
</html>