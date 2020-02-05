package sm.hris.struts2.base.modules.mgt.discount;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.Product;
import sm.hris.struts2.base.db.ProductDAO;

@Results({
	@Result(name="tolist", location="/base/modules/mgt/product", type="redirect"),
	})
@ParentPackage(value = "hris")

public class IndexAddAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
	private ProductDAO productDAO = new ProductDAO();
    private Product product = new Product();
    private String proc;
    
    public String execute() throws Exception{
    	if((proc != null)&&(proc.equals("Submit"))) {
	   		productDAO.setProduct(product);
	   		productDAO.productAdd();
    	}
		return "tolist";
    }
	
    public Product getProduct(){
		return product;
	}
	
	public void setProduct(Product product){
		this.product = product;
	}

    public String getProc(){
		return proc;
	}
	
	public void setProc(String proc){
		this.proc = proc;
	}
}
