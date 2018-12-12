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

class LastNameComparator implements Comparator<String> {
	public int compare(String b1, String b2) {
		String[] arr1 = b1.split(" ");
		String[] arr2 = b2.split(" ");
		if (arr1.length > 1 && arr2.length > 1)
			return arr1[arr1.length - 1].compareTo(arr2[arr2.length - 1]);
		else
			return 0;
	}
}

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
	private JRadioButton filter0;
	private JRadioButton filter1;
	private JRadioButton filter2;
	private JRadioButton filter3;
	private JRadioButton filter4;
	private JRadioButton filter5;
	private JRadioButton filter6;
	private JRadioButton filter7;
	private ButtonGroup filters;
	private JTextField search;
	private JTextField first;
	private JTextField last;
	private JTextField phone;
	private JTextField maxRent;
	private JTextField staffNum;
	private JTextField street;
	private JTextField city;
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
	//ArrayList<Client> clientList = db.getClients();
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
		filter0 = new JRadioButton();
		filter1 = new JRadioButton();
		filter2 = new JRadioButton();
		filter3 = new JRadioButton();
		filter4 = new JRadioButton();
		filter5 = new JRadioButton();
		filter6 = new JRadioButton();
		filter7 = new JRadioButton();
		filters.add(filter0);
		filters.add(filter1);
		filters.add(filter2);
		filters.add(filter3);
		filters.add(filter4);
		filters.add(filter5);
		filters.add(filter6);
		filters.add(filter7);

		Panel.add(label);
		Panel.add(choices);
		Panel.add(s);
		Panel.add(search);
		Panel.add(b);
		Panel.add(a);
		Panel2.add(filter0);
		Panel2.add(filter1);
		Panel2.add(filter2);
		Panel2.add(filter3);
		Panel2.add(filter4);
		Panel2.add(filter5);
		Panel2.add(filter6);
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
		filter0 = new JRadioButton();
		filter1 = new JRadioButton();
		filter2 = new JRadioButton();
		filter3 = new JRadioButton();
		filter4 = new JRadioButton();
		filter5 = new JRadioButton();
		filter6 = new JRadioButton();
		filter7 = new JRadioButton();
		filters.add(filter0);
		filters.add(filter1);
		filters.add(filter2);
		filters.add(filter3);
		filters.add(filter4);
		filters.add(filter5);
		filters.add(filter6);
		filters.add(filter7);

		Panel.add(label);
		Panel.add(choices);
		Panel.add(s);
		Panel.add(search);
		Panel.add(b);
		Panel2.add(filter0);
		Panel2.add(filter1);
		Panel2.add(filter2);
		Panel2.add(filter3);
		Panel2.add(filter4);
		Panel2.add(filter5);
		Panel2.add(filter6);

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

	public void RadioListener() {

	}

	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == a){
			
			AddMenu();
			add(addPanel);
			setVisible(true);
			
			
		}
		if(add.getSelectedItem().equals("Add Client")){
			JLabel f = new JLabel("First Name:");
			JLabel l = new JLabel("Last Name:");
			JLabel sp = new JLabel("");
			JLabel sp1 = new JLabel("");
			JLabel ph = new JLabel("Phone Number:");
			JLabel sp2 = new JLabel("");
			JLabel num = new JLabel("Staff Number:");
			JLabel st = new JLabel("Address:");
			JLabel sp3 = new JLabel("");
			JLabel ci = new JLabel("City:");
			JLabel sp4 = new JLabel("");
			JLabel zi = new JLabel("Zipcode:");
			JLabel sp5 = new JLabel("");
			JLabel sp6 = new JLabel("");
			JLabel sp7 = new JLabel("");
			JLabel max = new JLabel("Max Rent:");

			

			first = new JTextField(15);
			last = new JTextField(15);
			phone = new JTextField(15);
			staffNum = new JTextField(15);
			street = new JTextField(20);
			city = new JTextField(20);
			zip = new JTextField(20);
			maxRent = new JTextField(20);
			button = new JButton("Submit");
			addPanel.add(f);
			addPanel.add(first);
			addPanel.add(sp);
			addPanel.add(l);
			addPanel.add(last);
			addPanel.add(sp1);
			addPanel.add(ph);
			addPanel.add(phone);
			addPanel.add(sp7);
			addPanel.add(max);
			addPanel.add(maxRent);
			addPanel.add(sp2);
			addPanel.add(num);
			addPanel.add(staffNum);
			addPanel.add(sp3);
			addPanel.add(st);
			addPanel.add(street);
			addPanel.add(sp4);
			addPanel.add(sp6);
			addPanel.add(ci);
			addPanel.add(city);
			addPanel.add(sp5);
			addPanel.add(zi);
			addPanel.add(zip);
			addPanel.add(button);
			addPanel.validate();
			addPanel.repaint();

			
		}

		if (src == b) {

			//String test = clientList.get(0).getFname() + " " + clientList.get(0).getLname();
			//String test2 = clientList.get(1).getFname() + " " + clientList.get(1).getLname();
			//list.addElement(test);
			//list.addElement(test2);
			
//			for(int i = 0; i < list.size(); i++){
//				if(list.get(i).toString().contains(search.getText())){
//					
//				}
//			}

			l = new JList(list);
			Panel3.removeAll();
			scroll = new JScrollPane();
			scroll.setViewportView(l);
			Panel3.add(scroll);
			Panel3.validate();
			Panel3.repaint();

		}

		if (choices.getSelectedItem().equals("View Managers")) {
			filter0.setText("(No Select)");
			filter1.setText("First Name");
			filter2.setText("Last Name");
			filter3.setText("ID Number");

			filter0.setVisible(true);
			filter1.setVisible(true);
			filter2.setVisible(true);
			filter3.setVisible(false);
			filter4.setVisible(false);
			filter5.setVisible(false);
			filter6.setVisible(false);

			filter0.addActionListener(this);
			filter1.addActionListener(this);
			filter2.addActionListener(this);
			filter3.addActionListener(this);
			filter4.addActionListener(this);
			filter5.addActionListener(this);
			filter6.addActionListener(this);
			filter7.addActionListener(this);

			if (filter0.isSelected()) {
				try {
					BufferedReader in = new BufferedReader(
							new FileReader("/Users/KennysStuff/Documents/UserInterface/src/pp/names.txt"));
					String line;
					while ((line = in.readLine()) != null) {
						System.out.println(line);
					}
					in.close();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}

			if (filter1.isSelected()) {
				System.out.println();

				System.out.println("Sorted by first name:");
				ArrayList<String> name = new ArrayList<String>();
				try {
					BufferedReader in = new BufferedReader(
							new FileReader("/Users/KennysStuff/Documents/UserInterface/src/pp/names.txt"));
					String line;
					while ((line = in.readLine()) != null) {
						name.add(line);

					}
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				Collections.sort(name);

				for (int i = 0; i < name.size(); i++) {
					System.out.println(name.get(i));
				}

			}
			if (filter2.isSelected()) {

				System.out.println();

				System.out.println("Sorted by last name:");

				ArrayList<String> name = new ArrayList<String>();
				try {
					BufferedReader in = new BufferedReader(
							new FileReader("/Users/KennysStuff/Documents/UserInterface/src/pp/names.txt"));
					String line;
					while ((line = in.readLine()) != null) {

						name.add(line);
					}

				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				Collections.sort(name, new LastNameComparator());

				for (int i = 0; i < name.size(); i++) {
					System.out.println(name.get(i));
				}

			}
			if (filter3.isSelected()) {

			}

		}

		if (choices.getSelectedItem().equals("View Supervisors")) {
			filter0.setText("(No Select)");
			filter1.setText("First Name");
			filter2.setText("Last Name");
			filter3.setText("ID Number");

			filter0.setVisible(true);

			filter1.setVisible(true);
			filter2.setVisible(true);
			filter3.setVisible(true);
			filter4.setVisible(false);
			filter5.setVisible(false);
			filter6.setVisible(false);
		}
		if (choices.getSelectedItem().equals("View Agents")) {
			filter0.setText("(No Select)");
			filter1.setText("First Name");
			filter2.setText("Last Name");
			filter3.setText("ID Number");

			filter0.setVisible(true);
			filter1.setVisible(true);
			filter2.setVisible(true);
			filter3.setVisible(true);
			filter4.setVisible(false);
			filter5.setVisible(false);
			filter6.setVisible(false);
		}

		if (choices.getSelectedItem().equals("View Employees Salaries")) {
			filter0.setText("(No Select)");
			filter1.setText("First Name");
			filter2.setText("Last Name");
			filter3.setText("Low to High");
			filter4.setText("High to Low");

			filter0.setVisible(true);
			filter1.setVisible(true);
			filter2.setVisible(true);
			filter3.setVisible(true);
			filter4.setVisible(true);
			filter5.setVisible(false);
			filter6.setVisible(false);

			filter0.addActionListener(this);
			filter1.addActionListener(this);
			filter2.addActionListener(this);
			filter3.addActionListener(this);
			filter4.addActionListener(this);
			filter5.addActionListener(this);
			filter6.addActionListener(this);
			filter7.addActionListener(this);

			if (filter0.isSelected()) {
				try {
					BufferedReader in = new BufferedReader(
							new FileReader("/Users/KennysStuff/Documents/UserInterface/src/pp/names.txt"));
					String line;
					while ((line = in.readLine()) != null) {
						System.out.println(line);
					}
					in.close();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
			if (filter1.isSelected()) {
				ArrayList<String> name = new ArrayList<String>();
				try {
					BufferedReader in = new BufferedReader(
							new FileReader("/Users/KennysStuff/Documents/UserInterface/src/pp/names.txt"));
					String line;
					while ((line = in.readLine()) != null) {
						name.add(line);

					}
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				Collections.sort(name);

				for (int i = 0; i < name.size(); i++) {
					System.out.println(name.get(i));
				}

			}
			if (filter2.isSelected()) {
				ArrayList<String> name = new ArrayList<String>();
				try {
					BufferedReader in = new BufferedReader(
							new FileReader("/Users/KennysStuff/Documents/UserInterface/src/pp/names.txt"));
					String line;
					while ((line = in.readLine()) != null) {

						name.add(line);
					}

				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				Collections.sort(name, new LastNameComparator());

				for (int i = 0; i < name.size(); i++) {
					System.out.println(name.get(i));
				}

			}

			if (choices.getSelectedItem().equals("View Renters")) {
				filter0.setText("(No Select)");
				filter1.setText("First Name");
				filter2.setText("Last Name");
				filter3.setText("Renter ID");
				filter4.setText("Property ID");
				filter5.setText("Phone Number");
				filter6.setText("Staff Member");

				filter0.setVisible(true);
				filter1.setVisible(true);
				filter2.setVisible(true);
				filter3.setVisible(true);
				filter4.setVisible(true);
				filter5.setVisible(true);
				filter6.setVisible(true);
			}
			if (choices.getSelectedItem().equals("View Property Owners")) {
				filter0.setText("(No Select)");
				filter1.setText("First Name");
				filter2.setText("Last Name");
				filter3.setText("Property Owner ID");
				filter4.setText("Property ID");
				filter5.setText("Phone Number");
				filter6.setText("Staff Member");

				filter0.setVisible(true);
				filter1.setVisible(true);
				filter2.setVisible(true);
				filter3.setVisible(true);
				filter4.setVisible(true);
				filter5.setVisible(true);
				filter6.setVisible(true);
				filter7.setVisible(false);
			}
			if (choices.getSelectedItem().equals("View Properties")) {

				filter0.setText("(No Select)");

				filter1.setText("First Name");
				filter2.setText("Last Name");
				filter3.setText("Property Owner ID");
				filter4.setText("Property ID");
				filter5.setText("Phone Number");

				filter0.setVisible(true);
				filter1.setVisible(true);
				filter2.setVisible(true);
				filter3.setVisible(true);
				filter4.setVisible(true);
				filter5.setVisible(true);
				filter7.setVisible(false);

			}

			if (choices.getSelectedItem().equals("View Property Viewings")) {
				filter0.setText("(No Select)");

				filter1.setText("First Name");
				filter2.setText("Last Name");
				filter3.setText("Property Owner ID");
				filter4.setText("Property ID");
				filter5.setText("Phone Number");
				filter6.setText("Staff Member");
				filter7.setText("City");

				Panel2.add(filter7);

				filter0.setVisible(true);
				filter1.setVisible(true);
				filter2.setVisible(true);
				filter3.setVisible(true);
				filter4.setVisible(true);
				filter5.setVisible(true);
				filter6.setVisible(true);
				filter7.setVisible(true);

			}
		}

	}

}
