package sm.hris.struts2.base.modules.mgt.department;

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
import sm.hris.struts2.base.db.Department;
import sm.hris.struts2.base.db.DepartmentDAO;

@Results({
	@Result(name="loginx", location="/base/login", type="redirect"),
	@Result(name="tolist", location="/base/modules/mgt/department/index", type="redirect"),
})

@InterceptorRef(value="customStack")
@ParentPackage(value = "hris")

public class DepartmentAddAction extends ActionSupport {
    private Department department = new Department();
    //private ArrayList<Department> departments = new ArrayList<Department>();
    private DepartmentDAO departmentDAO = new DepartmentDAO();
    private ArrayList<Department> departments = new ArrayList<Department>();
    private String proc = new String();
    
   
	public String execute() throws Exception {
		System.out.println("Passing Id Department: " + department.getIdDepartment());
		System.out.println("Passing Name: " + department.getName());
   	 	try {
			departments = departmentDAO.searchDepartment();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(proc.equals("Submit")){ 
		    if (getDepartment().getIdDepartment() == null || getDepartment().getIdDepartment().trim().equals("")||getDepartment().getName() == null || getDepartment().getName().trim().equals("")){
			  	 try {
			  		departments = departmentDAO.searchDepartment();
			  	 } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    addFieldError("department.name","The name is required");
			    return SUCCESS;
			} else {
				System.out.println("To Be Edited: "+department.getIdDepartment());
				departmentDAO.departmentAdd(department);
				return "tolist";
			}	
		} else {
			return SUCCESS; 
		}	
	}

	      
	public Department getDepartment(){
		return department;
	}

	public void setDepartment(Department department){
		this.department = department;
	}
	
	public String getProc(){
		return proc;
	}

	public void setProc(String proc){
		this.proc = proc;
	}

	public List<Department> getDepartments(){
		return departments;
	} 



}


	