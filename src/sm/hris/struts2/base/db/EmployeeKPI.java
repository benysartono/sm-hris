package sm.hris.struts2.base.db;

import java.util.Date;
import java.io.File;

public class EmployeeKPI {

	private String idEmployee; 									
	private String idKPI; 				
	private Float targetKPI; 						
	private Date targetDate;
	private Float achievedKPI;
	private Date achievedDate; 						
	private Date startingDate; 						

	public String getIdKPI(){
		return idKPI;
	}
	
	public void setIdKPI(String idKPI) {
		this.idKPI = idKPI;
	}

	public String getIdEmployee(){
		return idEmployee;
	}
	
	public void setIdEmployee(String idEmployee) {
		this.idEmployee = idEmployee;
	}

	public Float getTargetKPI(){
		return targetKPI;
	}
	
	public void setTargetKPI(Float targetKPI) {
		this.targetKPI = targetKPI;
	}

	public Date getTargetDate(){
		return targetDate;
	}
	
	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
	
	public Float getAchievedKPI(){
		return achievedKPI;
	}
	
	public void setAchievedKPI(Float achievedKPI) {
		this.achievedKPI = achievedKPI;
	}

	public Date getAchievedDate(){
		return achievedDate;
	}
	
	public void setAchievedDate(Date achievedDate) {
		this.achievedDate = achievedDate;
	}
	
	public Date getStartingDate(){
		return startingDate;
	}
	
	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}
}
