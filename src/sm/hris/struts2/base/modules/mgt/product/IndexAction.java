package sm.hris.struts2.base.modules.mgt.product;


import java.util.ArrayList;
import java.util.HashMap;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.Product;
import sm.hris.struts2.base.db.ProductDAO;
import sm.hris.struts2.base.db.Category;
import sm.hris.struts2.base.db.CategoryDAO;

@ParentPackage(value = "hris")

public class IndexAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
	private ProductDAO productDAO = new ProductDAO();
    private ArrayList<Product> products;
    private String description;
    private ArrayList<String> argArray = new ArrayList<String>();
    private ArrayList<String> idProducts = new ArrayList<String>();
    private String proc;
    private String res;
    private Category category = new Category();
    private CategoryDAO categoryDAO = new CategoryDAO();
    private ArrayList<Category> categories = new ArrayList<Category>();
    
    public String execute() throws Exception{
    	if (proc != null){
	    	if(proc.equals("Add")){
	    		setCategories(categoryDAO.searchCategory());
	    		return "add";
	    		//res = productAdd();
	    	}
	    	if(proc.equals("Delete")){
	    		res = productDelete();
	    	}
			if(!(proc.equals("Add")||proc.equals("Delete"))){
		    	if (!description.equals("")) {
					argArray.add("%"+description+"%");
		    		productDAO.setArgArray(argArray);
					setProducts(productDAO.searchProductByAnyLike());
					res="success";
				} 
			}
    	}
		else {
			setProducts(productDAO.searchProduct());
			res="success";
		} 
		return res;
    }
    
	public String productDelete() throws Exception {
		productDAO.setArgArray(idProducts);
		productDAO.productDelete();
		setProducts(productDAO.searchProduct());
		return "success";
	}

	public String productAdd() throws Exception {
		return "add";
	}


	public ArrayList<String> getIdProducts(){
			return idProducts;
		}
			
	public void setIdProducts(ArrayList<String> idProducts){
			this.idProducts=idProducts;
		}
	
	public String getDescription(){
		return description;
	}
	
	public void setDescription(String description){
		this.description = description;
	}

	public void setProc(String proc) {
        this.proc = proc;
    }

	public void setProducts(ArrayList<Product> products){
		this.products = products;
	}
	
	public ArrayList<Product> getProducts(){
		return products;
	}
	public ArrayList<Category> getCategories(){
		return categories;
	}	
	
	public void setCategories(ArrayList<Category> categories){
		this.categories = categories;
	}

}
