package pp;

import static sql.Database.getPropOwnersByID;
import static sql.Database.getStaffByID;

public class Property {
	private String street;
	private String city;
	private String postcode;
	private String type;
	private int propertyId;
	private int numRooms;
	private int staffId;
	private Staff staffMember;
	private double monthlyRent;
	private PropertyOwner owner;
	
	public Property() {
		super();
	}

	public Property(String street, String city, String postcode, String type, int propertyId, int numRooms, double monthlyRent) {
		super();
		this.street = street;
		this.city = city;
		this.postcode = postcode;
		this.type = type;
		this.propertyId = propertyId;
		this.numRooms = numRooms;
		this.monthlyRent = monthlyRent;
		this.owner = getPropOwnersByID(propertyId).get(0);
		this.staffMember = owner.getStaff();
		this.staffId = staffMember.getStaffNum();
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
		this.owner = getPropOwnersByID(propertyId).get(0);
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
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
	public void setPpropertyId(int propertyId) {
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

	/**
	 * @param ownerId the owner to set
	 */
	public void setOwner(int ownerId) {
		this.owner = getPropOwnersByID(ownerId).get(0);
	}
	

}
