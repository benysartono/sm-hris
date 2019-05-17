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
                        	value="%{employee.idEmployee}"/>
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
						<s:url id="d_url" action="unit-list" /> 
						<sx:div 
							id="unitlist" href="%{d_url}" 
							listenTopics="show_unitlist" 
							theme="ajax"
							formId="frmEmployee" 
							/>                    
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
						<img width="100" height="100" src="<s:url value='employee-edit?prmimg='/><s:property value='%{employee.idEmployee}' />">
					</div>
					<s:submit cssClass="btn btn-primary" name="proc" value="Submit"/>
                </div>
                </div>
            </s:form>
        </div>
		<div class="tab-pane"  id="edu"><p>Under Construction</p></div>
		<div class="tab-pane" id="career"><p>Under Construction</p></div>
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
