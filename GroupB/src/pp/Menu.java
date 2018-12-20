package pp;

import sql.Database;
import pp.Add;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.*;


public class Menu extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JButton button;
	private JPanel Panel;
	private JPanel Panel2;
	private JPanel Panel3;
	private JPanel addPanel;
	private JLabel label;
	private JLabel j;
	private String[] manChoices = {"View Managers", "View Supervisors", "View Agents", "View Employees Salaries",
			"View Clients", "View Property Owners", "View Properties", "View Property Viewings" };
	private String[] supChoices = { "View Supervisors", "View Agents", "View Renters", "View Property Owners",
			"View Properties", "View Property Viewings" };
	private String[] agentChoices = { "View Agents", "View Renters", "View Property Owners", "View Properties",
			"View Property Viewings" };

	private String[] addChoices = {"Add Client", "Add Property", "Add Staff", "Add Owners", "Add Property Viewing", "Add Lease"};
	private JComboBox<?> choices;
	private JComboBox<?> add;
	private JRadioButton noSelect;
	private JRadioButton firstName;
	private JRadioButton lastName;
	private JRadioButton staffId;
	private JRadioButton propOwnerId;
	private JRadioButton propId;
	private JRadioButton renterId;
	private JRadioButton phoneNum;
	private JRadioButton staffMemAdded;
	private JRadioButton city;
	private JRadioButton lowtoHigh;
	private JRadioButton hightoLow;
	private ButtonGroup filters;
	private JTextField search;
	private JTextField first;
	private JTextField last;
	private JTextField phone;
	private JTextField maxRent;
	private JTextField staffNum;
	private JTextField street;
	private JTextField Ccity;
	private JTextField zip;


	private JTextField prop;
	private JTextField staff;
	private JTextField owner;
	private JTextField propView;

	private JLabel s;
	private JLabel n;
	private JButton b;
	private JButton a;
	private JList l;
	private JScrollPane scroll;
	private JFrame f;

	Database db = new Database();
	Staff s1 = new Staff();
	PropertyOwner propertyOwner = new PropertyOwner();
	BusinessOwner businessOwner = new BusinessOwner();
	//ArrayList<Client> clientList = db.getClientByID(0);
	//ArrayList<Staff> staffList = s1.getStaffByID(0);
	//ArrayList<PropertyOwner> propOwnerList = propertyOwner.getPropOwnersByID(0);
	//ArrayList<BusinessOwner> busOwnerList = businessOwner.getBusinessOwnersByID(0);
	//ArrayList<PropView> propViewList = db.getPropView();
	//ArrayList<Lease> leaseList = db.getLeaseByClientId(0);
	DefaultListModel list = new DefaultListModel();

	public Menu(int cl) {
		if (cl == 2) {
			setTitle("Manager Menu");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setLayout(new GridLayout(3, 0));
			setSize(900, 700);
			ManagerMenu(cl);
			add(Panel, BorderLayout.NORTH);
			add(Panel2, BorderLayout.SOUTH);
			add(Panel3, BorderLayout.SOUTH);
			setVisible(true);
		}
		if (cl == 1) {
			setTitle("Supervisor Menu");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setLayout(new GridLayout(3, 0));
			setSize(900, 700);
			ManagerMenu(cl);
			add(Panel, BorderLayout.NORTH);
			add(Panel2, BorderLayout.SOUTH);
			add(Panel3, BorderLayout.SOUTH);

			setVisible(true);
		}
		if (cl == 0) {
			setTitle("Agent Menu");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setLayout(new GridLayout(3, 0));
			setSize(900, 700);
			ManagerMenu(cl);
			add(Panel, BorderLayout.NORTH);
			add(Panel2, BorderLayout.SOUTH);
			add(Panel3, BorderLayout.SOUTH);

			setVisible(true);

		}
	}


	public void ManagerMenu(int cl) {
		
		
		Panel = new JPanel();
		Panel2 = new JPanel();
		Panel3 = new JPanel();
		s = new JLabel("Search:");
		search = new JTextField(20);
		b = new JButton("Search");
		b.addActionListener(this);
		a = new JButton("Add Info");
		a.addActionListener(this);
		if(cl == 2) {
			label = new JLabel("Welcome Manager!");
			choices = new JComboBox<Object>(manChoices);
			choices.addActionListener(this);
			choices.setEditable(false);
			

		}
		if(cl == 1) {
			label = new JLabel("Welcome Supervisor!");
			choices = new JComboBox<Object>(supChoices);
			choices.addActionListener(this);
			choices.setEditable(false);
		}
		if(cl == 0) {
			label = new JLabel("Welcome Agent!");
			choices = new JComboBox<Object>(agentChoices);
			choices.addActionListener(this);
			choices.setEditable(false);
		}
		//a.setPreferredSize(new Dimension(50, 25));
		
		filters = new ButtonGroup();
		noSelect = new JRadioButton();
		firstName = new JRadioButton();
		lastName = new JRadioButton();
		staffId = new JRadioButton();
		propOwnerId = new JRadioButton();
		propId = new JRadioButton();
		phoneNum = new JRadioButton();
		staffMemAdded = new JRadioButton();
		renterId = new JRadioButton();
		city = new JRadioButton();
		lowtoHigh = new JRadioButton();
		hightoLow = new JRadioButton();
		filters.add(noSelect);
		filters.add(firstName);
		filters.add(lastName);
		filters.add(staffId);
		filters.add(propOwnerId);
		filters.add(propId);
		filters.add(phoneNum);
		filters.add(staffMemAdded);
		filters.add(renterId);
		filters.add(city);
		filters.add(lowtoHigh);
		filters.add(hightoLow);

		noSelect.setText("(No Select)");
		firstName.setText("First Name");
		lastName.setText("Last Name");
		staffId.setText("Id Number");
		propOwnerId.setText("Property Owner Id");
		propId.setText("Property Id");
		renterId.setText("Renter Id");
		phoneNum.setText("Phone Number");
		staffMemAdded.setText("Staff Member Added");
		city.setText("City");
		lowtoHigh.setText("Low to High");
		hightoLow.setText("High to Low");

		noSelect.setVisible(true);
		firstName.setVisible(false);
		lastName.setVisible(false);
		staffId.setVisible(false);
		propOwnerId.setVisible(false);
		propId.setVisible(false);
		renterId.setVisible(false);
		phoneNum.setVisible(false);
		staffMemAdded.setVisible(false);
		city.setVisible(false);
		lowtoHigh.setVisible(false);
		hightoLow.setVisible(false);

		Panel.add(label);
		Panel.add(choices);
		Panel.add(s);
		Panel.add(search);
		Panel.add(b);
		Panel.add(a);
		if(cl == 2) {
			JButton register = new JButton("Register New Staff");
			register.addActionListener(e -> {
				UserInterface userInterface = new UserInterface(true);
			});
			Panel.add(register);
		}
		Panel2.add(noSelect);
		Panel2.add(firstName);
		Panel2.add(lastName);
		Panel2.add(staffId);
		Panel2.add(propOwnerId);
		Panel2.add(propId);
		Panel2.add(phoneNum);
		Panel2.add(renterId);
		Panel2.add(city);
		Panel2.add(lowtoHigh);
		Panel2.add(hightoLow);
		l = new JList();
		l.setPrototypeCellValue("XXXXXXXXXXXXXXXXXXXX");
		l.setPreferredSize(new Dimension(200, 200));
		l.setVisibleRowCount(3);
		l.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		l.setLayoutOrientation(JList.VERTICAL);
		scroll = new JScrollPane();
		scroll.setViewportView(l);
		Panel3.add(scroll);
		Panel3.validate();
		Panel3.repaint();
		choices.setSelectedIndex(0);

	}


	//this action listener needs help
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == a) {
			Add window = new Add();
			setResizable(false);
			window.frame.setVisible(true);




		}

		//this if-statement will be copied and pasted into all of the choices. this was just for testing purposes.
		if (src == b) {
			/*	if(clientList.size()> 0){
				String test = clientList.get(0).getFname() + " " + clientList.get(0).getLname();
				String test2 = clientList.get(1).getFname() + " " + clientList.get(1).getLname();
				list.addElement(test);
				list.addElement(test2);

				l = new JList(list);
				Panel3.removeAll();
				scroll = new JScrollPane();
				scroll.setViewportView(l);
				Panel3.add(scroll);
				Panel3.validate();
				Panel3.repaint();
				}
			}
			if (choices.getSelectedItem().equals(null)) {
				firstName.setVisible(false);
				lastName.setVisible(false);
				staffId.setVisible(false);
				propOwnerId.setVisible(false);
				propId.setVisible(false);
				renterId.setVisible(false);
				phoneNum.setVisible(false);
				staffMemAdded.setVisible(false);
				city.setVisible(false);
				lowtoHigh.setVisible(false);
				hightoLow.setVisible(false);
			}*/

			//needs work
			if (choices.getSelectedItem().equals("View Managers")) {

				noSelect.setVisible(true);
				firstName.setVisible(true);
				lastName.setVisible(true);
				staffId.setVisible(true);

				list = new DefaultListModel();
				ArrayList<Staff> managers = new ArrayList();
				/*for(int i = 0; i < staffList.size(); i++){
					if(staffList.get(i).getPosition() == 2){
						managers.add(staffList.get(i));
						list.addElement(staffList.get(i));
					}
				}*/

				if(noSelect.isSelected()) {
					l = new JList(list);
					Panel3.removeAll();
					scroll = new JScrollPane();
					scroll.setViewportView(l);
					Panel3.add(scroll);
					Panel3.validate();
					Panel3.repaint();
				}
				if(firstName.isSelected()) {
					list = new DefaultListModel();
					Collections.sort(managers, ((m1,m2) -> m1.getFname().compareTo(m2.getFname())));
					for(int i = 0; i < managers.size(); i++){
						list.addElement(managers.get(i));
					}
					l = new JList(list);
					Panel3.removeAll();
					scroll = new JScrollPane();
					scroll.setViewportView(l);
					Panel3.add(scroll);
					Panel3.validate();
					Panel3.repaint();
				}
				if(lastName.isSelected()) {
					list = new DefaultListModel();
					Collections.sort(managers, ((m1,m2) -> m1.getLname().compareTo(m2.getLname())));
					for(int i = 0; i < managers.size(); i++){
						list.addElement(managers.get(i));
					}
					l = new JList(list);
					Panel3.removeAll();
					scroll = new JScrollPane();
					scroll.setViewportView(l);
					Panel3.add(scroll);
					Panel3.validate();
					Panel3.repaint();
				}
				if(staffId.isSelected()) {
					list = new DefaultListModel();
					Collections.sort(managers, ((m1,m2) -> m1.getStaffNum() - m2.getStaffNum() ));
					for(int i = 0; i < managers.size(); i++){
						list.addElement(managers.get(i));
					}
					l = new JList(list);
					Panel3.removeAll();
					scroll = new JScrollPane();
					scroll.setViewportView(l);
					Panel3.add(scroll);
					Panel3.validate();
					Panel3.repaint();
				}

			}

			//needs work
			if (choices.getSelectedItem().equals("View Supervisors")) {

				noSelect.setVisible(true);
				firstName.setVisible(true);
				lastName.setVisible(true);
				staffId.setVisible(true);

				list = new DefaultListModel();
				ArrayList<Staff> supervisors = new ArrayList();
				/*for(int i = 0; i < staffList.size(); i++){
					if(staffList.get(i).getPosition() == 1){
						supervisors.add(staffList.get(i));
						list.addElement(staffList.get(i));
					}
				}*/

				if(noSelect.isSelected()) {
					l = new JList(list);
					Panel3.removeAll();
					scroll = new JScrollPane();
					scroll.setViewportView(l);
					Panel3.add(scroll);
					Panel3.validate();
					Panel3.repaint();
				}
				if(firstName.isSelected()) {
					list = new DefaultListModel();
					Collections.sort(supervisors, ((m1,m2) -> m1.getFname().compareTo(m2.getFname())));
					for(int i = 0; i < supervisors.size(); i++){
						list.addElement(supervisors.get(i));
					}
					l = new JList(list);
					Panel3.removeAll();
					scroll = new JScrollPane();
					scroll.setViewportView(l);
					Panel3.add(scroll);
					Panel3.validate();
					Panel3.repaint();
				}
				if(lastName.isSelected()) {
					list = new DefaultListModel();
					Collections.sort(supervisors, ((m1,m2) -> m1.getLname().compareTo(m2.getLname())));
					for(int i = 0; i < supervisors.size(); i++){
						list.addElement(supervisors.get(i));
					}
					l = new JList(list);
					Panel3.removeAll();
					scroll = new JScrollPane();
					scroll.setViewportView(l);
					Panel3.add(scroll);
					Panel3.validate();
					Panel3.repaint();
				}
				if(staffId.isSelected()) {
					list = new DefaultListModel();
					Collections.sort(supervisors, ((m1,m2) -> m1.getStaffNum() - m2.getStaffNum() ));
					for(int i = 0; i < supervisors.size(); i++){
						list.addElement(supervisors.get(i));
					}
					l = new JList(list);
					Panel3.removeAll();
					scroll = new JScrollPane();
					scroll.setViewportView(l);
					Panel3.add(scroll);
					Panel3.validate();
					Panel3.repaint();
				}

			}
			//needs work
			if (choices.getSelectedItem().equals("View Agents")) {

				noSelect.setVisible(true);
				firstName.setVisible(true);
				lastName.setVisible(true);
				staffId.setVisible(true);

				list = new DefaultListModel();
				ArrayList<Staff> agents = new ArrayList();
				/*for(int i = 0; i < staffList.size(); i++){
					if(staffList.get(i).getPosition() == 0){
						agents.add(staffList.get(i));
						list.addElement(staffList.get(i));
					}
				}*/

				if(noSelect.isSelected()) {
					l = new JList(list);
					Panel3.removeAll();
					scroll = new JScrollPane();
					scroll.setViewportView(l);
					Panel3.add(scroll);
					Panel3.validate();
					Panel3.repaint();
				}
				if(firstName.isSelected()) {
					list = new DefaultListModel();
					Collections.sort(agents, ((m1,m2) -> m1.getFname().compareTo(m2.getFname())));
					for(int i = 0; i < agents.size(); i++){
						list.addElement(agents.get(i));
					}
					l = new JList(list);
					Panel3.removeAll();
					scroll = new JScrollPane();
					scroll.setViewportView(l);
					Panel3.add(scroll);
					Panel3.validate();
					Panel3.repaint();
				}
				if(lastName.isSelected()) {
					list = new DefaultListModel();
					Collections.sort(agents, ((m1,m2) -> m1.getLname().compareTo(m2.getLname())));
					for(int i = 0; i < agents.size(); i++){
						list.addElement(agents.get(i));
					}
					l = new JList(list);
					Panel3.removeAll();
					scroll = new JScrollPane();
					scroll.setViewportView(l);
					Panel3.add(scroll);
					Panel3.validate();
					Panel3.repaint();
				}
				if(staffId.isSelected()) {
					list = new DefaultListModel();
					Collections.sort(agents, ((m1,m2) -> m1.getStaffNum() - m2.getStaffNum() ));
					for(int i = 0; i < agents.size(); i++){
						list.addElement(agents.get(i));
					}
					l = new JList(list);
					Panel3.removeAll();
					scroll = new JScrollPane();
					scroll.setViewportView(l);
					Panel3.add(scroll);
					Panel3.validate();
					Panel3.repaint();
				}

			}
			//needs work
			if (choices.getSelectedItem().equals("View Employees Salaries")) {

				noSelect.setVisible(true);
				firstName.setVisible(true);
				lastName.setVisible(true);
				staffId.setVisible(true);
				lowtoHigh.setVisible(true);
				hightoLow.setVisible(true);

				list = new DefaultListModel();
				ArrayList<Staff> staff = new ArrayList();
				/*for(int i = 0; i < staffList.size(); i++){
					staff.add(staffList.get(i));
					list.addElement(staffList.get(i));
				}*/
				if(lowtoHigh.isSelected()) {

				}
				if(hightoLow.isSelected()) {

				}

				if(noSelect.isSelected()) {
					l = new JList(list);
					Panel3.removeAll();
					scroll = new JScrollPane();
					scroll.setViewportView(l);
					Panel3.add(scroll);
					Panel3.validate();
					Panel3.repaint();
				}
				if(firstName.isSelected()) {

				}
				if(lastName.isSelected()) {

				}
				if(staffId.isSelected()) {

				}

			}

			//needs work
			if (choices.getSelectedItem().equals("View Clients")) {


				noSelect.setVisible(true);
				firstName.setVisible(true);
				lastName.setVisible(true);
				renterId.setVisible(true);
				propOwnerId.setVisible(true);
				propId.setVisible(true);
				phoneNum.setVisible(true);

				list = new DefaultListModel();
				ArrayList<Client> clients = new ArrayList();
				/*for(int i = 0; i < clientList.size(); i++) {
					clients.add(clientList.get(i));
					list.addElement(clientList.get(i));
				}*/
				l = new JList(list);
				Panel3.removeAll();
				scroll = new JScrollPane();
				scroll.setViewportView(l);
				Panel3.add(scroll);
				Panel3.validate();
				Panel3.repaint();
				if(noSelect.isSelected()) {

				}
				if(firstName.isSelected()) {
					list = new DefaultListModel();
					Collections.sort(clients, ((m1,m2) -> m1.getFname().compareTo(m2.getFname())));
					for(int i = 0; i < clients.size(); i++){
						list.addElement(clients.get(i));
					}
					l = new JList(list);
					Panel3.removeAll();
					scroll = new JScrollPane();
					scroll.setViewportView(l);
					Panel3.add(scroll);
					Panel3.validate();
					Panel3.repaint();
				}
				if(lastName.isSelected()) {

				}
			}

			//needs work
			if (choices.getSelectedItem().equals("View Property Owners")) {

				noSelect.setVisible(true);
				firstName.setVisible(true);
				lastName.setVisible(true);
				propOwnerId.setVisible(true);
				propId.setVisible(true);
				phoneNum.setVisible(true);
				staffMemAdded.setVisible(true);

				if(noSelect.isSelected()) {

				}
				if(firstName.isSelected()) {

				}
				if(lastName.isSelected()) {

				}

			}
			//needs work
			if (choices.getSelectedItem().equals("View Properties")) {

				noSelect.setVisible(true);
				firstName.setVisible(true);
				lastName.setVisible(true);
				propOwnerId.setVisible(true);
				propId.setVisible(true);
				phoneNum.setVisible(true);
				city.setVisible(true);

				if(noSelect.isSelected()) {

				}
				if(firstName.isSelected()) {

				}
				if(lastName.isSelected()) {

				}

			}
			//needs work
			if (choices.getSelectedItem().equals("View Property Viewings")) {

				noSelect.setVisible(true);
				firstName.setVisible(true);
				lastName.setVisible(true);
				propOwnerId.setVisible(true);
				propId.setVisible(true);
				phoneNum.setVisible(true);
				city.setVisible(true);
				staffMemAdded.setVisible(true);

				if(noSelect.isSelected()) {

				}
				if(firstName.isSelected()) {

				}
				if(lastName.isSelected()) {

				}

			}
		}
    }
}
