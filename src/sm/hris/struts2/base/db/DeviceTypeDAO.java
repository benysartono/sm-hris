package sm.hris.struts2.base.db;
 
import java.util.ArrayList;
//import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;
import sm.hris.struts2.base.db.Device;

public class DeviceTypeDAO extends SmBaseDAO{
 
	private DeviceType deviceType = new DeviceType();
	private ArrayList<DeviceType> deviceTypes = new ArrayList<DeviceType>();
    private ArrayList<String> argArray = new ArrayList<String>();

	public ArrayList<DeviceType> searchDeviceType() throws SQLException{
        ResultSet rs = this.runQuery("searchDeviceType");
            while (rs.next()) {
            	DeviceType deviceType = new DeviceType();
            	deviceType.setIdDeviceType(rs.getString("idDeviceType"));
            	deviceType.setNmDeviceType(rs.getString("nmDeviceType"));
            	deviceType.setMaxRelayNbr(rs.getInt("maxRelayNbr"));
            	deviceType.setUpdatedTime(rs.getString("updatedTime"));
            	deviceTypes.add(deviceType);
            } 
        	
            if(rs != null){
     		   try {
     		   rs.close();
     		   } catch (SQLException e) {
     		        System.out.println("Exception while closing result set: " + e);
     		   }
     		}
        	//closeConnection();
        	return deviceTypes;
        
    }

	public ArrayList<DeviceType> searchDeviceTypeByIdDeviceType() throws SQLException{
        ResultSet rs = this.runQuery("searchDeviceTypeByIdDeviceType",argArray);
            while (rs.next()) {
            	DeviceType deviceType = new DeviceType();
            	deviceType.setIdDeviceType(rs.getString("idDeviceType"));
            	deviceType.setNmDeviceType(rs.getString("nmDeviceType"));
            	deviceType.setMaxRelayNbr(rs.getInt("maxRelayNbr"));
            	deviceType.setUpdatedTime(rs.getString("updatedTime"));
            	deviceTypes.add(deviceType);
            } 
        	
            if(rs != null){
     		   try {
     		   rs.close();
     		   } catch (SQLException e) {
     		        System.out.println("Exception while closing result set: " + e);
     		   }
     		}
        	//closeConnection();
        	return deviceTypes;
        
    }

	public void deviceTypeDelete() throws SQLException{
		for(int i=0;i<argArray.size();i++) {
			ArrayList<String> argArray2 = new ArrayList<String>();
			argArray2.add(argArray.get(i));
			this.run("deviceTypeDelete", argArray.get(i));
		}
		//closeConnection();
    }

	public void deviceTypeAdd() throws SQLException{
		argArray = new ArrayList<String>();
		argArray.add(0, deviceType.getIdDeviceType());
		argArray.add(1, deviceType.getNmDeviceType());
		this.run("DeviceAdd", argArray);
		//closeConnection();
    }
	

	public void deviceTypeEdit() throws SQLException{
		argArray = new ArrayList<String>();
		argArray.add(0, deviceType.getIdDeviceType());
		argArray.add(2, deviceType.getNmDeviceType());
		argArray.add(3, deviceType.getIdDeviceType());
		this.run("DeviceEdit", argArray);
		//closeConnection();
    }

	public ArrayList<DeviceType> searchDeviceByAnyLike() throws SQLException{
        ResultSet rs = this.runQuery("searchDeviceByAnyLike",argArray);
        while (rs.next()) {
        	DeviceType deviceType = new DeviceType();
        	deviceType.setIdDeviceType(rs.getString("idDeviceType"));
        	deviceType.setNmDeviceType(rs.getString("nmDeviceType"));
        	deviceType.setMaxRelayNbr(rs.getInt("maxRelayNbr"));
        	deviceType.setUpdatedTime(rs.getString("updatedTime"));
        	deviceTypes.add(deviceType);
        } 
       	return deviceTypes;
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

	public DeviceType getDeviceType(){
		return deviceType;
	}
	
	public void setDeviceType(DeviceType deviceType) {
		this.deviceType = deviceType;
	}
	
	public void setArgArray(ArrayList<String> argArray){
		this.argArray = argArray;
	}
	
	public ArrayList<String> getArgArray(){
		return argArray;
	}

	
}