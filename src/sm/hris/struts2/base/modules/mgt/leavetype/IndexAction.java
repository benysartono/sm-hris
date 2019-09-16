package sm.hris.struts2.base.modules.mgt.leavetype;

import java.util.ArrayList;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.LeaveType;
import sm.hris.struts2.base.db.LeaveTypeDAO;


@Results({
	//@Result(name="add", location="/base/modules/mgt/leavetype/add-leave-type", type="redirect"),
	})
@ParentPackage(value = "hris")

public class IndexAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
    private LeaveType leaveType = new LeaveType();
    private LeaveTypeDAO leaveTypeDAO = new LeaveTypeDAO();
    private ArrayList<LeaveType> leaveTypes;
    private ArrayList<String> formArg = new ArrayList<String>();
    private ArrayList<String> idLeaveTypes = new ArrayList<String>();
    private String proc = new String();
    private String res = new String();
    private String searchPrm = new String();
    
    public String execute() throws Exception{
    	if(proc.equals("Add")){
    		res = addLeaveType();
    	}
    	if(proc.equals("Delete")){
    		res = deleteLeaveType();
    	}
		if(!(proc.equals("Add")||proc.equals("Delete"))){
	    	if (!searchPrm.equals("")) {
				formArg.add("%"+searchPrm+"%");
				leaveTypeDAO.setArgArray(formArg);
				leaveTypes = leaveTypeDAO.searchLeaveTypeByDescriptionLike();
				res="success";
			} 
			else {
				leaveTypes = leaveTypeDAO.searchLeaveType();
				res="success";
			} 
		}
		return res;
    }
    
  
	public String deleteLeaveType() throws Exception {
		leaveTypeDAO.setArgArray(idLeaveTypes);
		leaveTypeDAO.deleteLeaveType();
		leaveTypes = leaveTypeDAO.searchLeaveType();
		return "success";
	}

	public String addLeaveType() throws Exception {
		return "add";
	}

	public LeaveType getLeaveType(){
		return leaveType;
	}
		
	public void setLeaveType(LeaveType leaveType){
		this.leaveType=leaveType;
	}

	public ArrayList<String> getIdLeaveTypes(){
			return idLeaveTypes;
		}
			
	public void setIdLeaeTypes(ArrayList<String> idLeaveTypes){
			this.idLeaveTypes=idLeaveTypes;
		}
	
	public ArrayList<LeaveType> getLeaveTypes(){
		return leaveTypes;
	}

	public void setLeaveTypes(ArrayList<LeaveType> leaveTypes){
		this.leaveTypes=leaveTypes;
	}


	public void setProc(String proc) {
        this.proc = proc;
    }

	public String getSearchPrm(){
		return searchPrm;
	}
		
	public void setSearchPrm(String searchPrm){
		this.searchPrm=searchPrm;
	}


}
