<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>End Page</title>
</head>
<body>
	
	<div class="header_resize">
      <div class="logo"><h1><a href="/parking_system/${role == 'MANAGER' ? 'listManager.jsp' : role == 'ADMIN' ? 'listAdmin.jsp' : 'listUser.jsp'}">Parking System</a></h1></div>
      <div class="menu_nav"></div>
	 </div>
	 
	 <br>
	 <h3> Your reservation booking has been made with Reference: ${ref} and SpotID: ${spotID}!! </h3>

</body>
</html>