package sm.hris.struts2.base.db;

import java.util.Date;
import java.io.File;
import org.apache.commons.codec.digest.DigestUtils;
import java.sql.Blob;


public class Supplier {

	private String idSupplier; 									
	private String nmSupplier; 				
	private String address; 						
	private String phone; 				
	private String email; 				
	private String fax; 				
	private String npwp; 	
	private String bankAccount; 	
	
	public String getIdSupplier(){
		return idSupplier;
	}
	
	public void setIdSupplier(String idSupplier) {
		this.idSupplier = idSupplier;
	}

	public String getNmSupplier(){
		return nmSupplier;
	}
	
	public void setNmSupplier(String nmSupplier) {
		this.nmSupplier = nmSupplier;
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

	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax(){
		return fax;
	}
	
	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getNpwp(){
		return npwp;
	}
	
	public void setNpwp(String npwp) {
		this.npwp = npwp;
	}


	public String getBankAccount(){
		return bankAccount;
	}
	
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

}
