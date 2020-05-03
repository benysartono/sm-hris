package sm.hris.struts2.base.modules.devicetrx;


import com.opensymphony.xwork2.ActionSupport;
import sm.hris.struts2.base.SmBaseAction;

import org.apache.struts2.convention.annotation.ParentPackage;


@ParentPackage(value = "hris")

public class IndexAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
    
    public String execute() throws Exception{
    	return SUCCESS;
    }
    

}
