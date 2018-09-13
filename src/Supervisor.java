
public class Supervisor extends Staff {
	private Staff[] group;
	

	public Supervisor(String staffNum, String name, String position, String gender, String DOB, Staff[] group) {
		super(staffNum, name, position, gender, DOB);
		this.group = group;
	}

	/**
	 * @return the group
	 */
	public Staff[] getGroup() {
		return group;
	}

	/**
	 * @param group the group to set
	 */
	public void setGroup(Staff[] group) {
		this.group = group;
	}
	/**
	 * Sets individual members of the group.
	 * @param n
	 * @param member
	 * @param group
	 */
	public void setIndvGroup(int n, Staff member, Staff[] group) {
		group[n] = member;
	}
	public void replaceGroup(Staff in, Staff out, Staff[] group) {
		for(int i=0; i<group.length; i++) {
			if (group[i] == out) {
				group[i] = in;
			}
		}
	}
	

}
