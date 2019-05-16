package sm.hris.struts2.base.db;
 
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;
import sm.hris.struts2.base.db.RoleMenu;
import sm.hris.struts2.base.db.SmBaseDAO;

public class RoleMenuDAO extends SmBaseDAO{
 
	private RoleMenu roleMenu = new RoleMenu();
	private ArrayList<RoleMenu> roleMenus = new ArrayList<RoleMenu>();
    private ArrayList<String> argArray = new ArrayList<String>();
    private String strSearch;

	public ArrayList<RoleMenu> searchRoleMenu() throws SQLException{
        ResultSet rs = this.runQuery("searchRoleMenu");
            while (rs.next()) {
            	RoleMenu roleMenu = new RoleMenu();
            	roleMenu.setIdRole(rs.getString("idRole"));
            	roleMenu.setIdMenu(rs.getString("IdMenu"));
            	roleMenus.add(roleMenu);
                
            } 
        	
            if(rs != null){
     		   try {
     		   rs.close();
     		   } catch (SQLException e) {
     		        System.out.println("Exception while closing result set: " + e);
     		   }
     		}
        	closeConnection();
        	return roleMenus;
    }

	public ArrayList<RoleMenu> menuListByIdRole() throws SQLException{
        ResultSet rs = this.runQuery("menuListByIdRole", strSearch);
            while (rs.next()) {
            	RoleMenu roleMenu = new RoleMenu();
            	roleMenu.setIdRole(rs.getString("idRole"));
            	roleMenu.setIdMenu(rs.getString("idMenu"));
            	roleMenu.setDescription(rs.getString("description"));
            	roleMenu.setHref(rs.getString("href"));
            	roleMenus.add(roleMenu);
                
            } 
        	
            if(rs != null){
  			   System.out.println("RS tidak null");
     		   try {
     			   rs.close();
     		   } catch (SQLException e) {
     		        System.out.println("Exception while closing result set: " + e);
     		   }
     		}
        	closeConnection();
        	return roleMenus;
        
    }

	public void roleMenuDeleteByIdRole() throws SQLException{
			this.run("roleMenuDeleteByIdRole", strSearch);
    }

	public void roleMenuDelete() throws SQLException{
		for(int i=0;i<argArray.size();i++) {
			this.run("roleMenuDelete", argArray.get(i));
		}
    }

	public void roleMenuAdd() throws SQLException{
			argArray.add(0, String.valueOf(roleMenu.getIdRole()));
			argArray.add(1, String.valueOf(roleMenu.getIdMenu()));
			this.run("roleMenuAdd", argArray);
			closeConnection();
    }
	
	public void roleMenuEdit() throws SQLException{
		argArray.add(0, String.valueOf(roleMenu.getIdRole()));
		argArray.add(1, String.valueOf(roleMenu.getIdMenu()));
		argArray.add(2, String.valueOf(roleMenu.getIdRole()));
		argArray.add(3, String.valueOf(roleMenu.getIdMenu()));
		this.run("roleMenuEdit", argArray);
		closeConnection();
	}
	
	public RoleMenu getRoleMenu(){
		return roleMenu;
	}
	
	public void setRoleMenu(RoleMenu roleMenu) {
		this.roleMenu = roleMenu;
	}
	
	public ArrayList<RoleMenu> getRoleMenus() {
		return roleMenus;
	}
	
	public void setRoleMenus(ArrayList<RoleMenu> roleMenus) {
		this.roleMenus = roleMenus;
	}

	public ArrayList<String> getArgArray() {
		return argArray;
	}
	
	public void setArgArray(ArrayList<String> argArray) {
		this.argArray = argArray;
	}

	public void setStrSearch(String strSearch){
		this.strSearch = strSearch;
	}
}