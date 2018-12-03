package pp;

public class PropertyOwner extends Client{
	private int ownerNum;
	private PropertyNew property;
	
	
	public PropertyOwner(int ownerNum, String fname, String lname, String phone, Staff member,
			PropertyNew property) {
		super(fname, lname, phone, member);
		this.ownerNum = ownerNum;
		this.property = property;
	}

	/**
	 * @return the ownerNum
	 */
	public int getOwnerNum() {
		return ownerNum;
	}

	/**
	 * @param ownerNum the ownerNum to set
	 */
	public void setOwnerNum(int ownerNum) {
		this.ownerNum = ownerNum;
	}


}
