import java.util.ArrayList;

public class Staff extends Person{

	private int position;
	private String gender;
	private String DOB;
	private Staff Supervisor;
	private String staffNum;
	private ArrayList<Property> propList = new ArrayList<>(100);

	public Staff(String fname, String lname, int position, String gender, String dOB, String staffNum) {
		super(fname, lname);
		this.position = position;
		this.gender = gender;
		DOB = dOB;
		this.staffNum = staffNum;
	}
	public Staff(String fname, String lname, int position, String gender, String dOB, String staffNum, Staff Supervisor) {
		super(fname, lname);
		this.position = position;
		this.gender = gender;
		DOB = dOB;
		this.staffNum = staffNum;
		this.Supervisor = Supervisor;
	}
	
	public void inputData(Property p) {
		propList.add(p);
	}

//
//	/**
//	 * @return the staffNum
//	 */
//	public String getStaffNum() {
//		return staffNum;
//	}
//	/**
//	 * @param staffNum the staffNum to set
//	 */
//	public void setStaffNum(String staffNum) {
//		this.staffNum = staffNum;
//	}
//
//
//	/**
//	 * @return the position
//	 */
//	public int getPosition() {
//		return position;
//	}
//
//	/**
//	 * @param position the position to set
//	 */
//	public void setPosition(int position) {
//		this.position = position;
//	}
//
//	/**
//	 * @return the gender
//	 */
//	public String getGender() {
//		return gender;
//	}
//
//	/**
//	 * @param gender the gender to set
//	 */
//	public void setGender(String gender) {
//		this.gender = gender;
//	}
//
//	/**
//	 * @return the dOB
//	 */
//	public LocalDate getDOB() {
//		return DOB;
//	}
//
//	/**
//	 * @param dOB the dOB to set
//	 */
//	public void setDOB(LocalDate dOB) {
//		DOB = dOB;
//	}
//
//	/**
//	 * @return the supervisor
//	 */
//	public Staff getSupervisor() {
//		return Supervisor;
//	}
//
//	/**
//	 * @param supervisor the supervisor to set
//	 */
//	public void setSupervisor(Staff supervisor) {
//		Supervisor = supervisor;
//	}
//	/**
//	 * @return the propList
//	 */
//	public ArrayList<PropRent> getPropList() {
//		return propList;
//	}
//	/**
//	 * @param propList the propList to set
//	 */
//	public void setPropList(ArrayList<PropRent> propList) {
//		this.propList = propList;
//	}
//	
//
}
