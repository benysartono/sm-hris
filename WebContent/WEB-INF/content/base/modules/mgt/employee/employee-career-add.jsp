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
	//function show_unitlist() {
	//	dojo.event.topic.publish("show_unitlist");
	//}
	
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
            <h1>Adding Employee Career</h1>
          </div>
          <div class="panel-body">
            <s:form id="frmEmployeeCareer" action="employee-career-add" enctype="multipart/form-data" method="post" theme="bootstrap" cssClass="form-horizontal">
             <div class="form-group">
                <div class="row">
                    <div class="col-md-9">
                		<s:textfield
                        	label="ID Employee"
                        	name="employeeCareer.idEmployee"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-3"
                        	tooltip="Enter ID"
                        	value="%{employeeCareer.idEmployee}"/>
					</div>
                    <div class="col-md-9">
                		<s:textfield
                        	label="ID Career"
                        	name="employeeCareer.idCareer"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-3"
                        	tooltip="Enter ID"
                        	value="%{employeeCareer.idCareer}"/>
					</div>
                    <div class="col-md-9">
                		<s:textfield
                        	label="Company"
                        	name="employeeCareer.company"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-3"
                        	tooltip="Enter Company"
                        	value="%{employeeCareer.company}"/>
					</div>
                    <div class="col-md-9">
                		<s:textfield
                        	label="Last Position"
                        	name="employeeCareer.lastPosition"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-3"
                        	tooltip="Enter Last Position"
                        	value="%{employeeCareer.lastPosition}"
                        	/>
                    </div>
                    <div class="col-md-9">
                		<s:textfield
                        	label="Description"
                        	name="employeeCareer.description"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-3"
                        	tooltip="Enter Description"
                        	value="%{employeeCareer.description}"/>
                    </div>
                    <div class="col-md-9">
						<sj:datepicker
                                id="datepicker1"
                                parentTheme="bootstrap"
                                name="employeeCareer.yearFrom"
                                label="Date From"
                                tooltip="Enter Date from"
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
                                name="employeeCareer.yearTo"
                                label="Date To"
                                tooltip="Enter Date To"
                                cssClass="form-control"
                                elementCssClass="col-sm-3"
                                showOn="focus"
                                inputAppendIcon="calendar"
                                dateFormat="yy-m-d"
                                />
					</div>
					
                    <div class="col-md-9">
                		<s:file
                        	label="Upload File"
                        	name="employeeCareer.img"
                        	id="img"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-3"
                        	tooltip="Enter Image"
                        	value="%{employeeCareer.img}"/>
                    </div>
                    <s:submit cssClass="btn btn-primary" name="proc" value="Submit"/>
                </div>
             </div>
			</s:form> 
		  </div>
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

		</div>  <!-- Tab -->
		</div>
		</div>
        </div> <!-- -------col-md-9 -->
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
