
public class PropRent {
	private String probNum;
	private Address address;
	private String type;
	private int numofRooms;
	private double monthlyRent;
	private PropertyOwner owner;
	/**
	 * @return the probNum
	 */
	public String getProbNum() {
		return probNum;
	}
	/**
	 * @param probNum the probNum to set
	 */
	public void setProbNum(String probNum) {
		this.probNum = probNum;
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
	 * @return the numofRooms
	 */
	public int getNumofRooms() {
		return numofRooms;
	}
	/**
	 * @param numofRooms the numofRooms to set
	 */
	public void setNumofRooms(int numofRooms) {
		this.numofRooms = numofRooms;
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
	public PropRent() {
		this("", null, "", 0, 0, null);
	}
	public PropRent(String probNum, Address address, String type, int numofRooms, double monthlyRent,
			PropertyOwner owner) {
		this.probNum = probNum;
		this.address = address;
		this.type = type;
		this.numofRooms = numofRooms;
		this.monthlyRent = monthlyRent;
		this.owner = owner;
	}
	

}
