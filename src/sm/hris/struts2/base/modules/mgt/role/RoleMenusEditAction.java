package sm.hris.struts2.base.modules.mgt.role;

import sm.hris.struts2.base.SmBaseAction;

//import java.util.List;
import java.util.ArrayList;
//import java.util.List;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
//import sm.hris.struts2.base.db.Employee;
import sm.hris.struts2.base.db.RoleMenuDAO;
import sm.hris.struts2.base.db.RoleMenu;

@Results({
	@Result(name="tolist", location="/base/modules/mgt/role/index", type="redirect"),
})
@ParentPackage(value = "hris")

public class RoleMenusEditAction extends SmBaseAction {
    //private static final long serialVersionUID = 7353477345330099548L;
    //private Employee employee;
    private ArrayList<String> idMenus = new ArrayList<String>();
    private String idRole;
    private Integer n;
	private RoleMenu roleMenu;
	private ArrayList<RoleMenu> roleMenus = new ArrayList<RoleMenu>();
	private String proc = "";
	private String strParamIdRole;
	private RoleMenuDAO roleMenuDAO;


	public String execute() throws Exception {
    	if(proc.equals("Submit")){
    		roleMenuDAO = new RoleMenuDAO();
			roleMenuDAO.setStrSearch(idRole);
			roleMenuDAO.roleMenuDeleteByIdRole();
			for (n=0;n<idMenus.size();n++){
				roleMenu = new RoleMenu();
	    		roleMenuDAO = new RoleMenuDAO();
				roleMenu.setIdMenu(idMenus.get(n));
				roleMenu.setIdRole(idRole);
				roleMenuDAO.setRoleMenu(roleMenu);
				roleMenuDAO.roleMenuAdd();
			}
    	}
    	roleMenuDAO = new RoleMenuDAO();
    	strParamIdRole = idRole;
    	roleMenuDAO.setStrSearch(idRole);
    	roleMenus = roleMenuDAO.menuListByIdRole();
    	return SUCCESS;
	}
	

	public ArrayList<String> getIdMenus(){
		return idMenus;
	}
	
	public void setIdMenus(ArrayList<String> idMenus){
		this.idMenus=idMenus;
	}
	
	public String getIdRole(){
		return idRole;
	}
	
	public void setIdRole (String idRole){
		this.idRole = idRole;
	}

	public String getProc(){
		return proc;
	}
	
	public void setProc (String proc){
		this.proc = proc;
	}
	
	public ArrayList<RoleMenu> getRoleMenus(){
		return roleMenus;
	}
	
	public void setRoleMenus(ArrayList<RoleMenu> roleMenus){
		this.roleMenus = roleMenus;
	}
	
	public String getStrParamIdRole(){
		return strParamIdRole;
	}
	
	public void setStrParamIdRole(String strParamIdRole){
		this.strParamIdRole = strParamIdRole;
	} 
}
