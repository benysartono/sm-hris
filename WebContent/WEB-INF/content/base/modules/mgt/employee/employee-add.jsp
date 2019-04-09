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
            <h1>Adding Employee</h1>
          </div>
          <div class="panel-body">
			<ul class="nav nav-tabs responsive" id="myTab">
			  <li class="active"><a href="#profile">Profile</a></li>
			  <li><a href="#edu">Education History</a></li>
			  <li><a href="#career">Career History</a></li>
			</ul>

			<div class="tab-content responsive">
            <s:form id="frmEmployee" action="employee-add" enctype="multipart/form-data" method="post" theme="bootstrap" cssClass="form-horizontal">
			<div class="tab-pane active" id="profile">

                <div class="form-group">
                <div class="row">
                    <div class="col-md-9">
                		<s:textfield
                        	label="ID"
                        	name="employee.idEmployee"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-3"
                        	tooltip="Enter ID"
                        	value="%{employee.idEmployee}"/>
					</div>
                    <div class="col-md-9">
                		<s:textfield
                        	label="Password"
                        	name="employee.password"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-3"
                        	tooltip="Enter Password"
                        	value="%{employee.password}"/>
					</div>
                    <div class="col-md-9">
                		<s:textfield
                        	label="Name"
                        	name="employee.name"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-3"
                        	tooltip="Enter Name"
                        	value="%{employee.name}"
                        	/>
                    </div>
                    <div class="col-md-9">
                		<s:textfield
                        	label="Address"
                        	name="employee.address"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-3"
                        	tooltip="Enter Address"
                        	value="%{employee.address}"/>
                    </div>
                    <div class="col-md-9">
						<sj:datepicker
                                id="datepicker"
                                parentTheme="bootstrap"
                                name="employee.dob"
                                label="Datepicker"
                                tooltip="Enter DOB"
                                cssClass="form-control"
                                elementCssClass="col-sm-3"
                                showOn="focus"
                                inputAppendIcon="calendar"
                                dateFormat="yy-m-d"
                                />
					</div>
                    <div class="col-md-9">
                		<!--  
                		<select id="idDeptSelect" name="employee.idDept" ng-focus="deptOnFocus()" ng-blur="deptOnBlur()" ng-model="idDeptSelect">
							<option ng-repeat="x in deptlist" value="{{x.idDepartment}}">{{x.name}}</option>
                		</select>
                		-->
						<s:textfield
                        	label="Department"
                        	name="employee.idDepartment"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-3"
                        	tooltip="Enter Department"
                        	value="%{employee.idDepartment}"
                        	id="idDeptSelect"
                        	list="departmentlist"
                        	ng-model="idDeptSelect" 
                        	ng-focus="deptOnFocus()" 
                        	ng-blur="deptOnBlur()"
                        	/>
						
                		<!-- <input list="departmentlist" id="idDeptSelect" name="idDeptSelect" ng-model="idDeptSelect" ng-focus="deptOnFocus()" ng-blur="deptOnBlur()">  -->
						<datalist id="departmentlist">
						    <option ng-repeat="x in deptlist" value="{{x.idDepartment}}">{{x.name}}</option>
						</datalist>
                		<!-- <select ng-model="idDeptSelect" ng-options="item.idDepartment as item.name for item in deptlist" ng-focus="deptOnFocus()" ng-blur="deptOnBlur()"></select> --> 
                    </div>
					
					<div class="col-md-9"> 
						<!-- 
						<select id="idUnitSelect" name="employee.idUnit" ng-model="idUnitSelect">
							<option ng-repeat="x in unitlist" value="{{x.idUnit}}">{{x.name}}</option>
						</select>
						-->
						<s:textfield
                        	label="Unit"
                        	name="employee.idUnit"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-3"
                        	tooltip="Enter Unit"
                        	value="%{employee.idUnit}"
                        	id="idUnitSelect"
                        	list="unitlist"
                        	ng-model="idUnitSelect" 
                        	/>
						<datalist id="unitlist">
						    <option ng-repeat="x in unitlist" value="{{x.idUnit}}">{{x.name}}</option>
						</datalist>
						
					</div>
					
					<!-- 
						<s:url id="d_url" action="unit-list" /> 
						<sx:div 
							id="unitlist" href="%{d_url}" 
							listenTopics="show_unitlist" 
							theme="ajax"
							formId="frmEmployee" 
							/>
					-->		                    
                    <div class="col-md-9">
                		<s:textfield
                        	label="Position"
                        	name="employee.idPosition"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-3"
                        	tooltip="Enter Position"
                        	value="%{employee.idPosition}"/>
                    </div>
                    <div class="col-md-9">
                		<s:textfield
                        	label="Site"
                        	name="employee.idSite"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-3"
                        	tooltip="Enter site"
                        	value="%{employee.idSite}"/>
                    </div>
                    <div class="col-md-9">
                		<s:file
                        	label="Image"
                        	name="employee.img"
                        	id="img"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-3"
                        	tooltip="Enter Image"
                        	value="%{employee.img}"/>
                    </div>
                    <s:submit cssClass="btn btn-primary" name="proc" value="Submit"/>
                </div>
                </div>
        </div>
			<div class="tab-pane"  id="edu">
				<div class="row">
	                    <div class="col-md-9">
	                		<s:textfield
	                        	label="Education ID"
	                        	name="employeeEdus[0].idEmployeeEdu"
	                        	cssClass="input-sm"
	                        	elementCssClass="col-sm-3"
	                        	tooltip="Enter"
	                        	value="%{employeeEdus[0].idEmployeeEdu}"/>
	                    </div>
					
				</div>
				<div class="row">
	                    <div class="col-md-9">
	                		<s:textfield
	                        	label="Employee ID"
	                        	name="employeeEdus[0].idEmployee"
	                        	cssClass="input-sm"
	                        	elementCssClass="col-sm-3"
	                        	tooltip="Enter"
	                        	value="%{employeeEdus[0].idEmployee}"/>
	                    </div>
					
				</div>
	
				<div class="row">
	                    <div class="col-md-9">
	                		<s:textfield
	                        	label="School"
	                        	name="employeeEdus[0].schoolName"
	                        	cssClass="input-sm"
	                        	elementCssClass="col-sm-3"
	                        	tooltip="Enter"
	                        	value="%{employeeEdus[0].schoolName}"/>
	                    </div>
					
				</div>
	
				<div class="row">
	                    <div class="col-md-9">
	                		<s:textfield
	                        	label="Institution"
	                        	name="employeeEdus[0].institution"
	                        	cssClass="input-sm"
	                        	elementCssClass="col-sm-3"
	                        	tooltip="Enter"
	                        	value="%{employeeEdus[0].institution}"/>
	                    </div>
					
				</div>
	
				<div class="row">
	                    <div class="col-md-9">
	                		<s:textfield
	                        	label="Description"
	                        	name="employeeEdus[0].description"
	                        	cssClass="input-sm"
	                        	elementCssClass="col-sm-3"
	                        	tooltip="Enter"
	                        	value="%{employeeEdus[0].description}"/>
	                    </div>
					
				</div>
	
				<div class="row">
	                    <div class="col-md-9">
							<sj:datepicker
	                                id="employeeEdus[0].yearFrom"
	                                parentTheme="bootstrap"
	                                name="employeeEdus[0].yearFrom"
	                                label="From"
	                                tooltip="Enter"
	                                cssClass="form-control"
	                                elementCssClass="col-sm-3"
	                                showOn="focus"
	                                inputAppendIcon="calendar"
	                                dateFormat="yy-m-d"
	                                />
						</div>
				</div>
	
				<div class="row">
	                    <div class="col-md-9">
							<sj:datepicker
	                                id="employeeEdus[0].yearTo"
	                                parentTheme="bootstrap"
	                                name="employeeEdus[0].yearTo"
	                                label="To"
	                                tooltip="Enter"
	                                cssClass="form-control"
	                                elementCssClass="col-sm-3"
	                                showOn="focus"
	                                inputAppendIcon="calendar"
	                                dateFormat="yy-m-d"
	                                />
						</div>
				</div>
	
				<div class="row">
	                    <div class="col-md-9">
	                		<s:textfield
	                        	label="Education ID"
	                        	name="employeeEdus[1].idEmployeeEdu"
	                        	cssClass="input-sm"
	                        	elementCssClass="col-sm-3"
	                        	tooltip="Enter"
	                        	value="%{employeeEdus[1].idEmployeeEdu}"/>
	                    </div>
					
				</div>
				<div class="row">
	                    <div class="col-md-9">
	                		<s:textfield
	                        	label="Employee ID"
	                        	name="employeeEdus[1].idEmployee"
	                        	cssClass="input-sm"
	                        	elementCssClass="col-sm-3"
	                        	tooltip="Enter"
	                        	value="%{employeeEdus[1].idEmployee}"/>
	                    </div>
					
				</div>
	
				<div class="row">
	                    <div class="col-md-9">
	                		<s:textfield
	                        	label="School"
	                        	name="employeeEdus[1].schoolName"
	                        	cssClass="input-sm"
	                        	elementCssClass="col-sm-3"
	                        	tooltip="Enter"
	                        	value="%{employeeEdus[1].schoolName}"/>
	                    </div>
					
				</div>
	
				<div class="row">
	                    <div class="col-md-9">
	                		<s:textfield
	                        	label="Institution"
	                        	name="employeeEdus[1].institution"
	                        	cssClass="input-sm"
	                        	elementCssClass="col-sm-3"
	                        	tooltip="Enter"
	                        	value="%{employeeEdus[1].institution}"/>
	                    </div>
					
				</div>
	
				<div class="row">
	                    <div class="col-md-9">
	                		<s:textfield
	                        	label="Description"
	                        	name="employeeEdus[1].description"
	                        	cssClass="input-sm"
	                        	elementCssClass="col-sm-3"
	                        	tooltip="Enter"
	                        	value="%{employeeEdus[1].description}"/>
	                    </div>
					
				</div>
	
				<div class="row">
	                    <div class="col-md-9">
							<sj:datepicker
	                                id="employeeEdus[1].yearFrom"
	                                parentTheme="bootstrap"
	                                name="employeeEdus[1].yearFrom"
	                                label="From"
	                                tooltip="Enter"
	                                cssClass="form-control"
	                                elementCssClass="col-sm-3"
	                                showOn="focus"
	                                inputAppendIcon="calendar"
	                                dateFormat="yy-m-d"
	                                />
						</div>
				</div>
	
				<div class="row">
	                    <div class="col-md-9">
							<sj:datepicker
	                                id="employeeEdus[1].yearTo"
	                                parentTheme="bootstrap"
	                                name="employeeEdus[1].yearTo"
	                                label="To"
	                                tooltip="Enter"
	                                cssClass="form-control"
	                                elementCssClass="col-sm-3"
	                                showOn="focus"
	                                inputAppendIcon="calendar"
	                                dateFormat="yy-m-d"
	                                />
						</div>
				</div>
	
			</div>
			<div class="tab-pane" id="career"><p>Under Construction</p></div>
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
