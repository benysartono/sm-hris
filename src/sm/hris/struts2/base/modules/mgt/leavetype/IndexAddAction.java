package sm.hris.struts2.base.modules.mgt.leavetype;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import sm.hris.struts2.base.db.LeaveType;
import sm.hris.struts2.base.db.LeaveTypeDAO;

import sm.hris.struts2.base.SmBaseAction;

@Results({
	@Result(name="tolist", location="/base/modules/mgt/leavetype/index", type="redirect"),
})
@ParentPackage(value = "hris")

public class IndexAddAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
    private LeaveType leaveType = new LeaveType();
    private LeaveTypeDAO leaveTypeDAO = new LeaveTypeDAO();
    private String proc = new String();
	
	public String execute() throws Exception {
		if(proc.equals("Submit")){
				leaveTypeDAO.setLeaveType(leaveType);
			    leaveTypeDAO.addLeaveType();
				return "tolist";
		} else {
			return SUCCESS; 
		}	
	}

	public LeaveType getLeaveType(){
		return leaveType;
	}

	public void setLeaveType(LeaveType leaveType){
		this.leaveType = leaveType;
	}
	
	public String getProc(){
		return proc;
	}

	public void setProc(String proc){
		this.proc = proc;
	}

}


	