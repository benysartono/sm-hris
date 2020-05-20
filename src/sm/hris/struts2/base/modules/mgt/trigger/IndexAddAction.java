package sm.hris.struts2.base.modules.mgt.trigger;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.Trigger;
import sm.hris.struts2.base.db.TriggerDAO;
import sm.hris.struts2.base.db.Condition;
import sm.hris.struts2.base.db.ConditionDAO;
import sm.hris.struts2.base.db.Actuator;
import sm.hris.struts2.base.db.ActuatorDAO;
import sm.hris.struts2.base.db.EmployeeDAO;

@Results({
	@Result(name="tolist", location="/base/modules/trigger/index", type="redirect"),
	})
@ParentPackage(value = "hris")

public class IndexAddAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
	private EmployeeDAO employeeDAO = new EmployeeDAO();
	private ConditionDAO conditionDAO = new ConditionDAO();
	private ArrayList<Condition> conditions = new ArrayList<Condition>();
	private ActuatorDAO actuatorDAO = new ActuatorDAO();
	private ArrayList<Actuator> actuators = new ArrayList<Actuator>();
	private TriggerDAO triggerDAO = new TriggerDAO();
    private Trigger trigger = new Trigger();
    private String proc;
    private ArrayList<String> argArray = new ArrayList<String>();
	private Map session = ActionContext.getContext().getSession();
	private String userId = String.valueOf(session.get("userId"));
    
    public String execute() throws Exception{
    	argArray.add(userId);
    	String idSite = employeeDAO.searchEmployeeByUid(argArray).get(0).getIdSite();
    	argArray = new ArrayList<String>();
    	argArray.add(idSite);
    	conditionDAO.setArgArray(argArray);
    	conditions = conditionDAO.searchConditionByIdSite();
    	actuatorDAO.setArgArray(argArray);
    	actuators = actuatorDAO.searchActuatorByIdSite();

    	if((proc != null)&&(proc.equals("Submit"))) {
	   		triggerDAO.setTrigger(trigger);
	   		triggerDAO.triggerAdd();
			return "tolist";
    	}
    	return SUCCESS;
    }
	
    public Trigger getTrigger(){
		return trigger;
	}
	
	public void setTrigger(Trigger trigger){
		this.trigger = trigger;
	}

    public String getProc(){
		return proc;
	}
	
	public void setProc(String proc){
		this.proc = proc;
	}
	
	public ArrayList<Condition> getConditions(){
		return conditions;
	}
	
	public void setCoditions(ArrayList<Condition> conditions){
		this.conditions = conditions;
	}

	public ArrayList<Actuator> getActuators(){
		return actuators;
	}
	
	public void setActuators(ArrayList<Actuator> actuators){
		this.actuators = actuators;
	}

}
