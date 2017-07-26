<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Music</title>
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
	color: white !important;
	background-color: #718fc6 !important;
	font-weight: bold;
	font-size: 19px;
}
</style>

<body>
	<nav class="navbar navbar-default" style="background:#718fc6">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" style="color: white;font-weight:bold;font-size:24px" href="${pageContext.request.contextPath }/user.html">Logo</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1" >
			<ul class="nav navbar-nav" >
				<li ><a href="${pageContext.request.contextPath }/user/album.html" style="color:white">Album</a></li>
				<li><a href="${pageContext.request.contextPath }/user/singer.html" style="color:white">Singer</a></li>
				<li><a href="${pageContext.request.contextPath }/user/genre.html" style="color:white">Genre</a></li>

			</ul>
			<ul class="nav navbar-nav navbar-right">

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					style="color: white" data-toggle="dropdown" role="button"
					aria-haspopup="true" aria-expanded="false">Cá nhân<span
						class="caret"></span></a>
					<ul class="dropdown-menu">

						<li><a href="<c:url value='/j_spring_security_logout'/>">Đăng
								xuất</a></li>

					</ul></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	
	<!-- /.container-fluid --> </nav>
	<div class="w3-content" style="max-width: 1100px">


		<!-- Menu Section -->
		<div class="w3-row w3-padding-64">
			<div class=" l6 w3-padding-large">
			
				<c:forEach var="detail_genre" items="${detail_genre}">
					<h4><a href="${pageContext.request.contextPath}/user/detail/${detail_genre.id}.html">${detail_genre.songName}</a></h4>
					<h6>${detail_genre.singer.singerName}</h6>
					<p class="w3-text-grey">${detail_genre.lyric}</p>
					<hr>
				</c:forEach>

			</div>


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




	<!-- Footer -->

	<footer class="w3-right w3-padding-64"> <a href=""
		onclick="topFunction()"
		style="background: #718fc6 !important; color: white !important"
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
<script src="${pageContext.request.contextPath }/assets/js/ui-grid.js"></script>
<script>
	function topFunction() {
		document.body.scrollTop = 0; // For Chrome, Safari and Opera 
		document.documentElement.scrollTop = 0; // For IE and Firefox
	}
</script>
</html>