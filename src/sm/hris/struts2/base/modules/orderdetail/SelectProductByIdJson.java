package sm.hris.struts2.base.modules.orderdetail;


import java.util.ArrayList;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.ProductDAO;
import sm.hris.struts2.base.db.Product;


@Result(name="success",type="json")
@ParentPackage("hris")

public class SelectProductByIdJson extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
    private String idProduct;
    private ProductDAO productDAO = new ProductDAO();
    private Product product = new Product();
    private ArrayList<Product> products = new ArrayList<Product>();
    private ArrayList<String> argArray = new ArrayList<String>();
    
    public String execute() throws Exception{
    	argArray.add(idProduct);
    	productDAO.setArgArray(argArray);
    	products = productDAO.searchProductById();
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
    public ArrayList<Product> getProducts(){
    	return this.products;
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
