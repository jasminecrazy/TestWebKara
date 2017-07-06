<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<a href="${pageContext.request.contextPath }/demo.html">Back</a>
<br>	
<h3>Product Info</h3>
<table cellpadding="2" cellspacing="2" border="1">
	<tr>
		<td>Id</td>
		<td>${product.id }</td>
	</tr>
	<tr>
		<td>Name</td>
		<td>${product.name }</td>
	</tr>
	<tr>
		<td>Price</td>
		<td>${product.price }</td>
	</tr>
	<tr>
		<td>Quantity</td>
		<td>${product.quantity }</td>
	</tr>
	<tr>
		<td>Total</td>
		<td>${product.price * product.quantity }</td>
	</tr>
	<tr>
		<td>Photo</td>
		<td>
			<img src="${pageContext.request.contextPath }/assets/images/${product.photo }" width="120" height="100">
		</td>
	</tr>
</table>




	
	
</body>
</html>