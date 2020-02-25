package sm.hris.struts2.base.modules.orderdetail;


import java.util.ArrayList;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.DiscountDAO;
import sm.hris.struts2.base.db.Discount;


@Result(name="success",type="json")
@ParentPackage("hris")

public class SelectDiscountByIdProductJsonAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
    private String idProduct;
    private DiscountDAO discountDAO = new DiscountDAO();
    private Discount discount = new Discount();
    private ArrayList<String> argArray = new ArrayList<String>();
    private ArrayList<Discount> discounts = new ArrayList<Discount>();
    
    public String execute() throws Exception{
    	argArray.add(idProduct);
    	discountDAO.setArgArray(argArray);
    	discounts = discountDAO.searchDiscountByIdProduct();
    	return "success";
    }
/*    
    public String getIdProduct(){
    	return this.idProduct;
    } 
*/    
    public void setIdProduct(String idProduct){
    	this.idProduct = idProduct;
    }
/*
    public Product getProduct(){
    	return this.product;
    } 
    
    public void setProduct(Product product){
    	this.product = product;
    }
*/
    public ArrayList<Discount> getDiscounts(){
    	return this.discounts;
    } 
/*    
    public void setProducts(ArrayList<Product> products){
    	this.products = products;
    }
    
    public ArrayList<String> getArgArray(){
    	return this.argArray;
    } 
*/    
    public void setArgArray(ArrayList<String> argArray){
    	this.argArray = argArray;
    } 
}
