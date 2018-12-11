package pp;

import java.util.ArrayList;

public class Supervisor extends Staff {
	private ArrayList<Staff> group = new ArrayList<>(10);


	
	public Supervisor(String fname, String lname, int position, String branch, String gender, String dOB, int staffNum,
			double salary) {
		super(fname, lname, position, gender, dOB, staffNum, salary);
		this.group = group;
	}

	public void addStaff(Staff s) {
		group.add(s);
	}

	public Staff getStaff(int index) {
		Staff s = group.get(index);
		return s;
	}
	
	public void removeStaff(Staff s) {
		group.remove(s);
	}
	
	public void setStaff(ArrayList<Staff> sGroup) {
		group = sGroup;
	}
}
