package sm.hris.struts2.base.modules.mgt.employee;


//import java.util.List;
import java.util.ArrayList;
//import java.util.List;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.Employee;
import sm.hris.struts2.base.db.EmployeeDAO;
import sm.hris.struts2.base.db.Menu;
import sm.hris.struts2.base.db.MenuDAO;


@Results({
	@Result(name="toindex", location="/base/modules/mgt/employee/index", type="redirect")})
@ParentPackage(value = "hris")

public class EmployeeImgUpl extends SmBaseAction {
    //private static final long serialVersionUID = 7353477345330099548L;
    //private Employee employee;
	private EmployeeDAO employeeDAO = new EmployeeDAO();
    private ArrayList<Employee> employees;
    private String name = new String();
    private ArrayList<String> formArg = new ArrayList<String>();
    private ArrayList<String> idEmployees = new ArrayList<String>();
    //private boolean search;
    //private boolean delete;
    //private boolean add;
    private String proc = new String();
    private String res = new String();
    
    public String execute() throws Exception{
    	super.listMenu();

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
    
/*    public String employeeSearch() throws Exception {
		//If the query is using 'Like' in the statement, then the '%' sign must include in the parameter value instead of in the statement
		formArg.add("%"+name+"%");
		employees = employeeDAO.searchEmployee(formArg);
		return SUCCESS;
	} */
	

	public String employeeDelete() throws Exception {
		System.out.println("In EmployeeDelete");
		for(int i=0;i<idEmployees.size();i++){
			System.out.println("idEmployees to be deleted: " + idEmployees.get(i));
		}
		EmployeeDAO employeeDAO = new EmployeeDAO();
		employeeDAO.employeeDelete(idEmployees);
		return "toindex";
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

/*
	public void setMenus(ArrayList<Menu> menus){
		super.setMenus(menus);
	}

	public ArrayList<Menu> getMenus(){
		return super.getMenus();
	}
*/
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
