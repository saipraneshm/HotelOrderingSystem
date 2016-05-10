var app = angular.module("myApp",['ui.router','ui.bootstrap']);

app.controller("userCtrl",function($scope,$rootScope,$http,$state){
	console.log("am in main ctrl");
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
	    				  
	    				  $http.get().success(function(data){
	    					  
	    				  }).error(function(error){
	    					  
	    				  });
	    				  
	    				  
	    				  
	    				  $scope.quantity = 1;
	    				  $scope.menu=[{"id":1,"Name":"Chicken Pizza","Category":"Pizza","UnitPrice":10,"isCollapsed":true,"quantity":1},
	    				               {"id":2,"Name":"Chicken Pizza","Category":"Pizza","UnitPrice":10,"isCollapsed":true,"quantity":1},
	    				               {"id":3,"Name":"Chicken Pizza","Category":"Pizza","UnitPrice":10,"isCollapsed":true,"quantity":1}]
	    				  
	    				 
	    					 for(i=0;i<$scope.menu.length;i++){
	    						 
	    					  for(j=0;j<$rootScope.cart.length;j++){
	    						  if($scope.menu[i].id == $rootScope.cart[j].id){
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
	    					  var id = $scope.menu[index].id;
	    					  for(i=0;i<$rootScope.cart.length;i++){
	    						  if($rootScope.cart[i].id==id){
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
	    					  $rootScope.totalPrice = $rootScope.totalPrice+($rootScope.cart[i].UnitPrice*$rootScope.cart[i].quantity);
	    				  }
	    				 $scope.remove = function(item,index){
	    					 $rootScope.cart.splice(index,1);
	    					 console.log($rootScope.totalPrice);
	    					 
	    					 $rootScope.totalPrice = 0;
	    					 console.log("am after zero");
	    					 console.log($rootScope.totalPrice);
	    					 for(i=0;i<$rootScope.cart.length;i++){
		    					  $rootScope.totalPrice = $rootScope.totalPrice +($rootScope.cart[i].UnitPrice*$rootScope.cart[i].quantity);
		    				       
	    					 }
	    					 console.log($rootScope.cart);
	    				 }
	    				 
	    				 $scope.updatePrice = function(){
	    					 console.log($rootScope.totalPrice);
	    					 $rootScope.totalPrice = 0;
	    					 
	    					 for(i=0;i<$rootScope.cart.length;i++){
	    						 
		    					  $rootScope.totalPrice = $rootScope.totalPrice + (($rootScope.cart[i].UnitPrice)*($rootScope.cart[i].quantity));
		    				      
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
	    				  
	    				  
	    				 $scope.values = [1,2,3,4,5,6];
	    				  $scope.goBack = function()
		    				 {
		    					 
		    					 $state.go("userHomeState");
		    				 }
	    				  
	    				  
	    				 
	    			  }
	    
	    	}}
	      
	    })
	    
});







