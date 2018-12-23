package pp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Property {
	Staff staff = new Staff();
	PropertyOwner owner = new PropertyOwner();
	private String street;
	private String city;
	private String postcode;
	private String type;
	private int propertyId;
	private int numRooms;
	private int staffId;
	private double monthlyRent;
	private int POID;

	public Property() {}

	public Property(String street, String city, String postcode, String type, int propertyId, int numRooms, double monthlyRent) {
		super();
		this.street = street;
		this.city = city;
		this.postcode = postcode;
		this.type = type;
		this.propertyId = propertyId;
		this.numRooms = numRooms;
		this.monthlyRent = monthlyRent;
		owner = owner.getPropOwnersByID(propertyId).get(0);
		staff = owner.getStaff();
		this.staffId = staff.getStaffNum();
	}

	public Property(String street, String city, String postcode, String type, int propertyId, int numRooms, double monthlyRent, PropertyOwner owner) {
		super();
		this.street = street;
		this.city = city;
		this.postcode = postcode;
		this.type = type;
		this.propertyId = propertyId;
		this.numRooms = numRooms;
		this.monthlyRent = monthlyRent;
		owner = owner.getPropOwnersByID(propertyId).get(0);
	}

	public ArrayList<Property> getPropertyByID() {
		Connection c = null;
		Statement stmt = null;
		ArrayList<Property> propertiesList = new ArrayList<Property>();

		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:database.db");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully (Properties)");

			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM PROPERTIES;");

			while (rs.next()) {
				int propNum = rs.getInt("PROPNUM");
				String street = rs.getString("STREET");
				String city = rs.getString("CITY");
				String postcode = rs.getString("POSTCODE");
				String type = rs.getString("TYPE");
				int rooms = rs.getInt("ROOMS");
				double rent = rs.getDouble("RENT");
				int Owner = rs.getInt("OWNER");
				//if (Num == propNum) {
					Property prp = new Property(street, city, postcode, type, propNum, rooms, rent, owner.getPropOwnersByID(propertyId).get(0));
					propertiesList.add(prp);
				//}
				//else if (propNum == 0) {
					//Property prp = new Property(street, city, postcode, type, propNum, rooms, rent, owner.getPropOwnersByID(propertyId).get(Owner));
					//propertiesList.add(prp);
			//}
				}
			rs.close();
			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return propertiesList;
	}
	
	public ArrayList<Property> getPropertyByID(int Num) {
		Connection c = null;
		Statement stmt = null;
		ArrayList<Property> propertiesList = new ArrayList<Property>();

		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:database.db");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully (Properties)");

			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM PROPERTIES;");

			while (rs.next()) {
				int propNum = rs.getInt("PROPNUM");
				String street = rs.getString("STREET");
				String city = rs.getString("CITY");
				String postcode = rs.getString("POSTCODE");
				String type = rs.getString("TYPE");
				int rooms = rs.getInt("ROOMS");
				double rent = rs.getDouble("RENT");
				int Owner = rs.getInt("OWNER");
				if (Num == propNum) {
					Property prp = new Property(street, city, postcode, type, propNum, rooms, rent, owner.getPropOwnersByID(propertyId).get(Owner));
					propertiesList.add(prp);
				}
				else if (propNum == 0) {
					Property prp = new Property(street, city, postcode, type, propNum, rooms, rent, owner.getPropOwnersByID(propertyId).get(Owner));
					propertiesList.add(prp);
			}
				}
			rs.close();
			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return propertiesList;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}
	
	public Staff getStaff(){
		return staff;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the postcode
	 */
	public String getPostcode() {
		return postcode;
	}

	/**
	 * @param postcode the postcode to set
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the propNumber
	 */
	public int getPropertyId() {
		return propertyId;
	}

	/**
	 * @param propertyId the propertyId to set
	 */
	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}

	/**
	 * @return the numRooms
	 */
	public int getNumRooms() {
		return numRooms;
	}

	/**
	 * @param numRooms the numRooms to set
	 */
	public void setNumRooms(int numRooms) {
		this.numRooms = numRooms;
	}

	/**
	 * @return the monthlyRent
	 */
	public double getMonthlyRent() {
		return monthlyRent;
	}

	/**
	 * @param monthlyRent the monthlyRent to set
	 */
	public void setMonthlyRent(double monthlyRent) {
		this.monthlyRent = monthlyRent;
	}

	/**
	 * @return the owner
	 */
	public PropertyOwner getOwner() {
		return owner;
	}
	
	public int getOID(){
		return this.POID;
	}

	/**
	 * @param ownerId the owner to set
	 */
	public void setOwner(int ownerId) {
		this.owner = owner.getPropOwnersByID(ownerId).get(0);
	}
	
	public String toString(){
		return "address: " + getStreet() + " " + getCity() + " " + getPostcode() + " id: " + getPropertyId();
	}


}
