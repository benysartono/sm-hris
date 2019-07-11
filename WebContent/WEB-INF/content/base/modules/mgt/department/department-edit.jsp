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
            <h1>Editing Department</h1>
          </div>
          <div class="panel-body">
            <s:form id="frmDepartment" action="department-edit" method="post" theme="bootstrap" cssClass="form-horizontal">
                <div class="form-group">
                <div class="row">
                    <div class="col-md-9">
                		<s:textfield
                        	label="ID"
                        	name="department.idDepartment"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-3"
                        	tooltip="Enter ID"
                        	value="%{department.idDepartment}"/>
					</div>
                    <div class="col-md-9">
                		<s:textfield
                        	label="Name"
                        	name="department.name"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-3"
                        	tooltip="Enter Name"
                        	value="%{department.name}"
                        	/>
                    </div>
                    <div class="col-md-9">
                		<s:textfield
                        	label="Description"
                        	name="department.description"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-3"
                        	tooltip="Enter Description"
                        	value="%{department.description}"/>
                    </div>
                    <div class="col-md-9">
                		<s:select
                        	list="departments"
                        	listKey="idDepartment"
                        	listValue ="name"
                        	label="Parent Department"
                        	name="department.parentDepartment"
                        	cssClass="input-sm"
                        	elementCssClass="col-sm-3"
                        	tooltip="Enter Parent Department"
                        	value="%{department.parentDepartment}"
                        	/>
                    </div>

                    <s:submit cssClass="btn btn-primary" name="proc" value="Submit"/>
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
