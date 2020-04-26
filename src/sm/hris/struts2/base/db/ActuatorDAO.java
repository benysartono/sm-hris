package sm.hris.struts2.base.db;
 
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionContext;

//import java.util.List;

import java.sql.ResultSet;
import java.sql.SQLException;
import sm.hris.struts2.base.db.Actuator;
import sm.hris.struts2.base.db.SmBaseDAO;


public class ActuatorDAO extends SmBaseDAO{
	private Actuator actuator = new Actuator();
	private ArrayList<Actuator> actuators = new ArrayList<Actuator>();
    private String idActuator;
    private ArrayList<String> argArray = new ArrayList<String>();
    private String idSite;
	private int oppCommand;
	private Map<String, Object> sessionAttributes;
	private Map session = ActionContext.getContext().getSession();


	
	public ArrayList<Actuator> searchActuator() throws SQLException{
			ResultSet rs = this.runQuery("searchActuator");
            while (rs.next()) {
                Actuator actuator = new Actuator();
                actuator.setIdActuator(rs.getString("idActuator"));
                actuator.setIdRelay(rs.getInt("idRelay"));
                actuator.setCommand(rs.getInt("command"));
                actuator.setIdSite(rs.getString("idSite"));
                actuator.setUpdatedTime(rs.getTimestamp("updatedTime"));
                actuator.setCreatedTime(rs.getTimestamp("createdTime"));
                actuator.setUpdatedBy(rs.getString("updatedBy"));
                actuator.setCreatedBy(rs.getString("createdBy"));
                
                actuators.add(actuator);
            }
            //this.con.close();
        	return actuators;
        
    }
	
	public ArrayList<Actuator> searchActuatorById() throws SQLException{
		argArray.add(idActuator);
        ResultSet rs = this.runQuery("searchActuatorById",argArray);
 
            while (rs.next()) {
                Actuator actuator = new Actuator();
                actuator.setIdActuator(rs.getString("idActuator"));
                actuator.setIdRelay(rs.getInt("idRelay"));
                actuator.setCommand(rs.getInt("command"));
                actuator.setIdSite(rs.getString("idSite"));
                actuator.setUpdatedTime(rs.getTimestamp("updatedTime"));
                actuator.setCreatedTime(rs.getTimestamp("createdTime"));
                actuator.setUpdatedBy(rs.getString("updatedBy"));
                actuator.setCreatedBy(rs.getString("createdBy"));
                
                actuators.add(actuator);
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
        	return actuators;
    }

	public ArrayList<Actuator> searchActuatorBySite() throws SQLException{
		argArray.add(idSite);
        ResultSet rs = this.runQuery("searchActuatorBySite",argArray);
 
        while (rs.next()) {
            Actuator actuator = new Actuator();
            actuator.setIdActuator(rs.getString("idActuator"));
            actuator.setIdRelay(rs.getInt("idRelay"));
            actuator.setCommand(rs.getInt("command"));
            actuator.setIdSite(rs.getString("idSite"));
            actuator.setUpdatedTime(rs.getTimestamp("updatedTime"));
            actuator.setCreatedTime(rs.getTimestamp("createdTime"));
            actuator.setUpdatedBy(rs.getString("updatedBy"));
            actuator.setCreatedBy(rs.getString("createdBy"));
            
            actuators.add(actuator);
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
        	return actuators;
    }

	public void actuatorDelete() throws SQLException{
		//for(int cnt=0;cnt<actuators.size();cnt++){
			this.run("actuatorDelete", argArray);
		//}
	}

	public void actuatorOnOff() throws SQLException{
		//for(int cnt=0;cnt<actuators.size();cnt++){
		if(actuator.getCommand()==1) oppCommand = 0;  
		if(actuator.getCommand()==0) oppCommand = 1;  
		argArray.add(0, String.valueOf(oppCommand));
		argArray.add(1, actuator.getIdActuator());
		argArray.add(2, String.valueOf(actuator.getIdRelay()));
		argArray.add(3, actuator.getIdSite());
		this.run("actuatorOnOff", argArray);
		//}
	}

	public void actuatorAdd() throws SQLException{
		
			argArray.add(0, actuator.getIdActuator());
			argArray.add(1, String.valueOf(actuator.getIdRelay()));
			argArray.add(2, actuator.getIdSite());
			argArray.add(3, session.get("userId").toString());
			this.run("actuatorAdd", argArray);
	        //this.con.close();
			//closeConnection();
    }
	
	public void actuatorEdit() throws SQLException{
		
		argArray.add(0, actuator.getIdActuator());
		argArray.add(1, String.valueOf(actuator.getIdRelay()));
		argArray.add(2, actuator.getIdSite());
		argArray.add(3, session.get("userId").toString());
		argArray.add(4, actuator.getIdActuator());
		argArray.add(5, String.valueOf(actuator.getIdRelay()));
		argArray.add(6, actuator.getIdSite());
		this.run("actuatorAdd", argArray);
        //this.con.close();
		//closeConnection();
	}
	
	public void onOff() throws SQLException{
		if (actuator.getCommand() == 1) actuator.setCommand(0);
		if (actuator.getCommand() == 0) actuator.setCommand(1);
		argArray.add(0, String.valueOf(actuator.getCommand()));
		argArray.add(1, actuator.getIdActuator());
		argArray.add(2, String.valueOf(actuator.getIdRelay()));
		argArray.add(3, actuator.getIdSite());
		this.run("actuatorAdd", argArray);
        //this.con.close();
		//closeConnection();
	}
	
	public void setActuator(Actuator actuator){
		this.actuator = actuator;
	}
	
	public Actuator getActuator(){
		return actuator;
	}

	public void setActuators(ArrayList<Actuator> actuators){
		this.actuators = actuators;
	}
	
	public ArrayList<Actuator> getActuators(){
		return actuators;
	}

	public void setIdActuator(String idActuator){
		this.idActuator = idActuator;
	}
	
	public String getIdActuator(){
		return idActuator;
	}

	public void setIdSite(String idSite){
		this.idSite = idSite;
	}
	
	public String getIdSite(){
		return idSite;
	}

	public void setArgArray(ArrayList<String> argArray){
		this.argArray = argArray;
	}
	
	public ArrayList<String> getArgArray(){
		return argArray;
	}

}