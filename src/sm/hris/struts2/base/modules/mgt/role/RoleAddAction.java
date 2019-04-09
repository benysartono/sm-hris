package sm.hris.struts2.base.modules.mgt.role;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import sm.hris.struts2.base.db.Role;
import sm.hris.struts2.base.db.RoleDAO;

import sm.hris.struts2.base.SmBaseAction;

@Results({
	@Result(name="tolist", location="/base/modules/mgt/role/index", type="redirect"),
})
@ParentPackage(value = "hris")

public class RoleAddAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
    private Role role = new Role();
    private RoleDAO roleDAO = new RoleDAO();
    private String proc = new String();
	
	public String execute() throws Exception {
		if(proc.equals("Submit")){
				roleDAO.setRole(role);
			    roleDAO.roleAdd();
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


	