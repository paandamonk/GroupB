package pp;

import static sql.Database.getClientByID;

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
		this.client = getClientByID(clientId).get(0);
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
