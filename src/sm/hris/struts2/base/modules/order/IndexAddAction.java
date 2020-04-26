package sm.hris.struts2.base.modules.order;


import java.util.ArrayList;
import java.util.Date;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.Order;
import sm.hris.struts2.base.db.OrderFR;
import sm.hris.struts2.base.db.OrderDetail;
import sm.hris.struts2.base.db.OrderDetailFR;
import sm.hris.struts2.base.db.OrderDAO;
import sm.hris.struts2.base.db.CounterDAO;


@Results({
	@Result(name="tolist", location="/base/modules/order/", type="redirect"),
	})
@ParentPackage(value = "hris")

public class IndexAddAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
	private OrderDAO orderDAO = new OrderDAO();
    private CounterDAO counterDAO = new CounterDAO();
    private Order order = new Order();
    private OrderFR orderFR = new OrderFR();
    private ArrayList<Order> orders;
    private ArrayList<OrderDetail> orderDetails;
    private ArrayList<OrderDetailFR> orderDetailFRs;
    private String idOrder = new String();
    private ArrayList<String> formArg = new ArrayList<String>();
    private ArrayList<String> idOrders = new ArrayList<String>();
    private String proc;
    private String procIn;
    private String strIdOrder;
    private String strIdOrderCounter;
    
    public String execute() throws Exception{
    	System.out.println("Ada di dalam IndexAddAction");
    	System.out.println("proc nya:" + proc);
    	System.out.println("idOrder nya:" + order.getIdOrder());

    	if ("Print".equals(proc)){
			return "tolist";
		}
    	if ("Save, Save".equals(proc)){
	    	System.out.println("Ada di dalam IndexAddAction If");
	    	System.out.println("OrderDetailId nya: " + orderDetails.get(0).getIdOrderDetail());
	    	orderDAO.setOrder(order);
	    	orderDAO.setOrderDetails(orderDetails);
			orderDAO.orderAdd();
			idOrders.add(0,order.getIdOrder());
			orderDAO.setArgArray(idOrders);
			setOrderFR(orderDAO.searchOrderByIdOrderFR().get(0));
			proc = "Print";
			return "print";
		} else {
    		System.out.println("Ada di dalam IndexAddAction Else");
        	setStrIdOrderCounter(counterDAO.selectIdOrderCounter());
       		order.setOrderDate(new Date());
       		order.setIdOrder(strIdOrderCounter);
       		proc = "Save";
			return SUCCESS;
		}
    }
    

	public ArrayList<String> getIdOrders(){
			return idOrders;
		}
			
	public void setIdOrders(ArrayList<String> idOrders){
			this.idOrders=idOrders;
		}
	
	public Order getOrder(){
		return order;
	}
	
	public void setOrderFR(OrderFR orderFR){
		this.orderFR = orderFR;
	}

	public OrderFR getOrderFR(){
		return orderFR;
	}
	
	public void setOrder(Order order){
		this.order = order;
	}
	public ArrayList<OrderDetail> getOrderDetails(){
		return orderDetails;
	}
	
	public void setOrderDetailFRs(ArrayList<OrderDetailFR> orderDetailFRs){
		this.orderDetailFRs = orderDetailFRs;
	}

	public ArrayList<OrderDetailFR> getOrderDetailFRs(){
		return orderDetailFRs;
	}
	
	public void setOrderDetails(ArrayList<OrderDetail> orderDetails){
		this.orderDetails = orderDetails;
	}

	public void setProc(String proc) {
        this.proc = proc;
    }

	public String getProc(){
		return proc;
	}

	public void setProcIn(String procIn) {
        this.procIn = procIn;
    }

	public String getProcIn(){
		return procIn;
	}

	public String getStrIdOrder(){
		return strIdOrder;
	}
	
	public void setStrIdOrder(String strIdOrder){
		this.strIdOrder = strIdOrder;
	}

	public String getStrIdOrderCounter(){
		return strIdOrderCounter;
	}
	
	public void setStrIdOrderCounter(String strIdOrderCounter){
		this.strIdOrderCounter = strIdOrderCounter;
	}
}
