package sm.hris.struts2.base.db;
 
import java.util.ArrayList;
//import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;
import sm.hris.struts2.base.db.DeviceTrx;

public class DeviceTrxDAO extends SmBaseDAO{
 
	private DeviceTrx deviceTrx = new DeviceTrx();
	private ArrayList<DeviceTrx> deviceTrxs = new ArrayList<DeviceTrx>();
    private ArrayList<String> argArray = new ArrayList<String>();

	public ArrayList<DeviceTrx> searchDeviceTrx() throws SQLException{
        ResultSet rs = this.runQuery("searchDeviceTrx");
            while (rs.next()) {
            	DeviceTrx deviceTrx = new DeviceTrx();
            	deviceTrx.setIdDevice(rs.getString("idDevice"));
            	deviceTrx.setIdDeviceType(rs.getString("idDeviceType"));
            	deviceTrx.setIdSite(rs.getString("idSite"));
            	deviceTrx.setNmDeviceType(rs.getString("nmDeviceType"));
            	deviceTrx.setNmSite(rs.getString("nmSite"));
            	deviceTrx.setUpdatedTime(rs.getString("updatedTime"));
            	deviceTrxs.add(deviceTrx);
            } 
        	
            if(rs != null){
     		   try {
     		   rs.close();
     		   } catch (SQLException e) {
     		        System.out.println("Exception while closing result set: " + e);
     		   }
     		}
        	//closeConnection();
        	return deviceTrxs;
        
    }

	public ArrayList<DeviceTrx> searchDeviceTrxByIdSite() throws SQLException{
        ResultSet rs = this.runQuery("searchDeviceTrxByIdSite",argArray);
        while (rs.next()) {
        	DeviceTrx deviceTrx = new DeviceTrx();
        	deviceTrx.setIdDevice(rs.getString("idDevice"));
        	deviceTrx.setIdDeviceType(rs.getString("idDeviceType"));
        	deviceTrx.setIdSite(rs.getString("idSite"));
        	deviceTrx.setNmDeviceType(rs.getString("nmDeviceType"));
        	deviceTrx.setNmSite(rs.getString("nmSite"));
        	deviceTrx.setUpdatedTime(rs.getString("updatedTime"));
        	deviceTrxs.add(deviceTrx);
        } 
        	
            if(rs != null){
     		   try {
     		   rs.close();
     		   } catch (SQLException e) {
     		        System.out.println("Exception while closing result set: " + e);
     		   }
     		}
        	//closeConnection();
        	return deviceTrxs;
        
    }

	public void deviceTrxDelete() throws SQLException{
		for(int i=0;i<argArray.size();i++) {
			ArrayList<String> argArray2 = new ArrayList<String>();
			argArray2.add(argArray.get(i));
			this.run("deviceTrxDelete", argArray.get(i));
		}
		//closeConnection();
    }


	public ArrayList<DeviceTrx> searchDeviceTrxByAnyLike() throws SQLException{
        ResultSet rs = this.runQuery("searchDeviceTrxByAnyLike",argArray);
        while (rs.next()) {
        	DeviceTrx deviceTrx = new DeviceTrx();
        	deviceTrx.setIdDevice(rs.getString("idDevice"));
        	deviceTrx.setIdDeviceType(rs.getString("idDeviceType"));
        	deviceTrx.setIdSite(rs.getString("idSite"));
        	deviceTrx.setNmDeviceType(rs.getString("nmDeviceType"));
        	deviceTrx.setNmSite(rs.getString("nmSite"));
        	deviceTrx.setUpdatedTime(rs.getString("updatedTime"));
        	deviceTrxs.add(deviceTrx);
        } 
       	return deviceTrxs;
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

	public DeviceTrx getDeviceTrx(){
		return deviceTrx;
	}
	
	public void setDeviceTrx(DeviceTrx deviceTrx) {
		this.deviceTrx = deviceTrx;
	}
	
	public void setArgArray(ArrayList<String> argArray){
		this.argArray = argArray;
	}
	
	public ArrayList<String> getArgArray(){
		return argArray;
	}

	
}