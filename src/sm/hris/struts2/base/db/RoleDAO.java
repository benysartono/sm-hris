package sm.hris.struts2.base.db;
 
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;
import sm.hris.struts2.base.db.Role;
import sm.hris.struts2.base.db.SmBaseDAO;

public class RoleDAO extends SmBaseDAO{
 
	private Role role = new Role();
	private ArrayList<Role> roles = new ArrayList<Role>();
    private ArrayList<String> argArray = new ArrayList<String>();

	public ArrayList<Role> searchRole() throws SQLException{
        ResultSet rs = this.runQuery("searchRole");
            while (rs.next()) {
            	Role role = new Role();
            	role.setIdRole(rs.getInt("idRole"));
            	role.setRoleName(rs.getString("roleName"));
            	role.setDescription(rs.getString("description"));
            	roles.add(role);
                
            } 
        	
            if(rs != null){
     		   try {
     		   rs.close();
     		   } catch (SQLException e) {
     		        System.out.println("Exception while closing result set: " + e);
     		   }
     		}
        	closeConnection();
        	return roles;
    }

	public ArrayList<Role> searchRoleByIdRole() throws SQLException{
        ResultSet rs = this.runQuery("searchRoleByIdRole",argArray.get(0));
            while (rs.next()) {
            	Role role = new Role();
            	role.setIdRole(rs.getInt("idRole"));
            	role.setRoleName(rs.getString("roleName"));
            	role.setDescription(rs.getString("description"));
            	roles.add(role);
                
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
        	return roles;
        
    }

	public ArrayList<Role> searchRoleByNameLike() throws SQLException{
        ResultSet rs = this.runQuery("searchRoleByIdRoleLike",argArray);
            while (rs.next()) {
            	Role role = new Role();
            	role.setIdRole(rs.getInt("idRole"));
            	role.setRoleName(rs.getString("roleName"));
            	role.setDescription(rs.getString("description"));
            	roles.add(role);
                
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
        	return roles;
        
    }

	public void roleDelete() throws SQLException{
		for(int i=0;i<argArray.size();i++) {
			this.run("roleDelete", argArray.get(i));
		}
    }

	public void roleAdd() throws SQLException{
			argArray.add(0, role.getRoleName());
			argArray.add(1, role.getDescription());
			this.run("roleAdd", argArray);
			closeConnection();
    }
	
	public void roleEdit() throws SQLException{
		argArray.add(0, role.getRoleName());
		argArray.add(1, role.getDescription());
		argArray.add(2, String.valueOf(role.getIdRole()));
		this.run("roleEdit", argArray);
		closeConnection();
	}

	
	public Role getRole(){
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}
	
	public ArrayList<Role> getRoles() {
		return roles;
	}
	
	public void setRoles(ArrayList<Role> roles) {
		this.roles = roles;
	}



	public ArrayList<String> getArgArray() {
		return argArray;
	}
	
	public void setArgArray(ArrayList<String> argArray) {
		this.argArray = argArray;
	}

	
}