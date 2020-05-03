package sm.hris.struts2.base.modules.mqtt;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.Actuator;
import sm.hris.struts2.base.db.ActuatorDAO;

@Results({
	@Result(name="tolist", location="/base/modules/mqtt/", type="redirect"),
	})
@ParentPackage(value = "hris")

public class IndexEditAction extends ActionSupport {
    private static final long serialVersionUID = 7353477345330099548L;
	private ActuatorDAO actuatorDAO = new ActuatorDAO();
    private Actuator actuator = new Actuator();
    private String proc;
    
    public String execute() throws Exception{
    	if((proc != null)&&(proc.equals("Submit"))) {
	   		actuatorDAO.setActuator(actuator);
	   		actuatorDAO.actuatorEdit();
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
}
