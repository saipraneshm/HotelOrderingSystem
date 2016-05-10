var app = angular.module("myApp",['ui.router','ui.bootstrap']);

app.controller("userCtrl",function($scope,$rootScope,$http,$state){
	console.log("am hey dudu ctrl");
	$rootScope.cart = [];
	$scope.gotomyCart = function(){
		$state.go("cartState");
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
	    				  console.log("am here");
	    				  $http.get("/getMenuItems").success(function(data){
	    					  console.log(data);
	    					  $scope.menu = data;
	    					  for(i=0;i<$scope.menu.length;i++){
	    						  $scope.menu[i].isCollapsed=true;
	    						  console.log($scope.menu);
	    					  }
	    				  }).error(function(error){
	    					  
	    				  });
	    				  
	    				  
	    				  
	    				 
	    				  
	    				  
	    				 
	    					 for(i=0;i<$scope.menu.length;i++){
	    						 
	    					  for(j=0;j<$rootScope.cart.length;j++){
	    						  if($scope.menu[i].menu_id == $rootScope.cart[j].menu_id){
	    							  console.log("am in two loops");
	    							  $scope.menu[i].add = true;
	    	    					  $scope.menu[i].remove = true;
	    							  
	    						  }
	    					  }
	    				  }
	    				  
	    				  
	    				  $scope.add = function(item,index){
	    					  console.log(index);
	    					  $scope.menu[index].add = true;
	    					  $scope.menu[index].remove = true;
	    					  $rootScope.cart.push($scope.menu[index]);
	    					  console.log($rootScope.cart);
	    				  }
	    				  
	    				  $scope.remove = function(item,index){
	    					  console.log(index);
	    					  $scope.menu[index].add = false;
	    					  $scope.menu[index].remove = false;
	    					  var id = $scope.menu[index].menu_id;
	    					  for(i=0;i<$rootScope.cart.length;i++){
	    						  if($rootScope.cart[i].menu_id==id){
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
	    					  $rootScope.totalPrice = $rootScope.totalPrice+($rootScope.cart[i].unit_price*$rootScope.cart[i].quantity);
	    				  }
	    				 $scope.remove = function(item,index){
	    					 $rootScope.cart.splice(index,1);
	    					 console.log($rootScope.totalPrice);
	    					 
	    					 $rootScope.totalPrice = 0;
	    					 console.log("am after zero");
	    					 console.log($rootScope.totalPrice);
	    					 for(i=0;i<$rootScope.cart.length;i++){
		    					  $rootScope.totalPrice = $rootScope.totalPrice +($rootScope.cart[i].unit_price*$rootScope.cart[i].quantity);
		    				       
	    					 }
	    					 console.log($rootScope.cart);
	    				 }
	    				 
	    				 $scope.updatePrice = function(){
	    					 console.log($rootScope.totalPrice);
	    					 $rootScope.totalPrice = 0;
	    					 
	    					 for(i=0;i<$rootScope.cart.length;i++){
	    						 
		    					  $rootScope.totalPrice = $rootScope.totalPrice + (($rootScope.cart[i].unit_price)*($rootScope.cart[i].quantity));
		    				      
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
	    					  $rootScope.totalPrice = $rootScope.totalPrice+($rootScope.cart[i].unit_price*$rootScope.cart[i].quantity);
	    				  }
	    				  
	    				  
	    				 $scope.values = [1,2,3,4,5,6];
	    				  $scope.goBack = function()
		    				 {
		    					 
		    					 $state.go("userHomeState");
		    				 }
	    				  
	    				  
	    				 
	    			  }
	    
	    	}}
	      
	    })
	    
});







