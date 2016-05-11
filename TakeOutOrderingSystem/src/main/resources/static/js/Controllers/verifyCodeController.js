var app = angular.module('verifyCodeApp',[]);

app.controller('verifyCodeCtrl',function($http,$scope,$window){
	
	$scope.user = {};
	$scope.validatePin = function(){
		$scope.user.activationCode = $scope.pin;
		$http.post("/validatePin",$scope.user)
		.success(function(data, err){
			if(data.status == 200){
				$window.location.href = "/home";
			}else{
				alert("Validation Failure, Please re-enter your pin");
			}
		})
		.error(function(data,err){
			alert("some internal error has occured");
		});
	}
});