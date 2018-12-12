package pp;

import sql.Database;

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
	private String[] manChoices = { "", "View Managers", "View Supervisors", "View Agents", "View Employees Salaries",
			"View Renters", "View Property Owners", "View Properties", "View Property Viewings" };
	private String[] supChoices = { "", "View Supervisors", "View Agents", "View Renters", "View Property Owners",
			"View Properties", "View Property Viewings" };
	private String[] agentChoices = { "", "View Agents", "View Renters", "View Property Owners", "View Properties",
			"View Property Viewings" };
	
	private String[] addChoices = {"", "Add Client", "Add Property", "Add Staff", "Add Owners", "Add Property Viewing", "Add Lease"};
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
	ArrayList<Client> clientList = db.getClientByID(0);
	ArrayList<Staff> staffList = db.getStaffByID(0);
	ArrayList<PropertyOwner> propOwnerList = db.getPropOwnersByID(0);
	ArrayList<BusinessOwner> busOwnerList = db.getBusinessOwnersByID(0);
	ArrayList<PropView> propViewList = db.getPropView();
	ArrayList<Lease> leaseList = db.getLeaseByClientId(0);
	DefaultListModel list = new DefaultListModel();

	public Menu(int cl) {
		if (cl == 2) {
			setTitle("Manager Menu");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setLayout(new GridLayout(3, 0));
			setSize(700, 700);
			ManagerMenu();
			add(Panel, BorderLayout.NORTH);
			add(Panel2, BorderLayout.SOUTH);
			add(Panel3, BorderLayout.SOUTH);
			setVisible(true);
		}
		if (cl == 1) {
			setTitle("Supervisor Menu");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setLayout(new GridLayout(3, 2));
			setSize(4000, 3000);
			SupMenu();
			add(Panel, BorderLayout.NORTH);
			add(Panel2, BorderLayout.SOUTH);
			add(Panel3, BorderLayout.SOUTH);

			setVisible(true);
		}
		if (cl == 0) {
			setTitle("Agent Menu");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setLayout(new GridLayout(3, 2));
			setSize(4000, 3000);
			AgentMenu();
			add(Panel, BorderLayout.NORTH);
			add(Panel2, BorderLayout.SOUTH);
			add(Panel3, BorderLayout.SOUTH);

			setVisible(true);

		}
	}
	
	public void AddMenu(){
		
		addPanel = new JPanel();
		setLayout(new GridLayout(2,0));
		j = new JLabel("Add information here!");
		add = new JComboBox<Object>(addChoices);
		add.setEditable(false);
		add.addActionListener(this);
		addPanel.add(j);
		addPanel.add(add);
		
	}

	public void ManagerMenu() {
		Panel = new JPanel();
		Panel2 = new JPanel();
		Panel3 = new JPanel();
		label = new JLabel("Welcome Manager!");
		s = new JLabel("Search:");
		search = new JTextField(20);
		b = new JButton("Search");
		b.addActionListener(this);
		a = new JButton("Add Info");
		a.addActionListener(this);
		a.setPreferredSize(new Dimension(75, 75));
		choices = new JComboBox<Object>(manChoices);
		choices.addActionListener(this);
		choices.setEditable(false);
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
//		AddMenu();
//		add(addPanel);
//		setVisible(true);

	}

	public void SupMenu() {
		Panel = new JPanel();
		Panel2 = new JPanel();
		label = new JLabel("Welcome Supervisor!");
		s = new JLabel("Search:");
		search = new JTextField(20);
		b = new JButton("Search");
		b.addActionListener(this);
		choices = new JComboBox<Object>(supChoices);
		choices.addActionListener(this);
		choices.setEditable(false);
		filters = new ButtonGroup();
		
	}

	public void AgentMenu() {
		Panel = new JPanel();
		Panel2 = new JPanel();
		label = new JLabel("Welcome Agent!");
		s = new JLabel("Search:");
		search = new JTextField(20);
		b = new JButton("Search");
		b.addActionListener(this);
		choices = new JComboBox<Object>(agentChoices);
		choices.addActionListener(this);
		choices.setEditable(false);
		Panel.add(label);
		Panel.add(choices);
		Panel.add(s);
		Panel.add(search);
		Panel.add(b);

	}

	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		
//		if(add.getSelectedItem().equals("Add Client")){
//			JLabel f = new JLabel("First Name:");
//			JLabel l = new JLabel("Last Name:");
//			JLabel sp = new JLabel("");
//			JLabel sp1 = new JLabel("");
//			JLabel ph = new JLabel("Phone Number:");
//			JLabel sp2 = new JLabel("");
//			JLabel num = new JLabel("Staff Number:");
//			JLabel st = new JLabel("Address:");
//			JLabel sp3 = new JLabel("");
//			JLabel ci = new JLabel("City:");
//			JLabel sp4 = new JLabel("");
//			JLabel zi = new JLabel("Zipcode:");
//			JLabel sp5 = new JLabel("");
//			JLabel sp6 = new JLabel("");
//			JLabel sp7 = new JLabel("");
//			JLabel max = new JLabel("Max Rent:");
//
//			
//
//			first = new JTextField(15);
//			last = new JTextField(15);
//			phone = new JTextField(15);
//			staffNum = new JTextField(15);
//			street = new JTextField(20);
//			Ccity = new JTextField(20);
//			zip = new JTextField(20);
//			maxRent = new JTextField(20);
			button = new JButton("Submit");
//			addPanel.add(f);
//			addPanel.add(first);
//			addPanel.add(sp);
//			addPanel.add(l);
//			addPanel.add(last);
//			addPanel.add(sp1);
//			addPanel.add(ph);
//			addPanel.add(phone);
//			addPanel.add(sp7);
//			addPanel.add(max);
//			addPanel.add(maxRent);
//			addPanel.add(sp2);
//			addPanel.add(num);
//			addPanel.add(staffNum);
//			addPanel.add(sp3);
//			addPanel.add(st);
//			addPanel.add(street);
//			addPanel.add(sp4);
//			addPanel.add(sp6);
//			addPanel.add(ci);
//			addPanel.add(city);
//			addPanel.add(sp5);
//			addPanel.add(zi);
//			addPanel.add(zip);
//			addPanel.add(button);
//			addPanel.validate();
//			addPanel.repaint();	
//		}
		if (src == b) {
			if(clientList.size()> 0){
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
		}

		if (choices.getSelectedItem().equals("View Managers")) {

			noSelect.setVisible(true);
			firstName.setVisible(true);
			lastName.setVisible(true);
			staffId.setVisible(true);

		}

		
		if (choices.getSelectedItem().equals("View Supervisors")) {

			noSelect.setVisible(true);
			firstName.setVisible(true);
			lastName.setVisible(true);
			staffId.setVisible(true);

		}
		if (choices.getSelectedItem().equals("View Agents")) {

			noSelect.setVisible(true);
			firstName.setVisible(true);
			lastName.setVisible(true);
			staffId.setVisible(true);

		}
		if (choices.getSelectedItem().equals("View Employees Salaries")) {

			noSelect.setVisible(true);
			firstName.setVisible(true);
			lastName.setVisible(true);
			staffId.setVisible(true);
			lowtoHigh.setVisible(true);
			hightoLow.setVisible(true);

		}

		if (choices.getSelectedItem().equals("View Renters")) {

			noSelect.setVisible(true);
			firstName.setVisible(true);
			lastName.setVisible(true);
			renterId.setVisible(true);
			propOwnerId.setVisible(true);
			propId.setVisible(true);
			phoneNum.setVisible(true);
		}
		if (choices.getSelectedItem().equals("View Property Owners")) {

			noSelect.setVisible(true);
			firstName.setVisible(true);
			lastName.setVisible(true);
			propOwnerId.setVisible(true);
			propId.setVisible(true);
			phoneNum.setVisible(true);
			staffMemAdded.setVisible(true);

		}
		if (choices.getSelectedItem().equals("View Properties")) {

			noSelect.setVisible(true);
			firstName.setVisible(true);
			lastName.setVisible(true);
			propOwnerId.setVisible(true);
			propId.setVisible(true);
			phoneNum.setVisible(true);
			city.setVisible(true);

		}
		if (choices.getSelectedItem().equals("View Property Viewings")) {

			noSelect.setVisible(true);
			firstName.setVisible(true);
			lastName.setVisible(true);
			propOwnerId.setVisible(true);
			propId.setVisible(true);
			phoneNum.setVisible(true);
			city.setVisible(true);
			staffMemAdded.setVisible(true);

		}
		
	}

}
