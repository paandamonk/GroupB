package pp;

import java.util.ArrayList;

public class Supervisor extends Staff {
	
	
	

	private ArrayList<Staff> group = new ArrayList<>(10);

	public Supervisor(int sID, int pos, String Fname, String Lname, String branch, String sex, String DoB,
			String salary, String Username, String Password, int sup) {
		super(sID, pos, Fname, Lname, branch, sex, DoB, salary, Username, Password, sup);
		
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
