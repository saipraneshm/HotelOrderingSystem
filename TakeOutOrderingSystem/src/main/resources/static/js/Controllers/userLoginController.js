var app = angular.module('userLogin',['ui.bootstrap']);

app.controller('userLoginCtrl', function($scope,$http, $window){
	$scope.user = {};
	$scope.login = function(){
		
		$scope.user.email = $scope.email_login;
		$scope.user.password = $scope.password_login;
	
		 $http.post('/login', $scope.user).success(function(data, err){
			if(data.status = 200){
				alert("Login successfully");
				
			}
		}).error(function(data,err){
			alert("some internal error has occured");
		});
	}
	
	$scope.signup = function(){
		if($scope.password == $scope.password_c){
			
			$scope.user.firstname = $scope.firstname;
			$scope.user.lastname  = $scope.lastname;
			$scope.user.email     = $scope.email;
			$scope.user.password  = $scope.password;
			
			$http.post('/signup', $scope.user).success(function(data, err){
				if(data.status = 200){
					alert("navigate to pin enter page");
					$window.location.href = '/authenticatePin';
				}
			}).error(function(data,err){
				alert("some internal error has occured");
			});
		}
		
	}
	
});
	
