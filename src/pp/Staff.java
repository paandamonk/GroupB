package pp;

import java.util.ArrayList;

public class Staff extends Person{

	private int position;
	private String name;
	private String gender;
	private int age;
	//private String branch;
	private Staff Supervisor;
	private String dOB;
	private Branch branch;
	private String staffNum;
	private double salary;
	private int id;
	private ArrayList<PropertyNew> propList = new ArrayList<>(100);
	private ArrayList<Staff> group = new ArrayList<>(10);
	
	public Staff(int id, String name, int age, String address, double Salary){
		super(name,name);
		this.id = id;
		this.name = name;
		this.setAge(age);
		this.salary = Salary;
	}
	public Staff(String fname, String lname, int position) {
		super(fname, lname);
		this.position = position;
	}

	public Staff(String fname, String lname, int position, Branch branch, String gender, String dOB, String staffNum, double salary) {
		super(fname, lname);
		this.position = position;
		this.gender = gender;
		this.setdOB(dOB);
		this.staffNum = staffNum;
		this.salary = salary;
	}
	
	public Staff(String fname, String lname, int position, Branch branch, String gender, String dOB, String staffNum, double salary, Staff Supervisor) {
		super(fname, lname);
		this.position = position;
		this.gender = gender;
		this.staffNum = staffNum;
		this.salary = salary;
		this.Supervisor = Supervisor;
	}
	
	public void inputData(PropertyNew p) {
		propList.add(p);
	}
	public int getID(){
		return this.id;
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
	 * @return the supervisor
	 */
	public Staff getSupervisor() {
		return Supervisor;
	}
	public Branch getBranch(){
		return branch;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param branch the branch to set
	 */
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	/**
	 * @param supervisor the supervisor to set
	 */
	public void setSupervisor(Staff supervisor) {
		Supervisor = supervisor;
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
	public ArrayList<PropertyNew> getPropList() {
		return propList;
	}
	/**
	 * @param propList the propList to set
	 */
	public void setPropList(ArrayList<PropertyNew> propList) {
		this.propList = propList;
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
	public String getName(){
		return this.name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getdOB() {
		return dOB;
	}
	public void setdOB(String dOB) {
		this.dOB = dOB;
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
