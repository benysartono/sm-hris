package sm.hris.struts2.base.modules.mgt.supplier;


import java.util.ArrayList;
import java.util.HashMap;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.Supplier;
import sm.hris.struts2.base.db.SupplierDAO;

@ParentPackage(value = "hris")

public class IndexAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
	private SupplierDAO supplierDAO = new SupplierDAO();
    private ArrayList<Supplier> suppliers;
    private String description;
    private ArrayList<String> argArray = new ArrayList<String>();
    private ArrayList<String> idSuppliers = new ArrayList<String>();
    private String proc;
    private String res;
    
    public String execute() throws Exception{
    	if (proc != null){
	    	if(proc.equals("Add")){
	    		return "add";
	    	}
	    	if(proc.equals("Delete")){
	    		res = supplierDelete();
	    	}
			if(!(proc.equals("Add")||proc.equals("Delete"))){
		    	if (!description.equals("")) {
					argArray.add("%"+description+"%");
		    		supplierDAO.setArgArray(argArray);
					setSuppliers(supplierDAO.searchSupplierByAnyLike());
					res="success";
				} 
			}
    	}
		else {
			setSuppliers(supplierDAO.searchSupplier());
			res="success";
		} 
		return res;
    }
    
	public String supplierDelete() throws Exception {
		supplierDAO.setArgArray(idSuppliers);
		supplierDAO.supplierDelete();
		setSuppliers(supplierDAO.searchSupplier());
		return "success";
	}

	public String supplierAdd() throws Exception {
		return "add";
	}


	public ArrayList<String> getIdSuppliers(){
			return idSuppliers;
		}
			
	public void setIdSuppliers(ArrayList<String> idSuppliers){
			this.idSuppliers=idSuppliers;
		}
	
	public String getDescription(){
		return description;
	}
	
	public void setDescription(String description){
		this.description = description;
	}

	public void setProc(String proc) {
        this.proc = proc;
    }

	public void setSuppliers(ArrayList<Supplier> suppliers){
		this.suppliers = suppliers;
	}
	
	public ArrayList<Supplier> getSuppliers(){
		return suppliers;
	}

}
