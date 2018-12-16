package sql;
import java.io.File;
import java.io.PrintWriter;
import java.security.acl.Owner;
import java.sql.*;
import java.util.*;

import aes.encryption;
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

        //Input staffInput = new Input("STAFF");
        //staffInput.addStaffInfo("'Lupin'", "'Three'", 1, "'New York'", "'Male'", "'10/14/1997'", 23000.540,"'Bugs'","'RabbitSeason'", 1);

        //Input businessOwnerInput = new Input("BUSOWNERS");
        //businessOwnerInput.addBusinessOwnerInfo("'Robin'", "'Hood'",
         //      "'40 Dollop'", "'New York'", "'10020'", "'000-111-2222'",
          //    "'Proper Properties'", "'Property Rental'", 1);

        //ArrayList<BusinessOwner> businessOwnerList = getBusinessOwnersByID(0);
        // System.out.println(businessOwnerList.get(0).getFname() + " TEST 1");

        EditData ed = new EditData();
        ed.deleteInfo("STAFF", "STAFFNUM", 1);

        //ed.updateInfo("STAFF", "FNAME", 0, "Seymour", "STAFFNUM",1);
        //ed.updateInfo("STAFF", "LNAME", 0, "Lanellope", "STAFFNUM",1);

        //Input clientInput = new Input("CLIENTS");
        //clientInput.addClientInfo("'Connor'", "'Colabella'", "'Apartment'", "'123-456-7890'",
        //        30.1, 5, "'40'", "'Highland'", "'12234'");

        BusinessOwner businessOwner = new BusinessOwner();
        ArrayList<BusinessOwner> businessOwnerList = businessOwner.getBusinessOwnersByID(0);
        if(businessOwnerList.size() > 0) {
            for(int i = 0; i < businessOwnerList.size(); i++){
                System.out.println(businessOwnerList.get(i).getFname() + " " + businessOwnerList.get(i).getLname() + ", " +  businessOwnerList.get(i).getOwnerNum());
            }
        }
        else{
            System.out.println("No business owners exist in the database.");
        }
        Staff staff = new Staff();
        ArrayList<Staff> staffList = staff.getStaffByID(1);
        for(int i = 0; i < staffList.size(); i++){
            System.out.println(staffList.get(i).getFname() + " " + staffList.get(i).getLname() + ", " + staffList.get(i).getUsername() + ", " + staffList.get(i).getPassword());
        }

        //Staff staff = new Staff();
        ArrayList<Client> clientList = getClientByID(0);
        for(int i = 0; i < clientList.size(); i++){
            System.out.println(clientList.get(i).getFname() + " " + clientList.get(i).getLname() + ", " + clientList.get(i).getClientIdNum());
        }
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
            System.out.println("Opened database successfully (Clients)");

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
            System.out.println("Opened database successfully (Property)");

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
            System.out.println("Opened database successfully (PropView)");

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
            System.out.println("Opened database successfully (Lease)");

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