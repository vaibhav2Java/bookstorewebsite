<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="../css/style.css">
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>

<title>Shopping Cart</title>
</head>
<body>
<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h2>Shopping Cart</h2>
		<c:if test="${message != null}">
	<div align="center" class="message">
		<h4>
			<i> ${message} </i>
		</h4>
	</div>
	</c:if>		
		
		<c:set var="cart" value="${sessionScope['cart']}"/>
		<c:if test="${cart.totalItems == 0}">
		<h2> There is no item in cart at this time</h2>
		</c:if>
		
		<c:if test="${cart.totalItems > 0}">
			<div>
				<form action="">
					<table border="1">
						<tr>
						<th>No</th>
						<th colspan="2">Book</th>
						<th>Quantity</th>
						<th>Price</th>
						<th>Subtotal</th>
						<th><a href=""><b>Clear Cart</b></a> </th>
						</tr>
						<c:forEach items="${cart.items}" var="items" varStatus="status">
						<tr>
							<td> ${status.index +1}</td>
							<td>
								<img src="data:image/jpg;base64,${items.key.base64Image}" width="100" height="100">
							</td>
							<td>	
							 	<span id="book-title">  ${items.key.title} </span> 
							 </td>
							<td> ${items.value}</td>
							<td> <fmt:formatNumber value="${items.key.price}" type="currency"/></td>
							<td> <fmt:formatNumber value="${items.value * items.key.price}" type="currency"/> </td>
							<td> <a href="">remove</a> </td>
						</tr>
						</c:forEach>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td><b> ${cart.totalQuantity} book(s)</b></td>
							<td>Total:</td>
							<td colspan="2" > <fmt:formatNumber value="${cart.totalAmount}" type="currency"/> </td>
						</tr>
					</table>
				</form>
			</div>


		</c:if>
		
		
		
		
		
		
		
	</div>
<jsp:directive.include file="footer.jsp" />
</body>
<script >

$(document).ready(function() {
	$("#userForm").validate({
		rules: {
			email :{
				required: true,
				email:true
			},
			password:"required",
		},
		messages: {
			email :{ 
				required :" Please enter a Email Address",
				email :"Please Enter a Valid Email Address"
			},
			password: "Please enter a Password",
		},
	});
});
	
</script>

</html>