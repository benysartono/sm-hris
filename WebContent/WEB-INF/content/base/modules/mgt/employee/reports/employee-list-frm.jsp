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
	
	var app = angular.module('empApp', []);
	app.controller('empAppCtrl', function($scope, $http) {
		$scope.deptOnBlur=function(){
			$scope.idUnitSelect = null;
			console.log ("The Parameter is: " + $scope.idDeptSelect);
			//var mdata={'idDept':'200'};
			var murl = "/sm-hris/base/modules/mgt/employee/unit-list-json?idDept=" + $scope.idDeptSelect;
			//$http.post("unit-list-json", {params {idDept:"200"}}, {headers:{"Content-Type": "multipart/form-data"}})
			//$http.post("unit-list-json", mdata,{headers:{"Content-Type": "application/x-www-form-urlencoded"}})
			$http.get(murl)
			.then(function(response) {
		        $scope.unitlist = response.data.units;
		    });
	    }

		$scope.deptOnFocus=function(){
		    $http.post("dept-list-json")
		    .then(function(response) {
		        $scope.deptlist = response.data.departments;
		    });
	    }
	
	});

</script>

</head>


<body ng-app="empApp" ng-controller="empAppCtrl">
            
<div class="container">
    <div class="row">
        <div class="col-md-9">
      	<div class="panel panel-default">
          <div class="panel-heading">
            <h1>Listing Employees</h1>
          </div>
          <div class="panel-body">

			<div class="tab-content responsive">
            <s:form id="frmEmployeeList" action="employee-list" enctype="multipart/form-data" method="post" theme="bootstrap" cssClass="form-horizontal">
			<div class="tab-pane active" id="profile">

                <div class="form-group">
                <div class="row">
                    <div class="col-md-9">
                		<s:textfield
                        	label="Name"
                        	name="name"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-3"
                        	tooltip="Enter Name"
                        	value="%{name}"
                        	/>
                    </div>
                    <div class="col-md-9">
						<sj:datepicker
                                id="datepicker1"
                                parentTheme="bootstrap"
                                name="dob1"
                                label="Datepicker1"
                                tooltip="Enter DOB"
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
                                name="dob2"
                                label="Datepicker2"
                                tooltip="Enter DOB"
                                cssClass="form-control"
                                elementCssClass="col-sm-3"
                                showOn="focus"
                                inputAppendIcon="calendar"
                                dateFormat="yy-m-d"
                                />
					</div>
					
                    <s:submit cssClass="btn btn-primary" name="scrToDisplay" value="Submit"/>
                </div>
                </div>
        	</div>
			</s:form> 
		
		<script type="text/javascript">
		$(document).ready(function() {
			$('.nav-tabs > li > a').click(function(event){
			event.preventDefault();//stop browser to take action for clicked anchor
						
			//get displaying tab content jQuery selector
			var active_tab_selector = $('.nav-tabs > li.active > a').attr('href');					
						
			//find actived navigation and remove 'active' css
			var actived_nav = $('.nav-tabs > li.active');
			actived_nav.removeClass('active');
						
			//add 'active' css into clicked navigation
			$(this).parents('li').addClass('active');
						
			//hide displaying tab content
			$(active_tab_selector).removeClass('active');
			$(active_tab_selector).addClass('hide');
						
			//show target tab content
			var target_tab_selector = $(this).attr('href');
			$(target_tab_selector).removeClass('hide');
			$(target_tab_selector).addClass('active');
		     });
		  });	      
		  
		(function($) {
		      fakewaffle.responsiveTabs(['xs', 'sm']);
		  })(jQuery);
		
		</script>

		</div>  <!-- tab-content responsive -->
		</div> <!-- panel-body -->
		</div> <!--panel panel-default  -->
        </div> <!-- col-md-9 -->
    </div> <!-- row -->
</div> <!-- container -->
<div class="container">
    <div class="row">
        <div class="col-md-10">
    		<p class="pull-right"><a href="#">Back to top</a></p>
		</div>
	</div>
</div>	
</body>
</html>
