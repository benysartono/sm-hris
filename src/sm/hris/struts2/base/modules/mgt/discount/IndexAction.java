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
import sm.hris.struts2.base.db.Category;
import sm.hris.struts2.base.db.CategoryDAO;

@ParentPackage(value = "hris")

public class IndexAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
	private DiscountDAO discountDAO = new DiscountDAO();
    private ArrayList<Discount> discounts;
    private ArrayList<String> argArray = new ArrayList<String>();
    private ArrayList<ArrayList<String>> argArray2 = new ArrayList<ArrayList<String>>();
    private String proc;
    private String res;
    private String keyword;
    
    public String execute() throws Exception{
    	if (proc != null){
	    	if(proc.equals("Add")){
	    		return "add";
	    	}
	    	if(proc.equals("Delete")){
	    		res = discountDelete();
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
    
	public String discountDelete() throws Exception {
		discountDAO.setDiscounts(discounts);
		discountDAO.discountDelete();
		setDiscounts(discountDAO.searchDiscount());
		return "success";
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
	public ArrayList<ArrayList<String>> getArgArray2(){
		return argArray2;
	}	
	
	public void setArgArray2(ArrayList<ArrayList<String>> argArray2){
		this.argArray2 = argArray2;
	}

	public ArrayList<String> getArgArray(){
		return argArray;
	}	
	
	public void setArgArray(ArrayList<String> argArray){
		this.argArray = argArray;
	}
}
