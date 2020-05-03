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
import sm.hris.struts2.base.db.Site;
import sm.hris.struts2.base.db.DepartmentDAO;
import sm.hris.struts2.base.db.SiteDAO;
import sm.hris.struts2.base.db.Employee;
import sm.hris.struts2.base.db.EmployeeDAO;
import sm.hris.struts2.base.db.EmployeeEdu;
import sm.hris.struts2.base.db.EmployeeEduDAO;
import sm.hris.struts2.base.db.EmployeeCareer;
import sm.hris.struts2.base.db.EmployeeCareerDAO;

@Results({
	@Result(name="tolist", location="/base/modules/mgt/employee/index", type="redirect"),
	@Result(name="employee-career-add", location="/base/modules/mgt/employee/employee-career-add", type="redirect"),
})
@ParentPackage(value = "hris")

public class EmployeeEditAction extends SmBaseAction {
    private Employee employee = new Employee();
    private EmployeeDAO employeeDAO = new EmployeeDAO();

    private EmployeeEdu employeeEdu = new EmployeeEdu();
    private EmployeeEduDAO employeeEduDAO = new EmployeeEduDAO();

    private EmployeeCareer employeeCareer = new EmployeeCareer();
    private EmployeeCareerDAO employeeCareerDAO = new EmployeeCareerDAO();

    private Department department = new Department();
    private DepartmentDAO departmentDAO = new DepartmentDAO();
    
    private SiteDAO siteDAO = new SiteDAO();

    private ArrayList<EmployeeEdu> employeeEdus = new ArrayList<EmployeeEdu>();
    private ArrayList<EmployeeCareer> employeeCareers = new ArrayList<EmployeeCareer>();
    private ArrayList<Department> departments = new ArrayList<Department>();
    private ArrayList<Site> sites = new ArrayList<Site>();

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
			sites = siteDAO.searchSite();
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
		if ((proc != null)){
			if (proc.equals("Submit")){
			    //if (employee.getIdEmployee() == null || employee.getIdEmployee().trim().equals("")||employee.getName() == null || employee.getName().trim().equals("")){
				//    addFieldError("employee.name","The id employee is missing");
				//    return SUCCESS;
			    //}
				if (proc.equals("AddCareer")){
					return "employee-career-add";
				}
				if (proc.equals("DeleteCareer")){
					return SUCCESS;
			    } else {
			    	System.out.println("employeeEditAction.employee.employeeId nya: " + employee.getIdEmployee());
					employeeDAO.employeeEdit(employee);
					return "tolist";
				}	
			} 
		} else {
				employeeCareers = employeeCareerDAO.searchEmployeeCareer(employee.getIdEmployee());
				employeeEdus = employeeEduDAO.searchEmployeeEdu(employee.getIdEmployee());
				return SUCCESS; 
		}

		return SUCCESS;
	}

	      
	public Employee getEmployee(){
		return employee;
	}

	public void setEmployee(Employee employee){
		this.employee = employee;
	}
	
	public void setEmployeeCareers(ArrayList<EmployeeCareer> employeeCareers){
		this.employeeCareers = employeeCareers;
	}
	
	public ArrayList<EmployeeCareer> getEmployeeCareers(){
		return employeeCareers;
	}

	public void setEmployeeEdus(ArrayList<EmployeeEdu> employeeEdus){
		this.employeeEdus = employeeEdus;
	}
	
	public ArrayList<EmployeeEdu> getEmployeeEdus(){
		return employeeEdus;
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

	public List<Site> getSites(){
		return sites;
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


	