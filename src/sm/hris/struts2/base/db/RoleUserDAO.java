package sm.hris.struts2.base.db;
 
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;
import sm.hris.struts2.base.db.RoleMenu;
import sm.hris.struts2.base.db.SmBaseDAO;

public class RoleUserDAO extends SmBaseDAO{
 
	private RoleUser roleUser = new RoleUser();
	private ArrayList<RoleUser> roleUsers = new ArrayList<RoleUser>();
    private ArrayList<String> argArray = new ArrayList<String>();
    private String strSearch;

	public ArrayList<RoleUser> userListByIdRole() throws SQLException{
        ResultSet rs = this.runQuery("userListByIdRole", strSearch);
            while (rs.next()) {
            	RoleUser roleUser = new RoleUser();
            	roleUser.setIdRole(rs.getString("idRole"));
            	roleUser.setUid(rs.getString("uid"));
            	roleUser.setName(rs.getString("name"));
            	roleUsers.add(roleUser);
                
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
        	return roleUsers;
        
    }

	public ArrayList<RoleUser> roleListByIdUser() throws SQLException{
        ResultSet rs = this.runQuery("roleListByIdUser", strSearch);
            while (rs.next()) {
            	RoleUser roleUser = new RoleUser();
            	roleUser.setIdRole(rs.getString("idRole"));
            	roleUser.setUid(rs.getString("uid"));
            	roleUser.setName(rs.getString("name"));
            	roleUsers.add(roleUser);
                
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
        	return roleUsers;
        
    }

	public void roleUserDeleteByIdRole() throws SQLException{
			this.run("roleUserDeleteByIdRole", strSearch);
    }

	public void roleUserAdd() throws SQLException{
			argArray.add(0, String.valueOf(roleUser.getIdRole()));
			argArray.add(1, String.valueOf(roleUser.getUid()));
			this.run("roleUserAdd", argArray);
			closeConnection();
    }
	
	public RoleUser getRoleUser(){
		return roleUser;
	}
	
	public void setRoleUser(RoleUser roleUser) {
		this.roleUser = roleUser;
	}
	
	public ArrayList<RoleUser> getRoleUsers() {
		return roleUsers;
	}
	
	public void setRoleUsers(ArrayList<RoleUser> roleUsers) {
		this.roleUsers = roleUsers;
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