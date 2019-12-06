package sm.hris.struts2.base.modules.mgt.paymentmethod;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.PaymentMethod;
import sm.hris.struts2.base.db.PaymentMethodDAO;

@Results({
	@Result(name="tolist", location="/base/modules/mgt/paymentmethod", type="redirect"),
	})
@ParentPackage(value = "hris")

public class IndexAddAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
	private PaymentMethodDAO paymentMethodDAO = new PaymentMethodDAO();
    private PaymentMethod paymentMethod = new PaymentMethod();
    private String proc;
    
    public String execute() throws Exception{
    	if((proc != null)&&(proc.equals("Submit"))) {
	   		paymentMethodDAO.setPaymentMethod(paymentMethod);
	   		paymentMethodDAO.paymentMethodAdd();
    	}
		return "tolist";
    }
	
    public PaymentMethod getPaymentMethod(){
		return paymentMethod;
	}
	
	public void setPaymentMethod(PaymentMethod paymentMethod){
		this.paymentMethod = paymentMethod;
	}

    public String getProc(){
		return proc;
	}
	
	public void setProc(String proc){
		this.proc = proc;
	}
}
