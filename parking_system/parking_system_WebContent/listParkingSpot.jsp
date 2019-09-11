<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Parking Spot</title>
</head>
<body>

	<div class="header_resize">
      <div class="logo"><h1><a href="/parking_system/listManager.jsp">Home</a></h1></div>
      <div class="menu_nav">
      </div>
  	</div>

     <div class="mainbar"><div class="submb"></div></div>
      
 <br>
 Parking Spot Details:
 <br>
 
 	<table class="myTable"> 
			<tr class="myTableRow"> 
				<th class="myTableHead" style="width: 105px; ">PARKING-SPOT-ID</th>
				<th class="myTableHead" style="width: 74px; ">Spot No.</th> 
				<th class="myTableHead" style="width: 40px; ">Area Name</th>
				<th class="myTableHead" style="width: 63px; ">Parking_Type</th>
				<th class="myTableHead" style="width: 63px; ">Floor No.</th> 
				<th class="myTableHead" style="width: 63px; ">Availability</th>
			</tr>
			
				<tr class="myTableRow">
					<td class="myTableCell" style="width: 105px; "><c:out value="${PSPOT.parkingSpotID}" /></td>
					<td class="myTableCell" style="width: 74px; "><c:out value="${PSPOT.parkingspot}" /></td>
					<td class="myTableCell" style="width: 74px; "><c:out value="${PSPOT.parkingAreaName}" /></td>
					<td class="myTableCell" style="width: 74px; "><c:out value="${PSPOT.type}" /></td>
					<td class="myTableCell" style="width: 74px; "><c:out value="${PSPOT.floor}" /></td>
					<td class="myTableCell" style="width: 74px; "><c:out value="${PSPOT.availability}" /></td>
				</tr>
 		</table>
 		
	 <form name="toggleSpotForm" action="/parking_system/ReservationController?action=toggleSpot" method="post">
			<input name="pidtoggle" value="${PSPOT.parkingSpotID}" type="hidden">
			<input type="submit" value="Deactivate">		
	</form>
</body>
</html>