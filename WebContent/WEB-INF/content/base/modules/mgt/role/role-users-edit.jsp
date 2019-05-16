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
	<h1>User List for Role <s:property value="strParamIdRole" /></h1>
</div>
<div class="panel-body">
<!-- 
    <div class="row">
        <div class="col-md-9">
			<form id="frmSearch" method="post" action="index" theme="bootstrap" class="navbar-form navbar-right" label="Search">
			<table width="100%" Class="table-responsive table-striped table-bordered">
			<tr>
			<td>
			<label for="strSearch" class="text-right">Search</label>        	
			</td>
			<td>
			<s:textfield
        			id="strSearch"
                	name="strSearch"
                	cssClass="input-sm"
                	elementCssClass="col-sm-3"
                	tooltip="Enter Keyword"
                	class="text-right"/><s:submit cssClass="btn btn-primary" name="proc" value="Search"/>
			</td>
			</tr>
			</table>
            </form>
		</div>
	</div>	
 -->	
	<div class="row">
        <div class="col-md-9">
			<form id="frmIdRole" method="post" action="role-users-edit" theme="bootstrap" cssClass="form-horizontal" label="Role Delete">
			<div class="row">
	        	<div class="col-md-10">
				<!-- <div elementCssClass = "table-responsive">  -->
				<table width="100%" Class="table-responsive table-striped table-bordered">
					<thead>
						<tr>
							<td>
								<input type="checkbox" name="checkAll" onclick="for(c in document.getElementsByName('uids')) document.getElementsByName('uids').item(c).checked = this.checked" />
							</td>
							<td>
								ID User
							</td>
							<td>
								Name
							</td>
						</tr>
					</thead>
					<tbody>
					<s:iterator value="roleUsers">
						<tr>
							<td>       
								<input type="checkbox" <s:property value ="idRole"/> name="uids"  value="<s:property value ="uid"/>"></checkbox>
							</td>
							<td>       
								<s:property value ="uid"/>
							</td>
							<td>       
								<s:property value ="name"/>
							</td>
						</tr>
					</s:iterator>
					</tbody>	 
				</table>
				</div>
			</div> 
			<div class="row">
				<div class="col-sm-4">
					<input type="hidden" name="idRole" value="<s:property value='strParamIdRole'/>" />
		    		<s:submit cssClass="btn btn-primary" name="proc" value="Submit"/> 
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
