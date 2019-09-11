<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>SearchParkingArea</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
<body>
      <div class="logo"><h1><a href="/parking_system/${role == 'MANAGER' ? 'listManager.jsp' : 'listAdmin.jsp'}">Parking System</a></h1></div>
      <div class="menu_nav">
  </div>
<input name="errMsg"  value="<c:out value='${errorMsgs.errorMsg}'/>" type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
<table>
<tr>
	<td>
	<form action="/parking_system/ParkingAreaController?action=searchParkingArea" method="post">
	<table style="width: 120px; ">
	<tr>
	<tr>
  	<td> Search: </td>
    <td> <input name="search" value='${user.search}' type="text" maxlength="45" style="width: 306px; ">  </td>
  	<td> <input name="searchError"  value='${errorMsgs.searchError}' type="text"  style ="background-color: white; color: red; border: none; width: 322px"  disabled="disabled" maxlength="60"> </td>
    </tr>
    
</table>
  <input type="submit" value="Submit">
	</form>      
</td>
</tr>
</table>
</body>
</html>