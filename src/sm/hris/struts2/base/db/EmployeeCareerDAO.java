package sm.hris.struts2.base.db;
 
import java.util.ArrayList;
//import java.util.List;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import sm.hris.struts2.base.db.EmployeeEdu;
import sm.hris.struts2.base.db.SmBaseDAO;

public class EmployeeCareerDAO extends SmBaseDAO{
 
	private ArrayList<EmployeeCareer> employeeCareers = new ArrayList<EmployeeCareer>();
    private ArrayList<String> argArray;

	public ArrayList<EmployeeCareer> searchEmployeeCareer(String idEmployee) throws SQLException{
		//List<Employee> employeesList;
        ResultSet rs = this.runQuery("searchEmployeeCareer", idEmployee);
            while (rs.next()) {
                EmployeeCareer employeeCareer = new EmployeeCareer();
                employeeCareer.setIdCareer(rs.getString("idCareer"));
                employeeCareer.setIdEmployee(rs.getString("idEmployee"));
                employeeCareer.setCompany(rs.getString("company"));
                employeeCareer.setLastPosition(rs.getString("lastPosition"));
                employeeCareer.setDescription(rs.getString("description"));
                employeeCareer.setYearFrom(rs.getDate("yearFrom"));
                employeeCareer.setYearTo(rs.getDate("yearTo"));
                employeeCareers.add(employeeCareer);
            } 
        	if(rs != null){
     		   try {
     		   rs.close();
     		   } catch (SQLException e) {
     		        System.out.println("Exception while closing result set: " + e);
     		   }
     		}
        
        	//closeConnection();
        	return employeeCareers;
        
    }

	public void employeeCareerDelete() throws SQLException{
		for(int i=0;i<employeeCareers.size();i++) {
		    ArrayList<String> argArray = new ArrayList<String>();
			argArray.add(0,employeeCareers.get(i).getIdCareer());
			argArray.add(1,employeeCareers.get(i).getIdEmployee());
			this.run("employeeDelete", argArray);
			//closeConnection();
		}
    }

	public void employeeCareerAdd(EmployeeCareer employeeCareer) throws SQLException{
			argArray.add(0, employeeCareer.getIdCareer());
			argArray.add(1, employeeCareer.getIdEmployee());
			argArray.add(2, employeeCareer.getCompany());
			argArray.add(3, employeeCareer.getLastPosition());
			argArray.add(4, employeeCareer.getDescription());
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
			String cvtDate = formatter.format(employeeCareer.getYearFrom());
			argArray.add(5, cvtDate);
			cvtDate = formatter.format(employeeCareer.getYearTo());
			argArray.add(6, cvtDate);
			this.run("employeeCareerAdd", argArray);
			//closeConnection();
			argArray = null;
    }
	
	public void employeeCareerEdit(EmployeeCareer employeeCareer) throws SQLException{
			argArray.add(0, employeeCareer.getCompany());
			argArray.add(1, employeeCareer.getLastPosition());
			argArray.add(2, employeeCareer.getDescription());
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
			String cvtDate = formatter.format(employeeCareer.getYearFrom());
			argArray.add(3, cvtDate);
			cvtDate = formatter.format(employeeCareer.getYearTo());
			argArray.add(4, cvtDate);
			argArray.add(5, employeeCareer.getIdCareer());
			argArray.add(6, employeeCareer.getIdEmployee());
			this.run("employeeCareerEdit", argArray);
			//closeConnection();
			argArray = null;
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