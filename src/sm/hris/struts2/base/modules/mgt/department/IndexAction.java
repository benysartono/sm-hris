package sm.hris.struts2.base.modules.mgt.department;

import com.opensymphony.xwork2.ActionSupport;

//import java.util.List;
import java.util.ArrayList;
//import java.util.List;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import sm.hris.struts2.base.db.Department;
import sm.hris.struts2.base.db.DepartmentDAO;

@Results({
	@Result(name="loginx", location="/base/login", type="redirect"),
	@Result(name="add", location="/base/modules/mgt/department/department-add", type="redirect"),
	@Result(name="toindex", location="/base/modules/mgt/department/index", type="redirect")})
@InterceptorRef(value="customStack")
@ParentPackage(value = "hris")

public class IndexAction extends ActionSupport {
  //private static final long serialVersionUID = 7353477345330099548L;
  private ArrayList<Department> departments;
  private String name = new String();
  private ArrayList<String> formArg = new ArrayList<String>();
  private ArrayList<String> idDepartments = new ArrayList<String>();
  //private boolean search;
  //private boolean delete;
  //private boolean add;
  private String proc = new String();
  private String res = new String();
	private DepartmentDAO departmentDAO = new DepartmentDAO();
  
  public String execute() throws Exception{
  	System.out.println("Nilai proc: "+proc);
  	if(proc.equals("Add")){
  		res = departmentAdd();
  	}
  	if(proc.equals("Delete")){
  		res = departmentDelete();
  	}
		if(!(proc.equals("Add")||proc.equals("Delete"))){
	    	if (!name.equals("")) {
				formArg.add("%"+name+"%");
				departments = departmentDAO.searchDepartment(formArg);
				res="success";
			} 
			else {
				departments = departmentDAO.searchDepartment();
				res="success";
			} 
		}
		return res;
  }
  
/*    public String DepartmentSearch() throws Exception {
		//If the query is using 'Like' in the statement, then the '%' sign must include in the parameter value instead of in the statement
		formArg.add("%"+name+"%");
		employees = employeeDAO.searchEmployee(formArg);
		return SUCCESS;
	} */
	

	public String departmentDelete() throws Exception {
		System.out.println("In DepartmentDelete");
		for(int i=0;i<idDepartments.size();i++){
			System.out.println("idDepartments to be deleted: " + idDepartments.get(i));
		}
		DepartmentDAO departmentDAO = new DepartmentDAO();
		departmentDAO.departmentDelete(idDepartments);
		return "toindex";
	}

	public String departmentAdd() throws Exception {
		System.out.println("Department Add");
		return "add";
	}


	public ArrayList<String> getIdDepartments(){
			return idDepartments;
		}
			
	public void setIdDepartments(ArrayList<String> idDepartments){
			this.idDepartments=idDepartments;
		}
	
	public ArrayList<Department> getDepartments(){
		return departments;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}

	public void setProc(String proc) {
      this.proc = proc;
  }
  /*
	public void setDelete(boolean delete) {
      this.delete = delete;
  }
  public void setAdd(boolean add) {
      this.add = add;
  }
  public void setSearch(boolean search) {
      this.search = search;
  }
  */

}