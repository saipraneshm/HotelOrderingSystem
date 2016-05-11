app = angular.module('myApp');
app.controller('admin_login',['$scope','$http', function($scope, $http){
console.log("In admin Login Controller");
$scope.submit=function(){

console.log('submit button clicked');
var details={"username":$scope.username,"password":$scope.password};
//var data={details:JSON.stringify(details)}
$http.post('/verify',details).success(function(result){
	if(result.status[0]==200)
	window.location.replace('/addMenuItem');
	else
		alert("Invalid Username and Password");
})


}	
}
]);