package sm.hris.struts2.base.db;


public class DeviceTrx {

	private String idDevice;
	private String idDeviceType;
	private String idSite;
	private String nmSite;
	private String nmDeviceType;
	private String value;
	private String updatedTime;
	
	public String getIdDevice(){
		return idDevice;
	}
	
	public void setIdDevice(String idDevice) {
		this.idDevice = idDevice;
	}

	public String getIdDeviceType(){
		return idDeviceType;
	}
	
	public void setIdDeviceType(String idDeviceType) {
		this.idDeviceType = idDeviceType;
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

	public String getNmDeviceType(){
		return nmDeviceType;
	}
	
	public void setNmDeviceType(String nmDeviceType) {
		this.nmDeviceType = nmDeviceType;
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
