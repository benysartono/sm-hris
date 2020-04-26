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
    <title>Subscribe</title>

    <!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    
    <sb:head />
    <sj:head jqueryui="true"/>
    
    <style type="text/css">
        body {
            padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
        }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.5/angular.min.js"></script>
    <script>
	var app = angular.module('subscribeApp', []);
	app.controller('subscribeAppCtrl', function($scope, $http, $window, $interval) {
		var stop;
		$scope.cnt=0;
		stop =$interval(function(){
			$scope.cnt++; 
			var murl = "<s:url value='sensor-json'/>";
			$http.get(murl)
			.then(function(response) {
				$scope.smiotTests = response.data.smiotTests;
				//console.log("The murl :" + murl);
		    })
	    	},10000);
		//stop=$interval($scope.refreshDisplay,2000);

	});    
    </script>
    
    
</head>
<body>


<div class="container">
    <div class="row">
        <div class="col-md-9">

            <h1>Subscribe</h1>

            <s:actionerror theme="bootstrap"/>
            <s:actionmessage theme="bootstrap"/>
            <s:fielderror theme="bootstrap"/>


        </div>
    </div>
    <div class="row">
        <div class="col-md-9">
        <div ng-app="subscribeApp" ng-controller="subscribeAppCtrl" id="result">
			<div class="row">
	        	<div class="col-md-10">
				<table width="100%" Class="table-responsive table-striped table-bordered">
					<thead>
						<tr>
							<td>
								ID Sensor
							</td>
							<td>
								Value
							</td>
							<td>
								Sendor Type
							</td>
							<td>
								Last Updated
							</td>
						</tr>
					</thead>
					<tbody>
					<s:iterator value="sensors">
						<tr>
							<td>       
								<s:property value ="idSensor"/>
							</td>
							<td>       
								<s:property value ='value'/>
							</td>
							<td>       
								<s:property value ='idSensorType'/>
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


        <table>
        	<tr ng-repeat="x in smiotTests">
        		<td>{{x.content}}</td>
        	</tr>
        </table>
        {{cnt}}
        </div>
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
