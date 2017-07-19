<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh sách trang thiết bị</title>
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
	color: #00000 !important;
	background-color: #f0f0f0 !important;
	font-weight: bold;
	font-size: 19px;
}
</style>

<body ng-controller="autoCompleteCTRL" ng-app="myApp">
	<!-- Navbar (sit on top) -->
	<div class="w3-top">
		<div class="w3-bar w3-white w3-card-2" id="myNavbar">
			<a href="${pageContext.request.contextPath }/demo.html"
				class="w3-bar-item w3-button w3-wide">Logo</a>
			<!-- Right-sided navbar links -->
			<div class="w3-right w3-hide-small">

				<a
					href="${pageContext.request.contextPath }/user/detail/${pageContext.request.userPrincipal.name }.html"
					class="w3-bar-item w3-button ">Xem Danh sách thiết bị đã mượn</a> <a
					href="<c:url value='/j_spring_security_logout'/>"
					class="w3-bar-item w3-button">Logout</a>

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
	<!-- <div class="row" style="padding-top: 200px">
		<div class="row t " style="margin-left: 100px">
			<h1>Danh sách thiết bị</h1>
			<hr>
			<div data-ng-repeat="x in list_equipment">
				<div class="row">
					<label>Tên thiết bị: </label>
					<h3 data-ng-bind="x.equipmentName"></h3>
				</div>
				Mô tả :
				<p data-ng-bind="x.status"></p>
				Số lượng
				<p data-ng-bind="x.quantity"></p>
				<button ng-click="borrow(x)" class="btn btn-primary"
					data-toggle="modal" data-target="#myModal_Add">Mượn</button>
				<hr>
			</div>
		</div>
	</div> -->
<div class="w3-row-padding w3-center" style="margin-top:200px" >
		<div class="w3-third" data-ng-repeat="x in list_equipment" data-ng-show="showList(x,$index)">
			<div class="w3-card-2" style="min-height: 460px">
				<h3 style="color:blue; padding-top:10px">{{x.equipmentName}}</h3>
				<br> <i class="fa fa-desktop w3-margin-bottom w3-text-theme"
					style="font-size: 120px"></i>
				<p style="font-weight:bold">Mô tả: {{x.status}}</p>
				<p>Tình trạng: {{x.quantity > 0 ? 'Còn':'Hết'}}</p>
				<button ng-click="borrow(x)" class="btn btn-primary"
					data-toggle="modal" data-target="#myModal_Add">Mượn</button>
				
			</div>
		</div>

		
	</div> 
	<div class='w3-center'>
			<uib-pagination data-total-items="list_equipment.length"
				data-ng-model="currentPage" data-ng-change="updatePageIndexes()"
				data-max-size="maxPaginationSize" data-items-per-page="itemsPerPage"
				data-boundary-links="true" data-previous-text="&lsaquo;"
				data-next-text="&rsaquo;" data-first-text="&laquo;"
				data-last-text="&raquo;"> </uib-pagination>
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
					<form class="form-horizontal" name="frmFormAdd" id="fileUploadForm">
						<div class="col-md-6">
							<div class="form-group">
								<label class=" control-label" for="">Mã thiết bị</label>
								<div class="">
									<input id="EquipmentId" name="EquipmentId"
										class="form-control input-md" type="text" readonly="readonly"
										ng-model="add_EquipmentId" />

								</div>
							</div>


							<div class="form-group">
								<label class=" control-label" for="">Tên thiết bị</label>
								<div class="">
									<input id="EquipmentName" name="EquipmentName"
										class="form-control input-md" type="text" readonly="readonly"
										ng-model="add_EquipmentName" />

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
								<label class=" control-label" for="">Mã nhân viên</label>
								<div class="">
									<input id="employeeName" name="employeeName"
										class="form-control input-md" type="text"
										ng-model="add_employeeId" ng-required="true" />

								</div>
								<div ng-messages="frmFormAdd.employeeName.$error">
									<div ng-message="required"
										ng-show="frmFormAdd.employeeName.$touched">
										<p style="color: red">This field is required</p>
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
								<label class=" control-label" for="">Ngày trả</label>
								<div class="">
									<input id="date_return" name="date_return"
										class="form-control input-md" type="date"
										ng-model="add_date_return" />

								</div>
								<div ng-messages="frmFormAdd.date_return.$error">
									<div ng-message="required"
										ng-show="frmFormAdd.date_return.$touched">
										<p style="color: red">This field is required</p>
									</div>
								</div>
							</div>



						</div>






					</form>
				</div>
				<div class="modal-footer">
					<button id="btnSave" name="btnSave" class="btn btn-primary"
						ng-disabled="frmFormAdd.date_return.$error.required ||frmFormAdd.quantity.$error.required||frmFormAdd.employeeName.$error.required"
						ng-click="add()">Mượn</button>

					<button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>

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
	</script>
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