<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="../css/style.css">
<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>

<title>Create New Customer</title>
</head>
<body>
<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h1 class="pageheading">
		<c:if test="${customer != null}">
		Update Customer
		</c:if>
		<c:if test="${customer == null}">
		Create New Customer
		</c:if>
		</h1>
	</div>
	<div align="center">
	<c:if test="${customer != null}">
		<form action="update_customer" method="post" id="customerForm">
		<input type="hidden" name="customerId" value="${customer.customerId}">
		</c:if>
		<c:if test="${customer == null}">
		<form action="create_customer" method="post" id="customerForm">
		</c:if>
			<table class="form">
			<tr>
					<td align="right">E-mail:</td>
					<td align="left"><input type="text" id="email" name="email" value="${customer.email}" /></td>
				</tr>
				<tr>
					<td align="right">First Name:</td>
					<td align="left"><input type="text" id="firstName" name="firstName" value="${customer.firstName}"/></td>
				</tr>
				<tr>
					<td align="right">Last Name:</td>
					<td align="left"><input type="text" id="lastName" name="lastName" value="${customer.lastName}"/></td>
				</tr>
				<tr>
					<td align="right">Address Line:</td>
					<td align="left"><input type="text" id="address" name="address" value="${customer.address}"/></td>
				</tr>
				<tr>
					<td align="right">City:</td>
					<td align="left"><input type="text" id="city" name="city" value="${customer.city}"/></td>
				</tr>
				<tr>
					<td align="right">Country:</td>
					<td align="left"><input type="text" id="country" name="country" value="${customer.country}"/></td>
				</tr>
				<tr>
					<td align="right">Phone Number:</td>
					<td align="left"><input type="text" id="phone" name="phone" value="${customer.phone}"/></td>
				</tr>
				
				<tr>
					<td align="right">Password:</td>
					<td align="left"><input type="text" id="password" name="password" value="${customer.password}"/></td>
				</tr>
				<tr>
					<td align="right">Confirm Password:</td>
					<td align="left"><input type="text" id="confirmpassword" name="confirmpassword" value="${customer.password}"/></td>
				</tr>
				<tr>
					<td align="right">ZipCode:</td>
					<td align="left"><input type="text" id="pincode" name="pincode" size="20" value="${customer.pincode}"/></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<input type="submit" value="submit" size="20" /> 
					<input type="button" value="cancel" id="buttonCancel" size="20" /></td>
				</tr>
			</table>
		</form>
	</div>
<jsp:directive.include file="footer.jsp" /></body>
<script>
$(document).ready(function() {
	$("#customerForm").validate({
		rules: {
			email :{
				required: true,
				email:true
			},
			firstName: "required",
			lastName: "required",
			address: "required",
			city:"required",
			country:"required",
			phone:"required",
			password:"required",
			confirmpassword:{
				required : true,
				equalTo : "#password"
			},
			pincode:"required"
			
		},
		messages: {
			email :{ 
				required :" Please enter a Email Address",
				email :"Please Enter a Valid Email Address"
			},
			firstName: "Please enter First Name",
			lastName: "Please enter Last Name",
			address: "Please enter a valid Address",
			city: "Please enter City",
			country: "Please enter Country",
			phone: "Please enter a valid Phone Number",
			password: "Please enter a Password",
			confirmpassword:{
				required: "Please enter a Confirm Password",
				equalTo :"Password does not match Password"
			},
			pincode: "Please enter a valid Pincode"
		},
	});
});

$("#buttonCancel").click(function() {
	history.go(-1);
	});
	
	</script>
</html>