package pp;
import sql.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class PropertyOwner extends Client{
	Staff staff = new Staff();
	private String street;
	private String city;
	private String postCode;
	private int OID;
	private int MID;
	private Staff member;

	public PropertyOwner() {}

	public PropertyOwner(String FName, String LName, String street, String city, String postcode, String phone, int OID, int MID) {
		super(FName, LName, phone, MID);
		this.OID = OID;
		this.MID = MID;
		this.street = street;
		this.city = city;
		this.postCode = postcode;
		this.member = staff.getStaffByID(MID).get(0);
	}

	public ArrayList<PropertyOwner> getPropOwnersByID(int ownID){
		ArrayList<PropertyOwner> OList	= new ArrayList<>();
		Connection c;
		Statement stmt;
		String FName, LName, street, city, postcode, phone;
		int OID, MID;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:database.db");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully (Property Owners)");

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
					rs.close();
					stmt.close();
					c.commit();
					c.close();
					System.out.println("Closing database (Property Owner)");
					System.out.println();
					return OList;
				}
				else if(ownID == 0) {
					PropertyOwner o1 = new PropertyOwner(FName, LName, street, city, postcode, phone, OID, MID);
					OList.add(o1);
				}
			}
			rs.close();
			stmt.close();
			c.commit();
			c.close();
		}catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
		System.out.println("Closing database (Property Owners)");
		System.out.println();
		return OList;
	}

	public int compareTo(PropertyOwner p1){
		if(p1.getOwnerNum() == this.OID)	return 0;
		else if(p1.getOwnerNum() < this.OID) return 1;
		else return -1;
	}

	/**
	 * @return the ownerNum
	 */
	public int getOwnerNum() {
		return OID;
	}

	/**
	 * @param ownerNum the ownerNum to set
	 */
	public void setOwnerNum(int ownerNum) {
		this.OID = ownerNum;
	}

	public String getStreet() {
		return street;
	}
	public String getCity() {
		return city;
	}
	public String getPostCode() {
		return postCode;
	}


	public String toString(){
		return getFname() + ", " + getLname() + "; (ID: " + getOwnerNum() + ")";
	}
}