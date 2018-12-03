package sql;
import java.sql.*;

public class Update
{
   String tableName;
   public Update(String tname) {
       tableName = tname;
   }
   Connection c = null;
   Statement stmt = null;
   
   public void updateInfo(String infoType, String infoValue, int propNum){
   try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:test.db");
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      String sql = "UPDATE " + tableName + " set " + infoType + "=" + infoValue + " where PROPNUM=" + propNum + ";";
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
