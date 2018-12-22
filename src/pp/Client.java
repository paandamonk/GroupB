package pp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Client extends Person{
	Staff staff = new Staff();
	private int clientIdNum;
	private String phone;
	private int staffId;
	private Staff member;
	private String street, city, postCode, type;
	private int idNum;
	private double max;

	public Client() {}
	
	public Client(int clientIdNum, String fname, String lname, String type, String phone,
				  int staffId, String street, String city, String postCode, double maxRent) {
		super(fname, lname);
		this.type = type;
		this.clientIdNum = clientIdNum;
		this.phone = phone;
		this.staffId = staffId;
		this.member = staff.getStaffByID(staffId).get(0);
		this.street = street;
		this.city = city;
		this.postCode = postCode;
		this.max = maxRent;		
	}
	public Client(String fname, String lname, String phone, int staffId) {
		super(fname, lname);
		this.phone = phone;
		this.staffId = staffId;
		this.member = staff.getStaffByID(staffId).get(0);
	}

	public ArrayList<Client> getClientByID(int cID){
		Connection c = null;
		Statement stmt = null;

		ArrayList<Client> clientList = new ArrayList();
		String fName, lName, type, phone, street, city, postCode;
		int idNum, staffNum;
		float maxRent;

		try{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:database.db");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully (Clients)");

			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM CLIENTS;");
			while(rs.next()){
				idNum = rs.getInt("CLIENTID");
				fName = rs.getString("FNAME");
				lName = rs.getString("LNAME");
				type = rs.getString("TYPE");
				phone = rs.getString("PHONE");
				staffNum = rs.getInt("STAFFNUM");
				street = rs.getString("STREET");
				city = rs.getString("CITY");
				postCode = rs.getString("POSTCODE");
				maxRent = rs.getFloat("MAXRENT");

				if(cID == idNum) {
					Client client = new Client(idNum, fName, lName, type, phone, staffNum, street, city, postCode, maxRent);
					clientList.add(client);
					return clientList;
				}
				else if(cID == 0) {
					Client client = new Client(idNum, fName, lName, type, phone, staffNum, street, city, postCode, maxRent);
					clientList.add(client);
				}
			}
			rs.close();
			stmt.close();
			c.commit();
			c.close();
		}catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
		return clientList;
	}

	/**
	 * @return the clientIdNum
	 */
	public int getClientIdNum() {
		return clientIdNum;
	}
	/**
	 * @param clientIdNum the clientIdNum to set
	 */
	public void setClientIdNum(int clientIdNum) {
		this.clientIdNum = clientIdNum;
	}
	/**
	 * @return the staffId
	 */
	public int getStaffId() {
		return staffId;
	}
	/**
	 * @param staffId the staffId to set
	 */
	public void setStaffId(int staffId) {
		this.staffId = staffId;
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
	 * @return the idNum
	 */
	public int getIdNum() {
		return idNum;
	}
	/**
	 * @param idNum the idNum to set
	 */
	public void setIdNum(int idNum) {
		this.idNum = idNum;
	}
	/**
	 * @return the max
	 */
	public double getMax() {
		return max;
	}
	/**
	 * @param max the max to set
	 */
	public void setMax(double max) {
		this.max = max;
	}
	/**
	 * @return the member
	 */
	public Staff getMember() {
		return member;
	}
	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @param postCode the postCode to set
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getFname() + " " + getLname() + ", id = " + getClientIdNum();
	}



}
