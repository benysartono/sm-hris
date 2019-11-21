package sm.hris.struts2.base.db;

//import java.util.Date;
import java.io.File;
//import org.apache.commons.codec.digest.DigestUtils;

public class Product {

	private String idProduct; 									
	private String nmProduct; 				
	private String description; 				
	private String unit; 									
	private Float unitPrice; 									
	private String idCategory; 									
	private String imgUrl; 
	private File img;
    private String imgContentType;
    private String imgFileName;

	
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

	public String getDescription(){
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
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

	public String getIdCategory(){
		return idCategory;
	}
	
	public void setIdCategory(String idCategory) {
		this.idCategory = idCategory;
	}
	
	public String getImgUrl(){
		return imgUrl;
	}
	
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public File getImg(){
		return img;
	}
	
	public void setImg(File img) {
		this.img = img;
	}

	public String getImgFileName(){
		return imgFileName;
	}
	
	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}

	public String getImgContentType(){
		return imgContentType;
	}
	
	public void setImgContentType(String imgContentType) {
		this.imgContentType = imgContentType;
	}

}
