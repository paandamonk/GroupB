package pp;

import java.util.ArrayList;

public class Staff extends Person {

	private int position;
	private String gender;
	private String DOB;
	private String Branch;
	private Staff Supervisor;
	private int SupId;
	private int staffNum;
	private double salary;
	private ArrayList<Property> propList = new ArrayList<>(100);
	private ArrayList<Staff> group = new ArrayList<>(10);

	public Staff(String fname, String lname, int position) {
		super(fname, lname);
		this.position = position;
	}

	public Staff(int sID, int pos, String Fname, String Lname, String branch, String sex, String DoB, Double salary, int sup) {
		super(Fname, Lname);
		this.position = pos;
		this.Branch = branch;
		this.gender = sex;
		this.DOB = DoB;
		this.staffNum = sID;
		this.SupId = sup;
	}

	public Staff(String fname, String lname, int position, String gender, String dOB, int staffNum, double salary) {
		super(fname, lname);
		this.position = position;
		this.gender = gender;
		DOB = dOB;
		this.staffNum = staffNum;
		this.salary = salary;
	}

	public Staff(String fname, String lname, int position, String gender, String dOB, int staffNum, double salary, Staff Supervisor) {
		super(fname, lname);
		this.position = position;
		this.gender = gender;
		DOB = dOB;
		this.staffNum = staffNum;
		this.salary = salary;
		this.Supervisor = Supervisor;
	}

	public void inputData(Property p) {
		propList.add(p);
	}

	/**
	 * @return the position
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(int position) {
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
	 * @return the supervisor's ID
	 */
	public int getSupervisorID() {
		return SupId;
	}

	/**
	 * @param supervisorID the supervisorID to set
	 */
	public void setSupervisorID(int supervisorID) {
		SupId = supervisorID;
	}

	/**
	 * @return the staffNum
	 */
	public int getStaffNum() {
		return staffNum;
	}

	/**
	 * @param staffNum the staffNum to set
	 */
	public void setStaffNum(int staffNum) {
		this.staffNum = staffNum;
	}

	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}

	/**
	 * @return the propList
	 */
	public ArrayList<Property> getPropList() {
		return propList;
	}

	/**
	 * @param propList the propList to set
	 */
	public void setPropList(ArrayList<Property> propList) {
		this.propList = propList;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getFname() + " " + getLname() + "; Position: " + getPosition();
	}

	/**
	 * @return the group
	 */
	public ArrayList<Staff> getGroup() {
		return group;
	}

	/**
	 * @param group the group to set
	 */
	public void setGroup(ArrayList<Staff> group) {
		this.group = group;
	}

	public String getBranch() {
		return this.Branch;
	}
}