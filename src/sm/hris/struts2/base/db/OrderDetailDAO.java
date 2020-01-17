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
import sm.hris.struts2.base.db.CounterDAO;
import sm.hris.struts2.base.db.SmBaseDAO;

public class OrderDetailDAO extends SmBaseDAO{
 
	private Order order = new Order();
	private OrderDetail orderDetail = new OrderDetail();
	private CounterDAO counterDAO = new CounterDAO();
	private ArrayList<Order> orders = new ArrayList<Order>();
	private ArrayList<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
    private ArrayList<String> argArray = new ArrayList<String>();
    private ArrayList<Object> argArrayObj = new ArrayList<Object>();
    private ArrayList<ArrayList<String>> rowArray = new ArrayList<ArrayList<String>>();

	public ArrayList<OrderDetail> searchOrderDetail() throws SQLException{
        ResultSet rs = this.runQuery("searchOrderDetail");
 
            while (rs.next()) {
            	OrderDetail orderDetail = new OrderDetail();
            	orderDetail.setIdOrderDetail(rs.getString("idOrderDetail"));
            	orderDetail.setIdOrder(rs.getString("idOrder"));
            	orderDetail.setIdProduct(rs.getString("idProduct"));
            	orderDetail.setAmount(rs.getFloat("amount"));
            	orderDetail.setUnit(rs.getString("unit"));
            	orderDetail.setUnitPrice(rs.getFloat("UnitPrice"));
            	orderDetail.setSubTotal(rs.getFloat("subTotal"));
            	orderDetails.add(orderDetail);
                
            } 
        	
            if(rs != null){
     		   try {
     		   rs.close();
     		   } catch (SQLException e) {
     		        System.out.println("Exception while closing result set: " + e);
     		   }
     		}
        	closeConnection();
        	return orderDetails;
        
    }

	public ArrayList<OrderDetail> searchOrderDetailByIdOrder() throws SQLException{
        ResultSet rs = this.runQuery("searchOrderDetail",argArray);
 
        while (rs.next()) {
        	OrderDetail orderDetail = new OrderDetail();
        	orderDetail.setIdOrderDetail(rs.getString("idOrderDetail"));
        	orderDetail.setIdOrder(rs.getString("idOrder"));
        	orderDetail.setIdProduct(rs.getString("idProduct"));
        	orderDetail.setAmount(rs.getFloat("amount"));
        	orderDetail.setUnit(rs.getString("unit"));
        	orderDetail.setUnitPrice(rs.getFloat("unitPrice"));
        	orderDetail.setSubTotal(rs.getFloat("subTotal"));
        	orderDetails.add(orderDetail);
            
        } 
    	
        if(rs != null){
 		   try {
 		   rs.close();
 		   } catch (SQLException e) {
 		        System.out.println("Exception while closing result set: " + e);
 		   }
 		}
    	//closeConnection();
    	return orderDetails;
    
    }

	public String selectIdOrderDetailCounter() throws SQLException{
		String strIdOrderDetailCounter = counterDAO.selectIdOrderDetailCounter();
		return strIdOrderDetailCounter;
    }

	
	public void orderDetailAdd() throws SQLException{
		argArray.add(0, orderDetail.getIdOrder());
		argArray.add(1, orderDetail.getIdOrderDetail());
		argArray.add(2, orderDetail.getIdProduct());
		argArray.add(3, String.valueOf(orderDetail.getAmount()));
		argArray.add(4, orderDetail.getUnit());
		argArray.add(5, String.valueOf(orderDetail.getUnitPrice()));
		argArray.add(6, String.valueOf(orderDetail.getSubTotal()));
		this.run("orderDetailAdd", argArray);
		//closeConnection();
	}

	public void orderDetailEdit() throws SQLException{
		argArray.add(0, orderDetail.getIdOrder());
		argArray.add(1, orderDetail.getIdOrderDetail());
		argArray.add(2, orderDetail.getIdProduct());
		argArray.add(3, String.valueOf(orderDetail.getAmount()));
		argArray.add(4, orderDetail.getUnit());
		argArray.add(5, String.valueOf(orderDetail.getUnitPrice()));
		argArray.add(6, String.valueOf(orderDetail.getSubTotal()));
		argArray.add(7, orderDetail.getIdOrder());
		argArray.add(8, orderDetail.getIdOrderDetail());
		this.run("orderDetailEdit", argArray);
		//closeConnection();
	}

	public void orderDetailDelete() throws SQLException{
		for(int i=0;i<rowArray.size();i++) {
			this.run("orderItemDelete", rowArray.get(i));
		}
		closeConnection();
    }
	
	public void orderDetailDeleteByIdOrder() throws SQLException{
		for(int i=0;i<argArray.size();i++) {
			this.run("orderItemDeleteByIdOrder", argArray.get(i));
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

	public ArrayList<OrderDetail> getOrderDetails(){
		return orderDetails;
	} 
	
	public void setOrderDetails (ArrayList<OrderDetail> orderDetails){
		this.orderDetails = orderDetails;
	}

	public OrderDetail getOrderDetail(){
		return orderDetail;
	} 
	
	public void setOrderDetail (OrderDetail orderDetail){
		this.orderDetail = orderDetail;
	}
}