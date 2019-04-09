package sm.hris.struts2.base.modules.mgt.employee;

import java.util.ArrayList;

import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.Department;
import sm.hris.struts2.base.db.DepartmentDAO;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

@Result(name="success",type="json")
@ParentPackage("hris")

public class DeptListJsonAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
	private DepartmentDAO departmentDAO = new DepartmentDAO();
    private ArrayList<Department> departments;
    private String res = new String();
    
    public String execute() throws Exception{
		departments = departmentDAO.searchDepartment();
		res="success";
		return res;
		}

	public ArrayList<Department> getDepartments(){
		return departments;
	}
	
	public void setDepartments(ArrayList<Department> departments){
		this.departments = departments;
	}
}
