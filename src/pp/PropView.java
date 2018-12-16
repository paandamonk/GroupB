package pp;
import java.sql.*;
import java.util.ArrayList;
import static sql.Database.getClientByID;

public class PropView {
	private Renter renter;
	private Client client;
	private int clientId, propertyId;
	private String fname, lname, phone, street, city, postCode, date, viewDate, comments;
	
	public PropView(int clientId, String fname, String lname, String phone, int propertyId, String street, String city, String postCode, String viewDate, String comments) {
		this.client = getClientByID(clientId).get(0);
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
	}
	
	public static ArrayList<PropView> getPropView(){
        Connection c = null;
        Statement stmt = null;

        ArrayList<PropView> propViewList = new ArrayList();
        int clientId, propertyId;
        String fname, lname, phone, street, city, postCode, viewDate, comments;

        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM PROPVIEW;");
            while(rs.next()){
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

                PropView propView = new PropView(clientId, fname, lname, phone, propertyId, street, city, postCode, viewDate, comments);
                propViewList.add(propView);
            }
        }catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return propViewList;
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


}
