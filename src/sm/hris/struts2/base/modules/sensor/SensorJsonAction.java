package sm.hris.struts2.base.modules.sensor;

import java.util.ArrayList;
import java.util.Map;

import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.Device;
import sm.hris.struts2.base.db.DeviceDAO;
import sm.hris.struts2.base.db.EmployeeDAO;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Result(name="success",type="json")
@ParentPackage("hris")

public class SensorJsonAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
	private DeviceDAO sensorDAO = new DeviceDAO();
	private EmployeeDAO employeeDAO = new EmployeeDAO();
    private ArrayList<Device> sensors;
    private ArrayList<String> argArray = new ArrayList<String>();
    private String res = new String();
	private Map session = ActionContext.getContext().getSession();
	private String userId = String.valueOf(session.get("userId"));

    
    public String execute() throws Exception{
    	argArray.add(userId);
    	String idSite = employeeDAO.searchEmployeeByUid(argArray).get(0).getIdSite();
    	argArray = new ArrayList<String>();
    	argArray.add(idSite);
    	sensorDAO.setArgArray(argArray);
		sensors = sensorDAO.searchDevice();
		return SUCCESS;
		}

	public ArrayList<Device> getSensors(){
		return sensors;
	}
	
	public void setSensors(ArrayList<Device> sensors){
		this.sensors = sensors;
	}
}
