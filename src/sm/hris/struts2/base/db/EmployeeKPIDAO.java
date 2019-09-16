package sm.hris.struts2.base.db;
 
import java.util.ArrayList;
//import java.util.List;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import sm.hris.struts2.base.db.EmployeeKPI;
import sm.hris.struts2.base.db.SmBaseDAO;

public class EmployeeKPIDAO extends SmBaseDAO{
 
	private ArrayList<EmployeeKPI> employeeKPIs = new ArrayList<EmployeeKPI>();
    private ArrayList<String> argArray = new ArrayList<String>();
    private String idEmployee;

	public ArrayList<EmployeeKPI> searchEmployeeKPI() throws SQLException{
		//List<Employee> employeesList;
        ResultSet rs = this.runQuery("searchEmployeeKPI", idEmployee);
            while (rs.next()) {
                EmployeeKPI employeeKPI = new EmployeeKPI();
                employeeKPI.setIdEmployee(rs.getString("idEmployee"));
                employeeKPI.setIdKPI(rs.getString("idKPI"));
                employeeKPI.setTargetKPI(rs.getFloat("targetKPI"));
                employeeKPI.setTargetDate(rs.getDate("targetDate"));
                employeeKPI.setAchievedKPI(rs.getFloat("achievedKPI"));
                employeeKPI.setAchievedDate(rs.getDate("achievedDate"));
                employeeKPI.setStartingDate(rs.getDate("startingDate"));
                employeeKPIs.add(employeeKPI);
            } 
        	if(rs != null){
     		   try {
     		   rs.close();
     		   } catch (SQLException e) {
     		        System.out.println("Exception while closing result set: " + e);
     		   }
     		}
        
        	//closeConnection();
        	return employeeKPIs;
        
    }

	public void deleteEmployeeKPI() throws SQLException{
		for(int i=0;i<employeeKPIs.size();i++) {
		    		    
			argArray.add(0,employeeKPIs.get(i).getIdEmployee());
			argArray.add(1,employeeKPIs.get(i).getIdKPI());
			argArray.add(2,String.valueOf(employeeKPIs.get(i).getTargetKPI()));
			argArray.add(3,convertDateToString(employeeKPIs.get(i).getTargetDate()));
			argArray.add(4,String.valueOf(employeeKPIs.get(i).getAchievedKPI()));
			argArray.add(5,convertDateToString(employeeKPIs.get(i).getAchievedDate()));
			argArray.add(6,convertDateToString(employeeKPIs.get(i).getStartingDate()));
			
			this.run("deleteEmployeeKPI", argArray);
			//closeConnection();
		}
    }

	public void addEmployeeKPI(EmployeeKPI employeeKPI) throws SQLException{
		argArray.add(0,employeeKPI.getIdEmployee());
		argArray.add(1,employeeKPI.getIdKPI());
		argArray.add(2,String.valueOf(employeeKPI.getTargetKPI()));
		argArray.add(3,convertDateToString(employeeKPI.getTargetDate()));
		argArray.add(4,String.valueOf(employeeKPI.getAchievedKPI()));
		argArray.add(5,convertDateToString(employeeKPI.getAchievedDate()));
		argArray.add(6,convertDateToString(employeeKPI.getStartingDate()));
		
		this.run("addEmployeeKPI", argArray);
		//closeConnection();
		argArray = null;
    }
	
	public void editEmployeeKPI(EmployeeKPI employeeKPI) throws SQLException{
		argArray.add(0,employeeKPI.getIdEmployee());
		argArray.add(1,employeeKPI.getIdKPI());
		argArray.add(2,String.valueOf(employeeKPI.getTargetKPI()));
		argArray.add(3,convertDateToString(employeeKPI.getTargetDate()));
		argArray.add(4,String.valueOf(employeeKPI.getAchievedKPI()));
		argArray.add(5,convertDateToString(employeeKPI.getAchievedDate()));
		argArray.add(6,convertDateToString(employeeKPI.getStartingDate()));
		argArray.add(7,employeeKPI.getIdEmployee());
		argArray.add(8,employeeKPI.getIdKPI());
		this.run("editEmployeeKPI", argArray);
		//closeConnection();
		argArray = null;
	}

	public String convertDateToString(Date indate)
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