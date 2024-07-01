import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.table.*;

class ListContactsByName extends JFrame{
	private JTable customerDetails;
	private DefaultTableModel dtm;
	
	private JButton Close;
	
	ListContactsByName(){
		setSize(900,550);
		setTitle("Sorted by Name");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		
		JPanel panel1=new JPanel();
		panel1.setLayout(null);
		panel1.setBounds(0,0,900,550);
		panel1.setBackground(new Color(50, 168, 157));
		
		String[] columnName={"Contact ID", "Name","Contact Number","Company Name","Salary","Birthday"};
		dtm=new DefaultTableModel(columnName,0);
		customerDetails=new JTable(dtm);
		JScrollPane tablePane=new JScrollPane(customerDetails);
		tablePane.setBounds(0, 0, 900, 450);
		for (Contact contact : ContactsController.nameSort()) {
			Object[] rowdata ={contact.getcusId(), contact.getName(), contact.getNumber(), contact.getCompany(), contact.getSalary(), contact.getBirthday()};
			dtm.addRow(rowdata);
		}
		panel1.add(tablePane);
		
		JButton Close = new JButton("Close");
		Close.setFont(new Font("",1,20));
		Close.setBounds(700, 465, 150, 30);
		Close.setBackground(new Color(169, 207, 203));
		Close.setForeground(new Color(5, 43, 40));
		Close.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
		}
		});
        panel1.add(Close);
        
		add(panel1);
	}
}
