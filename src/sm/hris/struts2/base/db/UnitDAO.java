package sm.hris.struts2.base.db;
 
import java.util.ArrayList;
//import java.util.List;
import java.util.Enumeration;
import java.sql.ResultSet;
import java.sql.SQLException;
import sm.hris.struts2.base.db.Unit;
import sm.hris.struts2.base.db.SmBaseDAO;

public class UnitDAO extends SmBaseDAO{
 
	private ArrayList<Unit> units = new ArrayList<Unit>();
    private String idUnit;
    private ArrayList<String> argArray = new ArrayList<String>();

	public ArrayList<Unit> searchUnit() throws SQLException{
        ResultSet rs = this.runQuery("searchUnit");
 
            while (rs.next()) {
                Unit unit = new Unit();
                unit.setIdDepartment(rs.getString("idDepartment"));
                unit.setIdUnit(rs.getString("idUnit"));
                unit.setName(rs.getString("name"));
                unit.setDescription(rs.getString("description"));
                units.add(unit);
                
            } 
        	if(rs != null){
      		   try {
      		   rs.close();
      		   } catch (SQLException e) {
      		        System.out.println("Exception while closing result set: " + e);
      		   }
      		}
        	closeConnection();
        	return units;

        
    }

	public ArrayList<Unit> searchUnit(ArrayList<String> searchArg) throws SQLException{
        ResultSet rs = this.runQuery("searchUnitP", searchArg);
 
            while (rs.next()) {
                Unit unit = new Unit();
                unit.setIdDepartment(rs.getString("idDepartment"));
                unit.setIdUnit(rs.getString("idUnit"));
                unit.setName(rs.getString("name"));
                unit.setDescription(rs.getString("description"));
                units.add(unit);
                
            } 
        	if(rs != null){
      		   try {
      		   rs.close();
      		   } catch (SQLException e) {
      		        System.out.println("Exception while closing result set: " + e);
      		   }
      		}
        	closeConnection();
        	return units;

        
    }
	
	//public ArrayList<Unit> searchUnitBaseOnDept(ArrayList<String> searchArg) throws SQLException{
	public ArrayList<Unit> searchUnitBaseOnDept(String searchArg) throws SQLException{
        ResultSet rs = this.runQuery("searchUnitBaseOnDept", searchArg);
 
            while (rs.next()) {
                Unit unit = new Unit();
                unit.setIdDepartment(rs.getString("idDepartment"));
                unit.setIdUnit(rs.getString("idUnit"));
                unit.setName(rs.getString("name"));
                unit.setDescription(rs.getString("description"));
                units.add(unit);
                
            } 
        	if(rs != null){
      		   try {
      		   rs.close();
      		   } catch (SQLException e) {
      		        System.out.println("Exception while closing result set: " + e);
      		   }
      		}
        	closeConnection();
        	return units;

        
    }

	public void unitDelete(ArrayList<String> idUnits) throws SQLException{
		for(int i=0;i<idUnits.size();i++) {
			idUnit = idUnits.get(i);
			argArray.add(idUnit);
			this.run("unitDelete", argArray);
        	closeConnection();

		}
    }

	public void unitAdd(Unit unit) throws SQLException{
			argArray.add(0, unit.getIdDepartment());
			argArray.add(1, unit.getIdUnit());
			argArray.add(2, unit.getName());
			argArray.add(3, unit.getDescription());
			this.run("unitAdd", argArray);
        	closeConnection();

    }
	
}