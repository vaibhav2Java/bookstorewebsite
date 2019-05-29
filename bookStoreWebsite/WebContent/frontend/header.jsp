<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/style.css">
</head>
<body>

	<div class="center">
		<img src="images/mainlogo.jpg" height="100" width="100">
		<h1>this is header- logo search menu</h1>
	</div>
	<div class="center">
	<div >
	<form action="search" method="get">
		<input type="text" name="keyword" size="50" /> 
		<input type="submit" value="search">
		 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
		 <a	href="login">Sign In</a> | <a href="register">Register</a> | 
		 <a href="view_cart">Cart</a>
	</form>	 
	</div>
	<div>&nbsp;</div>
	<div>
		<c:forEach var="category" items="${listcategory}" varStatus="status">
			<a href="view_category?id=${category.categoryId}"> 
			<font	size="+1">
			<b><c:out value="${category.categoryName}" /> 
			</b></font>
			</a>
			<c:if test="${not status.last }">
	&nbsp; |&nbsp;
	</c:if>
		</c:forEach>
	</div>
</div>
</body>
</html>