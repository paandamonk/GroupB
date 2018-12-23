package pp;
import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class PropView {
	private Renter renter;
	private Client client = new Client();
	private int clientId, propertyId, viewnum;
	private String fname, lname, phone, street, city, postCode, date, viewDate, comments;
	private Staff staffMem;

	public PropView() {}
	
	public PropView(int viewnum, int clientId, String fname, String lname, String phone, int propertyId, String street, String city, String postCode, String viewDate, String comments) {
		this.client = client.getClientByID(clientId).get(0);
		this.viewnum = viewnum;
		this.clientId = clientId;
		this.propertyId = propertyId;
		this.fname = client.getFname();
		this.lname = client.getLname();
		this.phone = client.getPhone();
		this.street = client.getStreet();
		this.city = client.getCity();
		this.postCode = client.getPostCode();
		this.viewDate = viewDate;
		this.comments = comments;
		this.staffMem = client.getMember();
	}

	public ArrayList<PropView> getPropViewByID(int PVid){
		Connection c = null;
		Statement stmt = null;

		ArrayList<PropView> propViewList = new ArrayList();
		int viewnum, clientId, propertyId;
		String fname, lname, phone, street, city, postCode, viewDate, comments;

		try{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:database.db");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully (PropView)");

			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM PROPVIEW;");
			while(rs.next()){
				viewnum = rs.getInt("VIEWNUM");
				clientId = rs.getInt("CLIENTNUM");
				fname = rs.getString("FNAME");
				lname = rs.getString("LNAME");
				phone = rs.getString("CELL");
				propertyId = rs.getInt("PROPNUM");
				street = rs.getString("STREET");
				city = rs.getString("CITY");
				postCode = rs.getString("POSTCODE");
				viewDate = rs.getString("VIEWDATE");
				comments = rs.getString("COMMENTS");

				PropView propView = new PropView(viewnum, clientId, fname, lname, phone, propertyId, street, city, postCode, viewDate, comments);

				if(viewnum == PVid) {
					propViewList.add(propView);
					rs.close();
					stmt.close();
					c.commit();
					c.close();
					return propViewList;
				}
				else if(PVid == 0) {
					propViewList.add(propView);
				}
			}
			rs.close();
			stmt.close();
			c.commit();
			c.close();
		}catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
		return propViewList;
	}

	public Staff getMember(){
		return staffMem;
	}

	public int getCID(){
		return clientId;
	}

	public int getPID(){
		return propertyId;
	}

	public int getViewNum() {
		return viewnum;
	}

	/**
	 * @return the renter
	 */
	public Renter getRenter() {
		return renter;
	}

	/**
	 * @param renter the renter to set
	 */
	public void setRenter(Renter renter) {
		this.renter = renter;
	}

	/**
	 * @return the property
	 */
	/*public Property getProperty() {
		return property;
	}*/

	/**
	 * @param property the property to set
	 */
	/*public void setProperty(Property property) {
		this.property = property;
	}*/

	/**
	 * @return the viewDate
	 */
	public String getViewDate() {
		return viewDate;
	}

	/**
	 * @param viewDate the viewDate to set
	 */
	public void setViewDate(String viewDate) {
		this.viewDate = viewDate;
	}

	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getFname(){ return fname;}

	public String getLname(){ return lname;}

	public String getPhone(){ return phone;}

	public int getPropertyId(){ return propertyId;}

	public String getStreet(){ return street;}

	public String getCity(){ return city;}

	public String getPostCode(){ return postCode;}

	public int getClientId(){ return clientId;}

	public String toString(){

		return getFname() + " " + getLname() + " (VIEW ID: " + getViewNum() + ")";
	}
}
