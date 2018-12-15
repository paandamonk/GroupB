package sql;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.*;
import aes.encryption;
import java.util.Scanner;
import sql.Input;

public class Initialize
{
    public static void main(String[] args){
        Connection c = null;
        Statement stmt = null;

        File NF = new File("11235813.txt");
        String SK;
        Scanner kb = new Scanner(System.in);

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
                    " USERNAME     TEXT   NOT NULL, " +
                    " PASSWORD     TEXT   NOT NULL, " +
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
                    " STAFFNUM     TEXT   NOT NULL, " +
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

        System.out.println("Enter secret key");
        encryption.setKey(SK = kb.nextLine());
        try (PrintWriter out = new PrintWriter("11235813.txt")) {
            out.println(SK);
        }catch(Exception FileNotFoundException) {
            System.out.println("Unable to create file");
        }


      /* System.out.println("Enter first employee information:");
       * System.out.print("Staff ID Number: ");
      int sID = kb.nextInt();
      System.out.print("Enter First Name: ");
      String Fname = kb.nextLine();
      System.out.print("Enter Last Name: ");
      String Lname = kb.nextLine();
      System.out.println("Branch Location: ");
      String Branch = kb.nextLine();
      System.out.println("Gender: ");
      String sex = kb.nextLine();
      System.out.print("Date Of Birth (YYYY-MM-DD): ");
      String Dob = kb.nextLine();
      System.out.println("Salary: ");
      Double Salary = kb.nextDouble();
      int Pos = 2;
      int supID = 0;
      */

        System.out.println("Welcome Master User");
        System.out.println("Please Enter:");
        System.out.print("First Name: ");
        String Fname = kb.nextLine();
        System.out.print("Enter Last Name: ");
        String Lname = kb.nextLine();
        System.out.print("Enter UserName: ");
        String UserName = kb.nextLine();
        String Password1 = "q", Password2 = "p";
        while(!Password1.equals(Password2)) {
            System.out.print("Enter Password: ");
            Password1 = kb.nextLine();
            System.out.print("Verify Password: ");
            Password2 = kb.nextLine();
            System.out.println(Password1 + " " + Password2);
            if(!Password1.equals(Password2))	System.out.println("Passwords do not match, please try again");
        }

        Password1 = encryption.encrypt(Password1, SK);
        System.out.println(Password1);
        int sID = 1;
        int Pos = 4;
        String Branch = "MASTER";
        String sex = "MASTER";
        String Dob = "MASTER";
        double Salary = 0.00;
        int supID = -1;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:database.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "INSERT INTO  STAFF (STAFFNUM,FNAME,LNAME,POSITION,BRANCH,SEX,DOB,SALARY,USERNAME,PASSWORD,SUPERVISOR) " +
                    "VALUES (" + sID + ",'" + Fname + "','" + Lname + "','" + Pos + "','" + Branch + "','" + sex + "','" + Dob + "','" + Salary + "','" + UserName + "','" + Password1 + "','" + supID + "');";

            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Staff record for " + Fname + " " + Lname + " created successfully");

        System.out.println("Created database and tables successfully");
    }
}