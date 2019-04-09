package sm.hris.struts2.base.db;


public class Role {

	private Integer idRole; 									
	private String roleName; 				
	private String description; 									
	
	
	public Integer getIdRole() {
		return idRole;
	}
	
	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}

	public String getRoleName(){
		return roleName;
	}
	
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription(){
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

}
