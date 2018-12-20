	package pp;

import pp.Backend.InputAuthenticator;
import pp.Frontend.MultibleSelections;
import sql.Initialize;
import sql.Input;

import javax.swing.JFrame;
import javax.swing.*;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

import static javax.swing.SwingConstants.CENTER;
import static javax.swing.SwingConstants.EAST;
import static javax.swing.SwingConstants.NORTH;

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
	private String staffItemClicked = "";

	public UserInterface() {}

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
		final String[] registrationField = new String[10];
		final int[] count = {0};
		AtomicReference<String> input = new AtomicReference<>("");

		JPanel display = new JPanel(new BorderLayout());
		JPanel registration = new JPanel();
		JPanel hint = new JPanel(new BorderLayout());

		JLabel welcomeText = new JLabel("Welcome Master User");
		welcomeText.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		welcomeText.setHorizontalAlignment(CENTER);

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
		hintText.setHorizontalAlignment(CENTER);

		JRadioButton b1 = new JRadioButton();
		JRadioButton b2 = new JRadioButton();
		JRadioButton b3 = new JRadioButton();
		JRadioButton backButton = new JRadioButton();

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
								System.out.println(ia.nameAuthenticator(keyText.getText()));
								registrationField[0] = keyText.getText(); // secretKey
								keyInput.setText("Please Enter First Name:");
								hintText.setText("");
								count[0]++; // 1
							}
							break;
							case 1: {
								if(ia.nameAuthenticator(keyText.getText())) {
									registrationField[1] = keyText.getText(); // fName
									keyInput.setText("Please Enter Last Name:");
									hintText.setText("");
									count[0]++; // 2
								}
								else{
									hintText.setText("The first letter of a name must be uppercase, and the rest must be lowercase.");
								}
							}
							break;
							case 2: {
								if(ia.nameAuthenticator(keyText.getText())) {
									registrationField[2] = keyText.getText(); // lName
									keyInput.setText("Please Enter Username:");
									hintText.setText("");
									count[0]++; // 3
								}
								else{
									hintText.setText("The first letter of a name must be uppercase, and the rest must be lowercase.");
								}
							}
							break;
							case 3: {
								if(ia.lengthAuthenticator(keyText.getText(), 0)) {
									registrationField[3] = keyText.getText(); // username
									keyInput.setText("Please Enter Password:");
									hintText.setText("");
									count[0]++; // 4
								}
								else{
									hintText.setText("Input must be between 1 & 16 characters");
								}
							}
							break;
							case 4: {
								if(ia.lengthAuthenticator(keyText.getText(), 0)) {
									registrationField[4] = keyText.getText(); // password
									keyInput.setText("Verify Password:");
									hintText.setText("");
									count[0]++; // 5
								}
								else{
									hintText.setText("Input must be between 1 & 16 characters");
								}
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
						// Usernames
						if(count[0] == 3 || count[0] == 4) {
							hintText.setText("Input must be between 1 & 16 characters");
						}
						// Everything else
						else{
							hintText.setText("Input must be between 1 & 32 characters");
						}
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
			AtomicReference<JScrollPane> staffPane = new AtomicReference<>();
			//JList staffList = ms.StaffSelections();
			final JList[] staffList = {new JList()};

			staffPane.set(new JScrollPane(staffList[0]));

			System.out.println("Registering Staff");
			add(display);

			/*display.add(backButton, BorderLayout.EAST);
			backButton.setText("Back");
			backButton.setVisible(false);
			backButton.addActionListener(e -> {
				count[0]--;

			});*/

			add(registration);
			add(hint);
			display.add(welcomeText);
				welcomeText.setText("Welcome Manager! Enter new staff information below:");

			registration.add(keyInput);
			keyInput.setText("Please Enter First Name:");
			registration.add(keyText);
			registration.add(submit);
			hint.add(hintText, BorderLayout.NORTH);


			add(staffPane.get());
			staffPane.get().setVisible(false);

			submit.addActionListener(e -> {
				if(ia.lengthAuthenticator(keyText.getText(), 1) || ia.lengthAuthenticator(input.get(), 1)) { //1 - 32 character length parameter.
					switch (count[0]){
						case 0: {
							if(ia.nameAuthenticator(keyText.getText())) {
								//backButton.setVisible(true);
								registrationField[0] = keyText.getText(); // fName
								keyInput.setText("Please Enter Last Name:");
								hintText.setText("");

								count[0]++; // 1
							}
							else{
								hintText.setText("The first letter of a name must be uppercase, and the rest must be lowercase.");
							}
						}
						break;
						case 1: {
							if(ia.nameAuthenticator(keyText.getText())) {

								registrationField[1] = keyText.getText(); // lName
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
							else{
								hintText.setText("The first letter of a name must be uppercase, and the rest must be lowercase.");
							}
						}
						break;
						case 2: {
							registrationField[2] = input.get(); // position
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
							keyInput.setText("Please Select Sex: ");
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
							registrationField[4] = input.get(); // sex
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

							count[0]++;
						}
						break;
						case 5: {
							if(ia.dateAuthenticator(dayField.getText(), monthField.getText(), keyText.getText())) {
								registrationField[5] = ia.dateForDatabase(dayField.getText(), monthField.getText(), keyText.getText()); //doB
								keyInput.setText("Please Enter Salary: $");
								hintText.setText("");

								keyText.setColumns(20);

								registration.remove(yearLabel);
								registration.remove(monthLabel);
								registration.remove(monthField);
								registration.remove(dayLabel);
								registration.remove(dayField);

								if (Integer.parseInt(registrationField[2]) == 2) { //if position == 2 (Manager) skip the supervisor selection. Managers have no supervisors.
									count[0] = count[0] + 2; }
								else {
									count[0]++;
								}
							}
							else{
								hintText.setText("Date entered must be valid.");
							}
						}
						break;
						case 6: {
							if(ia.moneyAuthenticator(keyText.getText())) {
								registrationField[6] = keyText.getText(); // salary
								keyInput.setText("Please Select Supervisor:");
								hintText.setText("");

								registration.remove(keyText);
								registration.remove(submit);
								remove(registration);
								remove(hint);

								MultibleSelections ms = new MultibleSelections();
								int selectedPosition = Integer.parseInt(registrationField[2]);

								if (selectedPosition == 1) {
									staffList[0] = ms.StaffSelections(2); // If position is supervisor, only return managers
								} else if (selectedPosition == 0) {
									staffList[0] = ms.StaffSelections(1); // If position is agent, only return supervisors
								}

								staffList[0].addListSelectionListener(e2 -> {
									String selection = "";
									Object obj[] = staffList[0].getSelectedValues();
									for (int i = 0; i < obj.length; i++) {
										selection += (String) obj[i];
									}
									//get id of whoever was selected
									String[] id = selection.split(" ");
									keyText.setText(id[4].substring(0, id[4].length() - 1));
								});
								staffPane.set(new JScrollPane(staffList[0]));

								add(staffPane.get());
								staffPane.get().setVisible(true);
								setSize(400, 350);

								add(registration);
								registration.add(submit);

								add(hint);
								hintText.setText("");

								count[0]++; // 3
							}
							else{
								hintText.setText("Salary must be entered in the form of a decimal number.");
							}
						}
						break;
						case 7: {
							if(Integer.parseInt(registrationField[2]) == 2){ //if position == 2 (Manager) skip the supervisor selection. Managers have no supervisors.
								registrationField[7] = "-1";
								if(ia.moneyAuthenticator(keyText.getText())) {
									registrationField[6] = keyText.getText(); // salary
								}
								else{
									hintText.setText("Salary must be entered in the form of a decimal number.");
									break;
								}
							}
							else{
								registrationField[7] = keyText.getText(); // supervisor
							}
								keyInput.setText("Please Enter Username:");
								hintText.setText("");
								staffPane.get().setVisible(false);

								registration.remove(submit);
								registration.add(keyText);
								keyText.setColumns(10);
								registration.add(submit);

								count[0]++; // 3
						}
						break;
						case 8: {
							if(ia.lengthAuthenticator(keyText.getText(), 0)) {
								if (ia.usernameAuthenticator(keyText.getText())) {
									registrationField[8] = keyText.getText(); // username
									keyInput.setText("Please Enter Password:");
									hintText.setText("");
									count[0]++; // 4
								}
								else {
									hintText.setText("That username is unavailable.");
								}
							}
							else{
								hintText.setText("Input must be between 1 & 16 characters");
							}
						}
						break;
						case 9: {
							if(ia.lengthAuthenticator(keyText.getText(), 0)) {
								registrationField[9] = keyText.getText(); // password
								keyInput.setText("Verify Password:");
								hintText.setText("");
								count[0]++; // 5
							}
							else{
								hintText.setText("Input must be between 1 & 16 characters");
							}
						}
						break;
						case 10: {
							// If passwords match, execute final user creation
							if(registrationField[9].equals(keyText.getText())){ // password authentication
								//Register new Staff member
								Staff staff = new Staff();
								Input staffInput = new Input("STAFF");

								String fName = "'" + registrationField[0] + "'";
								String lName = "'" + registrationField[1] + "'";
								int position = Integer.parseInt(registrationField[2]);
								String branch = "'" + registrationField[3] + "'";
								String sex = "'" + registrationField[4] + "'";
								String doB =  "'" + registrationField[5] + "'";
								String salary = "'" + registrationField[6] + "'";
								int supervisorID = Integer.parseInt(registrationField[7]);
								String username = "'" + registrationField[8] + "'";
								String password = "'" + staff.encryptPassword(registrationField[9]) + "'";

								staffInput.addStaffInfo(fName, lName, position, branch, sex,
										doB, salary,username,password,supervisorID);

								System.out.println("Creating Staff: " + fName + ", " + lName + ", " + position + ", " + branch
										+ ", " + sex + ", " + doB + ", " + salary + ", " + supervisorID + ", " + username + ", " + password);

								//Close window
								setVisible(false);
								setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							}
							// If they don't, passwords should be entered anew
							else{
								keyInput.setText("Please Enter Password:");
								hintText.setText("Passwords did not match. Please try again.");
								count[0] = 9;
							}
						}
					}
					if(count[0] != 5) {
						keyText.setText("");
					}
				}
				else{
					// Date of birth
					if(count[0] == 5) {
						hintText.setText("Date entered must be valid.");
					}
					// Usernames
					else if(count[0] == 8 || count[0] == 9) {
						hintText.setText("Input must be between 1 & 16 characters");
					}
					// Everything else
					else{
						hintText.setText("Input must be between 1 & 32 characters");
					}
				}
			});
		}
	}

	public void setItemClicked(String itemClicked){
		staffItemClicked = itemClicked;
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