package pp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;

import sql.Input;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionListener;


public class Add implements ActionListener{

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private String[] addChoices = {"Clients", "Properties", "Staff", "Property Owners", "Business Owners", "Property Viewings", "Leases"};
    private String[]addChoicesNotManager = {"Clients", "Properties", "Property Owners", "Business Owners", "Property Viewings", "Leases"};
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JLabel l0;
	private JLabel l1;
	private JLabel l2;
	private JLabel l3;
	private JLabel l4;
	private JLabel l5;
	private JLabel l6;
	private JLabel l7;
	private JLabel l8;
	private JLabel l9;
	private JLabel l10;
	private JLabel l11;
	private JLabel l12;
	private JLabel l13;
	private JLabel l14;
	private JLabel l15, hint;
	private JComboBox<?> comboBox;
	private JPanel panel, display2, display3;
	private JPanel panel_1, panelEast;
	private JButton btnSubmit;
	private JRadioButton b1, b2, b3;
	private JScrollPane scroll = new JScrollPane();
	private Client client = new Client();
	private Property property = new Property();
	private Staff staff = new Staff();
    private PropertyOwner propertyOwner = new PropertyOwner();
    private BusinessOwner businessOwner = new BusinessOwner();
    private PropView propView = new PropView();
    private Lease lease = new Lease();
	private ArrayList<Client> clientList = client.getClientByID(0);
	private ArrayList<Property> propertyList = property.getPropertyByID(0);
	private ArrayList<Staff> staffList = staff.getStaffByID(0);
	private ArrayList<PropertyOwner> propertyOwnerList = propertyOwner.getPropOwnersByID(0);
    private ArrayList<BusinessOwner> businessOwnerList = businessOwner.getBusinessOwnersByID(0);
    private ArrayList<PropView> propViewList = propView.getPropViewByID(0);
    private ArrayList<Lease> leaseList = lease.getLeaseByClientId(0);

    private DefaultListModel secondaryList = new DefaultListModel<>();
	private DefaultListModel tertiaryList = new DefaultListModel<>();
    private JList<Property> propertyListForUpdating;
    private JList<Client> clientListForUpdating;
    private JList<Staff> staffListForUpdating;
	private JList<PropertyOwner> propertyOwnerListForUpdating;
	private JList<BusinessOwner> businessOwnerListForUpdating;
    private JList listForUpdating;
    private DefaultListModel list = new DefaultListModel<>();
    private JScrollPane staffScroll = new JScrollPane();
    private JScrollPane secondaryScroll = new JScrollPane();
    private int switchCase = 0;



    /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//Add window = new Add(cl);
		//window.frame.setVisible(true);
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Add window = new Add();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}

	/**
	 * Create the application.
	 */
	public Add(int cl) {
		initialize(cl);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int cl) {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.GRAY, Color.BLACK));
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		JLabel lblSelect = new JLabel("Select:");
		//panel.add(lblSelect);
        if(cl == 2) {
            comboBox = new JComboBox<Object>(addChoices);
        }
        else{
            comboBox = new JComboBox<Object>(addChoicesNotManager);
        }
		comboBox.addActionListener(this);
		//comboBox.setSelectedIndex(0);

        panel.add(comboBox);

        b1 = new JRadioButton();
            b1.setText("Add");
        b2 = new JRadioButton();
            b2.setText("Update");
        b3 = new JRadioButton();
            b3.setText("Delete");
        panel.add(b1);
        b1.setSelected(true);
        panel.add(b2);
        panel.add(b3);
        //add
        b1.addActionListener(e2 -> {
            b2.setSelected(false);
            b3.setSelected(false);
        });
        //update
        b2.addActionListener(e2 -> {
            b1.setSelected(false);
            b3.setSelected(false);
        });
        //delete
        b3.addActionListener(e2 -> {
            b1.setSelected(false);
            b2.setSelected(false);
        });

		panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, null, null));
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel l0 = new JLabel("First: ");
		panel_1.add(l0);

		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);

		JLabel l1 = new JLabel("Second:");
		panel_1.add(l1);

		textField_1 = new JTextField();
		textField_1.setColumns(1);
		panel_1.add(textField_1);

		JLabel l2 = new JLabel("Third:");
		panel_1.add(l2);

		textField_2 = new JTextField();
		textField_2.setColumns(2);
		panel_1.add(textField_2);

		JLabel l3 = new JLabel("Fourth:");
		panel_1.add(l3);

		textField_3 = new JTextField();
		textField_3.setColumns(3);
		panel_1.add(textField_3);

		JLabel l4 = new JLabel("Fifth");
		panel_1.add(l4);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		panel_1.add(textField_4);

		JLabel l5 = new JLabel("Sixth:");
		panel_1.add(l5);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		panel_1.add(textField_5);

		JLabel l6 = new JLabel("First: ");
		panel_1.add(l6);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		panel_1.add(textField_6);

		JLabel l7 = new JLabel("First: ");
		panel_1.add(l7);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		panel_1.add(textField_7);

		JLabel l8 = new JLabel("First: ");
		panel_1.add(l8);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		panel_1.add(textField_8);

		JLabel l9 = new JLabel("First: ");
		panel_1.add(l9);

		textField_9 = new JTextField();
		textField_9.setColumns(10);
		panel_1.add(textField_9);

		JLabel l10 = new JLabel("First: ");
		panel_1.add(l10);

		textField_10 = new JTextField();
		textField_10.setColumns(10);
		panel_1.add(textField_10);

		JLabel l11 = new JLabel("First: ");
		panel_1.add(l11);

		textField_11 = new JTextField();
		textField_11.setColumns(10);
		panel_1.add(textField_11);

		JLabel l12 = new JLabel("First: ");
		panel_1.add(l12);

		textField_12 = new JTextField();
		textField_12.setColumns(10);
		panel_1.add(textField_12);

		JLabel l13 = new JLabel("First: ");
		panel_1.add(l13);

		textField_13 = new JTextField();
		textField_13.setColumns(10);
		panel_1.add(textField_13);

		JLabel l14 = new JLabel("First: ");
		panel_1.add(l14);

		textField_14 = new JTextField();
		textField_14.setColumns(10);
		panel_1.add(textField_14);

		JLabel l15 = new JLabel("First: ");
		panel_1.add(l15);

		textField_15 = new JTextField();
		textField_15.setColumns(10);
		panel_1.add(textField_15);

		JPanel display = new JPanel(new BorderLayout());
		display2 = new JPanel(new BorderLayout());
		display3 = new JPanel();

		btnSubmit = new JButton("<html><h4>Submit</h4></html>");
		hint = new JLabel();
		hint.setText("Example hint");
		//btnSubmit.setPreferredSize(new Dimension(75, 75));
		//frame.getContentPane().add(btnSubmit, BorderLayout.NORTH);
		//frame.getContentPane().add(btnSubmit2, BorderLayout.SOUTH);
		panel.add(display);
		display.add(btnSubmit);
		//panel_1.add(display);
		//frame.getContentPane().add(comboBox, BorderLayout.SOUTH);
		btnSubmit.addActionListener(this);
		//Ensures box opens to add clients
		comboBox.setSelectedIndex(0);

        // Creating the eastern jScrollPane before we fill it with data
		scroll = new JScrollPane();
		scroll.setViewportView(listForUpdating);

		//Setting the JScrollPane's location
		panelEast = new JPanel();
		panelEast.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, null, null));
		frame.getContentPane().add(panelEast, BorderLayout.EAST);
		panelEast.setLayout(new GridLayout(2, 1, 0, 0));
		panelEast.add(display2, BorderLayout.NORTH);
		panelEast.add(display3, BorderLayout.SOUTH);
		display2.add(scroll);
		display3.add(hint);
		//END Staff
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//all done except for button
		if(comboBox.getSelectedItem().equals("Clients")) {
			switchCase = 0;

			panel_1.removeAll();
			textField.setVisible(true);
			textField_1.setVisible(true);
			textField_2.setVisible(true);
			textField_3.setVisible(true);
			textField_4.setVisible(true);
			textField_5.setVisible(true);
			textField_6.setVisible(true);
			textField_7.setVisible(true);
			textField_8.setVisible(true);
			textField_9.setVisible(false);
			textField_10.setVisible(false);
			textField_11.setVisible(false);
			textField_12.setVisible(false);
			textField_13.setVisible(false);
			textField_14.setVisible(false);
			textField_15.setVisible(false);
			l0 = new JLabel("First name");
			panel_1.add(l0);
			//JLabel fnReminder = new JLabel("First letter must be capitalized.");
			panel_1.add(l0);
			//panel_1.add(fnReminder);
			panel_1.add(textField);
			l1 = new JLabel("Last name");
			panel_1.add(l1);
			panel_1.add(textField_1);
			l2 = new JLabel("Type");
			panel_1.add(l2);
			panel_1.add(textField_2);
			l3 = new JLabel("Phone Number");
			panel_1.add(l3);
			panel_1.add(textField_3);
			l4 = new JLabel("Max Rent");
			panel_1.add(l4);
			panel_1.add(textField_4);
			l6 = new JLabel("Street");
			panel_1.add(l6);
			panel_1.add(textField_6);
			l7 = new JLabel("City");
			panel_1.add(l7);
			panel_1.add(textField_7);
			l8 = new JLabel("zip");
			panel_1.add(l8);
			panel_1.add(textField_8);
			l5 = new JLabel("Staff");
			panel_1.add(l5);

			staffListForUpdating = new JList<>(secondaryList);
			staffScroll = new JScrollPane();
			staffScroll.setViewportView(staffListForUpdating);

			staffListForUpdating.addListSelectionListener(e3 -> {
				if(switchCase == 0) {
					Staff selectedStaff2 = staffListForUpdating.getSelectedValue();
					if (selectedStaff2 != null) {
						System.out.println(selectedStaff2.getStaffNum());
                        textField_5.setText(Integer.toString(selectedStaff2.getStaffNum()));
						//selectedStaff2.getStaffNum()
						//TODO use this variable for updating the staff number
					}
				}
			});
			panel_1.add(staffScroll);
			panel_1.validate();
			panel_1.repaint();

			/////////////////////////////////////////////////
			if(list != null){
				list.removeAllElements();
			}
			if(secondaryList != null){
				secondaryList.removeAllElements();
                ArrayList<Staff> newStaffList;
                newStaffList = staff.getStaffByPosition(0);
				for(int i = 0; i < newStaffList.size(); i++){
				    secondaryList.addElement(newStaffList.get(i));
                }
			}
			for(int i = 0; i < clientList.size(); i++){
				if(!list.contains(clientList.get(i))) {
					list.addElement(clientList.get(i));
				}
			}
			listForUpdating = new JList(list);

			//Activated by clicking an item from the list

			listForUpdating.addListSelectionListener(e2 -> {
				if(switchCase == 0) { //clients are selected
					Client selectedClient = (Client)listForUpdating.getSelectedValue();
					if(selectedClient != null) {
						textField.setText(selectedClient.getFname());
						textField_1.setText(selectedClient.getLname());
                        textField_2.setText(selectedClient.getType());
                        textField_3.setText(selectedClient.getPhone());
                        DecimalFormat df2 = new DecimalFormat(".##");
                        textField_4.setText(df2.format(selectedClient.getMax())); //maxRent
                        textField_5.setText(Integer.toString(selectedClient.getStaffId()));
                        textField_6.setText(selectedClient.getStreet());
                        textField_7.setText(selectedClient.getCity());
                        textField_8.setText(selectedClient.getPostCode());

                        ArrayList<Staff> newStaffList;
						secondaryList.removeAllElements();
							newStaffList = staff.getStaffByPosition(0);

							for (int i = 0; i < newStaffList.size(); i++) {
								if (selectedClient.getStaffId() == newStaffList.get(i).getStaffNum()) {
									secondaryList.addElement(newStaffList.get(i));
									break;
								}
							}
							for (int i = 0; i < newStaffList.size(); i++) {
								if (selectedClient.getStaffId() == newStaffList.get(i).getStaffNum()) {
									continue;
								}
								secondaryList.addElement(newStaffList.get(i));
							}
							panel_1.remove(staffScroll);
							staffScroll = new JScrollPane();
							staffScroll.setViewportView(staffListForUpdating);
							staffListForUpdating.setSelectedIndex(0);
							panel_1.add(staffScroll);
					}
					panel_1.validate();
					panel_1.repaint();
				}
			});

			/////////////////////////////////////////////////

            //revalidate Eastern panel
			revalidateEast();

			//Button listener needs more idiot-proofing, but it works as of right now.
			if(e.getSource() == btnSubmit) {
				boolean cleared = (textField.getText() == null) || (textField_1.getText() == null) ||
						(textField_2.getText() == null) || (textField_3.getText() == null) ||
						(textField_4.getText() == null) || (textField_5.getText() == null) ||
						(textField_6.getText() == null) || (textField_7.getText() == null) ||
						(textField_8.getText() == null);

				//right now it either crashes when trying to submit empty or it gives the dialog box each time. Needs work.
//				if(cleared) {
				String fname = "'" + textField.getText() + "'";
				String lname = "'" + textField_1.getText() + "'";
				String type = "'" + textField_2.getText() + "'";
				String phone = "'" + textField_3.getText() + "'";
				double rent = Double.parseDouble(textField_4.getText());
				int staffId = Integer.parseInt(textField_5.getText());
				String street = "'" + textField_6.getText() + "'";
				String city = "'" + textField_7.getText() + "'";
				String zip = "'" + textField_8.getText() + "'";
				Input clientinput = new Input("CLIENTS");
				clientinput.addClientInfo(fname, lname, type, phone, rent, staffId, street, city, zip);

				clientList = client.getClientByID(0);
				if(list != null){
					list.removeAllElements();
				}
				for(int i = 0; i < clientList.size(); i++){
					if(!list.contains(clientList.get(i))) {
						list.addElement(clientList.get(i));
					}
				}
				listForUpdating = new JList(list);
				//Revalidates main list when clicking on a new dropdown item
				revalidateEast();

			}
			textField.setText(null);
			textField_1.setText(null);
			textField_2.setText(null);
			textField_3.setText(null);
			textField_4.setText(null);
			textField_5.setText(null);
			textField_6.setText(null);
			textField_7.setText(null);
			textField_8.setText(null);
		}
		//Up to date except button listener
		if(comboBox.getSelectedItem().equals("Properties")) {
			switchCase = 1;
            hint.setText("Example hint that happens to be really super duper totally long");
			panel_1.removeAll();

			textField.setVisible(true);
			textField_1.setVisible(true);
			textField_2.setVisible(true);
			textField_3.setVisible(true);
			textField_4.setVisible(true);
			textField_5.setVisible(true);
			textField_6.setVisible(true);
			textField_7.setVisible(false);
			textField_8.setVisible(false);
			textField_9.setVisible(false);
			textField_10.setVisible(false);
			textField_11.setVisible(false);
			textField_12.setVisible(false);
			textField_13.setVisible(false);
			textField_14.setVisible(false);
			textField_15.setVisible(false);
			l0 = new JLabel("Street");
			panel_1.add(l0);
			panel_1.add(textField);
			l1 = new JLabel("City");
			panel_1.add(l1);
			panel_1.add(textField_1);
			l2 = new JLabel("Post Code");
			panel_1.add(l2);
			panel_1.add(textField_2);
			l3 = new JLabel("Type");
			panel_1.add(l3);
			panel_1.add(textField_3);
			l4 = new JLabel("Rooms");
			panel_1.add(l4);
			panel_1.add(textField_4);
			l5 = new JLabel("Rent");
			panel_1.add(l5);
			panel_1.add(textField_5);
			l6 = new JLabel("Owner");
			panel_1.add(l6);
			//panel_1.add(textField_6); //if add is enabled

			propertyOwnerListForUpdating = new JList<>(secondaryList);
			staffScroll = new JScrollPane();
			staffScroll.setViewportView(propertyOwnerListForUpdating);

			propertyOwnerListForUpdating.addListSelectionListener(e3 -> {
				if(switchCase == 1) {
					PropertyOwner selectedPropertyOwner = propertyOwnerListForUpdating.getSelectedValue();
					if (selectedPropertyOwner != null) {
						System.out.println(selectedPropertyOwner.getOwnerNum());
                        textField_6.setText(Integer.toString(selectedPropertyOwner.getOwnerNum()));
						//TODO use this variable for updating the staff number
					}
				}
			});

			panel_1.add(staffScroll);
			panel_1.validate();
			panel_1.repaint();
			/////////////////////////////////////////////////
			if(list != null){
				list.removeAllElements();
			}
			if(secondaryList != null){
				secondaryList.removeAllElements();

				for(int i = 0; i < propertyOwnerList.size(); i++){
					secondaryList.addElement(propertyOwnerList.get(i));
				}
			}

			for(int i = 0; i < propertyList.size(); i++){
				if(!list.contains(propertyList.get(i))) {
					list.addElement(propertyList.get(i));
				}
			}
			listForUpdating = new JList(list);

			//Activated by clicking an item from the list
			listForUpdating.addListSelectionListener(e2 -> {
				if(switchCase == 1) {
					Property selectedProperty = (Property)listForUpdating.getSelectedValue();
					if(selectedProperty != null) {
						textField.setText(selectedProperty.getStreet ());
						textField_1.setText(selectedProperty.getCity());
						textField_2.setText(selectedProperty.getPostcode());
                        textField_3.setText(selectedProperty.getType());
                        textField_4.setText(Integer.toString(selectedProperty.getNumRooms()));
                        DecimalFormat df2 = new DecimalFormat(".##");
                        textField_5.setText(df2.format(selectedProperty.getMonthlyRent()));
                        textField_6.setText(Integer.toString(selectedProperty.getOwner().getOwnerNum()));

						ArrayList<PropertyOwner> newPropOwnerList;
						//staffListForUpdating = new JList<>(supervisorList);
						secondaryList.removeAllElements();

							for (int i = 0; i < propertyOwnerList.size(); i++) {
								if (selectedProperty.getOwner().getOwnerNum() == propertyOwnerList.get(i).getOwnerNum()) {
									secondaryList.addElement(propertyOwnerList.get(i));
									break;
								}
							}
							for (int i = 0; i < propertyOwnerList.size(); i++) {
								if (selectedProperty.getOwner().getOwnerNum() == propertyOwnerList.get(i).getOwnerNum()) {
									continue;
								}
								secondaryList.addElement(propertyOwnerList.get(i));
							}
							panel_1.remove(staffScroll);
							staffScroll = new JScrollPane();
							staffScroll.setViewportView(propertyOwnerListForUpdating);
							propertyOwnerListForUpdating.setSelectedIndex(0);
							panel_1.add(staffScroll);
						}
						panel_1.validate();
						panel_1.repaint();
				}
			});
			/////////////////////////////////////////////////
			//Revalidates main list when clicking on a new dropdown item
			panelEast.remove(scroll);
			panelEast.remove(display2);
			panelEast.remove(display3);
			scroll = new JScrollPane();
			scroll.setViewportView(listForUpdating);

			panelEast.add(scroll);
			panelEast.add(display3);
			panelEast.validate();
			panelEast.repaint();

			//Button listener needs more idiot-proofing, but it works as of right now.
			if(e.getSource() == btnSubmit) {
				boolean cleared = (textField.getText() == null) || (textField_1.getText() == null) ||
						(textField_2.getText() == null) || (textField_3.getText() == null) ||
						(textField_4.getText() == null) || (textField_5.getText() == null) ||
						(textField_6.getText() == null);

				//right now it either crashes when trying to submit empty or it gives the dialog box each time. Needs work.
				//	if(cleared) {
				Input propertyinput = new Input("PROPERTIES");
				String street = "'" + textField.getText() + "'";
				String city = "'" + textField_1.getText() + "'";
				String zip ="'" + textField_2.getText() + "'";
				String type = "'" + textField_3.getText() + "'";
				int rooms = Integer.parseInt(textField_4.getText());
				double rent = Double.parseDouble(textField_5.getText());
				int owner = Integer.parseInt(textField_6.getText());

				propertyinput.addPropertyInfo(street, zip, city, type, rooms, rent, owner);
//				}
//				else {
//					JOptionPane.showMessageDialog(null, "Something was empty. \n Try again.");
//
//				}
			}
			textField.setText(null);
			textField_1.setText(null);
			textField_2.setText(null);
			textField_3.setText(null);
			textField_4.setText(null);
			textField_5.setText(null);
			textField_6.setText(null);
		}
		//Up to date except button listener
		if(comboBox.getSelectedItem().equals("Staff")) {
			switchCase = 2;
			panel_1.removeAll();

			b1.setSelected(false);
            b1.setVisible(false);

			textField.setVisible(true);
			textField_1.setVisible(true);
			textField_2.setVisible(true);
			textField_3.setVisible(true);
			textField_4.setVisible(true);
			textField_5.setVisible(true);
			textField_6.setVisible(true);
			textField_7.setVisible(true);
			textField_8.setVisible(false);
			textField_9.setVisible(false);
			textField_10.setVisible(false);
			textField_11.setVisible(false);
			textField_12.setVisible(false);
			textField_13.setVisible(false);
			textField_14.setVisible(false);
			textField_15.setVisible(false);
			l0 = new JLabel("First name");
			panel_1.add(l0);
			panel_1.add(textField);
			l1 = new JLabel("Last name");
			panel_1.add(l1);
			panel_1.add(textField_1);
			l2 = new JLabel("Position");
			panel_1.add(l2);
			panel_1.add(textField_2);
			l3 = new JLabel("Branch");
			panel_1.add(l3);
			panel_1.add(textField_3);
			l4 = new JLabel("Sex");
			panel_1.add(l4);
			panel_1.add(textField_4);
			l5 = new JLabel("DoB");
			panel_1.add(l5);
			panel_1.add(textField_5);
			l6 = new JLabel("Salary");
			panel_1.add(l6);
			panel_1.add(textField_6);
			l7 = new JLabel("Supervisor");
			panel_1.add(l7);
            panel_1.validate();
            panel_1.repaint();

            staffListForUpdating = new JList<>(secondaryList);
            staffScroll = new JScrollPane();
            staffScroll.setViewportView(staffListForUpdating);

            staffListForUpdating.addListSelectionListener(e3 -> {
				if(switchCase == 2) {
					Staff selectedStaff2 = staffListForUpdating.getSelectedValue();
					if (selectedStaff2 != null) {
						System.out.println(selectedStaff2.getStaffNum());
						//selectedStaff2.getStaffNum()
						//TODO use this variable for updating the staff number
					}
				}
            });
            /////////////////////////////////////////////////
			if(list != null){
				list.removeAllElements();
			}
            for(int i = 0; i < staffList.size(); i++){
                if(!list.contains(staffList.get(i))) {
                    list.addElement(staffList.get(i));
                }
            }
            listForUpdating = new JList(list);

            //Activated by clicking an item from the list
            listForUpdating.addListSelectionListener(e2 -> {
            	if(switchCase == 2) {
					Staff selectedStaff = (Staff)listForUpdating.getSelectedValue();
					if(selectedStaff != null) {
						textField.setText(selectedStaff.getFname());
						textField_1.setText(selectedStaff.getLname());
						int position = selectedStaff.getPosition();
						String staffTitle = "";
						if(position == 2){
                            staffTitle = "Manager";
                        }
                        else if (position == 1){
                            staffTitle = "Supervisor";
                        }
                        else if (position == 0){
                            staffTitle = "Agent";
                        }
                        textField_2.setText(staffTitle);
						textField_3.setText(selectedStaff.getBranch());
						textField_4.setText(selectedStaff.getGender());
						textField_5.setText(selectedStaff.getDOB());
                        DecimalFormat df2 = new DecimalFormat(".##");
						textField_6.setText(df2.format(selectedStaff.getSalary()));

						ArrayList<Staff> newStaffList;
						//staffListForUpdating = new JList<>(supervisorList);
						secondaryList.removeAllElements();
						if (selectedStaff.getPosition() != 2) {
							newStaffList = staff.getStaffByPosition(2);
							if (selectedStaff.getPosition() == 1) {
								newStaffList = staff.getStaffByPosition(2);
							} else if (selectedStaff.getPosition() == 0) {
								newStaffList = staff.getStaffByPosition(1);
							}
							for (int i = 0; i < newStaffList.size(); i++) {
								if (selectedStaff.getSupervisorID() == newStaffList.get(i).getStaffNum()) {
									secondaryList.addElement(newStaffList.get(i));
									break;
								}
							}
							for (int i = 0; i < newStaffList.size(); i++) {
								if (selectedStaff.getSupervisorID() == newStaffList.get(i).getStaffNum()) {
									continue;
								}
								secondaryList.addElement(newStaffList.get(i));
							}
							panel_1.remove(staffScroll);
							staffScroll = new JScrollPane();
							staffScroll.setViewportView(staffListForUpdating);
							staffListForUpdating.setSelectedIndex(0);
							panel_1.add(staffScroll);
						}
						else {
							panel_1.remove(staffScroll);
						}
						panel_1.validate();
						panel_1.repaint();
					}
				}
            });
            /////////////////////////////////////////////////
            //Revalidates main list when clicking on a new dropdown item
            panelEast.remove(scroll);
            panelEast.remove(display2);
            panelEast.remove(display3);
            scroll = new JScrollPane();
            scroll.setViewportView(listForUpdating);
            listForUpdating.setSelectedIndex(0);

            panelEast.add(scroll);
            panelEast.add(display3);
            panelEast.validate();
            panelEast.repaint();

			textField.setText(null);
			textField_1.setText(null);
			textField_2.setText(null);
			textField_3.setText(null);
			textField_4.setText(null);
			textField_5.setText(null);
			textField_6.setText(null);

		}
		else{
            b1.setVisible(true);
        }
		//under construction
		if(comboBox.getSelectedItem().equals("Property Owners")) {
            switchCase = 3;
			panel_1.removeAll();

			textField.setVisible(true);
			textField_1.setVisible(true);
			textField_2.setVisible(true);
			textField_3.setVisible(true);
			textField_4.setVisible(true);
			textField_5.setVisible(true);
			textField_6.setVisible(true);
			textField_7.setVisible(false);
			textField_8.setVisible(false);
			textField_9.setVisible(false);
			textField_10.setVisible(false);
			textField_11.setVisible(false);
			textField_12.setVisible(false);
			textField_13.setVisible(false);
			textField_14.setVisible(false);
			textField_15.setVisible(false);
			l0 = new JLabel("First name");
			panel_1.add(l0);
			panel_1.add(textField);
			l1 = new JLabel("Last name");
			panel_1.add(l1);
			panel_1.add(textField_1);
			l2 = new JLabel("Street");
			panel_1.add(l2);
			panel_1.add(textField_2);
			l3 = new JLabel("City");
			panel_1.add(l3);
			panel_1.add(textField_3);
			l4 = new JLabel("Post Code");
			panel_1.add(l4);
			panel_1.add(textField_4);
			l5 = new JLabel("Phone");
			panel_1.add(l5);
			panel_1.add(textField_5);
			l6 = new JLabel("Staff");
			panel_1.add(l6);
			//panel_1.add(textField_6);

            staffListForUpdating = new JList<>(secondaryList);
            staffScroll = new JScrollPane();
            staffScroll.setViewportView(staffListForUpdating);

            staffListForUpdating.addListSelectionListener(e3 -> {
                if(switchCase == 3) {
                    Staff selectedStaff2 = staffListForUpdating.getSelectedValue();
                    if (selectedStaff2 != null) {
                        System.out.println(selectedStaff2.getStaffNum());
                        //selectedStaff2.getStaffNum()
                        //TODO use this variable for updating the staff number
                    }
                }
            });
            panel_1.add(staffScroll);
            panel_1.validate();
            panel_1.repaint();

            /////////////////////////////////////////////////
            if(list != null){
                list.removeAllElements();
            }
            if(secondaryList != null){
                secondaryList.removeAllElements();
                ArrayList<Staff> newStaffList;
                newStaffList = staff.getStaffByPosition(0);
                for(int i = 0; i < newStaffList.size(); i++){
                    secondaryList.addElement(newStaffList.get(i));
                }
            }
            for(int i = 0; i < propertyOwnerList.size(); i++){
                if(!list.contains(propertyOwnerList.get(i))) {
                    list.addElement(propertyOwnerList.get(i));
                }
            }
            listForUpdating = new JList(list);

            //Activated by clicking an item from the list

            listForUpdating.addListSelectionListener(e2 -> {
                if(switchCase == 3) { //clients are selected
                    PropertyOwner selectedPropertyOwner = (PropertyOwner) listForUpdating.getSelectedValue();
                    if(selectedPropertyOwner != null) {
                        textField.setText(selectedPropertyOwner.getFname());
                        textField_1.setText(selectedPropertyOwner.getLname());
                        textField_2.setText(selectedPropertyOwner.getStreet());
                        textField_3.setText(selectedPropertyOwner.getCity());
                        textField_4.setText(selectedPropertyOwner.getPostCode());
                        textField_5.setText(selectedPropertyOwner.getPhone());

                        ArrayList<Staff> newStaffList;
                        //staffListForUpdating = new JList<>(supervisorList);
                        secondaryList.removeAllElements();
                        newStaffList = staff.getStaffByPosition(0);

                        for (int i = 0; i < newStaffList.size(); i++) {
                            if (selectedPropertyOwner.getStaffId() == newStaffList.get(i).getStaffNum()) {
                                secondaryList.addElement(newStaffList.get(i));
                                break;
                            }
                        }
                        for (int i = 0; i < newStaffList.size(); i++) {
                            if (selectedPropertyOwner.getStaffId() == newStaffList.get(i).getStaffNum()) {
                                continue;
                            }
                            secondaryList.addElement(newStaffList.get(i));
                        }
                        panel_1.remove(staffScroll);
                        staffScroll = new JScrollPane();
                        staffScroll.setViewportView(staffListForUpdating);
                        staffListForUpdating.setSelectedIndex(0);
                        panel_1.add(staffScroll);
                    }
                    panel_1.validate();
                    panel_1.repaint();
                }
            });

            /////////////////////////////////////////////////

            //revalidate Eastern panel
            revalidateEast();

			//Button listener needs more idiot-proofing, but it works as of right now.
			if(e.getSource() == btnSubmit) {
				boolean cleared = (textField.getText() == null) || (textField_1.getText() == null) ||
						(textField_2.getText() == null) || (textField_3.getText() == null) ||
						(textField_4.getText() == null) || (textField_5.getText() == null) ||
						(textField_6.getText() == null);

				//right now it either crashes when trying to submit empty or it gives the dialog box each time. Needs work.
				//		if(cleared) {
				Input addPropertyOwner = new Input("PROPOWNERS");
				String fname = "'" + textField.getText() + "'";
				String lname = "'" + textField_1.getText() + "'";
				String street = "'" + textField_2.getText() + "'";
				String city = "'" + textField_3.getText() + "'";
				String zip = "'" + textField_4.getText() + "'";
				String phone = "'" + textField_5.getText() + "'";
				int staffId = Integer.parseInt(textField_6.getText());
				addPropertyOwner.addPropOwnerInfo(fname, lname, street, city, zip, phone, staffId);
//				}
//				else {
//					JOptionPane.showMessageDialog(null, "Something was empty. \n Try again.");
//
//				}

			}
			textField.setText(null);
			textField_1.setText(null);
			textField_2.setText(null);
			textField_3.setText(null);
			textField_4.setText(null);
			textField_5.setText(null);
			textField_6.setText(null);
		}
		//Up to date besides the idiot protection
		if(comboBox.getSelectedItem().equals("Business Owners")) {
		    switchCase = 4;
			panel_1.removeAll();

			textField.setVisible(true);
			textField_1.setVisible(true);
			textField_2.setVisible(true);
			textField_3.setVisible(true);
			textField_4.setVisible(true);
			textField_5.setVisible(true);
			textField_6.setVisible(true);
			textField_7.setVisible(true);
			textField_8.setVisible(true);
			textField_9.setVisible(false);
			textField_10.setVisible(false);
			textField_11.setVisible(false);
			textField_12.setVisible(false);
			textField_13.setVisible(false);
			textField_14.setVisible(false);
			textField_15.setVisible(false);
			l0 = new JLabel("First name");
			panel_1.add(l0);
			panel_1.add(textField);
			l1 = new JLabel("Last name");
			panel_1.add(l1);
			panel_1.add(textField_1);
			l2 = new JLabel("Street");
			panel_1.add(l2);
			panel_1.add(textField_2);
			l3 = new JLabel("City");
			panel_1.add(l3);
			panel_1.add(textField_3);
			l4 = new JLabel("Post Code");
			panel_1.add(l4);
			panel_1.add(textField_4);
			l5 = new JLabel("Phone");
			panel_1.add(l5);
			panel_1.add(textField_5);
			l6 = new JLabel("Business Name");
			panel_1.add(l6);
			panel_1.add(textField_6);
			l7 = new JLabel("Business Type");
			panel_1.add(l7);
			panel_1.add(textField_7);
			l8 = new JLabel("Staff Id");
			panel_1.add(l8);

            staffListForUpdating = new JList<>(secondaryList);
            staffScroll = new JScrollPane();
            staffScroll.setViewportView(staffListForUpdating);

            staffListForUpdating.addListSelectionListener(e3 -> {
                if(switchCase == 4) {
                    Staff selectedStaff2 = staffListForUpdating.getSelectedValue();
                    if (selectedStaff2 != null) {
                        System.out.println(selectedStaff2.getStaffNum());
                        //selectedStaff2.getStaffNum()
                        //TODO use this variable for updating the staff number
                    }
                }
            });
            panel_1.add(staffScroll);
            panel_1.validate();
            panel_1.repaint();

            /////////////////////////////////////////////////
            if(list != null){
                list.removeAllElements();
            }
            if(secondaryList != null){
                secondaryList.removeAllElements();
                ArrayList<Staff> newStaffList;
                newStaffList = staff.getStaffByPosition(0);
                for(int i = 0; i < newStaffList.size(); i++){
                    secondaryList.addElement(newStaffList.get(i));
                }
            }
            for(int i = 0; i < businessOwnerList.size(); i++){
                if(!list.contains(businessOwnerList.get(i))) {
                    list.addElement(businessOwnerList.get(i));
                }
            }
            listForUpdating = new JList(list);

            //Activated by clicking an item from the list

            listForUpdating.addListSelectionListener(e2 -> {
                if(switchCase == 4) { //clients are selected
                    BusinessOwner selectedBusinessOwner = (BusinessOwner)listForUpdating.getSelectedValue();
                    if(selectedBusinessOwner != null) {
                        textField.setText(selectedBusinessOwner.getFname());
                        textField_1.setText(selectedBusinessOwner.getLname());
                        textField_2.setText(selectedBusinessOwner.getStreet());
                        textField_3.setText(selectedBusinessOwner.getCity());
                        textField_4.setText(selectedBusinessOwner.getPostCode());
                        textField_5.setText(selectedBusinessOwner.getBusinessName());
                        textField_6.setText(selectedBusinessOwner.getPhone());
                        textField_7.setText(selectedBusinessOwner.getBusinessType()); //business type

                        ArrayList<Staff> newStaffList;
                        //staffListForUpdating = new JList<>(supervisorList);
                        secondaryList.removeAllElements();
                        newStaffList = staff.getStaffByPosition(0);

                        for (int i = 0; i < newStaffList.size(); i++) {
                            if (selectedBusinessOwner.getStaffId() == newStaffList.get(i).getStaffNum()) {
                                secondaryList.addElement(newStaffList.get(i));
                                break;
                            }
                        }
                        for (int i = 0; i < newStaffList.size(); i++) {
                            if (selectedBusinessOwner.getStaffId() == newStaffList.get(i).getStaffNum()) {
                                continue;
                            }
                            secondaryList.addElement(newStaffList.get(i));
                        }
                        panel_1.remove(staffScroll);
                        staffScroll = new JScrollPane();
                        staffScroll.setViewportView(staffListForUpdating);
                        staffListForUpdating.setSelectedIndex(0);
                        panel_1.add(staffScroll);
                    }
                    panel_1.validate();
                    panel_1.repaint();
                }
            });

            /////////////////////////////////////////////////

            //revalidate Eastern panel
            revalidateEast();

			if(e.getSource() == btnSubmit) {
				boolean cleared = (textField.getText() == null) || (textField_1.getText() == null) ||
						(textField_2.getText() == null) || (textField_3.getText() == null) ||
						(textField_4.getText() == null) || (textField_5.getText() == null) ||
						(textField_6.getText() == null) ||(textField_7.getText() == null) ||
						(textField_8.getText() == null);

				//right now it either crashes when trying to submit empty or it gives the dialog box each time. Needs work.
				//	if(cleared) {
				Input busownerinput = new Input("BUSOWNERS");
				String fname = "'" + textField.getText() + "'";
				String lname = "'" + textField_1.getText() + "'";
				String street = "'" + textField_2.getText() + "'";
				String city = "'" + textField_3.getText() + "'";
				String zip = "'" + textField_4.getText() + "'";
				String phone = "'" + textField_5.getText() + "'";
				String bname = "'" + textField_6.getText() + "'";
				String btype = "'" + textField_7.getText() + "'";
				if(!textField_7.getText().equals("")) {
					int staffId = Integer.parseInt(textField_8.getText());
					busownerinput.addBusinessOwnerInfo(fname, lname, street, city, zip, phone, bname, btype, staffId);
				}
				//busownerinput.addBusinessOwnerInfo(fname, lname, street, city, zip, phone, bname, btype, staffId);
//				}
//				else {
//					JOptionPane.showMessageDialog(null, "Something was empty. \n Try again.");
//
//				}

			}
			textField.setText(null);
			textField_1.setText(null);
			textField_2.setText(null);
			textField_3.setText(null);
			textField_4.setText(null);
			textField_5.setText(null);
			textField_6.setText(null);
			textField_7.setText(null);
			textField_8.setText(null);

		}
		//idiot proofing
		if(comboBox.getSelectedItem().equals("Property Viewings")) {
		    switchCase = 5;
			panel_1.removeAll();

			textField.setVisible(true);
			textField_1.setVisible(true);
			textField_2.setVisible(true);
			textField_3.setVisible(true);
			textField_4.setVisible(true);
			textField_5.setVisible(true);
			textField_6.setVisible(true);
			textField_7.setVisible(true);
			textField_8.setVisible(true);
			textField_9.setVisible(true);
			textField_10.setVisible(false);
			textField_11.setVisible(false);
			textField_12.setVisible(false);
			textField_13.setVisible(false);
			textField_14.setVisible(false);
			textField_15.setVisible(false);
			l0 = new JLabel("First name");
			panel_1.add(l0);
			panel_1.add(textField);
			l1 = new JLabel("Last name");
			panel_1.add(l1);
			panel_1.add(textField_1);
			l2 = new JLabel("Cell");
			panel_1.add(l2);
			panel_1.add(textField_2);
			l3 = new JLabel("Property Id");
			panel_1.add(l3);
			panel_1.add(textField_3);
			l4 = new JLabel("Street");
			panel_1.add(l4);
			panel_1.add(textField_4);
			l5 = new JLabel("City");
			panel_1.add(l5);
			panel_1.add(textField_5);
			l6 = new JLabel("Post Code");
			panel_1.add(l6);
			panel_1.add(textField_6);
			l7 = new JLabel("View Date");
			panel_1.add(l7);
			panel_1.add(textField_7);
			l8 = new JLabel("Comments");
			panel_1.add(l8);
			panel_1.add(textField_8);
			l9 = new JLabel("Client");
			panel_1.add(l9);

            clientListForUpdating = new JList<>(secondaryList);
            staffScroll = new JScrollPane();
            staffScroll.setViewportView(clientListForUpdating);

            clientListForUpdating.addListSelectionListener(e3 -> {
                if(switchCase == 5) {
                    Client selectedClient = clientListForUpdating.getSelectedValue();
                    if (selectedClient != null) {
                        System.out.println(selectedClient.getClientIdNum());
                        //selectedStaff2.getStaffNum()
                        //TODO use this variable for updating the staff number
                    }
                }
            });
            panel_1.add(staffScroll);
            panel_1.validate();
            panel_1.repaint();

            /////////////////////////////////////////////////
            if(list != null){
                list.removeAllElements();
            }
            if(secondaryList != null){
                secondaryList.removeAllElements();
                ArrayList<Client> newClientList;
                newClientList = client.getClientByID(0);
                for(int i = 0; i < newClientList.size(); i++){
                    secondaryList.addElement(newClientList.get(i));
                }
            }
            for(int i = 0; i < propViewList.size(); i++){
                if(!list.contains(propViewList.get(i))) {
                    list.addElement(propViewList.get(i));
                }
            }
            listForUpdating = new JList(list);

            //Activated by clicking an item from the list

            listForUpdating.addListSelectionListener(e2 -> {
                if(switchCase == 5) { //clients are selected
                    PropView selectedPropView = (PropView)listForUpdating.getSelectedValue();
                    if(selectedPropView  != null) {
                        textField.setText(selectedPropView.getFname());
                        textField_1.setText(selectedPropView.getLname());
                        textField_2.setText(selectedPropView.getPhone());
                        textField_3.setText(Integer.toString(selectedPropView.getPropertyId()));
                        textField_4.setText(selectedPropView.getStreet());
                        textField_5.setText(selectedPropView.getCity());
                        textField_6.setText(selectedPropView.getPostCode());
                        textField_7.setText(selectedPropView.getViewDate());
                        textField_8.setText(selectedPropView.getComments());

                        ArrayList<Client> newClientList;
                        secondaryList.removeAllElements();
                        newClientList = client.getClientByID(0);

                        //clientList
                        for (int i = 0; i <  newClientList.size(); i++) {
                            if (selectedPropView.getClientId() ==  newClientList.get(i).getClientIdNum()) {
                                secondaryList.addElement( newClientList.get(i));
                                break;
                            }
                        }
                        for (int i = 0; i < newClientList.size(); i++) {
                            if (selectedPropView.getClientId() ==  newClientList.get(i).getClientIdNum()) {
                                continue;
                            }
                            secondaryList.addElement(newClientList.get(i));
                        }
                        panel_1.remove(staffScroll);
                        staffScroll = new JScrollPane();
                        staffScroll.setViewportView(clientListForUpdating);
                        clientListForUpdating.setSelectedIndex(0);
                        panel_1.add(staffScroll);
                    }
                    panel_1.validate();
                    panel_1.repaint();
                }
            });

            /////////////////////////////////////////////////

            //revalidate Eastern panel
            revalidateEast();

			//Button listener needs more idiot-proofing, but it works as of right now.
			if(e.getSource() == btnSubmit) {
				boolean cleared = (textField.getText() == null) || (textField_1.getText() == null) ||
						(textField_2.getText() == null) || (textField_3.getText() == null) ||
						(textField_4.getText() == null) || (textField_5.getText() == null) ||
						(textField_6.getText() == null) ||(textField_7.getText() == null) ||
						(textField_8.getText() == null) || (textField_9.getText() == null);

				//right now it either crashes when trying to submit empty or it gives the dialog box each time. Needs work.
				//		if(cleared) {
				Input propviewinput = new Input("PROPVIEW");
				String fname = "'" + textField.getText() + "'";
				String lname = "'" + textField_1.getText() + "'";
				String cell = "'" + textField_2.getText() + "'";
				int propId = Integer.parseInt(textField_3.getText());
				String street = "'" + textField_4.getText() + "'";
				String city = "'" + textField_5.getText() + "'";
				String zip = "'" + textField_6.getText() + "'";
				String viewdate = "'" + textField_7.getText() + "'";
				String comments = "'" + textField_8.getText() + "'";
				int clientID = Integer.parseInt(textField_9.getText());
				propviewinput.addPropViewInfo(clientID, fname, lname, cell, propId, street, city, zip, viewdate, comments);
//				}
//				else {
//					JOptionPane.showMessageDialog(null, "Something was empty. \n Try again.");
//
//				}

			}
			textField.setText(null);
			textField_1.setText(null);
			textField_2.setText(null);
			textField_3.setText(null);
			textField_4.setText(null);
			textField_5.setText(null);
			textField_6.setText(null);
			textField_7.setText(null);
			textField_8.setText(null);
		}
		//under construction

		if(comboBox.getSelectedItem().equals("Leases")) {
            switchCase = 6;
			panel_1.removeAll();

			textField.setVisible(true);
			textField_1.setVisible(true);
			textField_2.setVisible(true);
			textField_3.setVisible(true);
			textField_4.setVisible(true);
			textField_5.setVisible(true);
			textField_6.setVisible(true);
			textField_7.setVisible(true);
			textField_8.setVisible(true);
			textField_9.setVisible(true);
			textField_10.setVisible(true);
			textField_11.setVisible(true);
			textField_12.setVisible(true);
			textField_13.setVisible(true);
			textField_14.setVisible(true);
			textField_15.setVisible(true);
			l1 = new JLabel("First Name");
			panel_1.add(l1);
			panel_1.add(textField_1);
			l2 = new JLabel("Last Name");
			panel_1.add(l2);
			panel_1.add(textField_2);
			l4 = new JLabel("Street");
			panel_1.add(l4);
			panel_1.add(textField_4);
			l5 = new JLabel("City");
			panel_1.add(l5);
			panel_1.add(textField_5);
			l6 = new JLabel("Post Code");
			panel_1.add(l6);
			panel_1.add(textField_6);
			l7 = new JLabel("Type");
			panel_1.add(l7);
			panel_1.add(textField_7);
			l8 = new JLabel("Rooms");
			panel_1.add(l8);
			panel_1.add(textField_8);
			l9 = new JLabel("Rent");
			panel_1.add(l9);
			panel_1.add(textField_9);
			l10 = new JLabel("Pay Method");
			panel_1.add(l10);
			panel_1.add(textField_10);
			l11 = new JLabel("Deposit");
			panel_1.add(l11);
			panel_1.add(textField_11);
			l12 = new JLabel("Paid Deposit");
			panel_1.add(l12);
			panel_1.add(textField_12);
			l13 = new JLabel("Start Date");
			panel_1.add(l13);
			panel_1.add(textField_13);
			l14 = new JLabel("End Date");
			panel_1.add(l14);
			panel_1.add(textField_14);
			l15 = new JLabel("Duration");
			panel_1.add(l15);
			panel_1.add(textField_15);
            l0 = new JLabel("Client");
            panel_1.add(l0);


            clientListForUpdating = new JList<>(secondaryList);
            staffScroll = new JScrollPane();
            staffScroll.setViewportView(clientListForUpdating);

            clientListForUpdating.addListSelectionListener(e3 -> {
                if(switchCase == 6) {
                    Client selectedClient = clientListForUpdating.getSelectedValue();
                    if (selectedClient != null) {
                        System.out.println(selectedClient.getClientIdNum());
                        //selectedStaff2.getStaffNum()
                        //TODO use this variable for updating the staff number
                    }
                }
            });
            panel_1.add(staffScroll);


            JLabel propLabel = new JLabel("Property");
            panel_1.add(propLabel);

            propertyListForUpdating = new JList<>(tertiaryList);
            secondaryScroll = new JScrollPane();
            secondaryScroll.setViewportView(propertyListForUpdating);

            propertyListForUpdating.addListSelectionListener(e3 -> {
                if(switchCase == 6) {
                    Property selectedProperty = propertyListForUpdating.getSelectedValue();
                    if (selectedProperty != null) {
                        System.out.println(selectedProperty.getPropertyId());
                        //selectedStaff2.getStaffNum()
                        //TODO use this variable for updating the staff number
                    }
                }
            });

            panel_1.add(secondaryScroll);
            panel_1.validate();
            panel_1.repaint();

            /////////////////////////////////////////////////
            if(list != null){
                list.removeAllElements();
            }
            if(secondaryList != null){
                secondaryList.removeAllElements();
                ArrayList<Client> newClientList;
                newClientList = client.getClientByID(0);
                for(int i = 0; i < newClientList.size(); i++){
                    secondaryList.addElement(newClientList.get(i));
                }
            }
            if(tertiaryList != null){
                tertiaryList.removeAllElements();
                ArrayList<Property> newPropertyList;
                newPropertyList = property.getPropertyByID(0);
                for(int i = 0; i < newPropertyList.size(); i++){
                    tertiaryList.addElement(newPropertyList.get(i));
                }
            }
            for(int i = 0; i < leaseList.size(); i++){
                if(!list.contains(leaseList.get(i))) {
                    list.addElement(leaseList.get(i));
                }
            }
            listForUpdating = new JList(list);

            //Activated by clicking an item from the list

            listForUpdating.addListSelectionListener(e2 -> {
                if(switchCase == 6) { //clients are selected
                    Lease selectedLease = (Lease)listForUpdating.getSelectedValue();
                    if(selectedLease != null) {
                            textField_1.setText(selectedLease.getFname());
                            textField_2.setText(selectedLease.getLname());
                        textField_4.setText(selectedLease.getStreet());
                        textField_5.setText(selectedLease.getCity());
                        textField_6.setText(selectedLease.getPostcode());
                        textField_7.setText(selectedLease.getType());
                        textField_8.setText(Integer.toString(selectedLease.getNumRooms()));
                        DecimalFormat df2 = new DecimalFormat(".##");
                        textField_9.setText(df2.format(selectedLease.getMonthlyRent()));
                        textField_10.setText(selectedLease.getPayMethod());

                        textField_11.setText(df2.format(selectedLease.getDeposit()));
                        boolean paidDeposit = false;
                        if(selectedLease.isDepositPaid() == 0){
                            paidDeposit = false;
                        }
                        if(selectedLease.isDepositPaid() == 1){
                            paidDeposit = true;
                        }
                        textField_12.setText(Boolean.toString(paidDeposit));
                        textField_13.setText(selectedLease.getRentStart());
                        textField_14.setText(selectedLease.getRentEnd());
                        textField_15.setText(selectedLease.getDuration());

                        ArrayList<Client> newClientList;
                        ArrayList<Property> newPropertyList;
                        //staffListForUpdating = new JList<>(supervisorList);
                        secondaryList.removeAllElements();
                        tertiaryList.removeAllElements();
                        newClientList = client.getClientByID(0);
                        newPropertyList = property.getPropertyByID(0);

                        //clientList
                        for (int i = 0; i <  newClientList.size(); i++) {
                            if (selectedLease.getClientId() ==  newClientList.get(i).getClientIdNum()) {
                                secondaryList.addElement( newClientList.get(i));
                                break;
                            }
                        }
                        for (int i = 0; i < newClientList.size(); i++) {
                            if (selectedLease.getClientId() ==  newClientList.get(i).getClientIdNum()) {
                                continue;
                            }
                            secondaryList.addElement(newClientList.get(i));
                        }

                        //propertyList
                        for (int i = 0; i <  newPropertyList.size(); i++) {
                            if (selectedLease.getPropertyId() ==  newPropertyList.get(i).getPropertyId()) {
                                tertiaryList.addElement(newPropertyList.get(i));
                                break;
                            }
                        }
                        for (int i = 0; i < newPropertyList.size(); i++) {
                            if (selectedLease.getPropertyId() ==  newPropertyList.get(i).getPropertyId()) {
                                continue;
                            }
                            tertiaryList.addElement(newPropertyList.get(i));
                        }

                        panel_1.remove(staffScroll);
                        panel_1.remove(propLabel);
                        panel_1.remove(secondaryScroll);
                        staffScroll = new JScrollPane();
                        staffScroll.setViewportView(clientListForUpdating);
                        secondaryScroll.setViewportView(propertyListForUpdating);
                        clientListForUpdating.setSelectedIndex(0);
                        propertyListForUpdating.setSelectedIndex(0);
                        panel_1.add(staffScroll);
                        panel_1.add(propLabel);
                        panel_1.add(secondaryScroll);
                    }
                    panel_1.validate();
                    panel_1.repaint();
                }
            });

            /////////////////////////////////////////////////

            //revalidate Eastern panel
            revalidateEast();

			//Button listener needs more idiot-proofing, but it works as of right now.
			if(e.getSource() == btnSubmit) {
				boolean cleared = (textField.getText() == null) || (textField_1.getText() == null) ||
						(textField_2.getText() == null) || (textField_3.getText() == null) ||
						(textField_4.getText() == null) || (textField_5.getText() == null) ||
						(textField_6.getText() == null) || (textField_7.getText() == null) ||
						(textField_10.getText() == null) || (textField_11.getText() == null)||
						(textField_12.getText() == null) || (textField_13.getText() == null)||
						(textField_14.getText() == null) || (textField_15.getText() == null);

				//right now it either crashes when trying to submit empty or it gives the dialog box each time. Needs work.
//				if(cleared) {
				Input leaseInput = new Input("LEASE");
				int clientId = Integer.parseInt(textField.getText());
				String fname = "'" + textField_1.getText() + "'";
				String lname = "'" + textField_2.getText() + "'";
				int propId = Integer.parseInt(textField_3.getText());
				String street = "'" + textField_4.getText() + "'";
				String city = "'" + textField_5.getText() + "'";
				String zip = "'" + textField_6.getText() + "'";
				String type = "'" + textField_7.getText() + "'";
				int rooms = Integer.parseInt(textField_8.getText());
				double rent = Double.parseDouble(textField_9.getText());
				String paymethod = "'" + textField_10.getText() + "'";
				double deposit = Double.parseDouble(textField_11.getText());
				int paidDeposit = Integer.parseInt(textField_12.getText());
				String startdate = "'" + textField_13.getText() + "'";
				String enddate = "'" + textField_14.getText() + "'";
				String duration = "'" + textField_15.getText() + "'";
				leaseInput.addLeaseInfo(clientId, fname, lname, propId, street, city, zip, type, rooms,
						rent, paymethod, deposit, paidDeposit, startdate, enddate, duration);
//				}
//				else {
//					JOptionPane.showMessageDialog(null, "Something was empty. \n Try again.");
//
//				}
			}
			textField.setText(null);
			textField_1.setText(null);
			textField_2.setText(null);
			textField_3.setText(null);
			textField_4.setText(null);
			textField_5.setText(null);
			textField_6.setText(null);
			textField_7.setText(null);
			textField_8.setText(null);
			textField_9.setText(null);
			textField_10.setText(null);
			textField_11.setText(null);
			textField_12.setText(null);
			textField_13.setText(null);
			textField_14.setText(null);
			textField_15.setText(null);

		}


	}

    public void revalidateEast(){
        //Revalidates main list when clicking on a new dropdown item
        if(panelEast != null) {
            panelEast.remove(scroll);
            panelEast.remove(display2);
            panelEast.remove(display3);
            scroll = new JScrollPane();
            scroll.setViewportView(listForUpdating);

            panelEast.add(scroll);
            //listForUpdating.setSelectedIndex(0);
            panelEast.add(display3);
            panelEast.validate();
            panelEast.repaint();
        }
    }

}