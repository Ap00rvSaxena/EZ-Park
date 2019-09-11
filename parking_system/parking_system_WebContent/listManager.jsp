<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manager Page</title>
</head>
<body>

	<div class="header_resize">
      <div class="logo"><h1><a href=".">Parking Management System Home</a></h1></div>
      <div class="menu_nav"></div>
	</div>
	
	 <input id="greetingField" value='${greetingField1}' style ="background-color: white; border: none; width: 400px;" disabled="disabled" />
	 <br>
	 <p> Choose among the options: </p>
	 <br>
	 
	 <ul>
          <li><a href="searchUser.jsp"  target="_top"><span>Search User</span></a></li>
          <li><a href="/parking_system/UserController?action=searchForParkings"  target="_top"><span>View Parking Spaces</span></a></li>
          <li><a href="searchParkingSpot.jsp"  target="_top">View/Modify Parking Spot<span></span></a></li>
          <li><a href="/parking_system/UserController?action=userEditProfile"  target="_top"><span>View/Edit Profile</span></a></li>
          <li><a href="addParkingArea.jsp"  target="_top"><span>Add Parking Area</span></a></li>
          <li><a href="/parking_system/ParkingAreaController?action=searchParkingArea"  target="_top"><span>Modify Parking area</span></a></li>
          <li><a href="/parking_system/UserController?action=logoutUser"  target="_top"><span>Log Out</span></a></li>
     </ul>
	 

</body>
</html>