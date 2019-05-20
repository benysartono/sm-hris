package sm.hris.struts2.base.db;

import java.util.Date;
import java.io.File;
import org.apache.commons.codec.digest.DigestUtils;
import java.sql.Blob;


public class Employee {

	private String idEmployee; 									
	private String name; 				
	private Date dob; 			
	private String address; 						
	private String idSite; 				
	private String idDepartment; 				
	private String idUnit; 				
	private String idPosition; 	
	private File img;
	private String imgURL;
	private String password;
	
	public String getIdEmployee(){
		return idEmployee;
	}
	
	public void setIdEmployee(String idEmployee) {
		this.idEmployee = idEmployee;
	}

	public String getName(){
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Date getDob(){
		return dob;
	}
	
	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress(){
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	public String getIdSite(){
		return idSite;
	}
	
	public void setIdSite(String idSite) {
		this.idSite = idSite;
	}

	public String getIdDepartment(){
		return idDepartment;
	}
	
	public void setIdDepartment(String idDepartment) {
		this.idDepartment = idDepartment;
	}

	public String getIdUnit(){
		return idUnit;
	}
	
	public void setIdUnit(String idUnit) {
		this.idUnit = idUnit;
	}

	public String getIdPosition(){
		return idPosition;
	}
	
	public void setIdPosition(String idPosition) {
		this.idPosition = idPosition;
	}

	public File getImg(){
		return img;
	}
	
	public void setImg(File img) {
		this.img = img;
	}

	public String getImgURL(){
		return imgURL;
	}
	
	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}

	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password) {
		this.password = DigestUtils.md5Hex(password).toUpperCase();
	}
}
