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
            <h1>Adding Discount</h1>
          </div>
          <div class="panel-body">
			<div class="tab-content responsive">
            <s:form id="frmCategory" action="index-add" enctype="multipart/form-data" method="post" theme="bootstrap" cssClass="form-horizontal">
                <div class="form-group">
                <div class="row">
                    <div class="col-md-9">
                		<s:select
                        	label="Product Id"
                        	name="discount.idProduct"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-3"
                        	tooltip="Enter Product"
                        	list="products"
                        	listKey="idProduct"
                        	listValue="nmProduct"
                        	/>
					</div>
                    <div class="col-md-9">
                		<s:textfield
                        	label="Discount %"
                        	name="discount.discount"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-3"
                        	tooltip="Enter Discount"
                        	value="%{discount.discount}"
                        	/>
                    </div>
                    <div class="col-md-9">
						<sj:datepicker
                                id="datepicker1"
                                parentTheme="bootstrap"
                                name="discount.startTime"
                                label="Date Start"
                                tooltip="Enter Date Start"
                                cssClass="form-control"
                                elementCssClass="col-sm-3"
                                showOn="focus"
                                inputAppendIcon="calendar"
                                dateFormat="yy-m-d"
                                />
                    </div>
                    <div class="col-md-9">
						<sj:datepicker
                                id="datepicker2"
                                parentTheme="bootstrap"
                                name="discount.endTime"
                                label="Date End"
                                tooltip="Enter Date End"
                                cssClass="form-control"
                                elementCssClass="col-sm-3"
                                showOn="focus"
                                inputAppendIcon="calendar"
                                dateFormat="yy-m-d"
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
