package sql;
import java.sql.*;

public class Initialize
{
    public static void main(String[] args) {
      Connection c = null;
      Statement stmt = null;
   
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:database.db");
         
            
         stmt = c.createStatement();
         String sql = "CREATE TABLE STAFF" +
                      "(STAFFNUM INTEGER PRIMARY KEY AUTOINCREMENT," +
                      " FNAME        TEXT   NOT NULL, " + 
                      " LNAME        TEXT   NOT NULL, " + 
                      " POSITION     INT    NOT NULL, " +
                      " BRANCH       TEXT   NOT NULL, " +
                      " SEX          TEXT   NOT NULL, " +
                      " DOB          TEXT   NOT NULL, " +
                      " SALARY       REAL   NOT NULL, " +
                      " SUPERVISOR   TEXT   NOT NULL)"; 
         stmt.executeUpdate(sql);//0
         
         sql = "CREATE TABLE PROPERTIES" +
                      "(PROPNUM INTEGER PRIMARY KEY AUTOINCREMENT," +
                      " STREET       TEXT   NOT NULL, " + 
                      " CITY         TEXT   NOT NULL, " + 
                      " POSTCODE     TEXT   NOT NULL, " +
                      " TYPE         TEXT   NOT NULL, " +
                      " ROOMS        INT    NOT NULL, " +
                      " RENT         REAL   NOT NULL, " +
                      " OWNER        TEXT   NOT NULL)"; 
         stmt.executeUpdate(sql);//1
         
         sql = "CREATE TABLE PROPOWNERS" +
                      "(POWNERNUM INTEGER PRIMARY KEY AUTOINCREMENT," +
                      " FNAME        TEXT   NOT NULL, " +
                      " LNAME        TEXT   NOT NULL, " +
                      " STREET       TEXT   NOT NULL, " + 
                      " CITY         TEXT   NOT NULL, " + 
                      " POSTCODE     TEXT   NOT NULL, " +
                      " PHONE        TEXT   NOT NULL, " +
                      " STAFFNUM     TEXT   NOT NULL)"; 
         stmt.executeUpdate(sql);//2

          sql = "CREATE TABLE BUSOWNERS" +
                  "(BOWNERNUM INTEGER PRIMARY KEY AUTOINCREMENT," +
                  " FNAME        TEXT   NOT NULL, " +
                  " LNAME        TEXT   NOT NULL, " +
                  " STREET       TEXT   NOT NULL, " +
                  " CITY         TEXT   NOT NULL, " +
                  " POSTCODE     TEXT   NOT NULL, " +
                  " PHONE        TEXT   NOT NULL, " +
                  " BTYPE        TEXT   NOT NULL, " +
                  " BNAME        TEXT   NOT NULL, " +
                  " STAFFNUM     TEXT   NOT NULL)";
          stmt.executeUpdate(sql);//2
         
         sql = "CREATE TABLE CLIENTS" +
                      "(CLIENTID INTEGER PRIMARY KEY AUTOINCREMENT," +
                      " FNAME        TEXT   NOT NULL, " +
                      " LNAME        TEXT   NOT NULL, " +
                      " TYPE         TEXT   NOT NULL, " +
                      " PHONE        TEXT   NOT NULL, " + 
                      " MAXRENT      REAL   NOT NULL, " +
                      " STAFFN       INT    NOT NULL, " +
                      " STREET       TEXT   NOT NULL, " + 
                      " CITY         TEXT   NOT NULL, " + 
                      " POSTCODE     TEXT   NOT NULL)"; 
         stmt.executeUpdate(sql);//3
         
         sql = "CREATE TABLE PROPVIEW" +
                      "(CLIENTNUM INTEGER PRIMARY KEY AUTOINCREMENT," +
                      " FNAME        TEXT   NOT NULL, " +
                      " LNAME        TEXT   NOT NULL, " +
                      " CELL         TEXT   NOT NULL, " + 
                      " PROPNUM      INT    NOT NULL, " + 
                      " STREET       TEXT   NOT NULL, " + 
                      " CITY         TEXT   NOT NULL, " + 
                      " POSTCODE     TEXT   NOT NULL, " +
                      " VIEWDATE     TEXT   NOT NULL, " +
                      " COMMENTS     TEXT   NOT NULL)"; 
         stmt.executeUpdate(sql);//4
         
         sql = "CREATE TABLE LEASE" +
                      "(LEASENUM INTEGER PRIMARY KEY AUTOINCREMENT," +
                      " CLIENTNUM    INT    NOT NULL, " +
                      " FNAME        TEXT   NOT NULL, " +
                      " LNAME        TEXT   NOT NULL, " + 
                      " PROPNUM      INT    NOT NULL, " + 
                      " STREET       TEXT   NOT NULL, " + 
                      " CITY         TEXT   NOT NULL, " + 
                      " POSTCODE     TEXT   NOT NULL, " +
                      " TYPE         TEXT   NOT NULL, " +
                      " ROOMS        INT    NOT NULL, " +
                      " RENT         REAL   NOT NULL, " +
                      " PAYMETHOD    TEXT   NOT NULL, " +
                      " DEPOSIT      REAL   NOT NULL, " +
                      " PAIDDEPOSIT  INT    NOT NULL, " +
                      " STARTDATE    TEXT   NOT NULL, " +
                      " ENDDATE      TEXT   NOT NULL, " +
                      " DURATION     TEXT   NOT NULL)"; 
         stmt.executeUpdate(sql);//5
      
         stmt.close();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         
         System.exit(0);
      }
      System.out.println("Created database and tables successfully");
    }
}
