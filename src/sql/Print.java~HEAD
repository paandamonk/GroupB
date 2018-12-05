package sql;
import java.sql.*;

public class Print
{
    private String tableName;
    public Print(String tName){
        tableName = tName;
    }

	public void Print(String tableName) {
      Connection c = null;
      Statement stmt = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:test.db");
         c.setAutoCommit(false);
         System.out.println("Opened database successfully");

         stmt = c.createStatement();
         ResultSet rs = stmt.executeQuery( "SELECT * FROM " + tableName + ";" );
         
         while ( rs.next() ) {
         int propNum = rs.getInt("PROPNUM");
         String  street = rs.getString("STREET");
         String city = rs.getString("CITY");
         String postcode = rs.getString("POSTCODE");
         String type  = rs.getString("TYPE");
         int  rooms = rs.getInt("ROOMS");
         double rent = rs.getDouble("RENT");
         
         System.out.println( "PROPNUM = " + propNum );
         System.out.println( "STREET = " + street );
         System.out.println("CITY = " + city);
         System.out.println("POSTCODE = " + postcode);
         System.out.println( "TYPE = " + type );
         System.out.println( "ROOMS = " + rooms );
         System.out.println( "RENT = " + rent );
         System.out.println();
      }
      rs.close();
      stmt.close();
      c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Operation done successfully");
    }
}
