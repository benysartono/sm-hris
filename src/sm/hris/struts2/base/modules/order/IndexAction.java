package sm.hris.struts2.base.modules.order;


import java.util.ArrayList;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.Order;
import sm.hris.struts2.base.db.OrderDAO;


//@Results({
//	@Result(name="add", location="/base/modules/mgt/employee/employee-add", type="redirect"),
//	})
@ParentPackage(value = "hris")

public class IndexAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
	private OrderDAO orderDAO = new OrderDAO();
    private ArrayList<Order> orders;
    private String idOrder = new String();
    private String searchKey = new String();
    private ArrayList<String> formArg = new ArrayList<String>();
    private ArrayList<String> idOrders = new ArrayList<String>();
    private String proc = new String();
    private String res = new String();
    
    public String execute() throws Exception{
    	//super.listMenu();
    	if(proc.equals("Add")){
    		//res = orderAdd();
    		res = "add";
    	}
    	if(proc.equals("Delete")){
    		res = orderDelete();
    	}
		if(!(proc.equals("Add")||proc.equals("Delete"))){
	    	if (!searchKey.equals("")) {
				formArg.add("%"+searchKey+"%");
				orderDAO.setArgArray(formArg);
				orders = orderDAO.searchOrderByAnyLike();
				res="success";
			} 
			else {
				orders = orderDAO.searchOrder();
				res="success";
			} 
		}
		return res;
    }
    
	public String orderDelete() throws Exception {
		orderDAO.setArgArray(idOrders);
		orderDAO.orderDelete(); 
		return "success";
	}

	public String orderAdd() throws Exception {
		return "add";
	}


	public String getIdOrder(){
		return idOrder;
	}
		
	public void setIdOrder(String idOrder){
		this.idOrder=idOrder;
	}

	public String getSearchKey(){
		return searchKey;
	}
		
	public void setSearchKey(String searchKey){
		this.searchKey=searchKey;
	}

	public ArrayList<String> getIdOrders(){
			return idOrders;
		}
			
	public void setIdOrders(ArrayList<String> idOrders){
			this.idOrders=idOrders;
		}
	
	public ArrayList<Order> getOrders(){
		return orders;
	}
	


	public void setProc(String proc) {
        this.proc = proc;
    }



}
