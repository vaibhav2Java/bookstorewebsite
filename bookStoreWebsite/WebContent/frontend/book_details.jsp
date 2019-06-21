<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/jquery-ui.min.js"></script>

<title> ${book.title} details</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<hr>
	<div align="center">
		<table width="80%" class="normal">
			<tr>
				<td colspan="3" align="left" height="10%">
					<h2>${book.title}</h2>	By ${book.author}
				</td>
			</tr>
			<tr>
				<td rowspan="2">
					<img src="data:image/jpg;base64,${book.base64Image}" width="200" height="200">
				</td>
				<td valign="top" align="left">
				<jsp:directive.include file="book_rating.jsp" />
				<a href="#reviews"> ${fn:length(book.reviews)} Reviews</a>
				</td>
				
				<td valign="top" rowspan="2" width="20%"> 
				<h2>$${book.price}</h2>
				<br><br>
				<button id="buttonAddToCart" >add to cart</button>
				 </td>
			</tr>
			<tr>
				<td valign="top" style="text-align: justify;">
				${book.description}
				</td>
			</tr>
			<tr><td> &nbsp;</td></tr>
			<tr>
				<td>
					<a id="reviews"><h2>Customer review</h2></a>
				</td>
				<td colspan="2" align="center">
					<button id="buttonWriteReview">Write a customer review</button>
				</td>
			</tr>
			<tr>
				<td colspan="3" align="left">
					<table class="normal">
						<c:forEach items="${book.reviews}" var="review">
							<tr>
								<td>
									<c:forTokens items="${review.stars}" delims="," var="star">
										<c:if test="${star eq 'on'}">
											<img alt="" src="images/rating-on.png">
										</c:if>
										<c:if test="${star eq 'off'}">
											<img alt="" src="images/rating-off.png">
										</c:if>
									</c:forTokens>
									- <b>${review.headline} </b>
								</td>
							</tr>
							<tr>
								<td>By ${review.customer.firstName}
									${review.customer.lastName} on ${review.reviewTime}</td>
							</tr>
							<tr><td> <i> ${review.comment} </i></td></tr>
							<tr><td> &nbsp; </td></tr>
						</c:forEach>
					</table>
				</td>
			</tr>
		</table>
	</div>
	<hr>
	<jsp:directive.include file="footer.jsp" />
	<script type="text/javascript">
	$(document).ready(function() {
	$("#buttonWriteReview").click(function() {
		window.location = 'write_review?book_Id=' + ${book.bookId};
		});
	$("#buttonAddToCart").click(function() {
		window.location = 'add_to_cart?book_Id=' + ${book.bookId};
		});
	
	});
	</script>
</body>
</html>