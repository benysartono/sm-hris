package sm.hris.struts2.base.modules.sensor;

import java.util.ArrayList;

import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.Sensor;
import sm.hris.struts2.base.db.SensorDAO;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@Result(name="success",type="json")
@ParentPackage("hris")

public class SensorJsonAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
	private SensorDAO sensorDAO = new SensorDAO();
    private ArrayList<Sensor> sensors;
    private String res = new String();
    
    public String execute() throws Exception{
		sensors = sensorDAO.searchSensor();
		return SUCCESS;
		}

	public ArrayList<Sensor> getSensors(){
		return sensors;
	}
	
	public void setSensors(ArrayList<Sensor> sensors){
		this.sensors = sensors;
	}
}
