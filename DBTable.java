package pp;

import java.sql.*;
import java.util.*;

public class DBTable {

   public static void main( String args[] ) {
      Connection c = null;
      int Find;
      Scanner kb = new Scanner(System.in);
      Statement stmt = null;
      ArrayList<Staff> list = new ArrayList<Staff>();
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:test.db");
         System.out.println("Opened database successfully");
         stmt = c.createStatement();
		 ResultSet rs = stmt.executeQuery( "SELECT * FROM COMPANY;" );
		 System.out.println("Enter employee id:");
	     Find = kb.nextInt(); 
         while ( rs.next() ) {
             int id = rs.getInt("id");
             String  name = rs.getString("name");
             int age  = rs.getInt("age");
             String  address = rs.getString("address");
             float salary = rs.getFloat("salary");
             
             Staff s1 = new Staff(id, name, age, address, salary);
             list.add(s1);
             
             //stmt = c.createStatement();
             }
         while(true){
        	 for(int i = 0; i < list.size(); i++){
        		 if(list.get(i).getID() == Find){
        			 System.out.println("");
        			 
        		 }
        	 }
         }
      } catch (Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      /*String sql1 = "CREATE TABLE COMPANY " +
      "(ID INT PRIMARY KEY     NOT NULL," +
      " NAME           TEXT    NOT NULL, " + 
      " AGE            INT     NOT NULL, " + 
      " ADDRESS        CHAR(50), " + 
      " SALARY         REAL)"; 
stmt.executeUpdate(sql1);
*/

/*String sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
   "VALUES (1, 'Paul', 32, 'California', 20000.00 );"; 
stmt.executeUpdate(sql);

sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
"VALUES (2, 'Allen', 25, 'Texas', 15000.00 );"; 
stmt.executeUpdate(sql);

sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
"VALUES (3, 'Teddy', 23, 'Norway', 20000.00 );"; 
stmt.executeUpdate(sql);

sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
"VALUES (4, 'Mark', 25, 'Rich-Mond ', 65000.00 );"; 
stmt.executeUpdate(sql);
System.out.println("Table created successfully");

*/    
   }
}