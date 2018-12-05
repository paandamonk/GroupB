package pp;

public class Client extends Person{
	private int clientIdNum;
	private String phone;
<<<<<<< HEAD
	private int staffId;
	private Staff member;
	private String street, city, postCode;
	private int idNum;
	private double max;
	
	public Client(int clientIdNum,String fname, String lname, String phone, int staffId, int idNum, String street, String city, String postCode, double maxPrice) {
		super(fname, lname);
		this.clientIdNum = clientIdNum;
		this.phone = phone;
		this.staffId = staffId;
		this.idNum = idNum;
		this.street = street;
		this.city = city;
		this.postCode = postCode;
		this.max = maxPrice;		
	}
	public Client(String fname, String lname, String phone, int staffId) {
		super(fname, lname);
		this.phone = phone;
		this.staffId = staffId;
	}

=======
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
	
>>>>>>> master
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
