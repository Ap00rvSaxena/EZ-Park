<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User page</title>
</head>
<body>
	
	<div class="header_resize">
      <div class="logo"><h1><a href=".">Parking Management System Home</a></h1></div>
      <div class="menu_nav"></div>
	 </div>
	 
	 <input id="greetingField1" value='${greetingField1}' style ="background-color: white; border: none; width: 400px;" disabled="disabled" /><br>
	 <input id="greetingField2" value='${greetingField2}' style ="background-color: white; color: red; border: none; width:800px" disabled="disabled"/>
	 <br>
	 <p> Choose among the options: </p>
	 <ul>
          <li><a href="/parking_system/UserController?action=searchForParkings"  target="_top"><span>Request Reservation</span></a></li>
          <li><a href="/parking_system/UserController?action=viewReservationList"  target="_top"><span>View/Modify Reservations</span></a></li>
          <li><a href="/parking_system/UserController?action=userEditProfile"  target="_top">View/Edit Profile<span></span></a></li>
          <li><a href="/parking_system/UserController?action=viewStatus"  target="_top">View Status<span></span></a> <input id="statusField" value='${statusField}' style ="background-color: white; border: none; width: 400px;" disabled="disabled" /></li>
          <li><a href="/parking_system/UserController?action=viewReservationList"  target="_top"><span>View No-Show</span></a></li> 
          <li><a href="/parking_system/UserController?action=logoutUser"  target="_top"><span>Log Out</span></a></li>
     </ul>

</body>
</html>