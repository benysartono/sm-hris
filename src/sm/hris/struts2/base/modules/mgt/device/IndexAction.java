package sm.hris.struts2.base.modules.mgt.device;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.convention.annotation.ParentPackage;

import com.opensymphony.xwork2.ActionContext;

import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.Device;
import sm.hris.struts2.base.db.DeviceDAO;
import sm.hris.struts2.base.db.ActuatorDAO;
import sm.hris.struts2.base.db.Site;
import sm.hris.struts2.base.db.SiteDAO;
import sm.hris.struts2.base.db.DeviceType;
import sm.hris.struts2.base.db.DeviceTypeDAO;
import sm.hris.struts2.base.db.EmployeeDAO;

@ParentPackage(value = "hris")

public class IndexAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
	private DeviceDAO deviceDAO = new DeviceDAO();
	private ActuatorDAO actuatorDAO = new ActuatorDAO();
    private ArrayList<Device> devices;
    private String srcParam;
    private ArrayList<String> argArray;
    private ArrayList<String> idDevices = new ArrayList<String>();
    private String proc;
    private String res;
    private SiteDAO siteDAO = new SiteDAO();
    private ArrayList<Site> sites = new ArrayList<Site>();
    private DeviceTypeDAO deviceTypeDAO = new DeviceTypeDAO();
    private ArrayList<DeviceType> deviceTypes = new ArrayList<DeviceType>();
    private ArrayList<String> idDeviceIdSite = new ArrayList<String>();

	private Map session = ActionContext.getContext().getSession();
	private String userId = String.valueOf(session.get("userId"));
	
	private EmployeeDAO employeeDAO = new EmployeeDAO();
	
	private String idSite;
	
 
    public String execute() throws Exception{

    	argArray = new ArrayList<String>();
    	argArray.add(userId);
    	idSite = employeeDAO.searchEmployeeByUid(argArray).get(0).getIdSite();

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
			if(proc.equals("Search")){
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
			argArray = new ArrayList<String>();
			argArray.add(idSite);
			deviceDAO.setArgArray(argArray);
			setDevices(deviceDAO.searchDeviceByIdSite());
			res="success";
		} 
		return res;
    }
    
	public String deviceDelete() throws Exception {
		for(int cnt=0;cnt<idDeviceIdSite.size();cnt++){
			argArray = new ArrayList<String>();
			int iend = idDeviceIdSite.get(cnt).indexOf(",");
			argArray.add(idDeviceIdSite.get(cnt).substring(0 , iend));
			argArray.add(idDeviceIdSite.get(cnt).substring(idDeviceIdSite.get(cnt).lastIndexOf(",") + 1));
			
			//System.out.println("Actuator Kode: " + idActuatorIdRelays.get(cnt).substring(0 , iend));
			//System.out.println("Relay Kode: " + idActuatorIdRelays.get(cnt).substring(idActuatorIdRelays.get(cnt).lastIndexOf(",") + 1));
			deviceDAO.setArgArray(argArray);
			deviceDAO.deviceDelete();
			actuatorDAO.setArgArray(argArray);
			actuatorDAO.actuatorDelete();
		}
		argArray = new ArrayList<String>();
		argArray.add(idSite);
		deviceDAO.setArgArray(argArray);
		setDevices(deviceDAO.searchDeviceByIdSite());
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


	public ArrayList<String> getIdDeviceIdSite(){
		return idDeviceIdSite;
	}
		
	public void setIdDeviceIdSite(ArrayList<String> idDeviceIdSite){
		this.idDeviceIdSite=idDeviceIdSite;
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
