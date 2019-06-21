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
    <title>Sartono-Media | Human Resource Management | Department Mgt</title>

    <!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <sb:head/>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-9">
		<div class="row">
        <div class="well col-md-9">
            <strong class="text-left">Department List</strong>
			<form id="frmSearchDepartment" method="post" action="index" theme="bootstrap" class="navbar-form navbar-right" label="Department Search">
			<label for="name" class="text-right">Department Search</label>        	
			<s:textfield
        			id="name"
                	name="name"
                	cssClass="input-sm"
                	elementCssClass="col-sm-3"
                	tooltip="Enter Name"
                	class="text-right"/><s:submit cssClass="btn btn-primary" name="proc" value="search"/>
            </form>
		</div>
		</div>
		<div class="row">
        <div class="col-md-9">
			<form id="frmIdDepartment" method="post" action="index" theme="bootstrap" cssClass="form-horizontal" label="Department Delete">
			<div elementCssClass = "table-responsive">
				<table Class="table table-striped table-bordered">
					<thead>
						<tr>
							<td>
								ID
							</td>
							<td>
								NAME
							</td>
							<td>
								DESCRIPTION
							</td>
						</tr>
					</thead>
					<tbody>
					<s:iterator value="departments">
						<tr>
							<td>       
								<input type="checkbox" name="idDepartments"  value="<s:property value ="idDepartment"/>"><s:property value ="idDepartment"/></checkbox>
							</td>
							<td>       
								<s:url action="department-edit" var="urlTag" escapeAmp="false">
    								<s:param name="department.idDepartment"><s:property value ="idDepartment"/></s:param>
    								<s:param name="department.name"><s:property value ="name"/></s:param>
    								<s:param name="department.description"><s:property value ="description"/></s:param>
								</s:url>
								<a href="<s:property value="#urlTag" />" ><s:property value ="name"/></a>
							</td>
							<td>       
								<s:property value ="description"/>
							</td>
						</tr>
					</s:iterator>
					</tbody>	 
				</table>
			</div>
			<s:submit cssClass="btn btn-primary" name="proc" value="Add"/><s:submit cssClass="btn btn-primary" name="proc" value="Delete"/>	
			</form>
        </div>
        </div>
        </div>
    </div>
</div>
</body>
</html>
