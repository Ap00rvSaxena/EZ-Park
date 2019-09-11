<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Parking Spot</title>
</head>
<body>

	<div class="header_resize">
      <div class="logo"><h1><a href="/parking_system/listManager.jsp">Home</a></h1></div>
      <div class="menu_nav">
      </div>
  	</div>

     <div class="mainbar"><div class="submb"></div></div>
      
 <br>
 Search for parking spots:
 <br>
 <input name="sPSErrMsg"  value='${sPSErrMsg}' type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
 <br>
	 <form name="searchParkingSpotForm" action="/parking_system/ReservationController?action=searchSpot" method="post">
		  Search by Parking Spot ID: <br>
    	  	<input name="spotId" type="text" maxlength="45" style="width: 306px; "> 
			<input type="submit" value="Submit">		
	</form>
</body>
</html>