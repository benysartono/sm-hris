package sm.hris.struts2.base.db;
 
import java.util.ArrayList;
//import java.util.List;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import sm.hris.struts2.base.db.Department;
import sm.hris.struts2.base.db.SmBaseDAO;

public class DepartmentDAO extends SmBaseDAO{
 
	private ArrayList<Department> departments = new ArrayList<Department>();
    private String idDepartment;
    private ArrayList<String> argArray = new ArrayList<String>();

	public ArrayList<Department> searchDepartment() throws SQLException{
        ResultSet rs = this.runQuery("searchDepartment");
 
            while (rs.next()) {
                Department department = new Department();
                department.setIdDepartment(rs.getString("idDepartment"));
                department.setName(rs.getString("name"));
                department.setDescription(rs.getString("description"));
                department.setParentDepartment(rs.getString("parentDepartment"));
                departments.add(department);
                
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
            //rs.close();
        	return departments;

        
    }

	public ArrayList<Department> searchDepartmentNotEqualTo() throws SQLException{
        ResultSet rs = this.runQuery("searchDepartmentNotEqualTo", argArray.get(0));
 
            while (rs.next()) {
                Department department = new Department();
                department.setIdDepartment(rs.getString("idDepartment"));
                department.setName(rs.getString("name"));
                department.setDescription(rs.getString("description"));
                department.setParentDepartment(rs.getString("parentDepartment"));
                departments.add(department);
                
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
            //rs.close();
        	return departments;

        
    }
	
	public ArrayList<Department> searchDepartment(ArrayList<String> searchArg) throws SQLException{
        ResultSet rs = this.runQuery("searchDepartmentP",searchArg);
 
            while (rs.next()) {
                Department department = new Department();
                department.setIdDepartment(rs.getString("idDepartment"));
                department.setName(rs.getString("name"));
                department.setDescription(rs.getString("description"));
                department.setParentDepartment(rs.getString("parentDepartment"));
                departments.add(department);
                
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
            //rs.close();
        	return departments;

        
    }
	
	public void departmentDelete(ArrayList<String> idDepartments) throws SQLException{
		for(int i=0;i<idDepartments.size();i++) {
			idDepartment = idDepartments.get(i);
			argArray.add(idDepartment);
			this.run("departmentDelete", argArray);
            //closeConnection();
		}
    }

	public void departmentAdd(Department department) throws SQLException{
			argArray.add(0, department.getIdDepartment());
			argArray.add(1, department.getName());
			argArray.add(2, department.getDescription());
			this.run("departmentAdd", argArray);
            //closeConnection();
    }
	
	public void departmentEdit(Department department) throws SQLException{
		System.out.println("Inside DepartmentDAO: argArray.add(0, department.getIdDepartment());");
		System.out.println(department.getIdDepartment());
		System.out.println(department.getName());
		System.out.println(department.getDescription());
		System.out.println(department.getParentDepartment());
		System.out.println(department.getIdDepartment());
		
		
		argArray.add(0, department.getName());
		argArray.add(1, department.getDescription());
		argArray.add(2, department.getParentDepartment());
		argArray.add(3, department.getIdDepartment());
		this.run("departmentEdit", argArray);
        //closeConnection();
	}

	public void setArgArray(ArrayList<String> argArray) {
		this.argArray = argArray;
	}
}