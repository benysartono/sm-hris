package sm.hris.struts2.base.modules.mgt.kpi;

import java.util.ArrayList;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.KPI;
import sm.hris.struts2.base.db.KPIDAO;


@Results({
	//@Result(name="add", location="/base/modules/mgt/kpi/add-kpi", type="redirect"),
	})
@ParentPackage(value = "hris")

public class IndexAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
    private KPI kPI = new KPI();
    private KPIDAO kPIDAO = new KPIDAO();
    private ArrayList<KPI> kPIs;
    private ArrayList<String> formArg = new ArrayList<String>();
    private ArrayList<String> idKPIs = new ArrayList<String>();
    private String proc = new String();
    private String res = new String();
    private String searchPrm = new String();
    
    public String execute() throws Exception{
    	if(proc.equals("Add")){
    		res = addKPI();
    	}
    	if(proc.equals("Delete")){
    		res = deleteKPI();
    	}
		if(!(proc.equals("Add")||proc.equals("Delete"))){
	    	if (!searchPrm.equals("")) {
				formArg.add("%"+searchPrm+"%");
				kPIDAO.setArgArray(formArg);
				kPIs = kPIDAO.searchKPIByDescriptionLike();
				res="success";
			} 
			else {
				kPIs = kPIDAO.searchKPI();
				res="success";
			} 
		}
		return res;
    }
    
  
	public String deleteKPI() throws Exception {
		kPIDAO.setArgArray(idKPIs);
		kPIDAO.deleteKPI();
		kPIs = kPIDAO.searchKPI();
		return "success";
	}

	public String addKPI() throws Exception {
		return "add";
	}

	public KPI getKPI(){
		return kPI;
	}
		
	public void setKPI(KPI kPI){
		this.kPI=kPI;
	}

	public ArrayList<String> getIdKPIs(){
			return idKPIs;
		}
			
	public void setIdKPIs(ArrayList<String> idKPIs){
			this.idKPIs=idKPIs;
		}
	
	public ArrayList<KPI> getKPIs(){
		return kPIs;
	}

	public void setKPIs(ArrayList<KPI> kPIs){
		this.kPIs=kPIs;
	}


	public void setProc(String proc) {
        this.proc = proc;
    }

	public String getSearchPrm(){
		return searchPrm;
	}
		
	public void setSearchPrm(String searchPrm){
		this.searchPrm=searchPrm;
	}


}
