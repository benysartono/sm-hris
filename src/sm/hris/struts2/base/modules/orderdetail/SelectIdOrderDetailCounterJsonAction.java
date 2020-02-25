package sm.hris.struts2.base.modules.orderdetail;


import java.util.ArrayList;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.OrderDetailDAO;


@Result(name="success",type="json")
@ParentPackage("hris")

public class SelectIdOrderDetailCounterJsonAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
    private String idOrderDetailCounter;
    private OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
    
    public String execute() throws Exception{
    	idOrderDetailCounter = orderDetailDAO.selectIdOrderDetailCounter();
    	return "success";
    }
    
    public String getIdOrderDetailCounter(){
    	return this.idOrderDetailCounter;
    } 
    
    public void setIdOrderDetailCounter(String idOrderDetailCounter){
    	this.idOrderDetailCounter = idOrderDetailCounter;
    }


}
