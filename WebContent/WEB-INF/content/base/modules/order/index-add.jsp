<!DOCTYPE html>
<html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="keywords" content="hris, company, resources, management, showcase" />
    <meta name="description" content="A Showcase for the Human Resporce Management System" />
    <!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	
    <![endif]-->
    <sb:head includeScripts="true" includeScriptsValidation="false"/>
	<sj:head jqueryui="true"/>
    <style type="text/css">
        body {
            padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
        }
        h5 {padding-left: 210px;}
    </style>
	<sx:head />
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.5/angular.min.js"></script>
	<!-- 
    <script data-require="angular.js@1.3.15" data-server="1.3.15" src="https://code.angularjs.org/1.3.15/angular.js"></script>
	-->
	<script>
	//function show_unitlist() {
	//	dojo.event.topic.publish("show_unitlist");
	//}
	</script>
	
	<script>
	 
	 var app = angular.module("orderApp", []);
	 
	 app.controller("orderAppCtrl", function($scope) {
	   
	   //$scope.orderDetails = [{id: 'orderDetail1', name: 'orderDetail1'}, {id: 'orderDetail2', name: 'orderDetail2'}, {id: 'orderDetail3', name: 'orderDetail3'}];
	   $scope.orderDetails = [{'id' : 'orderDetail1', 'name' : 'orderDetail1'}];
	   
	   $scope.addNewOrderDetail = function() {
	     newItemNo = $scope.orderDetails.length+1;
	     $scope.orderDetails.push({'id' : 'orderDetail' + newItemNo, 'name' : 'orderDetail' + newItemNo});
	   };
	   
	   $scope.removeNewOrderDetail = function(nId) {
		   //var index = $scope.orderDetails.indexOf(item);
		   //$scope.orderDetails.splice($scope.orderDetails.indexOf(nId), 1); 
		   	//var oOrderDetail = $scope.orderDetails.filter(orderDetail = function() {return orderDetail.id === nId});
			//var vIndex = $scope.orderDetails.indexOf(oOrderDetail);
			//var vIndex = $scope.orderDetails.findIndex(orderDetail=>orderDetail.id === nId);
			var found = $scope.orderDetails.find(function(orderDetail){return orderDetail.id = nId});
			var vIndex = $scope.orderDetails.indexOf(found);
			console.log("nId nya: " + nId);
			console.log("oOrderDetail nya:" + found);
			console.log("vIndex nya:" + vIndex);
		   $scope.orderDetails.splice(vIndex,1);
		   //$scope.orderDetails.splice(nId,1);     
	   };
	   
	   $scope.showAddOrderDetail = function(orderDetail) {
	     return orderDetail.id === $scope.orderDetails[$scope.orderDetails.length-1].id;
	   };
	   
	 });

	</script>

</head>


<body ng-app="orderApp">
            
<div class="container">
    <div class="row">
        <div class="col-md-9">
      	<div class="panel panel-default">
          <div class="panel-heading">
            <h1>Adding Order</h1>
          </div>
          <div class="panel-body">
	    	<div ng-controller="orderAppCtrl" class="container">

            <!-- <s:form id="frmOrder" action="index-edit" enctype="multipart/form-data" theme="bootstrap" cssClass="form-horizontal"> -->

                <div class="form-group">
                <div class="row">
                    <div class="col-md-9">
                		<s:textfield
                        	label="Order ID"
                        	name="order.idOrder"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-3"
                        	tooltip="Enter ID Order"
                        	value="%{order.idOrder}"
                        	ng-model="idOrder"
                        	readonly="true"
                        	/>
					</div>
                    <div class="col-md-9">
                		<s:textfield
                        	label="Total"
                        	name="order.total"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-3"
                        	tooltip="Total"
                        	value="%{order.total}"
                        	ng-model="total"
                        	readonly="true"
                        	/>
					</div>
                    <div class="col-md-9">
                		<s:textfield
                        	label="Total Discount"
                        	name="order.totalDiscount"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-3"
                        	tooltip="Total Discount"
                        	value="%{order.total}"
                        	ng-model="totalDiscount"
                        	readonly="true"
                        	/>
					</div>
                    <div class="col-md-9">
                		<s:textfield
                        	label="VAT"
                        	name="order.vat"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-3"
                        	tooltip="VAT"
                        	value="%{order.vat}"
                        	ng-model="vat"
                        	readonly="true"
                        	/>
					</div>
                    <div class="col-md-9">
                		<s:textfield
                        	label="Cash"
                        	name="order.cash"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-3"
                        	tooltip="Cash"
                        	value="%{order.cash}"
                        	ng-model="cash"
                        	/>
					</div>
                    <div class="col-md-9">
                		<s:textfield
                        	label="Changes"
                        	name="order.changes"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-3"
                        	tooltip="Changes"
                        	value="%{order.changes}"
                        	ng-model="changes"
                        	readonly="true"
                        	/>
					</div>
                    <div class="col-md-9">
                		<s:textfield
                        	label="Payment Method Id"
                        	name="order.idPaymentMethod"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-3"
                        	tooltip="Payment Method Id"
                        	value="%{order.idPaymentMethod}"
                        	ng-model="idPaymentMethod"
                        	/>
					</div>
                    <div class="col-md-9">
                		<s:textfield
                        	label="Payment Remark"
                        	name="order.paymentRemark"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-3"
                        	tooltip="Payment Remark"
                        	value="%{order.paymentRemark}"
                        	ng-model="paymentRemark"
                        	/>
					</div>
                    <div class="col-md-9">
                		<s:textfield
                        	label="Order Date"
                        	name="order.orderDate"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-3"
                        	tooltip="Order Date"
                        	value="%{order.orderDate}"
                        	ng-model="orderDate"
                        	readonly="true"
                        	/>
					</div>
	        		<s:submit cssClass="btn btn-primary" id="proc" name="proc" value="Save" />
                    <!--  <button ng-click="orderAddClick()">Add</button> -->
			      <h1>Order Detail</h1>
			      <div class="form-group" data-ng-repeat="orderDetail in orderDetails">
			      <div class="row">
			        <s:textfield type="text" ng-modal="{{orderDetail.id}}" name="orderDetails[].idOrderDetail" placeholder="" value="{{orderDetail.name}}" />
					<s:submit cssClass="btn btn-primary" id="{{orderDetail.id}}" ng-click="removeNewOrderDetail('{{orderDetail.id}}')" value="Remove Order Detail" />
			      </div>
			      </div>
			<!-- </s:form>  
		    <div class="row">
		        <s:submit cssClass="btn btn-primary" id="addOrderDetail" ng-click="addNewOrderDetail()" value="Add Order Detail" />
			</div>
		    </div>
		</div> 
		</div>
        </div> <!-- -------col-md-9 -->
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-md-10">
    		<p class="pull-right"><a href="#">Back to top</a></p>
		</div>
	</div>
</div>	
</body>
</html>
