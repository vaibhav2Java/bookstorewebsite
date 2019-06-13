<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/style.css">
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
					<table>
						<tr>
						<th>No</th>
						<th>Book</th>
						<th>Quantity</th>
						<th>Price</th>
						<th>Subtotal</th>
						<th><a href=""><b>Clear Cart</b></a> </th>
						
						
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