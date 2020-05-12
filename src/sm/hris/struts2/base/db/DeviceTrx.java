package sm.hris.struts2.base.db;


public class DeviceTrx {

	private String idDevice;
	private String idValueType;
	private String idSite;
	private String nmSite;
	private String nmValueType;
	private String value;
	private String updatedTime;
	
	public String getIdDevice(){
		return idDevice;
	}
	
	public void setIdDevice(String idDevice) {
		this.idDevice = idDevice;
	}

	public String getIdValueType(){
		return idValueType;
	}
	
	public void setIdValueType(String idValueType) {
		this.idValueType = idValueType;
	}

	public String getIdSite(){
		return idSite;
	}
	
	public void setIdSite(String idSite) {
		this.idSite = idSite;
	}

	public String getNmSite(){
		return nmSite;
	}
	
	public void setNmSite(String nmSite) {
		this.nmSite = nmSite;
	}

	public String getNmValueType(){
		return nmValueType;
	}
	
	public void setNmValueType(String nmValueType) {
		this.nmValueType = nmValueType;
	}

	public String getValue(){
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}


	public String getUpdatedTime(){
		return updatedTime;
	}
	
	public void setUpdatedTime(String updatedTime) {
		this.updatedTime = updatedTime;
	}

}
