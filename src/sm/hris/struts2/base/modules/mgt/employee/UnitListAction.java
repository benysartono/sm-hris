package sm.hris.struts2.base.modules.mgt.employee;

import com.opensymphony.xwork2.ActionSupport;

import java.util.List;
import java.util.ArrayList;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.Employee;
import sm.hris.struts2.base.db.Unit;
import sm.hris.struts2.base.db.UnitDAO;

@ParentPackage(value = "hris")

public class UnitListAction extends SmBaseAction {
    //private static final long serialVersionUID = 7353477345330099548L;
    //private Employee employee;
    private ArrayList<Unit> units;
    private Employee employee = new Employee();
    private String idDept;

	public String execute() throws Exception {
		UnitDAO unitDAO = new UnitDAO();
		if (employee.getIdDepartment().equals(null)||employee.getIdDepartment().equals("")) {
			units = unitDAO.searchUnit();
		} else {
			//If the query is using 'Like' in the statement, then the '%' sign must include in the parameter value instead of in the statement
			//formArg.add(employee.getIdDepartment());
			units = unitDAO.searchUnitBaseOnDept(idDept);
		}
		return SUCCESS;
	}
	

	public ArrayList<Unit> getUnits(){
		return units;
	}
	
	public Employee getEmployee(){
		return employee;
	}
	
	public void setEmployee(Employee employee){
		this.employee = employee;
	}

	public void setIdDept(String idDept){
		this.idDept = idDept;
	}
}
