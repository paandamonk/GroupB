package pp;

public class Renter extends Client{
	private int renterNum;
	private Property property;
	
	public Renter(int renterNum, String fname, String lname, String phone, int staffId, Property property) {
		super(fname, lname, phone, staffId);
		this.renterNum = renterNum;
		this.property = property;
	}

	/**
	 * @return the renterNum
	 */
	public int getRenterNum() {
		return renterNum;
	}

	/**
	 * @param renterNum the renterNum to set
	 */
	public void setRenterNum(int renterNum) {
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
