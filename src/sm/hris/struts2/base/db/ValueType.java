package sm.hris.struts2.base.db;


public class ValueType {

	private String idValueType; 									
	private String nmValueType; 		
	private String updatedTime;
	
	public String getIdValueType(){
		return idValueType;
	}
	
	public void setIdValueType(String idValueType) {
		this.idValueType = idValueType;
	}

	public String getNmValueType(){
		return nmValueType;
	}
	
	public void setNmValueType(String nmValueType) {
		this.nmValueType = nmValueType;
	}


	public String getUpdatedTime(){
		return updatedTime;
	}
	
	public void setUpdatedTime(String updatedTime) {
		this.updatedTime = updatedTime;
	}

}
