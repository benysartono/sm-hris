<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<html lang="en">
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
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
	<!-- <link rel="stylesheet" type="text/css" href="<s:url value="http://127.0.0.1/css/bootstrap-treeview.min.css" />"> -->
	<!-- <script type="text/javascript" src="http://127.0.0.1/js/bootstrap-treeview.min.js"></script> -->
	<script>
		var prevlvl = 0;
	</script>
	<script>
		var app = angular.module("myApp", []); 
		app.controller('myCtrl', function($scope) {
		    $scope.nUrl = "";
		});
	</script>
</head>
<body ng-app="myApp" ng-controller="myCtrl">

<div class="container">
<div class="row">
<div class="col-md-12">
<!-- <nav class="navbar navbar-default navbar-fixed-top">  -->
<nav class="navbar">
    <div class="navbar-header">
        <a class="navbar-brand" href="#">SM - HRIS</a>
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#leftbarmenu">
            <span class="sr-only">Toggle navigation</span>
        </button>
    </div>
    <div class="navbar-collapse collapse">
        <ul class="nav navbar-nav">
            <s:url var="index_url" action="index"/>
            <li class="active"><s:a href="%{index_url}">Home</s:a></li>
            <s:url var="about_url" action="about"/>
            <li><s:a href="%{about_url}">About</s:a></li>
            <s:url var="logout_url" action="logout-mobile"/>
            <li><s:a href="%{logout_url}">Logout</s:a></li>
        </ul>
    </div>
</nav>
</div>
</div>
</div>

<div class="container">
    <div class="row">
        <div class="col-md-3">
            <div class="well sidebar-nav"  id="leftbarmenu">
                <ul class="nav nav-list tree">
					<div class="panel-heading">
						<h1 style="text-align:center; background-color:white">Menu</h1>
						<h3 style="text-align:center; background-color:white">Welcome <%= session.getAttribute("userId") %></h3>
					</div>
                	<s:iterator value="menus">
               			<script type="text/javascript">
	            			var midlgt = "<s:property value ="idMenu"/>";
	            			var lvl = midlgt.length;
	            			var desc = "<s:property value ="description"/>";
	            			var href = "<s:property value ="href"/>";
	            			var haschildren = "<s:property value ="hasChildren"/>";

                			if (!(prevlvl > lvl)){
                				if (haschildren == "Y"){
                    				document.write('<li><label class="tree-toggle">'+desc+'</label><ul class="nav nav-list tree">');
                				}
                				else document.write ('<li><a href="'+href+'">'+desc+'</a></li>');
                			}
                			else {
                				var n;
            					for (n=prevlvl;n>lvl;n--) document.write("</ul></li>");
                				if (haschildren == "Y"){
                    				document.write('<li><label class="tree-toggle">'+desc+'</label><ul class="nav nav-list tree">');
                				}
                				else document.write ('<li><a href="'+href+'">'+desc+'</a></li>');
                			}
                			prevlvl = lvl;
               			</script>
					</s:iterator>

                 </ul>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-md-10">
    	<p>Developed by Beny Sartono for <a href="http://www.sartono-media.com" target="_blank">PT. SARTONO MEDIA</a>.</p>
		</div>
	</div>
</div>	
</body>
<script>
	$('.tree-toggle').click(function () {	$(this).parent().children('ul.tree').toggle(200);
	});
	$(function(){
	$('.tree-toggle').parent().children('ul.tree').toggle(200);
	})
</script>
</html>
