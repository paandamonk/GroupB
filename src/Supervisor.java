import java.util.ArrayList;

public class Supervisor extends Staff {
	private ArrayList<Staff> group = new ArrayList<>(10);
	

	

	public Supervisor(String fname, String lname, int position, String gender, String dOB, String staffNum) {
		super(fname, lname, position, gender, dOB, staffNum);
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
