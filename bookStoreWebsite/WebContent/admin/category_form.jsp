<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="../css/style.css">
<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>

<title>Create New Category</title>
</head>
<body>

	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h1 class="pageheading">
		<c:if test="${category !=null}">
		Update Category
		</c:if>
		<c:if test="${category !=null}">
		Create New Category
		</c:if>
		</h1>
	</div>
	<div align="center">
	<c:if test="${category !=null}">
		<form action="update_category" method="post" id="categoryForm">
		<input type="hidden" name="userId" value="${category.categoryId}">
		</c:if>
		<c:if test="${category == null}">
		<form action="create_category" method="post" id="categoryForm">
		</c:if>
			<table class="form">
				<tr>
					<td align="right">Category Name:</td>
					<td align="left"><input type="text" id="categoryname" name="categoryName" size="20" value="${categoryName}"/></td>
				</tr>

				<tr>
					<td>&nbsp;</td>
				</tr>
					<td colspan="2" align="center">
						<button type="submit"  size="20">submit</button>&nbsp;&nbsp;&nbsp;&nbsp; 
						<button type="button" id="buttonCancel" size="20">cancel</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:directive.include file="footer.jsp" />
</body>

<script>
$(document).ready(function() {
	$("#categoryForm").validate({
		rules: {
			categoryName: {
				required: true,
				categoryName: true
			},
		},
		message: {
			categoryName: {
				required: "Please enter Category Name.",
				categoryName: "Please enter a Category Name."
			},
		},
	});
});

$("#buttonCancel").click(function() {
	history.go(-1);
	});
	</script>
</html>