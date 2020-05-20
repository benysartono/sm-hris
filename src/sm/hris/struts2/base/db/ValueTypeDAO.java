package sm.hris.struts2.base.db;
 
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionContext;

//import java.util.List;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import sm.hris.struts2.base.db.ValueType;
import sm.hris.struts2.base.db.SmBaseDAO;


public class ValueTypeDAO extends SmBaseDAO{
	private ValueType valueType = new ValueType();
	private ArrayList<ValueType> valueTypes = new ArrayList<ValueType>();
    private String idValueType;
    private ArrayList<String> argArray = new ArrayList<String>();
    private String srcParam;

	
	public ArrayList<ValueType> searchValueType() throws SQLException{
			ResultSet rs = this.runQuery("searchValueType");
            while (rs.next()) {
                ValueType valueType = new ValueType();
                valueType.setIdValueType(rs.getString("idValueType"));
                valueType.setNmValueType(rs.getString("nmValueType"));
                valueTypes.add(valueType);
            }
            //this.con.close();
        	return valueTypes;
        
    }
	
	public ArrayList<ValueType> searchValueTypeById() throws SQLException{
		argArray.add(idValueType);
        ResultSet rs = this.runQuery("searchValueTypeById",argArray);
        while (rs.next()) {
            ValueType valueType = new ValueType();
            valueType.setIdValueType(rs.getString("idValueType"));
            valueType.setNmValueType(rs.getString("nmValueType"));
            valueTypes.add(valueType);
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
        return valueTypes;
    }

	public ArrayList<ValueType> searchValueTypeByAnyLike() throws SQLException{
        ResultSet rs = this.runQuery("searchValueTypeByAnyLike",argArray);
        while (rs.next()) {
            ValueType valueType = new ValueType();
            valueType.setIdValueType(rs.getString("idValueType"));
            valueType.setNmValueType(rs.getString("nmValueType"));
            valueTypes.add(valueType);
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
       	return valueTypes;
    }

	public void valueTypeDelete() throws SQLException{
		for(int cnt=0;cnt<argArray.size();cnt++){
			this.run("valueTypeDelete", argArray.get(cnt));
		}
	}

	public void valueTypeAdd() throws SQLException{
		argArray.add(0, valueType.getIdValueType());
		argArray.add(1, valueType.getNmValueType());
		this.run("valueTypeAdd", argArray);
	    //this.con.close();
		//closeConnection();
    }
	
	public void valueTypeEdit() throws SQLException{
		argArray.add(0, valueType.getIdValueType());
		argArray.add(1, valueType.getNmValueType());
		argArray.add(2, valueType.getIdValueType());
		argArray.add(3, valueType.getNmValueType());
		this.run("valueTypeEdit", argArray);
        //this.con.close();
		//closeConnection();
	}
	
	public void setValueType(ValueType valueType){
		this.valueType = valueType;
	}
	
	public ValueType getValueType(){
		return valueType;
	}

	public void setValueTypes(ArrayList<ValueType> valueTypes){
		this.valueTypes = valueTypes;
	}
	
	public ArrayList<ValueType> getValueTypes(){
		return valueTypes;
	}

	public void setIdValueType(String idValueType){
		this.idValueType = idValueType;
	}
	
	public String getIdValueType(){
		return idValueType;
	}

	public void setSrcParam(String srcParam){
		this.srcParam = srcParam;
	}
	
	public String getSrcParam(){
		return srcParam;
	}

	public void setArgArray(ArrayList<String> argArray){
		this.argArray = argArray;
	}
	
	public ArrayList<String> getArgArray(){
		return argArray;
	}

}