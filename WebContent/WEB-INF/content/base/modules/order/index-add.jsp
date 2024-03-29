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
	 function saveOrder(){
		 document.getElementById("frmOrder").submit();
	 } 
	
	 function printOrder(){
		 window.print();
	 } 
	
	 var app = angular.module("orderApp", []);
	 
	 app.controller("orderAppCtrl", function($scope,$http,$window,$compile) {
	   
	   //$scope.orderDetails = [{id: 'orderDetail1', name: 'orderDetail1'}, {id: 'orderDetail2', name: 'orderDetail2'}, {id: 'orderDetail3', name: 'orderDetail3'}];
   	   	$scope.orderDetails = [];
   	 	$scope.orders = [];
   	   	
   	 	$scope.orderDetail={
     		'idOrderDetail' :"",
     		'idOrder'		:"",
     		'idProduct'		:"",
     		'amount'		:"",
     		'unit'			:"",
     		'unitPrice'		:"",
     		'subTotal'		:"",
     		'subDiscount'	:"",
     		'nmProduct'		:""
   	   	};
		
   	 	$scope.order={
   	   		'idOrder'			:"",
   	   		'total'				:0,
   	   		'totalDiscount'		:0,
   	   		'vat'				:0,
   	   		'cash'				:0,
   	   		'changes'			:0,
   	   		'idPaymentMethod'	:"",
   	   		'paymentRemark'		:"",
   	   		'orderDate'			:""
   	   	};
		
		
   	   	$scope.addNewOrderDetail = function() {
			var murl ="/sm-hris/base/modules/orderdetail/select-id-order-detail-counter-json";
			$http.get(murl)
			.then(function(response) {
		     	$scope.orderDetails.push({
		     		'idOrderDetail' : response.data.idOrderDetailCounter,
		     		'idOrder'		:'<s:property value="order.idOrder"/>',
		     		'idProduct'		:'',
		     		'amount'		:'',
		     		'unit'			:0,
		     		'unitPrice'		:0,
		     		'subTotal'		:0,
		     		'subDiscount'	:0,
		     		'nmProduct'		:''
				});
		    });
	   };
	   
	   
	   $scope.removeNewOrderDetail = function(nId) {
		   	$scope.orderDetails.splice(nId,1);
		   	$scope.totalCalc();
		   	$scope.changesCalc();
	   };
	   
	   $scope.showAddOrderDetail = function(orderDetail) {
	     return orderDetail.id === $scope.orderDetails[$scope.orderDetails.length-1].id;
	   };

	   $scope.idProductNgBlur = function (idProduct,idx){
		   $scope.orderDetails[idx].unitPrice = 0;
		   var murl ="/sm-hris/base/modules/orderdetail/select-product-by-id-json?idProduct="+ idProduct;
			$http.get(murl)
			.then(function(response) {
				var product = response.data.products[0];
				$scope.orderDetails[idx].unitPrice = product.unitPrice;
				$scope.orderDetails[idx].subTotal = $scope.orderDetails[idx].amount * $scope.orderDetails[idx].unitPrice;
				$scope.orderDetails[idx].nmProduct = product.nmProduct;
				$scope.orderDetails[idx].unit=product.unit;
			})   
	   }

	   $scope.amountNgBlur = function (idProduct,amount,unitPrice,idx){
		   var vSubTotal = parseInt(amount) * parseInt(unitPrice);
		   $scope.orderDetails[idx].subTotal = vSubTotal;
		   var murl ="/sm-hris/base/modules/orderdetail/select-discount-by-id-product-json?idProduct="+ idProduct;
		   $http.get(murl)
		   .then(function(response) {
				$scope.orderDetails[idx].subDiscount = parseInt(response.data.discounts[0].discount) * parseInt(vSubTotal)/100;
			})
		   $scope.totalCalc();
	   }

	   $scope.subDiscountCalc = function(idx){
		   var murl ="/sm-hris/base/modules/orderdetail/select-discount-by-id-product-json?idProduct="+ idProduct;
			$http.get(murl)
			.then(function(response) {
				$scope.orderDetails[idx].subDiscount = parseInt(response.data.discount[0]) * parseInt($scope.orderDetails[idx].subTotal)/100;
			})   
	   }
	   
	   $scope.searchIdPaymentMethod = function(){
		   var murl ="/sm-hris/base/modules/mgt/paymentmethod/select-payment-method-json";
			$http.get(murl)
			.then(function(response) {
				$scope.paymentMethods = response.data.paymentMethods;
			})   
	   }

	   $scope.totalCalc = function(){
		   var k;
		   var orderTotal;
		   var orderDiscount;
		   orderTotal=parseInt("0");
		   orderDiscount=parseInt("0");
		   $scope.orderDetails.forEach(mFunc);
		   function mFunc(item,index)
		   {
			   if(item.subTotal){
			   orderTotal+=parseInt(item.subTotal);
			   orderDiscount+=parseInt(item.subDiscount);
			   }
		   }
		   $scope.total = orderTotal;
		   $scope.totalDiscount = orderDiscount;
		   $scope.vat = (orderTotal-orderDiscount)/10;
		   $scope.grandTotal = orderTotal - orderDiscount + $scope.vat;
	   }
	   
	   $scope.changesCalc = function(){
		   $scope.changes = parseFloat($scope.cash) - parseFloat($scope.grandTotal);
	   }
	 });

	</script>

</head>


<body>
            
<div class="container" >
     <div class="panel-heading">
         <h1>Adding Order</h1>
     </div>
     <div class="panel-default">
     <div class="panel-body">
     
            <s:form id="frmOrder" action="index-add" enctype="multipart/form-data" method="post" theme="bootstrap" cssClass="form-vertical">
                <div class="row">
                    <div class="col-md-9">
                		<s:textfield
                        	label="Order ID"
                        	name="order.idOrder"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-3"
                        	tooltip="Enter ID Order"
                        	value="%{order.idOrder}"
                        	ng-model=""
                        	readonly="true"
                        	/>
					</div>
				</div>	
                <div class="row">
                    <div class="col-md-9">
                		<s:textfield
                        	label="Order Date"
                        	name="order.orderDate"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-3"
                        	tooltip="Order Date"
                        	value="%{order.orderDate}"
                        	ng-model=""
                        	readonly="true"
                        	/>
					</div>
                </div>
                <div class="row"  ng-app="orderApp" ng-controller="orderAppCtrl">
                <div class="col-md-12">
                <div class="row">
                    <div class="col-md-9">
                		<s:textfield
                        	label="Total"
                        	name="order.total"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-3"
                        	tooltip="Total"
                        	value="{{total | number}}"
                        	ng-model="total"
                        	readonly="true"
                        	/>
					</div>
				</div>
                <div class="row">
                    <div class="col-md-9">
                		<s:textfield
                        	label="Total Discount"
                        	name="order.totalDiscount"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-2"
                        	tooltip="Total Discount"
                        	value="{{totalDiscount | number}}"
                        	ng-model="totalDiscount"
                        	readonly="true"
                        	/>
					</div>
				</div>
                <div class="row">
                    <div class="col-md-9">
                		<s:textfield
                        	label="VAT"
                        	name="order.vat"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-2"
                        	tooltip="VAT"
                        	value="{{vat | number}}"
                        	ng-model="vat"
                        	readonly="true"
                        	/>
					</div>
				</div>
                <div class="row">
                    <div class="col-md-9">
                		<s:textfield
                        	label="Grand Total"
                        	name="order.grandTotal"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-2"
                        	tooltip="Grand Total"
                        	value="{{grandTotal | number}}"
                        	ng-model="grandTotal"
                        	readonly="true"
                        	/>
					</div>
				</div>
                <div class="row">
                    <div class="col-md-9">
                		<s:textfield
                        	label="Cash"
                        	name="order.cash"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-3"
                        	tooltip="Cash"
                        	value="{{cash | number}}"
                        	ng-model="cash"
                        	ng-blur="changesCalc()"
                        	/>
					</div>
				</div>
                <div class="row">
                    <div class="col-md-9">
                		<s:textfield
                        	label="Changes"
                        	name="order.changes"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-3"
                        	tooltip="Changes"
                        	value="{{changes | number}}"
                        	ng-model="changes"
                        	readonly="true"
                        	/>
					</div>
				</div>
                <div class="row">
                    <div class="col-md-9">
                		<s:textfield
                        	label="Payment Method Id"
                        	name="order.idPaymentMethod"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-5"
                        	tooltip="Payment Method Id"
                        	ng-model="idPaymentMethod"
                        	ng-focus="searchIdPaymentMethod()"
                        	list="idPaymentMethods"
                        	/>
                        	<datalist id="idPaymentMethods">
						    	<option ng-repeat="x in paymentMethods" value="{{x.idPaymentMethod}}">{{x.nmPaymentMethod}}</option>
							</datalist>
                        	
					</div>
				</div>
                <div class="row">
                    <div class="col-md-9">
                		<s:textfield
                        	label="Payment Remark"
                        	name="order.paymentRemark"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-5"
                        	tooltip="Payment Remark"
                        	value="{{paymentRemark}}"
                        	ng-model="paymentRemark"
                        	/>
					</div>
				</div>
                <div class="row">
                   	<div class="col-md-9">
				      <h1>Order Detail</h1>
				      <div class="row" data-ng-repeat="orderDetail in orderDetails">
						<!-- <s:submit cssClass="btn btn-primary" ng-click="removeNewOrderDetail('{{orderDetail.id}}')" value="Remove Order Detail" /> -->
				        <div class="row">
				        <div class="col-md-12">
				        <s:textfield 
				        	ng-model="orderDetail.idOrderDetail" 
				        	name="orderDetails[{{$index}}].idOrderDetail" 
				        	id="orderDetails[{{$index}}].idOrderDetail" 
				        	placeholder="Id Order Detail" 
				        	value="{{orderDetail.idOrderDetail}}" 
				        	readonly="true" 
				        	elementCssClass="col-sm-4"/>
				        <s:textfield 
				        	ng-model="orderDetail.idProduct" 
				        	name="orderDetails[{{$index}}].idProduct" 
				        	id="orderDetails[{{$index}}].idProduct" 
				        	placeholder="Id Product" 
				        	value="{{orderDetail.idProduct}}" 
				        	ng-blur="idProductNgBlur(orderDetail.idProduct,$index)" 
				        	elementCssClass="col-sm-4"/>
				        <s:textfield ng-model="orderDetail.amount" 
				        	name="orderDetails[{{$index}}].amount" 
				        	id="orderDetails[{{$index}}].amount" 
				        	placeholder="Amount" 
				        	ng-blur="amountNgBlur(orderDetail.idProduct,orderDetail.amount,orderDetail.unitPrice,$index)" 
				        	ng-change="amountNgBlur(orderDetail.idProduct,orderDetail.amount,orderDetail.unitPrice,$index)" 
				        	ng-focus="amountNgBlur(orderDetail.idProduct,orderDetail.amount,orderDetail.unitPrice,$index)" elementCssClass="col-sm-2"/>
				        <s:textfield 
				        	ng-model="orderDetail.nmProduct" 
				        	name="orderDetails[{{$index}}].nmProduct" 
				        	id="orderDetails[{{$index}}].nmProduct" 
				        	placeholder="Product Name" 
				        	value="{{orderDetail.nmProduct}}" 
				        	readonly="true" 
				        	elementCssClass="col-sm-4"/>
				        <s:textfield 
				        	ng-model="orderDetail.unit" 
				        	name="orderDetails[{{$index}}].unit" 
				        	id="orderDetails[{{$index}}].unit" 
				        	placeholder="Unit" 
				        	value="{{orderDetail.unit}}" 
				        	readonly="true" 
				        	elementCssClass="col-sm-4"/>
				        </div> 
				        </div>
				        <div class="row">
				        <div class="col-md-9">
				        <s:textfield 
				        	ng-model="orderDetail.unitPrice" 
				        	name="orderDetails[{{$index}}].unitPrice" 
				        	id="orderDetails[{{$index}}].unitPrice" 
				        	placeholder="Unit Price" 
				        	value="{{orderDetail.unitPrice}}" 
				        	readonly="true" 
				        	elementCssClass="col-sm-2"/>
				        <s:textfield 
				        	ng-model="orderDetail.subTotal" 
				        	name="orderDetails[{{$index}}].subTotal" 
				        	id="orderDetails[{{$index}}].subTotal" 
				        	placeholder="Sub Total" 
				        	value="{{orderDetail.subTotal}}" 
				        	ng-focus="totalCalc()" 
				        	ng-change="totalCalc()" 
				        	readonly="true"
				        	elementCssClass="col-sm-2"/>
				        <s:textfield 
				        	ng-model="orderDetail.subDiscount" 
				        	name="orderDetails[{{$index}}].subDiscount" 
				        	id="orderDetails[{{$index}}].subDiscount" 
				        	placeholder="Discount" 
				        	value="{{orderDetail.subDiscount}}" 
				        	ng-change="totalCalc()" 
				        	readonly="true"
				        	elementCssClass="col-sm-2"/>
						</div>
				        <s:hidden 
				        	ng-model="orderDetail.idOrder" 
				        	name="orderDetails[{{$index}}].idOrder" 
				        	value="{{orderDetail.idOrder}}" />

						<s:hidden 
							name="proc"
							value="%{proc}"/>
				        <div class="col-md-3">
		        		<img src="http://127.0.0.1/img/icon/cross.png" width="30" height="30" alt="Del Item" ng-click="removeNewOrderDetail({{$index}})" >Remove</img>
		        		</div>
		        		</div>
		                <div class="row">
		                <div class="col-md-12">
		                =======================================================================
						</div>
						</div>
				      </div>
				   	</div>
				</div>

                <div class="row">
                <div class="col-md-9">
		        	<img src="http://127.0.0.1/img/icon/plus.png" width="30" height="30" alt="Add Item" ng-click="addNewOrderDetail()">Add Item</img>
				</div>
				</div>

                <div class="row">
                    <div class="col-md-9">
		                =======================================================================
		                =======================================================================
		                =======================================================================
                    	<s:if test="proc=='Save'">
			        		<img src="http://127.0.0.1/img/icon/save.png" width="120" height="50" alt="Save" onclick="saveOrder()"></img>
			        	</s:if>
                    	<s:elseif test="proc=='Print'">
			        		<img src="http://127.0.0.1/img/icon/print.png" width="120" height="50" alt="Print" onclick="printOrder()"></img>
			        	</s:elseif>
			        	<s:else>
			        	</s:else>
			        	
	        		</div>
				</div>

				</div>
				</div>
			</s:form>	
		</div>
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
