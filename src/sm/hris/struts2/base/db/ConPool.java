package sm.hris.struts2.base.db;
 
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
//import org.apache.tomcat.jdbc.pool.DataSource;
import javax.sql.DataSource;
 
 
public class ConPool {
 
    /* private static ConPool pool = null;
     private static javax.sql.DataSource dataSource = null;
     * */
    public static Connection getConnection() {
        Connection con = null;
       
 
        try {
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            DataSource ds = (DataSource) initCtx.lookup("java:comp/env/jdbc/smhris");
            //DataSource ds = (DataSource) ctx.lookup("java:jboss/datasources/MySQLDS");
            con = ds.getConnection();
        }  
        catch (NamingException ex) {
            Logger.getLogger(ConPool.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
        catch (SQLException sqle) {
            sqle.printStackTrace();
            System.out.println(sqle);
        }
        return con;
         
    }
 
    public static void freeConnection(Connection c) {
        try {
            if (c != null) c.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

}
