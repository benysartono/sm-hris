package sm.hris.struts2.base.db;
 
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import sm.hris.struts2.base.db.Product;
import sm.hris.struts2.base.db.SmBaseDAO;

public class ProductDAO extends SmBaseDAO{
 
	private ArrayList<Product> products = new ArrayList<Product>();
	private Product product;
    private String idProduct;
    private ArrayList<String> argArray = new ArrayList<String>();

    public ArrayList<Product> searchProduct() throws SQLException{
        ResultSet rs = this.runQuery("searchProduct");
        while (rs.next()) {
        	Product product = new Product();
            product.setIdProduct(rs.getString("idProduct"));
            product.setNmProduct(rs.getString("nmProduct"));
            product.setDescription(rs.getString("description"));
            product.setUnit(rs.getString("unit"));
            product.setUnitPrice(rs.getFloat("unitPrice"));
            product.setIdCategory(rs.getString("idCategory"));
            product.setImgUrl(rs.getString("imgUrl"));
            products.add(product);
        } 
        if(rs != null){
     	   try {
     	   rs.close();
     	   } catch (SQLException e) {
     	        System.out.println("Exception while closing result set: " + e);
     	   }
     	}
        closeConnection();
        return products;
        
    }

	public ArrayList<Product> searchProductById() throws SQLException{
		ResultSet rs = this.runQuery("searchProductById", argArray);
        while (rs.next()) {
        	Product product = new Product();
            product.setIdProduct(rs.getString("idProduct"));
            product.setNmProduct(rs.getString("nmProduct"));
            product.setDescription(rs.getString("description"));
            product.setUnit(rs.getString("unit"));
            product.setUnitPrice(rs.getFloat("unitPrice"));
            product.setIdCategory(rs.getString("idCategory"));
            product.setImgUrl(rs.getString("imgUrl"));
            products.add(product);
        } 
        if(rs != null){
     	   try {
     		   rs.close();
     	   } catch (SQLException e) {
     		   System.out.println("Exception while closing result set: " + e);
     	   }
     	}
        closeConnection();
        return products;
    }

	public ArrayList<Product> searchProductByAnyLike() throws SQLException{
		ResultSet rs = this.runQuery("searchProductByAnyLike", argArray);
        while (rs.next()) {
        	Product product = new Product();
            product.setIdProduct(rs.getString("idProduct"));
            product.setNmProduct(rs.getString("nmProduct"));
            product.setDescription(rs.getString("description"));
            product.setUnit(rs.getString("unit"));
            product.setUnitPrice(rs.getFloat("unitPrice"));
            product.setIdCategory(rs.getString("idCategory"));
            product.setImgUrl(rs.getString("imgUrl"));
            products.add(product);
        } 
        if(rs != null){
     	   try {
     		   rs.close();
     	   } catch (SQLException e) {
     		   System.out.println("Exception while closing result set: " + e);
     	   }
     	}
        closeConnection();
        return products;
    }

	public void productDelete() throws SQLException{
		for(int i=0;i<argArray.size();i++) {
			idProduct = argArray.get(i);
			this.run("productDelete", idProduct);
			//closeConnection();
		}
    }

	public void productAdd() throws SQLException {
		argArray.add(0, product.getIdProduct());
		argArray.add(1, product.getNmProduct());
		argArray.add(2, product.getDescription());
		argArray.add(3, product.getUnit());
		argArray.add(4, String.valueOf(product.getUnitPrice()));
		argArray.add(5, product.getIdCategory());
		this.run("productAdd", argArray);
		closeConnection();
    }
	
	public void productEdit() throws SQLException{
		argArray.add(0, product.getIdProduct());
		argArray.add(1, product.getNmProduct());
		argArray.add(2, product.getDescription());
		argArray.add(3, product.getUnit());
		argArray.add(4, String.valueOf(product.getUnitPrice()));
		argArray.add(5, product.getIdCategory());
		argArray.add(6, product.getImgUrl());
		argArray.add(7, product.getIdProduct());
		this.run("productEdit", argArray);
		closeConnection();
	}

	
	public void setArgArray(ArrayList<String> argArray){
		this.argArray = argArray;
	}
	public ArrayList<String> getArgArray(){
		return argArray;
	}
	public String getIdProduct(){
		return idProduct;
	}
	public void setIdProduct(String idProduct){
		this.idProduct = idProduct;
	}
	public void setProducts(ArrayList<Product> products){
		this.products = products;
	}
	public ArrayList<Product> getProducts(){
		return products;
	}
	public Product getProduct(){
		return product;
	}
	public void setProduct(Product product){
		this.product = product;
	}
}