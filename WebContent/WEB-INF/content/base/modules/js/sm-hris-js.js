/**
 * Custom AngularJS App File
 * for populating and creating
 * form fields dynamically
 **/
 
 var app = angular.module("orderApp", []);
 
 app.controller("orderAppCtrl", function($scope) {
   
   $scope.orderDetails = [{id: 'orderDetail1', name: 'orderDetail1'}, {id: 'orderDetail2', name: 'orderDetail2'}, {id: 'orderDetail3', name: 'orderDetail3'}];
   
   $scope.addNewOrderDetail = function() {
     var newItemNo = $scope.orderDetails.length+1;
     $scope.orderDetails.push({'id' : 'orderDetail' + newItemNo, 'name' : 'orderDetail' + newItemNo});
   };
   
   $scope.removeNewOrderDetail = function() {
     var newItemNo = $scope.orderDetails.length-1;
     if ( newItemNo !== 0 ) {
      $scope.orderDetails.pop();
     }
   };
   
   $scope.showAddOrderDetail = function(orderDetail) {
     return orderDetail.id === $scope.orderDetails[$scope.orderDetails.length-1].id;
   };
   
 });
 /**
 * 
 */