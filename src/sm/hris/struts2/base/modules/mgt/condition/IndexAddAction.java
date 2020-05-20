package sm.hris.struts2.base.modules.mgt.condition;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import sm.hris.struts2.base.db.Device;
import sm.hris.struts2.base.db.DeviceDAO;
import sm.hris.struts2.base.db.ValueType;
import sm.hris.struts2.base.db.ValueTypeDAO;

import com.opensymphony.xwork2.ActionContext;

import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.Condition;
import sm.hris.struts2.base.db.ConditionDAO;
import sm.hris.struts2.base.db.EmployeeDAO;

@Results({
	@Result(name="tolist", location="/base/modules/mgt/condition/index", type="redirect"),
	})
@ParentPackage(value = "hris")

public class IndexAddAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
	private ConditionDAO conditionDAO = new ConditionDAO();
    private Condition condition = new Condition();
    private String proc;
    private ArrayList<String> argArray;
	private Map session = ActionContext.getContext().getSession();
	private String userId = String.valueOf(session.get("userId"));
	private String idSite;
	private DeviceDAO deviceDAO = new DeviceDAO();
    private ArrayList<Device> devices;
    
	private ValueTypeDAO valueTypeDAO = new ValueTypeDAO();
    private ArrayList<ValueType> valueTypes;

    public String execute() throws Exception{
    	argArray = new ArrayList<String>();
    	argArray.add(userId);
    	EmployeeDAO employeeDAO = new EmployeeDAO();
		idSite = employeeDAO.searchEmployeeByUid(argArray).get(0).getIdSite();
		
    	argArray = new ArrayList<String>();
    	argArray.add(idSite);
		deviceDAO.setArgArray(argArray);
		devices = deviceDAO.searchDeviceByIdSite();
		
		valueTypes = valueTypeDAO.searchValueType();

		if((proc != null)&&(proc.equals("Submit"))) {
	   		conditionDAO.setCondition(condition);
			try {
				conditionDAO.conditionAdd();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   		return "tolist";
    	}
    	return SUCCESS;
    }
	
    public Condition getCondition(){
		return condition;
	}
	
	public void setCondition(Condition condition){
		this.condition = condition;
	}

    public ArrayList<Device> getDevices(){
		return devices;
	}
	
	public void setDevices(ArrayList<Device> devices){
		this.devices = devices;
	}

    public ArrayList<ValueType> getValueTypes(){
		return valueTypes;
	}
	
	public void setValueTypes(ArrayList<ValueType> valueTypes){
		this.valueTypes = valueTypes;
	}

    public String getProc(){
		return proc;
	}
	
	public void setProc(String proc){
		this.proc = proc;
	}
	
	public String getIdSite(){
		return idSite;
	}
	
	public void setIdSite(String idSite){
		this.idSite = idSite;
	}

}
