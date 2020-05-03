package sm.hris.struts2.base.modules.mgt.employee;

import sm.hris.struts2.base.SmBaseAction;

//import java.util.List;
import java.util.ArrayList;
//import java.util.List;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import sm.hris.struts2.base.db.Employee;
import sm.hris.struts2.base.db.EmployeeDAO;

@Results({
	@Result(name="tolist", location="/base/modules/mgt/employee/index", type="redirect"),
})
@ParentPackage(value = "hris")

public class EmployeeDeleteAction extends SmBaseAction {
    //private static final long serialVersionUID = 7353477345330099548L;
    //private Employee employee;
    private ArrayList<String> idEmployees = new ArrayList<String>();
    private ArrayList<Employee> employees = new ArrayList<Employee>();
    
	public String execute() throws Exception {
		System.out.println("In EmployeeDelete");
		for(int i=0;i<idEmployees.size();i++){
			System.out.println("idEmployees to be deleted: " + idEmployees.get(i));
		}
		EmployeeDAO employeeDAO = new EmployeeDAO();
		employeeDAO.employeeDelete(idEmployees);
		employees = employeeDAO.searchEmployee();
		return "tolist";
	}
	

	public ArrayList<String> getIdEmployees(){
		return idEmployees;
	}
	
	public void setIdEmployees(ArrayList<String> idEmployees){
		this.idEmployees=idEmployees;
	}
	
	public ArrayList<Employee> getEmployees(){
		return employees;
	}
	
	public void setEmployees(ArrayList<Employee> employees){
		this.employees=employees;
	}
	
}
