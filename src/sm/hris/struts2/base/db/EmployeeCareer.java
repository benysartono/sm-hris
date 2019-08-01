package sm.hris.struts2.base.db;

import java.util.Date;
import java.io.File;

public class EmployeeCareer {

	private String idCareer; 									
	private String idEmployee; 				
	private String company; 						
	private String lastPosition; 				
	private String description; 				
	private Date yearFrom; 				
	private Date yearTo; 
	private File img;
	private String imgPath;


	public String getIdCareer(){
		return idCareer;
	}
	
	public void setIdCareer(String idCareer) {
		this.idCareer = idCareer;
	}

	public String getIdEmployee(){
		return idEmployee;
	}
	
	public void setIdEmployee(String idEmployee) {
		this.idEmployee = idEmployee;
	}

	public String getCompany(){
		return company;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}

	public String getLastPosition(){
		return lastPosition;
	}
	
	public void setLastPosition(String lastPosition) {
		this.lastPosition = lastPosition;
	}

	public String getDescription(){
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public Date getYearFrom(){
		return yearFrom;
	}
	
	public void setYearFrom(Date yearFrom) {
		this.yearFrom = yearFrom;
	}

	public Date getYearTo(){
		return yearTo;
	}
	
	public void setYearTo(Date yearTo) {
		this.yearTo = yearTo;
	}

	public String getImgPath(){
		return imgPath;
	}
	
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public File getImg(){
		return img;
	}
	
	public void setImg(File img) {
		this.img = img;
	}
}
