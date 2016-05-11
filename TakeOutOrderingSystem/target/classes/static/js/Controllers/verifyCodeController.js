var app = angular.module('verifyCodeApp',[]);

app.controller('verifyCodeCtrl',function($http,$scope,$window){
	
	$scope.user = {};
	$scope.validatePin = function(){
		$scope.user.activationCode = $scope.pin;
		alert(JSON.stringify($scope.user));
		$http.post("/validatePin",$scope.user)
		.success(function(data, err){
			if(data.status == 200){
				alert("Validation Successful");
				$window.location.href = "/home";
			}else{
				alert("Validation Failure");
			}
		})
		.error(function(data,err){
			alert("some internal error has occured");
		});
	}
});