<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="../css/style.css">
<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
<title>Edit Review</title>
</head>
<body>

	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h1 class="pageheading">
		<c:if test="${category !=null}">
		Edit Review
		</c:if>
		</h1>
	</div>
	<div align="center">
		<form action="update_review" method="post" id="reviewForm">
		<input type="hidden" name="reviewId" value="${editReview.reviewId}">
			<table class="form">
				<tr>
					<td align="right">Book:</td>
					<td align="left"><b>${editReview.book.title}</b></td>
				</tr>
				<tr>
					<td align="right">Rating:</td>
					<td align="left"><b>${editReview.rating}</b></td>
				</tr>
				<tr>
					<td align="right">Customer:</td>
					<td align="left"><b>${editReview.customer.firstName}</b></td>
				</tr>
				<tr>
					<td align="right">Headline:</td>
					<td align="left"><input type="text" size="60" name="headline" value="${editReview.headline}"></td>
				</tr>
				<tr>
					<td align="right">Comment:</td>
					<td align="left"><textarea rows="5" cols="70" name="comment" >${editReview.comment}</textarea></td>
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
	$("#reviewForm").validate({
		rules: {
			headline:"required",
			comment:"required"
		},
		messages: {
			headline:"Please enter the headline !",
			comment:"Please enter the Comment !"
		}
	});
});

$("#buttonCancel").click(function() {
	history.go(-1);
	});
	</script>
</html>