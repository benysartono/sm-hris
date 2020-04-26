package sm.hris.struts2.base.db;


public class Sensor {

	private String idSensor;
	private String idSensorType;
	private String idSite;
	private String value;
	private String updatedTime;
	
	public String getIdSensor(){
		return idSensor;
	}
	
	public void setIdSensor(String idSensor) {
		this.idSensor = idSensor;
	}

	public String getIdSensorType(){
		return idSensorType;
	}
	
	public void setIdSensorType(String idSensorType) {
		this.idSensorType = idSensorType;
	}

	public String getIdSite(){
		return idSite;
	}
	
	public void setIdSite(String idSite) {
		this.idSite = idSite;
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
