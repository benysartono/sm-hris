package sm.hris.struts2.base.db;

import java.sql.Timestamp;


public class Trigger {

	private String idCondition;
	private String idActuator; 									
	private Integer idRelay; 		
	private Integer command;
	private String idSite; 									
	
	private String updatedBy;
	private String createdBy;
	private String updatedTime;
	private String createdTime;
	private String idConditionidActuatorIdRelayIdSite;
	
	public String getIdCondition(){
		return idCondition;
	}
	
	public void setIdCondition(String idCondition) {
		this.idCondition = idCondition;
	}

	public String getIdActuator(){
		return idActuator;
	}
	
	public void setIdActuator(String idActuator) {
		this.idActuator = idActuator;
	}

	public Integer getIdRelay(){
		return idRelay;
	}
	
	public void setIdRelay(Integer idRelay) {
		this.idRelay = idRelay;
	}

	public Integer getCommand(){
		return command;
	}
	
	public void setCommand(Integer command) {
		this.command = command;
	}

	public String getIdSite(){
		return idSite;
	}
	
	public void setIdSite(String idSite) {
		this.idSite = idSite;
	}

	public String getUpdatedBy(){
		return updatedBy;
	}
	
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getCreatedBy(){
		return createdBy;
	}
	
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedTime(){
		return updatedTime;
	}
	
	public void setUpdatedTime(String updatedTime) {
		this.updatedTime = updatedTime;
	}

	public String getCreatedTime(){
		return createdTime;
	}
	
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public String getIdConditionidActuatorIdRelayIdSite(){
		return this.idCondition + "," + this.idActuator + "," + this.idRelay + "," + this.idSite;
	}
	
	public void setIdConditionidActuatorIdRelayIdSite(String idConditionidActuatorIdRelayIdSite) {
		this.idConditionidActuatorIdRelayIdSite = idConditionidActuatorIdRelayIdSite;
	}


}
