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
	
	<s:form method="post" 
		enctype="multipart/form-data"  
		commandName="account" 
		action="${pageContext.request.contextPath }/account/save.html">
		<table>
			<tr>
				<td>Id</td>
				<td>
					${account.id }
					<s:hidden path="id"/>
				</td>
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
				<td>Description</td>
				<td>
					<s:textarea path="description" 
						cols="20" rows="5"/>
				</td>
			</tr>
			<tr>
				<td>Status</td>
				<td>
					<s:checkbox path="status"/>
				</td>
			</tr>
			<tr>
				<td>Languages</td>
				<td>
					<s:checkboxes path="languages" 
						items="${languages }" 
						itemLabel="name" 
						itemValue="id" 
						delimiter="<br>" />
				</td>
			</tr>
			<tr>
				<td>Gender</td>
				<td>
					<s:radiobutton path="gender" value="male"/> Male
					<br>
					<s:radiobutton path="gender" value="female"/> Female
				</td>
			</tr>
			<tr>
				<td>Role</td>
				<td>
					<s:select path="role" 
						items="${roles }" 
						itemLabel="name" 
						itemValue="id"></s:select>					
				</td>
			</tr>
			<tr>
				<td>Photo</td>
				<td>
					<input type="file" name="image">			
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>
					<input type="submit" value="Save" />
				</td>
			</tr>
		</table>
	</s:form>
	
</body>
</html>