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
                employeeKPI.setKPIValue(rs.getString("KPIValue"));
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
		    ArrayList<String> argArray = new ArrayList<String>();
			argArray.add(0,employeeKPIs.get(i).getIdEmployee());
			argArray.add(1,employeeKPIs.get(i).getIdKPI());
			this.run("deleteEmployeeKPI", argArray);
			//closeConnection();
		}
    }

	public void addEmployeeKPI(EmployeeKPI employeeKPI) throws SQLException{
		argArray.add(0, employeeKPI.getIdEmployee());
		argArray.add(1, employeeKPI.getIdKPI());
		argArray.add(2, employeeKPI.getKPIValue());
		this.run("addEmployeeKPI", argArray);
		//closeConnection();
		argArray = null;
    }
	
	public void editEmployeeKPI(EmployeeKPI employeeKPI) throws SQLException{
			argArray.add(0, employeeKPI.getIdEmployee());
			argArray.add(1, employeeKPI.getIdKPI());
			argArray.add(2, employeeKPI.getKPIValue());
			argArray.add(6, employeeKPI.getIdEmployee());
			argArray.add(5, employeeKPI.getIdKPI());
			this.run("editEmployeeKPI", argArray);
			//closeConnection();
			argArray = null;
	}

}