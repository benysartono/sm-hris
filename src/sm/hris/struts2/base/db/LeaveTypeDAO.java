package sm.hris.struts2.base.db;
 
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import sm.hris.struts2.base.db.LeaveType;
import sm.hris.struts2.base.db.SmBaseDAO;

public class LeaveTypeDAO extends SmBaseDAO{
 
	private LeaveType leaveType = new LeaveType();
	private ArrayList<LeaveType> leaveTypes = new ArrayList<LeaveType>();
    private String idLeaveType;
    private ArrayList<String> argArray = new ArrayList<String>();
    private ResultSet rs;

	public ArrayList<LeaveType> searchLeaveTypeByDescriptionLike() throws SQLException{
        if ((argArray.isEmpty())||(argArray.equals(null))||(argArray.equals(""))) 
        	rs = this.runQuery("searchLeaveType");
        else
    		rs = this.runQuery("searchLeaveTypeByDescriptionLike",argArray.get(0));
 
        while (rs.next()) {
          leaveType = new LeaveType();
          leaveType.setIdLeaveType(rs.getString("idLeaveType"));
          leaveType.setDescription(rs.getString("description"));
          leaveTypes.add(leaveType);
        } 
        if(rs != null){
      	   try {
      		   rs.close();
      		   } catch (SQLException e) {
      		        System.out.println("Exception while closing result set: " + e);
      		   }
      	}
        closeConnection();
        return leaveTypes;
    }

	public ArrayList<LeaveType> searchLeaveType() throws SQLException{
        if ((idLeaveType.isEmpty())||(idLeaveType.equals(null))||(idLeaveType.equals(""))) 
        	rs = this.runQuery("searchLeaveType");
        else
    		rs = this.runQuery("searchLeaveTypeByIdLeaveType",idLeaveType);
 
        while (rs.next()) {
          leaveType = new LeaveType();
          leaveType.setIdLeaveType(rs.getString("idLeaveType"));
          leaveType.setDescription(rs.getString("description"));
          leaveTypes.add(leaveType);
        } 
        if(rs != null){
      	   try {
      		   rs.close();
      		   } catch (SQLException e) {
      		        System.out.println("Exception while closing result set: " + e);
      		   }
      	}
        closeConnection();
        return leaveTypes;
    }
	
	public void deleteLeaveType() throws SQLException{
		for(int i=0;i<argArray.size();i++) {
			this.run("deleteLeaveType", argArray.get(i));
		}
        closeConnection();
    }

	public void addLeaveType() throws SQLException{
		argArray.add(0, leaveType.getIdLeaveType());
		argArray.add(1, leaveType.getDescription());
		this.run("addLeaveType", argArray);
       	closeConnection();
    }

	public void editLeaveType() throws SQLException{
		argArray.add(0, leaveType.getIdLeaveType());
		argArray.add(1, leaveType.getDescription());
		argArray.add(3, leaveType.getIdLeaveType());
		this.run("editLeaveType", argArray);
    	closeConnection();
	}
	
	//Getter Setter//
	public LeaveType getLeaveType(){
		return leaveType;
	} 

	public void setLeaveType(LeaveType leaveType) {
		this.leaveType = leaveType;
	}

	public ArrayList<LeaveType> getLeaveTypes() {
		return leaveTypes;
	}
	
	public void setLeaveTypes(ArrayList<LeaveType> leaveTypes) {
		this.leaveTypes = leaveTypes;
	}
	
	public String getIdLeaveType(){
		return idLeaveType;
	}

	public void setIdLeaveType(String idLeaveType) {
		this.idLeaveType = idLeaveType;
	}
	
	public ArrayList<String> getArgArray(){
		return argArray;
	}
	
	public void setArgArray (ArrayList<String> argArray){
		this.argArray = argArray;
	}
	

}