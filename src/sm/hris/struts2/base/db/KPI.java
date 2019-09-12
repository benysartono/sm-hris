package sm.hris.struts2.base.db;


public class KPI {

	private String idKPI; 									
	private String description; 			
	private String unitMeasure;
	
	public String getIdKPI(){
		return idKPI;
	}
	
	public void setIdKPI(String idKPI) {
		this.idKPI = idKPI;
	}

	public String getDescription(){
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public String getUnitMeasure(){
		return unitMeasure;
	}
	
	public void setUnitMeasure(String unitMeasure) {
		this.unitMeasure = unitMeasure;
	}

}
