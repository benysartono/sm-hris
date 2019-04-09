package sm.hris.struts2.base.db;


public class Unit {

	private String idDepartment; 									
	private String idUnit; 									
	private String name; 				
	private String description; 			
	
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

	public String getName(){
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}


	public String getDescription(){
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
