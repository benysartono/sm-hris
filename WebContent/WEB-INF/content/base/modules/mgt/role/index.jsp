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
    <title>Sartono-Media | Human Resource Management | Role Mgt</title>

    <!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <sb:head />
    <!-- <link rel="stylesheet" type="text/css" href="<s:url value="http://127.0.0.1/css/bootstrap-treeview.new.css" />">  -->
    <script>
    function fnRoleAdd(){
    	location.href = "http://127.0.0.1/sm-hris/base/modules/mgt/role/role-add";
    }
    
    function delConfirm() {
        var r = confirm("Are you sure?");
        if (r == true) {
        	document.getElementById("proc").value="delete";
        	document.getElementById("frmIdRole").submit();
        }
    }
    </script>
</head>
<body>
<div class="container">
<div class="panel panel-default">
<div class="panel-heading">
	<h1>Role List</h1>
</div>
<div class="panel-body">
    <div class="row">
        <div class="col-md-9">
			<form id="frmSearchRole" method="post" action="index" theme="bootstrap" class="navbar-form navbar-right" label="Role Search">
			<table width="100%" Class="table-responsive table-striped table-bordered">
			<tr>
			<td>
			<label for="roleName" class="text-right">Role Search</label>        	
			</td>
			<td>
			<s:textfield
        			id="roleName"
                	name="roleName"
                	cssClass="input-sm"
                	elementCssClass="col-sm-3"
                	tooltip="Enter Role Name"
                	class="text-right"/><s:submit cssClass="btn btn-primary" name="proc" value="search"/>
			</td>
			</tr>
			</table>
            </form>
		</div>
	</div>	
	<div class="row">
        <div class="col-md-9">
			<form id="frmIdRole" method="post" action="index" theme="bootstrap" cssClass="form-horizontal" label="Role Delete">
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
								ID Role
							</td>
							<td>
								Name
							</td>
							<td>
								Description
							</td>
						</tr>
					</thead>
					<tbody>
					<s:iterator value="roles">
						<tr>
							<td>       
								<input type="checkbox" name="idRoles"  value="<s:property value ="idRole"/>"></checkbox>
							</td>
							<td>       
								<s:url action="role-edit" var="urlTag" escapeAmp="false">
    								<s:param name="role.roleName"><s:property value ="roleName"/></s:param>
    								<s:param name="role.description"><s:property value ="description"/></s:param>
    								<s:param name="role.idRole"><s:property value ="idRole"/></s:param>
								</s:url>
								<a href="<s:property value="#urlTag" />" ><s:property value ="idRole"/></a>
							</td>
							<td>       
								<s:property value ="roleName"/>
							</td>
							<td>       
								<s:property value ="description"/>
							</td>
							<td>       
								<s:url action="role-users-edit" var="urlTag" escapeAmp="false">
    								<s:param name="idRole"><s:property value ="idRole"/></s:param>
								</s:url>
								<a href="<s:property value="#urlTag" />" >Role Users</a>
							</td>
							<td>       
								<s:url action="role-menus-edit" var="urlTag" escapeAmp="false">
    								<s:param name="idRole"><s:property value ="idRole"/></s:param>
								</s:url>
								<a href="<s:property value="#urlTag" />" >Role Menus</a>
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
