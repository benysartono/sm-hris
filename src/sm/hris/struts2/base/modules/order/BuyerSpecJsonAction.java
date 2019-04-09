package sm.hris.struts2.base.modules.order;

import java.util.ArrayList;

import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.BuyerSpec;
import sm.hris.struts2.base.db.BuyerDAO;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

@Result(name="success",type="json")
@ParentPackage("hris")

public class BuyerSpecJsonAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
	private BuyerDAO buyerDAO = new BuyerDAO();
	private BuyerSpec buyerSpec;
    private ArrayList<String> specs;
    private ArrayList<BuyerSpec> buyerSpecs = new ArrayList<BuyerSpec>();
    private String res = new String();
    private String idBuyer = new String();
    ArrayList<String> argArray = new ArrayList<String>();
    
    public String execute() throws Exception{
    	argArray.add(idBuyer);
		buyerSpecs = buyerDAO.searchBuyerSpecsByIdBuyer(argArray);
		res="success";
		return res;
	}

	public ArrayList<BuyerSpec> getBuyerSpecs(){
		return buyerSpecs;
	}
	
	public void setBuyerSpecs(ArrayList<BuyerSpec> buyerSpecs){
		this.buyerSpecs = buyerSpecs;
	}
	
	public String getIdBuyer(){
		return idBuyer;
	}
	
	public void setIdBuyer (String idBuyer){
		this.idBuyer = idBuyer;
	}

}
