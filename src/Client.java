
public class Client extends Person{
	private String phone;
	private Staff member;	
	
	public Client(String fname, String lname, String phone, Staff member) {
		super(fname, lname);
		this.phone = phone;
		this.member = member;
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



}
