<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page not found Error</title>
</head>
<body>
<div align="center">
	<div>
		<img alt="adminlogo" src="${pageContext.request.contextPath}/images/mainadmin.jpg" />
	</div>


	<div >
		<h1>Soory the requested page could not be found</h1>
	</div>
	
	<div>
	
		<a href="javascript:history.go(-1);"> go back</a>
	</div>
	</div>
</body>
</html>