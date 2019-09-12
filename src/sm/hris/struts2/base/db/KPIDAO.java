package sm.hris.struts2.base.db;
 
import java.util.ArrayList;
//import java.util.List;
import java.util.Enumeration;
import java.sql.ResultSet;
import java.sql.SQLException;
import sm.hris.struts2.base.db.KPI;
import sm.hris.struts2.base.db.SmBaseDAO;

public class KPIDAO extends SmBaseDAO{
 
	private KPI kPI = new KPI();
	private ArrayList<KPI> kPIs = new ArrayList<KPI>();
    private String idKPI;
    private ArrayList<String> argArray = new ArrayList<String>();
    private ResultSet rs;

	public ArrayList<KPI> searchKPIByDescriptionLike() throws SQLException{
        if ((argArray.isEmpty())||(argArray.equals(null))||(argArray.equals(""))) 
        	rs = this.runQuery("searchKPI");
        else
    		rs = this.runQuery("searchKPIByDescriptionLike",argArray.get(0));
 
        while (rs.next()) {
          KPI kPI = new KPI();
          kPI.setIdKPI(rs.getString("idKPI"));
          kPI.setDescription(rs.getString("description"));
          kPI.setUnitMeasure(rs.getString("unitMeasure"));
          kPIs.add(kPI);
        } 
        if(rs != null){
      	   try {
      		   rs.close();
      		   } catch (SQLException e) {
      		        System.out.println("Exception while closing result set: " + e);
      		   }
      	}
        closeConnection();
        return kPIs;
    }

	public ArrayList<KPI> searchKPI() throws SQLException{
        if ((idKPI.isEmpty())||(idKPI.equals(null))||(idKPI.equals(""))) 
        	rs = this.runQuery("searchKPI");
        else
    		rs = this.runQuery("searchKPIByIdKPI",idKPI);
 
        while (rs.next()) {
          KPI kPI = new KPI();
          kPI.setIdKPI(rs.getString("idKPI"));
          kPI.setDescription(rs.getString("description"));
          kPI.setUnitMeasure(rs.getString("unitMeasure"));
          kPIs.add(kPI);
        } 
        if(rs != null){
      	   try {
      		   rs.close();
      		   } catch (SQLException e) {
      		        System.out.println("Exception while closing result set: " + e);
      		   }
      	}
        closeConnection();
        return kPIs;
    }

	
	public void deleteKPI() throws SQLException{
		for(int i=0;i<argArray.size();i++) {
			this.run("deleteKPI", argArray.get(i));
		}
        closeConnection();
    }

	public void addKPI() throws SQLException{
		argArray.add(0, kPI.getIdKPI());
		argArray.add(1, kPI.getDescription());
		argArray.add(2, kPI.getUnitMeasure());
		this.run("addKPI", argArray);
       	closeConnection();
    }

	public void editKPI() throws SQLException{
		argArray.add(0, kPI.getIdKPI());
		argArray.add(1, kPI.getDescription());
		argArray.add(2, kPI.getUnitMeasure());
		argArray.add(3, kPI.getIdKPI());
		this.run("editKPI", argArray);
    	closeConnection();
	}
	
	//Getter Setter//
	public KPI getKPI(){
		return kPI;
	} 

	public void setKPI(KPI kPI) {
		this.kPI = kPI;
	}

	public ArrayList<KPI> getKPIs() {
		return kPIs;
	}
	
	public void setKPIs(ArrayList<KPI> kPIs) {
		this.kPIs = kPIs;
	}
	
	public String getIdKPI(){
		return idKPI;
	}

	public void setIdKPI(String idKPI) {
		this.idKPI = idKPI;
	}
	
	public ArrayList<String> getArgArray(){
		return argArray;
	}
	
	public void setArgArray (ArrayList<String> argArray){
		this.argArray = argArray;
	}
	

}