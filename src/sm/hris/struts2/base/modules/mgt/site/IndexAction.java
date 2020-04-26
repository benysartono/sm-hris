package sm.hris.struts2.base.modules.mgt.site;


import java.util.ArrayList;

import org.apache.struts2.convention.annotation.ParentPackage;

import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.Site;
import sm.hris.struts2.base.db.SiteDAO;

@ParentPackage(value = "hris")

public class IndexAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
	private SiteDAO siteDAO = new SiteDAO();
    private ArrayList<Site> sites;
    private String srcParam;
    private ArrayList<String> argArray = new ArrayList<String>();
    private ArrayList<String> idSites = new ArrayList<String>();
    private String proc;
    private String res;
    
    public String execute() throws Exception{
    	if (proc != null){
	    	if(proc.equals("Delete")){
	    		res = siteDelete();
	    	}
			if(!(proc.equals("Add")||proc.equals("Delete"))){
		    	if (!srcParam.equals("")) {
					argArray.add("%"+srcParam+"%");
		    		siteDAO.setArgArray(argArray);
					setSites(siteDAO.searchSiteByAnyLike());
					res="success";
				} 
			}
    	}
		else {
			setSites(siteDAO.searchSite());
			res="success";
		} 
		return res;
    }
    
	public String siteDelete() throws Exception {
		siteDAO.setArgArray(idSites);
		siteDAO.siteDelete();
		setSites(siteDAO.searchSite());
		return "success";
	}

	public String siteAdd() throws Exception {
		return "add";
	}


	public ArrayList<String> getIdSites(){
			return idSites;
		}
			
	public void setIdSites(ArrayList<String> idSites){
			this.idSites=idSites;
		}
	
	public String getSrcParam(){
		return srcParam;
	}
	
	public void setSrcParam(String srcParam){
		this.srcParam = srcParam;
	}

	public void setProc(String proc) {
        this.proc = proc;
    }

	public void setSites(ArrayList<Site> sites){
		this.sites = sites;
	}
	
	public ArrayList<Site> getSites(){
		return sites;
	}
}
