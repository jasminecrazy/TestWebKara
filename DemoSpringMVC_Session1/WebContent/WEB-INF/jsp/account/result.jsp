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
	
	<table border="1">
		<tr>
			<td>Id</td>
			<td>
				${account.id }
			</td>
		</tr>
		<tr>
			<td>Username</td>
			<td>
				${account.username }
			</td>
		</tr>
		<tr>
			<td>Password</td>
			<td>
				${account.password }
			</td>
		</tr>
		<tr>
			<td>Description</td>
			<td>
				${account.description }
			</td>
		</tr>
		<tr>
			<td>Status</td>
			<td>
				${account.status }
			</td>
		</tr>
		<tr>
			<td>Languages</td>
			<td>
				<c:forEach var="lang" 
					items="${account.languages }">
					${lang } 
					<br>
				</c:forEach>
			</td>
		</tr>
		<tr>
			<td>Gender</td>
			<td>
				${account.gender }
			</td>
		</tr>
		<tr>
			<td>Role</td>
			<td>
				${account.role }
			</td>
		</tr>
		<tr>
			<td>Photo</td>
			<td>
				<img src="${pageContext.request.contextPath }/assets/images/${account.photo }">
			</td>
		</tr>
	</table>
	
</body>
</html>