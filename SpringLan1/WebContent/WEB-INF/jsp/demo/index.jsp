<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Karaoke Song</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">
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
	background-color: #f39c12 !important;
	font-weight: bold;
	font-size: 19px;
}
</style>

<body ng-controller="indexCtrl" ng-app="myApp">
	<!-- Navbar (sit on top) -->
	<div class="w3-top">
		<div class="w3-bar w3-white w3-card-2" id="myNavbar">
			<a href="${pageContext.request.contextPath }/demo.html"
				class="w3-bar-item w3-button w3-wide">Tìm kiếm mã số karaoke</a>
			<!-- Right-sided navbar links -->
			<div class="w3-right w3-hide-small">
				<a href="${pageContext.request.contextPath }/demo/karaoke.html"
					class="w3-bar-item w3-button ">Karaoke 6 số</a> <a
					href="${pageContext.request.contextPath }/demo/detail/{{x.id}}.html"
					ng-model="volid" class="w3-bar-item w3-button"
					data-ng-repeat="x in list_newVol" ng-click="GetVolSongId(x.id)">{{x.volName}}</a>
				<a
					href="${pageContext.request.contextPath }/demo/albumdetail/{{x.id}}.html"
					class="w3-bar-item w3-button" data-ng-repeat="x in list_album">{{x.albumName}}</a>

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
	<div class="row w3-center t" style="padding-top: 100px">

		<h3>Tìm kiếm mã số bài hát...</h3>

		<div class="wrapper">
			<input class="search" type="text" id="songName" ng-model="keyword"
				placeholder="Nhập từ khóa cần tìm" name="keyword" /> <input
				class="submit" type="submit" value=" " ng-click=Search() />


		</div>
	</div>
	<div class="" ng-show="result">
		<h3>Kết quả tìm kiếm</h3>
		<div class="">
			<div id="songs-container ">
				<ul>

					<li data-ng-repeat="x in list_searchSong">
						<div class="song">
							<div class="row test">

								<p class="songId">
									{{x.maso}}<span
										style="font-size: 14px !important; text-transform: uppercase !important;">{{x.volume.volName}}</span>
								</p>
								<h1 class="songName">
									<a
										href="${pageContext.request.contextPath }/demo/detailSong/{{x.id}}.html">{{x.ten}}</a>
								</h1>
								<h4 class="SongLyric">{{x.loi}}</h4>
								<h3 class="author">{{x.thongtin}}</h3>

							</div>
						</div>

					</li>

				</ul>
			</div>
		</div>
	</div>
	<!-- Team Section -->
	<div class="col-md-6" id="team" ng-hide="showme">
		<h3 class="w3-left h3">Karaoke Vol Mới</h3>

		<div class="w3-row-padding w3-grayscale">
			<div class="">
				<div id="songs-container ">
					<ul>

						<li data-ng-repeat="x in list_NewestSong">
							<div class="song">
								<div class="row test">

									<p class="songId">
										{{x.maso}}<span
											style="font-size: 14px !important; text-transform: uppercase !important;">{{x.volume.volName}}</span>
									</p>
									<h1 class="songName">
										<a
											href="${pageContext.request.contextPath }/demo/detailSong/{{x.id}}.html">{{x.ten}}</a>
									</h1>
									<h4 class="SongLyric">{{x.loi}}</h4>
									<h3 class="author">{{x.thongtin}}</h3>

								</div>
							</div>

						</li>

					</ul>
				</div>
			</div>
		</div>


	</div>
	<div class="col-md-6" id="team" ng-hide="showme">
		<h3 class="w3-left h3">Bài hát yêu thích</h3>

		<div class="w3-row-padding w3-grayscale">
			<div class="">
				<div id="songs-container ">
					<ul>

						<li data-ng-repeat="x in list_favoriteSong">
							<div class="song">
								<div class="row test">

									<p class="songId">
										{{x.maso}}<span
											style="font-size: 14px !important; text-transform: uppercase !important;">{{x.volume.volName}}</span>
									</p>
									<h1 class="songName">
										<a
											href="${pageContext.request.contextPath }/demo/detailSong/{{x.id}}.html">{{x.ten}}</a>
									</h1>
									<h4 class="SongLyric">{{x.loi}}</h4>
									<h3 class="author">{{x.thongtin}}</h3>

								</div>
							</div>

						</li>

					</ul>
				</div>
			</div>
		</div>


	</div>
	<!-- Footer -->
	
	<footer class="w3-right w3-padding-64"> <a href="" onclick="topFunction()" style="background:#f39c12!important"
		class="w3-button w3-light-grey"><i
		class="fa fa-arrow-up w3-margin-right" ></i>To the top</a>
	<div class="w3-xlarge w3-section"></div>

	</footer>
	<!-- Add Google Maps -->


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
	src="${pageContext.request.contextPath }/assets/scripts/indexCtrl.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/ui-grid.js"></script>
<script>
function topFunction() {
    document.body.scrollTop = 0; // For Chrome, Safari and Opera 
    document.documentElement.scrollTop = 0; // For IE and Firefox
}

</script>
</html>