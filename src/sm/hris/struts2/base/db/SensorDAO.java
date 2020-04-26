package sm.hris.struts2.base.db;
 
import java.util.ArrayList;
//import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;
import sm.hris.struts2.base.db.Sensor;

public class SensorDAO extends SmBaseDAO{
 
	private Sensor sensor = new Sensor();
	private ArrayList<Sensor> sensors = new ArrayList<Sensor>();
    private ArrayList<String> argArray = new ArrayList<String>();

	public ArrayList<Sensor> searchSensor() throws SQLException{
        ResultSet rs = this.runQuery("searchSensor");
            while (rs.next()) {
            	Sensor sensor = new Sensor();
            	sensor.setIdSensor(rs.getString("idSensor"));
            	sensor.setIdSensorType(rs.getString("idSensorType"));
            	sensor.setValue(rs.getString("value"));
            	sensor.setIdSite(rs.getString("idSite"));
            	sensor.setUpdatedTime(rs.getString("updatedTime"));
            	sensors.add(sensor);
            } 
        	
            if(rs != null){
     		   try {
     		   rs.close();
     		   } catch (SQLException e) {
     		        System.out.println("Exception while closing result set: " + e);
     		   }
     		}
        	//closeConnection();
        	return sensors;
        
    }

	public void sensorDelete() throws SQLException{
		for(int i=0;i<argArray.size();i++) {
			ArrayList<String> argArray2 = new ArrayList<String>();
			argArray2.add(argArray.get(i));
			this.run("sensorDelete", argArray.get(i));
		}
		//closeConnection();
    }

	public void sensorAdd() throws SQLException{
		argArray = new ArrayList<String>();
		argArray.add(0, sensor.getIdSite());
		argArray.add(1, sensor.getIdSensor());
		argArray.add(2, sensor.getIdSensorType());
		argArray.add(3, sensor.getValue());
		argArray.add(4, sensor.getUpdatedTime().toString());
		this.run("SensorAdd", argArray);
		//closeConnection();
    }
	
	public void sensorEdit() throws SQLException{
		argArray = new ArrayList<String>();
		argArray.add(0, sensor.getIdSite());
		argArray.add(1, sensor.getIdSensor());
		argArray.add(2, sensor.getIdSensorType());
		argArray.add(3, sensor.getValue());
		argArray.add(4, sensor.getUpdatedTime().toString());
		argArray.add(5, sensor.getIdSite());
		argArray.add(6, sensor.getIdSensor());
		this.run("SensorEdit", argArray);
		//closeConnection();
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

	public Sensor getSensor(){
		return sensor;
	}
	
	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}
	

	
}