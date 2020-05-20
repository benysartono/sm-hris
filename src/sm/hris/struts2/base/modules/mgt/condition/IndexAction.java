package sm.hris.struts2.base.modules.mgt.condition;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.ParentPackage;

import com.opensymphony.xwork2.ActionContext;

import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.Condition;
import sm.hris.struts2.base.db.ConditionDAO;
import sm.hris.struts2.base.db.Device;
import sm.hris.struts2.base.db.DeviceDAO;
import sm.hris.struts2.base.db.ValueType;
import sm.hris.struts2.base.db.ValueTypeDAO;
import sm.hris.struts2.base.db.ActuatorDAO;
import sm.hris.struts2.base.db.Site;
import sm.hris.struts2.base.db.SiteDAO;
import sm.hris.struts2.base.db.DeviceType;
import sm.hris.struts2.base.db.DeviceTypeDAO;
import sm.hris.struts2.base.db.EmployeeDAO;

@ParentPackage(value = "hris")

public class IndexAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
	private ConditionDAO conditionDAO = new ConditionDAO();
	private ArrayList<Condition> conditions = new ArrayList<Condition>(); 
	private DeviceDAO deviceDAO = new DeviceDAO();
    private ArrayList<Device> devices;
	private ValueTypeDAO valueTypeDAO = new ValueTypeDAO();
    private ArrayList<ValueType> valueTypes;
    private String srcParam;
    private ArrayList<String> argArray;
    private ArrayList<String> idConditionIdSiteIdDevices = new ArrayList<String>();
    private String proc;
    private String res;
    private SiteDAO siteDAO = new SiteDAO();

	private Map session = ActionContext.getContext().getSession();
	private String userId = String.valueOf(session.get("userId"));
	
	private EmployeeDAO employeeDAO = new EmployeeDAO();
	
	private String idSite;
	private List<String> operands = new ArrayList<String>();
	
	
    public String execute() throws Exception{
    	
    	operands.add("GT");
    	operands.add("GE");
    	operands.add("LT");
    	operands.add("LE");
    	operands.add("EQ");

    	argArray = new ArrayList<String>();
    	argArray.add(userId);
    	idSite = employeeDAO.searchEmployeeByUid(argArray).get(0).getIdSite();
    	devices = new ArrayList<Device>();
    	argArray = new ArrayList<String>();
    	argArray.add(idSite);
    	deviceDAO.setArgArray(argArray);
    	devices = deviceDAO.searchDeviceByIdSite();
		valueTypes = valueTypeDAO.searchValueType();
		
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
					argArray.add("%"+srcParam+"%");
					argArray.add("%"+srcParam+"%");
					argArray.add("%"+srcParam+"%");
		    		conditionDAO.setArgArray(argArray);
					setConditions(conditionDAO.searchConditionByAnyLike());
					res="success";
				} 
			}
    	}
		else {
			argArray = new ArrayList<String>();
			argArray.add(idSite);
			conditionDAO.setArgArray(argArray);
			setConditions(conditionDAO.searchConditionByIdSite());
			res="success";
		} 
		return res;
    }
    
	public String deviceDelete() throws Exception {
		for(int cnt=0;cnt<idConditionIdSiteIdDevices.size();cnt++){
			argArray = new ArrayList<String>();
			int firstCommaPost = idConditionIdSiteIdDevices.get(cnt).indexOf(",");
			int lastCommaPost = idConditionIdSiteIdDevices.get(cnt).lastIndexOf(",");
			argArray.add(idConditionIdSiteIdDevices.get(cnt).substring(0 , firstCommaPost));
			argArray.add(idConditionIdSiteIdDevices.get(cnt).substring(firstCommaPost + 1, lastCommaPost));
			argArray.add(idConditionIdSiteIdDevices.get(cnt).substring(lastCommaPost + 1));
			
			//System.out.println("Actuator Kode: " + idActuatorIdRelays.get(cnt).substring(0 , iend));
			//System.out.println("Relay Kode: " + idActuatorIdRelays.get(cnt).substring(idActuatorIdRelays.get(cnt).lastIndexOf(",") + 1));
			conditionDAO.setArgArray(argArray);
			conditionDAO.conditionDelete();
		}
		argArray = new ArrayList<String>();
		argArray.add(idSite);
		conditionDAO.setArgArray(argArray);
		setConditions(conditionDAO.searchConditionByIdSite());
		return "success";
	}


	public String deviceAdd() throws Exception {
		return "add";
	}


	public ArrayList<String> getIdConditionIdSiteIdDevices(){
			return idConditionIdSiteIdDevices;
		}
			
	public void setIdConditionIdSiteIdDevices(ArrayList<String> idConditionIdSiteIdDevices){
			this.idConditionIdSiteIdDevices=idConditionIdSiteIdDevices;
		}


	public ArrayList<Condition> getConditions(){
		return conditions;
	}
		
	public void setConditions(ArrayList<Condition> conditions){
		this.conditions=conditions;
	}

	public String getSrcParam(){
		return srcParam;
	}
	
	public void setSrcParam(String srcParam){
		this.srcParam = srcParam;
	}

	public String getIdSite(){
		return idSite;
	}
	
	public void setIdSite(String idSite){
		this.idSite = idSite;
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

	public ArrayList<ValueType> getValueTypes(){
		return valueTypes;
	}
	
	public void setValueTypes(ArrayList<ValueType> valueTypes){
		this.valueTypes = valueTypes;
	}

	public List<String> getOperands(){
		return operands;
	}

	public void setOperands(List<String> operands){
		this.operands = operands;
	}
}
