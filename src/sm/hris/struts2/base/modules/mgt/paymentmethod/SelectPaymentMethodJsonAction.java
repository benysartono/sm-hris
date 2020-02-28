package sm.hris.struts2.base.modules.mgt.paymentmethod;


import java.util.ArrayList;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.PaymentMethodDAO;
import sm.hris.struts2.base.db.PaymentMethod;


@Result(name="success",type="json")
@ParentPackage("hris")

public class SelectPaymentMethodJsonAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
    private String idPaymentMethod;
    private PaymentMethodDAO paymentMethodDAO = new PaymentMethodDAO();
    private PaymentMethod paymentMethod = new PaymentMethod();
    private ArrayList<PaymentMethod> paymentMethods = new ArrayList<PaymentMethod>();
    private ArrayList<String> argArray = new ArrayList<String>();
    
    public String execute() throws Exception{
    	argArray.add(idPaymentMethod);
    	paymentMethodDAO.setArgArray(argArray);
    	paymentMethods = paymentMethodDAO.searchPaymentMethod();
    	return "success";
    }
/*    
    public String getIdPaymentMethod(){
    	return this.idPaymentMethod;
    } 
*/    
    public void setIdPaymentMethod(String idPaymentMethod){
    	this.idPaymentMethod = idPaymentMethod;
    }

/*    
    public PaymentMethod getPaymentMethod(){
    	return this.paymentMethod;
    } 
*/
    
    public void setPaymentMethod(PaymentMethod paymentMethod){
    	this.paymentMethod = paymentMethod;
    }

    public ArrayList<PaymentMethod> getPaymentMethods(){
    	return this.paymentMethods;
    } 
    
    public void setPaymentMethods(ArrayList<PaymentMethod> paymentMethods){
    	this.paymentMethods = paymentMethods;
    }
    
/*
    public ArrayList<String> getArgArray(){
    	return this.argArray;
    } 
*/
    
    public void setArgArray(ArrayList<String> argArray){
    	this.argArray = argArray;
    } 
}
