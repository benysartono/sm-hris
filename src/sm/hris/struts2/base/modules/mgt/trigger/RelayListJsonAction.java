package sm.hris.struts2.base.modules.mgt.trigger;

import java.util.ArrayList;
import java.util.Map;

import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.Actuator;
import sm.hris.struts2.base.db.ActuatorDAO;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;

import sm.hris.struts2.base.db.EmployeeDAO;

@Result(name="success",type="json")
@ParentPackage("hris")

public class RelayListJsonAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
    private ArrayList<String> relays = new ArrayList<String>();
    private ArrayList<String> argArray = new ArrayList<String>();
    private ArrayList<Actuator> actuators = new ArrayList<Actuator>();
    private Integer page;
    private String idActuator;
    private Integer rowStart;
    private Actuator actuator;
	private Map session = ActionContext.getContext().getSession();
	private String userId = String.valueOf(session.get("userId"));
	private EmployeeDAO employeeDAO = new EmployeeDAO();
	private String idSite;
	
    
    public String execute() throws Exception{
    	argArray.add(userId);
    	idSite = employeeDAO.searchEmployeeByUid(argArray).get(0).getIdSite();
    	rowStart = 2*(page-1);
    	argArray = new ArrayList<String>();
    	argArray.add(idActuator);
    	argArray.add(idSite);
    	//argArrayObj.add(rowStart);
    	ActuatorDAO actuatorDAO = new ActuatorDAO();
    	actuatorDAO.setArgArray(argArray);
		actuators = actuatorDAO.searchActuatorRelay();
		return SUCCESS;
	}

	public ArrayList<Actuator> getActuators(){
		return actuators;
	}
	
	public void setActuators(ArrayList<Actuator> actuators){
		this.actuators = actuators;
	}
	
	public Integer getPage(){
		return page;
	}

	public void setPage (Integer page){
		this.page = page;
	}
	
	
	public void setIdActuator (String idActuator){
		this.idActuator = idActuator;
	}
	
	public String getIdActutor(){
		return idActuator;
	}
	
}
