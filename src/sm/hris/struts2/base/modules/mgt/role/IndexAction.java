package sm.hris.struts2.base.modules.mgt.role;


import java.util.ArrayList;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.Role;
import sm.hris.struts2.base.db.RoleDAO;


@Results({
	@Result(name="add", location="/base/modules/mgt/role/role-add", type="redirect"),
	})
@ParentPackage(value = "hris")

public class IndexAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
    private Role role = new Role();
    private RoleDAO roleDAO = new RoleDAO();
    private ArrayList<Role> roles;
    private ArrayList<String> formArg = new ArrayList<String>();
    private ArrayList<String> idRoles = new ArrayList<String>();
    private String proc = new String();
    private String res = new String();
    private String searchPrm = new String();
    
    public String execute() throws Exception{
    	if(proc.equals("Add")){
    		res = roleAdd();
    	}
    	if(proc.equals("Delete")){
    		res = roleDelete();
    	}
		if(!(proc.equals("Add")||proc.equals("Delete"))){
	    	if (!searchPrm.equals("")) {
				formArg.add("%"+searchPrm+"%");
				roleDAO.setArgArray(formArg);
				roles = roleDAO.searchRoleByNameLike();
				res="success";
			} 
			else {
				roles = roleDAO.searchRole();
				res="success";
			} 
		}
		return res;
    }
    
	public String roleDelete() throws Exception {
		RoleDAO roleDAO = new RoleDAO();
		roleDAO.setArgArray(idRoles);
		roleDAO.roleDelete();
		roles = roleDAO.searchRole();
		return "success";
	}

	public String roleAdd() throws Exception {
		return "add";
	}


	public Role getRole(){
		return role;
	}
		
	public void setRole(Role role){
		this.role=role;
	}


	public ArrayList<String> getIdRoles(){
			return idRoles;
		}
			
	public void setIdRoles(ArrayList<String> idRoles){
			this.idRoles=idRoles;
		}
	
	public ArrayList<Role> getRoles(){
		return roles;
	}

	public void setRoles(ArrayList<Role> roles){
		this.roles=roles;
	}


	public void setProc(String proc) {
        this.proc = proc;
    }

	public String getSearchPrm(){
		return searchPrm;
	}
		
	public void setSearchPrm(String searchPrm){
		this.searchPrm=searchPrm;
	}


}
