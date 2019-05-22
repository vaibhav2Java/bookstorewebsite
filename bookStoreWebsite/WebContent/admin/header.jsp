<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="../css/style.css">
<title>header</title>
</head>
<body>
	<div align="center">
		<div>
			<img alt="adminlogo" src="../images/mainadmin.jpg" />
		</div>
		<div>
			welcome, <c:out value="${sessionScope.useremail }"></c:out> <a href="logout">LogOut</a>
		</div>
		<div id="headermenu">
		<div >
		<a href="list_users">
		<img src="../images/users.png" /><br/>Users </a>
		</div>
		<div >
		<a href="list_category">
		<img src="../images/category.png"/><br/>Category</a>
		</div>
		<div >
		<a href="list_books">
		<img src="../images/bookstack.png"/><br/>Books</a>
		</div>
		<div >
		<a href="list_users">
		<img src="../images/customer.png" /><br/>Customers</a>
		</div>
		<div >
		<a href="list_users">
		<img src="../images/review.png"/><br/>Reviews</a>
		</div>
		<div >
		<a href="list_users">
		<img src="../images/order.png"/><br/>Orders</a>
		</div>
	</div>
	</div>
</body>
</html>