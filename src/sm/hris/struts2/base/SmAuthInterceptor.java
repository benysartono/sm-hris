package sm.hris.struts2.base;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import sm.hris.struts2.base.db.MenuDAO;
import sm.hris.struts2.base.db.Menu;

import sm.hris.struts2.base.db.RoleUser;
import sm.hris.struts2.base.db.RoleUserDAO;

@ParentPackage(value = "hris")
public class SmAuthInterceptor implements Interceptor, ServletRequestAware{
    //private static final long serialVersionUID = 7353477345330099548L;
	private Map<String, Object> session;
	private HttpServletRequest request = null;

	private Menu menu = new Menu();
    private ArrayList<Menu> menus;
	private MenuDAO menuDAO = new MenuDAO();

    @Override
    public void destroy() {
    	System.out.println("Inside Destroy - smAuthInterceptor");
        //release resources here
    }
 
    @Override
    public void init() {
    	System.out.println("Inside Init");
        // create resources here
    }
 
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        System.out.println("inside auth interceptor");
        Map<String, Object> session = actionInvocation.getInvocationContext().getSession();
        //HttpServletResponse response = (HttpServletResponse)actionInvocation.getInvocationContext().getActionInvocation();         
        //String userid = (String) sessionAttributes.get("USER");
        
        if(session.get("userId") == null){
        	return "loginx";
        } else {
            HttpServletRequest request = ServletActionContext.getRequest(); 
            String url = request.getRequestURI(); 
            menuDAO.setUrl(url);
            menuDAO.setIdUser(String.valueOf(session.get("userId")));
            String access = menuDAO.checkRoleAccess();
        	if(access == "unAuthorized"){ 
        			return "loginx";
        	}
        }
        return actionInvocation.invoke();

    }

	@Override
	public void setServletRequest(HttpServletRequest httpservletrequest) {
		// TODO Auto-generated method stub
		this.request = httpservletrequest;
	}

} 