package sm.hris.struts2.base.modules.mgt.site;


import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.Site;
import sm.hris.struts2.base.db.SiteDAO;


@Results({
	@Result(name="tolist", location="/base/modules/mgt/site/index", type="redirect"),
	})
@ParentPackage(value = "hris")

public class IndexEditAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
	private SiteDAO siteDAO = new SiteDAO();
    private Site site = new Site();
    private String proc;
  
    
    public String execute() throws Exception{
    	if((proc != null)&&(proc.equals("Submit"))) {

		    //Reading the file image into FileInputStream
		    
		    //Creating New Empty File
		    
		    //Writing into the new empty file
		    
    		siteDAO.setSite(site);
    		siteDAO.siteEdit();
    		
    		return "tolist";
    	}
		return SUCCESS;
    }
	
   
    public Site getSite(){
		return site;
	}
	
	public void setSite(Site site){
		this.site = site;
	}

    public String getProc(){
		return proc;
	}
	
	public void setProc(String proc){
		this.proc = proc;
	}

	
}
