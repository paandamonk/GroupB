import java.time.LocalDate;

public class Lease {
	private String leaseNum;
	private String clientNum;
	private String clientName;
	private String propNum;
	private Address probAddr;
	private String propType;
	private int rooms;
	private double monthlyRent;
	private String paymentType;
	private double deposit;
	private boolean paid;
	private LocalDate start;
	private LocalDate end;
	private int duration;
	
	public Lease(String leaseNum, String clientNum, String clientName, String propNum, Address probAddr,
			String propType, int rooms, double monthlyRent, String paymentType, double deposit, boolean paid,
			LocalDate start, LocalDate end, int duration) {
		this.leaseNum = leaseNum;
		this.clientNum = clientNum;
		this.clientName = clientName;
		this.propNum = propNum;
		this.probAddr = probAddr;
		this.propType = propType;
		this.rooms = rooms;
		this.monthlyRent = monthlyRent;
		this.paymentType = paymentType;
		this.deposit = deposit;
		this.paid = paid;
		this.start = start;
		this.end = end;
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
	 * @return the clientNum
	 */
	public String getClientNum() {
		return clientNum;
	}

	/**
	 * @param clientNum the clientNum to set
	 */
	public void setClientNum(String clientNum) {
		this.clientNum = clientNum;
	}

	/**
	 * @return the clientName
	 */
	public String getClientName() {
		return clientName;
	}

	/**
	 * @param clientName the clientName to set
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	/**
	 * @return the propNum
	 */
	public String getPropNum() {
		return propNum;
	}

	/**
	 * @param propNum the propNum to set
	 */
	public void setPropNum(String propNum) {
		this.propNum = propNum;
	}

	/**
	 * @return the probAddr
	 */
	public Address getProbAddr() {
		return probAddr;
	}

	/**
	 * @param probAddr the probAddr to set
	 */
	public void setProbAddr(Address probAddr) {
		this.probAddr = probAddr;
	}

	/**
	 * @return the propType
	 */
	public String getPropType() {
		return propType;
	}

	/**
	 * @param propType the propType to set
	 */
	public void setPropType(String propType) {
		this.propType = propType;
	}

	/**
	 * @return the rooms
	 */
	public int getRooms() {
		return rooms;
	}

	/**
	 * @param rooms the rooms to set
	 */
	public void setRooms(int rooms) {
		this.rooms = rooms;
	}

	/**
	 * @return the monthlyRent
	 */
	public double getMonthlyRent() {
		return monthlyRent;
	}

	/**
	 * @param monthlyRent the monthlyRent to set
	 */
	public void setMonthlyRent(double monthlyRent) {
		this.monthlyRent = monthlyRent;
	}

	/**
	 * @return the paymentType
	 */
	public String getPaymentType() {
		return paymentType;
	}

	/**
	 * @param paymentType the paymentType to set
	 */
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
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
	 * @return the paid
	 */
	public boolean isPaid() {
		return paid;
	}

	/**
	 * @param paid the paid to set
	 */
	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	/**
	 * @return the start
	 */
	public LocalDate getStart() {
		return start;
	}

	/**
	 * @param start the start to set
	 */
	public void setStart(LocalDate start) {
		this.start = start;
	}

	/**
	 * @return the end
	 */
	public LocalDate getEnd() {
		return end;
	}

	/**
	 * @param end the end to set
	 */
	public void setEnd(LocalDate end) {
		this.end = end;
	}

	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}

}
