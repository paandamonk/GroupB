package sql;
import java.security.acl.Owner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import pp.Client;
import pp.Property;
import pp.PropertyOwner;
import pp.Staff;

public class Database {
 public static void main(String[] args) {
      Connection c = null;
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:test.db");
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
     // Input sInput = new Input("STAFF");
      //sInput.addInfo(1, "2", "3", 4, 43.2);
      Input oInput = new Input("OWNERS");
      oInput.addOInfo(1, "'JOE'", "'JOHNSON'", "'MAIN ST'", "'NEW PALTZ'", "'12561'", 2, "'911'");
       Input pInput = new Input("PROPERTIES");
       pInput.addPInfo(1, "'JOES HOUSE'", "'3'", "'4'" ,"'5'", 4, 43.2, 1);
       Input sInput = new Input("STAFF");
       sInput.addSInfo(2, "'MATT'", "'SMITH'", 1, "'NEW YORK'", "'MALE'", "'10/14/1997'", 23000.540, 6);
       
       
       Print print = new Print("PROPERTIES");   
       print.Print("PROPERTIES");
       //getProp(000);
       printProp(000);

   }
 public ArrayList<Staff> getStaffPos(int pos){
	 // returns all staff members of a certain level, call with 3 for all staff
	 // 0 = agent, 1 = supervisor, 2 = manager
		Statement stmt = null;
		int position = 0;
		ArrayList<Staff> list = new ArrayList<Staff>();
		try {
			ResultSet rs = stmt.executeQuery( "SELECT * FROM STAFF;" );
			while(rs.next()){
				int sID = rs.getInt("ID");
				position = rs.getInt("POSITION");
				String  Fname = rs.getString("FNAME");
				String Lname = rs.getString("LNAME");
				String branch = rs.getString("BRANCH");
				String sex = rs.getString("SEX");
				String DoB = rs.getString("DOB");
				Double salary = rs.getDouble("SALARY");
				int sup = rs.getInt("SUPERVISOR");
                if(position == pos){
	            		Staff staff = new Staff(Integer.toString(sID), position, Fname, Lname, branch, sex, DoB, salary, sup);
	                 	list.add(staff);
	             } 
	             else if(position == 3){
	            		Staff staff = new Staff(Integer.toString(sID), position, Fname, Lname, branch, sex, DoB, salary, sup);
	            		list.add(staff);
	             }
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
 
 public ArrayList<Staff> getStaff(int idNum){
	 ArrayList<Staff> sList = new ArrayList<Staff>();
	 Statement stmt = null;
	int position = 0;
	try {
			ResultSet rs = stmt.executeQuery( "SELECT * FROM STAFF;" );
			while(rs.next()){
				int sID = rs.getInt("ID");
				position = rs.getInt("POSITION");
				String  Fname = rs.getString("FNAME");
				String Lname = rs.getString("LNAME");
				String branch = rs.getString("BRANCH");
				String sex = rs.getString("SEX");
				String DoB = rs.getString("DOB");
				Double salary = rs.getDouble("SALARY");
				int sup = rs.getInt("SUPERVISOR");
				if(sID == idNum){
	            		Staff staff = new Staff(Integer.toString(sID), position, Fname, Lname, branch, sex, DoB, salary, sup);
	                 	sList.add(staff);
	                 	return sList;
	             } 
	             else if(idNum == 0){
	            		Staff staff = new Staff(Integer.toString(sID), position, Fname, Lname, branch, sex, DoB, salary, sup);
	            		sList.add(staff);
	             }
			}
	} catch (SQLException e) {
		e.printStackTrace();
	}
				return sList;
 }
 public void displayStaff(){
	 ArrayList<Staff> staffList = getStaff(3);
	 String Fname, Lname;
	 int position;
	 double salary;
	 for(int i = 0; i < staffList.size(); i++){
		 Fname = staffList.get(i).getFname();
		 Lname = staffList.get(i).getLname();
		 position = staffList.get(i).getPosition();
		 salary = staffList.get(i).getSalary();
	 }
	 
 }
 public ArrayList<Client> getClient(){
	 	ArrayList<Client> clientList = new ArrayList();
	 	Statement stmt = null;
 		String fName, lName, address, phone;
 		float maxRent;
 		Staff Mem;
 		int idNum, staffNum;
 		try{
 			ResultSet rs = stmt.executeQuery("SELECT * FROM CLIENTS;");
 			while(rs.next()){
		 		fName = rs.getString("FNAME");
		 		lName = rs.getString("LNAME");
		 		phone = rs.getString("PHONE");
		 		staffNum = rs.getInt("STAFFNUM");	 		
		 		idNum = rs.getInt("CLIENTNUM");
		 		maxRent = rs.getFloat("MAXRENT");
		 		String type = rs.getString("TYPE");
		 		Mem = getStaff(staffNum).get(1);
		 		Client client = new Client(fName, lName, phone, Mem, idNum, maxRent, type);
		 		clientList.add(client);
 			}
	 	}catch(SQLException e){
	 		e.printStackTrace();
	 	}
 		return clientList;
 }

	public void getProp(String tableName) {
	      Connection c = null;
	  	ArrayList<Property> list = new ArrayList<Property>();
	      Statement stmt = null;
	      
	      try {
	         Class.forName("org.sqlite.JDBC");
	         c = DriverManager.getConnection("jdbc:sqlite:test.db");
	         c.setAutoCommit(false);
	         System.out.println("Opened database successfully");

	         stmt = c.createStatement();
	         ResultSet rs = stmt.executeQuery( "SELECT * FROM " + tableName + ";" );
	         
	         while ( rs.next() ) {
	         int propNum = rs.getInt("PROPNUM");
	         String  street = rs.getString("STREET");
	         String city = rs.getString("CITY");
	         String postcode = rs.getString("POSTCODE");
	         String type  = rs.getString("TYPE");
	         int  rooms = rs.getInt("ROOMS");
	         double rent = rs.getDouble("RENT");
	         
	         System.out.println( "PROPNUM = " + propNum );
	         System.out.println( "STREET = " + street );
	         System.out.println("CITY = " + city);
	         System.out.println("POSTCODE = " + postcode);
	         System.out.println( "TYPE = " + type );
	         System.out.println( "ROOMS = " + rooms );
	         System.out.println( "RENT = " + rent );
	         System.out.println();
	      }
	      rs.close();
	      stmt.close();
	      c.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
	      }
	}
 
 public static void printProp(int Num) {
     Connection c = null;
     Statement stmt = null;
     ArrayList<Property> propertiesList = new ArrayList<Property>();
     
     try {
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:test.db");
        c.setAutoCommit(false);
        System.out.println("Opened database successfully");

        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery( "SELECT * FROM " + "PROPERTIES " + ";" );
        
        while ( rs.next() ) {
        int propNum = rs.getInt("PROPNUM");
        String  street = rs.getString("STREET");
        String city = rs.getString("CITY");
        String postcode = rs.getString("POSTCODE");
        String type  = rs.getString("TYPE");
        int  rooms = rs.getInt("ROOMS");
        double rent = rs.getDouble("RENT");
        String owner  = rs.getString("OWNER");
        
        System.out.println( "PROPNUM = " + propNum );
        System.out.println( "STREET = " + street );
        System.out.println("CITY = " + city);
        System.out.println("POSTCODE = " + postcode);
        System.out.println( "TYPE = " + type );
        System.out.println( "ROOMS = " + rooms );
        System.out.println( "RENT = " + rent );
        System.out.println( "OWNER = " + owner);
       
        if(Num == propNum){
        	Property prp = new Property(street,city,postcode,type, propNum,rooms,rent,owner);
        	propertiesList.add(prp);
        } 
        else if(propNum == 000){
        	Property prp = new Property(street, city, postcode, type, propNum, rooms, rent, owner);
        	propertiesList.add(prp);
        	System.out.println(propertiesList.get(0).getStreet().toString() + " TEST");
        }        
     }
     rs.close();
     stmt.close();
     c.close();
     } catch ( Exception e ) {
        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        System.exit(0);
     }
     System.out.println("Operation done successfully");
   }
 
 public ArrayList<PropertyOwner> getOwners(int ownID){
	 	ArrayList<PropertyOwner> OList	= new ArrayList<>();
	 	Connection c = null;
	    Statement stmt = null;
	    String FName, LName, street, city, postcode, phone;
	    int OID, MID;
	    try {
	        Class.forName("org.sqlite.JDBC");
	        c = DriverManager.getConnection("jdbc:sqlite:test.db");
	        c.setAutoCommit(false);
	        System.out.println("Opened database successfully");

	        stmt = c.createStatement();
	        ResultSet rs = stmt.executeQuery( "SELECT * FROM " + "OWNERS " + ";" );
	        
	        while ( rs.next() ) {
		       FName = rs.getString("FNAME");
		       LName = rs.getString("LNAME");
		       street = rs.getString("STREET");
		       city = rs.getString("CITY");
		       postcode = rs.getString("POSTCODE");
		       phone = rs.getString("PHONE");
		       OID = rs.getInt("OWNERNUM");
		       MID = rs.getInt("MEMID");	
		       
		       if(ownID == OID) {
		    	   PropertyOwner o1 = new PropertyOwner(FName, LName, street, city, postcode, phone, OID, MID);
			       OList.add(o1);
			       return OList;
		       }
		       if(ownID == 0) {
		    	   PropertyOwner o1 = new PropertyOwner(FName, LName, street, city, postcode, phone, OID, MID);
			       OList.add(o1);
		       }
	        }
	     }catch ( Exception e ) {
	            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	            System.exit(0);
	     }
	  return OList;
	        
 }
}
	     
		         
		         
		         
		         /*if(Num == propNum){
	     		Property prp = new Property(street,city,postcode,type, propNum,rooms,rent,owner);
	          	list.add(prp);
	      } 
	      else if(propNum == 000){
	    	  Property prp = new Property(street, city, postcode, type, propNum, rooms, rent, owner);
	          list.add(prp);
	          System.out.println(list.get(0));
	      }
		}
		} catch ( Exception e ) {
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
	      }
		System.out.println("Dicks");
		//return list;*/

