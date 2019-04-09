package sm.hris.struts2.base.db;

import java.util.ArrayList;
import java.util.Date;
import java.io.File;
import org.apache.commons.codec.digest.DigestUtils;
import sm.hris.struts2.base.db.OrderItem;

public class Order {

	private String idPO; 									
	private String idBuyer; 				
	private String idSpec; 									
	private String idProduction; 				
	private Date date; 									
	private String terms; 	
	private String idShipVia; 									
	private Date shipDate; 	
	private String FOB;
	private Date inWarehouse;
	private Date cancelation;
	private ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();
	
	
	public String getIdPO(){
		return idPO;
	}
	
	public void setIdPO(String idPO) {
		this.idPO = idPO;
	}

	public String getIdBuyer(){
		return idBuyer;
	}
	
	public void setIdBuyer(String idBuyer) {
		this.idBuyer = idBuyer;
	}

	public String getIdSpec(){
		return idSpec;
	}
	
	public void setIdSpec(String idSpec) {
		this.idSpec = idSpec;
	}

	public String getIdProduction(){
		return idProduction;
	}
	
	public void setIdProduction(String idProduction) {
		this.idProduction = idProduction;
	}

	public Date getDate(){
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}

	public String getTerms(){
		return terms;
	}
	
	public void setTerms(String terms) {
		this.terms = terms;
	}
	
	public String getIdShipVia(){
		return idShipVia;
	}
	
	public void setIdShipVia(String idShipVia) {
		this.idShipVia = idShipVia;
	}

	public Date getShipDate(){
		return shipDate;
	}
	
	public void setShipDate(Date shipDate) {
		this.shipDate = shipDate;
	}

	public String getFOB(){
		return FOB;
	}
	
	public void setFOB(String FOB) {
		this.FOB = FOB;
	}

	public Date getInWarehouse(){
		return inWarehouse;
	}
	
	public void setInWarehouse(Date inWarehouse) {
		this.inWarehouse = inWarehouse;
	}
	
	public Date getCancelation(){
		return cancelation;
	}
	
	public void setCancelation(Date cancelation) {
		this.cancelation = cancelation;
	}
	
	public ArrayList<OrderItem> getOrderItems(){
		return orderItems;
	} 
	
	public void setOrderItems(ArrayList<OrderItem> orderItems){
		this.orderItems = orderItems;
	}
}
