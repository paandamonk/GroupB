package pp;

public class Client extends Person{
	private String phone;
	private int member;	
	private String address;
	private int idNum;
	private float max;
	
	public Client(String fname, String lname, String phone, int member, int idNum, String address, float maxPrice) {
		super(fname, lname);
		this.phone = phone;
		this.member = member;
		this.idNum = idNum;
		this.address =  address;	
		this.max = maxPrice;		
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
