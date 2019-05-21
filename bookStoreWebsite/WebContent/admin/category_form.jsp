<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create New Category</title>
</head>
<body>

	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h2>
		<c:if test="${category !=null }">
		Update Category
		</c:if>
		<c:if test="${category ==null }">
		Create New User
		</c:if>
		</h2>
	</div>
	<div align="center">
	<c:if test="${category !=null }">
		<form action="update_category" method="post" onsubmit="return validateFormInput()">
		<input type="hidden" name="categoryId" value="${category.categoryId}">
		</c:if>
		<c:if test="${category ==null }">
		<form action="create_category" method="post" onsubmit="return validateFormInput()">
		</c:if>
		
			<table>
				<tr>
					<td align="right">Category Name:</td>
					<td align="left"><input type="text" id="categoryname" name="categoryName" size="20" value="${categoryName}"/></td>
				</tr>

				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="submit" size="20" /> <input type="button" value="cancel"
						size="20" onclick="javascipt:history.go(-1);" /></td>
				</tr>

			</table>
		</form>
	</div>



	<jsp:directive.include file="footer.jsp" />


</body>

<script type="text/javascript">
	function validateFormInput() {
		var fieldCategoryName = document.getElementById("categoryname");
		if (fieldCategoryName.value.length == 0) {
			alert("Category is required!");
			fieldCategoryName.focus();
			return false;
		}
		return true;
	}
</script>

</html>