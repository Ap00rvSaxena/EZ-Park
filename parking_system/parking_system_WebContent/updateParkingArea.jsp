<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Update Parking Area </title>
</head>
<body>
<div class="header_resize">
      <div class="logo"><h1><a href="/parking_system/${role == 'MANAGER' ? 'listManager.jsp' : 'listUser.jsp'}">Home</a></h1></div>
      <div class="menu_nav">
      </div>
  	</div>
	
	<input name="errMsg"  value='${errorMsgs.errorMsg}' type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
	<form name="userForm" action="/parking_system/ParkingAreaController?updateParkingAreaInDB" method="post">
	
	
	<table style="width: 1200px; ">
	
   

    <tr>
    <td> Parking Area Name (*): </td>
    <td> <input name="parking_area_name" value='${UPDATEParkingArea.parking_area_name}' type="text" maxlength="45">  </td>
    <td> <input name="userFirstNameError"  value='${errorMsgs.parkingAreaNameError}' type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>    </tr>
    
    
     <tr>
 	<td> Type(*): </td>	
      <td><select name="type">
  			<option value="BASIC">BASIC</option>
  			<option value="MIDRANGE">MIDRANGE</option>
  			<option value="PREMIUM">PREMIUM</option>
  			<option value="ACCESS">ACCESS</option>
		</select>
    </tr>
    
    <tr>
    <td> floor (*): </td>
    <td> <input name="floor" value='${UPDATEParkingArea.floor}' type="text" maxlength="45">  </td>
    <td> <input name="floor"  value='${errorMsgs.floorError}' type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>    </tr>
   
   
    
    
    <tr>
    <td> Capacity (*): </td>
    <td> <input name="capacity" value='${UPDATEParkingArea.capacity}' type="text" maxlength="45">  </td>
    <td> <input name="capacity"  value='${errorMsgs.capacityError}' type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>    </tr>
   
    </tr>

    <tr>
    <td> Reserved (*): </td>
    <td> <input name="reserved" value='${UPDATEParkingArea.reserved}' type="text" maxlength="45">  </td>
    <td> <input name="reserved"  value='${errorMsgs.reservedErro}' type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>    </tr>
    
    </tr>
    
   <tr>
    <td> Available (*): </td>
    <td> <input name="available" value='${UPDATEParkingArea.available}' type="text" maxlength="45">  </td>
    <td> <input name="available"  value='${errorMsgs.availableError}' type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>    </tr>
    
    </tr>
    
    
    </table>
    <input name="action" value="updateParkingAreaInDB" type="hidden">
    <input type="submit" value="Update Details">
	
	</form>
</body>
</html>