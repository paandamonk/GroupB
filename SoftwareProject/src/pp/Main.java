package pp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Calendar;

public class Main {

	public static void main(String[] args) throws Exception {
		Connection conn = null;
		 try
		    { //jdbc:mysql://localhost:3306/?user=root
		      // create a mysql database connection
		      String myDriver = "com.mysql.cj.jdbc.Driver";
		      String myUrl = "jdbc:mysql://localhost:3306/myserver";
		      Class.forName(myDriver);
		      conn = DriverManager.getConnection(myUrl, "root", "spacejam2018");
		      
		      if(conn != null) {
		    	  System.out.println("connected");
		      }
		    
		      // create a sql date object so we can use it in our INSERT statement
		      Calendar calendar = Calendar.getInstance();
		      java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

		      // the mysql insert statement
		      String query = " insert into users (first_name, last_name, date_created, is_admin, num_points)"
		        + " values (?, ?, ?, ?, ?)";

		      // create the mysql insert preparedstatement
		      PreparedStatement preparedStmt = conn.prepareStatement(query);
		      preparedStmt.setString (1, "Barney");
		      preparedStmt.setString (2, "Rubble");
		      preparedStmt.setDate   (3, startDate);
		      preparedStmt.setBoolean(4, false);
		      preparedStmt.setInt    (5, 5000);

		      // execute the preparedstatement
		      preparedStmt.execute();
		      
		      conn.close();
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception!");
		      System.err.println(e.getMessage());
		    }
		  }

	}

