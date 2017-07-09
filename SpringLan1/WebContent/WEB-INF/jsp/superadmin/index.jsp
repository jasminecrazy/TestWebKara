<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<!-- Meta, title, CSS, favicons, etc. -->
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />

<title>Welcome</title>
<link rel="stylesheet" type="text/css"
	href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.0/css/jquery.dataTables.css">
<link rel="stylesheet" type="text/css"
	href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.0/css/jquery.dataTables_themeroller.css">


<script type="text/javascript" charset="utf8"
	src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.7.1.min.js"></script>
<script type="text/javascript" charset="utf8"
	src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.0/jquery.dataTables.min.js"></script>

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
<link href="${pageContext.request.contextPath }/assets/css/ui-grid.css"
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
								<li><a> <i class="fa fa-list-ul"></i>Category
										Management<span class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										
										<li><a
											href="${pageContext.request.contextPath }/superadmin.html">Volume Management</a></li>
											<li><a
											href="${pageContext.request.contextPath }/superadmin.html">Album Management</a></li>

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
					<div class="title_right">
						<div class="form-group pull-right top_search">
							<%-- <a href="${pageContext.request.contextPath }/superadmin/add.html"
								class="btn btn-primary btn-lg">Add</a> --%>
							<button data-toggle="modal" data-target="#myModal_add"
								type="button" class="btn btn-primary btn-lg"
								ng-click="resetFormAdd()">Add</button>
						</div>
					</div>
					<div class="clearfix"></div>
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								<div class="x_title">
									<h3>User Management</h3>
									<div class="clearfix"></div>
								</div>


								<div class="x_content">

									<div class="table-responsive">

										<div id="grid" ui-grid="gridOptions"
											ui-grid-selection="ui-grid-selection"
											ui-grid-resize-columns="ui-grid-resize-columns"
											ui-grid-pagination="ui-grid-pagination" class="myGrid"></div>

									</div>
								</div>
							</div>
						</div>
						<!-- Modal add -->
						<div class="modal fade" id="myModal_add" tabindex="-1"
							role="dialog">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h4 class="modal-title" id="myModalLabel">Add new User</h4>
									</div>
									<div class="modal-body row">
										<form class="form-horizontal" name="frmUserAdd"
											enctype="multipart/form-data" id="fileUploadForm">
											<div class="col-md-6">

												<div class="form-group">
													<label class=" control-label">Fullname</label>
													<div class="">
														<input id="fullname" name="fullname"
															ng-keydown="autoAdd($event)" ng-model="add_fullname"
															class="form-control input-md" type="text" />

													</div>
												</div>
												<div class="form-group">
													<label class=" control-label" for="">Username</label>
													<div class="">
														<input id="username" name="username"
															ng-keyup="hideDuplicateAlert()"
															class="form-control input-md" type="text"
															ng-model="add_username" ng-required="false" />
													</div>
												</div>
												<p ng-show="duplicateAlert != ''" ng-bind="duplicateAlert"
													style="color: red"></p>



												<div class="form-group">
													<label class=" control-label" for="">Password</label>
													<div class="">
														<input id="password" name="password"
															class="form-control input-md" type="password"
															ng-model="add_password" ng-required="false" />
													</div>
												</div>


												<div class="form-group">
													<label class="control-label">Status</label> <input
														type="radio" ng-model="status" ng-value="true"
														ng-checked="true" /> Active <input type="radio"
														ng-model="status" ng-value="false" /> Inactive


												</div>

												<div class="form-group">
													<label class="control-label">Role</label> <input
														type="radio" ng-model="role" ng-value="1"
														ng-checked="true" /> Superadmin <input type="radio"
														ng-model="role" ng-value="2" /> admin


												</div>

											</div>





										</form>
									</div>
									<div class="modal-footer">
										<button id="btnSave" name="btnSave" class="btn btn-primary"
											ng-click="save(false)">Add</button>
										<button id="btnSave" name="btnSave" class="btn btn-default"
											ng-click="save(true)">Add and close</button>
										<button type="button" class="btn btn-default"
											data-dismiss="modal">Close</button>

									</div>

								</div>
							</div>
						</div>
						<!-- Modal-->
						<!-- Modal edit -->
						<div class="modal fade" id="myModal_edit" tabindex="-1"
							role="dialog">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h4 class="modal-title" id="myModalLabel">Edit User
											Information</h4>
									</div>
									<div class="modal-body row">
										<form class="form-horizontal" name="editForm">
											<div class="col-md-6">
												<input type="hidden" name="id" ng-model="edit_id" />
												<div class="form-group">
													<label class=" control-label">Fullname</label>
													<div class="">
														<input id="fullname" name="fullname" placeholder=""
															ng-model="edit_fullname" class="form-control input-md"
															type="text" />

													</div>
												</div>
												<div class="form-group">
													<label class=" control-label" for="">Username</label>
													<div class="">
														<input id="username" name="username"
															ng-keyup="hideDuplicateAlert()"
															class="form-control input-md"
															ng-keydown="autoAdd($event)" type="text"
															ng-model="edit_username" ng-required="false" />
													</div>
												</div>
												<p ng-show="duplicateAlert != ''" ng-bind="duplicateAlert"
													style="color: red"></p>
												<input type="hidden" id="password" name="password"
													ng-model="edit_password" />
												<div class="form-group">
													<label class="control-label">Status</label>
													<div class="checkbox">
														<label> <input type="radio" ng-model="edit_status"
															value="false" name="status" ng-value="false" /> Disable
														</label> <label> <input type="radio"
															ng-model="edit_status" value="true" name="status"
															ng-value="true" /> Enable
														</label>
													</div>


												</div>
												<div class="form-group">
													<label class="control-label">Role</label>
													<div class="checkbox">
														<label> <input type="radio" ng-model="edit_role"
															value="1" name="role" ng-value="1" />Superadmin
														</label> <label> <input type="radio" ng-model="edit_role"
															value="2" name="role" ng-value="2" />Admin
														</label>
													</div>


												</div>
											</div>

										</form>
									</div>
									<div class="modal-footer">
										<button type="button" class="pull-left btn btn-danger"
											data-toggle="modal" data-target="#myModal_confirmReset"
											ng-click="ResetPass(x)">Reset password</button>
										<button id="btnSave" name="btnSave" class="btn btn-primary"
											ng-click="update()" data-dismiss="modal">Save</button>
										<button type="button" class="btn btn-default"
											data-dismiss="modal">Close</button>
									</div>
								</div>
							</div>
						</div>
						<!-- Modal confirmReset -->
						<div class="modal fade" id="myModal_confirmReset" tabindex="-1"
							role="dialog" aria-labelledby="myModalLabel">
							<div class="modal-dialog" role="document">
								<div class="modal-content">

									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-hidden="true">&times;</button>
										<h4 class="modal-title" id="myModalLabel">Confirm reset
											password</h4>
									</div>

									<div class="modal-body row">
										<form class="form-horizontal" name="frmReset">
											<div class="form-group">
												<label class=" control-label" for="birthday">New
													password</label>
												<div class="">
													<input type="password" id="newPassword" name="newPassword"
														ng-model="newPassword" class="form-control "
														required="required" />
													<div ng-messages="frmReset.newPassword.$error">
														<div ng-message="required"
															ng-show="frmReset.newPassword.$touched">
															<p style="color: red">This field is required</p>
														</div>
													</div>
												</div>
											</div>
											<div class="form-group">
												<label class=" control-label" for="birthday">Retype
													password</label>
												<div class="">
													<input type="password" id="reNewPassword"
														name="reNewPassword" ng-model="reNewPassword"
														class="form-control" required="required"
														match-password="newPassword" />
													<div ng-messages="frmReset.reNewPassword.$error">
														<div ng-message="required"
															ng-show="frmReset.reNewPassword.$touched">
															<p style="color: red">This field is required</p>
														</div>
														<div ng-message="matchPassword">
															<p style="color: red">Must match the previous field</p>
														</div>
													</div>

												</div>

											</div>
											<input type="hidden" ng-model="reset_id_role" /> <input
												type="hidden" ng-model="reset_username" /> <input
												type="hidden" ng-model="reset_fullname" /> <input
												type="hidden" ng-model="reset_status" />

										</form>
									</div>

									<div class="modal-footer">
										<a class="btn btn-danger btn-ok" data-target="#myModal_reset"
											data-toggle="modal"
											ng-click="frmReset.$invalid || ResetPassword()"
											ng-disabled="frmReset.$invalid">Yes</a>

										<button type="button" class="btn btn-default"
											data-dismiss="modal">No</button>

									</div>
								</div>
							</div>
						</div>

						<!-- Modal delete -->
						<div class="modal fade" id="myModal_delete" tabindex="-1"
							role="dialog" aria-labelledby="myModalLabel">
							<div class="modal-dialog">
								<div class="modal-content">

									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-hidden="true">&times;</button>
										<h4 class="modal-title" id="myModalLabel">Confirm</h4>
									</div>

									<div class="modal-body">



										<p>Are you sure you want to delete this?</p>
									</div>

									<div class="modal-footer">
										<a class="btn btn-danger btn-ok" ng-click="deleteUsers()">Yes</a>
										<button type="button" class="btn btn-default"
											data-dismiss="modal">No</button>

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
	<script src="${pageContext.request.contextPath }/assets/js/ui-grid.js"></script>


</body>

</html>
