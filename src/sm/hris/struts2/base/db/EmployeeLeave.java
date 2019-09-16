package sm.hris.struts2.base.db;

public class EmployeeLeave {

	private String idEmployee; 				
	private String idLeaveType; 									
	private Float ceiling; 						
	private Integer periodYear; 				


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

	public Float getCeiling(){
		return ceiling;
	}
	
	public void setCeiling(Float ceiling) {
		this.ceiling = ceiling;
	}

	public Integer getPeriodYear(){
		return periodYear;
	}
	
	public void setPeriodYear(Integer periodYear) {
		this.periodYear = periodYear;
	}

}
