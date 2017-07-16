<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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

<h3>Product List</h3>
<table border="1">
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Photo</th>
		<th>Price</th>
		<th>Quantity</th>
		<th>Sub Total</th>
	</tr>
	<c:forEach var="p" items="${products }">
		<tr>	
			<td>${p.id }</td>
			<td>${p.name }</td>
			<td>
				<img src="${pageContext.request.contextPath }/assets/images/${p.photo }" width="120" height="100">
			</td>
			<td>${p.price }</td>
			<td>${p.quantity }</td>
			<td>${p.price * p.quantity }</td>
		</tr>
	</c:forEach>
</table>


	
	
</body>
</html>