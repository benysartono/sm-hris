package sm.hris.struts2.base;


import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

import sm.hris.struts2.base.db.MenuDAO;
import sm.hris.struts2.base.db.Menu;


//@Results({@Result(name="loginx", location="/base/login", type="redirect"),@Result(name="success", type="json")})
@Result(name="loginx", location="/base/login", type="redirect")
@InterceptorRef(value="customStack")
//@ParentPackage(value = "json-default")
@ParentPackage(value="hris")
//@Results({@Result(name="success", location="menu.tiles", type="tiles"),@Result(name="error", location="login.tiles", type="tiles")})

public class SmBaseAction extends ActionSupport {
    //private static final long serialVersionUID = 7353477345330099548L;
    private ArrayList<Menu> menus;
	private MenuDAO menuDAO = new MenuDAO();
 
/*
    public String execute() throws Exception{
		//try{
			menus = menuDAO.searchMenu();
			return "success";
		//}
		//catch (SQLException e) {
			//return "error";
		//}
			
    }
*/
	
    public void listMenu() throws Exception{
		//try{
			menus = menuDAO.searchMenu();
		//}
		//catch (SQLException e) {
			//return "error";
		//}
			
    }

	
	public void setMenus(ArrayList<Menu> menus){
		this.menus = menus;
	}

	public ArrayList<Menu> getMenus(){
		return menus;
	}
	
		
	}


