<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="keywords" content="struts2, twitter, bootstrap, plugin, showcase" />
    <meta name="description" content="A Showcase for the Struts2 Bootstrap Plugin" />
    <title>Publish</title>

    <!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    
    <sb:head />
    <style type="text/css">
        body {
            padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
        }
    </style>
</head>
<body>


<div class="container">
    <div class="row">
        <div class="col-md-9">

            <h1>Publish</h1>

            <s:actionerror theme="bootstrap"/>
            <s:actionmessage theme="bootstrap"/>
            <s:fielderror theme="bootstrap"/>


            <s:form id="bootstrapAjaxForm" action="publish" method="post" theme="bootstrap" cssClass="well form-horizontal" validate="true">
                <s:textfield
                        label="Client Id"
                        name="clientid"
                        cssClass="input-sm"
                        elementCssClass="col-sm-3"
                        tooltip="Enter Broker Host and Port"/>
                <s:textfield
                        label="Broker"
                        name="broker"
                        cssClass="input-sm"
                        elementCssClass="col-sm-3"
                        tooltip="Enter Broker Host and Port"/>
                <s:textfield
                        label="Topic"
                        name="topic"
                        cssClass="input-sm"
                        elementCssClass="col-sm-3"
                        tooltip="Enter Topic"/>
                <s:textfield
                        label="Content"
                        name="content"
                        cssClass="input-sm"
                        elementCssClass="col-sm-3"
                        tooltip="Enter Content"/>


                <s:submit cssClass="btn btn-success" />
            </s:form>
        </div>
    </div>
    <div class="row">
        <div class="col-md-9">
        <div id="result"></div>
		</div>
	</div>  
	  
</div>
<div class="container">
<footer>
    <p>Developed by Beny Sartono for <a href="http://www.sartono-media.com" target="_blank">PT. SARTONO MEDIA</a>.</p>
</footer>
</div>
</body>
</html>
