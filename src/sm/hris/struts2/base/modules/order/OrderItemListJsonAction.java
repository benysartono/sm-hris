package sm.hris.struts2.base.modules.order;

import java.util.ArrayList;

import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.OrderItem;
import sm.hris.struts2.base.db.OrderItemDAO;
import sm.hris.struts2.base.db.Order;
import sm.hris.struts2.base.db.OrderDAO;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

@Result(name="success",type="json")
@ParentPackage("hris")

public class OrderItemListJsonAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
    private ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();
    ArrayList<String> argArray = new ArrayList<String>();
    ArrayList<Object> argArrayObj = new ArrayList<Object>();
    private Integer page;
    private String idPO;
    private Integer rowStart;
    private Order order;
    private OrderItem orderItem;
    
    public String execute() throws Exception{
    	rowStart = 2*(page-1);
    	argArrayObj.add(idPO);
    	argArrayObj.add(rowStart);
    	OrderItemDAO orderItemDAO = new OrderItemDAO();
    	orderItemDAO.setArgArrayObj(argArrayObj);
		orderItems = orderItemDAO.searchOrderItemByIdPOnPage();
		return SUCCESS;
	}

	public ArrayList<OrderItem> getOrderItems(){
		return orderItems;
	}
	
	public void setOrderItems(ArrayList<OrderItem> orderItems){
		this.orderItems = orderItems;
	}
	
	public String getIdPO(){
		return idPO;
	}
	
	public void setIdPO (String idPO){
		this.idPO = idPO;
	}

	public Integer getPage(){
		return page;
	}
	
	public void setPage (Integer page){
		this.page = page;
	}
	
	public Order getOrder(){
		return order;
	}
	
	public void setOrder (Order order){
		this.order = order;
	}
	
	public OrderItem getOrderItem(){
		return orderItem;
	}
	
	public void setOrderItem (OrderItem orderItem){
		this.orderItem = orderItem;
	}
	
	
}
