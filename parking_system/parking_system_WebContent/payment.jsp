<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Choose Options</title>
</head>
<body>

	<div class="header_resize">
      <div class="logo"><h1><a href="/parking_system/listUser.jsp">Home</a></h1></div>
      <div class="menu_nav">
      </div>
  	</div>
  	
  	<b> Make payment: </b> ${amount}<br>
  	<input name="rErrMsg"  value='${rErrorMsgs.errorMsg}' type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
  	<div class="mainbar"><div class="submb"></div></div>
	
	<form class="credit-card" action="/parking_system/ReservationController?action=EndPage" method="post">
		  <div class="form-header">
		    <h4 class="title">Credit card detail</h4>
		  </div>
		 
		  <div class="form-body">
		    <!-- Card Number -->
		    <tr>
    		<td> Card Number (*): </td>
		    <td><input name="card"  type="text" value="${reservation.cardNumber}" maxlength="45"></td>
		    <td><input name="timeError" value="${rErrorMsgs.cardNumberError}" type="text" style="background-color: white; color: red; border: none; width: 1500px" disabled="disabled" maxlength="60"></td>
		    </tr> 
		    
		 
		    <!-- Date Field -->
		    <div class="date-field">
		      <div class="month">
		        <select name="Month">
		          <option value="january">January</option>
		          <option value="february">February</option>
		          <option value="march">March</option>
		          <option value="april">April</option>
		          <option value="may">May</option>
		          <option value="june">June</option>
		          <option value="july">July</option>
		          <option value="august">August</option>
		          <option value="september">September</option>
		          <option value="october">October</option>
		          <option value="november">November</option>
		          <option value="december">December</option>
		        </select>
		      </div>
		      <div class="year">
		        <select name="Year">
		          <option value="2016">2016</option>
		          <option value="2017">2017</option>
		          <option value="2018">2018</option>
		          <option value="2019">2019</option>
		          <option value="2020">2020</option>
		          <option value="2021">2021</option>
		          <option value="2022">2022</option>
		          <option value="2023">2023</option>
		          <option value="2024">2024</option>
		        </select>
		      </div>
		    </div>
		 
		    <!-- Card Verification Field -->
		    <div class="card-verification">
		      <div class="cvv-input">
		       CVV(*):<br> <input type="text" name="cvv" value="${reservation.cvv}">
		        <input name="timeError" value="${rErrorMsgs.cvvError}" type="text" style="background-color: white; color: red; border: none; width: 1500px" disabled="disabled" maxlength="60">
		      </div>
		      <div class="cvv-details">
		        <p>3 or 4 digits usually found <br> on the signature strip</p>
		      </div>
		    </div>
		 
		    <!-- Buttons -->
		    <input type="submit" class="paypal-btn" value="PAY">
		  </div>
	</form>

</body>
</html>