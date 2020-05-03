package sm.hris.struts2.base.modules.devicetrx;

import java.util.ArrayList;
import java.util.Map;

import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.EmployeeDAO;
import sm.hris.struts2.base.db.DeviceTrx;
import sm.hris.struts2.base.db.DeviceTrxDAO;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Result(name="success",type="json")
@ParentPackage("hris")

public class SearchDeviceTrxByIdSiteJsonAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
	private EmployeeDAO employeeDAO = new EmployeeDAO();
	private DeviceTrxDAO deviceTrxDAO = new DeviceTrxDAO();
    private ArrayList<DeviceTrx> deviceTrxs = new ArrayList<DeviceTrx>();
    private ArrayList<String> argArray = new ArrayList<String>();
    private String res = new String();
	private Map session = ActionContext.getContext().getSession();
	private String userId = String.valueOf(session.get("userId"));
    
    public String execute() throws Exception{
    	argArray.add(userId);
    	String idSite = employeeDAO.searchEmployeeByUid(argArray).get(0).getIdSite();
    	argArray = new ArrayList<String>();
    	argArray.add(idSite);
    	deviceTrxDAO.setArgArray(argArray);
		deviceTrxs = deviceTrxDAO.searchDeviceTrxByIdSite();
		return SUCCESS;
		}

	public ArrayList<DeviceTrx> getDeviceTrxs(){
		return deviceTrxs;
	}
	
	public void setDeviceTrxs(ArrayList<DeviceTrx> deviceTrxs){
		this.deviceTrxs = deviceTrxs;
	}
}
