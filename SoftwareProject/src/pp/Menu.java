package pp;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Menu extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel Panel;
	private JPanel Panel2;
	private JLabel label;
	private String[] manChoices = {"", "View Managers", "View Supervisors", "View Agents", "View Employees Salaries",
			"View Renters","View Property Owners", "View Properties","View Property Viewings" };
	private String[] supChoices = {"", "View Supervisors", "View Agents", "View Renters","View Property Owners", "View Properties","View Property Viewings" };
	private String[] agentChoices = {"", "View Agents", "View Renters","View Property Owners", "View Properties","View Property Viewings" };
	private JComboBox<?> choices;
	private JRadioButton filter1;
	private JRadioButton filter2;
	private JRadioButton filter3;
	private JRadioButton filter4;
	private JRadioButton filter5;
	private JRadioButton filter6;
	private ButtonGroup filters;
	private JTextField search;
	private JLabel s;
	private JButton b;

	public Menu(int cl) {
		if (cl == 2) {
			setTitle("Manager Menu");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setLayout(new GridLayout(3, 2));
			setSize(4000, 3000);
			ManagerMenu();
			add(Panel, BorderLayout.NORTH);
			add(Panel2, BorderLayout.SOUTH);
			pack();
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
			pack();
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
			pack();
			setVisible(true);

		}
	}

	public void ManagerMenu() {
		Panel = new JPanel();
		Panel2 = new JPanel();
		label = new JLabel("Welcome Manager!");
		s = new JLabel("Search:");
		search = new JTextField(20);
		b = new JButton("Search");
		choices = new JComboBox<Object>(manChoices);
		choices.addActionListener(this);
		choices.setEditable(false);
		filters = new ButtonGroup();
		filter1 = new JRadioButton();
		filter2 = new JRadioButton();
		filter3 = new JRadioButton();
		filter4 = new JRadioButton();
		filter5 = new JRadioButton();
		filter6 = new JRadioButton();
		filters.add(filter1);
		filters.add(filter2);
		filters.add(filter3);
		filters.add(filter4);
		filters.add(filter5);
		filters.add(filter6);
		Panel.add(label);
		Panel.add(choices);
		Panel.add(s);
		Panel.add(search);
		Panel.add(b);
		Panel2.add(filter1);
		Panel2.add(filter2);
		Panel2.add(filter3);
		Panel2.add(filter4);
		Panel2.add(filter5);
		Panel2.add(filter6);
	}

	public void SupMenu() {
		Panel = new JPanel();
		Panel2 = new JPanel();
		label = new JLabel("Welcome Supervisor!");
		s = new JLabel("Search:");
		search = new JTextField(20);
		b = new JButton("Search");
		choices = new JComboBox<Object>(supChoices);
		choices.addActionListener(choices);
		choices.setEditable(false);
		Panel.add(label);
		Panel.add(choices);
		Panel.add(s);
		Panel.add(search);
		Panel.add(b);
	}

	public void AgentMenu() {
		Panel = new JPanel();
		Panel2 = new JPanel();
		label = new JLabel("Welcome Agent!");
		s = new JLabel("Search:");
		search = new JTextField(20);
		b = new JButton("Search");
		choices = new JComboBox<Object>(agentChoices);
		choices.addActionListener(choices);
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

		if(choices.getSelectedItem().equals("View Managers")) {
			filter1.setText("First Name");
			filter2.setText("Last Name");
			filter3.setText("ID Number");
			
			filter1.setVisible(true);
			filter2.setVisible(true);
			filter3.setVisible(true);
			filter4.setVisible(false);
			filter5.setVisible(false);
			filter6.setVisible(false);

		}
		
		if(choices.getSelectedItem().equals("View Supervisors")) {
			filter1.setText("First Name");
			filter2.setText("Last Name");
			filter3.setText("ID Number");
			
			filter1.setVisible(true);
			filter2.setVisible(true);
			filter3.setVisible(true);
			filter4.setVisible(false);
			filter5.setVisible(false);
			filter6.setVisible(false);
		}
		if(choices.getSelectedItem().equals("View Agents")) {
			filter1.setText("First Name");
			filter2.setText("Last Name");
			filter3.setText("ID Number");
			filter4.setText("Supervisor Name");
			
			filter1.setVisible(true);
			filter2.setVisible(true);
			filter3.setVisible(true);
			filter4.setVisible(true);
			filter5.setVisible(false);
			filter6.setVisible(false);
		}

		if(choices.getSelectedItem().equals("View Employees Salaries")) {
			filter1.setText("First Name");
			filter2.setText("Last Name");
			filter3.setText("Low to High");
			filter4.setText("High to Low");
			
			filter1.setVisible(true);
			filter2.setVisible(true);
			filter3.setVisible(true);
			filter4.setVisible(true);
			filter5.setVisible(false);
			filter6.setVisible(false);
		}

		if(choices.getSelectedItem().equals("View Renters")) {
			filter1.setText("First Name");
			filter2.setText("Last Name");
			filter3.setText("Renter ID");
			filter4.setText("Property ID");
			filter5.setText("Phone Number");
			filter6.setText("Staff Member");
			
			filter1.setVisible(true);
			filter2.setVisible(true);
			filter3.setVisible(true);
			filter4.setVisible(true);
			filter5.setVisible(true);
			filter6.setVisible(true);
		}
		if(choices.getSelectedItem().equals("View Property Owners")) {
			filter1.setText("First Name");
			filter2.setText("Last Name");
			filter3.setText("Property Owner ID");
			filter4.setText("Property ID");
			filter5.setText("Phone Number");
			filter6.setText("Staff Member");
			
			filter1.setVisible(true);
			filter2.setVisible(true);
			filter3.setVisible(true);
			filter4.setVisible(true);
			filter5.setVisible(true);
			filter6.setVisible(true);
		}
		if(choices.getSelectedItem().equals("View Properties")){
			
		}
		if(choices.getSelectedItem().equals("View Property Viewings")) {
			
		}

	}

}
