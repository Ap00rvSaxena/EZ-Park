<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Update Reservation of User</title>
</head>
<body>
<div class="header_resize">
      <div class="logo"><h1><a href="/parking_system/${role == 'MANAGER' ? 'listManager.jsp' : role == 'ADMIN' ? 'listAdmin.jsp' : 'listUser.jsp'}">Parking System</a></h1></div>
      <div class="menu_nav">
      </div>
</div>	
	<input name="errMsg"  value='${errorMsgs.errorMsg}' type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
	<form name="userForm" action="/parking_system/UserController?editUserProfile" method="post">
	
	
	<table style="width: 1200px; ">
	
    <tr>
    <td> Reservation ID: </td>
    <td><input name="reservationid" value='${UPDATERESER.reservationid}' type="text" disabled></td>
    </tr>

    <tr>
    <td> Username: </td>
    <td><input name="username" value='${UPDATERESER.username}' type="text" disabled></td>
    </tr>
    
    <tr>
    <td> Start time: </td>
    <td><input name="starttime" value='${UPDATERESER.starttime}' type="text" disabled></td>
    </tr>
    
    <tr>
    <td> End time: </td>
    <td><input name="endtime" value='${UPDATERESER.endtime}' type="text" disabled></td>
    </tr>
    
    <tr>
    <td> Permit: </td>
    <td><input name="permit" value='${UPDATERESER.permit}' type="text" disabled></td>
    </tr>
    
    <tr>
    <td> Parking Area: </td>
    <td><input name="parkingarea" value='${UPDATERESER.parkingarea}' type="text" disabled></td>
    </tr>
    
    <tr>
    <td> Parking Floor: </td>
    <td><input name="floor" value='${UPDATERESER.floor}' type="text" disabled></td>
    </tr>
    
    <tr>
    <td> Parking Spot: </td>
    <td><input name="parkingspot" value='${UPDATERESER.parkingspot}' type="text" disabled></td>
    </tr>
    
    <tr>
    <td> Status (*): </td>
    <td><select name="cancelled">
  			<option value="1" ${UPDATERESER.cancelled eq '1' ? 'selected' : ''}>Cancelled</option>
  			<option value="0" ${UPDATERESER.cancelled eq '0' ? 'selected' : ''}>Active</option>
		</select></td>
    </tr>
    
    <tr>
    <td> Reservation Date: </td>
    <td> <input name="resvdate" value='${UPDATERESER.resvdate}' type="text" disabled></td>
    </tr>
    
    <tr>
    <td> Vehicle Number: </td>
    <td> <input name="vehiclenumber" value='${UPDATERESER.vehiclenumber}' type="text"></td>
    </tr>
    
    <tr>
    <td> Violation (*): </td>
    <td><select name="violation" ${role == 'USER' ? 'disabled' : ''}>
  			<option value="NULL" ${UPDATERESER.violation eq 'NULL' ? 'selected' : ''}>None</option>
  			<option value="NOSHOW" ${UPDATERESER.violation eq 'NOSHOW' ? 'selected' : ''}>NOSHOW</option>
  			<option value="OVERDUE" ${UPDATERESER.violation eq 'OVERDUE' ? 'selected' : ''}>OVERDUE</option>
		</select></td>
    </tr>
    
    <tr>
    <td> Cart: </td>
    <td><select name="cart" >
  			<option value="1" ${UPDATERESER.cart eq '1' ? 'selected' : ''}>Selected</option>
  			<option value="0" ${UPDATERESER.cart eq '0' ? 'selected' : ''}>Not Selected</option>
		</select>
		</td> 
    </tr>
    
    <tr>
    <td> Camera: </td>
    <td> <select name="camera" >
  			<option value="1" ${UPDATERESER.camera eq '1' ? 'selected' : ''}>Selected</option>
  			<option value="0" ${UPDATERESER.camera eq '0' ? 'selected' : ''}>Not Selected</option>
		</select></td>
    </tr>
    
    <tr>
    <td> History: </td>
    <td> <select name="history">
  			<option value="1" ${UPDATERESER.history eq '1' ? 'selected' : ''}>Selected</option>
  			<option value="0" ${UPDATERESER.history eq '0' ? 'selected' : ''}>Not Selected</option>
		</select></td>
    </tr>
    
    <tr>
    <td> Payment: </td>
    <td> <input name="payment" value='${UPDATERESER.payment}' type="text" disabled></td>
    </tr>
    

    <tr>
    <td colspan="2">(*) Mandatory field</td>
    </tr>
    
    </table>
    <input name="action" value="updateReservationInDB" type="hidden">
    <input type="submit" value="Update Reservation">
	
	</form>
</body>
</html>