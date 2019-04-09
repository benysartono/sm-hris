package sm.hris.struts2.base.modules.mgt.employee;


import java.util.ArrayList;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.Employee;
import sm.hris.struts2.base.db.EmployeeDAO;


@Results({
	@Result(name="add", location="/base/modules/mgt/employee/employee-add", type="redirect"),
	})
@ParentPackage(value = "hris")

public class IndexAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
	private EmployeeDAO employeeDAO = new EmployeeDAO();
    private ArrayList<Employee> employees;
    private String name = new String();
    private ArrayList<String> formArg = new ArrayList<String>();
    private ArrayList<String> idEmployees = new ArrayList<String>();
    private String proc = new String();
    private String res = new String();
    
    public String execute() throws Exception{
    	//super.listMenu();

    	System.out.println("Nilai proc: "+proc);
    	if(proc.equals("Add")){
    		res = employeeAdd();
    	}
    	if(proc.equals("Delete")){
    		res = employeeDelete();
    	}
		if(!(proc.equals("Add")||proc.equals("Delete"))){
	    	if (!name.equals("")) {
				formArg.add("%"+name+"%");
				employees = employeeDAO.searchEmployeeByName(formArg);
				res="success";
			} 
			else {
				employees = employeeDAO.searchEmployee();
				res="success";
			} 
		}
		return res;
    }
    
	public String employeeDelete() throws Exception {
		System.out.println("In EmployeeDelete");
		for(int i=0;i<idEmployees.size();i++){
			System.out.println("idEmployees to be deleted: " + idEmployees.get(i));
		}
		EmployeeDAO employeeDAO = new EmployeeDAO();
		employeeDAO.employeeDelete(idEmployees);
		return "success";
	}

	public String employeeAdd() throws Exception {
		System.out.println("Employee Add");
		return "add";
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
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}

	public void setProc(String proc) {
        this.proc = proc;
    }



}
