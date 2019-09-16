package sm.hris.struts2.base.modules.mgt.kpi;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import sm.hris.struts2.base.db.KPI;
import sm.hris.struts2.base.db.KPIDAO;

import sm.hris.struts2.base.SmBaseAction;

@Results({
	@Result(name="tolist", location="/base/modules/mgt/kpi/index", type="redirect"),
})
@ParentPackage(value = "hris")

public class IndexAddAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
    private KPI kPI = new KPI();
    private KPIDAO kPIDAO = new KPIDAO();
    private String proc = new String();
	
	public String execute() throws Exception {
		if(proc.equals("Submit")){
				kPIDAO.setKPI(kPI);
			    kPIDAO.addKPI();
				return "tolist";
		} else {
			return SUCCESS; 
		}	
	}

	public KPI getKPI(){
		return kPI;
	}

	public void setKPI(KPI kPI){
		this.kPI = kPI;
	}
	
	public String getProc(){
		return proc;
	}

	public void setProc(String proc){
		this.proc = proc;
	}

}


	