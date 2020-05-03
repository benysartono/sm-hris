package sm.hris.struts2.base.modules.mgt.device;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.Device;
import sm.hris.struts2.base.db.DeviceDAO;
import sm.hris.struts2.base.db.Site;
import sm.hris.struts2.base.db.SiteDAO;
import sm.hris.struts2.base.db.DeviceType;
import sm.hris.struts2.base.db.DeviceTypeDAO;

@Results({
	@Result(name="tolist", location="/base/modules/mgt/device/index", type="redirect"),
	})
@ParentPackage(value = "hris")

public class IndexAddAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
	private DeviceDAO deviceDAO = new DeviceDAO();
    private Device device = new Device();
    private String proc;
    private ArrayList<Site> sites = new ArrayList<Site>();
    private SiteDAO siteDAO = new SiteDAO();
    private DeviceTypeDAO deviceTypeDAO = new DeviceTypeDAO();
    private ArrayList<DeviceType> deviceTypes = new ArrayList<DeviceType>();

    
    public String execute() throws Exception{
		try {
			sites = siteDAO.searchSite();
			deviceTypes = deviceTypeDAO.searchDeviceType();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	if((proc != null)&&(proc.equals("Submit"))) {
    		System.out.println("Ada dalam proc == Submit ---");
	   		deviceDAO.setDevice(device);
	   		deviceDAO.deviceAdd();
	   		return "tolist";
    	}
    	return SUCCESS;
    }
	
    public Device getDevice(){
		return device;
	}
	
	public void setDevice(Device device){
		this.device = device;
	}

    public String getProc(){
		return proc;
	}
	
	public void setProc(String proc){
		this.proc = proc;
	}
	
	public ArrayList<Site> getSites(){
		return sites;
	} 

	public ArrayList<DeviceType> getDeviceTypes(){
		return deviceTypes;
	} 



}
