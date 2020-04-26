package sm.hris.struts2.base.db;


public class Site {

	private String idSite; 									
	private String description; 		
	private String nmSite;
	private String location;
	
	public String getIdSite(){
		return idSite;
	}
	
	public void setIdSite(String idSite) {
		this.idSite = idSite;
	}

	public String getDescription(){
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public String getNmSite(){
		return nmSite;
	}
	
	public void setNmSite(String nmSite) {
		this.nmSite = nmSite;
	}

	public String getLocation(){
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}

}
