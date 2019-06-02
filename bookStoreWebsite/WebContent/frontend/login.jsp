<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>

<title>Customer Log-in</title>
</head>
<body>
<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h2>Customer login</h2>
		<c:if test="${message != null}">
	<div align="center" class="message">
		<h4>
			<i> ${message} </i>
		</h4>
	</div>
	</c:if>		
		
		<form action="login" method="post" id="userForm">
			<table class="form">
				<tr>
					<td>email</td>
					<td><input id="email" type="text" name="email" size="20" /></td>
				</tr>
				<tr>
					<td>password</td>
					<td><input id="password" name="password" type="password" size="20" />
				</td>
				</tr>

				<tr>
					<td colspan="2" align="center">
					<input type="submit" value="Login" size="20" /> 
					<input type="submit" value="forget Password" size="20" /></td>
				</tr>
			</table>


		</form>
	</div>
<jsp:directive.include file="footer.jsp" />
</body>
<script >

$(document).ready(function() {
	$("#userForm").validate({
		rules: {
			email :{
				required: true,
				email:true
			},
			password:"required",
		},
		messages: {
			email :{ 
				required :" Please enter a Email Address",
				email :"Please Enter a Valid Email Address"
			},
			password: "Please enter a Password",
		},
	});
});
	
</script>

</html>