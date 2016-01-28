'use strict';

var app = angular.module("forecastApp", []);
app.config(function($httpProvider) {
	//Enable cross domain calls
	$httpProvider.defaults.useXDomain = true;
});		
app.controller("ForecastListCtrl", function($scope, $http) {

	$http.get("/acciones2/companys/json/list")
	.success(function(data){
		$scope.companies = data;
	});
	
});