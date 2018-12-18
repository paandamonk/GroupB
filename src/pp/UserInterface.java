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
		setLayout(new GridLayout(3, 2));
		setSize(1500, 3000);
		setResizable(false);
		buildLogin(staffRegistration);
		//add(usP, BorderLayout.WEST);
		pack();
		setVisible(true);
	}

	private void buildLogin(boolean staffRegistration) {
		InputAuthenticator ia = new InputAuthenticator();
		final String[] registrationField = new String[5]; //secretKey, fName, lName, username, password
		final int[] count = {0};

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

		JButton submit = new JButton("Submit");

		JLabel hintText = new JLabel("");
		hintText.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		hintText.setHorizontalAlignment(JLabel.CENTER);

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
			count[0] = 1;

			submit.addActionListener(e -> {
				if(ia.lengthAuthenticator(keyText.getText(), 1)) { //1 - 32 character length parameter.
					switch (count[0]){
						case 1: {
							registrationField[1] = keyText.getText(); // fName
							keyInput.setText("Please Enter Last Name:");
							hintText.setText("");
							count[0]++; // 2
						}
						break;
						case 2: {
							registrationField[2] = keyText.getText(); // lName
							keyInput.setText("Please Enter Position (Manager, Supervisor, Agent):");
							hintText.setText("");
							count[0]++; // 3
						}
						break;
						case 3: {
							registrationField[2] = keyText.getText(); // lName
							keyInput.setText("Please Enter Branch:");
							hintText.setText("");
							count[0]++; // 3
						}
						case 4: {
							registrationField[2] = keyText.getText(); // lName
							keyInput.setText("Please Enter Salary:");
							hintText.setText("");
							count[0]++; // 3
						}
						case 5: {
							registrationField[2] = keyText.getText(); // lName
							keyInput.setText("Please Enter Supervisor:");
							hintText.setText("");
							count[0]++; // 3
						}
						case 6: {
							registrationField[2] = keyText.getText(); // lName
							keyInput.setText("Please Enter Username:");
							hintText.setText("");
							count[0]++; // 3
						}
						break;
						case 7: {
							registrationField[3] = keyText.getText(); // username
							keyInput.setText("Please Enter Password:");
							hintText.setText("");
							count[0]++; // 4
						}
						break;
						case 8: {
							registrationField[4] = keyText.getText(); // password
							keyInput.setText("Verify Password:");
							hintText.setText("");
							count[0]++; // 5
						}
						break;
						case 9: {
							// If passwords match, execute final user creation
							if(registrationField[4].equals(keyText.getText())){
								//Register new Staff

								//Close window
								setVisible(false);
								setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							}
							// If they don't, passwords should be entered anew
							else{
								keyInput.setText("Please Enter Password:");
								hintText.setText("Passwords did not match. Please try again.");
								count[0] = 7;
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