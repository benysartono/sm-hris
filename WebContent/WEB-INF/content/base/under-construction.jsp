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
    <title>Sartono-Media | Human Resource Management</title>

    <!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <sb:head />
    <!-- <sb:head includeScripts="false" includeScriptsValidation="false"/> -->
    <style type="text/css">
        body {
            padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
        }
    </style>
    <script>
	    $('.tree-toggle').click(function () {	$(this).parent().children('ul.tree').toggle(200);
	    });
	    $(function(){
	    $('.tree-toggle').parent().children('ul.tree').toggle(200);
	    })    
    </script>


	<script>
		$(function(){
			var treeView = <s:property value="treeView" escape="false"/>;
			$('#tree').treeview({enableLinks: true, data: treeView});
		});
	</script>
	    
</head>
<body>
<div id="tree" class="col-md-3"></div>


        <div class="col-md-9">

            <h1>SM HRIS</h1>

            <p>----------------------------------------------</p>

			This page is under construction.
        </div>
    </div>
</div>
<footer>
    <p class="pull-right"><a href="#">Back to top</a></p>

    <p>Developed by Beny Sartono for <a href="http://www.sartono-media.com" target="_blank">PT. SARTONO MEDIA</a>.</p>
</footer>
</body>
</html>
