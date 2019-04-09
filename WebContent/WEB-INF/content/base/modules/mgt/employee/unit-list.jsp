<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<s:if test="units != null">
<div class="col-md-9">         
<div class="form-group ">
	<label 	class="col-sm-3 control-label"  for="frmEmployee_employee_idUnit">Unit    
		<i class="glyphicon glyphicon-info-sign s2b_tooltip" title="Enter Unit"></i>
  	</label>    
<div class="col-sm-3 controls">
<s:select                      
		list="units"              
		listKey="idUnit"          
		listValue = "name"        
		label ="Unit"             
		name="employee.idUnit"    
		cssClass="input-sm"       
		elementCssClass="col-sm-3"
        parentTheme="bootstrap"
		/>    
</div>
</div> 
</div>                        
</s:if>