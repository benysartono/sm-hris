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

public class OrderDAO extends SmBaseDAO{
 
	private Order order = new Order();
	private OrderItem orderItem = new OrderItem();
	private ArrayList<Order> orders = new ArrayList<Order>();
	private ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();
	//private ArrayList<orderFR> ordersfr = new ArrayList<ordersFR>();
    //private String idPO;
    private ArrayList<String> argArray = new ArrayList<String>();

	public ArrayList<Order> searchOrder() throws SQLException{
        ResultSet rs = this.runQuery("searchOrder");
 
            while (rs.next()) {
            	Order order = new Order();
            	order.setIdPO(rs.getString("idPO"));
            	order.setIdBuyer(rs.getString("idBuyer"));
            	order.setIdSpec(rs.getString("idSpec"));
            	order.setIdProduction(rs.getString("idProduction"));
            	order.setDate(rs.getDate("date"));
            	order.setTerms(rs.getString("terms"));
            	order.setIdShipVia(rs.getString("idShipVia"));
            	order.setShipDate(rs.getDate("shipDate"));
            	order.setFOB(rs.getString("FOB"));
            	order.setInWarehouse(rs.getDate("inWarehouse"));
            	order.setCancelation(rs.getDate("cancelation"));

            	orders.add(order);
                
            } 
        	
            if(rs != null){
     		   try {
     		   rs.close();
     		   } catch (SQLException e) {
     		        System.out.println("Exception while closing result set: " + e);
     		   }
     		}
        	closeConnection();
        	
        	return orders;
        
    }

	public ArrayList<Order> searchOrderByIdPO() throws SQLException{
		System.out.println("Isi Argument: " + argArray.get(0));
        ResultSet rs1 = this.runQuery("searchOrderByIdPO",argArray.get(0));
            while (rs1.next()) {
            	Order order = new Order();
            	order.setIdPO(rs1.getString("idPO"));
            	order.setIdBuyer(rs1.getString("idBuyer"));
            	order.setIdSpec(rs1.getString("idSpec"));
            	order.setIdProduction(rs1.getString("idProduction"));
            	order.setDate(rs1.getDate("date"));
            	order.setTerms(rs1.getString("terms"));
            	order.setIdShipVia(rs1.getString("idShipVia"));
            	order.setShipDate(rs1.getDate("shipDate"));
            	order.setFOB(rs1.getString("FOB"));
            	order.setInWarehouse(rs1.getDate("inWarehouse"));
            	order.setCancelation(rs1.getDate("cancelation"));

            	// --- Iterating OrderItems ---//
            	ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();
            	ArrayList<String> argArray1 = new ArrayList<String>();
            	argArray1.add(rs1.getString("idPO"));
            	ResultSet rsItem = this.runQuery("searchOrderItem",argArray1);
            	while (rsItem.next()){
            		OrderItem orderItem = new OrderItem();
            		orderItem.setIdPO(rsItem.getString("idPO"));
            		orderItem.setIdItem(rsItem.getInt("idItem"));
            		orderItem.setIdColor(rsItem.getString("idColor"));
            		orderItem.setQty(rsItem.getInt("qty"));
            		orderItem.setDescription(rsItem.getString("description"));
            		orderItem.setUnitPrice(rsItem.getInt("unitPrice"));
            		orderItem.setExtendedPrice(rsItem.getInt("extPrice"));
            		orderItems.add(orderItem);
            	}
                if(rsItem != null){
       			   System.out.println("RSITEM tidak null");
          		   try {
          			   rsItem.close();
          		   } catch (SQLException e) {
          		        System.out.println("Exception while closing result set: " + e);
          		   }
          		}

            	order.setOrderItems(orderItems);
            	orders.add(order);
                
            } 
        	
            if(rs1 != null){
  			   System.out.println("RS1 tidak null");
     		   try {
     			   rs1.close();
     		   } catch (SQLException e) {
     		        System.out.println("Exception while closing result set: " + e);
     		   }
     		}
        	closeConnection();
        	
        	return orders;
        
    }

	public ArrayList<Order> searchOrderByIdPOLike() throws SQLException{
        ResultSet rs = this.runQuery("searchOrderByIdPOLike",argArray);
 
            while (rs.next()) {
            	Order order = new Order();
            	order.setIdPO(rs.getString("idPO"));
            	order.setIdBuyer(rs.getString("idBuyer"));
            	order.setIdSpec(rs.getString("idSpec"));
            	order.setIdProduction(rs.getString("idProduction"));
            	order.setDate(rs.getDate("date"));
            	order.setTerms(rs.getString("terms"));
            	order.setIdShipVia(rs.getString("idShipVia"));
            	order.setShipDate(rs.getDate("shipDate"));
            	order.setFOB(rs.getString("FOB"));
            	order.setInWarehouse(rs.getDate("inWarehouse"));
            	order.setCancelation(rs.getDate("cancelation"));

            	// --- Iterating OrderItems ---//
            	ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();
            	ArrayList<String> argArray1 = new ArrayList<String>();
            	argArray1.add(rs.getString("idPO"));
            	ResultSet rsItem = this.runQuery("searchOrderItem",argArray1);
            	while (rsItem.next()){
            		OrderItem orderItem = new OrderItem();
            		orderItem.setIdPO(rsItem.getString("idPO"));
            		orderItem.setIdItem(rsItem.getInt("idItem"));
            		orderItem.setIdColor(rsItem.getString("idColor"));
            		orderItem.setQty(rsItem.getInt("qty"));
            		orderItem.setDescription(rsItem.getString("description"));
            		orderItem.setUnitPrice(rsItem.getInt("unitPrice"));
            		orderItem.setExtendedPrice(rsItem.getInt("extPrice"));
            		orderItems.add(orderItem);
            	}
            	order.setOrderItems(orderItems);
            	orders.add(order);
                
            } 
        	
            if(rs != null){
     		   try {
     		   rs.close();
     		   } catch (SQLException e) {
     		        System.out.println("Exception while closing result set: " + e);
     		   }
     		}
        	closeConnection();
        	
        	return orders;
        
    }

	public void orderDelete() throws SQLException{
		for(int i=0;i<argArray.size();i++) {
			this.run("orderDelete", argArray.get(i));
			this.run("orderItemDeleteByIdPO", argArray.get(i));
		}
		closeConnection();
    }

	public void orderAdd() throws SQLException{
			argArray.add(0, order.getIdPO());
			argArray.add(1, order.getIdBuyer());
			argArray.add(2, order.getIdSpec());
			argArray.add(3, order.getIdProduction());
			String cvtDate = convertDateToString(order.getDate());
			argArray.add(4, cvtDate);
			argArray.add(5, order.getTerms());
			argArray.add(6, order.getIdShipVia());
			cvtDate = convertDateToString(order.getShipDate());
			argArray.add(7, cvtDate);
			argArray.add(8, order.getFOB());
			cvtDate = convertDateToString(order.getInWarehouse());
			argArray.add(9, cvtDate);
			cvtDate = convertDateToString(order.getCancelation());
			argArray.add(10, cvtDate);
			this.run("orderAdd", argArray);
			closeConnection();
    }
	
	public void orderItemAdd() throws SQLException{
			ArrayList<String> argArrayItem = new ArrayList<String>(); 
			argArrayItem.add(0, orderItem.getIdPO());
			//argArrayItem.add(1, String.valueOf(orderItem.getIdItem()));
			argArrayItem.add(1, orderItem.getIdColor());
			argArrayItem.add(2, String.valueOf(orderItem.getQty()));
			argArrayItem.add(3, orderItem.getDescription());
			argArrayItem.add(4, String.valueOf(orderItem.getUnitPrice()));
			argArrayItem.add(5, String.valueOf(orderItem.getExtendedPrice()));
			this.run("orderItemAdd", argArrayItem);
			//closeConnection();
    }

	
	public void orderEdit() throws SQLException{
		argArray.add(0, order.getIdPO());
		argArray.add(1, order.getIdBuyer());
		argArray.add(2, order.getIdSpec());
		argArray.add(3, order.getIdProduction());
		String cvtDate = convertDateToString(order.getDate());
		argArray.add(4, cvtDate);
		argArray.add(5, order.getTerms());
		argArray.add(6, order.getIdShipVia());
		cvtDate = convertDateToString(order.getShipDate());
		argArray.add(7, cvtDate);
		argArray.add(8, order.getFOB());
		cvtDate = convertDateToString(order.getInWarehouse());
		argArray.add(9, cvtDate);
		cvtDate = convertDateToString(order.getCancelation());
		argArray.add(10, cvtDate);
		argArray.add(11, order.getIdPO());
		System.out.println("PrintOut OrderArgArray: " + argArray);
		this.run("orderEdit", argArray);
		for(OrderItem oi : order.getOrderItems()){
			if (oi.getIdItem() != null) {
				System.out.println("Anda ada di dalam Order Item Edit");
				ArrayList<String> argArrayItem = new ArrayList<String>(); 
				argArrayItem.add(0, oi.getIdPO());
				argArrayItem.add(1, String.valueOf(oi.getIdItem()));
				argArrayItem.add(2, oi.getIdColor());
				argArrayItem.add(3, String.valueOf(oi.getQty()));
				argArrayItem.add(4, oi.getDescription());
				argArrayItem.add(5, String.valueOf(oi.getUnitPrice()));
				argArrayItem.add(6, String.valueOf(oi.getExtendedPrice()));
				argArrayItem.add(7, oi.getIdPO());
				argArrayItem.add(8, String.valueOf(oi.getIdItem()));
				System.out.println("PrintOut OrderItemArgArray: " + argArrayItem);
				this.run("orderItemEdit", argArrayItem);
			}
				
		}	
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

	public void orderItemDelete() throws SQLException{
		for(int i=0;i<argArray.size();i++) {
			this.run("orderItemDelete", argArray.get(i));
		}
		//closeConnection();
    }
	
	public Order getOrder(){
		return order;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
	public OrderItem getOrderItem(){
		return orderItem;
	}
	
	public void setOrderItem(OrderItem orderItem){
		this.orderItem = orderItem;
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}
	
	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}



	public ArrayList<String> getArgArray() {
		return argArray;
	}
	
	public void setArgArray(ArrayList<String> argArray) {
		this.argArray = argArray;
	}

	public ArrayList<OrderItem> getOrderItems(){
		return orderItems;
	} 
	
	public void setOrderItems (ArrayList<OrderItem> orderItems){
		this.orderItems = orderItems;
	}
	
}