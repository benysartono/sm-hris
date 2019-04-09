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

public class EmployeeEduDAO extends SmBaseDAO{
 
	private ArrayList<EmployeeEdu> employeeEdus = new ArrayList<EmployeeEdu>();
    private ArrayList<String> argArray = new ArrayList<String>();
    private String idEmployeeEdu;

	public ArrayList<EmployeeEdu> searchEmployeeEdu(String idEmployee) throws SQLException{
		//List<Employee> employeesList;
        ResultSet rs = this.runQuery("searchEmployeeEdu", idEmployee);
 
            while (rs.next()) {
                EmployeeEdu employeeEdu = new EmployeeEdu();
                employeeEdu.setIdEmployeeEdu(rs.getString("idEmployeeEdu"));
                employeeEdu.setIdEmployee(rs.getString("idEmployee"));
                employeeEdu.setSchoolName(rs.getString("schoolName"));
                employeeEdu.setInstitution(rs.getString("institution"));
                employeeEdu.setDescription(rs.getString("description"));
                employeeEdu.setYearFrom(rs.getDate("yearFrom"));
                employeeEdu.setYearTo(rs.getDate("yearTo"));
                employeeEdus.add(employeeEdu);
            } 
        	if(rs != null){
     		   try {
     		   rs.close();
     		   } catch (SQLException e) {
     		        System.out.println("Exception while closing result set: " + e);
     		   }
     		}
        	//closeConnection();
        	return employeeEdus;
        
    }


	public void employeeEduDelete(ArrayList<String> idEmployeeEdus) throws SQLException{
		for(int i=0;i<idEmployeeEdus.size();i++) {
			idEmployeeEdu = idEmployeeEdus.get(i);
			this.run("employeeDelete", idEmployeeEdu);
			//closeConnection();
		}
    }

	public void employeeEduAdd(EmployeeEdu employeeEdu) throws SQLException{
			argArray.add(0, employeeEdu.getIdEmployeeEdu());
			argArray.add(1, employeeEdu.getIdEmployee());
			argArray.add(2, employeeEdu.getSchoolName());
			argArray.add(3, employeeEdu.getInstitution());
			argArray.add(4, employeeEdu.getDescription());
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");		
			String cvtDate = formatter.format(employeeEdu.getYearFrom());
			argArray.add(5, cvtDate);
			System.out.println("CVT Date nya:" + cvtDate);
			cvtDate = formatter.format(employeeEdu.getYearTo());
			argArray.add(6, cvtDate);
			System.out.println("CVT Date nya:" + cvtDate);
			this.run("employeeEduAdd", argArray);
			//closeConnection();
			argArray = null;
    }
	
	public void employeeEduEdit(EmployeeEdu employeeEdu) throws SQLException{
		
			argArray.add(0, employeeEdu.getSchoolName());
			argArray.add(1, employeeEdu.getInstitution());
			argArray.add(2, employeeEdu.getDescription());
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");		
			String cvtDate = formatter.format(employeeEdu.getYearFrom());
			argArray.add(3, cvtDate);
			cvtDate = formatter.format(employeeEdu.getYearTo());
			argArray.add(4, cvtDate);
			argArray.add(5, employeeEdu.getIdEmployee());
			argArray.add(6, employeeEdu.getIdEmployeeEdu());
			this.run("employeeEduEdit", argArray);
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