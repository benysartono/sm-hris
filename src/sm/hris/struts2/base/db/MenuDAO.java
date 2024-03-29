package sm.hris.struts2.base.db;
 
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionContext;

//import java.util.List;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import sm.hris.struts2.base.db.Menu;
import sm.hris.struts2.base.db.SmBaseDAO;
import sm.hris.struts2.base.db.RoleUser;
import sm.hris.struts2.base.db.RoleUserDAO;


public class MenuDAO extends SmBaseDAO{
	private Menu menu = new Menu();
	private ArrayList<Menu> menus = new ArrayList<Menu>();
    private String idMenu;
    private ArrayList<String> argArray = new ArrayList<String>();
	private Map<String, Object> sessionAttributes;
	private Map session = ActionContext.getContext().getSession();

	private RoleUser roleUser = new RoleUser();
	private ArrayList<RoleUser> roleUsers = new ArrayList<RoleUser>();
	private RoleUserDAO roleUserDAO = new RoleUserDAO();
	
	private Integer n;
	
	private String url;
	private String idUser;
	private String res;

	
	public String checkRoleAccess() throws SQLException{
		argArray = new ArrayList<String>();
		argArray.add(0,url);
		argArray.add(1,idUser);
		
        ResultSet rs = this.runQuery("checkRoleAccess",argArray);
        res="unAuthorized";
        if((rs != null)&&(rs.first())){
        	if(rs.getString("href").equals(url)) {
        		res = "Authorized";
        	}
        }	
        else {
            if ("/sm-hris/base/index".equals(url)) {
            	res = "Authorized";
            }
            if ("/sm-hris/base/index-mobile".equals(url)) {
            	res = "Authorized";
            }
        } 
        //this.con.close();
        return res;
	}
	
	public ArrayList<Menu> listMenu() throws SQLException{
			ResultSet rs = this.runQuery("listMenu");
            while (rs.next()) {
                Menu menu = new Menu();
                menu.setIdMenu(rs.getString("idMenu"));
                menu.setDescription(rs.getString("description"));
                menu.setHref(rs.getString("href"));
                menu.setHasChildren(rs.getString("hasChildren"));
                menus.add(menu);
            }
            //this.con.close();
        	return menus;
        
    }
	
	
	public ArrayList<Menu> searchMenu() throws SQLException{
		//List<Employee> employeesList;
		roleUserDAO.setStrSearch(String.valueOf(session.get("userId")));
		try {
			roleUsers = roleUserDAO.roleListByIdUser();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(n=0;n<roleUsers.size();n++){
			ResultSet rs = this.runQuery("searchMenu",String.valueOf(roleUsers.get(n).getIdRole()));
            while (rs.next()) {
                Menu menu = new Menu();
                menu.setIdMenu(rs.getString("idMenu"));
                menu.setDescription(rs.getString("description"));
                menu.setHref(rs.getString("href"));
                menu.setHasChildren(rs.getString("hasChildren"));
                menus.add(menu);
            }
		}
        	/*
            if(rs != null){
     		   try {
     		   rs.close();
     		   } catch (SQLException e) {
     		        System.out.println("Exception while closing result set: " + e);
     		   }
     		}
        	closeConnection();
     		*/
        	//this.con.close();
        	return menus;
        
    }

	public ArrayList<Menu> searchMenu(ArrayList<String> description) throws SQLException{
        ResultSet rs = this.runQuery("searchMenuP",description);
 
            while (rs.next()) {
                Menu menu = new Menu();
                menu.setIdMenu(rs.getString("idMenu"));
                menu.setDescription(rs.getString("description"));
                menu.setHref(rs.getString("href"));
                menu.setHasChildren(rs.getString("hasChildren"));
                menus.add(menu);
                
            } 
        	/*
            if(rs != null){
     		   try {
     		   rs.close();
     		   } catch (SQLException e) {
     		        System.out.println("Exception while closing result set: " + e);
     		   }
     		}
        	closeConnection();
        	*/
            //this.con.close();
        	return menus;
    }

	public void menuDelete(ArrayList<String> idMenus) throws SQLException{
		for(int i=0;i<idMenus.size();i++) {
			idMenu = idMenus.get(i);
			ArrayList<String> argArray = new ArrayList<String>();
			argArray.add(0,idMenu);
			this.run("menuDelete", argArray);
	        //this.con.close();
			//closeConnection();
		}
    }

	public void menuAdd() throws SQLException{
		
			argArray.add(0, menu.getIdMenu());
			argArray.add(1, menu.getDescription());
			argArray.add(2, menu.getHref());
			argArray.add(3, menu.getHasChildren());
			argArray.add(4, menu.getLvl());
			argArray.add(5, menu.getOrd());
			argArray.add(6, menu.getParent());
			this.run("menuAdd", argArray);
	        //this.con.close();
			//closeConnection();
    }
	
	public void menuEdit() throws SQLException{
		
		argArray.add(0, menu.getIdMenu());
		argArray.add(1, menu.getDescription());
		argArray.add(2, menu.getHref());
		argArray.add(3, menu.getHasChildren());
		this.run("menuEdit", argArray);
        //this.con.close();
		//closeConnection();
	}

	
	public void setMenu(Menu menu){
		this.menu = menu;
	}
	
	public Menu getMenu(){
		return menu;
	}

	public void setIdUser(String idUser){
		this.idUser = idUser;
	}
	
	public String getIdUser(){
		return idUser;
	}

	public void setUrl(String url){
		this.url = url;
	}
	
	public String getUrl(){
		return url;
	}
}