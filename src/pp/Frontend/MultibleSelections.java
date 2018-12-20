package pp.Frontend;

import pp.Staff;
import pp.UserInterface;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.ArrayList;

//Class to generate dropdown lists of clickable Strings
public class MultibleSelections extends JFrame implements ListSelectionListener {
    JList<String> staffJList;
    Staff staff = new Staff();
    ArrayList<Staff> staffArray = new ArrayList<>();

    public JList<String> StaffSelections(int clearance) {
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        staffArray = staff.getStaffByPosition(clearance);
        String names[] = new String[staffArray.size()];
        //Fill the list with data
        for(int i = 0; i < names.length; i++){
            String position = Integer.toString(staffArray.get(i).getPosition());
            String fName = staffArray.get(i).getFname();
            String lName = staffArray.get(i).getLname();
            int id = staffArray.get(i).getStaffNum();
            if(position.equals("2")){
                position = "Manager";
            }
            else if(position.equals("1")){
                position = "Supervisor";
            }
            names[i] = "(" + position + ") " + fName + " " + lName + " (ID: " + id + ")";
        }

        staffJList = new JList<>(names) ;                    // creating JList object; pass the array as parameter
        staffJList.setVisibleRowCount(5);

        staffJList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

       // c.add(new JScrollPane(staffJList));

        staffJList.addListSelectionListener(this);

        return staffJList;

        //setTitle("Practcing Multiple selection JList");
       // setSize(300,300);
       // setVisible(true);
    }

    public void StaffSelections1() {
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        staffArray = staff.getStaffByID(0);
        String names[] = new String[staffArray.size()];
        //Fill the list with data
        for(int i = 0; i < names.length; i++){
            String fName = staffArray.get(i).getFname();
            String lName = staffArray.get(i).getLname();
            names[i] = fName + " " + lName;
        }

        staffJList = new JList<>(names) ;                    // creating JList object; pass the array as parameter
        staffJList.setVisibleRowCount(4);

        staffJList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        c.add(new JScrollPane(staffJList));

        staffJList.addListSelectionListener(this);

        //return new JScrollPane(staffJList);

        setTitle("Practcing Multiple selection JList");
         setSize(300,300);
         setVisible(true);
    }
    public void valueChanged(ListSelectionEvent e) {
        /*String selection = "";
        Object obj[] = staffJList.getSelectedValues();
        for(int i = 0; i < obj.length; i++) {
            selection += (String) obj[i];
        }
        UserInterface ui = new UserInterface();
        ui.setItemClicked(selection);
        //JOptionPane.showMessageDialog( null, "You clicked: " + selection,  "Learning Multiple Selections", JOptionPane.PLAIN_MESSAGE);
        */
    }
    public static void main(String args[]) {
        MultibleSelections ms = new MultibleSelections();
        ms.StaffSelections1();
    }
}