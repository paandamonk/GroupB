package pp;

public class Client extends Person{
	private String phone;
	private Staff member;
	private String Type;
	private float MaxRent;
	private int ID;
		
	public Client(String fName, String lName, String phone, Staff Mem, int idNum, float maxRent, String type) {
		super(fName, lName);
		this.phone = phone;
		this.ID = idNum;
		this.Type = type;
		this.MaxRent = maxRent;	
		this.member = Mem; 
	}

	public void memInfo() {
		System.out.println("Staff Member:  " + member.getFname() + " " + member.getLname());
		System.out.println("Staff ID:      " + member.getStaffNum());
		System.out.println("Staff Branch:  " + member.getBranch());
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
