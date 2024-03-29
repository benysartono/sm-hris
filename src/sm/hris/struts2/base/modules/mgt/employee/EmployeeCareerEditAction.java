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

import java.sql.Blob;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import sm.hris.struts2.base.db.Department;
import sm.hris.struts2.base.db.DepartmentDAO;
import sm.hris.struts2.base.db.Employee;
import sm.hris.struts2.base.db.EmployeeDAO;
import sm.hris.struts2.base.db.EmployeeCareer;
import sm.hris.struts2.base.db.EmployeeCareerDAO;

import sm.hris.struts2.base.SmBaseAction;

@Results({
	@Result(name="tolist", location="/base/modules/mgt/employee/", type="redirect"),
})
@ParentPackage(value = "hris")

public class EmployeeCareerEditAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
    private Employee employee = new Employee();
    private EmployeeDAO employeeDAO = new EmployeeDAO();
    private EmployeeCareer employeeCareer = new EmployeeCareer();
    private EmployeeCareerDAO employeeCareerDAO = new EmployeeCareerDAO();
    private DepartmentDAO departmentDAO = new DepartmentDAO();
    private ArrayList<Department> departments = new ArrayList<Department>();
    private ArrayList<EmployeeCareer> employeeCareers = new ArrayList<EmployeeCareer>();
    private String proc = new String();
	private Blob img;
	private String imgContentType;
	
	public String execute() throws Exception {
		try {
			departments = departmentDAO.searchDepartment();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(proc.equals("Submit")){
		    if (employeeCareer.getIdEmployee().equals(null) || employeeCareer.getIdCareer().equals(null)){
		    	try {
			  		departments = departmentDAO.searchDepartment();
			  	 } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			  	 }
				
			    addFieldError("employee.Id","Id is required");
			    return SUCCESS;
			} else {
			    FileInputStream fis = new FileInputStream(employeeCareer.getImg());
			    byte[] bytesArray = new byte[(int) employeeCareer.getImg().length()];
			    fis.read(bytesArray); //read file into bytes[]
			    fis.close();
			    
			    
			    //Creating New Empty File
				String fileExtension = getFileExtension(employeeCareer.getImg());
			    String filePreffix1 = employeeCareer.getIdEmployee();
			    String filePreffix2 = employeeCareer.getIdCareer();
			    
			    File imgFile = new File("C:/Bitnami/tomcatstack-7.0.67-0/apache-tomcat/webapps/emp/" + filePreffix1 + "." + filePreffix1 + "." + fileExtension);
			    
			    //Writing into the new empty file
			    FileOutputStream fos = new FileOutputStream(imgFile);
			    fos.write(bytesArray);
			    fos.flush();
			    fos.close();
			    
			    String fileURL = "http://127.0.0.1/emp/" + filePreffix1 + "." + filePreffix2 + "."  + fileExtension;
			    
			    employeeCareer.setImgPath(fileURL);
			    //employee.setImg(img);
				
			    employeeCareerDAO.employeeCareerEdit(employeeCareer);

			    departmentDAO = null;
			    //departments = null;
			    
			    addActionMessage("<pm>1 employee career edited</pm>"); 
			    //return SUCCESS;	
				return "tolist";
			}	
		} else {
			//employeeCareer.setIdEmployee(employee.getIdEmployee());
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

	public void setEmployeeCareer(EmployeeCareer employeeCareer){
		this.employeeCareer = employeeCareer;
	}
	
	public EmployeeCareer getEmployeeCareer(){
		return employeeCareer;
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

	
	public Blob getImg() {
		return img;
	}

	public void setImg(Blob img) {
		this.img = img;
	}

	public String getImgContentType() {
		return imgContentType;
	}

	public void setImgContentType(String imgContentType) {
		this.imgContentType = imgContentType;
	}



}


	