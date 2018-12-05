package pp;
import sql.Database;

public class PropertyOwner extends Client{
<<<<<<< HEAD
	private int ownerNum;
	private PropertyNew property;
	
	
	public PropertyOwner(int ownerNum, String fname, String lname, String phone, int staffId,
			PropertyNew property) {
		super(fname, lname, phone, staffId);
		this.ownerNum = ownerNum;
		this.property = property;
=======
	private String Street;
	private String City;
	private String Postcode;
	private int OID;
	private int MID;
	private Staff Member;
		
	
	public PropertyOwner(String FName, String LName, String street, String city, String postcode, String phone, int OID, int MID) {
		super(FName, LName, phone, MID);
		this.OID = OID;
		this.MID = MID;
		this.Street = street;
		this.City = city;
		this.Postcode = postcode;
>>>>>>> master
	}

	/**
	 * @return the ownerNum
	 */
	public int getOwnerNum() {
<<<<<<< HEAD
		return ownerNum;
=======
		return OID;
>>>>>>> master
	}

	/**
	 * @param ownerNum the ownerNum to set
	 */
	public void setOwnerNum(int ownerNum) {
<<<<<<< HEAD
		this.ownerNum = ownerNum;
=======
		this.OID = ownerNum;
>>>>>>> master
	}


}
