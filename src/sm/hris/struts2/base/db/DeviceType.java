package sm.hris.struts2.base.db;


public class DeviceType {

	private String idDeviceType;
	private String nmDeviceType;
	private String updatedTime;
	
	public String getIdDeviceType(){
		return idDeviceType;
	}
	
	public void setIdDeviceType(String idDeviceType) {
		this.idDeviceType = idDeviceType;
	}

	public String getNmDeviceType(){
		return nmDeviceType;
	}
	
	public void setNmDeviceType(String nmDeviceType) {
		this.nmDeviceType = nmDeviceType;
	}


	public String getUpdatedTime(){
		return updatedTime;
	}
	
	public void setUpdatedTime(String updatedTime) {
		this.updatedTime = updatedTime;
	}

}
