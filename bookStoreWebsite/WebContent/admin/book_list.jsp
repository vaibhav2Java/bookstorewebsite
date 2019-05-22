<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Books</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h2 class="pageHeading">Books Management</h2>
		<h3>
			<a href="new_book"> Create new Book</a>
		</h3>
	</div>
	<c:if test="${message != null}">
	<div align="center">
		<h4>
			<i> ${message} </i>
		</h4>
	</div>
	</c:if>
	<div align="center">
		<table border="1" cellpadding="5">
			<tr>
				<th>Indexes</th>
				<th>bookId</th>
				<th>category</th>
				<th>title</th>
				<th>author</th>
				<th>description</th>
				<th>isbn</th>
				<th>image</th>
				<th>price</th>
				<th>publishDate</th>
				<th>lastUpdateTime</th>
				<th>Actions</th>
			</tr>

			<c:forEach var="books" items="${listbooks}" varStatus="status">
				<tr>
					<td>${status.index +1}</td>
					<td>${books.bookId}</td>
					<td>${books.category.categoryName}</td>
					<td>${books.title}</td>
					<td>${books.author}</td>
					<td>${books.description}</td>
					<td>${books.isbn}</td>
					<td> <img  src="data:image/jpg;base64,${books.base64Image}" width="100" height="100"> </td>
					<td>${books.price}</td>
					<td>${books.publishDate}</td>
					<td>${books.lastUpdateTime}</td>
					<td><a href="edit_book?bookId=${books.bookId}"> Edit</a> 
					<a href="javascript:confirmDelete(${books.bookId})"> Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<jsp:directive.include file="footer.jsp" />
	<script type="text/javascript">
	function confirmDelete(bookId){
		if(confirm('Are you sure you want to delete the user with id ' +bookId + '?')){
			window.location = 'delete_book?bookId=' + bookId;
		}
	}
	</script>
</body>
</html>