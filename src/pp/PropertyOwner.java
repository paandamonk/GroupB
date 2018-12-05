package pp;
import sql.Database;

public class PropertyOwner extends Client{
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
	}

	/**
	 * @return the ownerNum
	 */
	public int getOwnerNum() {
		return OID;
	}

	/**
	 * @param ownerNum the ownerNum to set
	 */
	public void setOwnerNum(int ownerNum) {
		this.OID = ownerNum;
	}


}
