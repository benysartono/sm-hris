package sm.hris.struts2.base;
import java.util.ArrayList;
import java.util.Map;

import sm.hris.struts2.base.LoginAction;

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
    private String baseUrl = "";
    private String url; 

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

        HttpServletRequest request = ServletActionContext.getRequest(); 
        url = request.getRequestURI();
        baseUrl = "";
        int iUrlEnd = url.indexOf("?");
        if (iUrlEnd != -1){
        	baseUrl = url.substring(0,iUrlEnd);
        } else {
        	baseUrl = url;
        }

        
        if(session.get("userId") == null){
        	System.out.println("Dalam if session is null");
        	LoginAction loginAction = new LoginAction();
        	loginAction.setRequestedUrl(url);
        	return "loginx";
        } else {
        	System.out.println("Dalam if session is not null");
            System.out.println("baseUrl nya --: " + baseUrl);
            
            menuDAO.setUrl(baseUrl);
            menuDAO.setIdUser(String.valueOf(session.get("userId")));
            String access = menuDAO.checkRoleAccess();
        	if(access == "unAuthorized"){ 
            	LoginAction loginAction = new LoginAction();
            	loginAction.setRequestedUrl(url);
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