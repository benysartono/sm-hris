package sm.hris.struts2.base.db;

import java.util.ArrayList;
import java.util.Date;
import java.io.File;
import org.apache.commons.codec.digest.DigestUtils;
import sm.hris.struts2.base.db.OrderDetail;

public class Counter {

	private Integer idCounter; 									
	private String tCode; 				
	private Integer rnd; 									
	private Integer bigRnd; 				
	
	
	public Integer getIdCounter(){
		return idCounter;
	}
	
	public void setIdCounter(Integer idCounter) {
		this.idCounter = idCounter;
	}

	public String getTCode(){
		return tCode;
	}
	
	public void setTCode(String tCode) {
		this.tCode = tCode;
	}

	public Integer getRnd(){
		return rnd;
	}
	
	public void setRnd(Integer rnd) {
		this.rnd = rnd;
	}

	public Integer getBigRnd(){
		return bigRnd;
	}
	
	public void setBigRnd(Integer bigRnd) {
		this.bigRnd = bigRnd;
	}

}
