package sm.hris.struts2.base.db;
 
import java.util.ArrayList;
//import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import sm.hris.struts2.base.db.Counter;

public class CounterDAO extends SmBaseDAO{
 
	private Counter counter = new Counter();
	private ArrayList<Counter> counters = new ArrayList<Counter>();
	private String strIdOrderCounter;

	public String selectIdOrderCounter() throws SQLException{
        ResultSet rs = this.runQuery("selectIdOrderCounter");
            while (rs.next()) {
            	strIdOrderCounter = rs.getString("F_GetIdOrder()");
            } 
        	System.out.println("Dragon Id:" + strIdOrderCounter);
            if(rs != null){
     		   try {
     		   rs.close();
     		   } catch (SQLException e) {
     		        System.out.println("Exception while closing result set: " + e);
     		   }
     		}
        	//closeConnection();
        	return strIdOrderCounter;
        
    }


	public void updateIdOrderCounter() throws SQLException{
			this.run("updateIdOrderCounter");
    }
	
	
//Getter Setter -------------------------------------//

	public Counter getCounter(){
		return counter;
	}
	
	public void setCounter(Counter counter) {
		this.counter = counter;
	}
	
	
}