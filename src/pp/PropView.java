package pp;
import static sql.Database.getClientByID;

public class PropView {
	private Renter renter;
	private Client client;
	private int clientId, propertyId;
	private String fname, lname, phone, street, city, postCode, date, viewDate, comments;
	
	public PropView(int clientId, String fname, String lname, String phone, int propertyId, String street, String city, String postCode, String viewDate, String comments) {
		this.client = getClientByID(clientId).get(0);
		this.clientId = clientId;
		this.propertyId = propertyId;
		this.fname = client.getFname();
		this.lname = client.getLname();
		this.phone = client.getPhone();
		this.street = client.getStreet();
		this.city = client.getCity();
		this.postCode = client.getPostCode();
		this.viewDate = viewDate;
		this.comments = comments;
	}

	/**
	 * @return the renter
	 */
	public Renter getRenter() {
		return renter;
	}

	/**
	 * @param renter the renter to set
	 */
	public void setRenter(Renter renter) {
		this.renter = renter;
	}

	/**
	 * @return the property
	 */
	/*public Property getProperty() {
		return property;
	}*/

	/**
	 * @param property the property to set
	 */
	/*public void setProperty(Property property) {
		this.property = property;
	}*/

	/**
	 * @return the viewDate
	 */
	public String getViewDate() {
		return viewDate;
	}

	/**
	 * @param viewDate the viewDate to set
	 */
	public void setViewDate(String viewDate) {
		this.viewDate = viewDate;
	}

	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}


}
