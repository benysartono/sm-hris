package sm.hris.struts2.base.db;


public class Device {

	private String idDevice;
	private String idDeviceType;
	private String idSite;
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


	public String getUpdatedTime(){
		return updatedTime;
	}
	
	public void setUpdatedTime(String updatedTime) {
		this.updatedTime = updatedTime;
	}

}
