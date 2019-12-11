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

public class IndexEditAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
	private Order order = new Order();
	private OrderDetail orderItem = new OrderDetail();
    private ArrayList<OrderDetail> orderItems = new ArrayList<OrderDetail>();
	private OrderDAO orderDAO = new OrderDAO();
	private OrderDetailDAO orderItemDAO = new OrderDetailDAO();
	private ArrayList<String> argArray = new ArrayList<String>();
	private ArrayList<String> idItemsCheck = new ArrayList<String>();
	private String proc = new String();
	
	private ArrayList<String> orderItemIdPO = new ArrayList<String>();
	private ArrayList<String> orderItemIdItem = new ArrayList<String>();
	private ArrayList<String> orderItemIdColor = new ArrayList<String>();
	private ArrayList<Integer> orderItemQty = new ArrayList<Integer>();
	private ArrayList<String> orderItemDescription = new ArrayList<String>();
	private ArrayList<Integer> orderItemUnitPrice = new ArrayList<Integer>();
	private ArrayList<Integer> orderItemExtendedPrice = new ArrayList<Integer>();
	
	
    //private OrderDetail 
	//private OrderDetail orderItem;
    
    public String execute() throws Exception{
    	System.out.println("Sudah ada di dalam IndexEditAction");
    	if (proc.equals("Save")){
    		System.out.println("Nilai Proc :::: " + proc);
    		for(int n=0;n<orderItemIdPO.size();n++){
    			OrderDetail orderItem = new OrderDetail(); 
    			orderItem.setIdPO(orderItemIdPO.get(n));
    			orderItem.setIdItem(Integer.parseInt(orderItemIdItem.get(n)));
    			orderItem.setIdColor(orderItemIdColor.get(n));
    			orderItem.setQty(orderItemQty.get(n));
    			orderItem.setDescription(orderItemDescription.get(n));
    			orderItem.setUnitPrice(orderItemUnitPrice.get(n));
    			orderItem.setExtendedPrice(orderItemExtendedPrice.get(n));
    			orderItems.add(orderItem);
    		}	
    		order.setOrderItems(orderItems);
    		System.out.println("PrintOut OrderItems: " + orderItems);
    		orderDAO.setOrder(order);
    		System.out.println("PrintOut Order: " + order);
    		orderDAO.orderEdit();
    	} 
    	else if (proc.equals("Delete")){
    		orderDAO.setArgArray(idItemsCheck);
    		orderDAO.orderItemDelete();
    		argArray = new ArrayList<String>();
	   		argArray.add(0,order.getIdPO());
	   		orderDAO.setArgArray(argArray);
	   		order = orderDAO.searchOrderByIdPO().get(0);
    	}
    	else if (proc.equals("Add")){
    		argArray = new ArrayList<String>();
	   		argArray.add(0,order.getIdPO());
	   		orderDAO.setArgArray(argArray);
	   		order = orderDAO.searchOrderByIdPO().get(0);
    		return "add";
    	}
    	else if (proc.equals("SaveItem")){
    		System.out.println("Anda berada di SaveItem: " + orderItem.getIdPO());
    		orderDAO.setOrderItem(orderItem);
    		orderDAO.orderItemAdd();
    		argArray = new ArrayList<String>();
    		System.out.println("orderItem.getIdPO() nya: " + orderItem.getIdPO());
	   		argArray.add(0,orderItem.getIdPO());
	   		orderDAO.setArgArray(argArray);
	   		order = orderDAO.searchOrderByIdPO().get(0);
    	}
    	else {
	   		//orderDAO.setArgArray(null);
	   		argArray.add(0,order.getIdPO());
	   		orderDAO.setArgArray(argArray);
	   		order = orderDAO.searchOrderByIdPO().get(0);
    	}
   		return SUCCESS;
    }
    /*
	public ArrayList<OrderDetail> getOrderItems(){
			//return orderItems;
		}
			
	public void setOrderItems(ArrayList<OrderDetail> orderItems){
			//this.orderItems=orderItems;
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
	
	public OrderDetail getOrderItem(){
		return orderItem;
	} 
	
	public void setOrderItem (OrderDetail orderItem){
		this.orderItem = orderItem;
	}

	
	public ArrayList<OrderDetail> getOrderItems(){
		return orderItems;
	} 
	
	public void setOrderItems (ArrayList<OrderDetail> orderItems){
		this.orderItems = orderItems;
	}

	public ArrayList<String> getOrderItemIdPO(){
		return orderItemIdPO;
	}
	public void setOrderItemIdPO(ArrayList<String> orderItemIdPO){
		this.orderItemIdPO = orderItemIdPO;
	}

	
	public ArrayList<String> getOrderItemIdItem(){
		return orderItemIdItem;
	}
	public void setOrderItemIdItem(ArrayList<String> orderItemIdItem){
		this.orderItemIdItem = orderItemIdItem;	
	}
	
	
	public ArrayList<String> getOrderItemIdColor(){
		return orderItemIdColor;
	}
	public void setOrderItemIdColor(ArrayList<String> orderItemIdColor){
		this.orderItemIdColor = orderItemIdColor;
	}
	
	public ArrayList<Integer> getOrderItemQty(){
		return orderItemQty;
	}
	public void setOrderItemQty(ArrayList<Integer> orderItemQty){
		this.orderItemQty = orderItemQty;
	}

	public ArrayList<String> getOrderItemDescription(){
		return orderItemDescription;
	}
	public void setOrderItemDescription(ArrayList<String> orderItemDescription){
		this.orderItemDescription = orderItemDescription;
	}

	public ArrayList<Integer> getOrderItemUnitPrice(){
		return orderItemUnitPrice;
	}
	public void setOrderItemUnitPrice(ArrayList<Integer> orderItemUnitPrice){
		this.orderItemUnitPrice = orderItemUnitPrice;
	}

	public ArrayList<Integer> getOrderItemExtendedPrice(){
		return orderItemExtendedPrice;
	}
	
	public void setOrderItemExtendedPrice(ArrayList<Integer> orderItemExtendedPrice){
		this.orderItemExtendedPrice = orderItemExtendedPrice;
	}

	public ArrayList<String> getIdItemsCheck(){
		return idItemsCheck;
	}
	public void setIdItemsCheck(ArrayList<String> idItemsCheck){
		this.idItemsCheck = idItemsCheck;
	}


}
