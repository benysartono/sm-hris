package sm.hris.struts2.base.modules.order;


import java.util.ArrayList;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.Order;
import sm.hris.struts2.base.db.OrderDetail;
import sm.hris.struts2.base.db.OrderDAO;
import sm.hris.struts2.base.db.OrderDetailDAO;

@Results({
	@Result(name="tolist", location="/base/modules/order", type="redirect"),
	})
@ParentPackage(value = "hris")

public class IndexEditTestAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
	private Order order = new Order();
	private OrderDetail orderDetail = new OrderDetail();
    private ArrayList<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
	private OrderDAO orderDAO = new OrderDAO();
	private OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
	private ArrayList<String> argArray = new ArrayList<String>();
	private ArrayList<String> idItemsCheck = new ArrayList<String>();
	private String proc = new String();
	
	private ArrayList<String> orderDetailIdPO = new ArrayList<String>();
	private ArrayList<String> orderDetailIdItem = new ArrayList<String>();
	private ArrayList<String> orderDetailIdColor = new ArrayList<String>();
	private ArrayList<Integer> orderDetailQty = new ArrayList<Integer>();
	private ArrayList<String> orderDetailDescription = new ArrayList<String>();
	private ArrayList<Integer> orderDetailUnitPrice = new ArrayList<Integer>();
	private ArrayList<Integer> orderDetailExtendedPrice = new ArrayList<Integer>();
	
	
    //private OrderDetail 
	//private OrderDetail orderDetail;
    
    public String execute() throws Exception{
    	System.out.println("Sudah ada di dalam IndexEditAction");
    	if (proc.equals("Save")){
    		System.out.println("Sudah ada dalam Proc Save");
    		//order.setOrderDetails(orderDetails);
    		order.setOrderDetails(orderDetails);
    		orderDAO.setOrder(order);
    		orderDAO.orderEdit();
    		return SUCCESS;
	   		//order = orderDAO.searchOrderByIdPO().get(0);
    	} 
    	else if (proc.equals("Delete")){
    		orderDetailDAO.setArgArray(idItemsCheck);
    		orderDetailDAO.orderDetailDelete();
    		argArray = new ArrayList<String>();
	   		argArray.add(0,order.getIdOrder());
	   		orderDAO.setArgArray(argArray);
	   		order = orderDAO.searchOrderByIdOrder().get(0);
    	}
    	else if (proc.equals("Add")){
    		argArray = new ArrayList<String>();
	   		argArray.add(0,order.getIdOrder());
	   		orderDAO.setArgArray(argArray);
	   		order = orderDAO.searchOrderByIdOrder().get(0);
    		return "add";
    	}
    	else {
	   		//orderDAO.setArgArray(null);
	   		argArray.add(0,order.getIdOrder());
	   		orderDAO.setArgArray(argArray);
	   		order = orderDAO.searchOrderByIdOrder().get(0);
    	}
   		return SUCCESS;
    }
    /*
	public ArrayList<OrderDetail> getOrderDetails(){
			//return orderDetails;
		}
			
	public void setOrderDetails(ArrayList<OrderDetail> orderDetails){
			//this.orderDetails=orderDetails;
		}
	*/
	public Order getOrder(){
		return order;
	}
	
	public void setOrder(Order order){
		this.order = order;
	}
	
	public void setProc(String proc) {
        this.proc = proc;
    }
	
	public OrderDetail getOrderDetail(){
		return orderDetail;
	} 
	
	public void setOrderDetail (OrderDetail orderDetail){
		this.orderDetail = orderDetail;
	}

	
	public ArrayList<OrderDetail> getOrderDetails(){
		return orderDetails;
	} 
	
	public void setOrderDetails (ArrayList<OrderDetail> orderDetails){
		this.orderDetails = orderDetails;
	}

	public ArrayList<String> getOrderDetailIdPO(){
		return orderDetailIdPO;
	}
	public void setOrderDetailIdPO(ArrayList<String> orderDetailIdPO){
		this.orderDetailIdPO = orderDetailIdPO;
	}

	
	public ArrayList<String> getOrderDetailIdItem(){
		return orderDetailIdItem;
	}
	public void setOrderDetailIdItem(ArrayList<String> orderDetailIdItem){
		this.orderDetailIdItem = orderDetailIdItem;	
	}
	
	
	public ArrayList<String> getOrderDetailIdColor(){
		return orderDetailIdColor;
	}
	public void setOrderDetailIdColor(ArrayList<String> orderDetailIdColor){
		this.orderDetailIdColor = orderDetailIdColor;
	}
	
	public ArrayList<Integer> getOrderDetailQty(){
		return orderDetailQty;
	}
	public void setOrderDetailQty(ArrayList<Integer> orderDetailQty){
		this.orderDetailQty = orderDetailQty;
	}

	public ArrayList<String> getOrderDetailDescription(){
		return orderDetailDescription;
	}
	public void setOrderDetailDescription(ArrayList<String> orderDetailDescription){
		this.orderDetailDescription = orderDetailDescription;
	}

	public ArrayList<Integer> getOrderDetailUnitPrice(){
		return orderDetailUnitPrice;
	}
	public void setOrderDetailUnitPrice(ArrayList<Integer> orderDetailUnitPrice){
		this.orderDetailUnitPrice = orderDetailUnitPrice;
	}

	public ArrayList<Integer> getOrderDetailExtendedPrice(){
		return orderDetailExtendedPrice;
	}
	
	public void setOrderDetailExtendedPrice(ArrayList<Integer> orderDetailExtendedPrice){
		this.orderDetailExtendedPrice = orderDetailExtendedPrice;
	}

	public ArrayList<String> getIdItemsCheck(){
		return idItemsCheck;
	}
	public void setIdItemsCheck(ArrayList<String> idItemsCheck){
		this.idItemsCheck = idItemsCheck;
	}


}
