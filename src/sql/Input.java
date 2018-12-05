package sql;
import java.sql.*;

public class Input
{
    private String tableName;
<<<<<<< HEAD
    
    
    public Input(String tName){
        tableName = tName;
    }

    public void addClientInfo(int clientId, String fname, String lname, String phone, float maxRent, int staffId,
                              int idNum, String address, double maxPrice) {
        Connection c = null;
        Statement stmt = null;

        try {
=======
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
>>>>>>> master
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
<<<<<<< HEAD
            String sql = "INSERT INTO " + tableName + " (CLIENTID,FNAME,LNAME,PHONE,MAXRENT,STAFFNUM,STREET,CITY,POSTCODE) " +
                    "VALUES (" + clientId + "," + fname + "," + lname + "," + phone + "," + maxRent + "," +
                    staffId + "," + idNum + "," + address + "," + maxPrice + ");";

            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Client record for " + fname + " " + lname + " created successfully");
    }
    
    public void addPropertyInfo(int propNum, String Street, String Postcode, String City, String type, int rooms, double rent, String Owner) {
=======
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
>>>>>>> master
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
<<<<<<< HEAD

=======
                        
                       
                        
>>>>>>> master
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
<<<<<<< HEAD

    public void addPropViewInfo(int clientId, String fname, String lname, String phone, int propertyId, String street, String city, String postCode, String viewDate, String comments) {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "INSERT INTO " + tableName + " (CLIENTNUM,FNAME,LNAME,CELL,PROPNUM,STREET,CITY,POSTCODE,VIEWDATE,COMMENTS) " +
                    "VALUES (" + clientId + "," + fname + "," + lname + "," + phone + "," + propertyId + "," + street + "," +
                    city + "," + postCode + "," + viewDate + "," + comments + ");";

            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Property Viewing record for " + fname + " " + lname + " created successfully");
    }

    public void addLeaseInfo(int leaseId, int clientId, String fname, String lname, int propertyId, String street, String city, String postCode,
                             String type, int numRooms, double monthlyRent, String payMethod, double deposit, int depositPaid, String rentStart, String rentEnd, String duration) {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "INSERT INTO " + tableName + " (LEASENUM,CLIENTNUM,FNAME,LNAME,PROPNUM,STREET,CITY,POSTCODE," +
                    "TYPE,ROOMS,RENT,PAYMETHOD,DEPOSIT,PAIDDEPOSIT,STARTDATE,ENDDATE,DURATION) " +
                    "VALUES (" + leaseId + "," + clientId + "," + fname + "," + lname + "," + propertyId + "," + street + "," +
                    city + "," + postCode + "," + type + "," + numRooms + "," + monthlyRent + "," + payMethod+ ","
                    + deposit + "," + depositPaid + "," + rentStart + "," + rentEnd + "," + duration + ");";

            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Lease record for " + fname + " " + lname + " created successfully");
    }
=======
>>>>>>> master
}
