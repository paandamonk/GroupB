package sql;
import java.sql.*;

public class Delete
{
   private String tableName;
   
   public Delete(String tname) {
       tableName = tname;
   }
   
   public void deleteInfo(int propNum) {
      Connection c = null;
      Statement stmt = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:test.db");
         c.setAutoCommit(false);
         System.out.println("Opened database successfully");

         stmt = c.createStatement();
         String sql = "DELETE from " + tableName + " where PROPNUM=" + propNum + ";";
         stmt.executeUpdate(sql);
         c.commit();

         stmt.close();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Operation done successfully");
    }
}
