var app = angular.module('userLogin',['ui.bootstrap']);

app.controller('userLoginCtrl', function($scope,$http, $window){
	$scope.user = {};
	$scope.login = function(){
		
		$scope.user.email = $scope.email_login;
		$scope.user.password = $scope.password_login;

		$http.post('/login', $scope.user).success(function(data, err){

			if(data.status == 200){
					alert("Login successfully");
					$window.location.href = "/home";
				}else if(data.status == 201){
					alert("Login failure, please authenticate your account");
				}else if(data.status == 401 ){
					alert("User doesn't exist");
				}else{
					alert("some err occured");
				}
		}).error(function(data,err){
			alert("some internal error has occured");
		});
	}
	
	$scope.signup = function(){
		alert("inside signup");
		if($scope.password == $scope.password_c){
			alert("inside signup if");	
			$scope.user.firstname = $scope.firstname;
			$scope.user.lastname  = $scope.lastname;
			$scope.user.email     = $scope.email;
			$scope.user.password  = $scope.password;
			
			$http.post('/signup', $scope.user).success(function(data, err){
				if(data.status = 200){
					$window.location.href = '/authenticatePin';
				}
			}).error(function(data,err){
				alert("some internal error has occured");
			});
		}
		
	}
	
});
	
