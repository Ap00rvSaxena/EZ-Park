<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>ReservationList</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
<body>
    <div class="header_resize">
      <div class="logo"><h1><a href="/parking_system/${role == 'MANAGER' ? 'listManager.jsp' : role == 'ADMIN' ? 'listAdmin.jsp' : 'listUser.jsp'}">Parking System</a></h1></div>
      <div class="menu_nav">
      </div>
  </div>

     <div class="mainbar"><div class="submb"></div></div>
      
      <input name="errMsg"  value="<c:out value='${errorMsgs.errorMsg}'/>" type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
       <form action="/parking_system/UserController?action=managerEditRevervation" method="post">
       <table class="myTable"> 
			<tr class="myTableRow">
				<th class="myTableHead" style="width: 12px; ">Select</th>
				<th class="myTableHead" style="width: 112px; ">Username</th> 
				<th class="myTableHead" style="width: 120px; ">Start Time</th>
				<th class="myTableHead" style="width: 120px; ">End Time</th>
				<th class="myTableHead" style="width: 70px; ">Permit</th>
				<th class="myTableHead" style="width: 200px; ">Parking Area</th>
				<th class="myTableHead" style="width: 12px; ">Floor</th>
				<th class="myTableHead" style="width: 110px; ">Parking Spot</th>
				<th class="myTableHead" style="width: 70px; ">Cancelled</th>
				<th class="myTableHead" style="width: 120px; ">Date</th>
				<th class="myTableHead" style="width: 70px; ">Violation</th>
				<th class="myTableHead" style="width: 120px; ">Vehicle Number</th>
				<th class="myTableHead" style="width: 12px; ">Cart</th>
				<th class="myTableHead" style="width: 12px; ">Camera</th>
				<th class="myTableHead" style="width: 12px; ">History</th>
				<th class="myTableHead" style="width: 63px; ">Payment</th>
			</tr>

 		<c:forEach items="${RESERS}" var="item">
			<tr class="myTableRow">
			<td><input type="radio" name="reservationSelected" value="${item.reservationid}"></td>
			<td class="myTableCell" style="width: 105px; "><c:out value="${item.username}" /></td>
			<td class="myTableCell" style="width: 130px; "><c:out value="${item.starttime}" /></td>
			<td class="myTableCell" style="width: 130px; "><c:out value="${item.endtime}" /></td>
			<td class="myTableCell" style="width: 130px; "><c:out value="${item.permit}" /></td>
			<td class="myTableCell" style="width: 200px; "><c:out value="${item.parkingarea}" /></td>
			<td class="myTableCell" style="width: 63px; "><c:out value="${item.floor}" /></td>
			<td class="myTableCell" style="width: 63px; "><c:out value="${item.parkingspot}" /></td>
			<td class="myTableCell" style="width: 63px; "><c:out value="${item.cancelled}" /></td>
			<td class="myTableCell" style="width: 200px; "><c:out value="${item.resvdate}" /></td>
			<td class="myTableCell" style="width: 63px; "><c:out value="${item.violation}" /></td>
			<td class="myTableCell" style="width: 200px; "><c:out value="${item.vehiclenumber}" /></td>
			<td class="myTableCell" style="width: 63px; "><c:out value="${item.cart}" /></td>
			<td class="myTableCell" style="width: 63px; "><c:out value="${item.camera}" /></td>
			<td class="myTableCell" style="width: 63px; "><c:out value="${item.history}" /></td>
			<td class="myTableCell" style="width: 63px; "><c:out value="${item.payment}" /></td>			
			</tr>
		</c:forEach>
 </table>
<input name="action" value="managerEditRevervation" type="hidden">
<input type="submit" value="${role == 'USER' ? 'Edit Reservation' : 'Mark Violation'}">

<input name="action" value="managerDeleteRevervation" type="hidden">
<input type="${role == 'USER' ? 'hidden' : 'submit'}" value="Delete Reservation"  formaction="/parking_system/UserController?action=managerDeleteRevervation">
</form>
</body>
</html>