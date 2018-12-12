package pp;

import sql.*;

import static sql.Database.getStaffByID;

public class Client extends Person{
	private int clientIdNum;
	private String phone;
	private int staffId;
	private Staff member;
	private String street, city, postCode, type;
	private int idNum;
	private float max;
	
	public Client(int clientIdNum, String fname, String lname, String type, String phone,
				  int staffId, String street, String city, String postCode, float maxPrice) {
		super(fname, lname);
		this.type = type;
		this.clientIdNum = clientIdNum;
		this.phone = phone;
		this.staffId = staffId;
		this.member = getStaffByID(staffId).get(0);
		this.street = street;
		this.city = city;
		this.postCode = postCode;
		this.max = maxPrice;		
	}
	public Client(String fname, String lname, String phone, int staffId) {
		super(fname, lname);
		this.phone = phone;
		this.staffId = staffId;
		this.member = getStaffByID(staffId).get(0);
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @return the city
	 */
	public String getPostCode() {
		return postCode;
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
	public Staff getStaff() {
		return member;
	}

	/**
	 * @param member the member to set
	 */
	public void setMember(Staff member) {
		this.member = member;
	}



}
