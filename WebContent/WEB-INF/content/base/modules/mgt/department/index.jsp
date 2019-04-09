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
    <style type="text/css">
        body {
            padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
        }
    </style>
</head>
<body>

<nav class="navbar navbar-default navbar-fixed-top">
    <div class="navbar-header">
        <a class="navbar-brand" href="#">SM - HRIS</a>
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
    </div>
    <div class="navbar-collapse collapse">
        <ul class="nav navbar-nav">
            <s:url var="index_url" action="index"/>
            <li class="active"><s:a href="%{index_url}">Home</s:a></li>
            <s:url var="about_url" action="about"/>
            <li><s:a href="%{about_url}">About</s:a></li>
        </ul>
    </div>
</nav>

<div class="container">
    <div class="row">
        <div class="col-md-3">
                <ul class="nav nav-list tree">
                	<li><label class="tree-toggle nav-header"><a href="/sm-hris/base/under-construction">Dashboard</a></label></li>
                	<li><label class="tree-toggle nav-header">Employee</label>
						<ul class="nav nav-list tree">
                    		<li class="active"><a href="/sm-hris/base/modules/mgt/employee/index">Employee Management</a></li>
                    	</ul>
                    </li>		
                	<li><label class="tree-toggle nav-header"><a href="/sm-hris/base/under-construction">Time Mgt</a></label></li>
                	<li><label class="tree-toggle nav-header"><a href="/sm-hris/base/under-construction">Benefit Adm</a></label></li>
                	<li><label class="tree-toggle nav-header"><a href="/sm-hris/base/under-construction">Organization Mgt</a></label></li>
                	<li><label class="tree-toggle nav-header"><a href="/sm-hris/base/under-construction">Disc. Action Adm</a></label></li>
                	<li><label class="tree-toggle nav-header"><a href="/sm-hris/base/under-construction">MIS Report</a></label></li>
                	<li><label class="tree-toggle nav-header"><a href="/sm-hris/base/under-construction">Complaint</a></label></li>
                	<li><label class="tree-toggle nav-header"><a href="/sm-hris/base/under-construction">Talent</a></label></li>
                	<li><label class="tree-toggle nav-header"><a href="/sm-hris/base/under-construction">Learning</a></label></li>
                	<li><label class="tree-toggle nav-header"><a href="/sm-hris/base/under-construction">Recruitment Adm</a></label></li>
                 </ul>
        </div>
        <div class="col-md-9">
		<div class="row">
        <div class="well col-md-9">
            <strong class="text-left">SM HRIS</strong>
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
<footer>
    <p class="pull-right"><a href="#">Back to top</a></p>

    <p>Created by <a href="http://www.sartono-media.com" target="_blank">PT. SARTONO MEDIA</a>.</p>
</footer>
</body>
</html>
