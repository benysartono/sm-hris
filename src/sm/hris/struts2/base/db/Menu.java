package sm.hris.struts2.base.db;


public class Menu {

	private String idMenu; 									
	private String description; 		
	private String href;
	private String hasChildren;
	private String lvl;
	private String ord;
	private String parent;
	
	public String getIdMenu(){
		return idMenu;
	}
	
	public void setIdMenu(String idMenu) {
		this.idMenu = idMenu;
	}

	public String getDescription(){
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public String getHref(){
		return href;
	}
	
	public void setHref(String href) {
		this.href = href;
	}

	public String getHasChildren(){
		return hasChildren;
	}
	
	public void setHasChildren(String hasChildren) {
		this.hasChildren = hasChildren;
	}

	public String getLvl(){
		return lvl;
	}
	
	public void setLvl(String lvl) {
		this.lvl = lvl;
	}

	public String getOrd(){
		return ord;
	}
	
	public void setOrd(String ord) {
		this.ord = ord;
	}

	public String getParent(){
		return parent;
	}
	
	public void setParent(String parent) {
		this.parent = parent;
	}

}
