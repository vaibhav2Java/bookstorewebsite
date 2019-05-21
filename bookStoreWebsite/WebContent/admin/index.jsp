<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="../css/style.css">
<title>BookStore's administration</title>

</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h2>Administrative Dashboard</h2>
	</div>

	<div align="center">
		<hr width="60%">
		<h2>Quick Action</h2>
		<a href="create_book"> New Book</a> &nbsp; <a href="create_category">
			New Category</a>&nbsp; <a href="create_user"> New User</a>&nbsp; <a
			href="create_customer"> New Customer</a>&nbsp;

	</div>

	<div align="center">
		<hr width="60%">
		<h2>Recent sales</h2>

		<hr width="60%">
	</div>

	<div align="center">
		<hr width="60%">
		<h2>Recent Reviews</h2>
		<hr width="60%">
	</div>
	<div align="center">
		<hr width="60%">
		<h2>Statistics</h2>
		<hr width="60%">
	</div>


	<jsp:directive.include file="footer.jsp" />

</body>
</html>