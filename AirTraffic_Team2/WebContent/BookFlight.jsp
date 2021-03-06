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
<script src="Web Pages/gen_validatorv4.js"> </script> 
<script type="text/javascript">

$(document).ready(function() {
	$("#dateOfBirth").datepicker({
		dateFormat : "yy-mm-dd"
	});
	yesnoCheck();
});
function yesnoCheck() {
	
    if (document.getElementById('newCheck').checked) {
        document.getElementById('ifNew').style.display = 'block';
        document.getElementById('ifExisting').style.display = 'none';
        if(document.getElementById('ifNewAdded')!=null)
        	document.getElementById('ifNewAdded').style.display = 'block';
    }
    else {
    	document.getElementById('ifNew').style.display = 'none';
    	
    	if(document.getElementById('ifNewAdded')!=null)
        	document.getElementById('ifNewAdded').style.display = 'none';
    
    	document.getElementById('ifExisting').style.display = 'block';
    }
}
</script>

</head>

<body>
	
	
	
									
		New Customer<input type="radio" <%
										if (request.getAttribute("existingTab") == null) {
											
										
									%>checked="checked"<%} %> onclick="javascript:yesnoCheck();" name="yesno" id="newCheck" value="new"> 
        Existing Customer <input type="radio" <%
										if (request.getAttribute("existingTab") != null) {
											
										
									%>checked="checked"<%} %>onclick="javascript:yesnoCheck();" name="yesno" id="existingCheck" value="existing"><br>
    
    <form method="post" id="bookFlightForm" action="booking">
    <input type="text" name="yesno" value="new" style="display:none">
    <div id="ifNew" style="display:block">
        <div id='bookFlightForm_firstName_errorloc' style="color: red;" class='error_strings'>
                       </div><br>
        First Name <input type='text' id='firstName' name='firstName'><br>
        <div id='bookFlightForm_lastName_errorloc' style="color: red;" class='error_strings'>
                       </div><br>
        Last Name  <input type='text' id='lastName' name='lastName'>
        Gender <select name="genderDdl">				
				<option value="Male">Male</option>
				<option value="Female">Female</option>				
			    </select>
	    <div id='bookFlightForm_newCustomerID_errorloc' style="color: red;" class='error_strings'>
                       </div><br>
	    Customer ID<input type='text' id='newCustomerID' name='newCustomerID'><br> 
	    ID Type <select name="idTypeDdl">				
				<option value="PASSPORT">PASSPORT</option>
				<option value="DRIVING LICENCE">DRIVING LICENCE</option>	
			    </select>
	    <div id='bookFlightForm_dateOfBirth_errorloc' style="color: red;" class='error_strings'>
                       </div><br>
	    Date of Birth <input type='text' id='dateOfBirth' name='dob'><br>
	    
	    <div id='bookFlightForm_custMobile_errorloc' style="color: red;" class='error_strings'>
                       </div><br>
        Mobile<input type='text' id='custMobile' name='custMobile'>
        
        <div id='bookFlightForm_custEmail_errorloc' style="color: red;" class='error_strings'>
                       </div><br>
        Email<input type='text' id='custEmail' name='custEmail'>
        
        Telephone<input type='text' id='custTelephone' name='custTelephone'>
        Address Line 1 <input type='text' id='custAdl1' name='custAdl1'>
        Address Line 2 <input type='text' id='custAdl2' name='custAdl2'>
        City <input type='text' id='custCity' name='custCity'>
        State  <input type='text' id='custState' name='custState'>
        
        <div id='bookFlightForm_custZipcode_errorloc' style="color: red;" class='error_strings'>
                       </div><br>
        Zipcode <input type='text' id='custZipcode' name='custZipcode'>
        
        <div id='bookFlightForm_custCountry_errorloc' style="color: red;" class='error_strings'>
                       </div><br>
        Country <input type='text' id='custCountry' name='custCountry'>

<br><input type="submit" value="Add My Details">
              </form>  
    </div>
		

	
<% if (request.getAttribute("error") != null) {
%>
<h3>No Customer Found</h3>
<%=request.getAttribute("error")%>
<%
} 
else {

		
 String newCustAddedSuccessfully = request.getAttribute("newCustAdded").toString();

	if(newCustAddedSuccessfully.equals("Yes")) { %>    
	<div id="ifNewAdded" style="display:block">   
        <h3>Customer Added Successfully</h3>                     
		<h1 align="center">Customer Details</h1>
		<table width="600" height="300" align=center cellspacing=0 border="0"
			cellpadding=0>
			<tr>
				<td>
					<fieldset id="fieldhead">
						<legend>Customer Information</legend>

						<table align=center cellspacing=1 cellpadding=3>

							<div align="center">
								<table border="1" cellpadding="5">
									<caption>
										<h2>Details of Customer</h2>
									</caption>
									<%
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
 						<% } %>
						</table>
				</td>
			</tr>
		</table>
</div>
	
	    
    <div id="ifExisting" style="display:none">   
    <form method="post" action="booking">
        Customer ID<input type='text' id='existingCustID' name='existingCustomerID'><br> 
  		<input type="text" name="yesno" value="existing" style="display:none">
  		<input type="submit" value="View My Details" id="ViewCust">                   
		</form>
		<h1 align="center">Customer Details</h1>

		<table width="600" height="300" align=center cellspacing=0 border="0"
			cellpadding=0>
			<tr>
				<td>
					<fieldset id="fieldhead">
						<legend>Customer Information</legend>

						<table align=center cellspacing=1 cellpadding=3>

							<div align="center">
								<table border="1" cellpadding="5">
									<caption>
										<h2>Details of Customer</h2>
									</caption>
									<%
										if (request.getAttribute("error") != null) {
									%>
									<h3>No Customer Found</h3>
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
</div>
		</form><br>


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
								
								<tr>
									<th>Flight Name</th>
									<th>Departure Time</th>
									<th>Arrival Time</th>
									<th>Departure Airport</th>
									<th>Arrival Airport</th>
									<th>Departure Date</th>
								    <!-- <th>Arrival Date</th>  -->
									<th>Flight Price</th>
									<th>Seat Class</th>
								</tr>
								<%
								List<FlightBean> flightList = (List<FlightBean>) session.getAttribute("flight");
								//String flightId=null;
								//if (request.getParameterMap().containsKey("flightId")) {
								//flightId = request.getParameter("flightId").trim();
							   	//}
								    for (int i = 0; i < flightList.size(); i++) {
								//if(flightList.get(i).getFlight_Id().equals(flightId)){
								%>
								<tr>

									<td><%=flightList.get(i).getFlight_Id()%></td>
									<td><%=flightList.get(i).getFlight_scheduled_departure_time()%></td>
									<td><%=flightList.get(i).getFlight_scheduled_arrival_time()%></td>
									<td><%=flightList.get(i).getFlightSegmentBean().getOriginAirport().getAirport_iata()%></td>
									<td><%=flightList.get(i).getFlightSegmentBean().getDestinationAirport()
              .getAirport_iata()%></td>
									<td><%=flightList.get(i).getDepartureDate()%></td>
									<%-- <td><%=flightList.get(i).getArrivalDate()%></td> --%> 
<td><%=flightList.get(i).getFlight_price()%></td>
<td><%=flightList.get(i).getSeatClass()%></td>
								</tr>
								<%
								//}
								}
								%>
								</table>
							</div>
						</table>
				</td>
			</tr>
		</table>
		<br>
     
  
							</table>
						</div>

					</table>
			</td>
		</tr>
	</table>

	<br>

	</div>

	<%
	if (request.getAttribute("error") != null) {

	} else {

	  if (request.getAttribute("personDetails") != null
	        && !request.getAttribute("personDetails").equals("")) {
	    List<FlightBean> flightList1 = (List<FlightBean>) session.getAttribute("flight");
	    List<BookingBean> bookPersonDetail =
	          (ArrayList<BookingBean>) request.getAttribute("personDetails");
	    for (int i = 0; i < flightList.size(); i++) {
			//if(flightList.get(i).getFlight_Id().equals(flightId)){
			%>
	<form role="form" action="bookTicket" method="post">
		<input type="text" style="display: none"
			value="<%=flightList.get(i).getFlight_Id()%>" name="flightId" />
			<input type="text" style="display: none"
			value="<%=flightList.get(i).getSeatClass()%>" name="seatClass" />
			<input type="text" style="display: none"
			value="<%=flightList.get(i).getFlight_price()%>" name="flightPrice" />
			<input type="text" style="display: none"
			value="<%=flightList.get(i).getDepartureDate().toString()%>" name="journeyDate" />
			<input
			type="text" style="display: none"
			value="<%=bookPersonDetail.get(i).getPersonBean().getPerson_id()%>"
			name="personId">
			<input
			type="text" style="display: none"
			value="<%=bookPersonDetail.get(i).getPersonBean().getPerson_lname()%>"
			name="lastname">
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
			}}}
		%>
	</form>

<script language="JavaScript" type="text/javascript">
  var frmvalidator  = new Validator("bookFlightForm");
  
  frmvalidator.EnableOnPageErrorDisplay();
  frmvalidator.EnableMsgsTogether();
  
  
  frmvalidator.addValidation("custEmail","maxlen=50"); 
  frmvalidator.addValidation("custEmail","req"); 
  frmvalidator.addValidation("custEmail","email");
  
  frmvalidator.addValidation("newCustomerID","req","Please enter valid CustomerID");
  frmvalidator.addValidation("newCustomerID","maxlen=20","For CustomerID, Max length is 30"); 
  
  frmvalidator.addValidation("firstName","req","Please enter First Name");
  frmvalidator.addValidation("firstName","maxlen=20","For First Name, Max length is 30"); 
  
  frmvalidator.addValidation("lastName","req","Please enter Last Name");
  frmvalidator.addValidation("lastName","maxlen=20","For Last Name, Max length is 30"); 
  
  frmvalidator.addValidation("dateOfBirth","req","Please enter valid dateOfBirth");
  frmvalidator.addValidation("dateOfBirth","maxlen=20","For dateOfBirth, Max length is 30"); 
  
  frmvalidator.addValidation("custZipcode","req","Please enter valid Zipcode");
  frmvalidator.addValidation("custZipcode","maxlen=20","For Zipcode, Max length is 20");
  
  frmvalidator.addValidation("custCountry","req","Please enter Country name");
  frmvalidator.addValidation("custCountry","maxlen=20","For Country, Max length is 20");
  
  frmvalidator.addValidation("custMobile","req","Please enter Mobile number");
  frmvalidator.addValidation("custMobile","maxlen=20","For Mobile, Max length is 20");
  
</script>
</body>
</html>