package sm.hris.struts2.base.db;
 
import java.util.ArrayList;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sm.hris.struts2.base.ReadXML;
import sm.hris.struts2.base.SmXmlQueryFolder; 
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class SmBaseDAO {
 
	private String className = (String) this.getClass().getSimpleName() + ".xml";
	private SmXmlQueryFolder smXmlQueryFolder = new SmXmlQueryFolder();
	private String queryFolder = smXmlQueryFolder.getXmlpath();
	private String xmlQueryFilePath = queryFolder + className;
	private Boolean executeResult = null;
	public Connection con = ConPool.getConnection();
    //System.out.println("Connection succeeded: " + con);
    private PreparedStatement ps;
    private ResultSet rs;
    private ResultSet rsReturn;

    
    public void closeConnection () throws SQLException{
    	System.out.println("Connection is Closing");
    	//ConPool.freeConnection(con);
    	con.close();
    	//if (ps != null) ps.close();
    	//if (rs != null) rs.close();
    }
   
	public ResultSet runQuery(String queryCommand) throws SQLException{
		ReadXML myxml = new ReadXML();
        String sql = myxml.ReadXmlAttribute(xmlQueryFilePath, queryCommand);        

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            setRsReturn(rs);
            //con.close();
        	//ConPool.freeConnection(con);
         } catch (SQLException e) {
             System.out.println("Catch SmBaseDAO: "+e);
             e.printStackTrace();
             //con.close();
             return null;
         }  /* finally {
        	 if (con != null) {
        		 con.close();
        	 }
         } */
        return rsReturn;
        
    }

	public ResultSet runQuery(String queryCommand, ArrayList<String> argArray) throws SQLException{
        ReadXML myxml = new ReadXML();
        String sql = myxml.ReadXmlAttribute(xmlQueryFilePath, queryCommand);        
        Logger logger = Logger.getLogger(SmBaseDAO.class);
        BasicConfigurator.configure();
        logger.info("SQL Query in smBaseDAO: " + sql);
        
        try {
            ps = con.prepareStatement(sql);
            for (int i=0; i<argArray.size(); i++){
            	int n=i+1;
                System.out.println("Prepare Statement = "+sql+" ");
                System.out.println("Prepare Statement Arg("+n+")= "+argArray.get(i));
                ps.setString(n, argArray.get(i));
            } 
            rs = ps.executeQuery();
            setRsReturn(rs);
            //con.close();
        	//ConPool.freeConnection(con);
        	return rsReturn;
         } catch (SQLException e) {
             System.out.println("Catch SmBaseDAO: "+e);
             e.printStackTrace();
             //con.close();
             return null;
         }  /* finally {
        	 if (con != null) {
        		 con.close();
        	 }
         } */

        
    }

	public ResultSet runQuery(String queryCommand, String argStr) throws SQLException{
        ReadXML myxml = new ReadXML();
        String sql = myxml.ReadXmlAttribute(xmlQueryFilePath, queryCommand);        
        Logger logger = Logger.getLogger(SmBaseDAO.class);
        BasicConfigurator.configure();
        logger.info("SQL Query : " + sql);
        logger.info("argStr: " + argStr);
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, argStr);
            rs = ps.executeQuery();
            setRsReturn(rs);
            //con.close();
        	//ConPool.freeConnection(con);
        	return rsReturn;
         } catch (SQLException e) {
             System.out.println("Catch SmBaseDAO: "+e);
             e.printStackTrace();
             //con.close();
             return null;
         }  /* finally {
        	 if (con != null) {
        		 con.close();
        	 }
         } */

        
    }

	public ResultSet runQueryObj(String queryCommand, ArrayList<Object> argArray) throws SQLException{
        ReadXML myxml = new ReadXML();
        String sql = myxml.ReadXmlAttribute(xmlQueryFilePath, queryCommand);        
        Logger logger = Logger.getLogger(SmBaseDAO.class);
        BasicConfigurator.configure();
        logger.info("SQL Query in smBaseDAO: " + sql);
        
        try {
            ps = con.prepareStatement(sql);
            for (int i=0; i<argArray.size(); i++){
            	int n=i+1;
                ps.setObject(n, argArray.get(i));
            } 
            ps.executeUpdate();
            setRsReturn(rs);
        	//ConPool.freeConnection(con);
            //con.close();
        	return rsReturn;

         } catch (SQLException e) {
             System.out.println("Catch SmBaseDAO: "+e);
             e.printStackTrace();
             //con.close();
             return null;
         }  /* finally {
        	 if (con != null) {
        		 con.close();
        	 }
         } */

        
    }
	
	public void run(String queryCommand, ArrayList<String> argArray) throws SQLException{
		
		Connection con = ConPool.getConnection();
        System.out.println("Connection succeeded: " + con);
        PreparedStatement ps;
        
        ReadXML myxml = new ReadXML();
        String sql = myxml.ReadXmlAttribute(xmlQueryFilePath, queryCommand);        
        System.out.println("Prepared Statement: " + sql);

        try {
            ps = con.prepareStatement(sql);
        	System.out.println("Size ArgArray: " + argArray.size());
            for(int i=0;i<argArray.size(); i++){
                int n = i+1;
               	ps.setString(n, argArray.get(i));
                System.out.println("Argument " +  n + ": " + argArray.get(i));
            } 
            //executeResult = ps.execute();
            ps.executeUpdate();
        	if(ps != null){
     		   try {
     		   ps.close();
     		   } catch (SQLException e) {
     		        System.out.println("Exception while closing statement: " + e);
     		   }
     		}

        	//ConPool.freeConnection(con);
         } catch (SQLException e) {
             System.out.println("Catch SmBaseDAO: "+e);
             e.printStackTrace();
             //con.close();
         }  /* finally {
        	 if (con != null) {
        		 con.close();
        	 } 
         } */

        
    }
	
	public void run(String queryCommand, String argStr) throws SQLException{
		
		Connection con = ConPool.getConnection();
        System.out.println("Connection succeeded: " + con);
        PreparedStatement ps;
        
        ReadXML myxml = new ReadXML();
        String sql = myxml.ReadXmlAttribute(xmlQueryFilePath, queryCommand);        
        System.out.println("Prepared Statement: " + sql);

        try {
            ps = con.prepareStatement(sql);
           	ps.setString(1, argStr);
            executeResult = ps.execute();
        	if(ps != null){
     		   try {
     		   ps.close();
     		   } catch (SQLException e) {
     		        System.out.println("Exception while closing statement: " + e);
     		   }
     		}
        	//ConPool.freeConnection(con);
         } catch (SQLException e) {
             System.out.println("Catch SmBaseDAO: "+e);
             e.printStackTrace();
             //con.close();
         }  /* finally {
        	 if (con != null) {
        		 con.close();
        	 }
         } */

        
    }
 	
	public void run(String queryCommand) throws SQLException{
		
		Connection con = ConPool.getConnection();
        System.out.println("Connection succeeded: " + con);
        PreparedStatement ps;
        
        ReadXML myxml = new ReadXML();
        String sql = myxml.ReadXmlAttribute(xmlQueryFilePath, queryCommand);        
        System.out.println("Prepared Statement: " + sql);

        try {
            ps = con.prepareStatement(sql);
            executeResult = ps.execute();
        	if(ps != null){
     		   try {
     		   ps.close();
     		   } catch (SQLException e) {
     		        System.out.println("Exception while closing statement: " + e);
     		   }
     		}

            
 

        	//ConPool.freeConnection(con);
         } catch (SQLException e) {
             System.out.println("Catch SmBaseDAO: "+e);
             e.printStackTrace();
             //con.close();
         }  /* finally {
        	 if (con != null) {
        		 con.close();
        	 }
         } */

        
    }
	
	public void setRsReturn(ResultSet rsReturn){
		this.rsReturn = rsReturn;
	}
	
	public ResultSet getRsReturn (){
		return rsReturn;
	}

}