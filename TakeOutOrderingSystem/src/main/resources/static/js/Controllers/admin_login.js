app = angular.module('myApp');
app.controller('admin_login',['$scope','$http', function($scope, $http){
console.log("In admin Login Controller");
$scope.submit=function(){

console.log('submit button clicked');
var data={"username":$scope.username,"password":$scope.password};
}	
}
]);