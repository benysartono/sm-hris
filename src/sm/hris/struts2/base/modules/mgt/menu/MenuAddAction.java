package sm.hris.struts2.base.modules.mgt.menu;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import sm.hris.struts2.base.db.Menu;
import sm.hris.struts2.base.db.MenuDAO;

import sm.hris.struts2.base.SmBaseAction;

@Results({
	@Result(name="tolist", location="/base/modules/mgt/menu/index", type="redirect"),
})
@ParentPackage(value = "hris")

public class MenuAddAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
    private Menu menu = new Menu();
    private MenuDAO menuDAO = new MenuDAO();
    private String proc = new String();
	
	public String execute() throws Exception {
		if(proc.equals("Submit")){
				menuDAO.setMenu(menu);
			    menuDAO.menuAdd();
				return "tolist";
		} else {
			return SUCCESS; 
		}	
	}

	public Menu getMenu(){
		return menu;
	}

	public void setMenu(Menu menu){
		this.menu = menu;
	}
	
	public String getProc(){
		return proc;
	}

	public void setProc(String proc){
		this.proc = proc;
	}

}


	