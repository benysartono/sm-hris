package sm.hris.struts2.base.db;

import java.util.Date;

public class EmployeeFR {

	private String idEmployee; 									
	private String name; 				
	private String dob; 			
	private String address; 						
	private String idSite; 				
	private String idDepartment; 				
	private String idUnit; 				
	private String idPosition; 				
	
	public String getIdEmployee(){
		return idEmployee;
	}
	
	public void setIdEmployee(String idEmployee) {
		this.idEmployee = idEmployee;
	}

	public String getName(){
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getDob(){
		return dob;
	}
	
	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress(){
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	public String getIdSite(){
		return idSite;
	}
	
	public void setIdSite(String idSite) {
		this.idSite = idSite;
	}

	public String getIdDepartment(){
		return idDepartment;
	}
	
	public void setIdDepartment(String idDepartment) {
		this.idDepartment = idDepartment;
	}

	public String getIdUnit(){
		return idUnit;
	}
	
	public void setIdUnit(String idUnit) {
		this.idUnit = idUnit;
	}

	public String getIdPosition(){
		return idPosition;
	}
	
	public void setIdPosition(String idPosition) {
		this.idPosition = idPosition;
	}
}
