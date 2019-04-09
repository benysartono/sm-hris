package sm.hris.struts2.base.modules.mgt.employee.reports;

//import com.lowagie.text.pdf.codec.Base64.OutputStream;
//import com.mysql.fabric.Response;
//import com.lowagie.text.pdf.codec.Base64.InputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
//import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.util.List;
import java.util.ArrayList;
//import java.util.List;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.Employee;
import sm.hris.struts2.base.db.EmployeeDAO;
import sm.hris.struts2.base.db.EmployeeFR;
import sm.hris.struts2.base.db.Menu;
import sm.hris.struts2.base.db.MenuDAO;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


public class EmployeeListAction extends SmBaseAction {
    private static final long serialVersionUID = 7353477345330099548L;
    //private Employee employee;
	private EmployeeDAO employeeDAO = new EmployeeDAO();
    private ArrayList<EmployeeFR> employees;
    private ArrayList<String> argArray = new ArrayList<String>();
    private String res = new String();
    private String jasperPath = ServletActionContext.getServletContext().getRealPath("/WEB-INF/content/reports/");
    private JasperPrint jp = new JasperPrint();
    //private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private File outputStream;
    private String fileURL;
    private String fileName;
    private String name;
    private Date dob1;
    private Date dob2;
    private Map parameters = new HashMap();
    private String scrToDisplay;
    //private OutputStream outputStream;
    //private byte[] outputStream;
    //private Byte bAOS;
    //private byte[] bASOs;
    //private InputStream inputStream = new InputStream(null);
    
    public String execute() throws Exception{
    	//super.listMenu();
    	if (scrToDisplay == null){
    			return "frm";
    	} 
		argArray.add("%"+name+"%");
		
		String cvtDob1 = convertDateToString(dob1);
		String cvtDob2 = convertDateToString(dob2);
		argArray.add(cvtDob1);
		argArray.add(cvtDob2);
		
    	employees = employeeDAO.searchEmployeeFRByNameAndDob(argArray);
	    JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(employees);	
	    parameters.put("TITLE","EMPLOYEE LIST REPORT");
	    try {
	    	jp = JasperFillManager.fillReport(jasperPath + "/employee-list.jasper", parameters, beanColDataSource);
	    	System.out.println("Done Executing Jasper Fill Report: ");
	    } catch (JRException e) {
	          e.printStackTrace();
		    	System.out.println("Error Executing Jasper Fill Report: -- " + e.getMessage());
	    }
	    //ServletOutputStream servletOutputStream = response.getOutputStream();
		//JasperExportManager.exportReportToPdfFile(jp, jasperPath + "/EmployeeList.pdf");
	    outputStream = File.createTempFile("output.", ".pdf", new File("C:/Bitnami/tomcatstack-7.0.67-0/apache-tomcat/webapps/reports"));
	    fileName = outputStream.getName();
	    fileURL = "http://127.0.0.1/reports/" + fileName;
	    //outputStream = new FileOutputStream(pdf);
	    //outputStream = new ByteArrayOutputStream();
	    //OutputStream outputStream = new FileOutputStream(new File(“jrxml/catalog.pdf”));
	    try {
	    	JasperExportManager.exportReportToPdfStream(jp, new FileOutputStream(outputStream));
	    	//JasperExportManager.exportReportToPdfStream(jp, outputStream);
	    	//JasperExportManager.exportReportToPdfStream(jp, outputStream);
	    	//outputStream = JasperExportManager.exportReportToPdf(jp);
	    	System.out.println("The File URL: " + fileURL);
	    }
	    catch (JRException e){
	    	e.printStackTrace();
	    	System.out.println("Error Executing Jasper Export Report: " + e.getMessage());
	    }		
		//FileInputStream fileInputStream = new FileInputStream(new File(jasperPath + "EmployeeList.pdf"));
		//fileInputStream.close();
		res="success";
		return res;
    }
    
	public String convertDateToString(Date indate)
	{
	   String dateString = null;
	   SimpleDateFormat sdfr = new SimpleDateFormat("yyyy/MM/dd");
	   /*you can also use DateFormat reference instead of SimpleDateFormat 
	    * like this: DateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
	    */
	   try{
		dateString = sdfr.format( indate );
	   }catch (Exception ex ){
		System.out.println(ex);
	   }
	   return dateString;
	}

    
    public ArrayList<EmployeeFR> getEmployees(){
		return employees;
	}
	

	public File getOutputStream(){
		return this.outputStream;
	}

	public String getFileName(){
		return this.fileName;
	}

	public String getFileURL(){
		return this.fileURL;
	}
	
	public void setScrToDisplay(String scrToDisplay){
		this.scrToDisplay = scrToDisplay;
	}

	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name = name;
	}

	public Date getDob1(){
		return this.dob1;
	}

	public void setDob1(Date dob1){
		this.dob1 = dob1;
	}

	public Date getDob2(){
		return this.dob2;
	}

	public void setDob2(Date dob2){
		this.dob2 = dob2;
	}

	public Map getParameters(){
		return this.parameters;
	}

	public void setParameters(Map parameters){
		this.parameters = parameters;
	}

}
