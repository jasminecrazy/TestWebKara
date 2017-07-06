<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" 
uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	${error }
	<s:form method="post"  
		commandName="account" 
		action="${pageContext.request.contextPath }/account/login.html">
		<table>			
			</tr>
			<tr>
				<td>Username</td>
				<td>
					<s:input path="username" />
				</td>
			</tr>
			<tr>
				<td>Password</td>
				<td>
					<s:password path="password" />
				</td>
			</tr>			
			<tr>
				<td>&nbsp;</td>
				<td>
					<input type="submit" value="Login" />
				</td>
			</tr>
		</table>
	</s:form>
	
</body>
</html>