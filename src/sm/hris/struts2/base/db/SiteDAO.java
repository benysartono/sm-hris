package sm.hris.struts2.base.db;
 
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionContext;

//import java.util.List;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import sm.hris.struts2.base.db.Site;
import sm.hris.struts2.base.db.SmBaseDAO;


public class SiteDAO extends SmBaseDAO{
	private Site site = new Site();
	private ArrayList<Site> sites = new ArrayList<Site>();
    private String idSite;
    private ArrayList<String> argArray = new ArrayList<String>();
    private String srcParam;

	
	public ArrayList<Site> searchSite() throws SQLException{
			ResultSet rs = this.runQuery("searchSite");
            while (rs.next()) {
                Site site = new Site();
                site.setIdSite(rs.getString("idSite"));
                site.setDescription(rs.getString("description"));
                site.setNmSite(rs.getString("nmSite"));
                site.setLocation(rs.getString("location"));
                sites.add(site);
            }
            //this.con.close();
        	return sites;
        
    }
	
	public ArrayList<Site> searchSiteById() throws SQLException{
		argArray.add(idSite);
        ResultSet rs = this.runQuery("searchSiteById",argArray);
 
            while (rs.next()) {
                Site site = new Site();
                site.setIdSite(rs.getString("idSite"));
                site.setDescription(rs.getString("description"));
                site.setLocation(rs.getString("location"));
                site.setNmSite(rs.getString("nmSite"));
                sites.add(site);
                
            } 
        	/*
            if(rs != null){
     		   try {
     		   rs.close();
     		   } catch (SQLException e) {
     		        System.out.println("Exception while closing result set: " + e);
     		   }
     		}
        	closeConnection();
        	*/
            //this.con.close();
        	return sites;
    }

	public ArrayList<Site> searchSiteByAnyLike() throws SQLException{
        ResultSet rs = this.runQuery("searchSiteByAnyLike",argArray);
 
            while ((rs != null)&&(rs.next())) {
                Site site = new Site();
                site.setIdSite(rs.getString("idSite"));
                site.setDescription(rs.getString("description"));
                site.setLocation(rs.getString("location"));
                site.setNmSite(rs.getString("nmSite"));
                sites.add(site);
                
            } 
        	/*
            if(rs != null){
     		   try {
     		   rs.close();
     		   } catch (SQLException e) {
     		        System.out.println("Exception while closing result set: " + e);
     		   }
     		}
        	closeConnection();
        	*/
            //this.con.close();
        	return sites;
    }

	public void siteDelete() throws SQLException{
		for(int cnt=0;cnt<argArray.size();cnt++){
			this.run("siteDelete", argArray.get(cnt));
		}
	}

	public void siteAdd() throws SQLException{
		System.out.println("Ada dalam SiteDAO.siteAdd --");
		argArray.add(0, site.getIdSite());
		argArray.add(1, site.getDescription());
		argArray.add(2, site.getLocation());
		argArray.add(3, site.getNmSite());
		this.run("siteAdd", argArray);
	    //this.con.close();
		//closeConnection();
    }
	
	public void siteEdit() throws SQLException{
		argArray.add(0, site.getIdSite());
		argArray.add(1, site.getDescription());
		argArray.add(2, site.getLocation());
		argArray.add(3, site.getNmSite());
		argArray.add(4, site.getIdSite());
		this.run("siteEdit", argArray);
        //this.con.close();
		//closeConnection();
	}
	
	public void setSite(Site site){
		this.site = site;
	}
	
	public Site getSite(){
		return site;
	}

	public void setSites(ArrayList<Site> sites){
		this.sites = sites;
	}
	
	public ArrayList<Site> getSites(){
		return sites;
	}

	public void setIdSite(String idSite){
		this.idSite = idSite;
	}
	
	public String getIdSite(){
		return idSite;
	}

	public void setSrcParam(String srcParam){
		this.srcParam = srcParam;
	}
	
	public String getSrcParam(){
		return srcParam;
	}

	public void setArgArray(ArrayList<String> argArray){
		this.argArray = argArray;
	}
	
	public ArrayList<String> getArgArray(){
		return argArray;
	}

}