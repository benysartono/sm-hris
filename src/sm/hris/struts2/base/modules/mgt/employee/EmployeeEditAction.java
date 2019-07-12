package sm.hris.struts2.base.modules.mgt.employee;

import com.opensymphony.xwork2.ActionSupport;

import java.sql.SQLException;
import java.io.OutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Blob;
//import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.Department;
import sm.hris.struts2.base.db.DepartmentDAO;
import sm.hris.struts2.base.db.Employee;
import sm.hris.struts2.base.db.EmployeeDAO;

@Results({
	@Result(name="tolist", location="/base/modules/mgt/employee/index", type="redirect"),
})
@ParentPackage(value = "hris")

public class EmployeeEditAction extends SmBaseAction {
    private Employee employee = new Employee();
    private EmployeeDAO employeeDAO = new EmployeeDAO();
    //private ArrayList<Department> departments = new ArrayList<Department>();
    private DepartmentDAO departmentDAO = new DepartmentDAO();
    private ArrayList<Department> departments = new ArrayList<Department>();
    private String proc;
    private String prmimg;
    private Blob bFile;
    private HttpServletResponse response;
    
/*	private String idEmployee = new String(); 									
	private String name = new String(); 				
	private Date dob = new Date(); 			
	private String address = new String(); 						
	private String idSite = new String(); 				
	private String idDept = new String(); 				
	private String idUnit = new String(); 				
	private String idPosition = new String(); 				
*/
    
	public String execute() throws Exception {
		String filePath = "C:/Bitnami/tomcatstack-7.0.67-0/apache-tomcat/webapps/img/" + employee.getIdEmployee();
   	 	try {
			departments = departmentDAO.searchDepartment();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		System.out.println("PRMIMG: " + prmimg);
   	 	//if (prmimg != ""){
   	 		//employeeDAO.setIdEmployee(prmimg);
   	 		//bFile = employeeDAO.getEmployeeImg();
   	 		//byte data[] = bFile.getBytes(1, (int) bFile.length());
   	 		//OutputStream outputStream = response.getOutputStream();
   	 		//FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath));
   	 		//fileOutputStream.write(data);
   	 		//fileOutputStream.flush();
   	 	//}
		if ((proc != null) && (proc.equals("Submit"))){ 
		    if (getEmployee().getIdEmployee() == null || getEmployee().getIdEmployee().trim().equals("")||getEmployee().getName() == null || getEmployee().getName().trim().equals("")){
			    addFieldError("employee.name","The name is required");
			    return SUCCESS;
			} else {
				employeeDAO.employeeEdit(employee);
				return "tolist";
			}	
		} else {
			return SUCCESS; 
		}	
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

	public String getPrmimg(){
		return prmimg;
	}

	public void setPrmimg(String prmimg){
		this.prmimg = prmimg;
	}

	public List<Department> getDepartments(){
		return departments;
	} 

/*
	public String getIdEmployee(){
		return idEmployee;
	}
	
	public void setIdEmployee(String idEmployee) {
		this.idEmployee = idEmployee;
	}

	public String getName(){
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Date getDob(){
		return dob;
	}
	
	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress(){
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	public String getIdSite(){
		return idSite;
	}
	
	public void setIdSite(String idSite) {
		this.idSite = idSite;
	}

	public String getIdDept(){
		return idDept;
	}
	
	public void setIdDept(String idDept) {
		this.idDept = idDept;
	}

	public String getIdUnit(){
		return idUnit;
	}
	
	public void setIdUnit(String idUnit) {
		this.idUnit = idUnit;
	}

	public String getIdPosition(){
		return idPosition;
	}
	
	public void setIdPosition(String idPosition) {
		this.idPosition = idPosition;
	}
*/

}


	