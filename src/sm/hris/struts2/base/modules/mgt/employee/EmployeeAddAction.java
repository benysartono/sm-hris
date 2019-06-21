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
import sm.hris.struts2.base.db.EmployeeEdu;
import sm.hris.struts2.base.db.EmployeeEduDAO;

import sm.hris.struts2.base.SmBaseAction;

@Results({
	@Result(name="tolist", location="/base/modules/mgt/employee/index", type="redirect"),
})
@ParentPackage(value = "hris")

public class EmployeeAddAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
    private Employee employee = new Employee();
    private EmployeeDAO employeeDAO = new EmployeeDAO();
    private EmployeeEduDAO employeeEduDAO = new EmployeeEduDAO();
    private DepartmentDAO departmentDAO = new DepartmentDAO();
    private ArrayList<Department> departments = new ArrayList<Department>();
    private ArrayList<EmployeeEdu> employeeEdus = new ArrayList<EmployeeEdu>();
    private String proc = new String();
	private Blob img;
	private String imgContentType;
	
	public String execute() throws Exception {
		//super.getMenus(); 
		System.out.println("Passing Id Employee: " + employee.getIdEmployee());
		System.out.println("Passing Name: " + employee.getName());
   	 	
		try {
			departments = departmentDAO.searchDepartment();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(proc.equals("Submit")){ 
		    if (getEmployee().getIdEmployee() == null || getEmployee().getIdEmployee().trim().equals("")||getEmployee().getName() == null || getEmployee().getName().trim().equals("")){
			  	 
		    	try {
			  		departments = departmentDAO.searchDepartment();
			  	 } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			  	 }
				
			    addFieldError("employee.name","The name is required");
			    return SUCCESS;
			} else {
				System.out.println("To Be Edited: "+employee.getIdEmployee());
				System.out.println("DOB value: "+employee.getDob());

			    //Reading the file image into FileInputStream
			    FileInputStream fis = new FileInputStream(employee.getImg());
			    byte[] bytesArray = new byte[(int) employee.getImg().length()];
			    fis.read(bytesArray); //read file into bytes[]
			    fis.close();
			    
			    
			    //Creating New Empty File
				String fileExtension = getFileExtension(employee.getImg());
			    String filePreffix = employee.getIdEmployee();
			    File imgFile = new File("C:/Bitnami/tomcatstack-7.0.67-0/apache-tomcat/webapps/img/" + filePreffix + "." + fileExtension);
			    
			    //Writing into the new empty file
			    FileOutputStream fos = new FileOutputStream(imgFile);
			    fos.write(bytesArray);
			    fos.flush();
			    fos.close();
			    
			    System.out.println("File Content Type nya= "+ getImgContentType());
			    String fileURL = "http://127.0.0.1/img/" + filePreffix + "." + fileExtension;
			    employee.setImgURL(fileURL);
			    //employee.setImg(img);

			    employeeDAO.employeeAdd(employee);
			    employeeDAO = null;
			    employee = null;
			    
			    System.out.println("Ukuran Employee Edus: " + employeeEdus.size());
			    
		    	EmployeeEdu employeeEdu = new EmployeeEdu();
			    for(int n = 0 ; n < employeeEdus.size(); n++) {
			    	employeeEdu = employeeEdus.get(n);
			    	System.out.println("Edu ID nya: " + employeeEdu.getIdEmployeeEdu());
			    	System.out.println("Edu School nya: " + employeeEdu.getSchoolName());
			    	System.out.println("Edu Year From nya: " + employeeEdu.getYearFrom());
			    	System.out.println("Edu Year To nya: " + employeeEdu.getYearTo());
			    	//employeeEduDAO.employeeEduAdd(employeeEdu);
			    }
		    	//employeeEduDAO = null;
		    	//employeeEdu = null;
			    employeeEdus = null;
			    
			    departmentDAO = null;
			    //departments = null;
			    
			    addActionMessage("<pm>1 employee added</pm>"); 
			    //return SUCCESS;	
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

	public List<EmployeeEdu> getEmployeeEdus() {
		return employeeEdus;
	}

	public void setEmployeeEdus(ArrayList<EmployeeEdu> employeeEdus) {
		this.employeeEdus = employeeEdus;
	}


}


	