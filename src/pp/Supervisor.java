package pp;

import java.util.ArrayList;

public class Supervisor extends Staff {
	private ArrayList<Staff> group = new ArrayList<>(10);


	
	public Supervisor(String fname, String lname, int position, Branch branch, String gender, String dOB, String staffNum,
			double salary, ArrayList<Staff> group) {
		super(fname, lname, position, branch, gender, dOB, staffNum, salary);
		this.group = group;
	}


	public void addStaff(Staff s) {
		group.add(s);
	}
	
	public void remStaff(Staff s) {
		group.remove(s);
	}
	
	public void setStaff(ArrayList<Staff> sGroup) {
		group = sGroup;
	}
	
	
	
//	/**
//	 * @return the group
//	 */
//	public Staff[] getGroup() {
//		return group;
//	}
//
//	/**
//	 * @param group the group to set
//	 */
//	public void setGroup(Staff[] group) {
//		this.group = group;
//	}
//	/**
//	 * Sets individual members of the group.
//	 * @param n
//	 * @param member
//	 * @param group
//	 */
//	public void setIndvGroup(int n, Staff member, Staff[] group) {
//		group[n] = member;
//	}
//	public void replaceGroup(Staff in, Staff out, Staff[] group) {
//		for(int i=0; i<group.length; i++) {
//			if (group[i] == out) {
//				group[i] = in;
//			}
//		}
//	}
//	
//	
//
//	
	

}
