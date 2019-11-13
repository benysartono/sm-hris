package sm.hris.struts2.base.db;

public class Category {

	private String idCategory; 									
	private String description; 				
	
	
	public String getIdCategory(){
		return idCategory;
	}
	
	public void setIdCategory(String idCategory) {
		this.idCategory = idCategory;
	}

	public String getDescription(){
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

}
