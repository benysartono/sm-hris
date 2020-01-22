package sm.hris.struts2.base.modules.order;


import java.util.ArrayList;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.Order;
import sm.hris.struts2.base.db.OrderDAO;


@Results({
	@Result(name="tolist", location="/base/modules/order", type="redirect"),
	})
@ParentPackage(value = "hris")

public class IndexAddAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
	private OrderDAO orderDAO = new OrderDAO();
    private Order order = new Order();
    private String idOrder = new String();
    private ArrayList<String> formArg = new ArrayList<String>();
    private ArrayList<String> idOrders = new ArrayList<String>();
    private String proc = new String();
    private String res = new String();
    
    public String execute() throws Exception{
    	//if(order.getIdOrder().isEmpty()) return "tolist";
    	//else {
    		//orderDAO.setOrder(order);
    		//orderDAO.orderAdd();
    		return SUCCESS;
    	//}
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

	public void setProc(String proc) {
        this.proc = proc;
    }



}
