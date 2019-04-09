package sm.hris.struts2.base.modules.mgt.department;

import com.opensymphony.xwork2.ActionSupport;

//import java.util.List;
import java.util.ArrayList;
//import java.util.List;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import sm.hris.struts2.base.db.DepartmentDAO;
//import sm.hris.struts2.base.db.Employee;
import sm.hris.struts2.base.db.EmployeeDAO;

@Results({
	@Result(name="loginx", location="/base/login", type="redirect"),
	@Result(name="tolist", location="/base/modules/mgt/department/index", type="redirect"),
})

@InterceptorRef(value="customStack")
@ParentPackage(value = "hris")

public class DepartmentDeleteAction extends ActionSupport {
    //private static final long serialVersionUID = 7353477345330099548L;
    //private Employee employee;
    private ArrayList<String> idDepartments = new ArrayList<String>();

	public String execute() throws Exception {
		System.out.println("In DepartmentDelete");
		for(int i=0;i<idDepartments.size();i++){
			System.out.println("idDepartment to be deleted: " + idDepartments.get(i));
		}
		DepartmentDAO departmentDAO = new DepartmentDAO();
		departmentDAO.departmentDelete(idDepartments);
		return "tolist";
	}
	

	public ArrayList<String> getIdDepartments(){
		return idDepartments;
	}
	
	public void setIdDepartments(ArrayList<String> idDepartments){
		this.idDepartments=idDepartments;
	}
}
