<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>log-in</title>
</head>
<body>

	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h2>please login here</h2>
		<form action="" method="post">
			<input type="text" value="email:" name="email"><br>
			<br> <input type="text" value="firstname:" name="firstname"><br>
			<br> <input type="text" value="lastname:" name="lastname">

			<input type="submit" value="log-in">


		</form>
	</div>
	<jsp:directive.include file="footer.jsp" />

</body>
</html>