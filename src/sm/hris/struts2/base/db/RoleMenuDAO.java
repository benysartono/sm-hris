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
    private String strSearch = new String();

	public ArrayList<RoleMenu> searchRoleMenu() throws SQLException{
        ResultSet rs = this.runQuery("searchRoleMenu");
            while (rs.next()) {
            	RoleMenu roleMenu = new RoleMenu();
            	roleMenu.setIdRole(rs.getInt("idRole"));
            	roleMenu.setIdMenu(rs.getInt("IdMenu"));
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

	public ArrayList<RoleMenu> searchRoleMenuByIdRole() throws SQLException{
        ResultSet rs = this.runQuery("searchRoleMenuByIdRole", strSearch);
            while (rs.next()) {
            	RoleMenu roleMenu = new RoleMenu();
            	roleMenu.setIdRole(rs.getInt("idRole"));
            	roleMenu.setIdMenu(rs.getInt("idMenu"));
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

	public void roleMenuDelete() throws SQLException{
		for(int i=0;i<argArray.size();i++) {
			this.run("roleMenuDelete", argArray.get(i));
		}
    }

	public void roleMenuAdd() throws SQLException{
			argArray.add(0, String.valueOf(roleMenu.getIdRole()));
			argArray.add(1, String.valueOf(roleMenu.getIdMenu()));
			this.run("roleAdd", argArray);
			closeConnection();
    }
	
	public void roleMenuEdit() throws SQLException{
		argArray.add(0, String.valueOf(roleMenu.getIdRole()));
		argArray.add(1, String.valueOf(roleMenu.getIdMenu()));
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

	public void strSearch(String strSearch){
		this.strSearch = strSearch;
	}
}