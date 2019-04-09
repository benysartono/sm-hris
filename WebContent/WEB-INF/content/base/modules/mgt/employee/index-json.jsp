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
    <title>Sartono-Media | Human Resource Management | Employee Mgt</title>

    <!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <sb:head />
    <!-- <link rel="stylesheet" type="text/css" href="<s:url value="http://127.0.0.1/css/bootstrap-treeview.new.css" />"> -->
    
</head>
<body>
<div class="container">
<div class="panel panel-default">
<div class="panel-heading">
	<h1>Employee List</h1>
</div>
<div class="panel-body">
    <div class="row">
        <div class="col-md-9">
			<form id="frmSearchEmployee" method="post" action="index" theme="bootstrap" class="navbar-form navbar-right" label="Employee Search">
			<table width="100%" Class="table-responsive table-striped table-bordered">
			<tr>
			<td>
			<label for="name" class="text-right">Employee Search</label>        	
			</td>
			<td>
			<s:textfield
        			id="name"
                	name="name"
                	cssClass="input-sm"
                	elementCssClass="col-sm-3"
                	tooltip="Enter Name"
                	class="text-right"/><s:submit cssClass="btn btn-primary" name="proc" value="search"/>
			</td>
			</tr>
			</table>
            </form>
		</div>
	</div>	
	<div class="row">
        <div class="col-md-9">
			<form id="frmIdEmployee" method="post" action="index" theme="bootstrap" cssClass="form-horizontal" label="Employee Delete">
			<div class="row">
	        	<div class="col-md-10">
				<!-- <div elementCssClass = "table-responsive">  -->
				<table width="100%" Class="table-responsive table-striped table-bordered">
					<thead>
						<tr>
							<td>
								ID
							</td>
							<td>
								NAME
							</td>
							<td>
								ADDRESS
							</td>
							<td>
								DOB
							</td>
						</tr>
					</thead>
					<tbody>
					<s:property value="employees"/>
					</tbody>	 
				</table>
				</div>
			</div> 
			<div class="row">
				<table width="100%" Class="table-responsive table-striped table-bordered">
					<tr>
					<td>
		        	<s:submit cssClass="btn btn-primary" name="proc" value="Add"/>
		        	</td>
		        	<td>
		        	<s:submit cssClass="btn btn-primary" name="proc" value="Delete"/>
		        	</td>
		        	</tr>
		        </table>	
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
