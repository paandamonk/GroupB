package sql;
import java.sql.*;

public class EditData {
    public EditData(){}

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
          System.out.println("Update method finished successfully (does not necessarily mean update was successful");
    }
    public void deleteInfo(String tableName, String primeFactor, int idNumber){
        //Disables deletion of master user
        if(tableName.equals("STAFF") && idNumber == 1){
            System.out.println("Cannot delete Master User");
            return;
        }
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
        System.out.println("Delete method finished successfully (does not necessarily mean delete was successful)");
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