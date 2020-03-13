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
	 function printOrder(){
		 window.print();
	 } 
	</script>

</head>


<body>
<table>
	<tr>
		<td>Id Order</td>
		<td>&nbsp;</td>
		<td><s:property value="order.idOrder"/></td>
	</tr>
	<tr>
		<td>Order Date</td>
		<td>&nbsp;</td>
		<td><s:property value="order.orderDate"/></td>
	</tr>
	<tr>
		<td>Total</td>
		<td>&nbsp;</td>
		<td><s:property value="order.total"/></td>
	</tr>
	<tr>
		<td>Discount</td>
		<td>&nbsp;</td>
		<td><s:property value="order.discount"/></td>
	</tr>
	<tr>
		<td>VAT</td>
		<td>&nbsp;</td>
		<td><s:property value="order.vat"/></td>
	</tr>
	<tr>
		<td>Grand Total</td>
		<td>&nbsp;</td>
		<td><s:property value="order.grandTotal"/></td>
	</tr>

	<tr>
		<td>=========================================================</td>
	</tr>
  	<s:iterator value="orderDetails" var="orderDetail">
	<tr>
		<td><s:property value="nmProduct"/></td>
		<td><s:property value="amount"/></td>
		<td><s:property value="unitPrice"/></td>
		<td><s:property value="subTotal"/></td>
	</tr>
	</s:iterator>


</table>
            
<div class="container" >

                <div class="row">
                   	<div class="col-md-9">
				      <h1>Order Detail</h1>
					  <s:iterator value="orderDetails" var="orderDetail">
    					<s:textfield value="%{nmProduct}" readonly="true"/>
    					<s:textfield value="%{amount}" readonly="true"/>
    					<s:textfield value="%{unitPrice}" readonly="true"/>
    					<s:textfield value="%{subTotal}" readonly="true"/>
    				  </s:iterator>
				   	</div>
				</div>

                <div class="row">
				</div>
				</div>
		</div>
	</div>		
</div>
</body>
</html>
