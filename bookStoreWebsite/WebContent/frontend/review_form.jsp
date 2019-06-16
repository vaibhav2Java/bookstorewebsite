<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.js"></script>
<title>Write Review-Book Store</title>
</head>
<body>
<jsp:directive.include file="header.jsp" />
	<div align="center">
	<form id="reviewForm" action="submit_review" method="post">
	<table class="normal" width="60%">
	<tr>
	<td><h2> Your Reviews</h2></td>
	<td>&nbsp;</td>
	<td><h2>${loggedCustomer.firstName} ${loggedCustomer.lastName} </h2></td>
	</tr>
	<tr ><td colspan="3"><hr></td></tr>

				<tr>
					<td >
					<span id="book-title"> <h2>${book.title}</h2></span><br>
					<img src="data:image/jpg;base64,${book.base64Image}" width="200" height="200">
					</td>
					<td>
					<div id="rateYo"></div>
					<input type="text" name="headline" size="60" placeholder ="headline required" /> </br>
					</br>
					<textarea rows="10" cols="70" name="comment" placeholder ="comment required"></textarea>					
					</td>
				</tr>

			</table>
	
	</form>
	
	</div>
<jsp:directive.include file="footer.jsp" />
</body>
<script >

$(document).ready(function() {
	$("#reviewForm").validate({
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
	$("#rateYo").rateYo({
		    starWidth: "40px",
		    fullStar:true
	  });
});
	
</script>

</html>