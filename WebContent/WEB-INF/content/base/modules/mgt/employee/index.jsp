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
    <script>
    function fnEmployeeAdd(){
    	location.href = "http://127.0.0.1/sm-hris/base/modules/mgt/employee/employee-add";
    }
    
    function delConfirm() {
        var r = confirm("Are you sure?");
        if (r == true) {
        	document.getElementById("proc").value="delete";
        	document.getElementById("frmIdEmployee").submit();
        }
    }
    </script>
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
                	class="text-right"/><s:submit cssClass="btn btn-primary" name="proc" value="Search"/>
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
					<s:iterator value="employees">
						<tr>
							<td>       
								<input type="checkbox" name="idEmployees"  value="<s:property value ="idEmployee"/>"><s:property value ="idEmployee"/></checkbox>
							</td>
							<td>       
								<s:url action="employee-edit" var="urlTag" escapeAmp="false">
    								<s:param name="employee.idEmployee"><s:property value ="idEmployee"/></s:param>
    								<s:param name="employee.name"><s:property value ="name"/></s:param>
    								<s:param name="employee.dob"><s:property value ="dob"/></s:param>
    								<s:param name="employee.address"><s:property value ="address"/></s:param>
    								<s:param name="employee.idSite"><s:property value ="idSite"/></s:param>
    								<s:param name="employee.idDepartment"><s:property value ="idDepartment"/></s:param>
    								<s:param name="employee.idUnit"><s:property value ="idUnit"/></s:param>
    								<s:param name="employee.idPosition"><s:property value ="idPosition"/></s:param>
								</s:url>
								<a href="<s:property value="#urlTag" />" ><s:property value ="name"/></a>
							</td>
							<td>       
								<s:property value ="address"/>
							</td>
							<td>       
								<s:property value ="dob"/>
							</td>
						</tr>
					</s:iterator>
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
		        		<s:submit cssClass="btn btn-primary" id="proc" name="proc" value="Delete" onclick = "return confirm('Are You Sure?')"/>
		        	</td>
		        	<td>
		        	            <s:actionmessage theme="bootstrap"/>
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
