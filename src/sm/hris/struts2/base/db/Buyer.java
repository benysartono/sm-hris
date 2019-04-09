package sm.hris.struts2.base.db;

import java.util.ArrayList;
import java.util.Date;
import java.io.File;
import org.apache.commons.codec.digest.DigestUtils;
import sm.hris.struts2.base.db.BuyerSpec;

public class Buyer {

	private String idBuyer; 									
	private String address; 				
	private String phone; 									
	private String fax; 				
	private String email; 	
	private String shippingAddress; 									
	private String buyerName;
	private ArrayList<BuyerSpec> buyerSpecs;
	
	
	public String getIdBuyer(){
		return idBuyer;
	}
	
	public void setIdBuyer(String idBuyer) {
		this.idBuyer = idBuyer;
	}

	public String getAddress(){
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone(){
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax(){
		return fax;
	}
	
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}


	public String getShippingAddress(){
		return shippingAddress;
	}
	
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getBuyerName(){
		return buyerName;
	}
	
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	
	public ArrayList<BuyerSpec> getBuyerSpecs(){
		return buyerSpecs;
	}
	
	public void setBuyerSpecs(ArrayList<BuyerSpec> buyerSpecs) {
		this.buyerSpecs = buyerSpecs;
	}
	
}
