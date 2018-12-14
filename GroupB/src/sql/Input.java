package sql;
import java.sql.*;

public class Input
{
    private String tableName;
    
    
    public Input(String tName){
        tableName = tName;
    }

    public void addStaffInfo(String Fname, String Lname, int Pos, String Branch, String sex, String Dob, double Salary, int supID) {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "INSERT INTO " + tableName + " (FNAME,LNAME,POSITION,BRANCH,SEX,DOB,SALARY,SUPERVISOR) " +
                    "VALUES ('"  + Fname + "','" + Lname + "','" + Pos + "','" + Branch + "','" + sex + "','" + 
            		Dob + "','" + Salary + "','" + supID + "');";

            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Staff record for " + Fname + "" + Lname + " created successfully");
    }

    public void addClientInfo(String fname, String lname, String type, String phone, double maxRent, int staffId,
                              String street, String city, String postCode) {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "INSERT INTO " + tableName + " (FNAME,LNAME,TYPE,PHONE,MAXRENT,STAFFN,STREET,CITY,POSTCODE) " +
                    "VALUES ('"  + fname + "','" + lname + "','" + type + "','" + phone + "','" + maxRent + "','" +
                    staffId + "','" + street + "','" + city + "','" + postCode + "');";

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

    public void addPropOwnerInfo(String Fname, String Lname, String street, String City, String Postcode, String Phone, int sID) {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "INSERT INTO " + tableName + " (FNAME,LNAME,STREET,CITY,POSTCODE,PHONE,STAFFNUM) " +
                    "VALUES ('"  + Fname + "','" + Lname + "','" + street + "','" + City + "','" + Postcode + "','" +
            		Phone + "','" + sID + "');";

            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Property Owner record created successfully");
    }

    public void addBusinessOwnerInfo(String Fname, String Lname, String street, String City, String Postcode,
                                String Phone, String BusinessName, String BusinessType,  int sID) {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "INSERT INTO " + tableName + " (FNAME,LNAME,STREET,CITY,POSTCODE,PHONE,BTYPE,BNAME,STAFFNUM) " +
                    "VALUES ('"  + Fname + "','" + Lname + "','" + street + "','" + City + "','" + Postcode +
                    "','" + BusinessName + "','" + BusinessType + "','" + Phone + "','" + sID + "');";

            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Property Owner record created successfully");
    }
    
    public void addPropertyInfo(String Street, String Postcode, String City, String type, int rooms, double rent, String Owner) {
      Connection c = null;
      Statement stmt = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:test.db");
         c.setAutoCommit(false);
         System.out.println("Opened database successfully");

         stmt = c.createStatement();
         String sql = "INSERT INTO " + tableName + " (STREET,CITY,POSTCODE,TYPE,ROOMS,RENT,OWNER) " +
                        "VALUES ('"  + Street + "'," + City + "','" + Postcode + "','" + type + "','" +
        		 rooms + "','" + rent + "','" + Owner + "');";

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

    public void addPropViewInfo(String fname, String lname, String phone, int propertyId, String street, String city, String postCode, String viewDate, String comments) {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "INSERT INTO " + tableName + " (FNAME,LNAME,CELL,PROPNUM,STREET,CITY,POSTCODE,VIEWDATE,COMMENTS) " +
                    "VALUES ('" + fname + "','" + lname + "','" + phone + "','" + propertyId + "','" + street + "','" +
                    city + "','" + postCode + "','" + viewDate + "','" + comments + "');";

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

    public void addLeaseInfo(int clientId, String fname, String lname, int propertyId, String street, String city, String postCode,
                             String type, int numRooms, double monthlyRent, String payMethod, double deposit, int depositPaid, String rentStart, String rentEnd, String duration) {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "INSERT INTO " + tableName + " (CLIENTNUM,FNAME,LNAME,PROPNUM,STREET,CITY,POSTCODE," +
                    "TYPE,ROOMS,RENT,PAYMETHOD,DEPOSIT,PAIDDEPOSIT,STARTDATE,ENDDATE,DURATION) " +
                    "VALUES ('"  + clientId + "','" + fname + "','" + lname + "','" + propertyId + "','" + street + "','" +
                    city + "','" + postCode + "','" + type + "','" + numRooms + "','" + monthlyRent + "','" + payMethod+ "','"
                    + deposit + "','" + depositPaid + "','" + rentStart + "','" + rentEnd + "','" + duration + "');";

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
}
