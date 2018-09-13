import java.util.ArrayList;

public class Staff {
	private String name;
	private String position;
	private String gender;
	private String DOB;
	private Staff Supervisor;
	private String staffNum;
	private ArrayList<PropRent> propList = new ArrayList<>(100);

	public Staff(String staffNum, String name, String position, String gender, String DOB) {
		this.staffNum = staffNum;
		this.name = name;
		this.position = position;
		this.gender = gender;
		this.DOB = DOB;
	}
	public Staff(String staffNum, String name, String position, String gender, String DOB, Staff Supervisor) {
		this.staffNum = staffNum;
		this.name = name;
		this.position = position;
		this.gender = gender;
		this.DOB = DOB;
		this.Supervisor = Supervisor;
	}

	/**
	 * @return the staffNum
	 */
	public String getStaffNum() {
		return staffNum;
	}
	/**
	 * @param staffNum the staffNum to set
	 */
	public void setStaffNum(String staffNum) {
		this.staffNum = staffNum;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the dOB
	 */
	public String getDOB() {
		return DOB;
	}

	/**
	 * @param dOB the dOB to set
	 */
	public void setDOB(String dOB) {
		DOB = dOB;
	}

	/**
	 * @return the supervisor
	 */
	public Staff getSupervisor() {
		return Supervisor;
	}

	/**
	 * @param supervisor the supervisor to set
	 */
	public void setSupervisor(Staff supervisor) {
		Supervisor = supervisor;
	}
	/**
	 * @return the propList
	 */
	public ArrayList<PropRent> getPropList() {
		return propList;
	}
	/**
	 * @param propList the propList to set
	 */
	public void setPropList(ArrayList<PropRent> propList) {
		this.propList = propList;
	}

}
