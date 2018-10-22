package pp;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SubMenu extends JFrame implements ActionListener {

	
	private JPanel subPanel;
	private JLabel sub;
	private String[] subChoices = {"View Supervisors","View Agents","View Clients","View Properties"};
	private JComboBox choices;
	private JTextField search;
	private JLabel s;
	private JButton b;
	
	
	public SubMenu(){
		setTitle("Supervisor Menu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new GridLayout(3,2));
		setSize(4000,3000);
		SubMenu();
		add(subPanel,BorderLayout.WEST);
		pack();
		setVisible(true);
		
		
	}
	
	public void SubMenu(){
		subPanel = new JPanel();
		sub = new JLabel("Welcome Supervisor!");
		s = new JLabel("Search:");
		search = new JTextField(20);
		b = new JButton("Search");
		choices = new JComboBox(subChoices);
		choices.setEditable(false);
		
		
		subPanel.add(sub);
		subPanel.add(choices);
		subPanel.add(s);
		subPanel.add(search);
		subPanel.add(b);
		
		
		
	}

	
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
