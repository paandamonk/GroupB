package sql;
import java.sql.*;

public class Input
{
    private String tableName;
    
    
    public Input(String tName){
        tableName = tName;
    }
    
    
    public void addInfo(int propNum, String Street, String Postcode, String City, String type, int rooms, double rent, String Owner) {
      Connection c = null;
      Statement stmt = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:test.db");
         c.setAutoCommit(false);
         System.out.println("Opened database successfully");

         stmt = c.createStatement();
         String sql = "INSERT INTO " + tableName + " (PROPNUM,STREET,CITY,POSTCODE,TYPE,ROOMS,RENT,OWNER) " +
                        "VALUES (" + propNum + "," + Street + "," + City + "," + Postcode + "," + type + "," + rooms + "," + rent + "," + Owner + ");";
                        
                       
                        
         stmt.executeUpdate(sql);

         stmt.close();
         c.commit();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Records created successfully");
    }
}
