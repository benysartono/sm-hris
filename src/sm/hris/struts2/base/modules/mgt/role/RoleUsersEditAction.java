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
import sm.hris.struts2.base.db.RoleUserDAO;
import sm.hris.struts2.base.db.RoleUser;

@Results({
	@Result(name="tolist", location="/base/modules/mgt/role/index", type="redirect"),
})
@ParentPackage(value = "hris")

public class RoleUsersEditAction extends SmBaseAction {
    //private static final long serialVersionUID = 7353477345330099548L;
    //private Employee employee;
    private ArrayList<String> uids = new ArrayList<String>();
    private String idRole;
    private Integer n;
	private RoleUser roleUser;
	private ArrayList<RoleUser> roleUsers = new ArrayList<RoleUser>();
	private String proc = "";
	private String strParamIdRole;
	private RoleUserDAO roleUserDAO;


	public String execute() throws Exception {
    	if(proc.equals("Submit")){
    		roleUserDAO = new RoleUserDAO();
			roleUserDAO.setStrSearch(idRole);
			roleUserDAO.roleUserDeleteByIdRole();
			System.out.println("Appel Ukuran: " + uids.size());
			for (n=0;n<uids.size();n++){
				roleUser = new RoleUser();
	    		roleUserDAO = new RoleUserDAO();
				roleUser.setUid(uids.get(n));
				roleUser.setIdRole(idRole);
				roleUserDAO.setRoleUser(roleUser);
				roleUserDAO.roleUserAdd();
			}
    	}
    	roleUserDAO = new RoleUserDAO();
    	strParamIdRole = idRole;
    	roleUserDAO.setStrSearch(idRole);
    	roleUsers = roleUserDAO.userListByIdRole();
    	return SUCCESS;
	}
	

	public ArrayList<String> getUids(){
		return uids;
	}
	
	public void setUids(ArrayList<String> uids){
		this.uids=uids;
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
	
	public ArrayList<RoleUser> getRoleUsers(){
		return roleUsers;
	}
	
	public void setRoleUsers(ArrayList<RoleUser> roleUsers){
		this.roleUsers = roleUsers;
	}
	
	public String getStrParamIdRole(){
		return strParamIdRole;
	}
	
	public void setStrParamIdRole(String strParamIdRole){
		this.strParamIdRole = strParamIdRole;
	} 
}
