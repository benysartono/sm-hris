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
    <title>Sartono-Media | Human Resource Management | Supplier Mgt</title>

    <!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <sb:head />
    <!-- <link rel="stylesheet" type="text/css" href="<s:url value="http://127.0.0.1/css/bootstrap-treeview.new.css" />">  -->
</head>
<body>
<div class="container">
<div class="panel panel-default">
<div class="panel-heading">
	<h1>Supplier List</h1>
</div>
<div class="panel-body">
    <div class="row">
        <div class="col-md-9">
			<form id="frmSearchSupplier" method="post" action="index" theme="bootstrap" class="navbar-form navbar-right" label="Supplier Search">
			<table width="100%" Class="table-responsive table-striped table-bordered">
			<tr>
			<td>
			<label for="description" class="text-right">Supplier Search</label>        	
			</td>
			<td>
			<s:textfield
        			id="description"
                	name="description"
                	cssClass="input-sm"
                	elementCssClass="col-sm-3"
                	tooltip="Enter name"
                	class="text-right"/><s:submit cssClass="btn btn-primary" name="proc" value="Search"/>
			</td>
			</tr>
			</table>
            </form>
		</div>
	</div>	
	<div class="row">
        <div class="col-md-9">
			<form id="frmSupplier" method="post" action="index" theme="bootstrap" cssClass="form-horizontal">
			<div class="row">
	        	<div class="col-md-10">
				<table width="100%" Class="table-responsive table-striped table-bordered">
					<thead>
						<tr>
							<td>
								<input type="checkbox" name="checkAll">ID Supplier</checkbox>
							</td>
							<td>
								Name
							</td>
							<td>
								Address
							</td>
							<td>
								Phone
							</td>
							<td>
								Email
							</td>
						</tr>
					</thead>
					<tbody>
					<s:iterator value="suppliers">
						<tr>
							<td>       
								<input type="checkbox" name="idSuppliers"  value="<s:property value ="idSupplier"/>"><s:property value ="idSupplier"/></checkbox>
							</td>
							<td>       
								<s:url action="index-edit" var="urlTag" escapeAmp="false">
    								<s:param name="supplier.idSupplier"><s:property value ="idSupplier"/></s:param>
    								<s:param name="supplier.nmSupplier"><s:property value ="nmSupplier"/></s:param>
    								<s:param name="supplier.address"><s:property value ="address"/></s:param>
    								<s:param name="supplier.phone"><s:property value ="phone"/></s:param>
    								<s:param name="supplier.email"><s:property value ="email"/></s:param>
    								<s:param name="supplier.fax"><s:property value ="fax"/></s:param>
    								<s:param name="supplier.npwp"><s:property value ="npwp"/></s:param>
    								<s:param name="supplier.bankAccount"><s:property value ="bankAccount"/></s:param>
								</s:url>
								<a href="<s:property value="#urlTag" />" ><s:property value ="nmSupplier"/></a>
							</td>
							<td>       
								<s:property value ="address"/>
							</td>
							<td>       
								<s:property value ="phone"/>
							</td>
							<td>       
								<s:property value ="email"/>
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
