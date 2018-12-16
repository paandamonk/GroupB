package pp;

import pp.Backend.InputAuthenticator;
import sql.Initialize;

import javax.swing.JFrame;
import javax.swing.*;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class UserInterface extends JFrame implements ActionListener {

	private File database = new File("database.db");

	Staff Rob = new Staff("Rob", "Williams", 2);
	Staff Kenny = new Staff("Kenny", "Manning", 1);

	StaffAccount Robacc = new StaffAccount(Rob.getFname(), "robman", Rob);
	StaffAccount Kennyacc = new StaffAccount(Kenny.getFname(), "kenman", Kenny);

	private StaffAccount[] staffAcc = { Robacc, Kennyacc };

	private String[] Manager = { "Rob", "robman", "Dave", "daveman" };
	private String[] Supervisors = { "Kenny", "kenman", "Bob", "bobman" };
	private String[] Agents = { "Connor", "cman", "Lucas", "lman" };
	private String[] allStaff = { "Rob", "robman", "Dave", "daveman", "Kenny", "kenman", "Bob", "bobman", "Connor",
			"cman", "Lucas", "lman" };

	private JPanel usP;
	private JPasswordField PasswordText;
	private JTextField UsernameText, registrationText;
	private JLabel PassPrompt, UserPrompt, registrationPrompt;
	private JButton Login;
	private JPanel manPanel;
	private JLabel man;
	private JFrame second;

	public UserInterface() {
		setTitle("Proper Properties");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new GridLayout(3, 2));
		setSize(1500, 3000);
		setResizable(false);
		buildLogin();
		//add(usP, BorderLayout.WEST);
		pack();
		setVisible(true);
	}

	private void buildLogin() {
		InputAuthenticator ia = new InputAuthenticator();
		final String[] registrationField = new String[5]; //secretKey, fName, lName, username, password
		final int[] count = {0};

		if(!database.exists()){


			JPanel display = new JPanel(new BorderLayout());
			JPanel registration = new JPanel();
			JPanel hint = new JPanel(new BorderLayout());
			add(display);
			add(registration);
			add(hint);

			JLabel welcomeText = new JLabel("Welcome Master User");
				welcomeText.setFont(new Font("Times New Roman", Font.PLAIN, 15));
				welcomeText.setHorizontalAlignment(JLabel.CENTER);
					display.add(welcomeText);

			JLabel keyInput = new JLabel("Please Enter Secret Key:");
				keyInput.setFont(new Font("Times New Roman", Font.PLAIN, 15));
				registration.add(keyInput);

			JTextField keyText = new JTextField(20);
				keyText.setEditable(true);
				registration.add(keyText);

			JButton submit = new JButton("Submit");
				registration.add(submit);

			JLabel hintText = new JLabel("");
			hintText.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			hintText.setHorizontalAlignment(JLabel.CENTER);
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
									UserInterface u = new UserInterface();
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
						hintText.setText("Input must be between 0 and 32 characters");
					}
				});
		}
		//database was generated. Enable login.
		else {
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
	}

	public int dataSubmission(int fieldCount, String input){

		return fieldCount;
	}

	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();

		boolean in = false;
		if (action.equals("Submit")) {
			//System.out.println(buildLogin().keyInput);
		}
		else if (action.equals("Login")) {
			String user = UsernameText.getText();
			String pass = PasswordText.getText();
			for (int i = 0; i < staffAcc.length; i++) {
				if (staffAcc[i].getUser().equals(user) && staffAcc[i].getPass().equals(pass)) {
					in = true;
					setVisible(false);
					setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					Menu menu = new Menu(staffAcc[i].getStaff().getPosition());
				}
			}
			if(in == false)
				JOptionPane.showMessageDialog(null, "Invalid username/password. \n Try again.");

		}
	}
}