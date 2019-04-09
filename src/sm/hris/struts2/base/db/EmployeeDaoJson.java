package sm.hris.struts2.base.db;
 
import java.util.ArrayList;
//import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.Connection;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import sm.hris.struts2.base.db.Employee;

@Results({@Result(name="success",type="json"),
@Result(name="loginx", location="/base/login", type="redirect")})
@InterceptorRef(value="customStack")
@ParentPackage("hris")

public class EmployeeDaoJson extends ActionSupport {
 
	private ArrayList<Employee> employees2 = new ArrayList<Employee>();
	private ArrayList<EmployeeFR> employeesfr = new ArrayList<EmployeeFR>();
    private String idEmployee;
    private ArrayList<String> argArray = new ArrayList<String>();
	private Boolean executeResult = null;
	private Connection con = ConPool.getConnection();
    private PreparedStatement ps;
    private ResultSet rs;
	private String imgContentType;
    
	public ResultSet searchEmployee() throws SQLException{
        ResultSet rs = null;
		try {
			String sql = "Select * from smhris_employee";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery(sql);
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (con != null) {
				con.close();
			}
		} 
        
    }

	public ResultSet searchEmployee(String uid, String password) throws SQLException{
        ResultSet rs = null;
		try {
			String sql = "Select * from smhris_employee where uid = ? and password = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, uid);
			ps.setString(2, password);
			rs = ps.executeQuery(sql);
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (con != null) {
				con.close();
			}
		} 
    } 

	public void employeeAdd(Employee employee) throws SQLException{
			System.out.println("Ada di dalam EmployeeDAO EmployeeAdd");
			try {

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
			    
				String sql = "Insert into smhris_employee(idEmployee,name,address,dob,idDepartment,idUnit,idPosition,idSite,imgURL,password) values(?,?,?,?,?,?,?,?,?,?)";
				ps = con.prepareStatement(sql);
				ps.setString(1, employee.getIdEmployee());
				ps.setString(2, employee.getName());
				ps.setString(3, employee.getAddress());
				String cvtDate = convertStringToDate(employee.getDob());
				//ps.setString(4, employee.getDob().toString());
				ps.setString(4, cvtDate);
				ps.setString(5, employee.getIdDepartment());
				ps.setString(6, employee.getIdUnit());
				ps.setString(7, employee.getIdPosition());
				ps.setString(8, employee.getIdSite());
				ps.setString(9, employee.getImgURL());
				ps.setString(10, employee.getPassword());
				executeResult = ps.execute();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (con != null) {
					con.close();
				}
			} 
    }
	

    private static String getFileExtension(File file) {

    	return "jpg";
    }

    public String getImgContentType() {
		return imgContentType;
	}

	public void setImgContentType(String imgContentType) {
		this.imgContentType = imgContentType;
	}

	public String convertStringToDate(Date indate)
	{
	   String dateString = null;
	   SimpleDateFormat sdfr = new SimpleDateFormat("yyyy-mm-dd");
	   /*you can also use DateFormat reference instead of SimpleDateFormat 
	    * like this: DateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
	    */
	   try{
		dateString = sdfr.format( indate );
	   }catch (Exception ex ){
		System.out.println(ex);
	   }
	   return dateString;
	}
}