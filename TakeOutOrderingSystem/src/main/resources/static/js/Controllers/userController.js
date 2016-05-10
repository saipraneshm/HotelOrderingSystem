

var app = angular.module("myApp",['ui.router','ui.bootstrap']);

app.controller("userCtrl",function($scope,$rootScope,$http,$state,$window){
	console.log("am hey dudu ctrl");
	$rootScope.cart = [];
	$scope.gotomyCart = function(){
		$state.go("cartState");
	}
	$scope.logout = function(){
		
		$http.post("/logout").success(function(data,err){
			if(data.status==200){
				$window.location.href = '/userLogin';
			}
		}).error(function(error){
			alert("Something went wrong, please try again");
		});
	}
	  
	
	$state.go("userHomeState");
});

app.config(function($stateProvider, $urlRouterProvider) {


	  $stateProvider
	    .state("userHomeState", {
	    	views: {
	    		"userHome" : {
	    			 
	    			  templateUrl : "/userHome",
	    			  controller  : function($scope , $http, $state,$rootScope){
	    				  console.log("am here mannn");
	    				  $http.get("/getMenuItems").success(function(data){
	    					  
	    					  $scope.menu = data;
	    					  for(i=0;i<$scope.menu.length;i++){
	    						  $scope.menu[i].isCollapsed=true;
	    						  $scope.menu[i].quantity=1;
	    						  console.log($scope.menu);
	    					  }
	    					  
	    					  var category = [];
	    					  $scope.finalMenu =[];

	    					  for(i=0;i<$scope.menu.length;i++){
	    					  console.log(category.indexOf($scope.menu[i].category));
	    					   if(category.indexOf($scope.menu[i].category)== -1)
	    					  {
	    					    category.push($scope.menu[i].category);
	    					  }
	    					  }

	    					  for(i=0;i<category.length;i++){
	    					    $scope.finalMenu.push({"category":$scope.menu[i].category,"items":[]});
	    					  }


	    					  for(i=0;i<$scope.menu.length;i++){
	    					     for(j=0;j<$scope.finalMenu.length;j++){
	    					       if($scope.menu[i].category==$scope.finalMenu[j].category){
	    					          $scope.finalMenu[j].items.push($scope.menu[i]);
	    					       }
	    					     }
	    					  }



	    					  //console.log($scope.menu.items);
	    					  console.log($scope.finalMenu);
	    				  }).error(function(error){
	    					  
	    				  });
	    				  
	    				  
	    				  
	    				 
	    				 /* if($scope.menu){
	    				  
	    				 
	    					 for(i=0;i<$scope.menu.length;i++){
	    						 
	    					  for(j=0;j<$rootScope.cart.length;j++){
	    						  if($scope.menu[i].menuId == $rootScope.cart[j].menuId){
	    							  console.log("am in two loops");
	    							  $scope.menu[i].add = true;
	    	    					  $scope.menu[i].remove = true;
	    							  
	    						  }
	    					  }
	    				  }
	    				  
	    				  }*/
	    				  
	    				  $scope.add = function(item,pindex,index){
	    					  console.log(index);
	    					  $scope.finalMenu[pindex].items[index].add = true;
	    					  $scope.finalMenu[pindex].items[index].remove = true;
	    					  $rootScope.cart.push($scope.finalMenu[pindex].items[index]);
	    					  console.log($rootScope.cart);
	    				  }
	    				  
	    				  $scope.remove = function(item,pindex,index){
	    					  console.log(index);
	    					  $scope.finalMenu[pindex].items[index].add = false;
	    					  $scope.finalMenu[pindex].items[index].remove = false;
	    					  var id = $scope.finalMenu[pindex].items[index].menuId;
	    					  for(i=0;i<$rootScope.cart.length;i++){
	    						  if($rootScope.cart[i].menuId==id){
	    							  var index = $rootScope.cart.indexOf($rootScope.cart[i]);
	    							  $rootScope.cart.splice(index,1);
	    						  }
	    					  }
	    					  console.log($rootScope.cart);
	    				  }
	    				  
	    				  $scope.goToCart= function(){
	    					  $state.go("cartState");
	    				  }
	    				  
	    				  $scope.goToCheckout = function(){
	    					  $state.go("checkoutState");
	    				  }
	    				  
	    				  
	    				  
	    				 
	    			  }
	    
	    	}}
	      
	    }).state("cartState", {
	    	views: {
	    		"cart" : {
	    			 
	    			  templateUrl : "/cart",
	    			  controller  : function($scope , $http, $state,$rootScope){
	    				  
	    				  $scope.values=[1,2,3,4,5,6,7,8,9,10];
	    				  $rootScope.totalPrice = 0;
	    				  for(i=0;i<$rootScope.cart.length;i++){
	    					  $rootScope.totalPrice = $rootScope.totalPrice+($rootScope.cart[i].unitPrice*$rootScope.cart[i].quantity);
	    				  }
	    				 $scope.remove = function(item,index){
	    					 $rootScope.cart.splice(index,1);
	    					 console.log($rootScope.totalPrice);
	    					 
	    					 $rootScope.totalPrice = 0;
	    					 console.log("am after zero");
	    					 console.log($rootScope.totalPrice);
	    					 for(i=0;i<$rootScope.cart.length;i++){
		    					  $rootScope.totalPrice = $rootScope.totalPrice +($rootScope.cart[i].unitPrice*$rootScope.cart[i].quantity);
		    				       
	    					 }
	    					 console.log($rootScope.cart);
	    				 }
	    				 
	    				 $scope.updatePrice = function(){
	    					 console.log($rootScope.totalPrice);
	    					 $rootScope.totalPrice = 0;
	    					 
	    					 for(i=0;i<$rootScope.cart.length;i++){
	    						 
		    					  $rootScope.totalPrice = $rootScope.totalPrice + (($rootScope.cart[i].unitPrice)*($rootScope.cart[i].quantity));
		    				      
	    					 }
	    				 }
	    				 
	    				 $scope.goBack = function()
	    				 {
	    					 
	    					 $state.go("userHomeState");
	    				 }
	    				 $scope.goToCheckout = function(){
	    					  $state.go("checkoutState");
	    				  }
	    				  
	    				  
	    				  
	    				 
	    			  }
	    
	    	}}
	      
	    }).state("checkoutState", {
	    	views: {
	    		"checkout" : {
	    			 
	    			  templateUrl : "/checkout",
	    			  controller  : function($scope , $http, $state,$rootScope){
	    				  $rootScope.totalPrice = 0;
	    				  for(i=0;i<$rootScope.cart.length;i++){
	    					  $rootScope.totalPrice = $rootScope.totalPrice+($rootScope.cart[i].unitPrice*$rootScope.cart[i].quantity);
	    				  }
	    				  
	    				  $scope.values=[1,2,3,4,5,6,7,8,9,10];
	    				 $scope.times = ["6:00AM","6:30AM","7:00AM","7:30AM","8:00AM","8:30AM","9:00AM","9:30AM","10:00AM","10:30AM","11:00AM","11:30AM","12:00PM",
	    				                  "12:30PM","1:00PM","1:30PM","2:00PM","2:30PM","3:00PM","3:30PM","4:00PM","4:30PM","5:00PM","5:30PM","6:00PM","6:30PM","7:00PM",
	    				                  "7:30PM","8:00PM","8:30PM","9:00PM"];
	    				  $scope.goBack = function()
		    				 {
		    					 
		    					 $state.go("cartState");
		    				 }
	    				  
	    				  $scope.placeOrder=function(){
	    					  var ordersMenu=[];
	    					  var orderId = 1265;
	    					  var order = {"orderId":orderId,"ordered_time":Date.now(),"pickUpDate":$scope.pickUpDate,
		    							 "pickUpTime":$scope.pickUpTime,"status":"new"};
	    					  for(i=0;i<$rootScope.cart.length;i++){
	    						  ordersMenu.push({"order":order,"menu":$rootScope.cart[i],"quantity":$rootScope.cart[i].quantity});
	    					  }
	    					 
	    					 
	    					
	    					 console.log("Order details")
	    					 console.log(order);
	    					 $http.post("/placeOrder",ordersMenu).success(function(data){
	    						 if(data.statusCode == 200){
	    						 alert("Order Placed Successfully");
	    						 }
	    					 })
	    					 
	    					
	    					  
	    				  }
	    				  
	    				  
	    				 
	    			  }
	    
	    	}}
	      
	    })
	    
});
