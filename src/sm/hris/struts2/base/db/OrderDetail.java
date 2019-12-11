package sm.hris.struts2.base.db;

import java.util.Date;
import java.io.File;
import org.apache.commons.codec.digest.DigestUtils;

public class OrderDetail {

	private String idOrder; 									
	private String idProduct; 				
	private Float amount; 									
	private String unit; 				
	private Float unitPrice; 									
	private Float subTotal; 									
	private String idOrderDetail; 				
	
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

	public String getIdOrderDetail(){
		return idOrderDetail;
	}
	
	public void setIdOrderDetail(String idOrderDetail) {
		this.idOrderDetail = idOrderDetail;
	}

}
