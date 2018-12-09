package pp;

import sql.*;

import static sql.Database.getStaffByID;

public class Client extends Person{
	private int clientIdNum;
	private String phone;
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
		this.member = getStaffByID(staffId).get(0);
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
