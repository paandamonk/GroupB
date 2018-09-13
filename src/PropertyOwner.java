
public class PropertyOwner {
	private String ownerNum;
	private Address address;
	private String phone;
	
	public PropertyOwner(String ownerNum, Address address, String phone) {
		this.ownerNum = ownerNum;
		this.address = address;
		this.phone = phone;
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

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
