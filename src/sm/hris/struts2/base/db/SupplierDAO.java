package sm.hris.struts2.base.db;
 
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import sm.hris.struts2.base.db.Supplier;
import sm.hris.struts2.base.db.SmBaseDAO;

public class SupplierDAO extends SmBaseDAO{
 
	private ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
	private Supplier supplier;
    private String idSupplier;
    private ArrayList<String> argArray = new ArrayList<String>();

    public ArrayList<Supplier> searchSupplier() throws SQLException{
        ResultSet rs = this.runQuery("searchSupplier");
        while (rs.next()) {
        	Supplier supplier = new Supplier();
            supplier.setIdSupplier(rs.getString("idSupplier"));
            supplier.setNmSupplier(rs.getString("nmSupplier"));
            supplier.setAddress(rs.getString("address"));
            supplier.setPhone(rs.getString("phone"));
            supplier.setEmail(rs.getString("email"));
            supplier.setFax(rs.getString("fax"));
            supplier.setNpwp(rs.getString("npwp"));
            supplier.setBankAccount(rs.getString("bankAccount"));
            suppliers.add(supplier);
        } 
        if(rs != null){
     	   try {
     	   rs.close();
     	   } catch (SQLException e) {
     	        System.out.println("Exception while closing result set: " + e);
     	   }
     	}
        closeConnection();
        return suppliers;
        
    }

	public ArrayList<Supplier> searchSupplierById() throws SQLException{
		ResultSet rs = this.runQuery("searchSupplierById", argArray);
        while (rs.next()) {
            Supplier supplier = new Supplier();
            supplier.setIdSupplier(rs.getString("idSupplier"));
            supplier.setNmSupplier(rs.getString("nmSupplier"));
            supplier.setAddress(rs.getString("address"));
            supplier.setPhone(rs.getString("phone"));
            supplier.setEmail(rs.getString("email"));
            supplier.setFax(rs.getString("fax"));
            supplier.setNpwp(rs.getString("npwp"));
            supplier.setBankAccount(rs.getString("bankAccount"));
            suppliers.add(supplier);
            
        } 
        if(rs != null){
     	   try {
     		   rs.close();
     	   } catch (SQLException e) {
     		   System.out.println("Exception while closing result set: " + e);
     	   }
     	}
        closeConnection();
        return suppliers;
    }

	public ArrayList<Supplier> searchSupplierByAnyLike() throws SQLException{
		ResultSet rs = this.runQuery("searchSupplierByAnyLike", argArray);
        while (rs.next()) {
            Supplier supplier = new Supplier();
            supplier.setIdSupplier(rs.getString("idSupplier"));
            supplier.setNmSupplier(rs.getString("nmSupplier"));
            supplier.setAddress(rs.getString("address"));
            supplier.setPhone(rs.getString("phone"));
            supplier.setEmail(rs.getString("email"));
            supplier.setFax(rs.getString("fax"));
            supplier.setNpwp(rs.getString("npwp"));
            supplier.setBankAccount(rs.getString("bankAccount"));
            suppliers.add(supplier);
            
        } 
        if(rs != null){
     	   try {
     		   rs.close();
     	   } catch (SQLException e) {
     		   System.out.println("Exception while closing result set: " + e);
     	   }
     	}
        closeConnection();
        return suppliers;
    }

	public void supplierDelete() throws SQLException{
		for(int i=0;i<argArray.size();i++) {
			idSupplier = argArray.get(i);
			this.run("supplierDelete", idSupplier);
			//closeConnection();
		}
    }

	public void supplierAdd() throws SQLException {
			argArray.add(0, supplier.getIdSupplier());
			argArray.add(1, supplier.getNmSupplier());
			argArray.add(2, supplier.getAddress());
			argArray.add(3, supplier.getPhone());
			argArray.add(4, supplier.getEmail());
			argArray.add(5, supplier.getFax());
			argArray.add(6, supplier.getNpwp());
			argArray.add(7, supplier.getBankAccount());
			this.run("supplierAdd", argArray);
			closeConnection();
    }
	
	public void supplierEdit() throws SQLException{
		argArray.add(0, supplier.getIdSupplier());
		argArray.add(1, supplier.getNmSupplier());
		argArray.add(2, supplier.getAddress());
		argArray.add(3, supplier.getPhone());
		argArray.add(4, supplier.getEmail());
		argArray.add(5, supplier.getFax());
		argArray.add(6, supplier.getNpwp());
		argArray.add(7, supplier.getBankAccount());
		argArray.add(8, supplier.getIdSupplier());
		this.run("supplierEdit", argArray);
		closeConnection();
	}

	
	public void setArgArray(ArrayList<String> argArray){
		this.argArray = argArray;
	}
	public ArrayList<String> getArgArray(){
		return argArray;
	}
	public String getIdSupplier(){
		return idSupplier;
	}
	public void setIdSupplier(String idSupplier){
		this.idSupplier = idSupplier;
	}
	public void setSuppliers(ArrayList<Supplier> suppliers){
		this.suppliers = suppliers;
	}
	public ArrayList<Supplier> getSuppliers(){
		return suppliers;
	}
	public Supplier getSupplier(){
		return supplier;
	}
	public void setSupplier(Supplier supplier){
		this.supplier = supplier;
	}
}