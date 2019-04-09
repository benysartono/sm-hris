package sm.hris.struts2.base.db;
 
import java.util.ArrayList;
//import java.util.List;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import sm.hris.struts2.base.db.Order;
import sm.hris.struts2.base.db.OrderItem;
import sm.hris.struts2.base.db.SmBaseDAO;

public class OrderItemDAO extends SmBaseDAO{
 
	private Order order = new Order();
	private OrderItem orderItem = new OrderItem();
	private ArrayList<Order> orders = new ArrayList<Order>();
	private ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();
    private ArrayList<String> argArray = new ArrayList<String>();
    private ArrayList<Object> argArrayObj = new ArrayList<Object>();
    private ArrayList<ArrayList<String>> rowArray = new ArrayList<ArrayList<String>>();

	public ArrayList<OrderItem> searchOrderItem() throws SQLException{
        ResultSet rs = this.runQuery("searchOrderItem",argArray);
 
            while (rs.next()) {
            	OrderItem orderItem = new OrderItem();
            	orderItem.setIdItem(rs.getInt("idItem"));
            	orderItem.setIdPO(rs.getString("idPO"));
            	orderItem.setIdColor(rs.getString("idColor"));
            	orderItem.setQty(rs.getInt("qty"));
            	orderItem.setDescription(rs.getString("description"));
            	orderItem.setUnitPrice(rs.getInt("UnitPrice"));
            	orderItem.setExtendedPrice(rs.getInt("extPrice"));
            	orderItems.add(orderItem);
                
            } 
        	
            if(rs != null){
     		   try {
     		   rs.close();
     		   } catch (SQLException e) {
     		        System.out.println("Exception while closing result set: " + e);
     		   }
     		}
        	closeConnection();
        	
        	return orderItems;
        
    }

	public ArrayList<OrderItem> searchOrderItemByIdPOnPage() throws SQLException{
        ResultSet rs = this.runQueryObj("searchOrderItemByIdPOnPage",argArrayObj);
 
            while (rs.next()) {
            	OrderItem orderItem = new OrderItem();
            	orderItem.setIdItem(rs.getInt("idItem"));
            	orderItem.setIdPO(rs.getString("idPO"));
            	orderItem.setIdColor(rs.getString("idColor"));
            	orderItem.setQty(rs.getInt("qty"));
            	orderItem.setDescription(rs.getString("description"));
            	orderItem.setUnitPrice(rs.getInt("UnitPrice"));
            	orderItem.setExtendedPrice(rs.getInt("extPrice"));
            	orderItems.add(orderItem);
                
            } 
        	
            if(rs != null){
     		   try {
     		   rs.close();
     		   } catch (SQLException e) {
     		        System.out.println("Exception while closing result set: " + e);
     		   }
     		}
        	closeConnection();
        	
        	return orderItems;
        
    }

	public void orderItemDelete() throws SQLException{
		for(int i=0;i<rowArray.size();i++) {
			this.run("orderItemDelete", rowArray.get(i));
		}
		closeConnection();
    }
	
	public void orderItemDeleteByIdPO() throws SQLException{
		for(int i=0;i<argArray.size();i++) {
			this.run("orderItemDeleteByIdPO", argArray.get(i));
		}
		closeConnection();
    }

	public ArrayList<String> getArgArray() {
		return argArray;
	}
	
	public void setArgArray(ArrayList<String> argArray) {
		this.argArray = argArray;
	}

	public ArrayList<Object> getArgArrayObj() {
		return argArrayObj;
	}
	
	public void setArgArrayObj(ArrayList<Object> argArrayObj) {
		this.argArrayObj = argArrayObj;
	}

	public ArrayList<ArrayList<String>> getRowArray() {
		return rowArray;
	}
	
	public void setRowArray(ArrayList<ArrayList<String>> rowArray) {
		this.rowArray = rowArray;
	}

	public ArrayList<OrderItem> getOrderItems(){
		return orderItems;
	} 
	
	public void setOrderItems (ArrayList<OrderItem> orderItems){
		this.orderItems = orderItems;
	}

	public OrderItem getOrderItem(){
		return orderItem;
	} 
	
	public void setOrderItem (OrderItem orderItem){
		this.orderItem = orderItem;
	}
}