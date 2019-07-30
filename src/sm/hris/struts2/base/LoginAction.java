package sm.hris.struts2.base;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import org.apache.commons.codec.digest.DigestUtils;

import sm.hris.struts2.base.db.EmployeeDAO;
import sm.hris.struts2.base.db.Employee;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ValidationAware;
import com.opensymphony.xwork2.ValidationAwareSupport;

@Result(name="pass", location="/base/index", type="redirect")
@ParentPackage(value = "hris")

public class LoginAction extends ActionSupport implements SessionAware {
    private static final long serialVersionUID = 7353477345330099548L;
    private String uid;
    private String password;
    //private String mdPassword;
	private Map<String, Object> sessionAttributes;
    private ArrayList<Employee> employees;
	private EmployeeDAO employeeDAO = new EmployeeDAO();
	private ArrayList<String> argArray = new ArrayList<String>();
	private Map session = ActionContext.getContext().getSession();

	public String execute() throws Exception {
		if (uid==null){
			System.out.println("Belum Benar " + uid);
			//addActionMessage("<p>Login Fail</p>");
			return SUCCESS;
		} else {
			argArray.add(uid);
			argArray.add(password);
			System.out.println("Passworde: " + password);
			employeeDAO.setArgArray(argArray);
			employees = employeeDAO.searchEmployeeLogin();

			if (employees.isEmpty()) {
				addActionError("<p>Login Fail</p>");
				return SUCCESS;
			}
			else {
				session.put("userId", uid);
				//sessionAttributes.put("userId", uid);
				//setSession(sessionAttributes);
				//addActionMessage("<p>Login Pass</p><p><a href='index'>Click Here to Enter</a></p>");
				return "pass";
			}
		}
		
    }
	
		
	@Override
	public void setSession(Map<String, Object> sessionAttr) {
		// TODO Auto-generated method stub
		this.sessionAttributes = sessionAttr;
	}

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = DigestUtils.md5Hex(password).toUpperCase();
    }
}
