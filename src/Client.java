
public class Client {
	private String clientNum;
	private String name;
	private String phone;
	private Staff member;
	private PropRent prop = new PropRent();
	
	public Client(String clientNum, String name, String phone) {
		this.clientNum = clientNum;
		this.name = name;
		this.phone = phone;
	}

	/**
	 * @return the clientNum
	 */
	public String getClientNum() {
		return clientNum;
	}

	/**
	 * @param clientNum the clientNum to set
	 */
	public void setClientNum(String clientNum) {
		this.clientNum = clientNum;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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

	/**
	 * @return the member
	 */
	public Staff getMember() {
		return member;
	}

	/**
	 * @param member the member to set
	 */
	public void setMember(Staff member) {
		this.member = member;
	}

	/**
	 * @return the prop
	 */
	public PropRent getProp() {
		return prop;
	}

	/**
	 * @param prop the prop to set
	 */
	public void setProp(PropRent prop) {
		this.prop = prop;
	}
	
	

}
