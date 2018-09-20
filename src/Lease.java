
public class Lease extends Property{
	private String leaseNum;
	private Client client;
	private String payMethod;
	private double deposit;
	private boolean depositPaid;
	private String rentStart;
	private String rentEnd;
	private String duration;
	
	public Lease(String leaseNum, Client client, String payMethod, double deposit, boolean depositPaid,
			String rentStart, String rentEnd, String duration) {
		super();
		this.leaseNum = leaseNum;
		this.client = client;
		this.payMethod = payMethod;
		this.deposit = deposit;
		this.depositPaid = depositPaid;
		this.rentStart = rentStart;
		this.rentEnd = rentEnd;
		this.duration = duration;
	}

	/**
	 * @return the leaseNum
	 */
	public String getLeaseNum() {
		return leaseNum;
	}

	/**
	 * @param leaseNum the leaseNum to set
	 */
	public void setLeaseNum(String leaseNum) {
		this.leaseNum = leaseNum;
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
	public boolean isDepositPaid() {
		return depositPaid;
	}

	/**
	 * @param depositPaid the depositPaid to set
	 */
	public void setDepositPaid(boolean depositPaid) {
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
