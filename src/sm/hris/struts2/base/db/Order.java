package sm.hris.struts2.base.db;

import java.util.ArrayList;
import java.util.Date;
import java.io.File;
import org.apache.commons.codec.digest.DigestUtils;
import sm.hris.struts2.base.db.OrderDetail;

public class Order {

	private String idOrder; 									
	private Float total; 				
	private Float totalDiscount; 									
	private Float vat; 				
	private Float cash; 									
	private Float changes; 	
	private String idPaymentMethod; 									
	private String paymentRemark; 	
	private Date orderDate;
	private ArrayList<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
	
	
	public String getIdOrder(){
		return idOrder;
	}
	
	public void setIdOrder(String idOrder) {
		this.idOrder = idOrder;
	}

	public Float getTotal(){
		return total;
	}
	
	public void setTotal(Float total) {
		this.total = total;
	}

	public Float getTotalDiscount(){
		return totalDiscount;
	}
	
	public void setTotalDiscount(Float totalDiscount) {
		this.totalDiscount = totalDiscount;
	}

	public Float getVat(){
		return vat;
	}
	
	public void setVat(Float vat) {
		this.vat = vat;
	}
	
	public Float getCash(){
		return cash;
	}
	
	public void setCash(Float cash) {
		this.cash = cash;
	}
	
	public Float getChanges(){
		return changes;
	}
	
	public void setChanges(Float changes) {
		this.changes = changes;
	}
	
	public String getIdPaymentMethod(){
		return idPaymentMethod;
	}
	
	public void setIdPaymentMethod(String idPaymentMethod) {
		this.idPaymentMethod = idPaymentMethod;
	}

	public String getPaymentRemark(){
		return paymentRemark;
	}
	
	public void setPaymentRemark(String paymentRemark) {
		this.paymentRemark = paymentRemark;
	}

	public Date getOrderDate(){
		return orderDate;
	}
	
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public ArrayList<OrderDetail> getOrderDetails(){
		return orderDetails;
	} 
	
	public void setOrderDetails(ArrayList<OrderDetail> orderDetails){
		this.orderDetails = orderDetails;
	}
}
