package sm.hris.struts2.base.modules.mgt.trigger;


import java.util.ArrayList;
import java.util.Map;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.convention.annotation.ParentPackage;

import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.Trigger;
import sm.hris.struts2.base.db.TriggerDAO;
import sm.hris.struts2.base.db.Condition;
import sm.hris.struts2.base.db.ConditionDAO;
import sm.hris.struts2.base.db.Actuator;
import sm.hris.struts2.base.db.ActuatorDAO;
import sm.hris.struts2.base.db.EmployeeDAO;

import sm.hris.struts2.base.SmBaseAction;

@ParentPackage(value = "hris")

public class IndexAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
    private ArrayList<Trigger> triggers;
    private String srcParam;
    private ArrayList<String> argArray = new ArrayList<String>();
    private ArrayList<String> idTriggers = new ArrayList<String>();
    private ArrayList<String> idTriggerIdRelays = new ArrayList<String>();
    private ArrayList<String> idTriggerIdRelayCmds = new ArrayList<String>();
    private String idTriggerIdRelayCmd;
    private String proc;
    private String res;
	private String idTrigger;
	private String IdRelay;
	private String Command;
	private int oppCommand;
	
	private EmployeeDAO employeeDAO = new EmployeeDAO();
	private TriggerDAO triggerDAO = new TriggerDAO();
    private Trigger trigger = new Trigger();

    
	//private String broker = "tcp://m12.cloudmqtt.com:11880";
	private Map session = ActionContext.getContext().getSession();
	private String userId = String.valueOf(session.get("userId"));
	private String idSite;
	private ArrayList<String> idConditionIdActuatorIdRelayIdSite = new ArrayList<String>();
	
    public String execute() throws Exception{
    	argArray.add(userId);
    	idSite = employeeDAO.searchEmployeeByUid(argArray).get(0).getIdSite();
    	argArray = new ArrayList<String>();
    	argArray.add(idSite);
    	triggerDAO.setArgArray(argArray);
		triggers = triggerDAO.searchTrigger();

    	if (proc != null){
    		if(proc.equals("Add")){
	    		res= triggerAdd();
	    	}
	    	if(proc.equals("delete")){
	    		res= triggerDelete();
	    	}
    	}
		else {
			argArray = new ArrayList<String>();
			argArray.add(idSite);
    		triggerDAO.setArgArray(argArray);
			setTriggers(triggerDAO.searchTrigger());
			res="success";
		} 
		return res;
    }
    
    public String triggerAdd(){
    	return "add";
    }
    
	public String triggerDelete() throws Exception {
		for(int cnt=0;cnt<idConditionIdActuatorIdRelayIdSite.size();cnt++){
			argArray = new ArrayList<String>();
			argArray = chunkString(idConditionIdActuatorIdRelayIdSite.get(cnt),",");
			triggerDAO.setArgArray(argArray);
			triggerDAO.triggerDelete();
		}
		argArray = new ArrayList<String>();
		argArray.add(idSite);
		triggerDAO.setArgArray(argArray);
		setTriggers(triggerDAO.searchTrigger());
		return "success";
	}
	
	public ArrayList<String> chunkString(String inputString, String delimiter){
		ArrayList<String> chunkInputString = new ArrayList<String>();
		String tempString = inputString;
		while(tempString.indexOf(delimiter)!=-1){
			chunkInputString.add(tempString.substring(0,tempString.indexOf(delimiter)));
			tempString = tempString.substring(tempString.indexOf(delimiter)+1);
		}
		chunkInputString.add(tempString);
		return chunkInputString;
	}
	


	
	public ArrayList<String> getIdTriggers(){
			return idTriggers;
		}
			
	public void setIdTriggers(ArrayList<String> idTriggers){
			this.idTriggers=idTriggers;
		}
	
	public String getSrcParam(){
		return srcParam;
	}
	
	public void setSrcParam(String srcParam){
		this.srcParam = srcParam;
	}

	public String getProc(){
		return proc;
	}

	public void setProc(String proc) {
        this.proc = proc;
    }

	public void setTriggers(ArrayList<Trigger> triggers){
		this.triggers = triggers;
	}
	
	public ArrayList<Trigger> getTriggers(){
		return triggers;
	}

	public void setIdTriggerIdRelays(ArrayList<String> idTriggerIdRelays){
		this.idTriggerIdRelays = idTriggerIdRelays;
	}

	public void setIdTriggerIdRelayCmds(ArrayList<String> idTriggerIdRelayCmds){
		this.idTriggerIdRelayCmds = idTriggerIdRelayCmds;
	}

	public void setIdTriggerIdRelayCmd(String idTriggerIdRelayCmd){
		this.idTriggerIdRelayCmd = idTriggerIdRelayCmd;
	}

	public void setIdTrigger(String idTrigger){
		this.idTrigger = idTrigger;
	}

	public void setIdRelay(String IdRelay){
		this.IdRelay = IdRelay;
	}

	public void setCommand(String command){
		this.Command = command;
	}
	
	public Trigger getTrigger(){
		return trigger;
	}
	
	public void setTrigger(Trigger trigger){
		this.trigger = trigger;
	}
	
	public void setIdConditionidActuatorIdRelayIdSite(ArrayList<String> idConditionidActuatorIdRelayIdSite) {
		this.idConditionIdActuatorIdRelayIdSite = idConditionidActuatorIdRelayIdSite;
	}



}
