package sm.hris.struts2.base.modules.mgt.paymentmethod;


import java.util.ArrayList;
import java.util.HashMap;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.PaymentMethod;
import sm.hris.struts2.base.db.PaymentMethodDAO;

@ParentPackage(value = "hris")

public class IndexAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
	private PaymentMethodDAO paymentMethodDAO = new PaymentMethodDAO();
    private ArrayList<PaymentMethod> paymentMethods;
    private String nmPaymentMethod;
    private ArrayList<String> argArray = new ArrayList<String>();
    private ArrayList<String> idPaymentMethods = new ArrayList<String>();
    private String proc;
    private String res;
    
    public String execute() throws Exception{
    	if (proc != null){
	    	if(proc.equals("Add")){
	    		return "add";
	    	}
	    	if(proc.equals("Delete")){
	    		res = paymentMethodDelete();
	    	}
			if(!(proc.equals("Add")||proc.equals("Delete"))){
		    	if (!nmPaymentMethod.equals("")) {
					argArray.add("%"+nmPaymentMethod+"%");
		    		paymentMethodDAO.setArgArray(argArray);
					setPaymentMethods(paymentMethodDAO.searchPaymentMethodByAnyLike());
					res="success";
				} 
			}
    	}
		else {
			setPaymentMethods(paymentMethodDAO.searchPaymentMethod());
			res="success";
		} 
		return res;
    }
    
	public String paymentMethodDelete() throws Exception {
		paymentMethodDAO.setArgArray(idPaymentMethods);
		paymentMethodDAO.paymentMethodDelete();
		setPaymentMethods(paymentMethodDAO.searchPaymentMethod());
		return "success";
	}

	public String paymentMethodAdd() throws Exception {
		return "add";
	}


	public ArrayList<String> getIdPaymentMethods(){
			return idPaymentMethods;
		}
			
	public void setIdPaymentMethods(ArrayList<String> idPaymentMethods){
			this.idPaymentMethods=idPaymentMethods;
		}
	
	public String getNmPaymentMethod(){
		return nmPaymentMethod;
	}
	
	public void setNmPaymentMethod(String nmPaymentMethod){
		this.nmPaymentMethod = nmPaymentMethod;
	}

	public void setProc(String proc) {
        this.proc = proc;
    }

	public void setPaymentMethods(ArrayList<PaymentMethod> paymentMethods){
		this.paymentMethods = paymentMethods;
	}
	
	public ArrayList<PaymentMethod> getPaymentMethods(){
		return paymentMethods;
	}
	
}
