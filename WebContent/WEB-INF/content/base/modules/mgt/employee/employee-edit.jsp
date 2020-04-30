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

<script>
function show_unitlist() {
dojo.event.topic.publish("show_unitlist");
}
</script>

</head>


<body>
            
<div class="container">
    <div class="row">
        <div class="col-md-9">
      	<div class="panel panel-default">
          <div class="panel-heading">
            <h1>Editing Employee</h1>
          </div>
          <div class="panel-body">
			<ul class="nav nav-tabs responsive" id="myTab">
			  <li class="active"><a href="#profile">Profile</a></li>
			  <li><a href="#edu">Education History</a></li>
			  <li><a href="#career">Career History</a></li>
			</ul>

			<div class="tab-content responsive">
			<div class="tab-pane active" id="profile">
            <s:form id="frmEmployee" action="employee-edit" method="post" theme="bootstrap" cssClass="form-horizontal">
                <div class="form-group">
                <div class="row">
                    <div class="col-md-9">
                		<s:textfield
                        	label="ID"
                        	name="employee.idEmployee"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-3"
                        	tooltip="Enter ID"
                        	value="%{employee.idEmployee}"
                        	disabled="true" />
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
                		<s:select
                        	list="departments"
                        	listKey="idDepartment"
                        	listValue ="name"
                        	label="Department"
                        	name="employee.idDepartment"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-3"
                        	tooltip="Enter Department"
                        	value="%{employee.idDepartment}"
                        	onchange="javascript:show_unitlist();return false"/>
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
					<!--  <input type="file" name="employee.photo" />  -->
					<div>
						<!-- <img width="100" height="100" src="<s:url value='employee-edit?prmimg='/><s:property value='%{employee.idEmployee}' />">  -->
						<img width="100" height="100" src="http://127.0.0.1/img/<s:property value='%{employee.idEmployee}'/>.jpg" />
					</div>
					<s:submit cssClass="btn btn-primary" name="proc" value="Submit"/>
                </div>
                </div>
            </s:form>
        </div>
		<div class="tab-pane"  id="edu">
			<table width="100%" Class="table-responsive table-striped table-bordered">
					<thead>
						<tr>
							<td>
								ID
							</td>
							<td>
								School Name
							</td>
							<td>
								Institution
							</td>
							<td>
								Year From
							</td>
							<td>
								Year To
							</td>
						</tr>
					</thead>
					<tbody>
					<s:iterator value="educations">
						<tr>
							<td>       
								<input type="checkbox" name="idEducation"  value="<s:property value ="idEducation"/>"><s:property value ="idEducation"/></checkbox>
							</td>
							<td>       
								<s:url action="education-edit" var="urlTag" escapeAmp="false">
    								<s:param name="education.idEducation"><s:property value ="idEducation"/></s:param>
    								<s:param name="education.idEmployee"><s:property value ="idEmployee"/></s:param>
    								<s:param name="education.schoolName"><s:property value ="schoolName"/></s:param>
    								<s:param name="education.institution"><s:property value ="institution"/></s:param>
    								<s:param name="education.description"><s:property value ="description"/></s:param>
    								<s:param name="education.yearFrom"><s:property value ="yearFrom"/></s:param>
    								<s:param name="education.yearTo"><s:property value ="yearTo"/></s:param>
								</s:url>
								<a href="<s:property value="#urlTag" />" ><s:property value ="schoolName"/></a>
							</td>
							<td>       
								<s:property value ="institution"/>
							</td>
							<td>       
								<s:property value ="yearFrom"/>
							</td>
							<td>       
								<s:property value ="yearTo"/>
							</td>
						</tr>
					</s:iterator>
					</tbody>	 
				</table>
		</div>
		<div class="tab-pane" id="career">
          <s:form id="frmEmployeeCareer" action="employee-career-add" method="post" theme="bootstrap" cssClass="form-horizontal">
            <div class="form-group">
			<table width="100%" Class="table-responsive table-striped table-bordered">
					<thead>
						<tr>
							<td>
								ID
							</td>
							<td>
								Company
							</td>
							<td>
								Last Position
							</td>
							<td>
								Description
							</td>
							<td>
								Year From
							</td>
							<td>
								Year To
							</td>
						</tr>
					</thead>
					<tbody>
					<s:iterator value="employeeCareers">
						<tr>
							<td>       
								<input type="checkbox" name="employeeCareer.idCareer"  value="<s:property value ="idCareer"/>"><s:property value ="idCareer"/></checkbox>
							</td>
							<td>       
								<s:url action="employee-career-edit" var="urlTag" escapeAmp="false">
    								<s:param name="employeeCareer.idCareer"><s:property value ="idCareer"/></s:param>
    								<s:param name="employeeCareer.idEmployee"><s:property value ="idEmployee"/></s:param>
    								<s:param name="employeeCareer.company"><s:property value ="company"/></s:param>
    								<s:param name="employeeCareer.lastPosition"><s:property value ="lastPosition"/></s:param>
    								<s:param name="employeeCareer.description"><s:property value ="description"/></s:param>
    								<s:param name="employeeCareer.yearFrom"><s:property value ="yearFrom"/></s:param>
    								<s:param name="employeeCareer.yearTo"><s:property value ="yearTo"/></s:param>
								</s:url>
								<a href="<s:property value="#urlTag" />" ><s:property value ="company"/></a>
							</td>
							<td>       
								<s:property value ="lastPosition"/>
							</td>
							<td>       
								<s:property value ="description"/>
							</td>
							<td>       
								<s:property value ="yearFrom"/>
							</td>
							<td>       
								<s:property value ="yearTo"/>
							</td>
						</tr>
					</s:iterator>
					</tbody>	 
				</table>
			<div style="display: none;" id="hiddenIdEmployee">
				<s:textfield id="idEmployee" name="employee.idEmployee" value="%{employee.idEmployee}"/>
			</div>							
			<s:submit cssClass="btn btn-primary" name="proc" value="AddCareer"/>
			<s:submit cssClass="btn btn-primary" name="proc" value="DeleteCareer"/>
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

		</div> 
		</div>
		</div>
        </div> <!-- -------col-md-9 -->
    </div>
</div>
<footer>
    <p class="pull-right"><a href="#">Back to top</a></p>

    <p>Created by <a href="http://www.sartono-media.com" target="_blank">PT. SARTONO MEDIA</a>.</p>
</footer>
</body>
</html>
