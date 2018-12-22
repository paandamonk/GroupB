package pp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Lease extends Property{
	private int leaseId;
	private int clientId;
	private String payMethod;
	private String fname;
	private String lname;
	private double deposit;
	private int depositPaid;
	private String rentStart;
	private String rentEnd;
	private String duration;
	private Client client;

	public Lease(int leaseId, int clientId, String fname, String lname, int propertyId, String street, String city, String postCode,
				 String type, int numRooms, double monthlyRent, String payMethod, double deposit, int depositPaid, String rentStart, String rentEnd, String duration) {
		super(street, city, postCode, type, propertyId, numRooms, monthlyRent);
		this.leaseId = leaseId;
		this.clientId = clientId;
		this.fname = fname;
		this.lname = lname;
		this.payMethod = payMethod;
		this.deposit = deposit;
		this.depositPaid = depositPaid;
		this.rentStart = rentStart;
		this.rentEnd = rentEnd;
		this.duration = duration;
		this.client = client.getClientByID(clientId).get(0);
	}

	public static ArrayList<Lease> getLeaseByClientId(int clientIdInput){
		Connection c = null;
		Statement stmt = null;

		ArrayList<Lease> leaseList = new ArrayList();
		String fname, lname, street, city, postCode, type, payMethod, rentStart, rentEnd, duration;
		int leaseId, clientId, propertyId, numRooms, paidDeposit;
		double monthlyRent, deposit;

		try{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:database.db");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully (Lease)");

			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM LEASE;");
			while(rs.next()){
				leaseId = rs.getInt("LEASENUM");
				clientId = rs.getInt("CLIENTNUM");
				fname = rs.getString("FNAME");
				lname = rs.getString("LNAME");
				propertyId = rs.getInt("PROPNUM");
				street = rs.getString("STREET");
				city = rs.getString("CITY");
				postCode = rs.getString("POSTCODE");
				type = rs.getString("TYPE");
				numRooms = rs.getInt("ROOMS");
				monthlyRent = rs.getDouble("RENT");
				payMethod = rs.getString("PAYMETHOD");
				deposit = rs.getDouble("DEPOSIT");
				paidDeposit = rs.getInt("PAIDDEPOSIT");
				rentStart = rs.getString("STARTDATE");
				rentEnd = rs.getString("ENDDATE");
				duration = rs.getString("DURATION");

				if(clientId == clientIdInput) {
					Lease lease = new Lease(leaseId, clientId, fname, lname, propertyId, street, city, postCode,
							type, numRooms, monthlyRent, payMethod, deposit, paidDeposit, rentStart, rentEnd, duration);
					leaseList.add(lease);
					stmt.close();
					c.commit();
					c.close();
					return leaseList;
				}
				else if(clientIdInput == 0) {
					Lease lease = new Lease(leaseId, clientId, fname, lname, propertyId, street, city, postCode,
							type, numRooms, monthlyRent, payMethod, deposit, paidDeposit, rentStart, rentEnd, duration);
					leaseList.add(lease);
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
		//TODO Might return null if no leases are associated with given client.
		return leaseList;
	}

	public static ArrayList<Lease> getLeaseByLeaseId(int LeaseIdInput){
		Connection c = null;
		Statement stmt = null;

		ArrayList<Lease> leaseList = new ArrayList();
		String fname, lname, street, city, postCode, type, payMethod, rentStart, rentEnd, duration;
		int leaseId, clientId, propertyId, numRooms, paidDeposit;
		double monthlyRent, deposit;

		try{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:database.db");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully (Lease)");

			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM LEASE;");
			while(rs.next()){
				leaseId = rs.getInt("LEASENUM");
				clientId = rs.getInt("CLIENTNUM");
				fname = rs.getString("FNAME");
				lname = rs.getString("LNAME");
				propertyId = rs.getInt("PROPNUM");
				street = rs.getString("STREET");
				city = rs.getString("CITY");
				postCode = rs.getString("POSTCODE");
				type = rs.getString("TYPE");
				numRooms = rs.getInt("ROOMS");
				monthlyRent = rs.getDouble("RENT");
				payMethod = rs.getString("PAYMETHOD");
				deposit = rs.getDouble("DEPOSIT");
				paidDeposit = rs.getInt("PAIDDEPOSIT");
				rentStart = rs.getString("STARTDATE");
				rentEnd = rs.getString("ENDDATE");
				duration = rs.getString("DURATION");

				if(clientId == LeaseIdInput) {
					Lease lease = new Lease(leaseId, clientId, fname, lname, propertyId, street, city, postCode,
							type, numRooms, monthlyRent, payMethod, deposit, paidDeposit, rentStart, rentEnd, duration);
					leaseList.add(lease);
					stmt.close();
					c.commit();
					c.close();
					return leaseList;
				}
				else if(LeaseIdInput == 0) {
					Lease lease = new Lease(leaseId, clientId, fname, lname, propertyId, street, city, postCode,
							type, numRooms, monthlyRent, payMethod, deposit, paidDeposit, rentStart, rentEnd, duration);
					leaseList.add(lease);
				}
			}
			stmt.close();
			c.commit();
			c.close();
		}catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
		//TODO Might return null if no leases are associated with given client.
		return leaseList;
	}

	/**
	 * @return the leaseNum
	 */
	public int getLeaseId() {
		return leaseId;
	}

	/**
	 * @return the leaseNum
	 */
	public int getClientId() {
		return clientId;
	}

	/**
	 * @param leaseId the leaseNum to set
	 */
	public void setLeaseNum(int leaseId) {
		this.leaseId = leaseId;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @return the payMethod
	 */
	public String getPayMethod() {
		return payMethod;
	}

	/**
	 * @param payMethod the payMethod to set
	 */
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	/**
	 * @return the deposit
	 */
	public double getDeposit() {
		return deposit;
	}

	/**
	 * @param deposit the deposit to set
	 */
	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}

	/**
	 * @return the depositPaid
	 */
	public int isDepositPaid() {
		return depositPaid;
	}

	/**
	 * @param depositPaid the depositPaid to set
	 */
	public void setDepositPaid(int depositPaid) {
		this.depositPaid = depositPaid;
	}

	/**
	 * @return the rentStart
	 */
	public String getRentStart() {
		return rentStart;
	}

	/**
	 * @param rentStart the rentStart to set
	 */
	public void setRentStart(String rentStart) {
		this.rentStart = rentStart;
	}

	/**
	 * @return the rentEnd
	 */
	public String getRentEnd() {
		return rentEnd;
	}

	/**
	 * @param rentEnd the rentEnd to set
	 */
	public void setRentEnd(String rentEnd) {
		this.rentEnd = rentEnd;
	}

	/**
	 * @return the duration
	 */
	public String getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(String duration) {
		this.duration = duration;
	}

}
