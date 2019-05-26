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

<title>Create New User</title>
</head>
<body>

	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h1 class="pageheading">
		<c:if test="${user != null}">
		Update user
		</c:if>
		<c:if test="${user == null}">
		Create New User
		</c:if>
		</h1>
	</div>
	<div align="center">
	<c:if test="${user != null}">
		<form action="update_user" method="post" id="userForm">
		<input type="hidden" name="userId" value="${user.userId}">
		</c:if>
		<c:if test="${user == null}">
		<form action="create_user" method="post" id="userForm">
		</c:if>
			<table class="form">
				<tr>
					<td align="right">Email:</td>
					<td align="left"><input type="text" id="email" name="email" size="20" value="${user.email}" /></td>
				</tr>
				<tr>
					<td align="right">First Name:</td>
					<td align="left"><input type="text" id="firstName" name="firstName" size="20" value="${user.firstName}"/></td>
				</tr>
				<tr>
					<td align="right">Last Name:</td>
					<td align="left"><input type="text" id="lastName" name="lastName" size="20" value="${user.lastName}"/></td>
				</tr>
				<tr>
					<td align="right">Password:</td>
					<td align="left"><input type="password" id="password" name="password" size="20" value="${user.password}"/></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="submit"  size="20">submit</button>&nbsp;&nbsp;&nbsp;&nbsp; 
						<button type="button" id="buttonCancel" size="20">cancel</button>
					</td>
				</tr>

			</table>
		</form>
	</div>
	<jsp:directive.include file="footer.jsp" />
</body>

<script>
$(document).ready(function(){
	$("#userForm").validate({
		rules: {
			email: {
				required: true,
				email: true
			},
			firstName: "required",
			lastName: "required",
			password: "required",
		},
		message: {
			email: {
				required: "Please enter email.",
				email: "Please enter a valid Email."
			},
			firstName: "Please enter Firstname",
			lastName: "Please enter Lastname",
			password: "Please enter password"
		},
	});
});
$("#buttonCancel").click(function() {
	history.go(-1);
	});
	</script>
</html>