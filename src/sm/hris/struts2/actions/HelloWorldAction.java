package sm.hris.struts2.actions;


import com.opensymphony.xwork2.ActionSupport;

public class HelloWorldAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	  private String message;
	  
	  public String getMessage() {
	    return message;
	  }
	 
	  public String execute() {
	    message = "Hello World!";
	    return SUCCESS;
	  }	
}