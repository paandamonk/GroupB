package pp;

import java.awt.BorderLayout;
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
			
		}
		if(o.getClass() == Property.class) {
			
		}
		if(o.getClass() == PropertyOwner.class) {
			
		}
		if(o.getClass() == BusinessOwner.class) {
			
		}
		if(o.getClass() == PropView.class) {
			
		}
		if(o.getClass() == Lease.class) {
			
		}
		
		
	}

}
