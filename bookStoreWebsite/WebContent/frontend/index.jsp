<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="../css/style.css">
<title>mybookstore</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<hr>

	<div align="center">
		<br/><br/>
		<h2>New Books:</h2>
			<div align="center">
		<h1>${category.categoryName}</h1>
		<hr>
	</div>
	<div align="center">
		<c:forEach items="${listNewBooks}" var="book">
			<div style="display: inline-block; margin: 10px;">
				<div>
					<a href="view_book?id=${book.bookId}">
					<img src="data:image/jpg;base64,${book.base64Image}" width="100" height="110">
					</a>
				</div>
				<div>
				<a href="view_book?id=${book.bookId}"><b>${book.title}</b></a></div>
				<div>Rating *****</div>
				<div><i>${book.author}</i></div>
				<div><b>${book.price}</b></div>
			</div>
		</c:forEach>
	</div>
		
	
		<h1>this is Main Content- new Books,Best selling books</h1>

	</div>
	<hr>
	<jsp:directive.include file="footer.jsp" />
</body>
</html>