package pp;

import java.util.ArrayList;

public class Branch {
	private String location;
	private ArrayList<Staff> staff = new ArrayList<>();
	private int totalstaff;
	private Staff manager;
	
	
	public Branch(String location, ArrayList<Staff> staff, int totalstaff, Staff manager) {
		super();
		this.location = location;
		this.staff = staff;
		this.totalstaff = totalstaff;
		this.manager = manager;
	}

	public int totalProp(String type) {
		int count = 0;
		for (int i = 0; i < staff.size(); i++) {
			if (staff.get(i).getPosition() == 0) {
				for (int n = 0; n < staff.get(i).getPropList().size(); n++) {
					if (staff.get(i).getPropList().get(n).getType() == type) {
						count++;
					}
				}
			}
		}
		return count;
	}
	
	public void perOwner(String ownerNum) {
		for (int i = 0; i < staff.size(); i++) {
			if (staff.get(i).getPosition() == 0) {
				for (int n = 0; n < staff.get(i).getPropList().size(); n++) {
					if (staff.get(i).getPropList().get(n).getOwner().getOwnerNum() == ownerNum) {
						System.out.println(staff.get(i).getPropList().get(n));
					}
				}
			}
		}
		
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}


	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}


	/**
	 * @return the staff
	 */
	public ArrayList<Staff> getStaff() {
		return staff;
	}


	/**
	 * @param staff the staff to set
	 */
	public void setStaff(ArrayList<Staff> staff) {
		this.staff = staff;
	}


	/**
	 * @return the totalstaff
	 */
	public int getTotalstaff() {
		return totalstaff;
	}


	/**
	 * @param totalstaff the totalstaff to set
	 */
	public void setTotalstaff(int totalstaff) {
		this.totalstaff = totalstaff;
	}


	/**
	 * @return the manager
	 */
	public Staff getManager() {
		return manager;
	}


	/**
	 * @param manager the manager to set
	 */
	public void setManager(Staff manager) {
		this.manager = manager;
	}

	

}
