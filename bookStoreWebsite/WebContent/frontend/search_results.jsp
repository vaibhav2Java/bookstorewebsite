<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="../css/style.css">
<title>Results in Search for ${keyword}</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<hr>

	<div class="center">
		<c:if test="${fn:length(searchBook)==0}">
			<h2>No Results found for ${keyword}</h2>
		</c:if>
		<c:if test="${fn:length(searchBook)>0}">
			<br/>
			<br/>
			<h2>Result for ${keyword}</h2>
			<div class="center">
				<hr>
			</div>
			<div class="center">
				<c:forEach items="${searchBook}" var="book">
					<div style="display: inline-block; margin: 10px;">
						<div>
							<a href="view_book?id=${book.bookId}"> <img
								src="data:image/jpg;base64,${book.base64Image}" width="100"
								height="110">
							</a>
						</div>
						<div>
							<a href="view_book?id=${book.bookId}"><b>${book.title}</b></a>
						</div>
						
						<div>Rating *****</div>
						<div>
							<i>${book.author}</i>
						</div>
						<div>
							<b>${book.price}</b>
						</div>
					</div>
				</c:forEach>
			</div>
		</c:if>
	</div>
	<jsp:directive.include file="footer.jsp" />
</body>
</html>