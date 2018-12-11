package sql;
import java.sql.*;
import java.util.ArrayList;

import pp.Client;

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
         String fName, lName, type, phone, street, city, postCode;
         int idNum, staffNum;
         float maxRent;
         while ( rs.next() ) {
        	 idNum = rs.getInt("CLIENTID");
		 		fName = rs.getString("FNAME");
		 		lName = rs.getString("LNAME");
             type = rs.getString("TYPE");
             phone = rs.getString("PHONE");
             staffNum = rs.getInt("STAFFNUM");
		 		street = rs.getString("STREET");
             city = rs.getString("CITY");
             postCode = rs.getString("POSTCODE");
             maxRent = rs.getFloat("MAXRENT");
             
            System.out.println(idNum);
            System.out.println(fName);
            System.out.println(lName);
            System.out.println(type);
            System.out.println(phone);
            System.out.println(staffNum);
            System.out.println(street);
            System.out.println(postCode);
            System.out.println(maxRent);



           
      }
      rs.close();
      stmt.close();
      c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         //System.exit(0);
      }
      System.out.println("Operation done successfully");
    }
}
