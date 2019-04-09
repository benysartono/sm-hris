package sm.hris.struts2.base;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

@ParentPackage(value = "hris")
public class SmAuthInterceptor implements Interceptor, ServletRequestAware{
    //private static final long serialVersionUID = 7353477345330099548L;
	private Map<String, Object> session;
	private HttpServletRequest request = null;
    
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
        	System.out.println("inside unauth");
        	return "loginx";
        }
        return actionInvocation.invoke();

    }

	@Override
	public void setServletRequest(HttpServletRequest httpservletrequest) {
		// TODO Auto-generated method stub
		this.request = httpservletrequest;
	}

} 