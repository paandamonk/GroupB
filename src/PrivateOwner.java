
public class PrivateOwner extends PropertyOwner{
	private String name;
	
	public PrivateOwner(String ownerNum, Address address, String phone, String name) {
		super(ownerNum, address, phone);
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
