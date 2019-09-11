<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Parking Page</title>
</head>
<body>

	<div class="header_resize">
      <div class="logo"><h1><a href="/parking_system/${role == 'MANAGER' ? 'listManager.jsp' : 'listUser.jsp'}">Home</a></h1></div>
      <div class="menu_nav">
      </div>
  	</div>

     <div class="mainbar"><div class="submb"></div></div>
      
 <br>
 Search for Available parking spots:
<input name="rErrMsg"  value='${rErrorMsgs.errorMsg}' type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
 <br>
	 <form name="searchParkingForm" action="/parking_system/ReservationController?action=searchP" method="post">
	 <table>
	  <tr>
	    <td> Beginning Time: </td>
	    <td>
	    	<input type="time" id="starttime" name="starttime"
	       	min="0:30" max="23:30" step="900" required>
	    </td>
	    
	    <td> End Time: </td>
	    <td>
	    	<input type="time" id="endtime" name="endtime" min="1:00" max="23:45" step="900" required>
	    </td>
	    
	    <td>
	    <input name="action" value="searchP" type="hidden">
	    <input type="submit" value="Search Parking">
	    <td>
	    
	  </tr>
	 
	 </table><input name="timeError" value="${rErrorMsgs.timeError}" type="text" style="background-color: white; color: red; border: none; width: 1500px" disabled="disabled" maxlength="60">
	</form>
</body>
</html>