<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="../css/style.css">
<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>

<title>Admin Log-in</title>
</head>
<body>
	<div align="center">
		<h1>Book Store Administration</h1>
		<h2>admin login</h2>
		<c:if test="${message != null}">
	<div align="center">
		<h4>
			<i> ${message} </i>
		</h4>
	</div>
	</c:if>		
		
		<form id="formlogin" action="login" method="post">
			<table>
				<tr>
					<td>email</td>
					<td><input id="email" type="email" name="email" size="20" /></td>
				</tr>
				<tr>
					<td>password</td>
					<td><input id="email" name="password" type="password"
						size="20" /></td>
				</tr>

				<tr>
					<td colspan="2" align="center">
						<button type="submit">login</button>
					</td>
				</tr>
				
				<tr>
					<td>
						<button type="submit">Forgot Password</button>
					</td>
				</tr>
				


			</table>


		</form>
	</div>

</body>
<script type="text/javascript">
$("#formlogin").validate({
	rules: {
		email: {
			required:true,
			email:true
		},
		
		password: "required",
	},
	
	message: {
		email: {
			required: "Please enter email",
			email: "Please enter a valid email address"
			
		},
		
		password: "Please enter password",
	}
});

});
	
</script>

</html>