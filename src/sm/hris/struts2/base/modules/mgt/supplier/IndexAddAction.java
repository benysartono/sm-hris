package sm.hris.struts2.base.modules.mgt.supplier;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.Supplier;
import sm.hris.struts2.base.db.SupplierDAO;

@Results({
	@Result(name="tolist", location="/base/modules/mgt/supplier", type="redirect"),
	})
@ParentPackage(value = "hris")

public class IndexAddAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
	private SupplierDAO supplierDAO = new SupplierDAO();
    private Supplier supplier = new Supplier();
    private String proc;
    
    public String execute() throws Exception{
    	if((proc != null)&&(proc.equals("Submit"))) {
	   		supplierDAO.setSupplier(supplier);
	   		supplierDAO.supplierAdd();
    	}
		return "tolist";
    }
	
    public Supplier getSupplier(){
		return supplier;
	}
	
	public void setSupplier(Supplier supplier){
		this.supplier = supplier;
	}

    public String getProc(){
		return proc;
	}
	
	public void setProc(String proc){
		this.proc = proc;
	}
}
