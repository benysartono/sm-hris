<!DOCTYPE html>
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
    <title>Sartono-Media | Human Resource Management | order Mgt</title>

    <!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <sb:head />
    <!-- <link rel="stylesheet" type="text/css" href="<s:url value="http://127.0.0.1/css/bootstrap-treeview.new.css" />">  -->
    <script data-require="jquery@2.1.3" data-semver="2.1.3" src="http://code.jquery.com/jquery-2.1.3.min.js"></script>
    <script data-require="angular.js@1.3.15" data-semver="1.3.15" src="https://code.angularjs.org/1.3.15/angular.js"></script>
    <script>
    function fnOrderAdd(){
    	location.href = "/sm-hris/base/modules/mgt/order/order-add";
    }
    
    function delConfirm() {
        var r = confirm("Are you sure?");
        if (r == true) {
        	document.getElementById("proc").value="delete";
        	document.getElementById("frmIdOrder").submit();
        }
    }
    </script>
</head>
<body>
<div class="container">
<div class="panel panel-default">
<div class="panel-heading">
	<h1>Order List</h1>
</div>
<div class="panel-body">
    <div class="row">
        <div class="col-md-9">
			<form id="frmSearchOrder" method="post" action="index" theme="bootstrap" class="navbar-form navbar-right" label="Order Search">
			<table width="100%" Class="table-responsive table-striped table-bordered">
			<tr>
			<td>
			<label for="idOrder" class="text-right">Order Search</label>        	
			</td>
			<td>
			<s:textfield
        			id="idOrder"
                	name="idOrder"
                	cssClass="input-sm"
                	elementCssClass="col-sm-3"
                	tooltip="Enter idOrder"
                	class="text-right"/><s:submit cssClass="btn btn-primary" name="proc" value="search"/>
			</td>
			</tr>
			</table>
            </form>
		</div>
	</div>	
	<div class="row">
        <div class="col-md-9">
			<form id="frmIdOrder" method="post" action="index" theme="bootstrap" cssClass="form-horizontal" label="Order Delete">
			<div class="row">
				<div class="col-sm-4">
		    		<s:submit cssClass="btn btn-primary" name="proc" value="Add"/> 
	        	</div>
	        	<div  class="col-sm-4">
	        		<s:submit cssClass="btn btn-primary" name="proc" value="Delete" onclick = "return confirm('Are You Sure?')"/>
	        	</div>
        	</div>
			<div class="row">
	        	<div class="col-md-10">
				<!-- <div elementCssClass = "table-responsive">  -->
				<table width="100%" Class="table-responsive table-striped table-bordered">
					<thead>
						<tr>
							<td>
								<input type="checkbox" name="checkAll"></checkbox>
							</td>
							<td>
								Total
							</td>
							<td>
								Total Discount
							</td>
							<td>
								VAT
							</td>
							<td>
								Cash
							</td>
							<td>
								Changes
							</td>
						</tr>
					</thead>
					<tbody>
					<s:iterator value="orders">
						<tr>
							<td>       
								<input type="checkbox" name="idOrders"  value="<s:property value ="idOrder"/>"><s:property value ="idOrder"/></checkbox>
							</td>
							<td>       
								<s:url action="index" var="urlTag" escapeAmp="false">
    								<s:param name="order.idOrder"><s:property value ="idOrder"/></s:param>
    								<s:param name="order.total"><s:property value ="total"/></s:param>
    								<s:param name="order.totalDiscount"><s:property value ="totalDiscount"/></s:param>
    								<s:param name="order.vat"><s:property value ="vat"/></s:param>
    								<s:param name="order.cash"><s:property value ="cash"/></s:param>
    								<s:param name="order.changes"><s:property value ="changes"/></s:param>
    								<s:param name="order.idPaymentMethod"><s:property value ="idSPaymentMethod"/></s:param>
    								<s:param name="order.paymentRemark"><s:property value ="paymentRemark"/></s:param>
    								<s:param name="order.orderDate"><s:property value ="orderDate"/></s:param>
								</s:url>
								<a href="<s:property value="#urlTag" />" ><s:property value ="total"/></a>
							</td>
							<td>       
								<s:property value ="totalDiscount"/>
							</td>
							<td>       
								<s:property value ="vat"/>
							</td>
							<td>       
								<s:property value ="cash"/>
							</td>
							<td>       
								<s:property value ="changes"/>
							</td>
						</tr>
					</s:iterator>
					</tbody>	 
				</table>
				</div>
			</div> 
			</form>
        </div>
    </div>
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
<script>
$('.tree-toggle').click(function () {
	$(this).parent().children('ul.tree').toggle(200);
});
</script>
</html>
