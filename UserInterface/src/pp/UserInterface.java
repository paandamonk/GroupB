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
	
	

	private String[] Manager = {"Rob","robman","Dave","daveman"};
	private String[] Supervisors = {"Kenny", "kenman","Bob","bobman"};
	private String[] Agents = {"Connor", "cman","Lucas","lman"};
	private String[] allStaff = {"Rob","robman","Dave","daveman","Kenny", "kenman","Bob","bobman","Connor", "cman","Lucas","lman"};
	
	
	private JPanel usP;
	private JPasswordField PasswordText;
	private JTextField UsernameText;
	private JLabel PassPrompt;
	private JLabel UserPrompt;
	private JButton Login;
	private JPanel manPanel;
	private JLabel man;
	private JFrame second;
	
	public UserInterface(){
		setTitle("Proper Properties");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new GridLayout(3,2));
		setSize(1500,3000);
		buildLogin();
		add(usP, BorderLayout.WEST);
		pack();
		setVisible(true);
	}
	private void buildLogin(){
		usP = new JPanel();
		UserPrompt = new JLabel("Username: ");
		UserPrompt.setFont(new Font("Times New Roman", 15,15));
		UsernameText = new JTextField(20);
		UsernameText.setEditable(true);		
		PassPrompt = new JLabel("Password: ");
		PasswordText = new JPasswordField(20);
		PasswordText.setEditable(true);
		PasswordText.setEchoChar('*');
		Login = new JButton("Login");
		Login.addActionListener(this);
		usP.add(UserPrompt);
		usP.add(UsernameText);
		usP.add(PassPrompt);
		usP.add(PasswordText);
		usP.add(Login);
		/*final String Username = UsernameText.getText();
		final String Password = PasswordText.getText();
		if(checkPass(Username, Password)) TopMenu(Username);
		else{
			System.out.println("Invalid Password");
			buildLogin();
		}*/
		
	}
	
	
	public boolean checkPass(String user, String Password){
			return true;
		//if(user.getpass() == Password)	return true;
		//else return false;
	}
	/*private void TopMenu(String user){
		int CL = checkClear(user);
		if(CL == 3){
			System.out.println("Welcome, Rob");
			ManagerMenu();
			
		}
		if(CL == 2){
			System.out.println("Welcome, Kenny");
			SupMenu();
		}
		if(CL == 1){
			System.out.println("welcome, connor");
			AgentMenu();
		}*/
		
	private int checkClear(){
		int CL = 0;
		if(user == "rob"){
			return(3);
		}
		if(user == "kenny"){
			return(2);
		}
		if(user == "connor"){
			return(1);
		}
		return 0;
		//int CL = user.getCL();
		//return CL;
	}
	

	
	 public void actionPerformed(ActionEvent e){
	 String action = e.getActionCommand();
	 
	 String user = UsernameText.getText();
	 String pass = PasswordText.getText();
	 
	boolean in = false;
	while (in != true){
		if (action.equals("Login")){
			for(int i = 0; i < allStaff.length; i+=2){
				if(allStaff[i].equals(user) && allStaff[i+1].equals(pass)){
					setVisible(false);
					setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					if(allStaff[i].checkClear() == 2){
						ManagerMen m = new ManagerMen();
					}
					if(allStaff[i].getCL() = 1){
						SubMenu m = new SubMenu();
					}
					if(allStaff[i].getCL() = 0){
						AgentMenu m = new AgentMenu();
					}
				}
			}
		}
	}
	if(action.equals("Login")){
		for(int i = 0; i< Manager.length; i+=2){
		if(Manager[i].equals(user)&& Manager[i+1].equals(pass)){
			setVisible(false);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			ManagerMen m = new ManagerMen();
			
		}
				
		
		}
		
	
		
		for(int i = 0; i<Supervisors.length;i+=2){
			if(Supervisors[i].equals(user)&& Supervisors[i+1].equals(pass)){
				setVisible(false);
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				SubMenu s = new SubMenu();
				
			}
			
			
		}
		
		
		for(int i = 0; i< Agents.length;i+=2){
			if(Agents[i].equals(user)&& Agents[i+1].equals(pass)){
				setVisible(false);
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				AgentMenu a = new AgentMenu();
				
			}
			
			
		}
	
	
	
	 }
	
	
	
	

	
	}
	
}



	


