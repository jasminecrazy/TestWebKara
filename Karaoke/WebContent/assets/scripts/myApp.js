var app = angular.module('myApp', ['ngRoute', 'ui.bootstrap', 'ngResource',
		'ngMessages' ]);
app.config(function($routeProvider, $locationProvider) {
	$locationProvider.hashPrefix('');
	$routeProvider.when("/", {
		templateUrl : "song.html",
		controller : "songCtrl"
	
	}).when("/user", {
		templateUrl : " user.html",
		controller : "userCtrl"
		
	
	})


	});