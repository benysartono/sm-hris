package sm.hris.struts2.base.db;

import java.sql.Timestamp;

public class Actuator {

	private String idActuator; 									
	private Integer idRelay; 		
	private Integer command;
	private String idSite;
	private Timestamp updatedTime;
	private String updatedBy;
	private Timestamp createdTime;
	private String createdBy;
	private String idActuatorIdRelay;
	private String idActuatorIdRelayCmd;
	
	public String getIdActuator(){
		return idActuator;
	}
	
	public void setIdActuator(String idActuator) {
		this.idActuator = idActuator;
	}

	public String getIdSite(){
		return idSite;
	}
	
	public void setIdSite(String idSite) {
		this.idSite = idSite;
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

	public Timestamp getUpdatedTime(){
		return updatedTime;
	}
	
	public void setUpdatedTime(Timestamp updatedTime){
		this.updatedTime = updatedTime;
	}

	public Timestamp getCreatedTime(){
		return createdTime;
	}
	
	public void setCreatedTime(Timestamp createdTime){
		this.createdTime = createdTime;
	}

	public String getIdActuatorIdRelay(){
		return this.idActuator + "," + this.idRelay;
	}
	
	public void setIdActuatorIdRelay(String idActuatorIdRelay) {
		this.idActuatorIdRelay = idActuatorIdRelay;
	}

	public String getIdActuatorIdRelayCmd(){
		return this.idActuator + "," + this.idRelay;
	}
	
	public void setIdActuatorIdRelayCmd(String idActuatorIdRelay) {
		this.idActuatorIdRelay = idActuatorIdRelay;
	}

}
