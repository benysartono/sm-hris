package sm.hris.struts2.base.db;

import java.util.ArrayList;
import java.util.Date;
import java.io.File;
import org.apache.commons.codec.digest.DigestUtils;
import sm.hris.struts2.base.db.OrderDetail;

public class Discount {

	private String idDiscount;
	private String idProduct; 									
	private Integer discount; 				
	private Date startTime; 									
	private Date endTime; 									
	
	
	public String getIdDiscount(){
		return idDiscount;
	}
	
	public void setIdDiscount(String idDiscount) {
		this.idDiscount = idDiscount;
	}

	public String getIdProduct(){
		return idProduct;
	}
	
	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}

	public Integer getDiscount(){
		return discount;
	}
	
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Date getStartTime(){
		return startTime;
	}
	
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime(){
		return endTime;
	}
	
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

}
