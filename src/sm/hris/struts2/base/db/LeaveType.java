package sm.hris.struts2.base.db;


public class LeaveType {

	private String idLeaveType; 									
	private String description; 			
	
	public String getIdLeaveType(){
		return idLeaveType;
	}
	
	public void setIdLeaveType(String idLeaveType) {
		this.idLeaveType = idLeaveType;
	}

	public String getDescription(){
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

}
