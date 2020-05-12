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
			var murl = "<s:url value='search-device-trx-by-id-site-json'/>";
			$http.get(murl)
			.then(function(response) {
				$scope.deviceTrxs = response.data.deviceTrxs;
				//console.log("The murl :" + murl);
		    });
	    	},10000);
		//stop=$interval($scope.refreshDisplay,2000);

	});    
    </script>
    
    
</head>
<body>


<div class="container">
   	<div class="panel panel-default">
    <div class="panel-heading">
	    <h1>Device Activity Log</h1>
    </div>
    <div class="row">
        <div class="col-md-9">
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
								ID Device
							</td>
							<td>
								Value
							</td>
							<td>
								Value Type
							</td>
							<td>
								Site
							</td>
							<td>
								Last Updated
							</td>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="deviceTrx in deviceTrxs">
							<td>       
								{{deviceTrx.idDevice}}
							</td>
							<td>       
								{{deviceTrx.value}}
							</td>
							<td>       
								{{deviceTrx.nmValueType}}
							</td>
							<td>       
								{{deviceTrx.nmSite}}
							</td>
							<td>       
								{{deviceTrx.updatedTime}}
							</td>
						</tr>
					</tbody>	 
				</table>
				</div>
			</div> 


        </div>
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
