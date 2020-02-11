package sm.hris.struts2.base.modules.mgt.discount;


import java.util.ArrayList;
import java.util.HashMap;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.Discount;
import sm.hris.struts2.base.db.DiscountDAO;
import sm.hris.struts2.base.db.Product;
import sm.hris.struts2.base.db.ProductDAO;

@ParentPackage(value = "hris")

public class IndexAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
	private DiscountDAO discountDAO = new DiscountDAO();
    private ArrayList<Discount> discounts = new ArrayList<Discount>();
    private ArrayList<String> argArray = new ArrayList<String>();
    private ArrayList<String> idDiscounts = new ArrayList<String>();
    private ArrayList<ArrayList<String>> argArray2 = new ArrayList<ArrayList<String>>();
    private ProductDAO productDAO = new ProductDAO();
    private ArrayList<Product> products = new ArrayList<Product>();
    private String proc;
    private String res;
    private String keyword;
    private Integer n;
    private Discount discount;
    
    public String execute() throws Exception{
    	if (proc != null){
	    	if(proc.equals("Add")){
	    		products = productDAO.searchProduct();
	    		res="add";
	    	}
	    	if(proc.equals("Delete")){
	    		discountDAO.setIdDiscounts(idDiscounts);
	    		discountDAO.discountDelete();
	    		setDiscounts(discountDAO.searchDiscount());
	    		res="success";
	    	}
			if(!(proc.equals("Add")||proc.equals("Delete"))){
		    	if (!keyword.equals("")) {
					argArray.add("%"+keyword+"%");
		    		discountDAO.setArgArray(argArray);
					setDiscounts(discountDAO.searchDiscountByAnyLike());
					res="success";
				} 
			}
    	}
		else {
			setDiscounts(discountDAO.searchDiscount());
			res="success";
		} 
		return res;
    }
    

	public String discountAdd() throws Exception {
		return "add";
	}

	public String getKeyword(){
		return keyword;
	}
	
	public void setKeyword(String keyword){
		this.keyword = keyword;
	}

	public void setProc(String proc) {
        this.proc = proc;
    }

	public void setDiscounts(ArrayList<Discount> discounts){
		this.discounts = discounts;
	}
	
	public ArrayList<Discount> getDiscounts(){
		return discounts;
	}

	public void setProducts(ArrayList<Product> products){
		this.products = products;
	}
	
	public ArrayList<Product> getProducts(){
		return products;
	}
	
	public void setDiscount(Discount discount){
		this.discount = discount;
	}
	
	public Discount getDiscount(){
		return discount;
	}

	public ArrayList<ArrayList<String>> getArgArray2(){
		return argArray2;
	}	
	
	public void setArgArray2(ArrayList<ArrayList<String>> argArray2){
		this.argArray2 = argArray2;
	}

	public ArrayList<String> getIdDiscounts(){
		return idDiscounts;
	}	
	
	public void setIdDiscounts(ArrayList<String> idDiscounts){
		this.idDiscounts = idDiscounts;
	}

	public ArrayList<String> getArgArray(){
		return argArray;
	}	
	
	public void setArgArray(ArrayList<String> argArray){
		this.argArray = argArray;
	}
}
