<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="../css/style.css">
<link rel="stylesheet" href="../css/jquery-ui.min.css">
<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
<script type="text/javascript" src="../js/jquery-ui.min.js"></script>

<title>Create New Book</title>
</head>
<body>
<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h1 class="pageheading">
		<c:if test="${book != null}">
		Update Book
		</c:if>
		<c:if test="${book == null}">
		Create New Book
		</c:if>
		</h1>
	</div>
	<div align="center">
	<c:if test="${book != null}">
		<form action="update_book" method="post" id="bookForm" enctype='multipart/form-data'>
		<input type="hidden" name="bookId" value="${book.bookId}">
		</c:if>
		<c:if test="${book == null}">
		<form action="create_book" method="post" id="bookForm" enctype='multipart/form-data'>
		</c:if>
			<table class="form">
			<tr>
 				<td align="right">Category:</td>
 				<td align="left">
 						<select name="category"> 
 							<c:forEach items="${listCategory}" var="category"> 
<%--   									<c:if test="${category.categoryId eq book.category.categoryId} ">  --%>
  									<option value="${category.categoryId}">${category.categoryName}</option>
<%--   									</c:if>  --%>
<%--   									<c:if test="test="${category.categoryId ne book.category.categoryId}">  --%>
<%--   									<option value="${category.categoryId}"/>  --%>
<%--   									</c:if>  --%>
<%--  									${category.categoryName}  --%>
<!--  									</option>  -->
 							</c:forEach> 
 						</select> 
 					</td> 
 			</tr>			
			<tr>
					<td align="right">Title:</td>
					<td align="left"><input type="text" id="title" name="title" size="20" value="${book.title}" /></td>
				</tr>
				<tr>
					<td align="right">Author:</td>
					<td align="left"><input type="text" id="author" name="author" size="20" value="${book.author}"/></td>
				</tr>
				<tr>
					<td align="right">Isbn:</td>
					<td align="left"><input type="text" id="isbn" name="isbn" size="20" value="${book.isbn}"/></td>
				</tr>
				<tr>
					<td align="right">Price:</td>
					<td align="left"><input type="text" id="price" name="price" size="20" value="${book.price}"/></td>
				</tr>
				<tr>
					<td align="right">PublishDate:</td>
					<td align="left"><input type="text" id="publishDate" name="publishDate" size="20" value="${book.publishDate}"/></td>
				</tr>
				<tr>
					<td align="right">Book Image:</td>
					<td align="left"><input type="file" id="bookImage" name="bookImage" size="20"/>
						<img alt="logo" id="thumbnail" name="thumbnail" style="width:20%; margin-top:10px;" src="data:image/jpeg;charset=utf-8;base64,${book.base64Image}"/>
					</td>
				</tr>
				<tr>
					<td align="right">Description:</td>
					<td align="left"><textarea rows="5" cols="50" name="description" id="description">${book.description}</textarea>  </td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="submit" size="20" /> 
						<input type="button" value="cancel" id="buttonCancel" size="20" /></td>
				</tr>
			</table>
		</form>
	</div>
<jsp:directive.include file="footer.jsp" /></body>
<script>

$('#publishDate').datepicker();
$('#bookImage').change(function() {
	showImagethubnail(this);
	});
$(document).ready(function() {
	$("#bookForm").validate({
		rules: {
			title: {
				required: true,
				title: true
			},
			author: "required",
			isbn: "required",
			price: "required",
			publishDate:"required",
			bookImage:"required",
			description:"required"
			
		},
		messages: {
			title: {
				required: "Please enter title.",
				title: "Please enter a valid and unique title."
			},
			author: "Please enter author",
			isbn: "Please enter isbn",
			price: "Please enter price",
			publishDate:"Please enter a valid publishDate",
			bookImage:"Please upload a BookImage",
			description:"Please Enter the Description"
		},
	});
});

$("#buttonCancel").click(function() {
	history.go(-1);
	});
	
function showImagethubnail(fileInput) {
		var file = fileInput.files[0];
		var reader = new FileReader();
		reader.onload = function (e) {
			$('#thumbnail').attr('src', e.target.result);
		};
		reader.readAsDataURL(file);
}
	</script>
</html>