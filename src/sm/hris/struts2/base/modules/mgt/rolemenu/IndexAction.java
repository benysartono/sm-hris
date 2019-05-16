package sm.hris.struts2.base.modules.mgt.rolemenu;

import java.util.ArrayList;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.RoleMenu;
import sm.hris.struts2.base.db.RoleMenuDAO;


@Results({
	@Result(name="add", location="/base/modules/mgt/rolemenu/role-menu-add", type="redirect"),
	})
@ParentPackage(value = "hris")

public class IndexAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
    private RoleMenu roleMenu = new RoleMenu();
    private RoleMenuDAO roleMenuDAO = new RoleMenuDAO();
    private ArrayList<RoleMenu> roleMenus;
    private ArrayList<String> formArg = new ArrayList<String>();
    private ArrayList<String> idRoles = new ArrayList<String>();
    private String proc = new String();
    private String res = new String();
    private String searchPrm = new String();
    
    public String execute() throws Exception{
    	if(proc.equals("Add")){
    		res = roleMenuAdd();
    	}
    	if(proc.equals("Delete")){
    		res = roleDelete();
    	}
		if(!(proc.equals("Add")||proc.equals("Delete"))){
	    	if (!searchPrm.equals("")) {
				formArg.add("%"+searchPrm+"%");
				roleMenuDAO.setArgArray(formArg);
				roleMenus = roleMenuDAO.menuListByIdRole();
				res="success";
			} 
			else {
				roleMenus = roleMenuDAO.searchRoleMenu();
				res="success";
			} 
		}
		return res;
    }
    
  
	public String roleDelete() throws Exception {
		RoleMenuDAO roleMenuDAO = new RoleMenuDAO();
		roleMenuDAO.setArgArray(idRoles);
		roleMenuDAO.roleMenuDelete();
		roleMenus = roleMenuDAO.searchRoleMenu();
		return "success";
	}

	public String roleMenuAdd() throws Exception {
		return "add";
	}

	public RoleMenu getRoleMenu(){
		return roleMenu;
	}
		
	public void setRoleMenu(RoleMenu roleMenu){
		this.roleMenu=roleMenu;
	}


	public ArrayList<String> getIdRoles(){
			return idRoles;
		}
			
	public void setIdRoles(ArrayList<String> idRoles){
			this.idRoles=idRoles;
		}
	
	public ArrayList<RoleMenu> getRoleMenus(){
		return roleMenus;
	}

	public void setRoleMenus(ArrayList<RoleMenu> roleMenus){
		this.roleMenus=roleMenus;
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
