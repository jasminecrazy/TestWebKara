<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" 
uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">

.error {
	color: red;
}

</style>

</head>
<body>

	<h3>Edit Student</h3>
	<s:form method="post" commandName="student" 
		action="${pageContext.request.contextPath }/student/edit.html">
		
		<table cellpadding="2" cellspacing="2">
			<tr>
				<td>Username</td>
				<td>
					<s:input path="username"/>
				</td>
				<td>
					<s:errors path="username" 
						cssClass="error"></s:errors>
				</td>
			</tr>
			<tr>
				<td>Password</td>
				<td>
					<s:password path="password"/>
				</td>
				<td>
					<s:errors path="password" 
						cssClass="error"></s:errors>
				</td>
			</tr>			
			<tr>
				<td>&nbsp;</td>
				<td colspan="2">
					<input type="submit" value="Save">
				</td>
			</tr>
		</table>
		
	</s:form>









</body>
</html>