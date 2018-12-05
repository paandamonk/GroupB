package sql;
import java.sql.*;

public class Input
{
    private String tableName;
    public Input(String tName){
        tableName = tName;
    }
    
    public void addCInfo(String Fname, String Lname, int cID, String phone, String type, float max, int sID) {
    	  Connection c = null;
          Statement stmt = null;
          
          try {
             Class.forName("org.sqlite.JDBC");
             c = DriverManager.getConnection("jdbc:sqlite:test.db");
             c.setAutoCommit(false);
             System.out.println("Opened database successfully");

             stmt = c.createStatement();
             String sql = "INSERT INTO " + tableName + " (CLIENTNUM,FNAME,LNAME,PHONE,TYPE,MAXRENT,STAFFNUM) " +
                            "VALUES (" + cID + "," + Fname + "," + Lname + "," + phone + "," + type + "," + max + "," + sID + "," + ");";
            
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
    
    public void addOInfo(int oID, String Fname, String Lname, String street, String City, String Postcode, int sID, String Phone) {
    	 Connection c = null;
         Statement stmt = null;
         
         try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "INSERT INTO " + tableName + " (OWNERNUM,FNAME,LNAME,STREET,CITY,POSTCODE,MEMID,PHONE) " +
                           "VALUES (" + oID + "," + Fname + "," + Lname + "," + street + "," + City + "," + Postcode + "," + sID + "," + ");";
           
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
    
    public void addSInfo(int sID, String Fname, String Lname, int Pos, String Branch, String sex, String Dob, double Salary, int supID) {
    	Connection c = null;
        Statement stmt = null;
        
        try {
           Class.forName("org.sqlite.JDBC");
           c = DriverManager.getConnection("jdbc:sqlite:test.db");
           c.setAutoCommit(false);
           System.out.println("Opened database successfully");

           stmt = c.createStatement();
           String sql = "INSERT INTO " + tableName + " (STAFFNUM,FNAME,LNAME,POSITION,BRANCH,SEX,DOB,SALARY,SUPERVISOR) " +
                          "VALUES (" + sID + "," + Fname + "," + Lname + "," + Pos + "," + Branch + "," + sex + "," + Dob + "," + Salary + "," + supID + ");";
                          
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
    
    
    
    public void addPInfo(int propNum, String Street, String Postcode, String City, String type, int rooms, double rent, int Owner) {
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
