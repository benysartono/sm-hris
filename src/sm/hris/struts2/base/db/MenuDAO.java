package sm.hris.struts2.base.db;
 
import java.util.ArrayList;
//import java.util.List;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import sm.hris.struts2.base.db.Menu;
import sm.hris.struts2.base.db.SmBaseDAO;

public class MenuDAO extends SmBaseDAO{
 
	private ArrayList<Menu> menus = new ArrayList<Menu>();
    private String idMenu;
    private ArrayList<String> argArray = new ArrayList<String>();

	public ArrayList<Menu> searchMenu() throws SQLException{
		//List<Employee> employeesList;
        ResultSet rs = this.runQuery("searchMenu");
 
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
        	return menus;
    }

	public void menuDelete(ArrayList<String> idMenus) throws SQLException{
		for(int i=0;i<idMenus.size();i++) {
			idMenu = idMenus.get(i);
			ArrayList<String> argArray = new ArrayList<String>();
			argArray.add(0,idMenu);
			this.run("menuDelete", argArray);
			//closeConnection();
		}
    }

	public void menuAdd(Menu menu) throws SQLException{
		
			argArray.add(0, menu.getIdMenu());
			argArray.add(1, menu.getDescription());
			argArray.add(2, menu.getHref());
			argArray.add(3, menu.getHasChildren());
			this.run("menuAdd", argArray);
			//closeConnection();
    }
	
	public void menuEdit(Menu menu) throws SQLException{
		
		argArray.add(0, menu.getIdMenu());
		argArray.add(1, menu.getDescription());
		argArray.add(2, menu.getHref());
		argArray.add(3, menu.getHasChildren());
		this.run("menuEdit", argArray);
		//closeConnection();
	}

}