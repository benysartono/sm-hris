package sm.hris.struts2.base.modules.mgt.kpi;

import com.opensymphony.xwork2.ActionSupport;

import java.sql.SQLException;
//import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.KPI;
import sm.hris.struts2.base.db.KPIDAO;

@Results({
	@Result(name="tolist", location="/base/modules/mgt/role/index", type="redirect"),
})
@ParentPackage(value = "hris")

public class IndexEditAction extends SmBaseAction {
    private KPI kPI = new KPI();
    private KPIDAO kPIDAO = new KPIDAO();
    private String proc = new String();
    
/*	private String idEmployee = new String(); 									
	private String name = new String(); 				
	private Date dob = new Date(); 			
	private String address = new String(); 						
	private String idSite = new String(); 				
	private String idDept = new String(); 				
	private String idUnit = new String(); 				
	private String idPosition = new String(); 				
*/
    
	public String execute() throws Exception {
		if(proc.equals("Submit")){ 
			kPIDAO.setKPI(kPI);
			kPIDAO.editKPI();
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


	