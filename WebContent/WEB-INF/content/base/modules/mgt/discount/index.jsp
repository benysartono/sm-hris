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
    <title>Sartono-Media | Human Resource Management | Discount Mgt</title>

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
	<h1>Discount List</h1>
</div>
<div class="panel-body">
    <div class="row">
        <div class="col-md-9">
			<form id="frmSearchDiscount" method="post" action="index" theme="bootstrap" class="navbar-form navbar-right" label="Discount Search">
			<table width="100%" Class="table-responsive table-striped table-bordered">
			<tr>
			<td>
			<label for="description" class="text-right">Discount Search</label>        	
			</td>
			<td>
			<s:textfield
        			id="keyword"
                	name="keyword"
                	cssClass="input-sm"
                	elementCssClass="col-sm-3"
                	tooltip="Enter keyword"
                	class="text-right"/><s:submit cssClass="btn btn-primary" name="proc" value="Search"/>
			</td>
			</tr>
			</table>
            </form>
		</div>
	</div>	
	<div class="row">
        <div class="col-md-9">
			<form id="frmDiscount" method="post" action="index" theme="bootstrap" cssClass="form-horizontal" label="">
			<div class="row">
	        	<div class="col-md-10">
				<table width="100%" Class="table-responsive table-striped table-bordered">
					<thead>
						<tr>
							<td>
								<input type="checkbox" name="checkAll">Discount Id</checkbox>
							</td>
							<td>
								Product Id
							</td>
							<td>
								Discount
							</td>
							<td>
								Start Time
							</td>
							<td>
								End Time
							</td>
						</tr>
					</thead>
					<tbody>
					<s:iterator value="discounts" status="stat" var="discount">
						<tr>
							<td>
								<input type="checkbox" 
									name="idDiscounts" 
									value="<s:property value="idDiscount"/>" >
								</input>
								<s:property value="idDiscount"/>
							</td>	
							<td>		
								<s:url action="index-edit" var="urlTag" escapeAmp="false">
    								<s:param name="discount.idDiscount"><s:property value ="idDiscount"/></s:param>
    								<s:param name="discount.idProduct"><s:property value ="idProduct"/></s:param>
    								<s:param name="discount.discount"><s:property value ="discount"/></s:param>
    								<s:param name="discount.startTime"><s:property value ="startTime"/></s:param>
    								<s:param name="discount.endTime"><s:property value ="endTime"/></s:param>
								</s:url>
								<a href="<s:property value="#urlTag" />" ><s:property value ="idProduct"/></a>
							</td>
							<td>       
								<s:property value ="discount"/>
							</td>
							<td>       
								<s:property value ="startTime"/>
							</td>
							<td>       
								<s:property value ="endTime"/>
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
	        		<s:submit cssClass="btn btn-primary" name="proc" value="Delete" onclick = "return confirm('Are You Sure?')"/>
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
