
public class BusinessOwner extends PropertyOwner{
	private String businessName;
	private String businessType;

	
	public BusinessOwner(String fname, String lname, String phone, Staff member, String ownerNum,
			Property property, String businessName, String businessType) {
		super(fname, lname, phone, member, ownerNum, property);
		this.businessName = businessName;
		this.businessType = businessType;
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

	

}
