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
    <title>Sartono-Media | Human Resource Management | Site Mgt</title>

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
	<h1>Sites List</h1>
</div>
<div class="panel-body">
    <div class="row">
        <div class="col-md-9">
			<form id="frmSearchSite" method="post" action="index" theme="bootstrap" class="navbar-form navbar-right" label="Site Search">
			<table width="100%" Class="table-responsive table-striped table-bordered">
			<tr>
			<td>
			<label for="description" class="text-right">Site Search</label>        	
			</td>
			<td>
			<s:textfield
        			id="srcParam"
                	name="srcParam"
                	cssClass="input-sm"
                	elementCssClass="col-sm-3"
                	tooltip="Enter search param"
                	class="text-right"/><s:submit cssClass="btn btn-primary" name="proc" value="Search"/>
			</td>
			</tr>
			</table>
            </form>
		</div>
	</div>	
	<div class="row">
        <div class="col-md-9">
			<form id="frmSite" method="post" action="index" theme="bootstrap" cssClass="form-horizontal" label="Site Delete">
			<div class="row">
	        	<div class="col-md-10">
				<table width="100%" Class="table-responsive table-striped table-bordered">
					<thead>
						<tr>
							<td>
								<input type="checkbox" name="checkAll">ID Site</checkbox>
							</td>
							<td>
								Name
							</td>
							<td>
								Location
							</td>
							<td>
								Description
							</td>
						</tr>
					</thead>
					<tbody>
					<s:iterator value="sites">
						<tr>
							<td>       
								<input type="checkbox" name="idSites"  value="<s:property value ="idSite"/>"><s:property value ="idSite"/></checkbox>
							</td>
							<td>       
								<s:url action="index-edit" var="urlTag" escapeAmp="false">
    								<s:param name="site.idSite"><s:property value ="idSite"/></s:param>
    								<s:param name="site.nmSite"><s:property value ="nmSite"/></s:param>
    								<s:param name="site.description"><s:property value ="description"/></s:param>
    								<s:param name="site.location"><s:property value ="location"/></s:param>
								</s:url>
								<a href="<s:property value="#urlTag" />" ><s:property value ="nmSite"/></a>
							</td>
							<td>       
								<s:property value ="description"/>
							</td>
							<td>       
								<s:property value ="location"/>
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
