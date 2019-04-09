package sm.hris.struts2.base.db;

import java.util.Date;
import java.io.File;

public class EmployeeEdu {

	private String idEmployeeEdu; 									
	private String idEmployee; 				
	private String schoolName; 						
	private String institution; 				
	private String description; 				
	private Date yearFrom; 				
	private Date yearTo; 				


	public String getIdEmployeeEdu(){
		return idEmployeeEdu;
	}
	
	public void setIdEmployeeEdu(String idEmployeeEdu) {
		this.idEmployeeEdu = idEmployeeEdu;
	}

	public String getIdEmployee(){
		return idEmployee;
	}
	
	public void setIdEmployee(String idEmployee) {
		this.idEmployee = idEmployee;
	}

	public String getSchoolName(){
		return schoolName;
	}
	
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getInstitution(){
		return institution;
	}
	
	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getDescription(){
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public Date getYearFrom(){
		return yearFrom;
	}
	
	public void setYearFrom(Date yearFrom) {
		this.yearFrom = yearFrom;
	}

	public Date getYearTo(){
		return yearTo;
	}
	
	public void setYearTo(Date yearTo) {
		this.yearTo = yearTo;
	}

}
