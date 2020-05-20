package sm.hris.struts2.base.db;


public class Condition {

	private String idCondition;
	private String idSite;
	private String idDevice;
	private String operand;
	private Float value;
	private String idValueType;
	private String nmValueType;
	private String idConditionIdSiteIdDevice;
	
	
	public String getIdCondition(){
		return idCondition;
	}
	
	public void setIdCondition(String idCondition) {
		this.idCondition = idCondition;
	}

	public String getIdSite(){
		return idSite;
	}
	
	public void setIdSite(String idSite) {
		this.idSite = idSite;
	}

	public String getIdDevice(){
		return idDevice;
	}
	
	public void setIdDevice(String idDevice) {
		this.idDevice = idDevice;
	}

	public String getOperand(){
		return operand;
	}
	
	public void setOperand(String operand) {
		this.operand = operand;
	}

	public Float getValue(){
		return value;
	}
	
	public void setValue(Float value) {
		this.value = value;
	}

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

	public String getIdConditionIdSiteIdDevice(){
		return idCondition + "," + idSite + "," + idDevice;
	}
	
	public void setIdConditionIdSiteIdDevice(String idConditionIdSiteIdDevice) {
		this.idConditionIdSiteIdDevice = idConditionIdSiteIdDevice;
	}

}
