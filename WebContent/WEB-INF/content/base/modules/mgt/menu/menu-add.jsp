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
    <!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	
    <![endif]-->
    <sb:head includeScripts="true" includeScriptsValidation="false"/>
	<sj:head jqueryui="true"/>
    <style type="text/css">
        body {
            padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
        }
    </style>
	<sx:head />
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.5/angular.min.js"></script>
	<script>
	
	</script>

</head>


<body>
            
<div class="container">
    <div class="row">
        <div class="col-md-9">
      	<div class="panel panel-default">
          <div class="panel-heading">
            <h1>Adding Menu</h1>
          </div>
          <div class="panel-body">
			<div class="tab-content responsive">
            <s:form id="frmMenu" action="menu-add" enctype="multipart/form-data" method="post" theme="bootstrap" cssClass="form-horizontal">
                <div class="form-group">
                <div class="row">
                    <div class="col-md-9">
                		<s:textfield
                        	label="ID Menu"
                        	name="menu.idMenu"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-3"
                        	tooltip="Enter Id"
                        	value="%{menu.idMenu}"/>
					</div>
                    <div class="col-md-9">
                		<s:textfield
                        	label="Description"
                        	name="menu.description"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-3"
                        	tooltip="Enter Description"
                        	value="%{menu.description}"
                        	/>
                    </div>
                    <div class="col-md-9">
                		<s:textfield
                        	label="Href"
                        	name="menu.href"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-3"
                        	tooltip="Enter Href"
                        	value="%{menu.href}"
                        	/>
                    </div>
                    <div class="col-md-9">
                		<s:textfield
                        	label="Has Children"
                        	name="menu.hasChildren"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-3"
                        	tooltip="Enter Has Children"
                        	value="%{menu.HasChildren}"
                        	/>
                    </div>
                    <div class="col-md-9">
                		<s:textfield
                        	label="Level"
                        	name="menu.lvl"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-3"
                        	tooltip="Enter Level"
                        	value="%{menu.lvl}"
                        	/>
                    </div>
                    <div class="col-md-9">
                		<s:textfield
                        	label="Order"
                        	name="menu.ord"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-3"
                        	tooltip="Enter Order"
                        	value="%{menu.ord}"
                        	/>
                    </div>
                    <div class="col-md-9">
                		<s:textfield
                        	label="Parent"
                        	name="menu.parent"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-3"
                        	tooltip="Enter Parent"
                        	value="%{menu.parent}"
                        	/>
                    </div>
                    
                    <s:submit cssClass="btn btn-primary" name="proc" value="Submit"/>
                </div>
                </div>
			</s:form> 
		
		</div>  <!-- Tab -->
		</div>
		</div>
        </div> <!-- -------col-md-9 -->
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
</html>
