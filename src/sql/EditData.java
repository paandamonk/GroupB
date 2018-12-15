package sql;

import java.sql.*;

public class EditData
{
    public EditData(){}
    public void addStaffInfo(int sID, String Fname, String Lname, int Pos, String Branch, String sex, String Dob, double Salary, int supID) {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:database.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "INSERT INTO STAFF (STAFFNUM,FNAME,LNAME,POSITION,BRANCH,SEX,DOB,SALARY,SUPERVISOR) " +
                    "VALUES (" + sID + "," + Fname + "," + Lname + "," + Pos + "," + Branch + "," + sex + "," + Dob + "," + Salary + "," + supID + ");";

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
    public void addClientInfo(int clientId, String fname, String lname, String type, String phone, float maxRent, int staffId,
                              String street, String city, String postCode) {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:database.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "INSERT INTO CLIENTS (CLIENTID,FNAME,LNAME,TYPE,PHONE,MAXRENT,STAFFNUM,STREET,CITY,POSTCODE) " +
                    "VALUES (" + clientId + "," + fname + "," + lname + "," + type + "," + phone + "," + maxRent + "," +
                    staffId + "," + street + "," + city + "," + postCode + ");";

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
    public void addPropOwnerInfo(int oID, String Fname, String Lname, String street, String City, String Postcode, int sID, String Phone) {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:database.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "INSERT INTO PROPOWNERS (OWNERNUM,FNAME,LNAME,STREET,CITY,POSTCODE,PHONE,STAFFNUM) " +
                    "VALUES (" + oID + "," + Fname + "," + Lname + "," + street + "," + City + "," + Postcode + "," + Phone + "," + sID + ");";

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
    public void addBusinessOwnerInfo(int oID, String Fname, String Lname, String street, String City, String Postcode,
                                String Phone, String BusinessName, String BusinessType,  int sID) {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:database.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "INSERT INTO BUSOWNERS (OWNERNUM,FNAME,LNAME,STREET,CITY,POSTCODE,PHONE,BTYPE,BNAME,STAFFNUM) " +
                    "VALUES (" + oID + "," + Fname + "," + Lname + "," + street + "," + City + "," + Postcode +
                    "," + BusinessName + "," + BusinessType + "," + Phone + "," + sID + ");";

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
    public void addPropertyInfo(int propNum, String Street, String Postcode, String City, String type, int rooms, double rent, String Owner) {
      Connection c = null;
      Statement stmt = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:database.db");
         c.setAutoCommit(false);
         System.out.println("Opened database successfully");

         stmt = c.createStatement();
         String sql = "INSERT INTO PROPERTIES (PROPNUM,STREET,CITY,POSTCODE,TYPE,ROOMS,RENT,OWNER) " +
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
    public void addPropViewInfo(int clientId, String fname, String lname, String phone, int propertyId, String street, String city, String postCode, String viewDate, String comments) {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:database.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "INSERT INTO PROPVIEW (CLIENTNUM,FNAME,LNAME,CELL,PROPNUM,STREET,CITY,POSTCODE,VIEWDATE,COMMENTS) " +
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
            c = DriverManager.getConnection("jdbc:sqlite:database.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "INSERT INTO LEASE (LEASENUM,CLIENTNUM,FNAME,LNAME,PROPNUM,STREET,CITY,POSTCODE," +
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
    public void updateInfo(String tableName, String parameter, int dataType, String infoValue, String primeFactor, int idNumber){
        Connection c = null;
        Statement stmt = null;
        
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:database.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            
            stmt = c.createStatement();
            //dataType: 0 = String, 1 = integer, 2 = float
            String result0;
            int result1;
            float result2;
            String sql = "";
            if(dataType == 0){
                result0 = "'" + infoValue + "'";
                sql = "UPDATE " + tableName + " set " + parameter + "=" + result0 + " where " + primeFactor + "=" + idNumber + ";";
            }
            else if(dataType == 1){
                result1 = Integer.parseInt(infoValue);
                sql = "UPDATE " + tableName + " set " + parameter + "=" + result1 + " where " + primeFactor + "=" + idNumber + ";";
            }
            else{
                result2 = Float.parseFloat(infoValue);
                sql = "UPDATE " + tableName + " set " + parameter + "=" + result2 + " where " + primeFactor + "=" + idNumber + ";";
            }
            stmt.executeUpdate(sql);
            c.commit();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
          System.out.println("Updated successfully");
    }
    public void deleteInfo(String tableName,String primeFactor, int idNumber){
      Connection c = null;
      Statement stmt = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:database.db");
         c.setAutoCommit(false);
         //System.out.println("Opened database successfully");

         stmt = c.createStatement();
         String sql = "DELETE from " + tableName + " where " + primeFactor + "=" + idNumber + ";";
         stmt.executeUpdate(sql);
         c.commit();

         stmt.close();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Deleted successfully");
    }
    public void print(String tableName){
      Connection c = null;
      Statement stmt = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:database.db");
         c.setAutoCommit(false);
         //System.out.println("Opened database successfully");

         stmt = c.createStatement();
         ResultSet rs = stmt.executeQuery( "SELECT * FROM " + tableName + ";" );
         
         switch(tableName){
             
         case "STAFF":while ( rs.next() ) {
                         System.out.println("STAFFNUM = " + rs.getInt("STAFFNUM"));
                         System.out.println("FIRST NAME = " + rs.getString("FNAME"));
                         System.out.println("LAST NAME = " + rs.getString("LNAME"));
                         System.out.println("POSITION = " + rs.getInt("POSITION"));
                         System.out.println("BRANCH = " + rs.getString("BRANCH"));
                         System.out.println("SEX = " + rs.getString("SEX"));
                         System.out.println("DATE OF BIRTH = " + rs.getString("DOB"));
                         System.out.println("SUPERVISOR = " + rs.getString("SUPERVISOR"));
                         System.out.println();
                      }
                      break;
         default: System.out.println("No Information Specified");
         }
      rs.close();
      stmt.close();
      c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Printed successfully");
    }
}