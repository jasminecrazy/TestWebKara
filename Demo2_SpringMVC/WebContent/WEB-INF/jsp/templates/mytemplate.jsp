<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" 
uri="http://tiles.apache.org/tags-tiles" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<a href="${pageContext.request.contextPath }/home.html">Home</a> | 
	<a href="${pageContext.request.contextPath }/aboutus.html">About Us</a> |
	<a href="${pageContext.request.contextPath }/news.html">News</a>
	<br><br>
	<tiles:insertAttribute name="content"></tiles:insertAttribute>
	<br><br>
	Copyright 2017
	
	
	
	
</body>
</html>