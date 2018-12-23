package pp;

import java.awt.BorderLayout;
import pp.Client;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Info {
	 JFrame frame;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Object type = new Staff(0, 0, "", null, null, null, null, null, null, null, 0);
//					
//					Info window = new Info(type);
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public Info(Object o) {
		initialize(o);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Object o) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		if(o.getClass() == Staff.class) {
			JPanel north = new JPanel();
			JPanel center = new JPanel();
			JPanel west = new JPanel();
			JPanel south = new JPanel();
			JPanel east = new JPanel();
			
			frame.add(north, BorderLayout.NORTH);
			frame.add(center, BorderLayout.CENTER);
			frame.add(west, BorderLayout.WEST);
			frame.add(south, BorderLayout.SOUTH);
			frame.add(east, BorderLayout.EAST);

			Staff staff = (Staff) o;
			JLabel name_1 = new JLabel("Name: ");
			JLabel name_2 = new JLabel(staff.getFname() + " " + staff.getLname());
			JLabel id_1 = new JLabel("Id number: ");
			JLabel id_2 = new JLabel(Integer.toString(staff.getStaffNum()));
			north.setLayout(new GridLayout(1, 4));
			north.setBorder(BorderFactory.createLineBorder(Color.black));
			north.add(name_1);
			north.add(name_2);
			north.add(id_1);
			north.add(id_2);
			
			JLabel pos_1 = new JLabel("Position: ");
			JLabel pos_2 = new JLabel(Integer.toString(staff.getPosition()));
			JLabel gender_1 = new JLabel("Gender: ");
			JLabel gender_2 = new JLabel(staff.getGender());
			JLabel dob_1 = new JLabel("Date of birth: ");
			JLabel dob_2 = new JLabel(staff.getDOB());
			JLabel salary_1 = new JLabel("Salary: ");
			JLabel salary_2 = new JLabel(Double.toString(staff.getSalary()));
			west.setLayout(new GridLayout(4, 2));
			west.setBorder(BorderFactory.createLineBorder(Color.black));
			west.add(pos_1);
			west.add(pos_2);
			west.add(gender_1);
			west.add(gender_2);
			west.add(dob_1);
			west.add(dob_2);
			west.add(salary_1);
			west.add(salary_2);
			
			JLabel branch_1 = new JLabel("Branch: ");
			JLabel branch_2 = new JLabel(staff.getBranch());
			south.setLayout(new GridLayout(1,1));
			south.setBorder(BorderFactory.createLineBorder(Color.black));
			south.add(branch_1);
			south.add(branch_2);
			
			JLabel props = new JLabel("Properties: ");
			DefaultListModel propList = new DefaultListModel();
			for(int i = 0; i < staff.getPropList().size(); i++) {
				propList.addElement(staff.getPropList().get(i));
			}
			JList list_1 = new JList(propList);
			JScrollPane scroll_1 = new JScrollPane(list_1);
			center.setLayout(new GridLayout(2,1));
			center.setBorder(BorderFactory.createLineBorder(Color.black));
			center.add(props);
			center.add(scroll_1);
			
			if((staff.getPosition() == 2) || (staff.getPosition() == 1)) {
				JLabel staffs = new JLabel("Staff: ");
				DefaultListModel staffList = new DefaultListModel();
				for(int i = 0; i < staff.getGroup().size(); i++) {
					staffList.addElement(staff.getGroup().get(i));
					System.out.println(staff.getGroup().get(i));
				}
				JList list_2 = new JList(staffList);
				JScrollPane scroll_2 = new JScrollPane(list_2);
				center.setLayout(new GridLayout(2, 2));
				center.removeAll();
				center.add(props);
				center.add(staffs);
				center.add(scroll_1);
				center.add(scroll_2);
			}
			if(staff.getPosition() == 0) {
				JLabel supervisor = new JLabel("Supervisor: ");
				JLabel supervisor_2 = new JLabel(staff.getStaffByID(staff.getStaffNum()).get(0).getFname() + 
						" " + staff.getStaffByID(staff.getStaffNum()).get(0).getLname());
				east.setLayout(new GridLayout(1,2));
				east.setBorder(BorderFactory.createLineBorder(Color.black));
				east.add(supervisor);
				east.add(supervisor_2);
			}
			
			
		}
		if(o.getClass() == Client.class) {
			JPanel north = new JPanel();
			JPanel center = new JPanel();
			JPanel west = new JPanel();
			JPanel south = new JPanel();
			JPanel east = new JPanel();
			
			frame.add(north, BorderLayout.NORTH);
			frame.add(center, BorderLayout.CENTER);
			frame.add(west, BorderLayout.WEST);
			frame.add(south, BorderLayout.SOUTH);
			frame.add(east, BorderLayout.EAST);

			Client client = (Client) o;
			JLabel name_1 = new JLabel("Name: ");
			JLabel name_2 = new JLabel(client.getFname() + " " + client.getLname());
			JLabel id_1 = new JLabel("Id number: ");
			JLabel id_2 = new JLabel(Integer.toString(client.getIdNum()));
			north.setLayout(new GridLayout(1, 4));
			north.setBorder(BorderFactory.createLineBorder(Color.black));
			north.add(name_1);
			north.add(name_2);
			north.add(id_1);
			north.add(id_2);
			
			JLabel phone = new JLabel("Phone Number: ");
			JLabel phone_2 = new JLabel(client.getPhone());
			JLabel staff_1 = new JLabel("Staff Member: ");
			JLabel staff_2 = new JLabel(client.getStaff().toString());
			JLabel add = new JLabel("Address: ");
			JLabel add_1 = new JLabel(client.getStreet() + " " + client.getCity() + " " + client.getPostCode());
			JLabel Max = new JLabel("Max Rent: ");
			JLabel Max_2 = new JLabel(Double.toString(client.getMax()));
			
			west.setLayout(new GridLayout(4, 2));
			west.setBorder(BorderFactory.createLineBorder(Color.black));
			west.add(phone);
			west.add(phone_2);
			west.add(staff_1);
			west.add(staff_2);
			west.add(add);
			west.add(add_1);
			west.add(Max);
			west.add(Max_2);
		}
		if(o.getClass() == Property.class) {
			JPanel north = new JPanel();
			JPanel center = new JPanel();
			JPanel west = new JPanel();
			JPanel south = new JPanel();
			JPanel east = new JPanel();
			
			frame.add(north, BorderLayout.NORTH);
			frame.add(center, BorderLayout.CENTER);
			frame.add(west, BorderLayout.WEST);
			frame.add(south, BorderLayout.SOUTH);
			frame.add(east, BorderLayout.EAST);

			Property prop = (Property) o;
			JLabel name_1 = new JLabel("Owner: ");
			JLabel name_2 = new JLabel(prop.getOwner().getFname() + " " + prop.getOwner().getFname());
			JLabel id_1 = new JLabel("Property Id: ");
			JLabel id_2 = new JLabel(Integer.toString(prop.getPropertyId()));
			north.setLayout(new GridLayout(1, 4));
			north.setBorder(BorderFactory.createLineBorder(Color.black));
			north.add(name_1);
			north.add(name_2);
			north.add(id_1);
			north.add(id_2);
			
			JLabel type_1 = new JLabel("Type: ");
			JLabel type_2 = new JLabel(prop.getType());
			JLabel add_1 = new JLabel("Address: ");
			JLabel add_2 = new JLabel(prop.getStreet() + " " + prop.getCity() + " " + prop.getPostcode());
			JLabel rooms_1 = new JLabel("Rooms: ");
			JLabel rooms_2 = new JLabel(Integer.toString(prop.getNumRooms()));
			JLabel staff_1 = new JLabel("Staff Member: ");
			JLabel staff_2 = new JLabel(prop.getStaff().toString());
			JLabel rent_1 = new JLabel("Monthly Rent: ");
			JLabel rent_2 = new JLabel(Double.toString(prop.getMonthlyRent()));
			
			west.setLayout(new GridLayout(4, 2));
			west.setBorder(BorderFactory.createLineBorder(Color.black));
			west.add(type_1);
			west.add(type_2);
			west.add(add_1);
			west.add(add_2);
			west.add(rooms_1);
			west.add(rooms_2);
			west.add(staff_1);
			west.add(staff_2);
			west.add(rent_1);
			west.add(rent_2);
			
		}
		if(o.getClass() == PropertyOwner.class) {
			JPanel north = new JPanel();
			JPanel center = new JPanel();
			JPanel west = new JPanel();
			JPanel south = new JPanel();
			JPanel east = new JPanel();
			
			frame.add(north, BorderLayout.NORTH);
			frame.add(center, BorderLayout.CENTER);
			frame.add(west, BorderLayout.WEST);
			frame.add(south, BorderLayout.SOUTH);
			frame.add(east, BorderLayout.EAST);

			PropertyOwner propOwn = (PropertyOwner) o;
			JLabel name_1 = new JLabel("Owner: ");
			JLabel name_2 = new JLabel(propOwn.getFname() + " " + propOwn.getLname());
			JLabel Oid_1 = new JLabel("ID: ");
			JLabel Oid_2 = new JLabel(Integer.toString(propOwn.getOwnerNum()));
			JLabel mem_1 = new JLabel("Staff Member: ");
			JLabel mem_2 = new JLabel(propOwn.getStaff().toString());
			JLabel add_1 = new JLabel("Address:" );
			JLabel add_2 = new JLabel(propOwn.getStreet() + " " + propOwn.getCity() + " " + propOwn.getPostCode());
			JLabel phone_1 = new JLabel("Phone Number: ");
			JLabel phone_2 = new JLabel(propOwn.getPhone());
			north.setLayout(new GridLayout(1, 4));
			north.setBorder(BorderFactory.createLineBorder(Color.black));
			north.add(name_1);
			north.add(name_2);
			north.add(Oid_1);
			north.add(Oid_2);
			
			west.setLayout(new GridLayout(4, 2));
			west.setBorder(BorderFactory.createLineBorder(Color.black));
			west.add(mem_1);
			west.add(mem_2);
			west.add(add_1);
			west.add(add_2);
			west.add(phone_1);
			west.add(phone_2);
		}
		if(o.getClass() == BusinessOwner.class) {
			
		}
		if(o.getClass() == PropView.class) {
			JPanel north = new JPanel();
			JPanel center = new JPanel();
			JPanel west = new JPanel();
			JPanel south = new JPanel();
			JPanel east = new JPanel();
			
			frame.add(north, BorderLayout.NORTH);
			frame.add(center, BorderLayout.CENTER);
			frame.add(west, BorderLayout.WEST);
			frame.add(south, BorderLayout.SOUTH);
			frame.add(east, BorderLayout.EAST);

			PropView view = (PropView) o;
			Client c1 = new Client();
			JLabel client_1 = new JLabel("Client: ");
			JLabel client_2 = new JLabel(c1.getClientByID(view.getCID()).toString());
			JLabel name_1 = new JLabel("Property ID: ");
			JLabel name_2 = new JLabel(Integer.toString(view.getPID()));
			JLabel view_1 = new JLabel("View Date: ");
			JLabel view_2 = new JLabel(view.getViewDate());
			JLabel comments_1 = new JLabel("Comments: ");
			JLabel comments_2 = new JLabel(view.getComments());
			JLabel staff_1 = new JLabel("Staff member: ");
			JLabel staff_2 = new JLabel(view.getStaff().toString());
			
			north.setLayout(new GridLayout(1, 4));
			north.setBorder(BorderFactory.createLineBorder(Color.black));
			north.add(client_1);
			north.add(client_2);
			north.add(name_1);
			north.add(name_2);
			
			west.setLayout(new GridLayout(4, 2));
			west.setBorder(BorderFactory.createLineBorder(Color.black));
			west.add(view_1);
			west.add(view_2);
			west.add(comments_1);
			west.add(comments_2);
			west.add(staff_1);
			west.add(staff_2);
		}
		if(o.getClass() == Lease.class) {
			JPanel north = new JPanel();
			JPanel center = new JPanel();
			JPanel west = new JPanel();
			JPanel south = new JPanel();
			JPanel east = new JPanel();
			
			frame.add(north, BorderLayout.NORTH);
			frame.add(center, BorderLayout.CENTER);
			frame.add(west, BorderLayout.WEST);
			frame.add(south, BorderLayout.SOUTH);
			frame.add(east, BorderLayout.EAST);
			
			Lease l = (Lease) o;
			JLabel id_1 = new JLabel("Lease ID:");
			JLabel id_2 = new JLabel(Integer.toString(l.getLeaseId()));
			JLabel cid_1 = new JLabel("Client ID: ");
			JLabel cid_2 = new JLabel(Integer.toString(l.getClientId()));
			JLabel cname_1 = new JLabel("Cient Name: ");
			JLabel cname_2 = new JLabel(l.getClient().getFname() + " " + l.getClient().getLname());
			JLabel add_1 = new JLabel("Address: ");
			JLabel add_2 = new JLabel(l.getStreet() + " " + l.getCity() + " " + l.getPostcode());
			JLabel type_1 = new JLabel("Property Type: ");
			JLabel type_2 = new JLabel(l.getType());
			JLabel rooms_1 = new JLabel("Number of Rooms: ");
			
					
		}
		
		
	}

}
