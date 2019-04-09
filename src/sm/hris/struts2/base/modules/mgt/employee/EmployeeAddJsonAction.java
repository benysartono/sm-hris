package sm.hris.struts2.base.modules.mgt.employee;


import java.io.File;
//import java.nio.file.Path;
//import java.nio.file.Paths;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.SQLException;
//import java.util.List;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import sm.hris.struts2.base.db.Department;
import sm.hris.struts2.base.db.DepartmentDAO;
import sm.hris.struts2.base.db.Employee;
import sm.hris.struts2.base.db.EmployeeDaoJson;
import sm.hris.struts2.base.db.EmployeeEdu;
import sm.hris.struts2.base.db.EmployeeEduDAO;

import sm.hris.struts2.base.SmBaseAction;

public class EmployeeAddJsonAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
    private Employee employee = new Employee();
    private EmployeeDaoJson employeeDaoJson = new EmployeeDaoJson();
    private EmployeeEduDAO employeeEduDAO = new EmployeeEduDAO();
    private DepartmentDAO departmentDAO = new DepartmentDAO();
    private ArrayList<Department> departments = new ArrayList<Department>();
    private ArrayList<EmployeeEdu> employeeEdus = new ArrayList<EmployeeEdu>();
    private String proc = new String();
	private File img;
	private String imgContentType;
	
	public String execute() throws Exception {
		
		if(proc.equals("Submit")){ 
		    if (getEmployee().getIdEmployee() == null || getEmployee().getIdEmployee().trim().equals("")||getEmployee().getName() == null || getEmployee().getName().trim().equals("")){
			  	 
			    addFieldError("employee.name","The name is required");
			    return SUCCESS;
			} else {
			    employeeDaoJson.employeeAdd(employee);
			    employeeDaoJson = null;
			    employee = null;
			    
	    
		    	//EmployeeEdu employeeEdu = new EmployeeEdu();
			    //for(int n = 0 ; n < employeeEdus.size(); n++) {
			    //	employeeEdu = employeeEdus.get(n);
			    //}
			    //employeeEdus = null;
			    
			    //departmentDAO = null;
			    
			    addActionMessage("<pm>1 employee added</pm>"); 
				return "tolist";
			}	
		} else {
			return SUCCESS; 
		}	
	}

    private static String getFileExtension(File file) {

    	return "jpg";
    }
    
	public Employee getEmployee(){
		return employee;
	}

	public void setEmployee(Employee employee){
		this.employee = employee;
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

	
	public File getImg() {
		return img;
	}

	public void setImg(File img) {
		this.img = img;
	}

	public String getImgContentType() {
		return imgContentType;
	}

	public void setImgContentType(String imgContentType) {
		this.imgContentType = imgContentType;
	}

	public List<EmployeeEdu> getEmployeeEdus() {
		return employeeEdus;
	}

	public void setEmployeeEdus(ArrayList<EmployeeEdu> employeeEdus) {
		this.employeeEdus = employeeEdus;
	}


}


	