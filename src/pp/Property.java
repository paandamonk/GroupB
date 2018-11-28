package pp;

public class Property {
	private String street;
	private String city;
	private String postcode;
	private String type;
	private String propNumber;
	private int numRooms;
	private double monthlyRent;
	private PropertyOwner owner;
	
	public Property() {
		super();
	}

	public Property(String street, String city, String postcode, String type, String propNumber, int numRooms,
			double monthlyRent, PropertyOwner owner) {
		super();
		this.street = street;
		this.city = city;
		this.postcode = postcode;
		this.type = type;
		this.propNumber = propNumber;
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
	public String getPropNumber() {
		return propNumber;
	}

	/**
	 * @param propNumber the propNumber to set
	 */
	public void setPropNumber(String propNumber) {
		this.propNumber = propNumber;
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
	 * @param owner the owner to set
	 */
	public void setOwner(PropertyOwner owner) {
		this.owner = owner;
	}
	

}
