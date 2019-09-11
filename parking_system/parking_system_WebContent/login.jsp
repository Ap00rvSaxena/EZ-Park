<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<h1><a href='/parking_system/index.jsp'>Arlington Parking, Inc.</a></h1>
<h3>Log in</h3>
<table>
<tr>
<td>
<form name="loginForm" action="/parking_system/UserController?action=loginUser" method="post">
<table style="height: 150px; ">
<input id="greetingField" value='${greetingField}' type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"/>
<tr>
	<td>Username:</td>
	<td><input name="username" value='${user.username}' style="width: 209px; "/></td>
	<td> <input name="userNameError"  value='${errorMsgs.userNameError}' type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
</tr>
	<td>Password:</td>
	<td><input name="password" type="password" value="${user.password}" style="width: 210px; "></td>
	<td> <input name="userPasswordError"  value='${errorMsgs.userPasswordError}' type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
<tr>
</tr>
</table>
<input name="action" value="loginUser" type="hidden">
<input type="submit" value="Login">
</form>
</table>
</body>
</html>