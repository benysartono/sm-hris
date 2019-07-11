package sm.hris.struts2.base.db;


public class Department {

	private String idDepartment; 									
	private String name; 				
	private String description; 
	private String parentDepartment;
	
	public String getIdDepartment(){
		return idDepartment;
	}
	
	public void setIdDepartment(String idDepartment) {
		this.idDepartment = idDepartment;
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

	public String getParentDepartment(){
		return parentDepartment;
	}
	
	public void setParentDepartment(String parentDepartment) {
		this.parentDepartment = parentDepartment;
	}

}
