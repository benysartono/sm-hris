package sm.hris.struts2.base.modules.mgt.discount;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.Discount;
import sm.hris.struts2.base.db.DiscountDAO;

@Results({
	@Result(name="tolist", location="/base/modules/mgt/discount", type="redirect"),
	})
@ParentPackage(value = "hris")

public class IndexAddAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
	private DiscountDAO discountDAO = new DiscountDAO();
    private Discount discount = new Discount();
    private String proc;
    
    public String execute() throws Exception{
    	if((proc != null)&&(proc.equals("Submit"))) {
	   		discountDAO.setDiscount(discount);
	   		discountDAO.discountAdd();
    	}
		return "tolist";
    }
	
    public Discount getDiscount(){
		return discount;
	}
	
	public void setDiscount(Discount discount){
		this.discount = discount;
	}

    public String getProc(){
		return proc;
	}
	
	public void setProc(String proc){
		this.proc = proc;
	}
}
