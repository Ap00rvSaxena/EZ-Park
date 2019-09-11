<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Update Manager Profile</title>
</head>
<body>
<div class="header_resize">
      <div class="logo"><h1><a href="/parking_system/listAdmin.jsp">Parking Management System Home</a></a></h1></div>
      <div class="menu_nav">
      </div>
	
	<input name="errMsg"  value='${errorMsgs.errorMsg}' type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
	<form name="userForm" action="/parking_system/UserController?editUserProfile" method="post">
	
	
	<table style="width: 1200px; ">
	
    <tr>
    <td> Username(*): </td>
    <td> <input name="username" value='${UPDATEUSER.username}' type="text" maxlength="16" readonly> </td>
    </tr>

    <tr>
    <td> First Name (*): </td>
    <td> <input name="firstName" value='${UPDATEUSER.firstName}' type="text" maxlength="45">  </td>
 	<td> <input name="userFirstNameError"  value='${errorMsgs.userFirstNameError}' type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <tr>
    <td> Last Name (*): </td>
    <td> <input name="lastName" value='${UPDATEUSER.lastName}' type="text" maxlength="45">  </td>
 	<td> <input name="userLastNameError"  value='${errorMsgs.userLastNameError}' type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <tr>
    <td> Email (*): </td>
    <td> <input name="email" value='${UPDATEUSER.email}' type="text" maxlength="45">  </td>
  	<td> <input name="userEmailError"  value='${errorMsgs.userEmailError}' type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <tr>
    <td> Password (*): </td>
    <td> <input name="password" value='${UPDATEUSER.password}' type="text" maxlength="45">  </td>
  	<td> <input name="userPasswordError"  value='${errorMsgs.userPasswordError}' type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <tr>
    <td> Role (*): </td>
    <td><select name="role" >
  			<option value="USER" ${UPDATEUSER.role eq 'USER' ? 'selected' : ''}>USER</option>
  			<option value="MANAGER" ${UPDATEUSER.role eq 'MANAGER' ? 'selected' : ''}>MANAGER</option>
  			<option value="ADMIN" ${UPDATEUSER.role eq 'ADMIN' ? 'selected' : ''}>ADMIN</option>
		</select></td>
    </tr>
    
    <tr>
    <td> UTA ID (*): </td>
    <td> <input name="utaid" value='${UPDATEUSER.utaid}' type="text" maxlength="45">  </td>
  	<td> <input name="utaIDerror"  value='${errorMsgs.utaIDerror}' type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <tr>
    <td> Phone: </td>
    <td> <input name="phone" value='${UPDATEUSER.phone}' type="text" maxlength="16">  </td>
  	<td> <input name="phoneError"  value='${errorMsgs.phoneError}' type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <tr>
    <td> Street Address (*): </td>
    <td> <input name="streetaddress" value='${UPDATEUSER.streetaddress}' type="text" maxlength="45">  </td>
  	<td> <input name="streetAddError"  value='${errorMsgs.streetAddError}' type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <tr>
    <td> City (*): </td>
    <td> <input name="city" value='${UPDATEUSER.city}' type="text" maxlength="45">  </td>
  	<td> <input name="cityError"  value='${errorMsgs.cityError}' type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <tr>
    <td> State: (*)</td>
    <td> <input name="state" value='${UPDATEUSER.state}' type="text" maxlength="45">  </td>
  	<td> <input name="stateError"  value='${errorMsgs.stateError}' type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <tr>
    <td> Zip code (*): </td>
    <td> <input name="zipcode" value='${UPDATEUSER.zipcode}' type="text" maxlength="45">  </td>
  	<td> <input name="zipCodeError"  value='${errorMsgs.zipCodeError}' type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <tr>
    <td>Status: </td>
    <td><select name="status" >
  			<option value="1" ${UPDATEUSER.status eq 1 ? 'selected' : ''}>Active</option>
  			<option value="0" ${UPDATEUSER.status eq 0 ? 'selected' : ''}>Revoked</option>
		</select></td>
    </tr>
    
    <tr>
    <td>Comments: </td>
	<td> <input name="comments" value='${UPDATEUSER.comments}' type="text" maxlength="45">  </td>
 <!--  	<td> <input name="commentError"  value='${errorMsgs.streetAddError}' type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td> -->
    </tr>
    
    <tr>
    <td> Vehicle Number (*): </td>
    <td> <input name="vehiclenumber" value='${UPDATEUSER.vehiclenumber}' type="text" maxlength="45">  </td>
  	<td> <input name="vehicleNumberError"  value='${errorMsgs.vehicleNumberError}' type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <tr>
    <td> Permit: </td>
    <td><select name="permit" >
  			<option value="BASIC" ${UPDATEUSER.permit eq 'BASIC' ? 'selected' : ''}>BASIC</option>
  			<option value="MIDRANGE" ${UPDATEUSER.permit eq '"MIDRANGE"' ? 'selected' : ''}>MIDRANGE</option>
  			<option value="PREMIUM" ${UPDATEUSER.permit eq 'PREMIUM' ? 'selected' : ''}>PREMIUM</option>
  			<option value="ACCESS" ${UPDATEUSER.permit eq 'ACCESS' ? 'selected' : ''}>ACCESS</option>
		</select></td>
    </tr>

    <tr>
    <td colspan="2">(*) Mandatory field</td>
    </tr>
    
    </table>
    <input name="action" value="updateUserInDB" type="hidden">
    <input type="submit" value="Update Details">
	
	</form>
</body>
</html>