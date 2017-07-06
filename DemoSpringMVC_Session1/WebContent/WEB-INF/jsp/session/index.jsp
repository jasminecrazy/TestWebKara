<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	a: ${sessionScope.a }
	<br>
	username: ${sessionScope.username }
	<br>
	Username: ${sessionScope.student.username }
	<br>
	Password: ${sessionScope.student.password }
	<h3>Students</h3>
	<c:forEach var="student" 
		items="${sessionScope.students }">
		Username: ${student.username }
		<br>
		Password: ${student.password }
		<br>
	</c:forEach>
	
	
	
</body>
</html>