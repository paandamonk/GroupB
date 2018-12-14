 package pp;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import sql.Input;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;


public class Add implements ActionListener{

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private String[] addChoices = {"", "Add Client", "Add Property", "Add Staff", "Add Property Owners", "Add Business Owners", "Add Property Viewing", "Add Lease"};
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
	private JLabel l15;
	private JComboBox<?> comboBox;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnSubmit;




	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Add window = new Add();
		window.frame.setVisible(true);
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
	public Add() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.GRAY, Color.BLACK));
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblSelect = new JLabel("Select:");
		panel.add(lblSelect);
		comboBox = new JComboBox<Object>(addChoices);
		comboBox.addActionListener(this);

		panel.add(comboBox);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, null, null));
		frame.getContentPane().add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel l0 = new JLabel("First: ");
		panel_1.add(l0);
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel l1 = new JLabel("Second:");
		panel_1.add(l1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		panel_1.add(textField_1);
		
		JLabel l2 = new JLabel("Third:");
		panel_1.add(l2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		panel_1.add(textField_2);
		
		JLabel l3 = new JLabel("Fourth:");
		panel_1.add(l3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
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
		
		btnSubmit = new JButton("Submit");
		frame.getContentPane().add(btnSubmit, BorderLayout.CENTER);
		btnSubmit.addActionListener(this);
		
		textField.setVisible(false);
		textField_1.setVisible(false);
		textField_2.setVisible(false);
		textField_3.setVisible(false);
		textField_4.setVisible(false);
		textField_5.setVisible(false);
		textField_6.setVisible(false);
		textField_7.setVisible(false);
		textField_8.setVisible(false);
		textField_9.setVisible(false);
		textField_10.setVisible(false);
		textField_11.setVisible(false);
		textField_12.setVisible(false);
		textField_13.setVisible(false);
		textField_14.setVisible(false);
		textField_15.setVisible(false);
		l0.setVisible(false);
		l1.setVisible(false);
		l2.setVisible(false);
		l3.setVisible(false);
		l4.setVisible(false);
		l5.setVisible(false);
		l6.setVisible(false);
		l7.setVisible(false);
		l8.setVisible(false);
		l9.setVisible(false);
		l10.setVisible(false);
		l11.setVisible(false);
		l12.setVisible(false);
		l13.setVisible(false);
		l14.setVisible(false);
		l15.setVisible(false);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//all done except for button
		if(comboBox.getSelectedItem().equals("Add Client")) {
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
			l2 = new JLabel("Type");
			panel_1.add(l2);
			panel_1.add(textField_2);
			l3 = new JLabel("Phone Number");
			panel_1.add(l3);
			panel_1.add(textField_3);
			l4 = new JLabel("Max Rent");
			panel_1.add(l4);
			panel_1.add(textField_4);
			l5 = new JLabel("Staff Id");
			panel_1.add(l5);
			panel_1.add(textField_5);
			l6 = new JLabel("Street");
			panel_1.add(l6);
			panel_1.add(textField_6);
			l7 = new JLabel("City");
			panel_1.add(l7);
			panel_1.add(textField_7);
			l8 = new JLabel("zip");
			panel_1.add(l8);
			panel_1.add(textField_8);
			panel_1.validate();
			panel_1.repaint();
			
			//Button listener needs more idiot-proofing, but it works as of right now.
			if(e.getSource() == btnSubmit) {
				boolean cleared = (textField.getText() == null) || (textField_1.getText() == null) || 
						(textField_2.getText() == null) || (textField_3.getText() == null) ||
						(textField_4.getText() == null) || (textField_5.getText() == null) ||
						(textField_6.getText() == null) || (textField_7.getText() == null) ||
						(textField_8.getText() == null);
				
				//right now it either crashes when trying to submit empty or it gives the dialog box each time. Needs work.
//				if(cleared) {
					Input clientinput = new Input("CLIENTS");
					String fname = textField.getText();
					String lname = textField_1.getText();
					String type = textField_2.getText();
					String phone = textField_3.getText();
					double rent = Double.parseDouble(textField_4.getText());
					int staffId = Integer.parseInt(textField_5.getText());
					String street = textField_6.getText();
					String city = textField_7.getText();
					String zip = textField_8.getText();
					clientinput.addClientInfo(fname, lname, type,
							phone, rent, staffId,
							street, city, zip);
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
		//Up to date except button listener
		if(comboBox.getSelectedItem().equals("Add Property")) {
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
			panel_1.add(textField_6);
			panel_1.validate();
			panel_1.repaint();
			
			//Button listener needs more idiot-proofing, but it works as of right now.
			if(e.getSource() == btnSubmit) {
				boolean cleared = (textField.getText() == null) || (textField_1.getText() == null) || 
						(textField_2.getText() == null) || (textField_3.getText() == null) ||
						(textField_4.getText() == null) || (textField_5.getText() == null) ||
						(textField_6.getText() == null);
				
				//right now it either crashes when trying to submit empty or it gives the dialog box each time. Needs work.
			//	if(cleared) {
					Input propertyinput = new Input("PROPERTIES");
					String street = textField.getText();
					String city = textField_1.getText();
					String zip = textField_2.getText();
					String type = textField_3.getText();
					int rooms = Integer.parseInt(textField_4.getText());
					double rent = Double.parseDouble(textField_5.getText());
					String owner = textField_6.getText();

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
		if(comboBox.getSelectedItem().equals("Add Staff")) {
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
			panel_1.add(textField_7);
			panel_1.validate();
			panel_1.repaint();
			
			//Button listener needs more idiot-proofing, but it works as of right now.
			if(e.getSource() == btnSubmit) {
				boolean cleared = (textField.getText() == null) || (textField_1.getText() == null) || 
						(textField_2.getText() == null) || (textField_3.getText() == null) ||
						(textField_4.getText() == null) || (textField_5.getText() == null) ||
						(textField_6.getText() == null) ||(textField_7.getText() == null);
				
				//right now it either crashes when trying to submit empty or it gives the dialog box each time. Needs work.
			//	if(cleared) {
					Input staffinput = new Input("STAFF");
					String fname = textField.getText();
					String lname = textField_1.getText();
					int position = Integer.parseInt(textField_2.getText());
					String branch = textField_3.getText();
					String sex = textField_4.getText();
					String DoB = textField_5.getText();
					double salary = Double.parseDouble(textField_6.getText());
					int supId = Integer.parseInt(textField_7.getText());
					
					staffinput.addStaffInfo(fname, lname, position, branch, sex, DoB, salary, supId);
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
		//under construction
		if(comboBox.getSelectedItem().equals("Add Property Owners")) {
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
			l6 = new JLabel("Staff Id");
			panel_1.add(l6);
			panel_1.add(textField_6);
			panel_1.validate();
			panel_1.repaint();
			
			//Button listener needs more idiot-proofing, but it works as of right now.
			if(e.getSource() == btnSubmit) {
				boolean cleared = (textField.getText() == null) || (textField_1.getText() == null) || 
						(textField_2.getText() == null) || (textField_3.getText() == null) ||
						(textField_4.getText() == null) || (textField_5.getText() == null) ||
						(textField_6.getText() == null);
				
				//right now it either crashes when trying to submit empty or it gives the dialog box each time. Needs work.
		//		if(cleared) {
					Input propownerinput = new Input("PROPOWNERS");
					String fname = textField.getText();
					String lname = textField_1.getText();
					String street = textField_2.getText();
					String city = textField_3.getText();
					String zip = textField_4.getText();
					String phone = textField_5.getText();
					int staffId = Integer.parseInt(textField_6.getText());
					propownerinput.addPropOwnerInfo(fname, lname, street, city, zip, phone, staffId);
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
		if(comboBox.getSelectedItem().equals("Add Business Owners")) {
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
			panel_1.add(textField_8);
			panel_1.validate();
			panel_1.repaint();
			
			//Button listener needs more idiot-proofing, but it works as of right now.
			if(e.getSource() == btnSubmit) {
				boolean cleared = (textField.getText() == null) || (textField_1.getText() == null) || 
						(textField_2.getText() == null) || (textField_3.getText() == null) ||
						(textField_4.getText() == null) || (textField_5.getText() == null) ||
						(textField_6.getText() == null) ||(textField_7.getText() == null) ||
						(textField_8.getText() == null);
				
				//right now it either crashes when trying to submit empty or it gives the dialog box each time. Needs work.
			//	if(cleared) {
					Input busownerinput = new Input("BUSOWNERS");
					String fname = textField.getText();
					String lname = textField_1.getText();
					String street = textField_2.getText();
					String city = textField_3.getText();
					String zip = textField_4.getText();
					String phone = textField_5.getText();
					String bname = textField_6.getText();
					String btype = textField_7.getText();
					int staffId = Integer.parseInt(textField_8.getText());
					busownerinput.addBusinessOwnerInfo(fname, lname, street, city, zip, phone, bname, btype, staffId);
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
		if(comboBox.getSelectedItem().equals("Add Property Viewing")) {
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
			panel_1.validate();
			panel_1.repaint();
			
			//Button listener needs more idiot-proofing, but it works as of right now.
			if(e.getSource() == btnSubmit) {
				boolean cleared = (textField.getText() == null) || (textField_1.getText() == null) || 
						(textField_2.getText() == null) || (textField_3.getText() == null) ||
						(textField_4.getText() == null) || (textField_5.getText() == null) ||
						(textField_6.getText() == null) ||(textField_7.getText() == null) ||
						(textField_8.getText() == null);
				
				//right now it either crashes when trying to submit empty or it gives the dialog box each time. Needs work.
		//		if(cleared) {
					Input propviewinput = new Input("PROPVIEW");
					String fname = textField.getText();
					String lname = textField_1.getText();
					String cell = textField_2.getText();
					int propId = Integer.parseInt(textField_3.getText());
					String street = textField_4.getText();
					String city = textField_5.getText();
					String zip = textField_6.getText();
					String viewdate = textField_7.getText();
					String comments = textField_8.getText();
					propviewinput.addPropViewInfo(fname, lname, cell, propId, street, city, zip, viewdate, comments);
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

		if(comboBox.getSelectedItem().equals("Add Lease")) {
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
			l0 = new JLabel("Client Id");
			panel_1.add(l0);
			panel_1.add(textField);
			l1 = new JLabel("First Name");
			panel_1.add(l1);
			panel_1.add(textField_1);
			l2 = new JLabel("Last Name");
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
			panel_1.validate();
			panel_1.repaint();
			
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
					Input leaseinput = new Input("LEASE");
					int clientId = Integer.parseInt(textField.getText());
					String fname = textField_1.getText();
					String lname = textField_2.getText();
					int propId = Integer.parseInt(textField_3.getText());
					String street = textField_4.getText();
					String city = textField_5.getText();
					String zip = textField_6.getText();
					String type = textField_7.getText();
					int rooms = Integer.parseInt(textField_8.getText());
					double rent = Double.parseDouble(textField_9.getText());
					String paymethod = textField_10.getText();
					double deposit = Double.parseDouble(textField_11.getText());
					int paidDeposit = Integer.parseInt(textField_12.getText());
					String startdate = textField_13.getText();
					String enddate = textField_14.getText();
					String duration = textField_15.getText();
					leaseinput.addLeaseInfo(clientId, fname, lname, propId, street, city, zip, type, rooms,
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
	

}
