package pp;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import sql.Input;

public class AddMenu extends JFrame implements ActionListener {

	
	private static final long serialVersionUID = 1L;
	private String[] addChoices = {"", "Add Client", "Add Property", "Add Staff", "Add Owners", "Add Property Viewing", "Add Lease"};
	private JComboBox<?> choices;
	private JComboBox<?> add;
	private JPanel optionsPanel;
	private JPanel addPanel;
//	private JPanel input;
	private JLabel j;
	private JTextField first;
	private JTextField last;
	private JTextField type;
	private JTextField phone;
	private JTextField maxRent;
	private JTextField staffNum;
	private JTextField street;
	private JTextField city;
	private JTextField zip;
	private JButton button;
	private JTextField ownerIn;
	private JTextField roomsIn;
	private JTextField rentIn;
	
	public AddMenu(){
		setTitle("Add Info Window");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(1,3));
		getContentPane().setLayout(new GridLayout(2,1));
		setSize(500,700);
		AddMenu();
		getContentPane().add(optionsPanel, BorderLayout.NORTH);
		getContentPane().add(addPanel, BorderLayout.NORTH);
		//addPanel.setLayout(new GridLayout(0, 1, 0, 0));
		setVisible(true);
	}
	
	public void AddMenu(){
		optionsPanel = new JPanel();
		addPanel = new JPanel();
		getContentPane().setLayout(new GridLayout(2,0));
		j = new JLabel("Add information here!");
		add = new JComboBox<Object>(addChoices);
		button = new JButton();
		button.addActionListener(this);
		add.setEditable(false);
		add.addActionListener(this);
		optionsPanel.add(j);
		optionsPanel.add(add);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(add.getSelectedItem().equals("Add Client")) {
			addPanel.removeAll();

			JLabel f = new JLabel("First Name:");
			JLabel l = new JLabel("Last Name:");
			JLabel ph = new JLabel("Phone Number:");
			JLabel ty = new JLabel("Type:");
			JLabel num = new JLabel("Staff Number:");
			JLabel st = new JLabel("Address:");
			JLabel ci = new JLabel("City:");
			JLabel zi = new JLabel("Zipcode:");
			JLabel max = new JLabel("Max Rent:");

			first = new JTextField(15);
			last = new JTextField(15);
			type = new JTextField(15);
			phone = new JTextField(15);
			staffNum = new JTextField(15);
			street = new JTextField(20);
			city = new JTextField(20);
			zip = new JTextField(20);
			maxRent = new JTextField(20);
			button = new JButton("Submit");	
			
			addPanel.add(f);
			addPanel.add(first);
			addPanel.add(l);
			addPanel.add(last);
			addPanel.add(ty);
			addPanel.add(type);
			addPanel.add(ph);
			addPanel.add(phone);
			addPanel.add(max);
			addPanel.add(maxRent);
			addPanel.add(num);
			addPanel.add(staffNum);
			addPanel.add(st);
			addPanel.add(street);
			addPanel.add(ci);
			addPanel.add(city);
			addPanel.add(zi);
			addPanel.add(zip);
			addPanel.add(button);
			addPanel.validate();
			addPanel.repaint();	
			
			if(button.isSelected()) {
				Input clientinput = new Input("CLIENTS");
				clientinput.addClientInfo(first.getText(), last.getText(), type.getText(), phone.getText(),
						Double.parseDouble(maxRent.getText()), Integer.parseInt(staffNum.getText()), street.getText(), 
						city.getText(), zip.getText());
				
			}

		}
		if(add.getSelectedItem().equals("Add Property")) {
			addPanel.removeAll();
			
			JLabel st = new JLabel("Street:");
			JLabel ci = new JLabel("City:");
			JLabel zi = new JLabel("Zipcode:");
			JLabel ty = new JLabel("Type:");
			JLabel rooms = new JLabel("Rooms:");
			JLabel rent = new JLabel("Rent:");
			JLabel owner = new JLabel("Owner:");
			
			street = new JTextField(20);
			city = new JTextField(20);
			zip = new JTextField(20);
			type = new JTextField(20);
			roomsIn = new JTextField(20);
			rentIn = new JTextField(20);
			ownerIn = new JTextField(20);
			
			addPanel.add(st);
			addPanel.add(street);
			addPanel.add(ci);
			addPanel.add(city);
			addPanel.add(zi);
			addPanel.add(zip);
			addPanel.add(ty);
			addPanel.add(type);
			addPanel.add(rooms);
			addPanel.add(roomsIn);
			//addPanel.add(comp)
			
			
			addPanel.validate();
			addPanel.repaint();	

			
		}
		if(add.getSelectedItem().equals("Add Staff")) {
			addPanel.removeAll();
			
			addPanel.validate();
			addPanel.repaint();	

			
		}
		if(add.getSelectedItem().equals("Add Owners")) {
			addPanel.removeAll();
			
			addPanel.validate();
			addPanel.repaint();	

			
		}
		if(add.getSelectedItem().equals("Add Property Viewing")) {
			addPanel.removeAll();
			
			addPanel.validate();
			addPanel.repaint();	

			
		}
		if(add.getSelectedItem().equals("Add Lease")) {
			addPanel.removeAll();

			addPanel.validate();
			addPanel.repaint();	

			
		}	
	}
}
