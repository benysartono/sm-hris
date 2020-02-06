package sm.hris.struts2.base.db;
 
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;
import sm.hris.struts2.base.db.Discount;
import sm.hris.struts2.base.db.SmBaseDAO;

public class DiscountDAO extends SmBaseDAO{
 
	private Discount discount = new Discount();
	private ArrayList<Discount> discounts = new ArrayList<Discount>();
    private ArrayList<String> argArray = new ArrayList<String>();
    private ArrayList<ArrayList<String>> argArray2 = new ArrayList<ArrayList<String>>();

	public ArrayList<Discount> searchDiscount() throws SQLException{
        ResultSet rs = this.runQuery("searchDiscount");
        if(rs != null){
            while (rs.next()) {
            	Discount discount = new Discount();
            	discount.setIdProduct(rs.getString("idProduct"));
            	discount.setDiscount(rs.getInt("discount"));
            	discount.setStartTime(rs.getDate("startTime"));
            	discount.setEndTime(rs.getDate("endTime"));
            	discounts.add(discount);
            } 
        	
     		   try {
     		   rs.close();
     		   } catch (SQLException e) {
     		        System.out.println("Exception while closing result set: " + e);
     		   }
   		}
        closeConnection();
        return discounts;
        
    }

	public ArrayList<Discount> searchDiscountByIdProduct() throws SQLException{
        ResultSet rs = this.runQuery("searchDiscountByIdProduct",argArray.get(0));
            while (rs.next()) {
            	Discount discount = new Discount();
            	discount.setIdProduct(rs.getString("idProduct"));
            	discount.setDiscount(rs.getInt("discount"));
            	discount.setStartTime(rs.getDate("startTime"));
            	discount.setEndTime(rs.getDate("endTime"));
            	discounts.add(discount);
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
        	return discounts;
        
    }

	public ArrayList<Discount> searchDiscountByAnyLike() throws SQLException{
        ResultSet rs = this.runQuery("searchDiscountByAnyLike",argArray);
 
        while (rs.next()) {
        	Discount discount = new Discount();
        	discount.setIdProduct(rs.getString("idProduct"));
        	discount.setDiscount(rs.getInt("discount"));
        	discount.setStartTime(rs.getDate("startTime"));
        	discount.setEndTime(rs.getDate("endTime"));
        	discounts.add(discount);
        } 
        if(rs != null){
     	   try {
     	   rs.close();
     	   } catch (SQLException e) {
     	        System.out.println("Exception while closing result set: " + e);
     	   }
     	}
        closeConnection();
        return discounts;
        
    }

	public void discountDelete() throws SQLException{
		for(int i=0;i<discounts.size();i++) {
			argArray.add(0, discounts.get(i).getIdProduct());
			String cvtDate = convertDateToString(discounts.get(i).getStartTime());
			argArray.add(1, cvtDate);
			cvtDate = convertDateToString(discounts.get(i).getEndTime());
			argArray.add(2, cvtDate);
			this.run("discountDelete", argArray);
		}
		closeConnection();
    }

	public void discountAdd() throws SQLException{
		argArray.add(0, discount.getIdProduct());
		argArray.add(1,String.valueOf(discount.getDiscount()));
		String cvtDate = convertDateToString(discount.getStartTime());
		argArray.add(2, cvtDate);
		cvtDate = convertDateToString(discount.getEndTime());
		argArray.add(3, cvtDate);
		this.run("discountAdd", argArray);
		closeConnection();
    }
	
	public void discountEdit() throws SQLException{
		argArray.add(0, discount.getIdProduct());
		
		argArray.add(1,String.valueOf(discount.getDiscount()));
		
		String cvtDate = convertDateToString(discount.getStartTime());
		argArray.add(2, cvtDate);
		
		cvtDate = convertDateToString(discount.getEndTime());
		argArray.add(3, cvtDate);
		
		argArray.add(4, discount.getIdProduct());
		
		cvtDate = convertDateToString(discount.getStartTime());
		argArray.add(5, cvtDate);
		
		cvtDate = convertDateToString(discount.getEndTime());
		argArray.add(6, cvtDate);
		
		this.run("discountEdit", argArray);
		closeConnection();
	}

	public String convertDateToString(Date indate)
	{
	   String dateString = null;
	   SimpleDateFormat sdfr = new SimpleDateFormat("yyyy/MM/dd");
	   /*you can also use DateFormat reference instead of SimpleDateFormat 
	    * like this: DateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
	    */
	   try{
		dateString = sdfr.format( indate );
	   }catch (Exception ex ){
		System.out.println(ex);
	   }
	   return dateString;
	}
	
//Getter Setter -------------------------------------//

	public Discount getDiscount(){
		return discount;
	}
	
	public void setDiscount(Discount discount) {
		this.discount = discount;
	}
	
	public ArrayList<Discount> getDiscounts() {
		return discounts;
	}
	
	public void setDiscounts(ArrayList<Discount> discounts) {
		this.discounts = discounts;
	}

	public ArrayList<String> getArgArray() {
		return argArray;
	}
	
	public void setArgArray(ArrayList<String> argArray) {
		this.argArray = argArray;
	}

	public ArrayList<ArrayList<String>> getArgArray2() {
		return argArray2;
	}
	
	public void setArgArray2(ArrayList<ArrayList<String>> argArray2) {
		this.argArray2 = argArray2;
	}
	
}