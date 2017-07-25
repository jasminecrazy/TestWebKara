
var app = angular.module('myApp', ['ui.bootstrap','ngResource','ngMessages', 'ui.grid','ui.grid.pagination','ui.grid.selection']);
/*app.config(function($routeProvider, $locationProvider) {
	$locationProvider.hashPrefix('');
	$routeProvider.when("/", {
		templateUrl : "song.html",
		controller : "songCtrl"
	
	}).when("/user", {
		templateUrl : " user.html",
		controller : "userCtrl"
		
	
	})


	});*/
function alertDeleteSucess() {
	swal({
		title : "",
		text : "Delete successfully.",
		type : "success",
		timer : alertDuration,
		showConfirmButton : false
	});
}
function alertDelete() {
	swal({
		title : "Are you sure you want to delete this?",
		text : "",
		type : "warning",
		timer : alertDuration,
		 showCancelButton: true,   
		    confirmButtonColor: "#DD6B55",
		    confirmButtonText: "Yes"
	});
}