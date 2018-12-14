package sql;
import java.security.acl.Owner;
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
      // printProp(000);

       Input staffInput = new Input("STAFF");
       staffInput.addStaffInfo("Matt", "Jones", 0, "New York", "Male", "10/14/1997", 2300.540, 2);
       staffInput.addStaffInfo("Chris", "Smith", 1, "New York", "Male", "10/14/1997", 43000.540, 3);
       staffInput.addStaffInfo("Josh", "Grosh", 2, "New York", "Male", "10/14/1997", 13000.540, 3);
       staffInput.addStaffInfo("Trevor", "Milton", 0, "New York", "Male", "10/14/1997", 23000.540, 2);
       staffInput.addStaffInfo("Allen", "Sweeney", 0, "New York", "Male", "10/14/1997", 23000.540, 2);

       Input clientInput = new Input("CLIENTS");
       String name = "Connor";
       clientInput.addClientInfo(name, "Colabella", "Apartment", "123-456-7890",
               30, 5, "40", "Highland", "12234");
       clientInput.addClientInfo("Kenny", "Manning", "Mansion", "123-456-7890",
               30, 5, "40", "Highland", "12234");
       clientInput.addClientInfo("Robert", "Williams", "Home", "123-456-7890",
               30, 5, "40", "Highland", "12234");
       clientInput.addClientInfo("Nick", "Grunk", "Desk", "123-456-7890",
               30, 5, "40", "Highland", "12234");
       clientInput.addClientInfo("Liam", "Colololol", "House", "123-456-7890",
               30, 5, "40", "Highland", "12234");

        Input leaseInput = new Input("LEASE");
        leaseInput.addLeaseInfo(1, "Thomas", "Benedict", 1, "30 Archibald Lane", "Kingston", "12528",
             "Apartment", 3, 750.0, "Credit", 1000.0, 1, "12/5/18", "12/1/20", "Two years");
        leaseInput.addLeaseInfo(1, "Shannon", "Reachie", 1, "30 Archibald Lane", "Kingston", "12528",
                "Apartment", 3, 750.0, "Credit", 1000.0, 1, "12/5/18", "12/1/20", "Two years");

     Input propViewInput = new Input("PROPVIEW");
     propViewInput.addPropViewInfo("Richard", "Bulganari", "012-345-6789", 10,
             "40 Hawk Drive", "Albany", "10405", "6/22/19", "Beautiful view");

     Input propOwnerInput = new Input("PROPOWNERS");
     propOwnerInput.addPropOwnerInfo("Jerry", "Seinfeld",
             "40 Dollop", "New York", "10020","000-111-2222", 1);

     Input businessOwnerInput = new Input("BUSOWNERS");
     businessOwnerInput.addBusinessOwnerInfo("Louie", "CK",
             "40 Dollop", "New York", "10020", "000-111-2222",
             "Proper Properties", "Property Rental", 1);
   }

    public static ArrayList<Staff> getStaffByID(int idNum){
        Connection c = null;
        Statement stmt = null;

        ArrayList<Staff> staffList = new ArrayList();
        int staffID, position, supervisorId;
        String Fname, Lname, branch, sex, DoB;
        double salary;

        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully(staff)");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM STAFF;");
            while(rs.next()){
                staffID = rs.getInt("STAFFNUM");
                Fname = rs.getString("FNAME");
                Lname = rs.getString("LNAME");
                position = rs.getInt("POSITION");
                branch = rs.getString("BRANCH");
                sex = rs.getString("SEX");
                DoB = rs.getString("DOB");
                salary = rs.getDouble("SALARY");
                supervisorId = rs.getInt("SUPERVISOR");

                //Return staff of given ID
                if(staffID == idNum) {
                    Staff staff = new Staff(staffID, position, Fname, Lname, branch, sex, DoB, salary, supervisorId);
                    staffList.add(staff);
                    return staffList;
                }
                else if(idNum == 0){
                    Staff staff = new Staff(staffID, position, Fname, Lname, branch, sex, DoB, salary, supervisorId);
                    staffList.add(staff);
                }
                Staff staff = new Staff(staffID, position, Fname, Lname, branch, sex, DoB, salary, supervisorId);
                staffList.add(staff);
            }
        }catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return staffList;
    }

    public static ArrayList<PropertyOwner> getPropOwnersByID(int ownID){
        ArrayList<PropertyOwner> OList	= new ArrayList<>();
        Connection c = null;
        Statement stmt = null;
        String FName, LName, street, city, postcode, phone;
        int OID, MID;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully (propowner)");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM PROPOWNERS;");

            while ( rs.next() ) {
                FName = rs.getString("FNAME");
                LName = rs.getString("LNAME");
                street = rs.getString("STREET");
                city = rs.getString("CITY");
                postcode = rs.getString("POSTCODE");
                phone = rs.getString("PHONE");
                OID = rs.getInt("POWNERNUM");
                MID = rs.getInt("STAFFNUM");

                if(ownID == OID) {
                    PropertyOwner o1 = new PropertyOwner(FName, LName, street, city, postcode, phone, OID, MID);
                    OList.add(o1);
                    return OList;
                }
                else if(ownID == 0) {
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

    public static ArrayList<BusinessOwner> getBusinessOwnersByID(int ownID){
        ArrayList<BusinessOwner> BusinessOwnerList	= new ArrayList<>();
        Connection c = null;
        Statement stmt = null;
        String FName, LName, street, city, postCode, phone, businessName, businessType;
        int ownerId, staffId;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully(busowner)");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM BUSOWNERS;");

            while ( rs.next() ) {
                FName = rs.getString("FNAME");
                LName = rs.getString("LNAME");
                street = rs.getString("STREET");
                city = rs.getString("CITY");
                postCode = rs.getString("POSTCODE");
                phone = rs.getString("PHONE");
                ownerId = rs.getInt("BOWNERNUM");
                staffId = rs.getInt("STAFFNUM");
                businessName = rs.getString("BNAME");
                businessType = rs.getString("BTYPE");

                if(ownID == ownerId) {
                    BusinessOwner businessOwner = new BusinessOwner(FName, LName, street, city, postCode, phone, staffId, ownerId,
                    businessName, businessType);
                    BusinessOwnerList.add(businessOwner);
                    return BusinessOwnerList;
                }
                else if(ownID == 0) {
                    BusinessOwner businessOwner = new BusinessOwner(FName, LName, street, city, postCode, phone, staffId, ownerId,
                            businessName, businessType);
                    BusinessOwnerList.add(businessOwner);
                }
            }
        }catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return BusinessOwnerList;

    }

 public static ArrayList<Client> getClientByID(int cID){
     Connection c = null;
     Statement stmt = null;
     

     ArrayList<Client> clientList = new ArrayList();
     String fName, lName, type, phone, street, city, postCode;
     int idNum, staffNum;
     double maxRent;

 		try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully (clientbyid)");

            stmt = c.createStatement();
 			ResultSet rs = stmt.executeQuery("SELECT * FROM CLIENTS;");
            idNum = rs.getInt("CLIENTID");
 			while(rs.next()){
                idNum = rs.getInt("CLIENTID");
		 		fName = rs.getString("FNAME");
		 		lName = rs.getString("LNAME");
                type = rs.getString("TYPE");
                phone = rs.getString("PHONE");
                maxRent = rs.getDouble("MAXRENT");
                staffNum = rs.getInt("STAFFN");
		 		street = rs.getString("STREET");
                city = rs.getString("CITY");
                postCode = rs.getString("POSTCODE");
		 		System.out.println("guy");
                Client client = new Client(rs.getInt("CLIENTID"), rs.getString("FNAME"), 
                		rs.getString("LNAME"), rs.getString("TYPE"), rs.getString("PHONE"), 
                		rs.getInt("STAFFN"), rs.getString("STREET"), rs.getString("CITY"), 
                		rs.getString("POSTCODE"), rs.getDouble("MAXRENT"));
                System.out.println("guy");
                if(cID == idNum) {
                	System.out.println("we're in");
                     client = new Client(idNum, fName, lName, type, phone, staffNum, street, city, postCode, maxRent);
                    System.out.println("Client being returned: " + client.toString());

                    clientList.add(client);
                    System.out.println("Client being returned: " + client.toString());
                    return clientList;
                }
                else if(cID == 0) {
                	System.out.println("we're inx2");
                     client = new Client(idNum, fName, lName, type, phone, staffNum, street, city, postCode, maxRent);
                     System.out.println("Client being returned: " + client.toString());
                    clientList.add(client);
                }
 			}
	 	}catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.out.println("Ya dun fuced it boy");
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
        System.out.println("Opened database successfully(print prop)");

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
            System.out.println("Opened database successfully(propview)");

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

    public static ArrayList<Lease> getLeaseByClientId(int clientIdInput){
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
            System.out.println("Opened database successfully(lease)");

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

                if(clientId == clientIdInput) {
                    Lease lease = new Lease(leaseId, clientId, fname, lname, propertyId, street, city, postCode,
                            type, numRooms, monthlyRent, payMethod, deposit, paidDeposit, rentStart, rentEnd, duration);
                    leaseList.add(lease);
                }
                /*else if(clientIdInput == 0) {
                    Lease lease = new Lease(leaseId, clientId, fname, lname, propertyId, street, city, postCode,
                            type, numRooms, monthlyRent, payMethod, deposit, paidDeposit, rentStart, rentEnd, duration);
                    leaseList.add(lease);
                }*/
            }
        }catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        //TODO Might return null if no leases are associated with given client.
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
