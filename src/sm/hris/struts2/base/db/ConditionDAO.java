package sm.hris.struts2.base.db;
 
import java.util.ArrayList;
//import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;
import sm.hris.struts2.base.db.Condition;

public class ConditionDAO extends SmBaseDAO{
 
	private Condition condition = new Condition();
	private ArrayList<Condition> conditions = new ArrayList<Condition>();
    private ArrayList<String> argArray = new ArrayList<String>();

	public ArrayList<Condition> searchCondition() throws SQLException{
        ResultSet rs = this.runQuery("searchCondition");
            while (rs.next()) {
            	Condition condition = new Condition();
            	condition.setIdCondition(rs.getString("idCondition"));
            	condition.setIdSite(rs.getString("idSite"));
            	condition.setIdDevice(rs.getString("idDevice"));
            	condition.setOperand(rs.getString("operand"));
            	condition.setValue(rs.getFloat("value"));
            	condition.setIdValueType(rs.getString("idValueType"));
            	condition.setNmValueType(rs.getString("nmValueType"));
            	conditions.add(condition);
            } 
        	
            if(rs != null){
     		   try {
     		   rs.close();
     		   } catch (SQLException e) {
     		        System.out.println("Exception while closing result set: " + e);
     		   }
     		}
        	//closeConnection();
        	return conditions;
        
    }

	public ArrayList<Condition> searchConditionByIdSite() throws SQLException{
        ResultSet rs = this.runQuery("searchConditionByIdSite",argArray);
        while (rs.next()) {
        	Condition condition = new Condition();
        	condition.setIdCondition(rs.getString("idCondition"));
        	condition.setIdSite(rs.getString("idSite"));
        	condition.setIdDevice(rs.getString("idDevice"));
        	condition.setOperand(rs.getString("operand"));
        	condition.setValue(rs.getFloat("value"));
        	condition.setIdValueType(rs.getString("idValueType"));
        	condition.setNmValueType(rs.getString("nmValueType"));
        	conditions.add(condition);
        } 
        	
        if(rs != null){
   		   try {
	    rs.close();
     	} catch (SQLException e) {
     	    System.out.println("Exception while closing result set: " + e);
     	   }
     	}
        //closeConnection();
        return conditions;
    }

	public void conditionDelete() throws SQLException{
		try{
			this.run("conditionDelete", argArray);
		} catch (SQLException e) {
		        System.out.println("Exception ConditionDAO.conditionDelete: " + e);
		}
    }

	public void conditionAdd() throws SQLException{
		argArray = new ArrayList<String>();
		argArray.add(0, condition.getIdCondition());
		argArray.add(1, condition.getIdSite());
		argArray.add(2, condition.getIdDevice());
		argArray.add(3, condition.getOperand());
		argArray.add(4, String.valueOf(condition.getValue()));
		argArray.add(5, condition.getIdValueType());
		this.run("ConditionAdd", argArray);
		//closeConnection();
    }
	

	public void conditionEdit() throws SQLException{
		argArray = new ArrayList<String>();
		argArray.add(0, condition.getIdCondition());
		argArray.add(1, condition.getIdSite());
		argArray.add(2, condition.getIdDevice());
		argArray.add(3, condition.getOperand());
		argArray.add(4, String.valueOf(condition.getValue()));
		argArray.add(5, condition.getIdValueType());
		argArray.add(6, condition.getIdCondition());
		argArray.add(7, condition.getIdSite());
		argArray.add(8, condition.getIdDevice());
		this.run("ConditionEdit", argArray);
		//closeConnection();
    }

	public ArrayList<Condition> searchConditionByAnyLike() throws SQLException{
        ResultSet rs = this.runQuery("searchConditionByAnyLike",argArray);
        while (rs.next()) {
        	Condition condition = new Condition();
        	condition.setIdCondition(rs.getString("idCondition"));
        	condition.setIdSite(rs.getString("idSite"));
        	condition.setIdDevice(rs.getString("idDevice"));
        	condition.setOperand(rs.getString("operand"));
        	condition.setValue(rs.getFloat("value"));
        	condition.setIdValueType(rs.getString("idValueType"));
        	condition.setNmValueType(rs.getString("nmValueType"));
        	conditions.add(condition);
        } 
       	return conditions;
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
	
//Getter Setter -------------------------------------//

	public Condition getCondition(){
		return condition;
	}
	
	public void setCondition(Condition condition) {
		this.condition = condition;
	}
	
	public void setArgArray(ArrayList<String> argArray){
		this.argArray = argArray;
	}
	
	public ArrayList<String> getArgArray(){
		return argArray;
	}

	public void setConditions(ArrayList<Condition> conditions){
		this.conditions = conditions;
	}
	
	public ArrayList<Condition> getConditions(){
		return conditions;
	}
	
}