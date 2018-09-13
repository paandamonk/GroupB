
public class BusinessOwner extends PropertyOwner{
	private String businessName;
	private String businessType;
	private String contact;
	public BusinessOwner(String ownerNum, Address address, String phone, String businessName, String businessType, String contact) {
		super(ownerNum, address, phone);
		this.businessName = businessName;
		this.businessType = businessType;
		this.contact = contact;
		// TODO Auto-generated constructor stub
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
	/**
	 * @return the contact
	 */
	public String getContact() {
		return contact;
	}
	/**
	 * @param contact the contact to set
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}
	

}
