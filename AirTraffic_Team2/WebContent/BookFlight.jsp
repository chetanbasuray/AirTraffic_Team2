<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.AirTraffic.Team2.Models.BookingBean"%>
<%@page import="com.AirTraffic.Team2.Models.FlightBean"%>
<%@page import="com.AirTraffic.Team2.Models.LocationBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.AirTraffic.Team2.Servlets.BookFlightServlet"%>
<%@page import="com.itextpdf.text.Document"%>
<%@page import="com.itextpdf.text.DocumentException"%>
<%@page import="com.itextpdf.text.pdf.PdfWriter"%>
<%@page import="com.itextpdf.text.Paragraph"%>
<%@page import="com.itextpdf.text.Element"%>
<%@page import="java.io.FileOutputStream"%>


<jsp:useBean id="booking" scope="request"
	class="com.AirTraffic.Team2.Models.BookingBean" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>AirTraffic</title>
<link
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/ui-lightness/jquery-ui.css"
	rel="stylesheet" type="text/css" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>

<!-- <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script> -->
<script type="text/javascript">

$(document).ready(function() {
	$("#dateOfBirth").datepicker({
		dateFormat : "yy-mm-dd"
	});		
});
function yesnoCheck() {
    if (document.getElementById('newCheck').checked) {
        document.getElementById('ifNew').style.display = 'block';
        document.getElementById('ifExisting').style.display = 'none';
    }
    else {
    	document.getElementById('ifNew').style.display = 'none';
    	document.getElementById('ifExisting').style.display = 'block';
    }
}
</script>

</head>

<body>
	<a href="index.html">Home Page</a>
 <br>


	<form method="post" action="booking">
		New Customer<input type="radio" onclick="javascript:yesnoCheck();" name="yesno" value="new" id="newCheck"> 
        Existing Customer <input type="radio" checked="checked" onclick="javascript:yesnoCheck();" name="yesno" value="exists" id="existingCheck"><br>
    <div id="ifNew" style="display:none">
        First Name <input type='text' id='fname' name='firstName'><br>
        Last Name  <input type='text' id='lname' name='lastName'>
        Gender <select name="genderDdl">				
				<option value="Male">Male</option>
				<option value="Female">Female</option>				
			    </select>
	    Customer ID<input type='text' id='newCustID' name='newCustomerID'><br> 
	    ID Type <select name="idTypeDdl">				
				<option value="PASSPORT">PASSPORT</option>
				<option value="DRIVING LICENCE">DRIVING LICENCE</option>	
				<option value="Other">Other</option>			
			    </select>
	    Date of Birth <input type='text' id='dateOfBirth' name='dob'><br>
        Mobile<input type='text' id='custMobile' name='custMobile'>
        Email<input type='text' id='custEmail' name='custEmail'>
        Telephone<input type='text' id='custTelephone' name='custTelephone'>
        Address Line 1 <input type='text' id='custAdl1' name='custAdl1'>
        Address Line 2 <input type='text' id='custAdl2' name='custAdl2'>
        City <input type='text' id='custCity' name='custCity'>
        State  <input type='text' id='custState' name='custState'>
        Zipcode <input type='text' id='custZipcode' name='custZipcode'>
        Country <input type='text' id='custCountry' name='custCountry'>
        Submit <input type='submit' id='custdetails' name='custdetails'>
        
    </div>
    
    <div id="ifExisting" style="display:block">   
        Customer ID<input type='text' id='existingCustID' name='existingCustomerID'><br> 
        <input type="submit" value="View My Data">    
        </form>         
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
								  } else {
								%>
								<tr>
									<th>Flight Name</th>
									<th>Departure Time</th>
									<th>Arrival Time</th>
									<th>Departure Airport</th>
									<th>Arrival Airport</th>
									<th>Departure Date</th>
									<th>Arrival Date</th>
									<th>Flight Price</th>
								</tr>
								<%
								  List<FlightBean> flightList = (List<FlightBean>) session.getAttribute("flight");

								    for (int i = 0; i < flightList.size(); i++) {
								%>
								<tr>

									<td><%=flightList.get(i).getFlight_Id()%></td>
									<td><%=flightList.get(i).getFlight_scheduled_departure_time()%></td>
									<td><%=flightList.get(i).getFlight_scheduled_arrival_time()%></td>
									<td><%=flightList.get(i).getFlightSegmentBean().getOriginAirport().getAirport_iata()%></td>
									<td><%=flightList.get(i).getFlightSegmentBean().getDestinationAirport()
              .getAirport_iata()%></td>
									<td><%=flightList.get(i).getDepartureDate()%></td>
									<td><%=flightList.get(i).getArrivalDate()%></td>
<td><%=flightList.get(i).getFlight_price()%></td>
								</tr>
								<%
								  }
								%>
								<%-- <%								
									
									  Document document = new Document();
									  PdfWriter.getInstance(document, new FileOutputStream("//home//adnan//Downloads//testpdf1.pdf"));
								      document.open();       
									  for (int i = 0; i < flightList.size(); i++) {
										 document.add(new Paragraph("Flight ID ::"+flightList.get(i).getFlight_Id()
										                           +"\n Departure Day ::"+flightList.get(i).getDepartureDay()
										                           +"\n Arrival Day ::"+flightList.get(i).getArrivalDay()));											 
										} 					
									%> --%>


							</table>
						</div>

					</table>
			</td>
		</tr>
	</table>

	<br>

	</div>

	<%
	  if (request.getAttribute("personDetails") != null
	        && !request.getAttribute("personDetails").equals("")) {
	      List<BookingBean> bookPersonDetail =
	          (ArrayList<BookingBean>) request.getAttribute("personDetails");
	%>
	<form role="form" action="bookticket" method="post">
		<input type="text" style="display: none"
			value="<%=flightList.get(0).getFlight_Id()%>" name="flightId" />
			<input type="text" style="display: none"
			value="<%=flightList.get(0).getFlight_price()%>" name="flightPrice" /> <input
			type="text" style="display: none"
			value="<%=bookPersonDetail.get(0).getPersonBean().getPerson_id()%>"
			name="personId">
			<div class="form-group">
            <label for="paymentMethod">Choose your payment method</label>

            <select class="form-control" name="paymentMethod">
				<!-- TODO populate universities from database -->
              <option value="1" selected>CREDIT CARD</option>
              <option value="2" >DEBIT CARD</option>
              <option value="4" >NET BANKING</option>
            </select>
          </div>
          <div class="form-group">
            <label for="currency">Choose your type of currency</label>

            <select class="form-control" name="currency">
				<!-- TODO populate universities from database -->
              <option value="2" selected>EUR</option>
              <option value="1" >USD</option>
               <option value="3" >GBP</option>
              <option value="4" >INR</option>
            </select>
          </div>
			 <input type="submit" value="Book">
		<%
		  }
		%>
	</form>
	<%
	  }
	%>
</body>


</html>