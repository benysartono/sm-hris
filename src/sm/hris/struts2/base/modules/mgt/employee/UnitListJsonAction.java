package sm.hris.struts2.base.modules.mgt.employee;

import java.util.ArrayList;

import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.Unit;
import sm.hris.struts2.base.db.UnitDAO;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

@Result(name="success",type="json")
@ParentPackage("hris")

public class UnitListJsonAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
	private UnitDAO unitDAO = new UnitDAO();
    private ArrayList<Unit> units;
    private String idDept = new String();
    //private ArrayList<String> formArg = new ArrayList<String>();
    //private String formArg = new String();
    private String res = new String();
    
    public String execute() throws Exception{
    	if(!(idDept.equals(null)||idDept.equals(""))){
	    		System.out.println("Sempet Masuk UnitListJson idDept = " + idDept);
				//formArg .add(idDept);
				units = unitDAO.searchUnitBaseOnDept(idDept);
				res="success";
		}
			else {
	    		System.out.println("Sempet Masuk UnitListJson idDept null --");
				units = unitDAO.searchUnit();
				res="success";
			} 
		return res;
		}

	public ArrayList<Unit> getUnits(){
		return units;
	}
	
	public void setUnits(ArrayList<Unit> units){
		this.units = units;
	}
	
	//public String getIdDept(){
	//	return idDept;
	//}
	
	public void setIdDept(String idDept){
		this.idDept = idDept;
	}

}
