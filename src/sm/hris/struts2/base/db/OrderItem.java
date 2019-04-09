package sm.hris.struts2.base.db;

import java.util.Date;
import java.io.File;
import org.apache.commons.codec.digest.DigestUtils;

public class OrderItem {

	private String idPO; 									
	private String idColor; 				
	private Integer qty; 									
	private String description; 				
	private Integer unitPrice; 									
	private Integer extendedPrice; 									
	private Integer idItem; 				
	
	public String getIdPO(){
		return idPO;
	}
	
	public void setIdPO(String idPO) {
		this.idPO = idPO;
	}

	public Integer getIdItem(){
		return idItem;
	}
	
	public void setIdItem(Integer idItem) {
		this.idItem = idItem;
	}

	public Integer getQty(){
		return qty;
	}
	
	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public String getDescription(){
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public String getIdColor(){
		return idColor;
	}
	
	public void setIdColor(String idColor) {
		this.idColor = idColor;
	}

	public Integer getUnitPrice(){
		return unitPrice;
	}
	
	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getExtendedPrice(){
		return extendedPrice;
	}
	
	public void setExtendedPrice(Integer extendedPrice) {
		this.extendedPrice = extendedPrice;
	}

	
}
