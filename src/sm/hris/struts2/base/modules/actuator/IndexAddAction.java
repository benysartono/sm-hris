package sm.hris.struts2.base.modules.actuator;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.Actuator;
import sm.hris.struts2.base.db.ActuatorDAO;
import sm.hris.struts2.base.db.Device;
import sm.hris.struts2.base.db.DeviceDAO;
import sm.hris.struts2.base.db.DeviceTrx;
import sm.hris.struts2.base.db.DeviceTrxDAO;
import sm.hris.struts2.base.db.EmployeeDAO;

@Results({
	@Result(name="tolist", location="/base/modules/actuator/index", type="redirect"),
	})
@ParentPackage(value = "hris")

public class IndexAddAction extends ActionSupport {
    private static final long serialVersionUID = 7353477345330099548L;
	private EmployeeDAO employeeDAO = new EmployeeDAO();
	private DeviceDAO deviceDAO = new DeviceDAO();
    private ArrayList<Device> devices = new ArrayList<Device>();
	private ActuatorDAO actuatorDAO = new ActuatorDAO();
    private Actuator actuator = new Actuator();
    private String proc;
    private ArrayList<String> argArray = new ArrayList<String>();
	private Map session = ActionContext.getContext().getSession();
	private String userId = String.valueOf(session.get("userId"));
    
    public String execute() throws Exception{
    	argArray.add(userId);
    	System.out.println("User e : " + userId);
    	String idSite = employeeDAO.searchEmployeeByUid(argArray).get(0).getIdSite();
    	System.out.println("Site e : " + idSite);
    	argArray = new ArrayList<String>();
    	argArray.add(idSite);
    	deviceDAO.setArgArray(argArray);
		devices = deviceDAO.searchDeviceByIdSite();

    	if((proc != null)&&(proc.equals("Submit"))) {
	   		actuatorDAO.setActuator(actuator);
	   		actuatorDAO.actuatorAdd();
			return "tolist";
    	}
    	return SUCCESS;
    }
	
    public Actuator getActuator(){
		return actuator;
	}
	
	public void setActuator(Actuator actuator){
		this.actuator = actuator;
	}

    public String getProc(){
		return proc;
	}
	
	public void setProc(String proc){
		this.proc = proc;
	}

	public ArrayList<Device> getDevices(){
		return devices;
	}
	
	public void setDevices(ArrayList<Device> devices){
		this.devices = devices;
	}

}
