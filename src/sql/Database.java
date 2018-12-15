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
            c = DriverManager.getConnection("jdbc:sqlite:database.db");
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

        // Input staffInput = new Input("STAFF");
        // staffInput.addStaffInfo(5, "'Matt'", "'Smith'", 1, "'New York'", "'Male'", "'10/14/1997'", 23000.540, 6);

        //Input clientInput = new Input("CLIENTS");
        //clientInput.addClientInfo(1,"'Connor'", "'Colabella'", "'Apartment'", "'123-456-7890'",
        //        30, 5, "'40'", "'Highland'", "'12234'");

        // ArrayList<Client> clientList = getClientByID(0);
        // System.out.println(clientList.get(0).getStaff().getFname() + " TEST");

        //Input leaseInput = new Input("LEASE");
        //leaseInput.addLeaseInfo(0, 1, "'Thomas'", "'Benedict'", 1, "'30 Archibald Lane'", "'Kingston'", "'12528'",
        //     "'Apartment'", 3, 750.0, "'Credit'", 1000.0, 1, "'12/5/18'", "'12/1/20'", "'Two years'");

        //ArrayList<Lease> leaseList = getLease();
        //System.out.println(leaseList.get(0).getStreet() + " TEST");

        //Input propViewInput = new Input("PROPVIEW");
        //propViewInput.addPropViewInfo(1, "'Richard'", "'Bulganari'", "'012-345-6789'", 10,
        //        "'40 Hawk Drive'", "'Albany'", "'10405'", "'6/22/19'", "'Beautiful view'");

        //ArrayList<PropView> propViewList = getPropView();
        //System.out.println(propViewList.get(0).getViewDate() + " TEST");

        //Input propOwnerInput = new Input("PROPOWNERS");
        //propOwnerInput.addPropOwnerInfo(0, "'Jerry'", "'Seinfeld'",
        //        "'40 Dollop'", "'New York'", "'10020'", 1, "'000-111-2222'");

        //ArrayList<PropertyOwner> propertyOwnerList = getPropOwnersByID(0);
        //System.out.println(propertyOwnerList.get(0).getFname() + " TEST");

        //Input businessOwnerInput = new Input("BUSOWNERS");
        //businessOwnerInput.addBusinessOwnerInfo(0, "'Jerry'", "'Seinfeld'",
        //       "'40 Dollop'", "'New York'", "'10020'", "'000-111-2222'",
        //      "'Proper Properties'", "'Property Rental'", 1);

        //ArrayList<BusinessOwner> businessOwnerList = getBusinessOwnersByID(0);
        // System.out.println(businessOwnerList.get(0).getFname() + " TEST 1");

        EditData ed = new EditData();
        //ed.deleteInfo("BUSOWNERS", "OWNERNUM", 0);

        ed.updateInfo("STAFF", "FNAME", 0, "Seymour", "STAFFNUM",1);
        ed.updateInfo("STAFF", "LNAME", 0, "Lanellope", "STAFFNUM",1);



        ArrayList<BusinessOwner> businessOwnerList = getBusinessOwnersByID(0);
        if(businessOwnerList.size() > 0) {
            System.out.println(businessOwnerList.get(0).getFname() + " " + businessOwnerList.get(0).getLname());
        }
        else{
            System.out.println("No business owners exist in the database.");
        }
        ArrayList<Staff> staffList = getStaffByID(0);
        System.out.println(staffList.get(0).getFname() + " " + staffList.get(0).getLname());

    }

    public static ArrayList<Staff> getStaffByID(int idNum){
        Connection c = null;
        Statement stmt = null;

        ArrayList<Staff> staffList = new ArrayList();
        int staffID, position, supervisorId;
        String Fname, Lname, branch, sex, DoB, username, password;
        double salary;

        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:database.db");
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
                username = rs.getString("USERNAME");
                password = rs.getString("PASSWORD");
                supervisorId = rs.getInt("SUPERVISOR");

                //Return staff of given ID
                if(staffID == idNum) {
                    Staff staff = new Staff(staffID, position, Fname, Lname, branch, sex, DoB, salary, username, password, supervisorId);
                    staffList.add(staff);
                    return staffList;
                }
                else if(idNum == 0){
                    Staff staff = new Staff(staffID, position, Fname, Lname, branch, sex, DoB, salary, username, password,  supervisorId);
                    staffList.add(staff);
                }
                Staff staff = new Staff(staffID, position, Fname, Lname, branch, sex, DoB, salary, username, password,  supervisorId);
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
            c = DriverManager.getConnection("jdbc:sqlite:database.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM PROPOWNERS;");

            while ( rs.next() ) {
                FName = rs.getString("FNAME");
                LName = rs.getString("LNAME");
                street = rs.getString("STREET");
                city = rs.getString("CITY");
                postcode = rs.getString("POSTCODE");
                phone = rs.getString("PHONE");
                OID = rs.getInt("OWNERNUM");
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
            c = DriverManager.getConnection("jdbc:sqlite:database.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM BUSOWNERS;");

            while ( rs.next() ) {
                FName = rs.getString("FNAME");
                LName = rs.getString("LNAME");
                street = rs.getString("STREET");
                city = rs.getString("CITY");
                postCode = rs.getString("POSTCODE");
                phone = rs.getString("PHONE");
                ownerId = rs.getInt("OWNERNUM");
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
        float maxRent;

        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:database.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM CLIENTS;");
            while(rs.next()){
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

                System.out.println("name: " + fName + " " + lName);

                if(cID == idNum) {
                    Client client = new Client(idNum, fName, lName, type, phone, staffNum, street, city, postCode, maxRent);
                    clientList.add(client);
                    return clientList;
                }
                else if(cID == 0) {
                    Client client = new Client(idNum, fName, lName, type, phone, staffNum, street, city, postCode, maxRent);
                    clientList.add(client);
                }


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
            c = DriverManager.getConnection("jdbc:sqlite:database.db");
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
            c = DriverManager.getConnection("jdbc:sqlite:database.db");
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

    public static ArrayList<Lease> getLeaseByClientId(int clientIdInput){
        Connection c = null;
        Statement stmt = null;

        ArrayList<Lease> leaseList = new ArrayList();
        String fname, lname, street, city, postCode, type, payMethod, rentStart, rentEnd, duration;
        int leaseId, clientId, propertyId, numRooms, paidDeposit;
        double monthlyRent, deposit;

        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:database.db");
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