package pp;

public class Renter extends Client{
	private String renterNum;
	private Property property;
	
	public Renter(String fname, String lname, String phone, Staff member, String renterNum, Property property) {
		super(fname, lname, phone, member);
		this.renterNum = renterNum;
		this.property = property;
	}

	/**
	 * @return the renterNum
	 */
	public String getRenterNum() {
		return renterNum;
	}

	/**
	 * @param renterNum the renterNum to set
	 */
	public void setRenterNum(String renterNum) {
		this.renterNum = renterNum;
	}

	/**
	 * @return the property
	 */
	public Property getProperty() {
		return property;
	}

	/**
	 * @param property the property to set
	 */
	public void setProperty(Property property) {
		this.property = property;
	}
	

}
