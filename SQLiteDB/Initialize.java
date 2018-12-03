package sql;
import java.sql.*;

public class Initialize
{
    public static void main(String[] args) {
      Connection c = null;
      Statement stmt = null;
   
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:test.db");
         
            
         stmt = c.createStatement();
         String sql = "CREATE TABLE STAFF" +
                      "(STAFFNUM INT PRIMARY KEY     NOT NULL," +
                      " FNAME        TEXT   NOT NULL, " + 
                      " LNAME        TEXT   NOT NULL, " + 
                      " POSITION     INT    NOT NULL, " +
                      " BRANCH       TEXT   NOT NULL, " +
                      " SEX          TEXT   NOT NULL, " +
                      " DOB          TEXT   NOT NULL, " +
                      " SUPERVISOR   TEXT   NOT NULL)"; 
         stmt.executeUpdate(sql);
         
         sql = "CREATE TABLE PROPERTIES" +
                      "(PROPNUM INT PRIMARY KEY     NOT NULL," +
                      " STREET       TEXT   NOT NULL, " + 
                      " CITY         TEXT   NOT NULL, " + 
                      " POSTCODE     TEXT   NOT NULL, " +
                      " TYPE         TEXT   NOT NULL, " +
                      " ROOMS        INT    NOT NULL, " +
                      " RENT         REAL   NOT NULL, " +
                      " OWNER        TEXT   NOT NULL)"; 
         stmt.executeUpdate(sql);
         
         sql = "CREATE TABLE OWNERS" +
                      "(OWNERNUM INT PRIMARY KEY     NOT NULL," +
                      " FNAME        TEXT   NOT NULL, " +
                      " LNAME        TEXT   NOT NULL, " +
                      " STREET       TEXT   NOT NULL, " + 
                      " CITY         TEXT   NOT NULL, " + 
                      " POSTCODE     TEXT   NOT NULL, " +
                      " PHONE        TEXT   NOT NULL)"; 
         stmt.executeUpdate(sql);
         
         sql = "CREATE TABLE CLIENTS" +
                      "(CLIENTNUM INT PRIMARY KEY     NOT NULL," +
                      " FNAME        TEXT   NOT NULL, " +
                      " LNAME        TEXT   NOT NULL, " +
                      " PHONE        TEXT   NOT NULL, " + 
                      " TYPE         TEXT   NOT NULL, " +
                      " MAXRENT      REAL   NOT NULL, " +
                      " STAFFNUM   TEXT   NOT NULL)"; 
         stmt.executeUpdate(sql);
         
         sql = "CREATE TABLE PROPVIEW" +
                      "(CLIENTNUM INT PRIMARY KEY     NOT NULL," +
                      " FNAME        TEXT   NOT NULL, " +
                      " LNAME        TEXT   NOT NULL, " +
                      " CELL         TEXT   NOT NULL, " + 
                      " PROPNUM      INT    NOT NULL, " + 
                      " STREET       TEXT   NOT NULL, " + 
                      " CITY         TEXT   NOT NULL, " + 
                      " POSTCODE     TEXT   NOT NULL, " +
                      " DATE         TEXT   NOT NULL, " + 
                      " COMMENTS     TEXT   NOT NULL)"; 
         stmt.executeUpdate(sql);
         
         sql = "CREATE TABLE LEASE" +
                      "(LEASENUM INT PRIMARY KEY     NOT NULL," +
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
         stmt.executeUpdate(sql);
      
         stmt.close();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Created database and tables successfully");
    }
}
