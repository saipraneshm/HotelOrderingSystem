app = angular.module('myApp');
app.controller('item_add',['$scope','$http', function($scope, $http){
console.log("heyy aasha na swaasa");
$scope.add=function(){
console.log('Heyy!! I am clicked');
console.log($scope.item_price);
var menu={"name":$scope.item_name,"imagePath":$scope.item_path,"unitPrice":parseFloat($scope.item_price),"calories":$scope.item_calories,"preparationTime":$scope.item_time,"category":$scope.item_category,"quantity":1};
$http.post('/item_add',menu).success(function(response){
	console.log('reached backk');
	   location.reload(); 

})	
}
}]);