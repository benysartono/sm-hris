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
    <title>Sartono-Media | Human Resource Management | Menu Mgt</title>

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
	<h1>Menu List</h1>
</div>
<div class="panel-body">
    <div class="row">
        <div class="col-md-9">
			<form id="frmSearchMenu" method="post" action="index" theme="bootstrap" class="navbar-form navbar-right" label="Menu Search">
			<table width="100%" Class="table-responsive table-striped table-bordered">
			<tr>
			<td>
			<label for="description" class="text-right">Menu Search</label>        	
			</td>
			<td>
			<s:textfield
        			id="description"
                	name="description"
                	cssClass="input-sm"
                	elementCssClass="col-sm-3"
                	tooltip="Enter description"
                	class="text-right"/><s:submit cssClass="btn btn-primary" name="proc" value="Search"/>
			</td>
			</tr>
			</table>
            </form>
		</div>
	</div>	
	<div class="row">
        <div class="col-md-9">
			<form id="frmIdMenu" method="post" action="index" theme="bootstrap" cssClass="form-horizontal" label="Menu Delete">
			<div class="row">
	        	<div class="col-md-10">
				<!-- <div elementCssClass = "table-responsive">  -->
				<table width="100%" Class="table-responsive table-striped table-bordered">
					<thead>
						<tr>
							<td>
								<input type="checkbox" name="checkAll">ID Menu</checkbox>
							</td>
							<td>
								Id Menu
							</td>
							<td>
								Description
							</td>
							<td>
								href
							</td>
							<td>
								Has Children
							</td>
							<td>
								Lvl
							</td>
							<td>
								Ord
							</td>
							<td>
								Parent
							</td>
						</tr>
					</thead>
					<tbody>
					<s:iterator value="menus">
						<tr>
							<td>       
								<input type="checkbox" name="idMenus"  value="<s:property value ="idMenu"/>"></checkbox>
							</td>
							<td>       
								<s:url action="menu-edit" var="urlTag" escapeAmp="false">
    								<s:param name="menu.idMenu"><s:property value ="idMenu"/></s:param>
    								<s:param name="menu.description"><s:property value ="description"/></s:param>
    								<s:param name="menu.href"><s:property value ="href"/></s:param>
    								<s:param name="menu.hasChildren"><s:property value ="hasChildren"/></s:param>
    								<s:param name="menu.lvl"><s:property value ="lvl"/></s:param>
    								<s:param name="menu.ord"><s:property value ="ord"/></s:param>
    								<s:param name="menu.parent"><s:property value ="parent"/></s:param>
								</s:url>
								<a href="<s:property value="#urlTag" />" ><s:property value ="idMenu"/></a>
							</td>
							<td>       
								<s:property value ="description"/>
							</td>
							<td>       
								<s:property value ="href"/>
							</td>
							<td>       
								<s:property value ="hasChildren"/>
							</td>
							<td>       
								<s:property value ="lvl"/>
							</td>
							<td>       
								<s:property value ="ord"/>
							</td>
							<td>       
								<s:property value ="parent"/>
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
