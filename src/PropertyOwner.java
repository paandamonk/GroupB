
public class PropertyOwner extends Client{
	private String ownerNum;
	private Property property;
	
	
	public PropertyOwner(String fname, String lname, String phone, Staff member, String ownerNum,
			Property property) {
		super(fname, lname, phone, member);
		this.ownerNum = ownerNum;
		this.property = property;
	}

	/**
	 * @return the ownerNum
	 */
	public String getOwnerNum() {
		return ownerNum;
	}

	/**
	 * @param ownerNum the ownerNum to set
	 */
	public void setOwnerNum(String ownerNum) {
		this.ownerNum = ownerNum;
	}


}
