package sql;
import java.io.File;
import java.io.PrintWriter;
import java.security.acl.Owner;
import java.sql.*;
import java.util.*;

import aes.encryption;
import pp.*;
import sql.Input;

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

        Input staffInput = new Input("STAFF");
        //staffInput.addStaffInfo("'Sarah'", "'Hughes'", 0, "'New York'", "'Male'", "'10/14/1997'", 23000.540,"'Bugs'","'RabbitSeason'", 2);
       // staffInput.addStaffInfo("'Sarah'", "'Hughes'", 0, "'New York'", "'Male'", "'10/14/1997'", 23000.540,"'Bugs'","'RabbitSeason'", 3);
        //staffInput.addStaffInfo("'Sarah'", "'Hughes'", 0, "'New York'", "'Male'", "'10/14/1997'", 23000.540,"'Bugs'","'RabbitSeason'", 4);

        Input propertyOwnerInput = new Input("PROPOWNERS");
        propertyOwnerInput.addPropOwnerInfo("'Captain'", "'Picard'", "'40 Dollop'", "'New York'", "'10020'",
                "'000-111-2222'", 11);

        Input propertyInput = new Input("PROPERTIES");
        //propertyInput.addPropertyInfo("'20 Bellend Road'", "'12345'", "'Riverrun'", "'House'", 6, 2.0, 1);

        Input businessOwnerInput = new Input("BUSOWNERS");
       // businessOwnerInput.addBusinessOwnerInfo("'Benny'", "'Hood'",
         //     "'40 Dollop'", "'New York'", "'10020'", "'000-111-2222'",
         //   "'Proper Properties'", "'Property Rental'", 11);

        //ArrayList<BusinessOwner> businessOwnerList = getBusinessOwnersByID(0);
        // System.out.println(businessOwnerList.get(0).getFname() + " TEST 1");

        EditData ed = new EditData();
        //ed.deleteInfo("BUSOWNERS", "BOWNERNUM", 1);


        //ed.updateInfo("STAFF", "FNAME", 0, "Seymour", "STAFFNUM",1);
        // ed.updateInfo("STAFF", "LNAME", 0, "Lanellope", "STAFFNUM",1);

        Input clientInput = new Input("CLIENTS");
        //clientInput.addClientInfo("'Connor'", "'Colabella'", "'Apartment'", "'123-456-7890'", 30.1, 9, "'40'", "'Highland'", "'12234'");
        //clientInput.addClientInfo("'Connor'", "'Colabella'", "'Apartment'", "'123-456-7890'", 30.1, 11, "'40'", "'Highland'", "'12234'");
        //clientInput.addClientInfo("'Connor'", "'Colabella'", "'Apartment'", "'123-456-7890'", 30.1, 10, "'40'", "'Highland'", "'12234'");
       // clientInput.addClientInfo("'Connor'", "'Colabella'", "'Apartment'", "'123-456-7890'", 30.1, 2, "'40'", "'Highland'", "'12234'");
       // clientInput.addClientInfo("'Connor'", "'Colabella'", "'Apartment'", "'123-456-7890'", 30.1, 4, "'40'", "'Highland'", "'12234'");

        BusinessOwner businessOwner = new BusinessOwner();
        ArrayList<BusinessOwner> businessOwnerList = businessOwner.getBusinessOwnersByID(0);
        if(businessOwnerList.size() > 0) {
            for(int i = 0; i < businessOwnerList.size(); i++){
                System.out.println(businessOwnerList.get(i).getPostCode() + ", " + businessOwnerList.get(i).getCity() + ", " +  businessOwnerList.get(i).getStreet());
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
        Property property = new Property();
        ArrayList<Property> propertyList = property.getPropertyByID(0);
        for(int i = 0; i < propertyList.size(); i++){
            System.out.println(propertyList.get(i).getCity());
        }
    }
}