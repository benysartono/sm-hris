package sm.hris.struts2.base.db;
 
import java.util.ArrayList;
//import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import sm.hris.struts2.base.db.SmBaseDAO;
import sm.hris.struts2.base.db.Category;

public class CategoryDAO extends SmBaseDAO{
 
	private Category category = new Category();
	private ArrayList<Category> categories = new ArrayList<Category>();
    private ArrayList<String> argArray = new ArrayList<String>();
    private String idCategory;

	public ArrayList<Category> searchCategory() throws SQLException{
        ResultSet rs = this.runQuery("searchCategory");
 
        while (rs.next()) {
            	Category category = new Category();
            	category.setIdCategory(rs.getString("idCategory"));
            	category.setDescription(rs.getString("description"));
            	categories.add(category);
        } 
        	
        if(rs != null){
     		   try {
     		   rs.close();
     		   } catch (SQLException e) {
     		        System.out.println("Exception while closing result set: " + e);
     		   }
  		}
       	closeConnection();
       	return categories;
        
    }

	public ArrayList<Category> searchCategoryById() throws SQLException{
        ResultSet rs = this.runQuery("searchCategoryById",argArray);
        while (rs.next()) {
        	Category category = new Category();
        	category.setIdCategory(rs.getString("idCategory"));
        	category.setIdCategory(rs.getString("description"));
        }	
        if(rs != null){
     		   try {
     		   rs.close();
     		   } catch (SQLException e) {
     		        System.out.println("Exception while closing result set: " + e);
     		   }
   		}
       	closeConnection();
       	return categories;
    }

	public ArrayList<Category> searchCategoryByDescription() throws SQLException{
        ResultSet rs = this.runQuery("searchCategoryByDescription",argArray);
        while (rs.next()) {
        	Category category = new Category();
        	category.setIdCategory(rs.getString("idCategory"));
        	category.setIdCategory(rs.getString("description"));
        }	
        if(rs != null){
     		   try {
     		   rs.close();
     		   } catch (SQLException e) {
     		        System.out.println("Exception while closing result set: " + e);
     		   }
   		}
       	closeConnection();
       	return categories;
    }

	public void categoryDelete() throws SQLException{
		for(int i=0;i<argArray.size();i++) {
			idCategory = argArray.get(i);
			this.run("categoryDelete", idCategory);
			//closeConnection();
		}
    }

	public void CategoryAdd() throws SQLException{
		argArray.add(0, category.getIdCategory());
		argArray.add(1, category.getDescription());
		this.run("categoryAdd", argArray);
		closeConnection();
	}

	public void categoryEdit() throws SQLException{
		argArray.add(0, category.getIdCategory());
		argArray.add(1, category.getDescription());
		argArray.add(2, category.getIdCategory());
		this.run("categoryEdit", argArray);
		closeConnection();
	}

	public Category getCategory(){
		return category;
	}
	
	public void setCategory(Category category){
		this.category = category;
	}

}