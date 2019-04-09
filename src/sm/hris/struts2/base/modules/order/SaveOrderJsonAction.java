package sm.hris.struts2.base.modules.order;

import java.util.ArrayList;

import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.Order;
import sm.hris.struts2.base.db.OrderDAO;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

@Result(name="success",type="json")
@ParentPackage("hris")

public class SaveOrderJsonAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
	private OrderDAO orderDAO = new OrderDAO();
	private Order order = new Order();
	private ArrayList<Order> orders = new ArrayList<Order>();
	//private ArrayList<String> argArray = new ArrayList<String>();
	
	//private String res = new String();
    
    public String execute() throws Exception{
		orderDAO.setOrder(order);
    	orderDAO.orderAdd();
		//argArray.add(order.getIdPO());
		//orders = orderDAO.searchOrder();
		//res="success";
		return SUCCESS;
	}

	public Order getOrder(){
		return order;
	}
	
	public void setOrder(Order order){
		this.order = order;
	}
	
	public ArrayList<Order> getOrders(){
		return orders;
	}
	
	public void setOrders (ArrayList<Order> orders){
		this.orders = orders;
	}
	
}
