<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<!-- Meta, title, CSS, favicons, etc. -->
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />

<title>Welcome</title>

<!-- Bootstrap -->
<link
	href="${pageContext.request.contextPath }/assets/css/bootstrap.min.css"
	rel="stylesheet" />

<!-- Font Awesome -->
<link
	href="${pageContext.request.contextPath }/assets/css/font-awesome.min.css"
	rel="stylesheet" />

<!-- NProgress -->
<link
	href="${pageContext.request.contextPath }/assets/css/nprogress.css"
	rel="stylesheet" />

<!-- iCheck -->
<link href="${pageContext.request.contextPath }/assets/css/green.css"
	rel="stylesheet" />
<!-- Custom Theme Style -->
<link
	href="${pageContext.request.contextPath }/assets/css/custom.min.css"
	rel="stylesheet" />

<!-- External Libraries-->
<link href="${pageContext.request.contextPath }/assets/css/style1.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath }/assets/css/sweetalert.css"
	rel="stylesheet" />


</head>

<body data-ng-app="myApp" class="nav-md" data-ng-controller="userCtrl">
	<div class="container body">
		<div class="main_container">
			<div class="col-md-3 left_col">
				<div class="left_col scroll-view">


					<div class="clearfix"></div>
					<div class="profile clearfix">
						<div class="profile_pic">
							<img
								src="${pageContext.request.contextPath }/assets/images/img.jpg"
								alt="..." class="img-circle profile_img" />
						</div>
						<div class="profile_info">
							<span>Welcome,</span>
							<h2>${pageContext.request.userPrincipal.name }</h2>
						</div>
					</div>
					<!-- sidebar menu -->
					<div id="sidebar-menu"
						class="main_menu_side hidden-print main_menu">
						<div class="menu_section">

							<ul class="nav side-menu">

								<li><a> <i class="fa fa-info-circle"></i>Information
										Management<span class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a
											href="${pageContext.request.contextPath }/superadmin/song.html">Song
												management</a></li>
										<li><a
											href="${pageContext.request.contextPath }/superadmin.html">User
												management</a></li>

									</ul></li>

							</ul>
						</div>


					</div>
					<!-- /sidebar menu -->

					<!-- /menu footer buttons -->

					<!-- /menu footer buttons -->
				</div>
			</div>

			<!-- top navigation -->
			<div class="top_nav">
				<div class="nav_menu">
					<nav>
						<div class="nav toggle">
							<a id="menu_toggle"><i class="fa fa-bars"></i></a>
						</div>

						<ul class="nav navbar-nav navbar-right">
							<li class=""><a href="javascript:;"
								class="user-profile dropdown-toggle" data-toggle="dropdown"
								aria-expanded="false"> <img src="images/img.jpg" alt="" />Admin
									<span class=" fa fa-angle-down"></span>
							</a>
								<ul class="dropdown-menu dropdown-usermenu pull-right">
									<li><a href="javascript:;"> Profile</a></li>


									<li><a href="<c:url value='/j_spring_security_logout'/>"><i
											class="fa fa-sign-out pull-right"></i> Log Out</a></li>
								</ul></li>


						</ul>
					</nav>
				</div>
			</div>
			<!-- /top navigation -->

			<!-- page content -->
			<div class="right_col" role="main">

				<div class="">
					<div class="page-title">
						<div class="title_left">

							<ul class="breadcrumb">
								<li><i class="ace-icon fa fa-home home-icon"></i> <a
									href="${pageContext.request.contextPath }/admin/welcome">Home</a>
								</li>
								<li class="active"><a
									href="${pageContext.request.contextPath }/superadmin.html">User
										Management</a></li>

							</ul>
						</div>

					</div>
					<div class="title_right"></div>
					<div class="clearfix"></div>
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								<div class="x_content text-center">
									<h3>Add new user</h3>
									<!-- Content -->
									<s:form method="post" commandName="user"
										action="${pageContext.request.contextPath }/superadmin/add.html">
										<%-- <table cellpadding="2" cellspacing="2">
											<tr>
												<label>Username</label>
												<td><s:input path="username" class="form-control" /></td>
												
											</tr>
											<tr>
												<td>Password</td>
												<td><s:input path="password" /></td>
												
											</tr>
											 <tr>
												<td>Fullname</td>
												<td><s:input path="fullname" /></td>
												
											</tr>
											<tr>
												<td>Status</td>
												<td>
												
												 <s:checkbox path="enabled" value="1"/>
												</td>
											</tr>
											<tr>
												<td>
												<input type="submit" value="Save">
												</td>
											</tr>
										</table> --%>
										<div class="form-group text-left">
											<label class="col-md-offset-2 control-label col-md-2" for="">Username</label>
											<div class="col-md-5">
												<s:input path="username" class="form-control" />
											</div>
										</div>
										<div class="form-group text-left">
											<label class="col-md-offset-2 control-label col-md-2" for="">Password</label>
											<div class="col-md-5">
												<td><s:password path="password" class="form-control"/></td>
											</div>
										</div>
										<div class="form-group text-left">
											<label class="col-md-offset-2 control-label col-md-2" for="">Fullname</label>
											<div class="col-md-5">
												<td><s:input path="fullname" class="form-control"/></td>
											</div>
										</div>
										<div class="form-group text-left">
											<label class="col-md-offset-2 control-label col-md-2" for="">Status</label>
											<div class="col-md-5">
												<td><s:checkbox path="enabled" value="0"/></td>
											</div>
										</div>
										<div class="form-group col-md-12">
										<button type="submit" class="btn btn-primary btn-lg">Add</button>
										</div>
									</s:form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- /page content -->

			<!-- footer content -->
			<footer> </footer>
			<!-- /footer content -->
		</div>
	</div>


	<!-- jQuery -->
	<script
		src="${pageContext.request.contextPath }/assets/js/jquery.min.js"></script>

	<!-- Bootstrap -->
	<script
		src="${pageContext.request.contextPath }/assets/js/bootstrap.min.js"></script>

	<!-- FastClick -->
	<script
		src="${pageContext.request.contextPath }/assets/js/fastclick.js"></script>

	<!-- NProgress -->
	<script
		src="${pageContext.request.contextPath }/assets/js/nprogress.js"></script>

	<!-- iCheck -->
	<script
		src="${pageContext.request.contextPath }/assets/js/icheck.min.js"></script>

	<!-- Custom Theme Scripts -->
	<script src="${pageContext.request.contextPath }/assets/js/custom.js"></script>

	<!-- Angular JS -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/assets/js/angular.min.js"></script>

	<script type="text/javascript"
		src="${pageContext.request.contextPath }/assets/js/sweetalert-dev.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/assets/js/angular-route.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/assets/js/angular-ui.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/assets/js/angular-resource.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/assets/js/angular-messages.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/assets/js/ui-bootstrap-tpls.min.js"></script>
	<!-- App & Controller -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/assets/scripts/myApp.js"></script>

	<script type="text/javascript"
		src="${pageContext.request.contextPath }/assets/scripts/userCtrl.js"></script>
</body>

</html>
