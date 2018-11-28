package pp;

public class PropView {
	private Renter renter;
	private Property property;
	private String viewDate;
	private String comments;
	
	public PropView(Renter renter, Property property, String viewDate, String comments) {
		super();
		this.renter = renter;
		this.property = property;
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
	public Property getProperty() {
		return property;
	}

	/**
	 * @param property the property to set
	 */
	public void setProperty(Property property) {
		this.property = property;
	}

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
