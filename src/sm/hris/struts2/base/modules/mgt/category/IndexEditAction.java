package sm.hris.struts2.base.modules.mgt.category;


import java.util.ArrayList;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.Category;
import sm.hris.struts2.base.db.CategoryDAO;


@Results({
	@Result(name="tolist", location="/base/modules/mgt/category", type="redirect"),
	})
@ParentPackage(value = "hris")

public class IndexEditAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
	private CategoryDAO categoryDAO = new CategoryDAO();
    private Category category = new Category();
    private ArrayList<String> argArray = new ArrayList<String>();
    private String proc = new String();
    
    public String execute() throws Exception{
    	if((proc != null)&&(proc.equals("Submit"))) {
    		categoryDAO.setCategory(category);
    		categoryDAO.categoryEdit();
    		//setCategory(category);
    		return "tolist";
    	}
    	else {
    		return SUCCESS;
    	}
    }
 
	public Category getCategory(){
		return category;
	}
	
	public void setCategory(Category category){
		this.category = category;
	}
	
	public String getProc(){
		return proc;
	}
	
	public void setProc(String proc){
		this.proc = proc;
	}



}
