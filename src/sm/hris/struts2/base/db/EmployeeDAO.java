package sm.hris.struts2.base.db;
 
import java.util.ArrayList;
//import java.util.List;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import sm.hris.struts2.base.db.Employee;
import sm.hris.struts2.base.db.SmBaseDAO;

public class EmployeeDAO extends SmBaseDAO{
 
	private ArrayList<Employee> employees = new ArrayList<Employee>();
	private ArrayList<EmployeeFR> employeesfr = new ArrayList<EmployeeFR>();
    private String idEmployee;
    private ArrayList<String> argArray = new ArrayList<String>();

	public ArrayList<Employee> searchEmployee() throws SQLException{
		//List<Employee> employeesList;
        ResultSet rs = this.runQuery("searchEmployee");
 
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setIdEmployee(rs.getString("idEmployee"));
                employee.setName(rs.getString("name"));
                employee.setAddress(rs.getString("address"));
                employee.setDob(rs.getDate("dob"));
                employee.setIdDepartment(rs.getString("idDepartment"));
                employee.setIdSite(rs.getString("idSite"));
                employee.setIdUnit(rs.getString("idUnit"));
                employee.setIdPosition(rs.getString("idPosition"));
                employees.add(employee);
                
            } 
        	
            if(rs != null){
     		   try {
     		   rs.close();
     		   } catch (SQLException e) {
     		        System.out.println("Exception while closing result set: " + e);
     		   }
     		}
        	closeConnection();
        	
        	return employees;
        
    }

	public ArrayList<Employee> searchEmployeeLogin() throws SQLException{
		ResultSet rs = this.runQuery("searchEmployeeLogin", argArray);
 
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setIdEmployee(rs.getString("idEmployee"));
                employee.setName(rs.getString("name"));
                employee.setAddress(rs.getString("address"));
                employee.setDob(rs.getDate("dob"));
                employee.setIdDepartment(rs.getString("idDepartment"));
                employee.setIdSite(rs.getString("idSite"));
                employee.setIdUnit(rs.getString("idUnit"));
                employee.setIdPosition(rs.getString("idPosition"));
                employees.add(employee);
                
            } 
        	
            if(rs != null){
     		   try {
     		   rs.close();
     		   } catch (SQLException e) {
     		        System.out.println("Exception while closing result set: " + e);
     		   }
     		}
        	closeConnection();
        	
        	return employees;
    }

	public ArrayList<Employee> searchEmployeeByName(ArrayList<String> argArray) throws SQLException{
        ResultSet rs = this.runQuery("searchEmployeeByName",argArray);
 
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setIdEmployee(rs.getString("idEmployee"));
                employee.setName(rs.getString("name"));
                employee.setAddress(rs.getString("address"));
                employee.setDob(rs.getDate("dob"));
                employee.setIdDepartment(rs.getString("idDepartment"));
                employee.setIdSite(rs.getString("idSite"));
                employee.setIdUnit(rs.getString("idUnit"));
                employee.setIdPosition(rs.getString("idPosition"));
                employees.add(employee);
                
            } 
        	
            if(rs != null){
     		   try {
     		   rs.close();
     		   } catch (SQLException e) {
     		        System.out.println("Exception while closing result set: " + e);
     		   }
     		}
        	closeConnection();
        	
        	return employees;
    }

	public ArrayList<EmployeeFR> searchEmployeeFRByNameAndDob(ArrayList<String> argArray) throws SQLException{
        ResultSet rs = this.runQuery("searchEmployeeFRByNameAndDob",argArray);
        	if(rs != null){
	            while (rs.next()) {
	                EmployeeFR employee = new EmployeeFR();
	                employee.setIdEmployee(rs.getString("idEmployee"));
	                employee.setName(rs.getString("name"));
	                employee.setAddress(rs.getString("address"));
	                //employee.setDob(rs.getDate("dob"));
	                employee.setDob(rs.getString("dob"));
	                employee.setIdDepartment(rs.getString("idDepartment"));
	                employee.setIdSite(rs.getString("idSite"));
	                employee.setIdUnit(rs.getString("idUnit"));
	                employee.setIdPosition(rs.getString("idPosition"));
	                employeesfr.add(employee);
	                
	            } 
        	
     		   try {
     		   rs.close();
     		   } catch (SQLException e) {
     		        System.out.println("Exception while closing result set: " + e);
     		   }
     		}
        	closeConnection();
        	
        	return employeesfr;
    }
	
	public ArrayList<EmployeeFR> searchEmployeeFR() throws SQLException{
		//List<Employee> employeesList;
        ResultSet rs = this.runQuery("searchEmployeeFR");
 
            while (rs.next()) {
                EmployeeFR employee = new EmployeeFR();
                employee.setIdEmployee(rs.getString("idEmployee"));
                employee.setName(rs.getString("name"));
                employee.setAddress(rs.getString("address"));
                employee.setDob(rs.getString("dob"));
                employee.setIdDepartment(rs.getString("idDepartment"));
                employee.setIdSite(rs.getString("idSite"));
                employee.setIdUnit(rs.getString("idUnit"));
                employee.setIdPosition(rs.getString("idPosition"));
                employeesfr.add(employee);
                
            } 
        	
            if(rs != null){
     		   try {
     		   rs.close();
     		   } catch (SQLException e) {
     		        System.out.println("Exception while closing result set: " + e);
     		   }
     		}
        	closeConnection();
        	
        	return employeesfr;
        
    }

	public void employeeDelete(ArrayList<String> idEmployees) throws SQLException{
		for(int i=0;i<idEmployees.size();i++) {
			idEmployee = idEmployees.get(i);
			ArrayList<String> argArray = new ArrayList<String>();
			argArray.add(0,idEmployee);
			this.run("employeeDelete", argArray);
			closeConnection();
		}
    }

	public void employeeAdd(Employee employee) throws SQLException{
			System.out.println("Ada di dalam EmployeeDAO EmployeeAdd");
			argArray.add(0, employee.getIdEmployee());
			argArray.add(1, employee.getName());
			argArray.add(2, employee.getAddress());
			String cvtDate = convertDateToString(employee.getDob());
			System.out.println("Employee.getDOB: " + employee.getDob());
			System.out.println("cvtDate: " + cvtDate);
			//argArray.add(3, employee.getDob().toString());
			argArray.add(3, cvtDate);
			argArray.add(4, employee.getIdDepartment());
			argArray.add(5, employee.getIdUnit());
			argArray.add(6, employee.getIdPosition());
			argArray.add(7, employee.getIdSite());
			argArray.add(8, employee.getImgURL());
			argArray.add(9, employee.getPassword());
			this.run("employeeAdd", argArray);
			closeConnection();
    }
	
	public void employeeEdit(Employee employee) throws SQLException{
		
		argArray.add(0, employee.getName());
		argArray.add(1, employee.getAddress());
		String cvtDate;
		cvtDate = convertDateToString(employee.getDob());
		//argArray.add(3, employee.getDob().toString());
		argArray.add(2, cvtDate);
		argArray.add(3, employee.getIdDepartment());
		argArray.add(4, employee.getIdUnit());
		argArray.add(5, employee.getIdPosition());
		argArray.add(6, employee.getIdSite());
		argArray.add(7, employee.getIdEmployee());
		this.run("employeeEdit", argArray);
		closeConnection();
	}

	public String convertDateToString(Date indate)
	{
	   String dateString = null;
	   SimpleDateFormat sdfr = new SimpleDateFormat("yyyy/MM/dd");
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
	
	public void setArgArray(ArrayList<String> argArray){
		this.argArray = argArray;
	}
	public ArrayList<String> getArgArray(){
		return argArray;
	}
}