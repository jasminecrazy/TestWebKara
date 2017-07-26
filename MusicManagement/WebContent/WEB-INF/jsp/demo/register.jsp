<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Register</title>

<!-- CSS -->
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/assets/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/assetscss/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/assets/css/form-elements.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/assets/css/style4.css">


<style type="text/css">
.error {
	color: red;
}
</style>

</head>

<body>

	<!-- Top content -->
	<div class="top-content">

		<div class="inner-bg">
			<div class="container">


				<div class="row">



					<div class="col-sm-5" style="margin-left: 350px">

						<div class="form-box text-center">
							<div class="form-top">
								<div class="form-top-center">
									<h3>Sign up now</h3>

								</div>
								<div class="form-top-right">
									<i class="fa fa-pencil"></i>
								</div>
							</div>
							<div class="form-bottom">
								<s:form role="form"
									action="${pageContext.request.contextPath }/demo/register.html"
									method="post" commandName="register" class="registration-form">
									<div class="form-group">
										<label class="sr-only" for="form-first-name">Fullname</label>
										<s:input name="form-first-name" path="fullname"
											placeholder="Enter fullname"
											class="form-first-name form-control" id="form-first-name" />
										<s:errors path="fullname" cssClass="error"></s:errors>
									</div>
									<div class="form-group">
										<label class="sr-only" for="form-first-name">Username</label>
										<s:input path="username" name="form-first-name"
											placeholder="Username" class="form-first-name form-control"
											id="form-first-name" />
										<s:errors path="username" cssClass="error"></s:errors>
									</div>
									<div class="form-group">
										<label class="sr-only" for="form-last-name">Password</label>
										<s:password name="form-last-name" placeholder="Enter password"
											path="password" class="form-password form-control"
											id="form-last-name"/>
										<s:errors path="password" cssClass="error"></s:errors>
									</div>
									<div class="form-group">
										<label class="sr-only" for="form-last-name">Re
											Password</label> <s:password path="retypePassword" name="form-last-name"
											placeholder="Re enter password"
											class="form-password form-control" id="form-last-name"/>
											<s:errors path="retypePassword" cssClass="error"></s:errors>
									</div>
									<div class="form-group">
										<label class="sr-only" for="form-email">Email</label>
										<s:input path="email" name="form-email" placeholder="Email..."
											class="form-email form-control" id="form-email" />
										<s:errors path="email" cssClass="error"></s:errors>
									</div>
									<div class="form-group">
										<label class="sr-only" for="form-email">Phone</label>
										<s:input path="phone" name="form-email" placeholder="Phone"
											class="form-email form-control" id="form-email" />
										<s:errors path="phone" cssClass="error"></s:errors>
									</div>
									<s:hidden path="role.id" value="2" />

									<button type="submit" class="btn">Sign me up!</button>
								</s:form>
							</div>
						</div>

					</div>
				</div>

			</div>
		</div>

	</div>



	<!-- Javascript -->
	<script
		src="${pageContext.request.contextPath }/assets/js/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/assets/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/assets/js/jquery.backstretch.min.js"></script>
	<script src="${pageContext.request.contextPath }/assets/js/scripts.js"></script>

	<!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->

</body>

</html>