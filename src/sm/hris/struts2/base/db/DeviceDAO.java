package sm.hris.struts2.base.db;
 
import java.util.ArrayList;
//import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;
import sm.hris.struts2.base.db.Device;

public class DeviceDAO extends SmBaseDAO{
 
	private Device device = new Device();
	private ArrayList<Device> devices = new ArrayList<Device>();
    private ArrayList<String> argArray = new ArrayList<String>();

	public ArrayList<Device> searchDevice() throws SQLException{
        ResultSet rs = this.runQuery("searchDevice");
            while (rs.next()) {
            	Device device = new Device();
            	device.setIdDevice(rs.getString("idDevice"));
            	device.setIdDeviceType(rs.getString("idDeviceType"));
            	device.setIdSite(rs.getString("idSite"));
            	device.setUpdatedTime(rs.getString("updatedTime"));
            	devices.add(device);
            } 
        	
            if(rs != null){
     		   try {
     		   rs.close();
     		   } catch (SQLException e) {
     		        System.out.println("Exception while closing result set: " + e);
     		   }
     		}
        	//closeConnection();
        	return devices;
        
    }

	public void deviceDelete() throws SQLException{
		for(int i=0;i<argArray.size();i++) {
			ArrayList<String> argArray2 = new ArrayList<String>();
			argArray2.add(argArray.get(i));
			this.run("deviceDelete", argArray.get(i));
		}
		//closeConnection();
    }

	public void deviceAdd() throws SQLException{
		argArray = new ArrayList<String>();
		argArray.add(0, device.getIdSite());
		argArray.add(1, device.getIdDevice());
		argArray.add(2, device.getIdDeviceType());
		this.run("DeviceAdd", argArray);
		//closeConnection();
    }
	

	public void deviceEdit() throws SQLException{
		argArray = new ArrayList<String>();
		argArray.add(0, device.getIdSite());
		argArray.add(1, device.getIdDevice());
		argArray.add(2, device.getIdDeviceType());
		argArray.add(3, device.getIdDevice());
		this.run("DeviceEdit", argArray);
		//closeConnection();
    }

	public ArrayList<Device> searchDeviceByAnyLike() throws SQLException{
        ResultSet rs = this.runQuery("searchDeviceByAnyLike",argArray);
        while (rs.next()) {
        	Device device = new Device();
        	device.setIdDevice(rs.getString("idDevice"));
        	device.setIdDeviceType(rs.getString("idDeviceType"));
        	device.setIdSite(rs.getString("idSite"));
        	device.setUpdatedTime(rs.getString("updatedTime"));
        	devices.add(device);
        } 
       	return devices;
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

	public Device getDevice(){
		return device;
	}
	
	public void setDevice(Device device) {
		this.device = device;
	}
	
	public void setArgArray(ArrayList<String> argArray){
		this.argArray = argArray;
	}
	
	public ArrayList<String> getArgArray(){
		return argArray;
	}

	
}