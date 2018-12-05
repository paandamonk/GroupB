package pp;

public class Property {
	private String street;
	private String city;
	private String postcode;
	private String type;
<<<<<<< HEAD
	private int propertyId;
=======
	private int propNumber;
>>>>>>> master
	private int numRooms;
	private double monthlyRent;
	private String owner;
	
	public Property() {
		super();
	}

<<<<<<< HEAD
	public Property(String street, String city, String postcode, String type, int propertyId, int numRooms, double monthlyRent) {
=======
	public Property(String street, String city, String postcode, String type, int propNumber, int numRooms,
			double monthlyRent, String owner) {
>>>>>>> master
		super();
		this.street = street;
		this.city = city;
		this.postcode = postcode;
		this.type = type;
		this.propertyId = propertyId;
		this.numRooms = numRooms;
		this.monthlyRent = monthlyRent;
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
		this.owner = owner;
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
<<<<<<< HEAD
	public int getPropertyId() {
		return propertyId;
=======
	public int getPropNumber() {
		return propNumber;
>>>>>>> master
	}

	/**
	 * @param propertyId the propertyId to set
	 */
<<<<<<< HEAD
	public void setPpropertyId(int propertyId) {
		this.propertyId = propertyId;
=======
	public void setPropNumber(int propNumber) {
		this.propNumber = propNumber;
>>>>>>> master
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
	public String getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}
	

}
