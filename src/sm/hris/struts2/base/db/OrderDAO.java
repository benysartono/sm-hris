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
import sm.hris.struts2.base.db.OrderDetail;
import sm.hris.struts2.base.db.OrderDetailDAO;
import sm.hris.struts2.base.db.CounterDAO;
import sm.hris.struts2.base.db.SmBaseDAO;

public class OrderDAO extends SmBaseDAO{
 
	private Order order = new Order();
	private OrderDetail orderDetail = new OrderDetail();
	private OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
	private ArrayList<Order> orders = new ArrayList<Order>();
	private ArrayList<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
	//private ArrayList<orderFR> ordersfr = new ArrayList<ordersFR>();
    private ArrayList<String> argArray = new ArrayList<String>();
    private CounterDAO counterDAO = new CounterDAO();
    private String strIdOrderCounter;

	public ArrayList<Order> searchOrder() throws SQLException{
        ResultSet rs = this.runQuery("searchOrder");
            while (rs.next()) {
            	Order order = new Order();
            	order.setIdOrder(rs.getString("idOrder"));
            	order.setTotal(rs.getFloat("total"));
            	order.setTotalDiscount(rs.getFloat("totalDiscount"));
            	order.setVat(rs.getFloat("vat"));
            	order.setGrandTotal(rs.getFloat("grandTotal"));
            	order.setCash(rs.getFloat("cash"));
            	order.setChanges(rs.getFloat("changes"));
            	order.setIdPaymentMethod(rs.getString("idPaymentMethod"));
            	order.setPaymentRemark(rs.getString("paymentRemark"));
            	order.setOrderDate(rs.getDate("orderDate"));
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

	public ArrayList<Order> searchOrderByIdOrder() throws SQLException{
		System.out.println("Arg Array Get 0 nya:" + argArray.get(0));
        ResultSet rs = this.runQuery("searchOrderByIdOrder",argArray.get(0));
            while (rs.next()) {
            	Order order = new Order();
            	OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
            	order.setIdOrder(rs.getString("idOrder"));
            	order.setTotal(rs.getFloat("total"));
            	order.setTotalDiscount(rs.getFloat("totalDiscount"));
            	order.setVat(rs.getFloat("vat"));
            	order.setGrandTotal(rs.getFloat("grandTotal"));
            	order.setCash(rs.getFloat("cash"));
            	order.setChanges(rs.getFloat("changes"));
            	order.setIdPaymentMethod(rs.getString("idPaymentMethod"));
            	order.setPaymentRemark(rs.getString("paymentRemark"));
            	order.setOrderDate(rs.getDate("orderDate"));
            	ArrayList<String> argArray = new ArrayList<String>();
            	argArray.add(rs.getString("idOrder"));
            	orderDetailDAO.setArgArray(argArray);
            	order.setOrderDetails(orderDetailDAO.searchOrderDetailByIdOrder());
            	orders.add(order);
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
        	return orders;
        
    }

	public ArrayList<Order> searchOrderByAnyLike() throws SQLException{
        ResultSet rs = this.runQuery("searchOrderByAnyLike",argArray);
 
        while (rs.next()) {
        	Order order = new Order();
        	order.setIdOrder(rs.getString("idOrder"));
        	order.setTotal(rs.getFloat("total"));
        	order.setTotalDiscount(rs.getFloat("totalDiscount"));
        	order.setVat(rs.getFloat("vat"));
        	order.setGrandTotal(rs.getFloat("grandTotal"));
        	order.setCash(rs.getFloat("cash"));
        	order.setChanges(rs.getFloat("changes"));
        	order.setIdPaymentMethod(rs.getString("idPaymentMethod"));
        	order.setPaymentRemark(rs.getString("paymentRemark"));
        	order.setOrderDate(rs.getDate("orderDate"));
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
			ArrayList<String> argArray2 = new ArrayList<String>();
			argArray2.add(argArray.get(i));
			orderDetailDAO.setArgArray(argArray2);
			orderDetailDAO.orderDetailDeleteByIdOrder();
			this.run("orderDelete", argArray.get(i));
		}
		closeConnection();
    }

	public String orderAdd() throws SQLException{
		setStrIdOrderCounter(counterDAO.selectIdOrderCounter());
		argArray.add(0, strIdOrderCounter);
		argArray.add(1, convertDateToString(order.getOrderDate()));
		this.run("orderAdd", argArray);
		closeConnection();
		return strIdOrderCounter;
    }
	
	public void orderEdit() throws SQLException{
		argArray.add(0, order.getIdOrder());
		argArray.add(1, String.valueOf(order.getTotal()));
		argArray.add(2, String.valueOf(order.getTotalDiscount()));
		argArray.add(3, String.valueOf(order.getVat()));
		argArray.add(4, String.valueOf(order.getCash()));
		argArray.add(5, String.valueOf(order.getChanges()));
		argArray.add(6, order.getIdPaymentMethod());
		argArray.add(7, order.getPaymentRemark());
		argArray.add(8, convertDateToString(order.getOrderDate()));
		argArray.add(9, String.valueOf(order.getGrandTotal()));
		argArray.add(10, order.getIdOrder());
		this.run("orderEdit", argArray);
		ArrayList<String> argArray = new ArrayList<String>();
		argArray.add(order.getIdOrder());
		orderDetailDAO.setArgArray(argArray);
		orderDetailDAO.orderDetailDeleteByIdOrder();
		for (int n=0;n<orderDetails.size();n++){
			orderDetailDAO.setOrderDetail(orderDetails.get(n));
			orderDetailDAO.orderDetailAdd();
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
	
//Getter Setter -------------------------------------//

	public Order getOrder(){
		return order;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
	public OrderDetail getOrderDetail(){
		return orderDetail;
	}
	
	public void setOrderItem(OrderDetail orderDetail){
		this.orderDetail = orderDetail;
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

	public ArrayList<OrderDetail> getOrderDetails(){
		return orderDetails;
	} 
	
	public void setOrderDetails (ArrayList<OrderDetail> orderDetails){
		this.orderDetails = orderDetails;
	}
	
	public String getStrIdOrderCounter(){
		return strIdOrderCounter;
	} 
	
	public void setStrIdOrderCounter(String strIdOrderCounter){
		this.strIdOrderCounter = strIdOrderCounter;
	} 
	
}