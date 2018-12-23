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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

public class Menu extends JFrame implements ActionListener,MouseListener {

	private static final long serialVersionUID = 1L;
	private JButton button;
	private JPanel Panel;
	private JPanel Panel2;
	private JPanel Panel3;
	private JPanel addPanel;
	private JLabel label;
	private JLabel j;
	private int clearance;
	private String[] manChoices = { "View Managers", "View Supervisors", "View Agents", "View Employees",
			"View Clients", "View Property Owners", "View Properties", "View Property Viewings", "View Leases"};
	private String[] supChoices = { "View Supervisors", "View Agents", "View Renters", "View Property Owners",
			"View Properties", "View Property Viewings", "View Leases" };
	private String[] agentChoices = { "View Agents", "View Renters", "View Property Owners", "View Properties",
			"View Property Viewings", "View Leases"};

	private String[] addChoices = { "Add Client", "Add Property", "Add Staff", "Add Owners", "Add Property Viewing",
			"Add Lease" };
	private JComboBox<?> choices;
	private JComboBox<?> add;

	private JRadioButton firstName;
	private JRadioButton lastName;
	private JRadioButton staffId;
	private JRadioButton propOwnerId;
	private JRadioButton propId;
	private JRadioButton renterId;
	private JRadioButton staffMemAdded;
	private JRadioButton city;
	private JRadioButton lowtoHigh;
	private JRadioButton hightoLow;
	private JRadioButton rent;
	private JRadioButton startDate;
	private JRadioButton endDate;
	private JRadioButton duration;
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
	Client c1 = new Client();
	PropertyOwner p1 = new PropertyOwner();
	Property pr1 = new Property();
	PropView pv1 = new PropView();
	Lease l1 = new Lease();
	PropertyOwner propertyOwner = new PropertyOwner();
	BusinessOwner businessOwner = new BusinessOwner();
	// ArrayList<Client> clientList = db.getClientByID(0);
	ArrayList<Staff> staffList = s1.getStaffByID(0);
	ArrayList<PropertyOwner> propOwnerList = propertyOwner.getPropOwnersByID(0);
	ArrayList<BusinessOwner> busOwnerList = businessOwner.getBusinessOwnersByID(0);
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
		clearance = cl;
		Panel = new JPanel();
		Panel2 = new JPanel();
		Panel3 = new JPanel();
		s = new JLabel("Search:");
		search = new JTextField(20);
		//search.addActionListener(this);
		b = new JButton("Search");
		b.addActionListener(this);
		a = new JButton("Add Info");
		a.addActionListener(this);
		if (cl == 2) {
			label = new JLabel("Welcome Manager!");
			choices = new JComboBox<Object>(manChoices);
			choices.addActionListener(this);
			choices.setEditable(false);

		}
		if (cl == 1) {
			label = new JLabel("Welcome Supervisor!");
			choices = new JComboBox<Object>(supChoices);
			choices.addActionListener(this);
			choices.setEditable(false);
		}
		if (cl == 0) {
			label = new JLabel("Welcome Agent!");
			choices = new JComboBox<Object>(agentChoices);
			choices.addActionListener(this);
			choices.setEditable(false);
		}
		filters = new ButtonGroup();

		firstName = new JRadioButton();
		firstName.addActionListener(this);
		lastName = new JRadioButton();
		lastName.addActionListener(this);
		staffId = new JRadioButton();
		staffId.addActionListener(this);
		propOwnerId = new JRadioButton();
		propOwnerId.addActionListener(this);
		propId = new JRadioButton();
		propId.addActionListener(this);
		staffMemAdded = new JRadioButton();
		staffMemAdded.addActionListener(this);
		renterId = new JRadioButton();
		renterId.addActionListener(this);
		city = new JRadioButton();
		city.addActionListener(this);
		lowtoHigh = new JRadioButton();
		lowtoHigh.addActionListener(this);
		hightoLow = new JRadioButton();
		hightoLow.addActionListener(this);
		rent = new JRadioButton();
		rent.addActionListener(this);
		startDate = new JRadioButton();
		startDate.addActionListener(this);
		endDate = new JRadioButton();
		endDate.addActionListener(this);
		duration = new JRadioButton();
		duration.addActionListener(this);
		
		filters.add(rent);
		filters.add(startDate);
		filters.add(endDate);
		filters.add(duration);
		filters.add(staffId);
		filters.add(firstName);
		filters.add(lastName);
		filters.add(propOwnerId);
		filters.add(propId);
		filters.add(staffMemAdded);
		filters.add(renterId);
		filters.add(city);
		filters.add(lowtoHigh);
		filters.add(hightoLow);

		firstName.setText("First Name");
		lastName.setText("Last Name");
		staffId.setText("Id Number");
		propOwnerId.setText("Property Owner Id");
		propId.setText("Property Id");
		renterId.setText("Renter Id");
		staffMemAdded.setText("Staff Member Added");
		city.setText("City");
		lowtoHigh.setText("Low to High");
		hightoLow.setText("High to Low");

		firstName.setVisible(false);
		lastName.setVisible(false);
		staffId.setVisible(false);
		staffId.setSelected(true);
		propOwnerId.setVisible(false);
		propId.setVisible(false);
		renterId.setVisible(false);
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
		if (cl == 2) {
			JButton register = new JButton("Register New Staff");
			register.addActionListener(e -> {
				UserInterface userInterface = new UserInterface(true);
			});
			Panel.add(register);
		}

		Panel2.add(firstName);
		Panel2.add(lastName);
		Panel2.add(staffId);
		Panel2.add(propOwnerId);
		Panel2.add(propId);
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

	// this action listener needs help
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		if (src == a) {
			Add window = new Add(clearance);
			setResizable(false);
			window.frame.setVisible(true);

		}


		// needs work
		if (choices.getSelectedItem().equals("View Managers")) {

			rent.setVisible(false);
			duration.setVisible(false);
			startDate.setVisible(false);
			endDate.setVisible(false);
			staffMemAdded.setVisible(false);
			renterId.setVisible(false);
			propOwnerId.setVisible(false);
			propId.setVisible(false);
			staffId.setVisible(false);
			lowtoHigh.setVisible(false);
			hightoLow.setVisible(false);
			city.setVisible(false);
			firstName.setVisible(true);
			lastName.setVisible(true);
			staffId.setVisible(true);

			list = new DefaultListModel();
			ArrayList<Staff> managers = new ArrayList();
			for(int i = 0; i < staffList.size(); i++){
				if(staffList.get(i).getPosition() == 2){
					if(!list.contains(staffList.get(i))) {
						managers.add(staffList.get(i));
						list.addElement(staffList.get(i));
					}
				}
			}
			l = new JList(list);
			l.addMouseListener(this);
			Panel3.removeAll();
			scroll = new JScrollPane();
			scroll.setViewportView(l);
			Panel3.add(scroll);
			Panel3.validate();
			Panel3.repaint();

			if (firstName.isSelected()) {
				list = new DefaultListModel();
				Collections.sort(managers, ((m1, m2) -> m1.getFname().compareTo(m2.getFname())));
				for (int i = 0; i < managers.size(); i++) {
					list.addElement(managers.get(i));
				}
				l = new JList(list);
				l.addMouseListener(this);
				Panel3.removeAll();
				scroll = new JScrollPane();
				scroll.setViewportView(l);
				Panel3.add(scroll);
				Panel3.validate();
				Panel3.repaint();
				if(src == b) {
					list = new DefaultListModel();
					staffList = s1.getStaffByID(0);
					for (int i = 0; i < managers.size(); i++) {
						if(managers.get(i).getFname().contains(search.getText())) {
							list.addElement(managers.get(i));
						}
					}
					l = new JList(list);
					l.addMouseListener(this);
					Panel3.removeAll();
					scroll = new JScrollPane();
					scroll.setViewportView(l);
					Panel3.add(scroll);
					Panel3.validate();
					Panel3.repaint();
				}
			}
			if (lastName.isSelected()) {
				list = new DefaultListModel();
				Collections.sort(managers, ((m1, m2) -> m1.getLname().compareTo(m2.getLname())));
				for (int i = 0; i < managers.size(); i++) {
					list.addElement(managers.get(i));
				}
				l = new JList(list);
				l.addMouseListener(this);
				Panel3.removeAll();
				scroll = new JScrollPane();
				scroll.setViewportView(l);
				Panel3.add(scroll);
				Panel3.validate();
				Panel3.repaint();
				if(src == b) {
					staffList = s1.getStaffByID(0);
					list = new DefaultListModel();
					for (int i = 0; i < managers.size(); i++) {
						if(managers.get(i).getLname().contains(search.getText())) {
							list.addElement(managers.get(i));
						}
					}
					l = new JList(list);
					l.addMouseListener(this);
					Panel3.removeAll();
					scroll = new JScrollPane();
					scroll.setViewportView(l);
					Panel3.add(scroll);
					Panel3.validate();
					Panel3.repaint();
				}
			}
			if (staffId.isSelected()) {
				list = new DefaultListModel();
				Collections.sort(managers, ((m1, m2) -> m1.getStaffNum() - m2.getStaffNum()));
				for (int i = 0; i < managers.size(); i++) {
					list.addElement(managers.get(i));
				}
				l = new JList(list);
				l.addMouseListener(this);
				Panel3.removeAll();
				scroll = new JScrollPane();
				scroll.setViewportView(l);
				Panel3.add(scroll);
				Panel3.validate();
				Panel3.repaint();

			}

		}

		// needs work
		if (choices.getSelectedItem().equals("View Supervisors")) {

			rent.setVisible(false);
			duration.setVisible(false);
			startDate.setVisible(false);
			endDate.setVisible(false);
			staffMemAdded.setVisible(false);
			renterId.setVisible(false);
			propOwnerId.setVisible(false);
			propId.setVisible(false);
			staffId.setVisible(false);
			lowtoHigh.setVisible(false);
			city.setVisible(false);
			hightoLow.setVisible(false);
			firstName.setVisible(true);
			lastName.setVisible(true);
			staffId.setVisible(true);

			staffList = s1.getStaffByID(0);
			list = new DefaultListModel();
			ArrayList<Staff> supervisors = new ArrayList();
			for(int i = 0; i < staffList.size(); i++){
				if(staffList.get(i).getPosition() == 1){
					if(!list.contains(staffList.get(i))) {
						supervisors.add(staffList.get(i));
						list.addElement(staffList.get(i));
					}

				}
			}
			l = new JList(list);
			l.addMouseListener(this);
			Panel3.removeAll();
			scroll = new JScrollPane();
			scroll.setViewportView(l);
			Panel3.add(scroll);
			Panel3.validate();
			Panel3.repaint();

			if (firstName.isSelected()) {
				list = new DefaultListModel();
				Collections.sort(supervisors, ((m1, m2) -> m1.getFname().compareTo(m2.getFname())));
				for (int i = 0; i < supervisors.size(); i++) {
					list.addElement(supervisors.get(i));
				}
				l = new JList(list);
				l.addMouseListener(this);
				Panel3.removeAll();
				scroll = new JScrollPane();
				scroll.setViewportView(l);
				Panel3.add(scroll);
				Panel3.validate();
				Panel3.repaint();
				if(src == b) {
					list = new DefaultListModel();
					for (int i = 0; i < supervisors.size(); i++) {
						if(supervisors.get(i).getFname().contains(search.getText())) {
							list.addElement(supervisors.get(i));
						}
					}
					l = new JList(list);
					l.addMouseListener(this);
					Panel3.removeAll();
					scroll = new JScrollPane();
					scroll.setViewportView(l);
					Panel3.add(scroll);
					Panel3.validate();
					Panel3.repaint();
				}
			}
			if (lastName.isSelected()) {
				list = new DefaultListModel();
				Collections.sort(supervisors, ((m1, m2) -> m1.getLname().compareTo(m2.getLname())));
				for (int i = 0; i < supervisors.size(); i++) {
					list.addElement(supervisors.get(i));
				}
				l = new JList(list);
				l.addMouseListener(this);
				Panel3.removeAll();
				scroll = new JScrollPane();
				scroll.setViewportView(l);
				Panel3.add(scroll);
				Panel3.validate();
				Panel3.repaint();
				if(src == b) {
					list = new DefaultListModel();
					for (int i = 0; i < supervisors.size(); i++) {
						if(supervisors.get(i).getLname().contains(search.getText())) {
							list.addElement(supervisors.get(i));
						}
					}
					l = new JList(list);
					l.addMouseListener(this);
					Panel3.removeAll();
					scroll = new JScrollPane();
					scroll.setViewportView(l);
					Panel3.add(scroll);
					Panel3.validate();
					Panel3.repaint();
				}
			}
			if (staffId.isSelected()) {
				list = new DefaultListModel();
				Collections.sort(supervisors, ((m1, m2) -> m1.getStaffNum() - m2.getStaffNum()));
				for (int i = 0; i < supervisors.size(); i++) {
					list.addElement(supervisors.get(i));
				}
				l = new JList(list);
				l.addMouseListener(this);
				Panel3.removeAll();
				scroll = new JScrollPane();
				scroll.setViewportView(l);
				Panel3.add(scroll);
				Panel3.validate();
				Panel3.repaint();
			}

		}
		// needs work
		if (choices.getSelectedItem().equals("View Agents")) {

			rent.setVisible(false);
			duration.setVisible(false);
			startDate.setVisible(false);
			endDate.setVisible(false);
			staffMemAdded.setVisible(false);
			renterId.setVisible(false);
			propOwnerId.setVisible(false);
			propId.setVisible(false);
			city.setVisible(false);
			staffId.setVisible(true);
			lowtoHigh.setVisible(false);
			hightoLow.setVisible(false);
			firstName.setVisible(true);
			lastName.setVisible(true);

			staffList = s1.getStaffByID(0);
			list = new DefaultListModel();
			ArrayList<Staff> agents = new ArrayList();
			for(int i = 0; i < staffList.size(); i++){
				if(staffList.get(i).getPosition() == 0){
					if(!list.contains(staffList.get(i))) {
						agents.add(staffList.get(i));
						list.addElement(staffList.get(i));
					}

				}
			}
			l = new JList(list);
			l.addMouseListener(this);
			Panel3.removeAll();
			scroll = new JScrollPane();
			scroll.setViewportView(l);
			Panel3.add(scroll);
			Panel3.validate();
			Panel3.repaint();

			if (firstName.isSelected()) {
				list = new DefaultListModel();
				Collections.sort(agents, ((m1, m2) -> m1.getFname().compareTo(m2.getFname())));
				for (int i = 0; i < agents.size(); i++) {
					list.addElement(agents.get(i));
				}
				l = new JList(list);
				l.addMouseListener(this);
				Panel3.removeAll();
				scroll = new JScrollPane();
				scroll.setViewportView(l);
				Panel3.add(scroll);
				Panel3.validate();
				Panel3.repaint();
				if(src == b) {
					list = new DefaultListModel();
					for (int i = 0; i < agents.size(); i++) {
						if(agents.get(i).getFname().contains(search.getText())) {
							list.addElement(agents.get(i));
						}
					}
					l = new JList(list);
					l.addMouseListener(this);
					Panel3.removeAll();
					scroll = new JScrollPane();
					scroll.setViewportView(l);
					Panel3.add(scroll);
					Panel3.validate();
					Panel3.repaint();
				}
			}
			if (lastName.isSelected()) {
				list = new DefaultListModel();
				Collections.sort(agents, ((m1, m2) -> m1.getLname().compareTo(m2.getLname())));
				for (int i = 0; i < agents.size(); i++) {
					list.addElement(agents.get(i));
				}
				l = new JList(list);
				l.addMouseListener(this);
				Panel3.removeAll();
				scroll = new JScrollPane();
				scroll.setViewportView(l);
				Panel3.add(scroll);
				Panel3.validate();
				Panel3.repaint();
				if(src == b) {
					list = new DefaultListModel();
					for (int i = 0; i < agents.size(); i++) {
						if(agents.get(i).getLname().contains(search.getText())) {
							list.addElement(agents.get(i));
						}
					}
					l = new JList(list);
					l.addMouseListener(this);
					Panel3.removeAll();
					scroll = new JScrollPane();
					scroll.setViewportView(l);
					Panel3.add(scroll);
					Panel3.validate();
					Panel3.repaint();
				}
			}
			if (staffId.isSelected()) {
				list = new DefaultListModel();
				Collections.sort(agents, ((m1, m2) -> m1.getStaffNum() - m2.getStaffNum()));
				for (int i = 0; i < agents.size(); i++) {
					list.addElement(agents.get(i));
				}
				l = new JList(list);
				l.addMouseListener(this);
				Panel3.removeAll();
				scroll = new JScrollPane();
				scroll.setViewportView(l);
				Panel3.add(scroll);
				Panel3.validate();
				Panel3.repaint();
			}

		}
		// needs work
		if (choices.getSelectedItem().equals("View Employees")) {

			rent.setVisible(false);
			duration.setVisible(false);
			startDate.setVisible(false);
			endDate.setVisible(false);
			staffMemAdded.setVisible(false);
			renterId.setVisible(false);
			propOwnerId.setVisible(false);
			propId.setVisible(false);
			city.setVisible(false);
			firstName.setVisible(true);
			lastName.setVisible(true);
			staffId.setVisible(true);
			lowtoHigh.setVisible(true);
			hightoLow.setVisible(true);

			staffList = s1.getStaffByID(0);
			list = new DefaultListModel();
			ArrayList<Staff> staff = new ArrayList();
			for(int i = 0; i < staffList.size(); i++){
				staff.add(staffList.get(i));
				list.addElement(staffList.get(i));
			}
			l = new JList(list);
			l.addMouseListener(this);
			Panel3.removeAll();
			scroll = new JScrollPane();
			scroll.setViewportView(l);
			Panel3.add(scroll);
			Panel3.validate();
			Panel3.repaint();
			
			if(lowtoHigh.isSelected()) {
				list = new DefaultListModel();
				Collections.sort(staff, ((m1,m2) -> Double.compare(m1.getSalary(),m2.getSalary()) ));
				for(int i = 0; i < staff.size(); i++){
					list.addElement(staff.get(i));
				}
				l = new JList(list);
				l.addMouseListener(this);
				Panel3.removeAll();
				scroll = new JScrollPane();
				scroll.setViewportView(l);
				Panel3.add(scroll);
				Panel3.validate();
				Panel3.repaint();
				if(src == b) {
					list = new DefaultListModel();
					for (int i = 0; i < staff.size(); i++) {
						if(staff.get(i).getFname().contains(search.getText())) {
							list.addElement(staff.get(i));
						}
						if(staff.get(i).getLname().contains(search.getText())) {
							list.addElement(staff.get(i));
						}
					}
					l = new JList(list);
					l.addMouseListener(this);
					Panel3.removeAll();
					scroll = new JScrollPane();
					scroll.setViewportView(l);
					Panel3.add(scroll);
					Panel3.validate();
					Panel3.repaint();
				}
			}
			if (hightoLow.isSelected()) {
				list = new DefaultListModel();
				Collections.sort(staff, ((m1,m2) -> Double.compare(m2.getSalary(),m1.getSalary()) ));
				for(int i = 0; i < staff.size(); i++){
					list.addElement(staff.get(i));
				}
				l = new JList(list);
				l.addMouseListener(this);
				Panel3.removeAll();
				scroll = new JScrollPane();
				scroll.setViewportView(l);
				Panel3.add(scroll);
				Panel3.validate();
				Panel3.repaint();
				if(src == b) {
					list = new DefaultListModel();
					for (int i = 0; i < staff.size(); i++) {
						if(staff.get(i).getFname().contains(search.getText())) {
							list.addElement(staff.get(i));
						}
						if(staff.get(i).getLname().contains(search.getText())) {
							list.addElement(staff.get(i));
						}
					}
					l = new JList(list);
					l.addMouseListener(this);
					Panel3.removeAll();
					scroll = new JScrollPane();
					scroll.setViewportView(l);
					Panel3.add(scroll);
					Panel3.validate();
					Panel3.repaint();
				}
			}

			if (firstName.isSelected()) {
				list = new DefaultListModel();
				Collections.sort(staff, ((m1, m2) -> m1.getFname().compareTo(m2.getFname())));
				for (int i = 0; i < staff.size(); i++) {
					list.addElement(staff.get(i));
				}
				l = new JList(list);
				l.addMouseListener(this);
				Panel3.removeAll();
				scroll = new JScrollPane();
				scroll.setViewportView(l);
				Panel3.add(scroll);
				Panel3.validate();
				Panel3.repaint();
				if(src == b) {
					list = new DefaultListModel();
					for (int i = 0; i < staff.size(); i++) {
						if(staff.get(i).getFname().contains(search.getText())) {
							list.addElement(staff.get(i));
						}
					}
					l = new JList(list);
					l.addMouseListener(this);
					Panel3.removeAll();
					scroll = new JScrollPane();
					scroll.setViewportView(l);
					Panel3.add(scroll);
					Panel3.validate();
					Panel3.repaint();
				}
			}
			if (lastName.isSelected()) {
				list = new DefaultListModel();
				Collections.sort(staff, ((m1, m2) -> m1.getLname().compareTo(m2.getLname())));
				for (int i = 0; i < staff.size(); i++) {
					list.addElement(staff.get(i));
				}
				l = new JList(list);
				l.addMouseListener(this);
				Panel3.removeAll();
				scroll = new JScrollPane();
				scroll.setViewportView(l);
				Panel3.add(scroll);
				Panel3.validate();
				Panel3.repaint();
				if(src == b) {
					list = new DefaultListModel();
					for (int i = 0; i < staff.size(); i++) {
						if(staff.get(i).getLname().contains(search.getText())) {
							list.addElement(staff.get(i));
						}
					}
					l = new JList(list);
					l.addMouseListener(this);
					Panel3.removeAll();
					scroll = new JScrollPane();
					scroll.setViewportView(l);
					Panel3.add(scroll);
					Panel3.validate();
					Panel3.repaint();
				}
			}
			if (staffId.isSelected()) {
				list = new DefaultListModel();
				
				Collections.sort(staff, ((m1, m2) -> m1.getStaffNum() - m2.getStaffNum()));
				for (int i = 0; i < staff.size(); i++) {
					list.addElement(staff.get(i));
				}
				l = new JList(list);
				l.addMouseListener(this);
				Panel3.removeAll();
				scroll = new JScrollPane();
				scroll.setViewportView(l);
				Panel3.add(scroll);
				Panel3.validate();
				Panel3.repaint();
				if(src == b) {
					list = new DefaultListModel();
					for (int i = 0; i < staff.size(); i++) {
						if(staff.get(i).getFname().contains(search.getText())) {
							list.addElement(staff.get(i));
						}
						if(staff.get(i).getLname().contains(search.getText())) {
							list.addElement(staff.get(i));
						}
					}
					l = new JList(list);
					l.addMouseListener(this);
					Panel3.removeAll();
					scroll = new JScrollPane();
					scroll.setViewportView(l);
					Panel3.add(scroll);
					Panel3.validate();
					Panel3.repaint();
				}
			}

		}
		

		if (choices.getSelectedItem().equals("View Clients")) {
			rent.setVisible(false);
			duration.setVisible(false);
			startDate.setVisible(false);
			endDate.setVisible(false);
			staffMemAdded.setVisible(true);
			staffId.setVisible(false);
			lowtoHigh.setVisible(false);
			hightoLow.setVisible(false);
			city.setVisible(false);
			firstName.setVisible(true);
			lastName.setVisible(true);
			renterId.setVisible(true);
			propOwnerId.setVisible(false);
			propId.setVisible(false);

			ArrayList<Client> clients = new ArrayList();
			clients = c1.getClientByID(0);
			list = new DefaultListModel();
			l = new JList(list);
			Panel3.removeAll();
			scroll = new JScrollPane();
			scroll.setViewportView(l);
			Panel3.add(scroll);
			Panel3.validate();
			Panel3.repaint();
			/*
			 * for(int i = 0; i < clientList.size(); i++) { clients.add(clientList.get(i));
			 * list.addElement(clientList.get(i)); }
			 */
			if (firstName.isSelected()) {
				list = new DefaultListModel();
				Collections.sort(clients, ((m1, m2) -> m1.getFname().compareTo(m2.getFname())));
				for (int i = 0; i < clients.size(); i++) {
					list.addElement(clients.get(i));
				}
				l = new JList(list);
				l.addMouseListener(this);
				Panel3.removeAll();
				scroll = new JScrollPane();
				scroll.setViewportView(l);
				Panel3.add(scroll);
				Panel3.validate();
				Panel3.repaint();
			}
			if (lastName.isSelected()) {
				list = new DefaultListModel();
				Collections.sort(clients, ((m1,m2) -> m1.getLname().compareTo(m2.getLname())));
				for(int i = 0; i < clients.size(); i++){
					list.addElement(clients.get(i));
				}
				l = new JList(list);
				l.addMouseListener(this);
				Panel3.removeAll();
				scroll = new JScrollPane();
				scroll.setViewportView(l);
				Panel3.add(scroll);
				Panel3.validate();
				Panel3.repaint();
			}
			if (renterId.isSelected()){
				list = new DefaultListModel();
				Collections.sort(clients, ((m1,m2) -> m1.getClientIdNum() - m2.getIdNum()));
				for(int i = 0; i < clients.size(); i++){
					list.addElement(clients.get(i));
				}
				l = new JList(list);
				l.addMouseListener(this);
				Panel3.removeAll();
				scroll = new JScrollPane();
				scroll.setViewportView(l);
				Panel3.add(scroll);
				Panel3.validate();
				Panel3.repaint();
			}
			if (staffMemAdded.isSelected()){
				list = new DefaultListModel();
				Collections.sort(clients, ((m1,m2) -> m1.getStaffId() - m2.getStaffId()));
				for(int i = 0; i < clients.size(); i++){
					list.addElement(clients.get(i));
				}
				l = new JList(list);
				l.addMouseListener(this);
				Panel3.removeAll();
				scroll = new JScrollPane();
				scroll.setViewportView(l);
				Panel3.add(scroll);
				Panel3.validate();
				Panel3.repaint();
			}
		}

		// needs work
		if (choices.getSelectedItem().equals("View Property Owners")) {
			
			rent.setVisible(false);
			duration.setVisible(false);
			startDate.setVisible(false);
			endDate.setVisible(false);
			renterId.setVisible(false);
			staffId.setVisible(false);
			lowtoHigh.setVisible(false);
			hightoLow.setVisible(false);
			city.setVisible(false);
			firstName.setVisible(true);
			lastName.setVisible(true);
			propOwnerId.setVisible(true);
			propId.setVisible(true);
			staffMemAdded.setVisible(true);
			
			ArrayList<PropertyOwner> Powners = new ArrayList();
			Powners = p1.getPropOwnersByID(0);
			for (int i = 0; i < Powners.size(); i++) {
				list.addElement(Powners.get(i));
			}
			list = new DefaultListModel();
			l = new JList(list);
			Panel3.removeAll();
			scroll = new JScrollPane();
			scroll.setViewportView(l);
			Panel3.add(scroll);
			Panel3.validate();
			Panel3.repaint();
			
			if (firstName.isSelected()) {
				list = new DefaultListModel();
				Collections.sort(Powners, ((m1, m2) -> m1.getFname().compareTo(m2.getFname())));
				for (int i = 0; i < Powners.size(); i++) {
					list.addElement(Powners.get(i));
				}
				l = new JList(list);
				l.addMouseListener(this);
				Panel3.removeAll();
				scroll = new JScrollPane();
				scroll.setViewportView(l);
				Panel3.add(scroll);
				Panel3.validate();
				Panel3.repaint();
			}
			if (lastName.isSelected()) {
				list = new DefaultListModel();
				Collections.sort(Powners, ((m1, m2) -> m1.getLname().compareTo(m2.getLname())));
				for (int i = 0; i < Powners.size(); i++) {
					list.addElement(Powners.get(i));
				}
				l = new JList(list);
				l.addMouseListener(this);
				Panel3.removeAll();
				scroll = new JScrollPane();
				scroll.setViewportView(l);
				Panel3.add(scroll);
				Panel3.validate();
				Panel3.repaint();
			}
			if (propOwnerId.isSelected()){
				list = new DefaultListModel();
				Collections.sort(Powners, ((m1,m2) -> m1.getOwnerNum() - m2.getOwnerNum()));
				for(int i = 0; i < Powners.size(); i++){
					list.addElement(Powners.get(i));
				}
				l = new JList(list);
				l.addMouseListener(this);
				Panel3.removeAll();
				scroll = new JScrollPane();
				scroll.setViewportView(l);
				Panel3.add(scroll);
				Panel3.validate();
				Panel3.repaint();
			}
			if(staffMemAdded.isSelected()){
				list = new DefaultListModel();
				Collections.sort(Powners, ((m1,m2) -> m1.getStaffId() - m2.getStaffId()));
				for(int i = 0; i < Powners.size(); i++){
					list.addElement(Powners.get(i));
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
		// needs work
		if (choices.getSelectedItem().equals("View Properties")) {

			rent.setVisible(false);
			duration.setVisible(false);
			startDate.setVisible(false);
			endDate.setVisible(false);
			staffMemAdded.setVisible(false);
			renterId.setVisible(false);
			propOwnerId.setVisible(false);
			propId.setVisible(false);
			staffId.setVisible(false);
			lowtoHigh.setVisible(false);
			hightoLow.setVisible(false);
			firstName.setVisible(false);
			lastName.setVisible(false);
			propOwnerId.setVisible(true);
			propId.setVisible(true);
			city.setVisible(true);

			ArrayList<Property> prop = new ArrayList<Property>();
			prop = pr1.getPropertyByID();
			list = new DefaultListModel();
			l = new JList(list);
			for(int i = 0; i < prop.size(); i++){
				list.addElement(prop.get(i));
			}
			Panel3.removeAll();
			scroll = new JScrollPane();
			scroll.setViewportView(l);
			Panel3.add(scroll);
			Panel3.validate();
			Panel3.repaint();
			if (propOwnerId.isSelected()) {
				list = new DefaultListModel();
				Collections.sort(prop, ((m1,m2) -> m1.getOwner().compareTo(m2.getOwner())));
				for(int i = 0; i < prop.size(); i++){
					list.addElement(prop.get(i));
				}
				l = new JList(list);
				l.addMouseListener(this);
				Panel3.removeAll();
				scroll = new JScrollPane();
				scroll.setViewportView(l);
				Panel3.add(scroll);
				Panel3.validate();
				Panel3.repaint();
			}
			if (propId.isSelected()) {
				list = new DefaultListModel();
				Collections.sort(prop, ((m1,m2) -> m1.getPropertyId() - m2.getPropertyId()));
				for(int i = 0; i < prop.size(); i++){
					list.addElement(prop.get(i));
				}
				l = new JList(list);
				l.addMouseListener(this);
				Panel3.removeAll();
				scroll = new JScrollPane();
				scroll.setViewportView(l);
				Panel3.add(scroll);
				Panel3.validate();
				Panel3.repaint();
			}
			if(city.isSelected()){
				list = new DefaultListModel();
				Collections.sort(prop, ((m1, m2) -> m1.getCity().compareTo(m2.getCity())));
				for (int i = 0; i < prop.size(); i++) {
					list.addElement(prop.get(i));
				}
				l = new JList(list);
				l.addMouseListener(this);
				Panel3.removeAll();
				scroll = new JScrollPane();
				scroll.setViewportView(l);
				Panel3.add(scroll);
				Panel3.validate();
				Panel3.repaint();
			}

		}
		// needs work
		if (choices.getSelectedItem().equals("View Property Viewings")) {

			rent.setVisible(false);
			duration.setVisible(false);
			startDate.setVisible(false);
			endDate.setVisible(false);
			renterId.setVisible(false);
			staffId.setVisible(false);
			lowtoHigh.setVisible(false);
			hightoLow.setVisible(false);
			firstName.setVisible(true);
			lastName.setVisible(false);
			propOwnerId.setVisible(true);
			propId.setVisible(true);
			city.setVisible(true);
			staffMemAdded.setVisible(true);

			ArrayList<PropView> view = new ArrayList<PropView>(pv1.getPropView(0));
			for (int i = 0; i < view.size(); i++) {
				list.addElement(view.get(i));
			}
			list = new DefaultListModel();
			l = new JList(list);
			Panel3.removeAll();
			scroll = new JScrollPane();
			scroll.setViewportView(l);
			Panel3.add(scroll);
			Panel3.validate();
			Panel3.repaint();
			if (firstName.isSelected()) {
				list = new DefaultListModel();
				Collections.sort(view, ((m1, m2) -> m1.getCID() - m2.getCID()));
				for (int i = 0; i < view.size(); i++) {
					list.addElement(view.get(i));
				}
				l = new JList(list);
				l.addMouseListener(this);
				Panel3.removeAll();
				scroll = new JScrollPane();
				scroll.setViewportView(l);
				Panel3.add(scroll);
				Panel3.validate();
				Panel3.repaint();
			}
			if (propOwnerId.isSelected()){
				list = new DefaultListModel();
				Collections.sort(view, ((m1, m2) -> pr1.getPropertyByID(m1.getPID()).get(0).getOID() - pr1.getPropertyByID(m2.getPID()).get(0).getOID()));
				for(int i = 0; i < view.size(); i++){
					list.addElement(view.get(i));
				}
				l = new JList(list);
				l.addMouseListener(this);
				Panel3.removeAll();
				scroll = new JScrollPane();
				scroll.setViewportView(l);
				Panel3.add(scroll);
				Panel3.validate();
				Panel3.repaint();
				
			}
			if(propId.isSelected()){
				list = new DefaultListModel();
				Collections.sort(view, ((m1, m2) -> m1.getPID() - m2.getPID()));
				for (int i = 0; i < view.size(); i++) {
					list.addElement(view.get(i));
				}
				l = new JList(list);
				l.addMouseListener(this);
				Panel3.removeAll();
				scroll = new JScrollPane();
				scroll.setViewportView(l);
				Panel3.add(scroll);
				Panel3.validate();
				Panel3.repaint();
			}
			if(city.isSelected()){
				list = new DefaultListModel();
				Collections.sort(view, ((m1, m2) -> m1.getCity().compareTo(m2.getCity())));
				for (int i = 0; i < view.size(); i++) {
					list.addElement(view.get(i));
				}
				l = new JList(list);
				l.addMouseListener(this);
				Panel3.removeAll();
				scroll = new JScrollPane();
				scroll.setViewportView(l);
				Panel3.add(scroll);
				Panel3.validate();
				Panel3.repaint();
			}
			if(staffMemAdded.isSelected()){
				list = new DefaultListModel();
				Collections.sort(view, ((m1, m2) -> m1.getMember().getStaffNum() - m2.getMember().getStaffNum()));
				for(int i = 0; i < view.size(); i++){
					list.addElement(view.get(i));
				}
				l = new JList(list);
				l.addMouseListener(this);
				Panel3.removeAll();
				scroll = new JScrollPane();
				scroll.setViewportView(l);
				Panel3.add(scroll);
				Panel3.validate();
				Panel3.repaint();
			}
		}
		if(choices.getSelectedItem().equals("View Leases")){
			renterId.setVisible(false);
			staffId.setVisible(false);
			lowtoHigh.setVisible(false);
			hightoLow.setVisible(false);
			firstName.setVisible(true);
			lastName.setVisible(true);
			staffMemAdded.setVisible(false);
			propOwnerId.setVisible(true);
			propId.setVisible(true);
			city.setVisible(true);
			rent.setVisible(true);
			startDate.setVisible(true);
			endDate.setVisible(true);
			duration.setVisible(true);
			
			ArrayList<Lease> Lease = new ArrayList<Lease>(l1.getLeaseByLeaseId(0));
			for (int i = 0; i < Lease.size(); i++) {
				list.addElement(Lease.get(i));
			}
			list = new DefaultListModel();
			l = new JList(list);
			l.addMouseListener(this);
			Panel3.removeAll();
			scroll = new JScrollPane();
			scroll.setViewportView(l);
			Panel3.add(scroll);
			Panel3.validate();
			Panel3.repaint();
			
			if (propOwnerId.isSelected()){
				list = new DefaultListModel();
				Collections.sort(Lease, ((m1, m2) -> m1.getOID() - m2.getOID()));
				for(int i = 0; i < Lease.size(); i++){
					list.addElement(Lease.get(i));
				}
				l = new JList(list);
				l.addMouseListener(this);
				Panel3.removeAll();
				scroll = new JScrollPane();
				scroll.setViewportView(l);
				Panel3.add(scroll);
				Panel3.validate();
				Panel3.repaint();				
			}
			
			if(city.isSelected()){
				list = new DefaultListModel();
				Collections.sort(Lease, ((m1, m2) -> m1.getCity().compareTo(m2.getCity())));
				for (int i = 0; i < Lease.size(); i++) {
					list.addElement(Lease.get(i));
				}
				l = new JList(list);
				l.addMouseListener(this);
				Panel3.removeAll();
				scroll = new JScrollPane();
				scroll.setViewportView(l);
				Panel3.add(scroll);
				Panel3.validate();
				Panel3.repaint();
			}
			
			if(rent.isSelected()){
				list = new DefaultListModel();
				Collections.sort(Lease, ((m1, m2) -> Double.compare(m1.getMonthlyRent(), m2.getMonthlyRent())));
				for (int i = 0; i < Lease.size(); i++) {
					list.addElement(Lease.get(i));
				}
				l = new JList(list);
				l.addMouseListener(this);
				Panel3.removeAll();
				scroll = new JScrollPane();
				scroll.setViewportView(l);
				Panel3.add(scroll);
				Panel3.validate();
				Panel3.repaint();
			}
			if(startDate.isSelected()){
				list = new DefaultListModel();
				Collections.sort(Lease, ((m1, m2) -> m1.getRentStart().compareTo(m2.getRentStart())));
				for (int i = 0; i < Lease.size(); i++) {
					list.addElement(Lease.get(i));
				}
				l = new JList(list);
				l.addMouseListener(this);
				Panel3.removeAll();
				scroll = new JScrollPane();
				scroll.setViewportView(l);
				Panel3.add(scroll);
				Panel3.validate();
				Panel3.repaint();
			}
			if(endDate.isSelected()){
				list = new DefaultListModel();
				Collections.sort(Lease, ((m1, m2) -> m1.getRentEnd().compareTo(m2.getRentEnd())));
				for (int i = 0; i < Lease.size(); i++) {
					list.addElement(Lease.get(i));
				}
				l = new JList(list);
				l.addMouseListener(this);
				Panel3.removeAll();
				scroll = new JScrollPane();
				scroll.setViewportView(l);
				Panel3.add(scroll);
				Panel3.validate();
				Panel3.repaint();
			}
			if (duration.isSelected()){
				list = new DefaultListModel();
				Collections.sort(Lease, ((m1, m2) -> m1.getDuration().compareTo(m2.getDuration())));
				for(int i = 0; i < Lease.size(); i++){
					list.addElement(Lease.get(i));
				}
				l = new JList(list);
				l.addMouseListener(this);
				Panel3.removeAll();
				scroll = new JScrollPane();
				scroll.setViewportView(l);
				Panel3.add(scroll);
				Panel3.validate();
				Panel3.repaint();				
			}
	}
		}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount() == 2) {
			Object info = l.getSelectedValue();
			Info i = new Info(info);
			i.frame.setVisible(true);
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}