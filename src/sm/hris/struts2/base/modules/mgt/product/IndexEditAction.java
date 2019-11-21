package sm.hris.struts2.base.modules.mgt.product;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.Product;
import sm.hris.struts2.base.db.ProductDAO;
import sm.hris.struts2.base.db.Category;
import sm.hris.struts2.base.db.CategoryDAO;

import java.io.FileInputStream;
import java.io.FileOutputStream;


@Results({
	@Result(name="tolist", location="/base/modules/mgt/product", type="redirect"),
	})
@ParentPackage(value = "hris")

public class IndexEditAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
	private ProductDAO productDAO = new ProductDAO();
    private Product product = new Product();
    private String proc;
    private Category category = new Category();
    private CategoryDAO categoryDAO = new CategoryDAO();
    private ArrayList<Category> categories = new ArrayList<Category>();
  
    
    public String execute() throws Exception{
    	if((proc != null)&&(proc.equals("Submit"))) {

		    //Reading the file image into FileInputStream
		    FileInputStream fis = new FileInputStream(product.getImg());
		    byte[] bytesArray = new byte[(int) product.getImg().length()];
		    fis.read(bytesArray); //read file into bytes[]
		    fis.close();
		    
		    //Creating New Empty File
		    String filePreffix = product.getIdProduct();
		    String fileExtension = getFileExtension(product.getImgFileName());
		    File imgFile = new File("C:/Bitnami/tomcatstack-7.0.67-0/apache-tomcat/webapps/img/product/" + filePreffix + "." + fileExtension);
		    
		    //Writing into the new empty file
		    FileOutputStream fos = new FileOutputStream(imgFile);
		    fos.write(bytesArray);
		    fos.flush();
		    fos.close();
		    
		    String fileURL = "http://127.0.0.1/img/product/" + filePreffix + "." + fileExtension;
		    product.setImgUrl(fileURL);
		    //employee.setImg(img);
    		
    		productDAO.setProduct(product);
    		productDAO.productEdit();
    		
    		return "tolist";
    	}
		setCategories(categoryDAO.searchCategory());
		return SUCCESS;
    }
	
    private static String getFileExtension(String fileName) {
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
    
    public Product getProduct(){
		return product;
	}
	
	public void setProduct(Product product){
		this.product = product;
	}

    public String getProc(){
		return proc;
	}
	
	public void setProc(String proc){
		this.proc = proc;
	}

	public ArrayList<Category> getCategories(){
		return categories;
	}	
	
	public void setCategories(ArrayList<Category> categories){
		this.categories = categories;
	}
	

	
}
