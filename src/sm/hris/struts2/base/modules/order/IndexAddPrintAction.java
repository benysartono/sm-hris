package sm.hris.struts2.base.modules.order;


import java.util.ArrayList;
import java.util.Date;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.Order;
import sm.hris.struts2.base.db.OrderDetail;
import sm.hris.struts2.base.db.OrderDAO;
import sm.hris.struts2.base.db.CounterDAO;
import sm.hris.struts2.base.db.Product;
import sm.hris.struts2.base.db.ProductDAO;

@Results({
	@Result(name="tolist", location="/base/modules/order/", type="redirect"),
	})
@ParentPackage(value = "hris")

public class IndexAddPrintAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
    private ArrayList<OrderDetail> orderDetails;
    private ArrayList<String> argArray;
    private OrderDetail orderDetail;
    private String proc;
    private String nmProduct;
    private ProductDAO productDAO;
    
    public String execute() throws Exception{
    	for(OrderDetail orderDetail:orderDetails){
    		productDAO = new ProductDAO();
    		argArray = new ArrayList<String>();
    		argArray.add(orderDetail.getIdProduct());
    		productDAO.setArgArray(argArray);
    		nmProduct = productDAO.searchProductById().get(0).getNmProduct();
    	}
    	
    	System.out.println("Ada di dalam IndexAddAction");
    	System.out.println("proc nya:" + proc);
    	System.out.println("idOrder nya:" + order.getIdOrder());

    	if ("Print".equals(proc)){
			return "tolist";
		}
    	if ("Save".equals(proc)){
	    	System.out.println("Ada di dalam IndexAddAction If");
	    	System.out.println("OrderDetailId nya: " + orderDetails.get(0).getIdOrderDetail());
	    	orderDAO.setOrder(order);
	    	orderDAO.setOrderDetails(orderDetails);
			orderDAO.orderAdd();
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
	
	public void setOrder(Order order){
		this.order = order;
	}

	public ArrayList<OrderDetail> getOrderDetails(){
		return orderDetails;
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
