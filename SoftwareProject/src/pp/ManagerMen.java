package pp;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ManagerMen extends JFrame implements ActionListener {

	
	private JPanel manPanel;
	private JLabel man;
	private String[] manChoices = {"View Managers","View Supervisors","View Agents","View Employees Salaries","View Clients","View Properties"};
	private JComboBox choices;
	private JTextField search;
	private JLabel s;
	private JButton b;
	
	
	public ManagerMen(){
		setTitle("Manager Menu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new GridLayout(1,3));
		setSize(4000,3000);
		ManagerMenu();
		add(manPanel,("1"));
		pack();
		setVisible(true);
		
		
	}
	
	public void ManagerMenu(){
		manPanel = new JPanel();
		man = new JLabel("Welcome Manager!");
		s = new JLabel("Search:");
		search = new JTextField(20);
		b = new JButton("Search");
		choices = new JComboBox(manChoices);
		choices.setEditable(false);
		manPanel.add(man);
		manPanel.add(choices);
		manPanel.add(s);
		manPanel.add(search);
		manPanel.add(b);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}
