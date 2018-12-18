package pp;

import pp.Backend.InputAuthenticator;
import sql.Initialize;

import javax.swing.JFrame;
import javax.swing.*;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class UserInterface extends JFrame implements ActionListener {

	private File database = new File("database.db");

	//Staff Rob = new Staff("Rob", "Williams", 2);
	//Staff Kenny = new Staff("Kenny", "Manning", 1);

	//StaffAccount Robacc = new StaffAccount(Rob.getFname(), "robman", Rob);
	///StaffAccount Kennyacc = new StaffAccount(Kenny.getFname(), "kenman", Kenny);

	//private StaffAccount[] staffAcc = { Robacc, Kennyacc };

	private String[] Manager = { "Rob", "robman", "Dave", "daveman" };
	private String[] Supervisors = { "Kenny", "kenman", "Bob", "bobman" };
	private String[] Agents = { "Connor", "cman", "Lucas", "lman" };
	private String[] allStaff = { "Rob", "robman", "Dave", "daveman", "Kenny", "kenman", "Bob", "bobman", "Connor",
			"cman", "Lucas", "lman" };

	private JPanel usP;
	private JPasswordField PasswordText;
	private JTextField UsernameText;
	private JLabel PassPrompt, UserPrompt;
	private JButton Login, Submit;
	private JPanel manPanel;
	private JLabel man;
	private JFrame second;

	public UserInterface(boolean staffRegistration) {
		setTitle("Proper Properties");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new GridLayout(5, 2));
		//if(!staffRegistration) {
			setSize(1500, 3000);
		//}
		setResizable(false);
		buildLogin(staffRegistration);
		//add(usP, BorderLayout.WEST);
		pack();
		setVisible(true);
	}

	private void buildLogin(boolean staffRegistration) {
		InputAuthenticator ia = new InputAuthenticator();
		//registrationField (When !staffRegistration): secretKey, fName, lName, username, password
		//registrationField (When staffRegistration): fName, lName, position, branch, sex, DoB, username, password
		final String[] registrationField = new String[9];
		final int[] count = {0};
		AtomicReference<String> input = new AtomicReference<>("");
		int intInput = -1;

		JPanel display = new JPanel(new BorderLayout());
		JPanel registration = new JPanel();
		JPanel hint = new JPanel(new BorderLayout());

		JLabel welcomeText = new JLabel("Welcome Master User");
		welcomeText.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		welcomeText.setHorizontalAlignment(JLabel.CENTER);

		JLabel keyInput = new JLabel("Please Enter Secret Key:");
		keyInput.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		JTextField keyText = new JTextField(20);
		keyText.setEditable(true);

		JLabel yearLabel = new JLabel("Year");
		keyInput.setFont(new Font("Times New Roman", Font.PLAIN, 15));


		JLabel monthLabel = new JLabel("Month");
		keyInput.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		JTextField monthField = new JTextField(3);
		keyText.setEditable(true);

		JLabel dayLabel = new JLabel("Day");
		keyInput.setFont(new Font("Times New Roman", Font.PLAIN, 15));


		JTextField dayField = new JTextField(3);
		keyText.setEditable(true);

		JButton submit = new JButton("Submit");

		JLabel hintText = new JLabel("");
		hintText.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		hintText.setHorizontalAlignment(JLabel.CENTER);

		JRadioButton b1 = new JRadioButton();
		JRadioButton b2 = new JRadioButton();
		JRadioButton b3 = new JRadioButton();

		if(!database.exists() && !staffRegistration){
			add(display);
			add(registration);
			add(hint);

			display.add(welcomeText);
			registration.add(keyInput);
			registration.add(keyText);
			registration.add(submit);
			hint.add(hintText, BorderLayout.NORTH);

			//Set submit button to a local variable to avoid potential conflicts

				submit.addActionListener(e -> {
					if(ia.lengthAuthenticator(keyText.getText(), 1)) { //1 - 32 character length parameter.
						switch (count[0]){
							case 0: {
								registrationField[0] = keyText.getText(); // secretKey
								keyInput.setText("Please Enter First Name:");
								hintText.setText("");
								count[0]++; // 1
							}
							break;
							case 1: {
								registrationField[1] = keyText.getText(); // fName
								keyInput.setText("Please Enter Last Name:");
								hintText.setText("");
								count[0]++; // 2
							}
							break;
							case 2: {
								registrationField[2] = keyText.getText(); // lName
								keyInput.setText("Please Enter Username:");
								hintText.setText("");
								count[0]++; // 3
							}
							break;
							case 3: {
								registrationField[3] = keyText.getText(); // username
								keyInput.setText("Please Enter Password:");
								hintText.setText("");
								count[0]++; // 4
							}
							break;
							case 4: {
								registrationField[4] = keyText.getText(); // password
								keyInput.setText("Verify Password:");
								hintText.setText("");
								count[0]++; // 5
							}
							break;
							case 5: {
								// If passwords match, execute final user creation
								if(registrationField[4].equals(keyText.getText())){
									Initialize i = new Initialize();
									i.initializeTables();
									i.initializeMasterUser(registrationField);

									setVisible(false);
									setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
									UserInterface u = new UserInterface(false);
								}
								// If they don't, passwords should be entered anew
								else{
									keyInput.setText("Please Enter Password:");
									hintText.setText("Passwords did not match. Please try again.");
									count[0] = 4;
								}
							}
						}
						keyText.setText("");
					}
					else{
						hintText.setText("Input must be between 1 & 32 characters");
					}
				});
		}
		//database was generated. Enable login.
		else if(!staffRegistration){
			JPanel login = new JPanel();
			add(login);
			UserPrompt = new JLabel("Username: ");
			UserPrompt.setFont(new Font("Times New Roman", 15, 15));
			UsernameText = new JTextField(20);
			UsernameText.setEditable(true);
			PassPrompt = new JLabel("Password: ");
			PasswordText = new JPasswordField(20);
			PasswordText.setEditable(true);
			PasswordText.setEchoChar('*');
			Login = new JButton("Login");
			Login.addActionListener(this);
			login.add(UserPrompt);
			login.add(UsernameText);
			login.add(PassPrompt);
			login.add(PasswordText);
			login.add(Login);
		}
		//staffRegistration must be true
		else{
			System.out.println("Registering Staff");
			add(display);
			add(registration);
			add(hint);

			display.add(welcomeText);
				welcomeText.setText("Welcome Manager! Enter new staff information below:");
			registration.add(keyInput);
			keyInput.setText("Please Enter First Name:");
			registration.add(keyText);
			registration.add(submit);
			hint.add(hintText, BorderLayout.NORTH);

			submit.addActionListener(e -> {
				if(ia.lengthAuthenticator(keyText.getText(), 1) || ia.lengthAuthenticator(input.get(), 1)) { //1 - 32 character length parameter.
					switch (count[0]){
						case 0: {
							registrationField[0] = keyText.getText(); // fName
							keyInput.setText("Please Enter Last Name:");
							hintText.setText("");
							count[0]++; // 2
						}
						break;
						case 1: {
							registrationField[1] = input.get(); // sex
							keyInput.setText("Please Enter Position: ");
							hintText.setText("");
							registration.remove(keyText);
							registration.remove(submit);

							registration.add(b1);
							b1.setText("Manager");
							b1.addActionListener(e2 -> {
								input.set("2");
								b2.setSelected(false);
								b3.setSelected(false);
							});

							registration.add(b2);
							b2.setText("Supervisor");
							b2.addActionListener(e2 -> {
								input.set("1");
								b1.setSelected(false);
								b3.setSelected(false);
							});

							registration.add(b3);
							b3.setText("Agent");
							b3.addActionListener(e2 -> {
								input.set("0");
								b1.setSelected(false);
								b2.setSelected(false);
							});
							registration.add(submit);

							count[0]++; // 3
						}
						break;
						case 2: {
							registrationField[2] = keyText.getText(); // position
							keyInput.setText("Please Enter Branch:");
							hintText.setText("");

							b1.setText("");
							b2.setText("");
							b3.setText("");

							b1.setSelected(false);
							b2.setSelected(false);
							b3.setSelected(false);

							registration.remove(b1);
							registration.remove(b2);
							registration.remove(b3);
							registration.remove(submit);

							registration.add(keyText);
							registration.add(submit);
							input.set("");

							count[0]++; // 3
						}
						break;
						case 3: {
							registrationField[3] = keyText.getText(); // branch
							keyInput.setText("Please Enter Sex: ");
							hintText.setText("");
							registration.remove(keyText);
							registration.remove(submit);
							registration.add(b1);
							b1.setText("Male");
							b1.addActionListener(e2 -> {
								input.set("Male");
								b2.setSelected(false);
							});

							registration.add(b2);
							b2.setText("Female");
							b2.addActionListener(e2 -> {
								input.set("Female");
								b1.setSelected(false);
							});
							registration.add(submit);

							count[0]++; // 3
						}
						break;
						case 4: {
							registrationField[4] = keyText.getText(); // sex
							keyInput.setText("Please Enter DoB:");
							hintText.setText("");

							b1.setText("");
							b2.setText("");
							b3.setText("");

							b1.setSelected(false);
							b2.setSelected(false);
							b3.setSelected(false);

							registration.remove(b1);
							registration.remove(b2);
							registration.remove(submit);

							registration.add(yearLabel);

							registration.add(keyText);
								keyText.setColumns(3);

							registration.add(monthLabel);
							registration.add(monthField);

							registration.add(dayLabel);
							registration.add(dayField);

							registration.add(submit);
							input.set("");

							if(ia.lengthAuthenticator(input.get(), 1) && ia.lengthAuthenticator(monthField.getText(), 1) && ia.lengthAuthenticator(dayField.getText(), 1)){
								count[0]++; // 3
							}
							else{
								hintText.setText("Date entered must be valid.");
							}
						}
						break;
						case 5: {
							registrationField[5] = keyText.getText(); // DoB
							keyInput.setText("Please Enter Salary:");
							hintText.setText("");

							keyText.setColumns(20);

							registration.remove(yearLabel);
							registration.remove(monthLabel);
							registration.remove(monthField);
							registration.remove(dayLabel);
							registration.add(dayField);

							count[0]++; // 3
						}
						break;
						case 6: {
							registrationField[6] = keyText.getText(); // position
							keyInput.setText("Please Enter Supervisor:");
							hintText.setText("");
							count[0]++; // 3
						}
						break;
						case 7: {
							registrationField[7] = keyText.getText(); // supervisor
							keyInput.setText("Please Enter Usernamee:");
							hintText.setText("");
							count[0]++; // 3
						}
						break;
						case 8: {
							registrationField[8] = keyText.getText(); // username
							keyInput.setText("Please Enter Password:");
							hintText.setText("");
							count[0]++; // 4
						}
						break;
						case 9: {
							registrationField[9] = keyText.getText(); // password
							keyInput.setText("Verify Password:");
							hintText.setText("");
							count[0]++; // 5
						}
						break;
						case 10: {
							// If passwords match, execute final user creation
							if(registrationField[9].equals(keyText.getText())){ // password authentication
								//Register new Staff
								System.out.println("Registering new Staff!");
								//Close window
								setVisible(false);
								setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							}
							// If they don't, passwords should be entered anew
							else{
								keyInput.setText("Please Enter Password:");
								hintText.setText("Passwords did not match. Please try again.");
								count[0] = 8;
							}
						}
					}
					keyText.setText("");
				}
				else{
					hintText.setText("Input must be between 1 & 32 characters");
				}
			});

		}
	}

	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		boolean in = false;
		if (action.equals("Submit")) {

		}
		else if (action.equals("Login")) {
			String user = UsernameText.getText();
			String pass = PasswordText.getText();
			Staff staff = new Staff();
			ArrayList<Staff> staffList = staff.getStaffByID(0);
			for (int i = 0; i < staffList.size(); i++) {
				if (staffList.get(i).getUsername().equals(user) && staffList.get(i).getPassword().equals(pass)) {
					in = true;
					setVisible(false);
					setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					Menu menu = new Menu(staffList.get(i).getPosition());
				}
			}
			if(!in) { JOptionPane.showMessageDialog(null, "Invalid username/password. \n Try again."); }
		}
	}
}