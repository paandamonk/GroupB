package pp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Calendar;
import java.util.Scanner;

public class Testclass {

	public static void main(String[] args) {
		Connection conn = null;
		String myDriver = "com.mysql.cj.jdbc.Driver";
		String myUrl = "jdbc:mysql://localhost:3306/myserver";
		String username;
		String password;
		String query = " insert into users (first_name, last_name, date_created, is_admin, num_points)"
				+ " values (?, ?, ?, ?, ?)";
		
		//All queries for sending information to the MySQL server tables.
		String rentquery = " insert into renters (renter_number, first_name, last_name, phone_number, staff_first_name,"
				+ "staff_last_name, prop_street, prop_city, prop_postcode, prop_type, prop_number, number_rooms, monthly_rent,"
				+ "prop_owner_first_name, prop_owner_last_name)"
				+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		String propertyquery = " insert into properties (prop_street, prop_city, prop_postcode, prop_type, prop_number, number_rooms, monthly_rent,"
				+ "prop_owner_first_name, prop_owner_last_name)" + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		String POquery = " insert into propertyowners (prop_owner_number, prop_owner_first_name, prop_owner_last_name,"
				+ "prop_street, prop_city, prop_postcode, prop_type, prop_number, number_rooms, monthly_rent,"
				+ "staff_first_name, staff_last_name)" + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		String BOquery = " insert into business owners (prop_owner_number, prop_owner_first_name, prop_owner_last_name,"
				+ "prop_street, prop_city, prop_postcode, prop_type, prop_number, number_rooms, monthly_rent,"
				+ "staff_first_name, staff_last_name, business_name, business_type)" + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		String leasequery = " insert into leases (lease_number, client_first_name, client_last_name, "
				+ "prop_street, prop_city, prop_postcode, prop_type, prop_number, number_rooms, monthly_rent,"
				+ "prop_owner_first_name, prop_owner_last_name, paymethod, deposit, deposit_paid,"
				+ "rent_start, rent_end, duration)" + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		String viewingquery = " insert into viewings (renter_number, first_name, last_name,"
				+ "prop_street, prop_city, prop_postcode, prop_type, prop_number, number_rooms, monthly_rent,"
				+ "prop_owner_first_name, prop_owner_last_name, view_date, comments)"
				+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		String staffquery = " insert into staff (staff_position, first_name, last_name,"
				+ "gender, dob, supervisor_first_name, supervisor_last_name)" + " values (?, ?, ?, ?, ?, ?, ?)";
		
		try {
			Scanner key = new Scanner(System.in);
			System.out.println("Enter username: ");
			username = key.nextLine();
			System.out.println("Enter password: ");
			password = key.nextLine();
			Class.forName(myDriver);
			conn = DriverManager.getConnection(myUrl, username, password);

			if (conn != null) {
				System.out.println("Connected");
			}

			// create a sql date object so we can use it in our INSERT statement
			Calendar calendar = Calendar.getInstance();
			java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

			// the mysql insert statement

			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, "Barney");
			preparedStmt.setString(2, "Rubble");
			preparedStmt.setDate(3, startDate);
			preparedStmt.setBoolean(4, false);
			preparedStmt.setInt(5, 5000);

			// execute the preparedstatement
			preparedStmt.execute();

			conn.close();
		}

		catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
	}

}
