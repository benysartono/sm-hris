package sm.hris.struts2.base.db;
 
import java.util.ArrayList;
//import java.util.List;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import sm.hris.struts2.base.db.Buyer;
import sm.hris.struts2.base.db.BuyerSpec;
import sm.hris.struts2.base.db.SmBaseDAO;

public class BuyerDAO extends SmBaseDAO{
 
	private ArrayList<Buyer> buyers = new ArrayList<Buyer>();
	//private ArrayList<orderFR> ordersfr = new ArrayList<ordersFR>();
    private String idBuyer;
    private ArrayList<String> argArray = new ArrayList<String>();
    private ArrayList<String> idBuyerArray = new ArrayList<String>();
    private ArrayList<BuyerSpec> buyerSpecs = new ArrayList<BuyerSpec>();
    //private ArrayList<String> specs = new ArrayList<String>();

	public ArrayList<Buyer> searchBuyer() throws SQLException{
		//List<Employee> employeesList;
        ResultSet rs = this.runQuery("searchBuyer");
 
        while (rs.next()) {
            	Buyer buyer = new Buyer();
            	buyer.setIdBuyer(rs.getString("idBuyer"));
            	buyer.setAddress(rs.getString("address"));
            	buyer.setPhone(rs.getString("phone"));
            	buyer.setFax(rs.getString("fax"));
            	buyer.setEmail(rs.getString("email"));
            	buyer.setShippingAddress(rs.getString("shippingAddress"));
            	buyer.setBuyerName(rs.getString("buyerName"));

            	ArrayList<String> idBuyerArray = new ArrayList<String>();
            	idBuyerArray.add(rs.getString("idBuyer"));
            	ResultSet rs2 = this.runQuery("listSpecByIdBuyer",idBuyerArray);
            	while (rs2.next()){
            		BuyerSpec buyerSpec = new BuyerSpec();
            		buyerSpec.setIdBuyer(rs2.getString("idBuyer"));
            		buyerSpec.setIdSpec(rs2.getString("idSpec"));;
            		buyerSpecs.add(buyerSpec);
            	}
            	buyer.setBuyerSpecs(buyerSpecs);
            	buyers.add(buyer);
                
        } 
        	
        if(rs != null){
     		   try {
     		   rs.close();
     		   } catch (SQLException e) {
     		        System.out.println("Exception while closing result set: " + e);
     		   }
  		}
       	closeConnection();
        	
       	return buyers;
        
    }

	public ArrayList<Buyer> searchBuyerById(ArrayList<String> argArray) throws SQLException{
        ResultSet rs = this.runQuery("searchBuyerByIdBuyer",argArray);
 
        while (rs.next()) {
        	Buyer buyer = new Buyer();
        	buyer.setIdBuyer(rs.getString("idBuyer"));
        	buyer.setAddress(rs.getString("address"));
        	buyer.setPhone(rs.getString("phone"));
        	buyer.setFax(rs.getString("fax"));
        	buyer.setEmail(rs.getString("email"));
        	buyer.setShippingAddress(rs.getString("shippingAddress"));
        	buyer.setBuyerName(rs.getString("buyerName"));

        	ArrayList<String> idBuyerArray = new ArrayList<String>();
        	idBuyerArray.add(rs.getString("idBuyer"));
        	ResultSet rs2 = this.runQuery("listSpecByIdBuyer",idBuyerArray);
        	while (rs2.next()){
        		BuyerSpec buyerSpec = new BuyerSpec();
        		buyerSpec.setIdBuyer(rs2.getString("idBuyer"));
        		buyerSpec.setIdSpec(rs2.getString("idSpec"));;
        		buyerSpecs.add(buyerSpec);
        	}
        	buyer.setBuyerSpecs(buyerSpecs);
        	buyers.add(buyer);
            
        } 
        	
        if(rs != null){
     		   try {
     		   rs.close();
     		   } catch (SQLException e) {
     		        System.out.println("Exception while closing result set: " + e);
     		   }
   		}
       	closeConnection();
        	
       	return buyers;
        
    }

	public ArrayList<Buyer> searchBuyerByNameLike(ArrayList<String> argArray) throws SQLException{
        ResultSet rs = this.runQuery("searchBuyerByNameLike",argArray);
 
        while (rs.next()) {
        	Buyer buyer = new Buyer();
        	buyer.setIdBuyer(rs.getString("idBuyer"));
        	buyer.setAddress(rs.getString("address"));
        	buyer.setPhone(rs.getString("phone"));
        	buyer.setFax(rs.getString("fax"));
        	buyer.setEmail(rs.getString("email"));
        	buyer.setShippingAddress(rs.getString("shippingAddress"));
        	buyer.setBuyerName(rs.getString("buyerName"));

        	ArrayList<String> idBuyerArray = new ArrayList<String>();
        	idBuyerArray.add(rs.getString("idBuyer"));
        	ResultSet rs2 = this.runQuery("listSpecByIdBuyer",idBuyerArray);
        	while (rs2.next()){
        		BuyerSpec buyerSpec = new BuyerSpec();
        		buyerSpec.setIdBuyer(rs2.getString("idBuyer"));
        		buyerSpec.setIdSpec(rs2.getString("idSpec"));;
        		buyerSpecs.add(buyerSpec);
        	}
        	buyer.setBuyerSpecs(buyerSpecs);
        	buyers.add(buyer);
            
        } 
        	
        if(rs != null){
     		   try {
     		   rs.close();
     		   } catch (SQLException e) {
     		        System.out.println("Exception while closing result set: " + e);
     		   }
   		}
       	closeConnection();
        	
       	return buyers;
        
    }

	public void buyerDelete(ArrayList<String> idBuyers) throws SQLException{
		for(int i=0;i<idBuyers.size();i++) {
			idBuyer = argArray.get(i);
			ArrayList<String> argArray = new ArrayList<String>();
			argArray.add(0,idBuyer);
			this.run("buyerDelete", argArray);
			closeConnection();
		}
    }

/*
	public ArrayList<String> listSpecByIdBuyer(ArrayList<String> argArray) throws SQLException{
        ResultSet rs = this.runQuery("listSpecByIdBuyer",argArray);
 
        while (rs.next()) {
        	specs.add(rs.getString("idSpec"));
        } 
        	
        if(rs != null){
     		   try {
     		   rs.close();
     		   } catch (SQLException e) {
     		        System.out.println("Exception while closing result set: " + e);
     		   }
   		}
       	closeConnection();
        	
       	return specs;
        
    }
*/
	
	public ArrayList<BuyerSpec> searchBuyerSpecsByIdBuyer(ArrayList<String> argArray) throws SQLException{
        ResultSet rs = this.runQuery("searchBuyerSpecsByIdBuyer",argArray);
 
        while (rs.next()) {
        	BuyerSpec buyerSpec = new BuyerSpec();
        	buyerSpec.setIdBuyer(rs.getString("idBuyer"));
        	buyerSpec.setIdSpec(rs.getString("idSpec"));
        	buyerSpecs.add(buyerSpec);
        } 
        	
        if(rs != null){
     		   try {
     		   rs.close();
     		   } catch (SQLException e) {
     		        System.out.println("Exception while closing result set: " + e);
     		   }
   		}
       	closeConnection();
        	
       	return buyerSpecs;
        
    }	
}