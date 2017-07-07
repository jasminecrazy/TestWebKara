<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8" />
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
										<li><a href="#/giaovien">Song management</a></li>

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
				<li>
					<i class="ace-icon fa fa-home home-icon"></i>
					<a href="${pageContext.request.contextPath }/admin/welcome">Home</a>
				</li>
				<li class="active">
					<a href="admin/song">Song Management</a>
				</li>
				
			</ul>
		</div>

	</div>
	<div class="title_right">
			<div class="form-group pull-right top_search">
				<button data-toggle="modal" data-target="#myModal_them"
					type="button" class="btn btn-primary btn-lg" ng-click="loadthem()">Add</button>
			</div>
		</div> 
	<div class="clearfix"></div>
	<div class="row">
		<div class="col-md-12 col-sm-12 col-xs-12">
			<div class="x_panel">
				<div class="x_title">
					<div class="clearfix"></div>
				</div>
				<div class="col-md-6 pull-right">
					<input id="filter" type="text" placeholder="Find"
						class="form-control" data-ng-model="filterTable"></input>
				</div>

				<div class="x_content">
					<label for="mySelect">Show</label> <select name="mySelect"
						id="mySelect"
						ng-options="option.name for option in rowdata.availableOptions track by option.id"
						ng-model="rowdata.selectedOption"
						ng-change="ChangeRow(rowdata.selectedOption.id)">
					</select> <label>Row</label>
					
					<div class="table-responsive">
						<table class="table table-condensed table-hover">
							<thead>
								<tr>
									<th style="width: 3%">&#35;</th>
									<th class="sortable" style="width: 5%"
										ng-click="sortType = 'songId';sortReverse = !sortReverse">Song ID
										<span
										ng-show="sortType == 'songId' &amp;&amp; !sortReverse"
										class="fa fa-caret-down"></span> <span
										ng-show="sortType == 'songId' &amp;&amp; sortReverse"
										class="fa fa-caret-up"></span>
									</th>
									<th class="sortable" style="width: 10%"
										ng-click="sortType = 'songName';sortReverse = !sortReverse">Song Name
										<span
										ng-show="sortType == 'songName' &amp;&amp; !sortReverse"
										class="fa fa-caret-down"></span> <span
										ng-show="sortType == 'songName' &amp;&amp; sortReverse"
										class="fa fa-caret-up"></span>
									</th>
									<th class="sortable" style="width: 10%"
										ng-click="sortType = 'lyric';sortReverse = !sortReverse">Lyric
										<span
										ng-show="sortType == 'lyric' &amp;&amp; !sortReverse"
										class="fa fa-caret-down"></span> <span
										ng-show="sortType == 'lyric' &amp;&amp; sortReverse"
										class="fa fa-caret-up"></span>
									</th>
									<th class="sortable" style="width: 10%"
										ng-click="sortType = 'author';sortReverse = !sortReverse">Author
										<span
										ng-show="sortType == 'author' &amp;&amp; !sortReverse"
										class="fa fa-caret-down"></span> <span
										ng-show="sortType == 'author' &amp;&amp; sortReverse"
										class="fa fa-caret-up"></span>
									</th>
									
									

								

									<th style="width: 10%">Action</th>

								</tr>
							</thead>
							<tbody>
								<!-- <tr data-ng-show="showList(x,$index)" data-ng-repeat="x in list |  orderBy:sortType:sortReverse| filter : filterTable"">
									<td ng-bind="$index+1"><input type="hidden"
										ng-model="x.id" /></td>
									<td data-ng-bind="x.maso"></td>
									<td data-ng-bind="x.ten"></td>
									<td data-ng-bind="x.loi"></td>
									<td data-ng-bind="x.thongtin"></td>
									

									<td>
										<button data-toggle="modal" class="btn btn-success btn-sm"
											data-tooltip="tooltip" title="View detail informations"
											data-target="#myModal_detail" ng-click="chitiet(x)">
											<span class="glyphicon glyphicon-eye-open"></span>
										</button>
										<button class="btn btn-primary btn-sm" ng-click="sua(x)"
											data-tooltip="tooltip" title="Edit" data-toggle="modal"
											data-target="#myModal_sua">
											<span class="glyphicon glyphicon-edit"></span>
										</button>
										<button data-toggle="modal" class="btn btn-danger btn-sm"
											data-tooltip="tooltip" title="Delete"
											data-target="#myModal_xoa" ng-click="xoa(x)">
											<i class="ace-icon fa fa-trash-o bigger-130"></i>
										</button>
									</td>
								</tr> -->
							</tbody>
						</table>

					</div>
					<div class='pull-right'>
						<uib-pagination
							data-total-items="(list | filter:filterTable).length"
							data-ng-model="currentPage" data-ng-change="updatePageIndexes()"
							data-max-size="maxPaginationSize"
							data-items-per-page="itemsPerPage" data-boundary-links="true"
							data-previous-text="&lsaquo;" data-next-text="&rsaquo;"
							data-first-text="&laquo;" data-last-text="&raquo;">
						</uib-pagination>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal thÃªm -->
	<!-- <div class="modal fade" id="myModal_them" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">ThÃªm thÃ´ng tin tráº»</h4>
				</div>
				<div class="modal-body row">
					<form class="form-horizontal" name="frmStudentAdd"
						enctype="multipart/form-data" id="fileUploadForm">
						<div class="col-md-6">
							Text input
							<div class="form-group">
								<label class=" control-label" for="">MÃ£ tráº»</label>
								<div class="">
									<input id="username" name="username"
										ng-keyup="hideDuplicateAlert()" class="form-control input-md"
										ng-keydown="autoAdd($event)" type="text"
										ng-model="add_username" ng-required="false" />
								</div>
							</div>
							<p ng-show="duplicateAlert != ''" ng-bind="duplicateAlert"
								style="color: red"></p>
							Text input
							<div class="form-group">
								<label class=" control-label" for="">Há»� vÃ  tÃªn tráº»</label>
								<div class="">
									<input id="studentName" name="studentName"
										class="form-control input-md" type="text"
										ng-model="add_studentName" ng-required="false" />
								</div>
							</div>
							<div class="form-group">
								<label class=" control-label" for="birthday">NgÃ y Sinh</label>
								<div class="">
									<input id="birthday" name="birthday" placeholder=""
										ng-model="birthday" class="form-control input-md" type="date" />

								</div>
							</div>
							Text input
							<div class="form-group">
								<label class="control-label">Giá»›i tÃ­nh</label>
								<div class="checkbox">
									<label> <input type="radio" ng-model="gender" value="0"
										name="gender" ng-value="0" /> Nam
									</label> <label> <input type="radio" ng-model="gender"
										value="1" name="gender" ng-value="1" /> Ná»¯
									</label>
								</div>


							</div>
							Text input
							<div class="form-group">
								<label class=" control-label" for="birthday">Ä�á»‹a chá»‰</label>
								<div class="">
									<textarea id="address" name="address" rows="5"
										class="form-control input-md" type="text"
										ng-model="add_address"></textarea>

								</div>
							</div>
							<div class="form-group">
								<label class=" control-label" for="birthday">NgÃ y vÃ o
									trÆ°á»�ng</label>
								<div class="">
									<input id="ngayvaotruong" name="ngayvaotruong" placeholder=""
										class="form-control input-md" type="date" ng-required="true"
										ng-model="add_ngayvaotruong" />

								</div>
							</div>
							<div class="form-group">
								<label class="control-label">TÃ¬nh tráº¡ng sá»©c khá»�e</label> <input
									id="healthStatus" name="healthStatus" placeholder=""
									class="form-control input-md" type="text"
									ng-model="add_healthStatus" />


							</div>
							<div class="form-group">
								<label class="control-label">Há»� tÃªn phá»¥ huynh</label> <input
									id="parentName" name="parentName" placeholder=""
									class="form-control input-md" type="text"
									ng-model="add_parentName" />


							</div>
							<div class="form-group">
								<label class="control-label">Sá»‘ Ä‘iá»‡n thoáº¡i</label> <input
									id="phone" name="phone" placeholder=""
									class="form-control input-md" type="text"
									ng-model="add_phone" />


							</div>
							<div class="form-group">
								<label class="control-label" for="selectbasic">Lá»›p</label>
								<div class="">
									<select ng-selected="student.class" ng-model="add_className"
										class="form-control"
										ng-options="x.tenlop for x in list_class" name="className"
										id="className" ng-required="true">
									</select>
								</div>
							</div>
						</div>





					</form>
				</div>
				<div class="modal-footer">
					<button id="btnSave" name="btnSave" class="btn btn-primary"
						ng-click="them(false)">Add</button>
					<button id="btnSave" name="btnSave" class="btn btn-default"
						ng-click="them(true)">Add and close</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>

				</div>

			</div>
		</div>
	</div> -->
	<!-- Modal-->
	<!-- Modal sá»­a -->
	<!-- <div class="modal fade" id="myModal_sua" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Sá»­a thÃ´ng tin tráº»</h4>
				</div>
				<div class="modal-body row">
					<form class="form-horizontal" name="editForm">
						<div class="col-md-6">
							- text input
							<input type="hidden" name="id" ng-model="edit_id" /> <input
								type="hidden" name="username" ng-model="edit_username" />

							Text input
							<div class="form-group">
								<label class="control-label" for="lastName"> Há»� vÃ  tÃªn
									tráº»</label>
								<div class="">
									<input id="studentName" name="studentName" placeholder=""
										class="form-control input-md" type="text"
										ng-model="edit_studentName" ng-required="true" />

								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="birthday">Birthday</label>
								<div class="">
									<input id="birthday" name="birthday" placeholder=""
										ng-model="edit_birthday" class="form-control input-md"
										type="date" />

								</div>
							</div>
							<div class="form-group">
								<label class=" control-label" for="birthday">Ä�á»‹a chá»‰</label>
								<div class="">
									<input id="address" name="address"
										class="form-control input-md" type="text"
										ng-model="edit_address" />
								</div>
							</div>
							Text input
							<div class="form-group">
								<label class=" control-label">NgÃ y vÃ o trÆ°á»�ng</label>
								<div class="">
									<input id="ngayvaotruong" name="ngayvaotruong"
										class="form-control input-md" type="date"
										ng-model="edit_ngayvaotruong" />

								</div>
							</div>
							<div class="form-group">
								<label class="control-label">Gender</label>
								<div class="checkbox">
									<label> <input type="radio" ng-model="edit_gender"
										value="0" name="gender" /> Nam
									</label> <label> <input type="radio" ng-model="edit_gender"
										value="1" name="gender" /> Ná»¯
									</label>
								</div>
							</div>
						</div>
						<div class="col-md-6">

							Text input
							<div class="form-group">
								<label class=" control-label" for="birthday">TÃ¬nh tráº¡ng
									sá»©c khá»�e</label>
								<div class="">
									<input id="healthStatus" name="healthStatus" placeholder=""
										class="form-control input-md" type="text" ng-required="true"
										ng-model="edit_healthStatus" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="selectbasic">Lá»›p</label>
								<div class="">
									<select ng-selected="student.class" ng-model="edit_className"
										class="form-control" ng-options="x.tenlop for x in list_class"
										name="className" id="className" ng-required="true">
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label">Há»� tÃªn phá»¥ huynh</label> <input
									id="parentName" name="parentName" placeholder=""
									class="form-control input-md" type="text"
									ng-model="edit_parentName" />


							</div>
							<div class="form-group">
								<label class="control-label">Sá»‘ Ä‘iá»‡n thoáº¡i</label> <input
									id="phone" name="phone" placeholder=""
									class="form-control input-md" type="text"
									ng-model="edit_phone" />


							</div>
							<div class="form-group">
							<label class="control-label">Tráº¡ng thÃ¡i</label>
							<div class="" style="padding: 6px">
								<input type="radio" ng-model="active" ng-value="true" />
								CÃ²n há»�c <input type="radio" ng-model="active" ng-value="false" />
								Ä�Ã£ nghá»‰
							</div>
						</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">

					<button id="btnSave" name="btnSave" class="btn btn-primary"
						ng-click="update()" data-dismiss="modal">Save</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div> -->
	<!-- Modal xem chi tiáº¿t -->
	<!-- <div class="modal fade" id="myModal_detail" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">ThÃ´ng tin chi tiáº¿t</h4>
				</div>
				<div class="modal-body row">
					<form class="form-horizontal" name="frmStudentView">
						<div class="col-md-6">



							Text input
							<div class="form-group">
								<label class="control-label" for="lastName">MÃ£ Tráº»</label>
								<div class="">
									<input id="username" name="username" placeholder=""
										class="form-control input-md" type="text"
										ng-model="chitiet.username" readonly="readonly"
										ng-required="true" />
								</div>
							</div>

							Text input
							<div class="form-group">
								<label class="control-label" for="firstName">Há»� vÃ  TÃªn
									tráº»</label>
								<div class="">
									<input id="firstName" name="firstName" placeholder=""
										class="form-control input-md" type="text" ng-required="true"
										ng-model="chitiet.firstname" readonly="readonly" />
								</div>
							</div>
							Text input
							<div class="form-group">
								<label class="control-label" for="birthday">NgÃ y Sinh</label>
								<div class="">
									<input id="birthday" name="birthday"
										class="form-control input-md" type="text"
										ng-model="chitiet.birthday" readonly="readonly" />
									<p>{{chitiet.birthday}}</p>
								</div>
							</div>
							Text input
							<div class="form-group">
								<label class="control-label" for="address">Ä�á»‹a chá»‰</label>
								<div class="">
									<input type="text" id="adress" name="address" placeholder=""
										rows="5" class="form-control input-md" type="text"
										ng-model="chitiet.address" readonly="readonly" />

								</div>
							</div>
							Text input
							<div class="form-group">
								<label class="control-label" for="address">NgÃ y vÃ o
									trÆ°á»�ng</label>
								<div class="">
									<input type="date" id="ngayvaotruong" name="ngayvaotruong"
										placeholder="" class="form-control input-md"
										ng-model="chitiet.ngayvaotruong" readonly="readonly" />

								</div>
							</div>
							Text input
							<div class="form-group">
								<label class="control-label" for="address">TÃ¬nh tráº¡ng
									sá»©c khá»�e</label>
								<div class="">
									<input type="text" id="healthStatus" name="healthStatus"
										placeholder="" class="form-control input-md"
										ng-model="chitiet.healthStatus" readonly="readonly" />

								</div>
							</div>
							

						</div>
						<div class="col-md-6">

							Text input
							<div class="form-group">
								<label class=" control-label" for="gender">Giá»›i TÃ­nh</label>
								<div class="col-md-12">
									<p>{{chitiet.gender ? 'Ná»¯' : 'Nam'}}</p>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label">Há»� tÃªn phá»¥ huynh</label> <input
									id="parentName" name="parentName" placeholder=""
									class="form-control input-md" type="text"
									ng-model="chitiet.parentName" />


							</div>
							<div class="form-group">
								<label class="control-label">Sá»‘ Ä‘iá»‡n thoáº¡i</label> <input
									id="phone" name="phone" placeholder=""
									class="form-control input-md" type="text"
									ng-model="chitiet.phone" />


							</div>

						</div>

					</form>

				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div> -->
	<!-- Modal xÃ³a -->
	<!-- <div class="modal fade" id="myModal_xoa" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog">
			<div class="modal-content">

				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">XÃ¡c nháº­n</h4>
				</div>

				<div class="modal-body">

					<input type="hidden" ng-model="student_delete.id" />

					<p>Báº¡n cÃ³ cháº¯c cháº¯n muá»‘n xÃ³a khÃ´ng?</p>
				</div>

				<div class="modal-footer">
					<a class="btn btn-danger btn-ok" ng-click="deleteStudent()">CÃ³</a>
					<button type="button" class="btn btn-default" data-dismiss="modal">KhÃ´ng</button>

				</div>
			</div>
		</div>
	</div> -->

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
