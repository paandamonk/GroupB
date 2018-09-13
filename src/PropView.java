import java.time.LocalDate;

public class PropView {
	private String clientNum;
	private String clientName;
	private String clientPhone;
	private String propNum;
	private Address propAddr;
	private LocalDate viewdate;
	private String comments;
	
	public PropView(String clientNum, String clientName, String clientPhone, String propNum, Address propAddr,
			LocalDate viewdate, String comments) {
		this.clientNum = clientNum;
		this.clientName = clientName;
		this.clientPhone = clientPhone;
		this.propNum = propNum;
		this.propAddr = propAddr;
		this.viewdate = viewdate;
		this.comments = comments;
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
	 * @return the clientPhone
	 */
	public String getClientPhone() {
		return clientPhone;
	}

	/**
	 * @param clientPhone the clientPhone to set
	 */
	public void setClientPhone(String clientPhone) {
		this.clientPhone = clientPhone;
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
	 * @return the propAddr
	 */
	public Address getPropAddr() {
		return propAddr;
	}

	/**
	 * @param propAddr the propAddr to set
	 */
	public void setPropAddr(Address propAddr) {
		this.propAddr = propAddr;
	}

	/**
	 * @return the viewdate
	 */
	public LocalDate getViewdate() {
		return viewdate;
	}

	/**
	 * @param viewdate the viewdate to set
	 */
	public void setViewdate(LocalDate viewdate) {
		this.viewdate = viewdate;
	}

	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
	

}
