package pp;

import javax.swing.JFrame;
import javax.swing.*;
import java.util.*;
import java.util.List;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class UserInterface extends JFrame implements ActionListener {

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
	private JTextField UsernameText;
	private JLabel PassPrompt;
	private JLabel UserPrompt;
	private JButton Login;
	private JPanel manPanel;
	private JLabel man;
	private JFrame second;

	public UserInterface() {
		setTitle("Proper Properties");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new GridLayout(3, 2));
		setSize(1500, 3000);
		buildLogin();
		add(usP, BorderLayout.WEST);
		pack();
		setVisible(true);
	}

	private void buildLogin() {
		usP = new JPanel();
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
		getRootPane().setDefaultButton(Login);
		
		usP.add(UserPrompt);
		usP.add(UsernameText);
		usP.add(PassPrompt);
		usP.add(PasswordText);
		usP.add(Login);

	}


	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();

		String user = UsernameText.getText();
		String pass = PasswordText.getText();
		boolean in = false;
		if (action.equals("Login")) {
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