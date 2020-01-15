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
    <script>
    function fnOrderAdd(){
    	location.href = "http://127.0.0.1/sm-hris/base/modules/mgt/order/order-add";
    }
    
    function delConfirm() {
        var r = confirm("Are you sure?");
        if (r == true) {
        	document.getElementById("proc").value="delete";
        	document.getElementById("frmIdPO").submit();
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
			<label for="idPO" class="text-right">Order Search</label>        	
			</td>
			<td>
			<s:textfield
        			id="idPO"
                	name="idPO"
                	cssClass="input-sm"
                	elementCssClass="col-sm-3"
                	tooltip="Enter idPO"
                	class="text-right"/><s:submit cssClass="btn btn-primary" name="proc" value="search"/>
			</td>
			</tr>
			</table>
            </form>
		</div>
	</div>	
	<div class="row">
        <div class="col-md-9">
			<form id="frmIdPO" method="post" action="index" theme="bootstrap" cssClass="form-horizontal" label="Order Delete">
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
								ID PO
							</td>
							<td>
								ID Buyer
							</td>
							<td>
								ID Spec
							</td>
							<td>
								ID Production
							</td>
						</tr>
					</thead>
					<tbody>
					<s:iterator value="orders">
						<tr>
							<td>       
								<input type="checkbox" name="idPOs"  value="<s:property value ="idPO"/>"><s:property value ="idPO"/></checkbox>
							</td>
							<td>       
								<s:url action="index-edit-test" var="urlTag" escapeAmp="false">
    								<s:param name="order.idPO"><s:property value ="idPO"/></s:param>
    								<s:param name="order.idBuyer"><s:property value ="idBuyer"/></s:param>
    								<s:param name="order.idSpec"><s:property value ="idSpec"/></s:param>
    								<s:param name="order.idProduction"><s:property value ="idProduction"/></s:param>
    								<s:param name="order.date"><s:property value ="date"/></s:param>
    								<s:param name="order.terms"><s:property value ="terms"/></s:param>
    								<s:param name="order.idShipVia"><s:property value ="idShipVia"/></s:param>
    								<s:param name="order.shipDate"><s:property value ="shipDate"/></s:param>
    								<s:param name="order.FOB"><s:property value ="FOB"/></s:param>
    								<s:param name="order.inWarehouse"><s:property value ="inWarehouse"/></s:param>
    								<s:param name="order.cancelation"><s:property value ="cancelation"/></s:param>
								</s:url>
								<a href="<s:property value="#urlTag" />" ><s:property value ="idPO"/></a>
							</td>
							<td>       
								<s:property value ="idBuyer"/>
							</td>
							<td>       
								<s:property value ="idSpec"/>
							</td>
							<td>       
								<s:property value ="idProduction"/>
							</td>
						</tr>
					</s:iterator>
					</tbody>	 
				</table>
				</div>
			</div> 
			<div class="row">
				<div class="col-sm-4">
		    		<s:submit cssClass="btn btn-primary" name="proc" value="Add"/> 
	        	</div>
	        	<div  class="col-sm-4">
	        		<s:submit cssClass="btn btn-primary" id="proc" name="proc" value="Delete" onclick = "return confirm('Are You Sure?')"/>
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
