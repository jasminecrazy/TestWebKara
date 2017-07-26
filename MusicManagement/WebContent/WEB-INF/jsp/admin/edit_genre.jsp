<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<!-- Meta, title, CSS, favicons, etc. -->

<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />

<title>Genre management</title>

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
<link href="${pageContext.request.contextPath }/assets/css/ui-grid.css"
	rel="stylesheet" />
<style type="text/css">
.error {
	color: red;
}
</style>
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<div class="col-md-3 left_col">
				<div class="left_col scroll-view">


					<div class="clearfix"></div>
					<div class="profile clearfix">
						<div class="profile_pic">
							<img
								src="${pageContext.request.contextPath }/assets/images/preview.png"
								alt="..." class="img-circle profile_img" />
						</div>
						<div class="profile_info">
							<h4>Administrator</h4>

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
											href="${pageContext.request.contextPath }/admin.html">User
												management</a></li>
										<li><a
											href="${pageContext.request.contextPath }/admin/song.html">Song
												management</a></li>


									</ul></li>
								<li><a> <i class="fa fa-list-ul"></i>Category
										Management<span class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">

										<li><a
											href="${pageContext.request.contextPath }/admin/genre.html">Genre
												Management</a></li>
										<li><a
											href="${pageContext.request.contextPath }/admin/album.html">Album
												Management</a></li>
										<li><a
											href="${pageContext.request.contextPath }/admin/singer.html">Singer
												Management</a></li>
										<li><a
											href="${pageContext.request.contextPath }/admin/author.html">Author
												Management</a></li>

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
								aria-expanded="false"> Admin <span class=" fa fa-angle-down"></span>
							</a>
								<ul class="dropdown-menu dropdown-usermenu pull-right">



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
									href="${pageContext.request.contextPath }/admin.html">Home</a>
								</li>
								<li class="active"><a
									href="${pageContext.request.contextPath }/admin/genre.html">Genre
										Management</a></li>

							</ul>
						</div>

					</div>

					<div class="clearfix"></div>
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								<div class="x_title">
									<div class="clearfix"></div>

								</div>


								<div class="x_content">

									<s:form
										action="${pageContext.request.contextPath }/admin/edit_genre.html"
										method="POST" commandName="genre">
										<fieldset>

											<!-- Form Name -->
											<legend class="text-center"
												style="color: black; font-weight: bold">Edit genre
												information</legend>

											<!-- Text input-->
											<div class="form-group">
												<label class="col-md-4 control-label" for="username">Genre
													ID</label>
												<div class="col-md-8">
													<s:hidden path="id" />
													<s:input path="genreId" class="form-control input-md"
														readonly="true" />

												</div>
											</div>
											<div class="form-group">
												<label class="col-md-4 control-label" for="username">Genre
													Name</label>
												<div class="col-md-8">

													<s:input path="genreName" class="form-control input-md" />
													<s:errors path="genreName" cssClass="error"></s:errors>
												</div>
											</div>

											<div class="col-md-12 text-center">
												<input type="submit" value="Save"
													class="btn btn-primary btn-md"
													style="height: 45px; width: 91px;" /> <a
													href="${pageContext.request.contextPath }/admin/genre.html"
													class="btn btn-default btn-lg">Cancel</a>
											</div>

										</fieldset>
									</s:form>
								</div>
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


	<script src="${pageContext.request.contextPath }/assets/js/ui-grid.js"></script>
</body>

</html>
