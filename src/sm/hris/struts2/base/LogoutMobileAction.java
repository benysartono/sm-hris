package sm.hris.struts2.base;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import org.apache.commons.codec.digest.DigestUtils;

import sm.hris.struts2.base.db.EmployeeDAO;
import sm.hris.struts2.base.db.Employee;

import java.util.ArrayList;
import java.util.Map;


import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "hris")

public class LogoutMobileAction extends ActionSupport implements SessionAware {
    private static final long serialVersionUID = 7353477345330099548L;
	private Map<String, Object> sessionAttributes;

	public String execute() throws Exception {
				sessionAttributes.put("userId", null);
				setSession(sessionAttributes);
				addActionMessage("<p>Re-Login</p><p><a href='login-mobile'>Click Here to Re-Login</a></p>");
				return "pass";
			}
		
	
		
	@Override
	public void setSession(Map<String, Object> sessionAttr) {
		// TODO Auto-generated method stub
		this.sessionAttributes = sessionAttr;
	}


}
