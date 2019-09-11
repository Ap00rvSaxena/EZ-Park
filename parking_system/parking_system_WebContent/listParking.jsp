<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Available Parkings</title>
</head>
<body>

	<div class="header_resize">
      <div class="logo"><h1><a href="/parking_system/listUser.jsp">Home</a></h1></div>
      <div class="menu_nav">
      </div>
  	</div>
  	
  	<div class="mainbar"><div class="submb"></div></div>
  	<input name="rErrMsg"  value='${rErrorMsgs.errorMsg}' type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
  		<form id="listParkingForm" action="/parking_system/ReservationController?action=finalPayment" method="POST">
  		
  		<table class="myTable"> 
			<tr class="myTableRow"> 
				<th class="myTableHead" style="width: 105px; ">PARKING-AREA</th>
				<th class="myTableHead" style="width: 74px; ">Type</th> 
				<th class="myTableHead" style="width: 40px; ">Floor</th>
				<th class="myTableHead" style="width: 40px; ">Capacity</th>
				<th class="myTableHead" style="width: 63px; ">Available</th> 
				<th class="myTableHead" style="width: 63px; ">SELECT</th> 
			</tr>
			
	 		<c:forEach items="${PARKINGS}" var="item">
				<tr class="myTableRow">
					<td class="myTableCell" style="width: 105px; "><c:out value="${item.parkingAreaName}" /></td>
					<td class="myTableCell" style="width: 74px; "><c:out value="${item.type}" /></td>
					<td class="myTableCell" style="width: 40px; "><c:out value="${item.floor}" /></td>
					<td class="myTableCell" style="width: 40px; "><c:out value="${item.capacity}" /></td>
					<td class="myTableCell" style="width: 63px; "><c:out value="${item.available}" /></td>
					<td><input type="radio" name="select" style = "visibility: ${role == 'MANAGER' ? 'hidden' : 'none'}" value="${item.parkingAreaName},${item.type},${item.floor},${item.capacity},${item.available}"></td>
				</tr>
			</c:forEach>
 		</table>
 		<div class="submb" style = "visibility: ${role == 'MANAGER' ? 'hidden' : 'none'}">
 		<input name="timeError" value="${rErrorMsgs.permitError}" type="text" style="background-color: white; color: red; border: none; width: 1500px" disabled="disabled" maxlength="60">
 		<br>
 		<b> Choose options and confirm parking:</b>
 		
		  <input type="checkbox" name="optionsv" value="hist" > History
		  <input type="checkbox" name="optionsv" value="cart"> Cart
		  <input type="checkbox" name="optionsv" value="cam"> Camera<br>
		  <input type="submit" value="Reserve">
 		</div>
		</form>
 		
</body>
</html>