package sm.hris.struts2.base.modules.mgt.role;

import com.opensymphony.xwork2.ActionSupport;

import java.sql.SQLException;
//import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.Role;
import sm.hris.struts2.base.db.RoleDAO;

@Results({
	@Result(name="tolist", location="/base/modules/mgt/role/index", type="redirect"),
})
@ParentPackage(value = "hris")

public class RoleEditAction extends SmBaseAction {
    private Role role = new Role();
    private RoleDAO roleDAO = new RoleDAO();
    private String proc = new String();
    
/*	private String idEmployee = new String(); 									
	private String name = new String(); 				
	private Date dob = new Date(); 			
	private String address = new String(); 						
	private String idSite = new String(); 				
	private String idDept = new String(); 				
	private String idUnit = new String(); 				
	private String idPosition = new String(); 				
*/
    
	public String execute() throws Exception {
		if(proc.equals("Submit")){ 
			roleDAO.setRole(role);
			roleDAO.roleEdit();
			return "tolist";
		} else {
			return SUCCESS; 
		}	
	}

	      
	public Role getRole(){
		return role;
	}

	public void setRole(Role role){
		this.role = role;
	}
	
	public String getProc(){
		return proc;
	}

	public void setProc(String proc){
		this.proc = proc;
	}


}


	