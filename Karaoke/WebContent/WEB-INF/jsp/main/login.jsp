<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/assets/css/style.css"
	rel='stylesheet' type='text/css' />
<!--webfonts-->
<link
	href='http://fonts.googleapis.com/css?family=PT+Sans:400,700,400italic,700italic|Oswald:400,300,700'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Exo+2'
	rel='stylesheet' type='text/css'>


</head>
<body style="text-align:center">

	<h1 style="margin-bottom:10px">Login Form</h1>
	<span 
		style="color: red;">${msg}</span>
	<div class="login-form">
		<div class="close"></div>
		<div class="head-info">
			<label class="lbl-1"> </label> <label class="lbl-2"> </label> <label
				class="lbl-3"> </label>
		</div>
		<div class="clear"></div>
		<div class="avtar">
			<img
				src="${pageContext.request.contextPath }/assets/images/avtar.png" />
		</div>
		<form action='<c:url value="/j_spring_security_check"></c:url>'
			method="post">
			<input name="username" type="text" class="text" value="Username"
				onfocus="this.value = '';"
				onblur="if (this.value == '') {this.value = 'Username';}">
			<div class="key">
				<input type="password" name="password" value="Password"
					onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = 'Password';}">
			</div>
			<div class="signin">
				<input type="submit" value="Login">
			</div>

		</form>

	</div>

</body>
</html>