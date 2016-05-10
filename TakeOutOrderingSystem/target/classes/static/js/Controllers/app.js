var app = angular.module('myApp', []);
app.controller('mainController', function($scope, $http){
	
	
	
	$scope.clicked = function(){
		
		console.log("I received the click");
	
		
	}
});