package pp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class BusinessOwner extends PropertyOwner{
	private String street;
	private String city;
	private String postCode;
	private String businessName;
	private String businessType;

	public BusinessOwner() {}

	private BusinessOwner(String fname, String lname, String street, String city, String postCode, String phone, int staffId, int ownerId,
						 String businessName, String businessType) {
		super(fname, lname, street, city, postCode, phone, ownerId, staffId);
		this.street = street;
		this.city = city;
		this.postCode = postCode;
		this.businessName = businessName;
		this.businessType = businessType;
	}

	public ArrayList<BusinessOwner> getBusinessOwnersByID(int ownID){
		ArrayList<BusinessOwner> BusinessOwnerList	= new ArrayList<>();
		Connection c;
		Statement stmt;
		String FName, LName, street, city, postCode, phone, businessName, businessType;
		int ownerId, staffId;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:database.db");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully (Business Owners)");

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
					BusinessOwner businessOwner = new BusinessOwner(FName, LName, street, city, postCode, phone, staffId, ownerId, businessName, businessType);
					BusinessOwnerList.add(businessOwner);
					rs.close();
					stmt.close();
					c.commit();
					c.close();
					return BusinessOwnerList;
				}
				else if(ownID == 0) {
					BusinessOwner businessOwner = new BusinessOwner(FName, LName, street, city, postCode, phone, staffId, ownerId, businessName, businessType);
					BusinessOwnerList.add(businessOwner);
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
		return BusinessOwnerList;
	}


	/**
	 * @return the businessName
	 */
	public String getBusinessName() {
		return businessName;
	}
	/**
	 * @param businessName the businessName to set
	 */
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	/**
	 * @return the businessType
	 */
	public String getBusinessType() {
		return businessType;
	}
	/**
	 * @param businessType the businessType to set
	 */
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
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

}
