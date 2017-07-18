<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Karaoke Song</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


<script src="https://code.jquery.com/jquery-2.2.4.min.js"
	integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="
	crossorigin="anonymous"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/assets/js/jquery-ui-1.8.2.custom.js"></script>
<!-- Bootstrap -->
<link
	href="${pageContext.request.contextPath }/assets/css/bootstrap.min.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath }/assets/css/base/jquery.ui.all.css"
	rel="stylesheet" />

<!-- Font Awesome -->
<link
	href="${pageContext.request.contextPath }/assets/css/font-awesome.min.css"
	rel="stylesheet" />

<!-- NProgress -->
<link
	href="${pageContext.request.contextPath }/assets/css/nprogress.css"
	rel="stylesheet" />


<!-- External Libraries-->
<link href="${pageContext.request.contextPath }/assets/css/style3.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath }/assets/css/ui-grid.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath }/assets/css/sweetalert.css"
	rel="stylesheet" />

</head>
<style>
body, h1, h2, h3, h4, h5, h6 {
	font-family: "Raleway", sans-serif
}

body, html {
	height: 100%;
	line-height: 1.8;
}

.w3-bar .w3-button {
	padding: 16px;
}

.w3-white, .w3-hover-white:hover {
	color: #ffff !important;
	background-color: #f0f0f0 !important;
	font-weight: bold;
	font-size: 19px;
}
</style>

<body ng-controller="autoCompleteCTRL" ng-app="myApp">
${sessionScope.username}
	<!-- Navbar (sit on top) -->
	<%-- <div class="w3-top">
		<div class="w3-bar w3-white w3-card-2" id="myNavbar">
			<a href="${pageContext.request.contextPath }/user.html"
				class="w3-bar-item w3-button w3-wide">Equipment</a>
			<!-- Right-sided navbar links -->
			<div class="w3-right w3-hide-small">
				<a href="${pageContext.request.contextPath }/main/welcome.html" class="w3-bar-item w3-button ">Danh sách các thiết bị đã mượn</a> <a href="<c:url value='/j_spring_security_logout'/>"
					class="w3-bar-item w3-button">Logout</a>
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


			</div>
			<!-- Hide right-floated links on small screens and replace them with a menu icon -->

			<a href="javascript:void(0)"
				class="w3-bar-item w3-button w3-right w3-hide-large w3-hide-medium"
				onclick="w3_open()"> <i class="fa fa-bars"></i>
			</a>
		</div>
	</div>

	<!-- Sidebar on small screens when clicking the menu icon -->
	<nav
		class="w3-sidebar w3-bar-block w3-black w3-card-2 w3-animate-left w3-hide-medium w3-hide-large"
		style="display:none" id="mySidebar"> <a
		href="javascript:void(0)" onclick="w3_close()"
		class="w3-bar-item w3-button w3-large w3-padding-16">Close ×</a> <a
		href="#about" onclick="w3_close()" class="w3-bar-item w3-button"
		data-ng-repeat="x in list_newVol">{{x.volName}}</a> <a href="#pricing"
		onclick="w3_close()" data-ng-repeat="x in list_album"
		class="w3-bar-item w3-button">{{x.albumName}}</a> </nav>
	<div class="row" style="padding-top: 200px">
		<div class="w3-container Custom" style="padding: 70px 0px" id="about"
			ng-hide="showme">
			<h3 class="w3-left h3" ng-model="detail_categoryName"></h3>
			<div class="row " style="padding-left: 70px">
<h2>Danh sách các thiết bị đã mượn</h2><hr>
				
				<h1 style="font-size: 30px">Tên thiết bị:
					${detail.equipmentName}</h1>
				<h5>Mã : ${detail.equipmentId}</h5>
				<h3>Mô tả :${detail.status}</h3>

				<h3>Trạng thái</h3>

				<button ng-click="borrow()" class="btn btn-primary"
					data-toggle="modal" data-target="#myModal_Add">Mượn</button>


			</div>
			<div class="modal fade" id="myModal_Add" tabindex="-1" role="dialog">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title" id="myModalLabel">Đăng kí mượn thiết
								bị</h4>
						</div>
						<div class="modal-body row " style="padding-left: 30px">
							<form class="form-horizontal" name="frmFormAdd"
								id="fileUploadForm">
								<div class="col-md-6">
									<div class="form-group">
										<label class=" control-label" for="">Mã thiết bị</label>
										<div class="">
											<input id="EquipmentId" name="EquipmentId"
												class="form-control input-md" type="text"
												readonly="readonly" ng-model="add_EquipmentId" />

										</div>
									</div>


									<div class="form-group">
										<label class=" control-label" for="">Tên thiết bị</label>
										<div class="">
											<input id="EquipmentName" name="EquipmentName"
												class="form-control input-md" type="text"
												readonly="readonly" ng-model="add_EquipmentName" />

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
												type="text" ng-model="add_unit" readonly="readonly" />

										</div>
									</div>
									<div class="form-group">
										<label class=" control-label" for="">Note</label>
										<div class="">
											<input id="note" name="note" class="form-control input-md"
												type="text" ng-model="add_note" />

										</div>
									</div>
									<div class="form-group">
										<label class=" control-label" for="">Ngày trả</label>
										<div class="">
											<input id="date_return" name="date_return"
												class="form-control input-md" type="date"
												ng-model="add_date_return" />

										</div>
									</div>



								</div>






							</form>
						</div>
						<div class="modal-footer">
							<button id="btnSave" name="btnSave" class="btn btn-primary"
								ng-disabled="frmFormAdd.CategoryId.$error.required || frmFormAdd.CategoryName.$error.required||frmFormAdd.lyric.$error.required||frmFormAdd.lyric.$error.required||frmFormAdd.youtube.$error.required "
								ng-click="add">Add</button>

							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>

						</div>

					</div>
				</div>
			</div>


		</div>
	</div>


	<footer class="w3-right w3-padding-64"> <a href=""
		onclick="topFunction()" style="background: #f0f0f0 !important"
		class="w3-button w3-light-grey"><i
		class="fa fa-arrow-up w3-margin-right"></i>To the top</a>
	<div class="w3-xlarge w3-section"></div>

	</footer>
	<!-- Add Google Maps -->

	<script>
		// Modal Image Gallery
		function onClick(element) {
			document.getElementById("img01").src = element.src;
			document.getElementById("modal01").style.display = "block";
			var captionText = document.getElementById("caption");
			captionText.innerHTML = element.alt;
		}

		// Toggle between showing and hiding the sidebar when clicking the menu icon
		var mySidebar = document.getElementById("mySidebar");

		function w3_open() {
			if (mySidebar.style.display === 'block') {
				mySidebar.style.display = 'none';
			} else {
				mySidebar.style.display = 'block';
			}
		}

		// Close the sidebar with the close button
		function w3_close() {
			mySidebar.style.display = "none";
		}
	</script> --%>
</body>
<!-- jQuery -->

<!-- Bootstrap -->
<script
	src="${pageContext.request.contextPath }/assets/js/bootstrap.min.js"></script>

<!-- FastClick -->
<script src="${pageContext.request.contextPath }/assets/js/fastclick.js"></script>

<!-- NProgress -->
<script src="${pageContext.request.contextPath }/assets/js/nprogress.js"></script>

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
	src="${pageContext.request.contextPath }/assets/scripts/autoCompleteCTRL.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/ui-grid.js"></script>
<script>
	function topFunction() {
		document.body.scrollTop = 0; // For Chrome, Safari and Opera 
		document.documentElement.scrollTop = 0; // For IE and Firefox
	}
</script>
</html>