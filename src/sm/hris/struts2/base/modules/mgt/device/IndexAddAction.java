package sm.hris.struts2.base.modules.mgt.device;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionContext;

import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.Device;
import sm.hris.struts2.base.db.DeviceDAO;
import sm.hris.struts2.base.db.Actuator;
import sm.hris.struts2.base.db.ActuatorDAO;
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
	private DeviceTypeDAO deviceTypeDAO = new DeviceTypeDAO();
    private Device device = new Device();
    private String proc;
    private ArrayList<Site> sites = new ArrayList<Site>();
    private ArrayList<String> argArray;
    private SiteDAO siteDAO = new SiteDAO();
    private ArrayList<DeviceType> deviceTypes = new ArrayList<DeviceType>();
    private Integer maxArrayNbr;
    private Actuator actuator;
    private ActuatorDAO actuatorDAO; 
	private Map session = ActionContext.getContext().getSession();
	private String userId = String.valueOf(session.get("userId"));
    
    public String execute() throws Exception{
		try {
			sites = siteDAO.searchSite();
			deviceTypes = deviceTypeDAO.searchDeviceType();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	if((proc != null)&&(proc.equals("Submit"))) {
    		argArray = new ArrayList<String>();
    		argArray.add(device.getIdDeviceType());
    		deviceTypeDAO.setArgArray(argArray);
    		deviceTypes=deviceTypeDAO.searchDeviceTypeByIdDeviceType();
    		for(int n=0;n<deviceTypes.size();n++){
    			maxArrayNbr = deviceTypes.get(n).getMaxRelayNbr();
    		}
	   		deviceDAO.setDevice(device);
			try {
				deviceDAO.deviceAdd();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   		actuatorDAO = new ActuatorDAO();
	   		System.out.println("maxRelayNbr nya: --: " + maxArrayNbr);
	   		for(int n=1;n<=maxArrayNbr;n++){
	   			System.out.println("Relay Nbr -- : " + n);
		   		actuator = new Actuator();
		   		actuatorDAO = new ActuatorDAO();
		   		actuator.setIdActuator(device.getIdDevice());
		   		actuator.setIdRelay(n);
		   		actuator.setCommand(3);
		   		actuator.setUpdatedBy(userId);
		   		actuator.setCreatedBy(userId);
		   		actuatorDAO.setActuator(actuator);
				try {
					actuatorDAO.actuatorAdd();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		   		
	   		}
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
