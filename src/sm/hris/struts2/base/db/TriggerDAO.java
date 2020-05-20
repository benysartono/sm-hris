package sm.hris.struts2.base.db;
 
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionContext;

//import java.util.List;

import java.sql.ResultSet;
import java.sql.SQLException;
import sm.hris.struts2.base.db.Trigger;
import sm.hris.struts2.base.db.SmBaseDAO;


public class TriggerDAO extends SmBaseDAO{
	private Trigger trigger = new Trigger();
	private ArrayList<Trigger> triggers = new ArrayList<Trigger>();
    private String idTrigger;
    private ArrayList<String> argArray = new ArrayList<String>();
    private String idSite;

	private Map<String, Object> sessionAttributes;
	private Map session = ActionContext.getContext().getSession();
	
	public ArrayList<Trigger> searchTrigger() throws SQLException{
        	ResultSet rs = this.runQuery("searchTrigger",argArray);
            while (rs.next()) {
                Trigger trigger = new Trigger();
                trigger.setIdCondition(rs.getString("idCondition"));
                trigger.setIdActuator(rs.getString("idActuator"));
                trigger.setIdRelay(rs.getInt("idRelay"));
                trigger.setCommand(rs.getInt("command"));
                trigger.setIdSite(rs.getString("idSite"));
                trigger.setUpdatedTime(rs.getString("updatedTime"));
                trigger.setUpdatedBy(rs.getString("updatedBy"));
                trigger.setCreatedTime(rs.getString("createdTime"));
                trigger.setCreatedBy(rs.getString("createdBy"));
                
                triggers.add(trigger);
            }
            //this.con.close();
        	return triggers;
        
    }
	
	public ArrayList<Trigger> searchTriggerByIdCondition() throws SQLException{
        ResultSet rs = this.runQuery("searchTriggerByIdCondition",argArray);
 
            while (rs.next()) {
                Trigger trigger = new Trigger();
                trigger.setIdCondition(rs.getString("idCondition"));
                trigger.setIdActuator(rs.getString("idActuator"));
                trigger.setIdRelay(rs.getInt("idRelay"));
                trigger.setCommand(rs.getInt("command"));
                trigger.setIdSite(rs.getString("idSite"));
                trigger.setUpdatedTime(rs.getString("updatedTime"));
                trigger.setUpdatedBy(rs.getString("updatedBy"));
                trigger.setCreatedTime(rs.getString("createdTime"));
                trigger.setCreatedBy(rs.getString("createdBy"));
                
                triggers.add(trigger);
            } 
        	/*
            if(rs != null){
     		   try {
     		   rs.close();
     		   } catch (SQLException e) {
     		        System.out.println("Exception while closing result set: " + e);
     		   }
     		}
        	closeConnection();
        	*/
            //this.con.close();
        	return triggers;
    }

	public void triggerDelete() throws SQLException{
		//for(int cnt=0;cnt<triggers.size();cnt++){
			this.run("triggerDelete", argArray);
		//}
	}

	public void triggerAdd() throws SQLException{
		
			argArray.add(0, trigger.getIdCondition());
			argArray.add(1, trigger.getIdActuator());
			argArray.add(2, String.valueOf(trigger.getIdRelay()));
			argArray.add(3, String.valueOf(trigger.getCommand()));
			argArray.add(4, trigger.getIdSite());
			argArray.add(5, trigger.getUpdatedBy());
			argArray.add(6, trigger.getCreatedBy());
			this.run("triggerAdd", argArray);
	        //this.con.close();
			//closeConnection();
    }
	
	public void triggerEdit() throws SQLException{
		
		argArray.add(0, trigger.getIdCondition());
		argArray.add(1, trigger.getIdActuator());
		argArray.add(2, String.valueOf(trigger.getIdRelay()));
		argArray.add(3, String.valueOf(trigger.getCommand()));
		argArray.add(4, trigger.getIdSite());
		argArray.add(5, trigger.getUpdatedBy());
		argArray.add(6, trigger.getCreatedBy());
		argArray.add(7, trigger.getIdCondition());
		argArray.add(8, trigger.getIdActuator());
		argArray.add(9, String.valueOf(trigger.getIdRelay()));
		argArray.add(10, trigger.getIdSite());
		this.run("triggerEdit", argArray);
        //this.con.close();
		//closeConnection();
	}
	
	public void setTrigger(Trigger trigger){
		this.trigger = trigger;
	}
	
	public Trigger getTrigger(){
		return trigger;
	}

	public void setTriggers(ArrayList<Trigger> triggers){
		this.triggers = triggers;
	}
	
	public ArrayList<Trigger> getTriggers(){
		return triggers;
	}

	public void setArgArray(ArrayList<String> argArray){
		this.argArray = argArray;
	}
	
	public ArrayList<String> getArgArray(){
		return argArray;
	}



}