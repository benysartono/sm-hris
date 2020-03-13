package sm.hris.struts2.base.db;

import java.util.Date;
import java.io.File;
import org.apache.commons.codec.digest.DigestUtils;

public class OrderDetailFR {

	private String idOrder; 									
	private String idProduct; 				
	private String nmProduct; 				
	private Float amount; 									
	private String unit; 				
	private Float unitPrice; 									
	private Float subTotal; 									
	private String idOrderDetail; 
	private Float subDiscount; 									
	
	
	public String getIdOrder(){
		return idOrder;
	}
	
	public void setIdOrder(String idOrder) {
		this.idOrder = idOrder;
	}

	public String getIdProduct(){
		return idProduct;
	}
	
	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}

	public String getNmProduct(){
		return nmProduct;
	}
	
	public void setNmProduct(String nmProduct) {
		this.nmProduct = nmProduct;
	}

	public Float getAmount(){
		return amount;
	}
	
	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public String getUnit(){
		return unit;
	}
	
	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Float getUnitPrice(){
		return unitPrice;
	}
	
	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}


	public Float getSubTotal(){
		return subTotal;
	}
	
	public void setSubTotal(Float subTotal) {
		this.subTotal = subTotal;
	}

	public Float getSubDiscount(){
		return subDiscount;
	}
	
	public void setSubDiscount(Float subDiscount) {
		this.subDiscount = subDiscount;
	}

	public String getIdOrderDetail(){
		return idOrderDetail;
	}
	
	public void setIdOrderDetail(String idOrderDetail) {
		this.idOrderDetail = idOrderDetail;
	}

}
