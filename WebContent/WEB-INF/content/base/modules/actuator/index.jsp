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
    <title>Sartono-Media | Human Resource Management |  Mgt</title>

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
	<h1>Actuators List</h1>
</div>
<div class="panel-body">
    <div class="row">
        <div class="col-md-9">
			<s:form id="frmSearchActuator" method="post" action="index" theme="bootstrap" class="navbar-form navbar-right" label="Actuator Search">
			<table width="100%" Class="table-responsive table-striped table-bordered">
			<tr>
			<td>
			<label for="description" class="text-right">Actuator Search</label>        	
			</td>
			<td>
			<s:textfield
        			id="srcParam"
                	name="srcParam"
                	cssClass="input-sm"
                	elementCssClass="col-sm-3"
                	tooltip="Enter search param"
                	class="text-right"/>
                	<s:submit cssClass="btn btn-primary" name="proc" value="Search"/>
			</td>
			</tr>
			</table>
            </s:form>
		</div>
	</div>
	<div class="row">
        <div class="col-md-9">
			<s:form id="frmActuator" method="post" action="index" enctype="multipart/form-data" >
			<div class="row">
	        	<div class="col-md-12">
				<table width="100%" Class="table-responsive table-striped table-bordered">
					<thead>
						<tr>
							<th align="center">
								ID Actuator
							</th>
							<th align="center">
								On Off
							</th>
							<th align="center">
								id Relay
							</th>
							<th align="center">
								Last Updated
							</th>
						</tr>
					</thead>
					<tbody>
					<s:iterator value="actuators">
						<tr>
							<td>       
								<input type="checkbox" name="idActuatorIdRelays"  value="<s:property value ="idActuatorIdRelay"/>"><s:property value ="idActuator"/></checkbox>
							</td>
							<td align="center">  
								<s:url action="index" var="urlTag" escapeAmp="false">
    								<s:param name="proc">OnOff</s:param>
    								<s:param name="actuator.idActuator"><s:property value ="idActuator"/></s:param>
    								<s:param name="actuator.idRelay"><s:property value ="idRelay"/></s:param>
    								<s:param name="actuator.command"><s:property value ="command"/></s:param>
								</s:url>
								<a href="<s:property value="#urlTag" />" ><img src="/img/icon/<s:property value ='command'/>.png"/></a>
							</td>
							<td>       
								<s:url action="index-edit" var="urlTag" escapeAmp="false">
    								<s:param name="actuator.idActuator"><s:property value ="idActuator"/></s:param>
    								<s:param name="actuator.idRelay"><s:property value ="idRelay"/></s:param>
    								<s:param name="actuator.command"><s:property value ="command"/></s:param>
								</s:url>
								<a href="<s:property value="#urlTag" />" ><s:property value ="idRelay"/></a>
							</td>
							<td>       
								<s:property value ="updatedTime"/>
							</td>
						</tr>
					</s:iterator>
					</tbody>	 
				</table>
				</div>
			</div> 
			<div class="row">
				<div class="col-sm-4">
		    		<s:submit cssClass="btn btn-primary" name="proc" id="Actv" value="Actv" onclick = "return confirm('Are You Sure?')"></s:submit> 
	        	</div>
	        	<div  class="col-sm-4">
	        		<s:submit cssClass="btn btn-primary" name="proc" id="InActv" value="InActv" onclick = "return confirm('Are You Sure?')"></s:submit>
	        	</div>
        	</div>
			</s:form>
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
