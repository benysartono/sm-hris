package sm.hris.struts2.base.db;
 
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import sm.hris.struts2.base.db.EmployeeLeaveLodge;
import sm.hris.struts2.base.db.SmBaseDAO;

public class EmployeeLeaveLodgeDAO extends SmBaseDAO{
 
	private EmployeeLeaveLodge employeeLeaveLodge;
	private ArrayList<EmployeeLeaveLodge> employeeLeaveLodges = new ArrayList<EmployeeLeaveLodge>();
    private ArrayList<String> argArray = new ArrayList<String>();
    private String idEmployee;
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");

	public ArrayList<EmployeeLeaveLodge> searchEmployeeLeaveLodge() throws SQLException{
        ResultSet rs = this.runQuery("searchEmployeeLeaveLodge", idEmployee);
            while (rs.next()) {
                employeeLeaveLodge = new EmployeeLeaveLodge();
                employeeLeaveLodge.setIdLeaveLodge(rs.getString("idLeaveLodge"));
                employeeLeaveLodge.setIdEmployee(rs.getString("idEmployee"));
                employeeLeaveLodge.setIdLeaveType(rs.getString("idLeaveType"));
                employeeLeaveLodge.setDaysLodge(rs.getFloat("daysLodge"));
                employeeLeaveLodge.setStartDate(rs.getDate("startDate"));
                employeeLeaveLodge.setEndDate(rs.getDate("endDate"));
                employeeLeaveLodge.setApprovedBy(rs.getString("approvedBy"));
                employeeLeaveLodges.add(employeeLeaveLodge);
            } 
        	if(rs != null){
     		   try {
     		   rs.close();
     		   } catch (SQLException e) {
     		        System.out.println("Exception while closing result set: " + e);
     		   }
     		}
        	//closeConnection();
        	return employeeLeaveLodges;
        
    }

	public void deleteEmployeeLeaveLodges() throws SQLException{
		for(int i=0;i<employeeLeaveLodges.size();i++) {
		    ArrayList<String> argArray = new ArrayList<String>();
			argArray.add(0,employeeLeaveLodges.get(i).getIdEmployee());
			argArray.add(1,employeeLeaveLodges.get(i).getIdLeaveLodge());
			this.run("deleteEmployeeLeaveLodge", argArray);
			//closeConnection();
		}
    }

	public void addEmployeeLeaveLodge() throws SQLException{
		argArray.add(0,employeeLeaveLodge.getIdLeaveLodge());
		argArray.add(1,employeeLeaveLodge.getIdEmployee());
		argArray.add(2,employeeLeaveLodge.getIdLeaveType());
		argArray.add(3,String.valueOf(employeeLeaveLodge.getDaysLodge()));
		String cvtDate = formatter.format(employeeLeaveLodge.getStartDate());
		argArray.add(4,cvtDate);
		cvtDate = formatter.format(employeeLeaveLodge.getEndDate());
		argArray.add(5,cvtDate);
		argArray.add(6,employeeLeaveLodge.getApprovedBy());
		this.run("addEmployeeLeaveLodge", argArray);
		//closeConnection();
		argArray = null;
    }
	
	public void editEmployeeLeave() throws SQLException{
		argArray.add(0,employeeLeaveLodge.getIdLeaveLodge());
		argArray.add(1,employeeLeaveLodge.getIdEmployee());
		argArray.add(2,employeeLeaveLodge.getIdLeaveType());
		argArray.add(3,String.valueOf(employeeLeaveLodge.getDaysLodge()));
		String cvtDate = formatter.format(employeeLeaveLodge.getStartDate());
		argArray.add(4,cvtDate);
		cvtDate = formatter.format(employeeLeaveLodge.getEndDate());
		argArray.add(5,cvtDate);
		argArray.add(6,employeeLeaveLodge.getApprovedBy());
		argArray.add(7,employeeLeaveLodge.getIdLeaveLodge());
		argArray.add(8,employeeLeaveLodge.getIdEmployee());
		this.run("editEmployeeLeaveLodge", argArray);
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

	public EmployeeLeaveLodge getEmployeeLeaveLodge(){
		return employeeLeaveLodge;
	}
	
	public void setEmployeeLeaveLodge(EmployeeLeaveLodge employeeLeaveLodge) {
		this.employeeLeaveLodge = employeeLeaveLodge;
	}


	public ArrayList<EmployeeLeaveLodge> getEmployeeLeaveLodges(){
		return employeeLeaveLodges;
	}
	
	public void setEmployeeLeaveLodges(ArrayList<EmployeeLeaveLodge> employeeLeaveLodges) {
		this.employeeLeaveLodges = employeeLeaveLodges;
	}
	
	public ArrayList<String> getArgArray(){
		return argArray;
	}
	
	public void setArgArray(ArrayList<String> argArray){
		this.argArray = argArray;
	}

}