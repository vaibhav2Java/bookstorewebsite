<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Profile </title>
<link rel="stylesheet" href="css/style.css">

</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center" class="message">
		<h2> Welcome! <i>${loggedCustomer.firstName}</i> </h2>
	<table class="normal">
	<tr>
		<td> E-mail Address :</td>
		<td>${loggedCustomer.email}</td>
	</tr>
	<tr>
		<td> First Name :</td>
		<td>${loggedCustomer.firstName}</td>
	</tr>
		<tr>
		<td> Last Name :</td>
		<td>${loggedCustomer.lastName}</td>
	</tr>
	<tr>
		<td> Address :</td>
		<td>${loggedCustomer.address}</td>
	</tr>
	<tr>
		<td> City :</td>
		<td>${loggedCustomer.city}</td>
	</tr>
	<tr>
		<td> Country :</td>
		<td>${loggedCustomer.country}</td>
	</tr>
	<tr>
		<td>Phone :</td>
		<td>${loggedCustomer.phone}</td>
	</tr>
		<tr>
		<td> Pin code :</td>
		<td>${loggedCustomer.pincode}</td>
	</tr>
		<tr>
		<td> User since :</td>
		<td>${loggedCustomer.registerDate}</td>
	</tr>
	<tr>
	<td>&nbsp;</td>
	</tr>
	
	<tr>
	<td colspan="2" align="center"><i><a href="edit_profile">Edit My Profile</a></i></td>
	</tr>
	</table>
	</div>
	<jsp:directive.include file="footer.jsp" />
</body>
</html>