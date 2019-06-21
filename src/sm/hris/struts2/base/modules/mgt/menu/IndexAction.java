package sm.hris.struts2.base.modules.mgt.menu;


import java.util.ArrayList;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.Menu;
import sm.hris.struts2.base.db.MenuDAO;


@Results({
	@Result(name="add", location="/base/modules/mgt/menu/menu-add", type="redirect"),
	})
@ParentPackage(value = "hris")

public class IndexAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
	private MenuDAO menuDAO = new MenuDAO();
    private ArrayList<Menu> menus;
    private String description;
    private ArrayList<String> formArg = new ArrayList<String>();
    private ArrayList<String> idMenus = new ArrayList<String>();
    private String proc;
    private String res;
    
    public String execute() throws Exception{
    	//super.listMenu();
    	if (proc != null){
	    	if(proc.equals("Add")){
	    		res = menuAdd();
	    	}
	    	if(proc.equals("Delete")){
	    		res = menuDelete();
	    	}
			if(!(proc.equals("Add")||proc.equals("Delete"))){
		    	if (!description.equals("")) {
					formArg.add("%"+description+"%");
					setMenus(menuDAO.searchMenu(formArg));
					res="success";
				} 
			}
    	}
		else {
			menus = menuDAO.listMenu();
			res="success";
		} 
		return res;
    }
    
	public String menuDelete() throws Exception {
		menuDAO.menuDelete(idMenus);
		menus = menuDAO.listMenu();
		return "success";
	}

	public String menuAdd() throws Exception {
		return "add";
	}


	public ArrayList<String> getIdMenus(){
			return idMenus;
		}
			
	public void setIdMenus(ArrayList<String> idMenus){
			this.idMenus=idMenus;
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

	public ArrayList<Menu> getMenus(){
		return menus;
	} 
	
	public void setMenus(ArrayList<Menu> menus){
		this.menus = menus;
	}

}
