<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Customers</title>
<link rel="stylesheet" href="../css/style.css">
<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h2 class="pageHeading">Customer Management</h2>
		<h3>
			<a href="customer_form.jsp"> Create New Customer</a>
		</h3>
	</div>
	<c:if test="${message != null}">
	<div align="center">
		<h4 class="message"> <i> ${message} </i> </h4>
	</div>
	</c:if>
	<div align="center">
		<table border="1" cellpadding="5">
			<tr>
				<th>Indexes</th>
				<th>Customer Id</th>
				<th>Email</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Address</th>
				<th>City</th>
				<th>Country</th>
				<th>Phone</th>
				<th>Pincode</th>
				<th>Password</th>
				<th>RegisterDate</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="customer" items="${listAllCustomers}" varStatus="status">
				<tr>
					<td>${status.index +1}</td>
					<td>${customer.customerId}</td>
					<td>${customer.email}</td>
					<td>${customer.firstName}</td>
					<td>${customer.lastName}</td>
					<td>${customer.address}</td>
					<td>${customer.city}</td>
					<td>${customer.country}</td>
					<td>${customer.phone}</td>
					<td>${customer.pincode}</td>
					<td>${customer.password}</td>
					<td>${customer.registerDate}</td>
					<td><a href="edit_customer?customerId=${customer.customerId}"> Edit</a> 
					<a href="javascript:void(0);" class="deleteLink" id="${customer.customerId}"> Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<jsp:directive.include file="footer.jsp" />

	<script type="text/javascript">
	$(document).ready(function(){
		$(".deleteLink").each(function(){
				$(this).on("click", function(){
					id = $(this).attr("id");
					if(confirm('Are you sure you want to delete the customer with id '+id + '?')) {
						window.location = 'delete_customer?customerId=' +id;
					}
				});
			});
		});

	</script>
</body>
</html>