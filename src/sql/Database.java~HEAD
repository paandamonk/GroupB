package sql;
import java.sql.*;
import java.util.*;

import pp.*;
import sql.Input;
import sql.Print;

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
       //Input pInput = new Input("PROPERTIES");
       //pInput.addPropertyInfo(1, "'2'", "'3'", "'4'" ,"'5'", 4, 43.2, "'john'");
       //Print print = new Print("PROPERTIES");
       //print.Print("PROPERTIES");
      // getProp(000);
       //printProp(000);

       //Input clientInput = new Input("CLIENTS");
       //clientInput.addClientInfo(0,"'Connor'", "'Colabella'", "'123-456-7890'",
       //        30, 5, 0, "'Highland'", 100.0);

        //ArrayList<Client> clientList = getClients();
        //System.out.println(clientList.get(0).getFname() + " TEST");

        //Input leaseInput = new Input("LEASE");
        //leaseInput.addLeaseInfo(0, 1, "'Thomas'", "'Benedict'", 1, "'30 Archibald Lane'", "'Kingston'", "'12528'",
         //    "'Apartment'", 3, 750.0, "'Credit'", 1000.0, 1, "'12/5/18'", "'12/1/20'", "'Two years'");

        //ArrayList<Lease> leaseList = getLease();
        //System.out.println(leaseList.get(0).getStreet() + " TEST");

     //Input propViewInput = new Input("PROPVIEW");
     //propViewInput.addPropViewInfo(1, "'Richard'", "'Bulganari'", "'012-345-6789'", 10,
     //        "'40 Hawk Drive'", "'Albany'", "'10405'", "'6/22/19'", "'Beautiful view'");

     ArrayList<PropView> propViewList = getPropView();
     System.out.println(propViewList.get(0).getViewDate() + " TEST");


   }
 public ArrayList<Staff> getStaff(int pos){
	 // returns all staff members of a certain level, call with 3 for all staff
	 // 0 = agent, 1 = supervisor, 2 = manager
		Statement stmt = null;
		int clearance = 0;
		ArrayList<Staff> list = new ArrayList<Staff>();
		try {
			ResultSet rs = stmt.executeQuery( "SELECT * FROM COMPANY;" );
			while(rs.next()){
			 int id = rs.getInt("id");
			 clearance = rs.getInt("pos");
             String  name = rs.getString("name");
             int age  = rs.getInt("age");
             String  address = rs.getString("address");
             double salary = rs.getDouble("salary");
             String branch = rs.getString("branch");
             if(clearance == pos){
            		Staff staff = new Staff(id, name, age, address, salary);
                 	list.add(staff);
             } 
             else if(clearance == 3){
            	 Staff staff = new Staff(id, name, age, address, salary);
            	 list.add(staff);
             }
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
 public void displayStaff(){
	 ArrayList<Staff> staffList = getStaff(3);
	 String name;
	 int position;
	 double salary;
	 for(int i = 0; i < staffList.size(); i++){
		 name = staffList.get(i).getName();
		 position = staffList.get(i).getPosition();
		 salary = staffList.get(i).getSalary();
		 // connect this garbage to the front end
	 }
	 
 }
 public static ArrayList<Client> getClients(){
     Connection c = null;
     Statement stmt = null;

     ArrayList<Client> clientList = new ArrayList();
     String fName, lName, phone, street, city, postCode;
     int idNum, staffNum;
     float maxRent;

 		try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
 			ResultSet rs = stmt.executeQuery("SELECT * FROM CLIENTS;");
 			while(rs.next()){
                idNum = rs.getInt("CLIENTID");
		 		fName = rs.getString("FNAME");
		 		lName = rs.getString("LNAME");
                phone = rs.getString("PHONE");
                staffNum = rs.getInt("STAFFNUM");
		 		street = rs.getString("STREET");
                city = rs.getString("CITY");
                postCode = rs.getString("POSTCODE");
                maxRent = rs.getFloat("MAXRENT");

		 		Client client = new Client(idNum, fName, lName, phone, staffNum, idNum, street, city, postCode, maxRent);
		 		clientList.add(client);
 			}
	 	}catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
 		return clientList;
 }


 
 public static void printProp(int Num) {
     Connection c = null;
     Statement stmt = null;
     ArrayList<PropertyNew> propertiesList = new ArrayList<PropertyNew>();
     
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
       
        /*if(Num == propNum){
        	Property prp = new Property(street,city,postcode,type, propNum,rooms,rent,owner);
        	propertiesList.add(prp);
        } 
        else if(propNum == 000){*/
        	PropertyNew prp = new PropertyNew(street, city, postcode, type, propNum, rooms, rent, owner);
        	propertiesList.add(prp);
        	System.out.println(propertiesList.get(0).getStreet().toString() + " TEST");
        //}

//return list;*/
        
        
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

    public static ArrayList<PropView> getPropView(){
        Connection c = null;
        Statement stmt = null;

        ArrayList<PropView> propViewList = new ArrayList();
        int clientId, propertyId;
        String fname, lname, phone, street, city, postCode, viewDate, comments;

        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM PROPVIEW;");
            while(rs.next()){
                clientId = rs.getInt("CLIENTNUM");
                fname = rs.getString("FNAME");
                lname = rs.getString("LNAME");
                phone = rs.getString("CELL");
                propertyId = rs.getInt("PROPNUM");
                street = rs.getString("STREET");
                city = rs.getString("CITY");
                postCode = rs.getString("POSTCODE");
                viewDate = rs.getString("VIEWDATE");
                comments = rs.getString("COMMENTS");

                PropView propView = new PropView(clientId, fname, lname, phone, propertyId, street, city, postCode, viewDate, comments);
                propViewList.add(propView);
            }
        }catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return propViewList;
    }

    public static ArrayList<Lease> getLease(){
        Connection c = null;
        Statement stmt = null;

        ArrayList<Lease> leaseList = new ArrayList();
        String fname, lname, street, city, postCode, type, payMethod, rentStart, rentEnd, duration;
        int leaseId, clientId, propertyId, numRooms, paidDeposit;
        double monthlyRent, deposit;

        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM LEASE;");
            while(rs.next()){
                leaseId = rs.getInt("LEASENUM");
                clientId = rs.getInt("CLIENTNUM");
                fname = rs.getString("FNAME");
                lname = rs.getString("LNAME");
                propertyId = rs.getInt("PROPNUM");
                street = rs.getString("STREET");
                city = rs.getString("CITY");
                postCode = rs.getString("POSTCODE");
                type = rs.getString("TYPE");
                numRooms = rs.getInt("ROOMS");
                monthlyRent = rs.getDouble("RENT");
                payMethod = rs.getString("PAYMETHOD");
                deposit = rs.getDouble("DEPOSIT");
                paidDeposit = rs.getInt("PAIDDEPOSIT");
                rentStart = rs.getString("STARTDATE");
                rentEnd = rs.getString("ENDDATE");
                duration = rs.getString("DURATION");

                Lease lease = new Lease(leaseId, clientId, fname, lname, propertyId, street, city, postCode,
                        type, numRooms, monthlyRent, payMethod, deposit, paidDeposit, rentStart, rentEnd, duration);
                leaseList.add(lease);
            }
        }catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return leaseList;
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
}
