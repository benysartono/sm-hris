package sm.hris.struts2.base.modules.mgt.device;


import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.struts2.convention.annotation.ParentPackage;

import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.Device;
import sm.hris.struts2.base.db.DeviceDAO;
import sm.hris.struts2.base.db.ActuatorDAO;
import sm.hris.struts2.base.db.Site;
import sm.hris.struts2.base.db.SiteDAO;
import sm.hris.struts2.base.db.DeviceType;
import sm.hris.struts2.base.db.DeviceTypeDAO;

@ParentPackage(value = "hris")

public class IndexAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
	private DeviceDAO deviceDAO = new DeviceDAO();
	private ActuatorDAO actuatorDAO = new ActuatorDAO();
    private ArrayList<Device> devices;
    private String srcParam;
    private ArrayList<String> argArray = new ArrayList<String>();
    private ArrayList<String> idDevices = new ArrayList<String>();
    private String proc;
    private String res;
    private SiteDAO siteDAO = new SiteDAO();
    private ArrayList<Site> sites = new ArrayList<Site>();
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
		
		if (proc != null){
	    	if(proc.equals("Delete")){
	    		res = deviceDelete();
	    	}
	    	if(proc.equals("Add")){
	    		res = deviceAdd();
	    	}
			if(!(proc.equals("Add")||proc.equals("Delete"))){
		    	if (!srcParam.equals("")) {
					argArray.add("%"+srcParam+"%");
					argArray.add("%"+srcParam+"%");
					argArray.add("%"+srcParam+"%");
		    		deviceDAO.setArgArray(argArray);
					setDevices(deviceDAO.searchDeviceByAnyLike());
					res="success";
				} 
			}
    	}
		else {
			setDevices(deviceDAO.searchDevice());
			res="success";
		} 
		return res;
    }
    
	public String deviceDelete() throws Exception {
		for(int n =0;n<devices.size();n++){
			System.out.println("Ini lho IdDevice nya "+devices.get(n).getIdDevice());
			System.out.println("Ini lho IdSite nya "+devices.get(n).getIdSite());
		}
		deviceDAO.setDevices(devices);
		deviceDAO.deviceDelete();
		//actuatorDAO.actuatorDelete();
		setDevices(deviceDAO.searchDevice());
		return "success";
	}

	public String deviceAdd() throws Exception {
		return "add";
	}


	public ArrayList<String> getIdDevices(){
			return idDevices;
		}
			
	public void setIdDevices(ArrayList<String> idDevices){
			this.idDevices=idDevices;
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

	public void setDevices(ArrayList<Device> devices){
		this.devices = devices;
	}
	
	public ArrayList<Device> getDevices(){
		return devices;
	}
	
	public ArrayList<Site> getSites(){
		return sites;
	} 

	public ArrayList<DeviceType> getDeviceTypes(){
		return deviceTypes;
	} 

}
