<!DOCTYPE html>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
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
            padding-top: 60px; padding-left:10px; /* 60px to make the container go all the way to the bottom of the topbar */
        }
        h5 {padding-left: 210px;}
    </style>
	<sx:head />
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.5/angular.min.js"></script>
	<script>
	//function show_unitlist() {
	//	dojo.event.topic.publish("show_unitlist");
	//}
	
	var app = angular.module('orderApp', []);
	app.controller('orderAppCtrl', function($scope, $http, $window) {
		$scope.buyerIdOnBlur=function(){
			//$scope.buyerAddress = null;
			//$scope.buyerPhone = null;
			//$scope.buyerFax = null;
			//$scope.buyerEmail = null;
			//$scope.buyerShippingAddress = null;
			var murl = "/sm-hris/base/modules/order/buyer-json?idBuyer=" + $scope.idBuyer;
			//$http.post("unit-list-json", {params {idDept:"200"}}, {headers:{"Content-Type": "multipart/form-data"}})
			//$http.post("unit-list-json", mdata,{headers:{"Content-Type": "application/x-www-form-urlencoded"}})
			$http.get(murl)
			.then(function(response) {
				$scope.jsbuyer = response.data.buyers;
				console.log("The murl :" + murl);
		    });
			var murl = "/sm-hris/base/modules/order/buyer-spec-json?idBuyer=" + $scope.idBuyer;
			//$http.post("unit-list-json", {params {idDept:"200"}}, {headers:{"Content-Type": "multipart/form-data"}})
			//$http.post("unit-list-json", mdata,{headers:{"Content-Type": "application/x-www-form-urlencoded"}})
			$http.get(murl)
			.then(function(response) {
				$scope.speclists = response.data.buyerSpecs;
				console.log("The murl :" + murl);
		    });
	    }

		$scope.buyerIdOnFocus=function(){
		    $http.get("buyer-list-json").then(function(response) {
		        $scope.buyerlist = response.data.buyers;
		    });
	    }

		$scope.orderAddClick=function(){
			var murl ="";
			murl = murl + "/sm-hris/base/modules/order/save-order-json?";
			murl = murl + "order.idBuyer=" + $scope.idBuyer + "&";
			murl = murl + "order.idSpec=" + $scope.idSpec + "&";
			murl = murl + "order.idPO=" + $scope.idPO + "&";
			murl = murl + "order.idProduction=" + $scope.idProduction + "&";
			murl = murl + "order.date=" + $scope.orderDate + "&";
			murl = murl + "order.terms=" + $scope.terms + "&";
			murl = murl + "order.idShipVia=" + $scope.idShipVia + "&";
			murl = murl + "order.shipDate=" + $scope.shipDate + "&";
			murl = murl + "order.FOB=" + $scope.FOB + "&";
			murl = murl + "order.inWarehouse=" + $scope.dateInWarehouse + "&";
			murl = murl + "order.cancelation=" + $scope.dateCancelation;
			$http.get(murl)
			.then(function(response) {
				$scope.returnOrder = response.data.order;
				//console.log("The murl :" + murl);
		    });
	    }
		
		$scope.tableInit=function(){
			var murl ="";
			murl = murl + "/sm-hris/base/modules/order/order-item-list-json?";
			murl = murl + "idPO=" + "<s:property value='%{order.idPO}'/>" + "&";
			murl = murl + "page=1";
			console.log(murl);
			$http.get(murl).then(function(response) {
				$scope.returnOrderItems = response.data.orderItems;
				//console.log("The murl :" + murl);
		    });
	    }
		$scope.toPage=function(){
			var murl ="";
			murl = murl + "/sm-hris/base/modules/order/order-item-list-json?";
			murl = murl + "idPO=" + "<s:property value='%{order.idPO}'/>" + "&";
			murl = murl + "page=" + $scope.pgNbr;
			console.log(murl);
			$http.get(murl).then(function(response) {
				$scope.returnOrderItems = response.data.orderItems;
				//console.log("The murl :" + murl);
		    });
	    }
	});

	//document.getElementById("buyer.address").value = "";

</script>

</head>


<body ng-app="orderApp" ng-controller="orderAppCtrl">
            
<div class="container">
    <div class="row">
        <div class="col-md-9">
      	<div class="panel panel-default">
        <div class="panel-heading">
          <h1>Editing Order</h1>
        </div>
        <div class="panel-body">

            <s:form id="frmOrder" method="post" action="index-edit-test" enctype="multipart/form-data" theme="bootstrap" cssClass="form-horizontal">
                <div class="row">
                    <div class="col-md-9">
                		<s:textfield
                        	label="Buyer ID"
                        	name="order.idBuyer"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-3"
                        	tooltip="Enter ID Buyer"
                        	ng-blur="buyerIdOnBlur()"
                        	ng-focus="buyerIdOnFocus()"
                        	list="buyerlists"
                        	value="%{order.idBuyer}"
                        	/>
						<datalist id="buyerlists">
						    <option ng-repeat="x in buyerlist" value="{{x.idBuyer}}">{{x.buyerName}}</option>
						</datalist>
						
					</div>
                    <div class="col-md-9">
						<h5 ng-repeat="x in jsbuyer">Buyer Name: {{x.buyerName}}</h5>
					</div>
                    <div class="col-md-9">
						<h5 ng-repeat="x in jsbuyer">Address: {{x.address}}</h5>
					</div>
                    <div class="col-md-9">
						<h5 ng-repeat="x in jsbuyer">Phone: {{x.phone}}</h5>
                    </div>
                    <div class="col-md-9">
						<h5 ng-repeat="x in jsbuyer">Email: {{x.email}}</h5>
                    </div>
                    <div class="col-md-9">
						<h5 ng-repeat="x in jsbuyer">Fax: {{x.fax}}</h5>
                    </div>
                    <div class="col-md-9">
						<h5 ng-repeat="x in jsbuyer">Shipping Address: {{x.shippingAddress}}</h5>
                    </div>
                    <div class="col-md-9">
                		<s:textfield
                        	label="Spec ID"
                        	name="order.idSpec"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-3"
                        	tooltip="Enter Spec"
                        	list="speclist"
                        	value="%{order.idSpec}"
                        	/>
						<datalist id="speclist">
						    <option ng-repeat="x in speclists" value="{{x.idSpec}}">{{x.idSpec}}</option>
						</datalist>
					</div>
                    <div class="col-md-9">
                		<s:textfield
                        	label="PO Number"
                        	name="order.idPO"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-3"
                        	tooltip="Enter PO Number"
                        	value="%{order.idPO}"/>
                        	
                    </div>
                    <div class="col-md-9">
                		<s:textfield
                        	label="Prod Number"
                        	name="order.idProduction"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-3"
                        	tooltip="Enter Prod Number"
                        	value="%{order.idProduction}"/>
                    </div>
                    <div class="col-md-9">
						<sj:datepicker
                                id="datepicker1"
                                parentTheme="bootstrap"
                                name="order.date"
                                label="Order Date"
                                tooltip="Enter Order Date"
                                cssClass="form-control"
                                elementCssClass="col-sm-3"
                                showOn="focus"
                                inputAppendIcon="calendar"
                                dateFormat="yy-m-d"
                        		value ="%{order.date}"
                                />
					</div>
                    <div class="col-md-9">
                		<s:textfield
                        	label="Terms"
                        	name="order.terms"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-3"
                        	tooltip="Enter Terms"
                        	value="%{order.terms}"/>
                    </div>
                    <div class="col-md-9">
                		<s:textfield
                        	label="Ship Via"
                        	name="order.idShipVia"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-3"
                        	tooltip="Enter ID Ship Via"
                        	ng-focus="shipViaIdOnFocus()"
                        	list="shipvialist"
                        	value="%{order.idShipVia}"
                        	/>
						<datalist id="shipvialist">
						    <option ng-repeat="x in shipvialist" value="{{x.idShipVia}}">{{x.ShipViaName}}</option>
						</datalist>
					</div>
                    <div class="col-md-9">
						<sj:datepicker
                                id="datepicker2"
                                parentTheme="bootstrap"
                                name="order.shipDate"
                                label="Shipping Date"
                                tooltip="Enter Ship Date"
                                cssClass="form-control"
                                elementCssClass="col-sm-3"
                                showOn="focus"
                                inputAppendIcon="calendar"
                                dateFormat="yy-m-d"
	                        	value="%{order.shipDate}"
                                />
					</div>
                    <div class="col-md-9">
                		<s:textfield
                        	label="FOB"
                        	name="order.FOB"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-3"
                        	tooltip="Enter FOB"
                        	ng-focus="FOBOnFocus()"
                        	list="FOBlist"
                        	value="%{order.FOB}"
                        	/>
						<datalist id="FOBlist">
						    <option ng-repeat="x in FOBlist" value="{{x.idFOB}}">{{x.FOBName}}</option>
						</datalist>
					</div>
                    <div class="col-md-9">
						<sj:datepicker
                                id="datepicker3"
                                parentTheme="bootstrap"
                                name="order.inWarehouse"
                                label="In Warehouse"
                                tooltip="Enter In Warehouse"
                                cssClass="form-control"
                                elementCssClass="col-sm-3"
                                showOn="focus"
                                inputAppendIcon="calendar"
                                dateFormat="yy-m-d"
                        		value="%{order.inWarehouse}"
                                />
					</div>
                    <div class="col-md-9">
						<sj:datepicker
                                id="datepicker4"
                                parentTheme="bootstrap"
                                name="order.cancelation"
                                label="Cancelation"
                                tooltip="Enter Cancelation"
                                cssClass="form-control"
                                elementCssClass="col-sm-3"
                                showOn="focus"
                                inputAppendIcon="calendar"
                                dateFormat="yy-m-d"
	                        	value="%{order.cancelation}"
                                />
					</div>

                </div>
                <div class="form-group">
                <div class="row">
                	<!-- <table class="table table-striped" ng-init="tableInit()">  -->
                	<table class="table table-striped">
						<thead>
					      <tr>
					        <th>Mark</th>
					        <th>ID</th>
					        <th>PO</th>
					        <th>Color</th>
					        <th>Qty</th>
					        <th>Descr</th>
					        <th>Unit Price</th>
					        <th>Ext Price</th>
					      </tr>
					    </thead>
						<tbody>
						
						<s:iterator value="order.orderItems" status="n">
 					     <tr>
					        <td><s:property value="%{#n.index}" /></td>
					        <td><s:textfield name="order.orderItems[%{#n.index}].idItems" value="%{idItem}" /></td>
					        <td><s:textfield name="order.orderItems[%{#n.index}].idPO" value="%{idPO}" /></td>
					        <td><s:textfield name="order.orderItems[%{#n.index}].idColor" value="%{idColor}" /></td>
					        <td><s:textfield name="order.orderItems[%{#n.index}].qty" value="%{qty}" /></td>
					        <td><s:textfield name="order.orderItems[%{#n.index}].description" value="%{description}" /></td>
					        <td><s:textfield name="order.orderItems[%{#n.index}].unitPrice" value="%{unitPrice}" /></td>
					        <td><s:textfield name="order.orderItems[%{#n.index}].extendedPrice" value="%{extendedPrice}" /></td>
							<!-- 
					        <td><s:textfield name="orderItems{{$index}}.IdPO" size="15" value="{{x.idPO}}" /></td>
					        <td><s:textfield name="orderItems{{$index}}.IdColor" size="8" value="{{x.idColor}}" /></td>
					        <td><s:textfield name="orderItems{{$index}}.Qty" size="10" value="{{x.qty}}" /></td>
					        <td><s:textfield name="orderItems{{$index}}.Description" size="10" value="{{x.description}}" /></td>
					        <td><s:textfield name="orderItems{{$index}}.UnitPrice" size="7" value="{{x.unitPrice}}" /></td>
					        <td><s:textfield name="orderItems{{$index}}.ExtendedPrice" size="8" value="{{x.extendedPrice}}" /></td>
					     	 -->
					     </tr>
					    </s:iterator>    
					    </tbody>
						<tfoot>
					      <tr>
					        <th></th>
					        <th></th>
					        <th></th>
					        <th></th>
					        <th></th>
					        <th>Go to page:</th>
					        <th><input size="3" type="text" id="pgNbr" name="pgNbr" ng-model="pgNbr" ng-change="toPage()"/></th>
					        <th><s:submit cssClass="btn btn-primary" name="proc" value="Save"/></th>
					      </tr>
					    </tfoot>
                   	</table>                   	
                </div>
                </div>
			</s:form> 
		
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
