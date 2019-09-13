package sm.hris.struts2.base.db;

import java.util.Date;
import java.io.File;

public class EmployeeKPI {

	private String idEmployee; 									
	private String idKPI; 				
	private String kPIValue; 						


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

	public String getKPIValue(){
		return kPIValue;
	}
	
	public void setKPIValue(String kPIValue) {
		this.kPIValue = kPIValue;
	}

}
