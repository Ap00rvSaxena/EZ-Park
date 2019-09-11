<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>ParkingArea List</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
<body>
    <div class="header_resize">
      <div class="logo"><h1><a href="/parking_system/${role == 'MANAGER' ? 'listManager.jsp' : 'listAdmin.jsp'}">Parking System</a></h1></div>
      <div class="menu_nav">
      </div>
  </div>

     <div class="mainbar"><div class="submb"></div></div>
	<input name="searchMsg" id="searchMsg" value='${searchMsg}' type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
	<form action="/parking_system/ParkingAreaController?action=EditParkingArea" method="post">
  <table class="myTable"> 
			<tr class="myTableRow">
				<th class="myTableHead" style="width: 12px; ">Select</th>
				<th class="myTableHead" style="width: 123px; ">Parking Area Name</th>
				<th class="myTableHead" style="width: 112px; ">Type</th> 
				<th class="myTableHead" style="width: 130px; ">Floor</th>
				<th class="myTableHead" style="width: 130px; ">Capacity</th> 
				<th class="myTableHead" style="width: 130px; ">Reserved</th>
				<th class="myTableHead" style="width: 130px; ">Available</th>
			</tr>

 		<c:forEach items="${ParkingArea}" var="item">
			<tr class="myTableRow">
			<td><input type="radio" name="select" value="${item.parking_area_name},${item.type},${item.floor},${item.capacity},${item.available}">
			<td class="myTableCell" style="width: 105px; "><c:out value="${item.parking_area_name}" /></td>
			<td class="myTableCell" style="width: 105px; "><c:out value="${item.type}" /></td>
			<td class="myTableCell" style="width: 130px; "><c:out value="${item.floor}" /></td>
			<td class="myTableCell" style="width: 130px; "><c:out value="${item.capacity}" /></td>
			<td class="myTableCell" style="width: 130px; "><c:out value="${item.reserved}" /></td>
			<td class="myTableCell" style="width: 130px; "><c:out value="${item.available}" /></td>
			</tr>
		</c:forEach>
 </table>
 <input name="action" value="EditParkingArea" type="hidden">
<input type="submit" value="Edit Parking Area" formaction="/parking_system/ParkingAreaController?action=EditParkingArea">
 
 </form>
</body>
</html>