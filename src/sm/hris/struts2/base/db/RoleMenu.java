package sm.hris.struts2.base.db;


public class RoleMenu {

	private String idRole; 									
	private String idMenu; 
	private String description;
	private String href;
	
	
	public String getIdRole() {
		return idRole;
	}
	
	public void setIdRole(String idRole) {
		this.idRole = idRole;
	}

	public String getIdMenu() {
		return idMenu;
	}
	
	public void setIdMenu(String idMenu) {
		this.idMenu = idMenu;
	}

	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public String getHref() {
		return href;
	}
	
	public void setHref(String href) {
		this.href = href;
	}
	

}
