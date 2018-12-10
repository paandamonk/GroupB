import java.sql.*;

public class EditData
{
    public EditData(){}
    
    public void addNewStaff(int staffNum, String fName, String lName, int position, String branch, String sex, String dOB, String supervisor){
        Connection c = null;
        Statement stmt = null;
        
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            
            stmt = c.createStatement();

            String sql = "INSERT INTO STAFF (STAFFNUM,FNAME,LNAME,POSITION,BRANCH,SEX,DOB,SUPERVISOR) " +
                            "VALUES (" + staffNum + "," + fName + "," + lName + "," + position + "," + branch + "," + sex + "," + dOB + "," + supervisor + ");"; 
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
    public void updateInfo(String tableName, String parameter, int dataType, String infoValue, String primeFactor, int idNumber){
        Connection c = null;
        Statement stmt = null;
        
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            //System.out.println("Opened database successfully");
            
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
         c = DriverManager.getConnection("jdbc:sqlite:test.db");
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
         c = DriverManager.getConnection("jdbc:sqlite:test.db");
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