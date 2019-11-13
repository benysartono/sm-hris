package sm.hris.struts2.base.db;

import java.sql.Date;

public class EmployeeLeaveLodge {

	private String idEmployee; 				
	private String idLeaveLodge;
	private String idLeaveType;
	private Float daysLodge;
	private Date startDate;
	private Date endDate;
	private String approvedBy;

	public String getIdEmployee(){
		return idEmployee;
	}
	
	public void setIdEmployee(String idEmployee) {
		this.idEmployee = idEmployee;
	}

	public String getIdLeaveType(){
		return idLeaveType;
	}
	
	public void setIdLeaveType(String idLeaveType) {
		this.idLeaveType = idLeaveType;
	}

	public String getIdLeaveLodge(){
		return idLeaveLodge;
	}
	
	public void setIdLeaveLodge(String idLeaveLodge) {
		this.idLeaveLodge = idLeaveLodge;
	}

	public Float getDaysLodge(){
		return daysLodge;
	}
	
	public void setDaysLodge(Float daysLodge) {
		this.daysLodge = daysLodge;
	}

	public Date getStartDate(){
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate(){
		return endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getApprovedBy(){
		return approvedBy;
	}
	
	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

}
