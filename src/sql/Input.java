package sql;
import pp.Staff;

import java.sql.*;
import java.util.ArrayList;

public class Input
{
    private String tableName;


    public Input(String tName){
        tableName = tName;
    }

    public void addStaffInfo(String Fname, String Lname, int position, String Branch, String sex, String Dob, double Salary, String username, String password, int supID) {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:database.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully (Staff)");

            stmt = c.createStatement();
            String sql = "INSERT INTO " + tableName + " (FNAME,LNAME,POSITION,BRANCH,SEX,DOB,SALARY,USERNAME,PASSWORD,SUPERVISOR) " +
                    "VALUES (" + Fname + "," + Lname + "," + position + "," + Branch  + "," + sex + "," + Dob +
                    "," + Salary + "," + username + "," + password + "," + supID + ");";

            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Staff record created successfully");
    }

    public void addClientInfo(String fname, String lname, String type, String phone, double maxRent, int staffId,
                              String street, String city, String postCode) {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:database.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully (Clients)");

            stmt = c.createStatement();
            String sql = "INSERT INTO " + tableName + " (FNAME,LNAME,TYPE,PHONE,MAXRENT,STAFFNUM,STREET,CITY,POSTCODE) " +
                    "VALUES (" + fname + "," + lname + "," + type + "," + phone  + "," + maxRent + "," + staffId +
                    "," + street + "," + city + "," + postCode + ");";

            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Client record created successfully");
    }

    public void addPropOwnerInfo(String Fname, String Lname, String street, String City, String Postcode, String Phone, int sID) {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:database.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "INSERT INTO " + tableName + " (FNAME,LNAME,STREET,CITY,POSTCODE,PHONE,STAFFNUM) " +
                    "VALUES (" + Fname + "," + Lname + "," + street + "," + City + "," + Postcode + "," + Phone + "," + sID + ");";

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
                                     String Phone, String BusinessName, String BusinessType, int sID) {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:database.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully (Business Owners)");

            stmt = c.createStatement();
            String sql = "INSERT INTO " + tableName + " (FNAME,LNAME,STREET,CITY,POSTCODE,PHONE,BTYPE,BNAME,STAFFNUM) " +
                    "VALUES (" + Fname + "," + Lname + "," + street + "," + City + "," + Postcode +
                    "," + BusinessName + "," + BusinessType + "," + Phone + "," + sID + ");";

            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Business Owner record created successfully");
    }

    public void addPropertyInfo(String Street, String Postcode, String City, String type, int rooms, double rent, int Owner) {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:database.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully (Property)");

            stmt = c.createStatement();
            String sql = "INSERT INTO " + tableName + " (STREET,CITY,POSTCODE,TYPE,ROOMS,RENT,OWNER) " +
                    "VALUES ("  + Street + "," + City + "," + Postcode + "," + type + "," +
                    rooms + "," + rent + "," + Owner + ");";

            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Property record created successfully");
    }

    public void addPropViewInfo(int clientNum, String fname, String lname, String phone, int propertyId, String street, String city, String postCode, String viewDate, String comments) {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:database.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "INSERT INTO " + tableName + " (CLIENTNUM,FNAME,LNAME,CELL,PROPNUM,STREET,CITY,POSTCODE,VIEWDATE,COMMENTS) " +
                    "VALUES (" + clientNum + "," + fname + "," + lname + "," + phone + "," + propertyId + "," + street + "," +
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

    public void addLeaseInfo(int clientId, String fname, String lname, int propertyId, String street, String city, String postCode,
                             String type, int numRooms, double monthlyRent, String payMethod, double deposit, int depositPaid,
                             String rentStart, String rentEnd, String duration) {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:database.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully (Lease)");

            stmt = c.createStatement();
            String sql = "INSERT INTO " + tableName + " (CLIENTNUM,FNAME,LNAME,PROPNUM,STREET,CITY,POSTCODE," +
                    "TYPE,ROOMS,RENT,PAYMETHOD,DEPOSIT,PAIDDEPOSIT,STARTDATE,ENDDATE,DURATION) " +
                    "VALUES (" + clientId + "," + fname + "," + lname + "," + propertyId + "," + street + "," +
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
}