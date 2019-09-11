<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form name="userForm" action="/parking_system/UserController?editUser" method="post">
    <table style="width: 1200px; ">
    <tr>
    <td> Username(*): </td>
    <td>${user.username}</td>
  	
    </tr>

    <tr>
    <td> First Name (*): </td>
    <td> <input name="firstName" value='${updateUserByManager.firstName}' type="text" maxlength="45">  </td>
 	<td> <input name="userFirstNameError"  value='${errorMsgs.userFirstNameError}' type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <tr>
    <td> Last Name (*): </td> 
    <td> <input name="lastName" value='${updateUserByManager.lastName}' type="text" maxlength="45">  </td>
 	<td> <input name="userLastNameError"  value='${errorMsgs.userLastNameError}' type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <tr>
    <td> Email (*): </td>
    <td> <input name="email" value='${UPupdateUserByManagerDATEUSER.email}' type="text" maxlength="45">  </td>
  	<td> <input name="userEmailError"  value='${errorMsgs.userEmailError}' type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <tr>
    <td> Password (*): </td>
    <td> <input name="password" value='${UPDATEUupdateUserByManagerSER.password}' type="password" maxlength="45">  </td>
  	<td> <input name="userPasswordError"  value='${errorMsgs.userPasswordError}' type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <tr>
    <td> Role (*): </td>
    <td><select name="role">
  			<option value="USER">USER</option>
  			<option value="MANAGER">MANAGER</option>
  			<option value="ADMIN">ADMIN</option>
		</select>
    </td>
    </tr>
    
    <tr>
    <td> UTA ID (*): </td>
    <td> <input name="utaid" value='${updateUserByManager.utaid}' type="text" maxlength="45">  </td>
  	<td> <input name="utaIDerror"  value='${errorMsgs.utaIDerror}' type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <tr>
    <td> Phone: </td>
    <td> <input name="phone" value='${updateUserByManager.phone}' type="text" maxlength="16">  </td>
  	<td> <input name="phoneError"  value='${errorMsgs.phoneError}' type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <tr>
    <td> Street Address (*): </td>
    <td> <input name="streetaddress" value='${updateUserByManager.streetaddress}' type="text" maxlength="45">  </td>
  	<td> <input name="streetAddError"  value='${errorMsgs.streetAddError}' type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <tr>
    <td> City (*): </td>
    <td> <input name="city" value='${updateUserByManager.city}' type="text" maxlength="45">  </td>
  	<td> <input name="cityError"  value='${errorMsgs.cityError}' type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <tr>
    <td> State (*): </td>
    <td> <input name="state" value='${updateUserByManager.state}' type="text" maxlength="45">  </td>
  	<td> <input name="stateError"  value='${errorMsgs.stateError}' type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <tr>
    <td> Zip code (*): </td>
    <td> <input name="zipcode" value='${updateUserByManager.zipcode}' type="text" maxlength="45">  </td>
  	<td> <input name="zipCodeError"  value='${errorMsgs.zipCodeError}' type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <tr>
    <td> Vehicle Number (*): </td>
    <td> <input name="vehiclenumber" value='${updateUserByManager.vehiclenumber}' type="text" maxlength="45">  </td>
  	<td> <input name="vehicleNumberError"  value='${errorMsgs.vehicleNumberError}' type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <tr>
    <td> Permit (*): </td>
    <td><select name="permit">
  			<option value="BASIC">BASIC</option>
  			<option value="MIDRANGE">MIDRANGE</option>
  			<option value="PREMIUM">PREMIUM</option>
  			<option value="ACCESS">ACCESS</option>
		</select>
    </td>
    </tr>

    <tr>
    <td colspan="2">(*) Mandatory field</td>
    </tr>
    </table>
    <input name="action" value="updateUserInDBByManager" type="hidden">
    <input type="submit" value="Update Details">
    </form>

</body>
</html>