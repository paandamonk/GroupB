package pp;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AgentMenu extends JFrame implements ActionListener {

	private JPanel agentPanel;
	private JLabel agent;
	private String[] subChoices = {"View Agents","View Clients","View Properties"};
	private JComboBox choices;
	private JTextField search;
	private JLabel s;
	private JButton b;
	
	
	public AgentMenu(){
		setTitle("Agent Menu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new GridLayout(3,2));
		setSize(4000,3000);
		AgentMenu();
		add(agentPanel,BorderLayout.WEST);
		pack();
		setVisible(true);
		
		
	}
	
	public void AgentMenu(){
		agentPanel = new JPanel();
		agent = new JLabel("Welcome Agent!");
		s = new JLabel("Search:");
		search = new JTextField(20);
		b = new JButton("Search");
		choices = new JComboBox(subChoices);
		choices.setEditable(false);
		
		
		agentPanel.add(agent);
		agentPanel.add(choices);
		agentPanel.add(s);
		agentPanel.add(search);
		agentPanel.add(b);
		
		
		
		
	}

	
	
	
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
