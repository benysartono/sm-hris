package sm.hris.struts2.base.db;
 
import java.util.ArrayList;
//import java.util.List;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import sm.hris.struts2.base.db.EmployeeLeave;
import sm.hris.struts2.base.db.SmBaseDAO;

public class EmployeeLeaveDAO extends SmBaseDAO{
 
	private EmployeeLeave employeeLeave;
	private ArrayList<EmployeeLeave> employeeLeaves = new ArrayList<EmployeeLeave>();
    private ArrayList<String> argArray = new ArrayList<String>();
    private String idEmployee;

	public ArrayList<EmployeeLeave> searchEmployeeLeave() throws SQLException{
        ResultSet rs = this.runQuery("searchEmployeeLeave", idEmployee);
            while (rs.next()) {
                employeeLeave = new EmployeeLeave();
                employeeLeave.setIdEmployee(rs.getString("idEmployee"));
                employeeLeave.setIdLeaveType(rs.getString("idLeaveType"));
                employeeLeave.setCeiling(rs.getFloat("ceiling"));
                employeeLeave.setPeriodYear(rs.getInt("periodYear"));
                employeeLeaves.add(employeeLeave);
            } 
        	if(rs != null){
     		   try {
     		   rs.close();
     		   } catch (SQLException e) {
     		        System.out.println("Exception while closing result set: " + e);
     		   }
     		}
        	//closeConnection();
        	return employeeLeaves;
        
    }

	public void deleteEmployeeLeave() throws SQLException{
		for(int i=0;i<employeeLeaves.size();i++) {
		    ArrayList<String> argArray = new ArrayList<String>();
			argArray.add(0,employeeLeaves.get(i).getIdEmployee());
			argArray.add(1,employeeLeaves.get(i).getIdLeaveType());
			argArray.add(2,String.valueOf(employeeLeaves.get(i).getCeiling()));
			argArray.add(3,String.valueOf(employeeLeaves.get(i).getPeriodYear()));
			this.run("deleteEmployeeLeave", argArray);
			//closeConnection();
		}
    }

	public void addEmployeeLeave() throws SQLException{
		argArray.add(0,employeeLeave.getIdEmployee());
		argArray.add(1,employeeLeave.getIdLeaveType());
		argArray.add(2,String.valueOf(employeeLeave.getCeiling()));
		argArray.add(3,String.valueOf(employeeLeave.getPeriodYear()));
		this.run("addEmployeeLeave", argArray);
		//closeConnection();
		argArray = null;
    }
	
	public void editEmployeeLeave() throws SQLException{
		argArray.add(0,employeeLeave.getIdEmployee());
		argArray.add(1,employeeLeave.getIdLeaveType());
		argArray.add(2,String.valueOf(employeeLeave.getCeiling()));
		argArray.add(3,String.valueOf(employeeLeave.getPeriodYear()));
		argArray.add(4,employeeLeave.getIdEmployee());
		argArray.add(5,employeeLeave.getIdLeaveType());
		this.run("editEmployeeLeave", argArray);
		//closeConnection();
		argArray = null;
	}

	
	//Getter Setter
	public String getIdEmployee(){
		return idEmployee;
	}
	
	public void setIdEmployee(String idEmployee) {
		this.idEmployee = idEmployee;
	}

	public ArrayList<EmployeeLeave> getEmployeeLeaves(){
		return employeeLeaves;
	}
	
	public void setEmployeeLeaves (ArrayList<EmployeeLeave> employeeLeaves){
		this.employeeLeaves = employeeLeaves;
	}
	
	public ArrayList<String> getArgArray() {
		return argArray;
	} 

	public void setArgArray(ArrayList<String> argArray){
		this.argArray = argArray;
	}
}