package sm.hris.struts2.base.modules.mgt.category;


import java.util.ArrayList;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.Category;
import sm.hris.struts2.base.db.CategoryDAO;


@ParentPackage(value = "hris")

public class IndexAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
	private CategoryDAO categoryDAO = new CategoryDAO();
    private ArrayList<Category> categories;
    private String description;
    private ArrayList<String> argArray = new ArrayList<String>();
    private ArrayList<String> idCategories = new ArrayList<String>();
    private String proc;
    private String res;
    
    public String execute() throws Exception{
    	if (proc != null){
	    	if(proc.equals("Add")){
	    		res = categoryAdd();
	    	}
	    	if(proc.equals("Delete")){
	    		res = categoryDelete();
	    	}
			if(!(proc.equals("Add")||proc.equals("Delete"))){
		    	if (!description.equals("")) {
					argArray.add("%"+description+"%");
		    		categoryDAO.setArgArray(argArray);
					setCategories(categoryDAO.searchCategoryByDescription());
					res="success";
				} 
			}
    	}
		else {
			setCategories(categoryDAO.searchCategory());
			res="success";
		} 
		return res;
    }
    
	public String categoryDelete() throws Exception {
		categoryDAO.setArgArray(idCategories);
		categoryDAO.categoryDelete();
		setCategories(categoryDAO.searchCategory());
		return "success";
	}

	public String categoryAdd() throws Exception {
		return "add";
	}


	public ArrayList<String> getIdCategories(){
			return idCategories;
		}
			
	public void setIdCategories(ArrayList<String> idCategories){
			this.idCategories=idCategories;
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

	public void setCategories(ArrayList<Category> categories){
		this.categories = categories;
	}
	
	public ArrayList<Category> getCategories(){
		return categories;
	}

}
