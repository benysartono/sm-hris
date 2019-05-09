package sm.hris.struts2.base.modules.mgt.rolemenu;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import sm.hris.struts2.base.db.RoleMenu;
import sm.hris.struts2.base.db.RoleMenuDAO;

import sm.hris.struts2.base.SmBaseAction;

@Results({
	@Result(name="tolist", location="/base/modules/mgt/rolemenu/index", type="redirect"),
})
@ParentPackage(value = "hris")

public class RoleMenuAddAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
    private RoleMenu roleMenu = new RoleMenu();
    private RoleMenuDAO roleMenuDAO = new RoleMenuDAO();
    private String proc = new String();
	
	public String execute() throws Exception {
		if(proc.equals("Submit")){
				roleMenuDAO.setRoleMenu(roleMenu);
			    roleMenuDAO.roleMenuAdd();
				return "tolist";
		} else {
			return SUCCESS; 
		}	
	}

	public RoleMenu getRoleMenu(){
		return roleMenu;
	}

	public void setRoleMenu(RoleMenu roleMenu){
		this.roleMenu = roleMenu;
	}
	
	public String getProc(){
		return proc;
	}

	public void setProc(String proc){
		this.proc = proc;
	}

}


	