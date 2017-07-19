<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<!-- Meta, title, CSS, favicons, etc. -->

<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />

<title>Equipment management</title>

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

</head>

<body data-ng-app="myApp" class="nav-md" data-ng-controller="listCtrl">
	<div class="container body">
		<div class="main_container">
			<div class="col-md-3 left_col">
				<div class="left_col scroll-view">


					<div class="clearfix"></div>
					<div class="profile clearfix">
						<div class="profile_pic">
							<img
								src="${pageContext.request.contextPath }/assets/images/avtar.png"
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
											href="${pageContext.request.contextPath }/admin/equipment.html">Equipment
												management</a></li>
										<li><a
											href="${pageContext.request.contextPath }/admin/user.html">User
												management</a></li>
										<li><a
											href="${pageContext.request.contextPath }/admin.html">Equipment
												management</a></li>


									</ul></li>
								<li><a> <i class="fa fa-list-ul"></i>List<span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a
											href="${pageContext.request.contextPath }/admin/list.html">List
												borrowed equipment</a></li>
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



						<%-- 			<li><a href="<c:url value='/j_spring_security_logout'/>"><i
											class="fa fa-sign-out pull-right"></i> Log Out</a></li> --%>
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
									href="${pageContext.request.contextPath }/admin/equipment.html">List
										borrowed equipment</a></li>

							</ul>
						</div>

					</div>
					<div class="title_right">
						<div class="form-group pull-right top_search">
							<!-- <button data-toggle="modal" data-target="#myModal_Add"
								type="button" class="btn btn-primary btn-lg"
								ng-click="ResetForm()">Add</button> -->
						</div>
					</div>
					<div class="clearfix"></div>
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								<div class="x_title">
									<div class="clearfix"></div>
									<h3>List Borrowed Equipment</h3>
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
						<!-- Modal add new Equipment -->
						<div class="modal fade" id="myModal_Add" tabindex="-1"
							role="dialog">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h4 class="modal-title" id="myModalLabel">Add new
											Equipment</h4>
									</div>
									<div class="modal-body row">
										<form class="form-horizontal" name="frmFormAdd"
											id="fileUploadForm">
											<div class="col-md-6">
												<div class="form-group">
													<label class=" control-label" for="">Equipment ID</label>
													<div class="">
														<input id="EquipmentId" name="EquipmentId"
															ng-keyup="hideDuplicateAlert()"
															class="form-control input-md"
															ng-keydown="autoAdd($event)" type="text"
															ng-model="add_EquipmentId" ng-required="true" />
														<div ng-messages="frmFormAdd.EquipmentId.$error">
															<div ng-message="required"
																ng-show="frmFormAdd.EquipmentId.$touched">
																<p style="color: red">This field is required</p>
															</div>
														</div>
													</div>
												</div>
												<p ng-show="duplicateAlert != ''" ng-bind="duplicateAlert"
													style="color: red"></p>

												<div class="form-group">
													<label class=" control-label" for="">Equipment Name</label>
													<div class="">
														<input id="EquipmentName" name="EquipmentName"
															class="form-control input-md" type="text"
															ng-model="add_EquipmentName" ng-required="true" />
														<div ng-messages="frmFormAdd.EquipmentName.$error">
															<div ng-message="required"
																ng-show="frmFormAdd.EquipmentName.$touched">
																<p style="color: red">This field is required</p>
															</div>
														</div>
													</div>
												</div>
												<div class="form-group">
													<label class=" control-label" for="">Quantity</label>
													<div class="">
														<input id="quantity" name="quantity"
															class="form-control input-md" type="number" min="0"
															ng-model="add_quantity" ng-required="true" />
														<div ng-messages="frmFormAdd.quantity.$error">
															<div ng-message="required"
																ng-show="frmFormAdd.quantity.$touched">
																<p style="color: red">This field is required</p>
															</div>
														</div>
													</div>
												</div>
												<div class="form-group">
													<label class=" control-label" for="">Unit</label>
													<div class="">
														<input id="unit" name="unit" class="form-control input-md"
															type="text" ng-model="add_unit" ng-required="true" />
														<div ng-messages="frmFormAdd.unit.$error">
															<div ng-message="required"
																ng-show="frmFormAdd.unit.$touched">
																<p style="color: red">This field is required</p>
															</div>
														</div>
													</div>
												</div>
												<div class="form-group">
													<label class=" control-label" for="">Note</label>
													<div class="">
														<input id="note" name="note" class="form-control input-md"
															type="text" ng-model="add_note" ng-required="true" />
														<div ng-messages="frmFormAdd.note.$error">
															<div ng-message="required"
																ng-show="frmFormAdd.note.$touched">
																<p style="color: red">This field is required</p>
															</div>
														</div>
													</div>
												</div>

												<div class="form-group">
													<label class=" control-label" for="">Category</label>
													<div class="">
														<select ng-selected="category.CategoryName"
															ng-model="add_categoryName" class="form-control"
															ng-options="x.categoryName for x in list_category"
															name="albumName" id="albumName" ng-required="true">
														</select>
														<div ng-messages="frmFormAdd.categoryName.$error">
															<div ng-message="required"
																ng-show="frmFormAdd.categoryName.$touched">
																<p style="color: red">This field is required</p>
															</div>
														</div>
													</div>
												</div>


											</div>





										</form>
									</div>
									<div class="modal-footer">
										<button id="btnSave" name="btnSave" class="btn btn-primary"
											ng-disabled="frmFormAdd.EquipmentId.$error.required || frmFormAdd.EquipmentName.$error.required||frmFormAdd.lyric.$error.required||frmFormAdd.lyric.$error.required||frmFormAdd.youtube.$error.required "
											ng-click="add(false)">Add</button>
										<button id="btnSave" name="btnSave" class="btn btn-default"
											ng-click="add(true)"
											ng-disabled="frmFormAdd.EquipmentId.$error.required || frmFormAdd.EquipmentName.$error.required||frmFormAdd.lyric.$error.required||frmFormAdd.lyric.$error.required||frmFormAdd.youtube.$error.required ">Add
											and close</button>
										<button type="button" class="btn btn-default"
											data-dismiss="modal">Close</button>

									</div>

								</div>
							</div>
						</div>

						<!-- Modal edit Equipment information -->
						<div class="modal fade" id="myModal_Edit" tabindex="-1"
							role="dialog">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h4 class="modal-title" id="myModalLabel">Edit</h4>
									</div>
									<div class="modal-body row " style="padding-left: 30px">
										<form class="form-horizontal" name="frmFormAdd"
											id="fileUploadForm">
											<div class="col-md-6">
												<div class="form-group">
												<input type="hidden" ng-model="edit_idequipment"/>
													<label class=" control-label" for="">EquipmentId</label>
													<div class="">
														<input id="EquipmentId" name="EquipmentId"
															class="form-control input-md" type="text"
															readonly="readonly" ng-model="edit_EquipmentId" />

													</div>
												</div>


												<div class="form-group">
													<label class=" control-label" for="">Equipment Name</label>
													<div class="">
														<input id="EquipmentName" name="EquipmentName"
															class="form-control input-md" type="text"
															readonly="readonly" ng-model="edit_EquipmentName" />

													</div>
												</div>
												<div class="form-group">
												<input type="hidden" ng-model="edit_employee"/>
													<label class=" control-label" for="">Employee Name</label>
													<div class="">
														<input id="employeeName" name="employeeName"
															class="form-control input-md" type="text"
															ng-model="edit_employeeId" readonly = "readonly"/>

													</div>
												</div>

												<div class="form-group">
													<label class=" control-label" for="">Quantity</label>
													<div class="">
														<input id="quantity" name="quantity"
															class="form-control input-md" type="number" min="0"
															ng-model="edit_quantity" ng-required="true" />
														<div ng-messages="frmFormAdd.quantity.$error">
															<div ng-message="required"
																ng-show="frmFormAdd.quantity.$touched">
																<p style="color: red">This field is required</p>
															</div>
														</div>
													</div>
												</div>
												<div class="form-group">
													<label class=" control-label" for="">Unit</label>
													<div class="">
														<input id="unit" name="unit" class="form-control input-md"
															type="text" ng-model="edit_unit" />

													</div>
												</div>
												<div class="form-group">
													<label class="control-label">Status</label> <input
														type="radio" ng-model="status" ng-value="true"
														ng-checked="true" /> Approved <input type="radio"
														ng-model="status" ng-value="false" />Pending


												</div>
												<div class="form-group">
													<label class=" control-label" for="">Date borrow</label>
													<div class="">
														<input id="date_return" name="date_return"
															class="form-control input-md" type="date"
															ng-model="edit_date_borrow" />

													</div>
												</div>
												<div class="form-group">
													<label class=" control-label" for="">Ngày trả</label>
													<div class="">
														<input id="date_return" name="date_return"
															class="form-control input-md" type="date"
															ng-model="edit_date_return" />

													</div>
												</div>



											</div>






										</form>
									</div>
									<div class="modal-footer">
										<button id="btnSave" name="btnSave" class="btn btn-primary"
											ng-disabled="frmFormAdd.CategoryId.$error.required || frmFormAdd.CategoryName.$error.required||frmFormAdd.lyric.$error.required||frmFormAdd.lyric.$error.required||frmFormAdd.youtube.$error.required "
											ng-click="update()">Save</button>

										<button type="button" class="btn btn-default"
											data-dismiss="modal">Close</button>

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
										<a class="btn btn-danger btn-ok" ng-click="delete()">Yes</a>
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
		src="${pageContext.request.contextPath }/assets/scripts/listCtrl.js"></script>

	<script src="${pageContext.request.contextPath }/assets/js/ui-grid.js"></script>
</body>

</html>
