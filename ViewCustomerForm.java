import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

class ViewCustomerForm extends JFrame{
	private JButton ListByName;
	private JButton ListBySalary;
	private JButton ListByBirthday;	
	
	private JLabel Title;
	
	private ListContactsByName listContactsByName;
	private ListContactsByBirthday listContactsByBirthday;
	private ListContactsBySalary listContactsBySalary;
	
	ViewCustomerForm(){
		setSize(400,400);
		setTitle("View Details");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBounds(0,0,400,400);
		panel1.setBackground(new Color(78, 133, 130));
		
		Title=new JLabel("View Contact Details", SwingConstants.CENTER);
		Title.setBounds(0,0,400,50);
		Title.setFont(new Font("",1,25));
		Title.setForeground(new Color(8, 8, 8));
		Title.setBackground(new Color(20, 66, 87));
		panel1.add(Title);
		
		ListByName=new JButton("List By Name");
		ListByName.setFont(new Font("",1,20));
		ListByName.setBounds(100,80,200,50);
		ListByName.setBackground(new Color(169, 207, 203));
		ListByName.setForeground(new Color(5, 43, 40));
		ListByName.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				listContactsByName=new ListContactsByName();
				listContactsByName.setVisible(true);
			}
		});	
		panel1.add(ListByName);
		
		ListBySalary=new JButton("List By Salary");
		ListBySalary.setFont(new Font("",1,20));
		ListBySalary.setBounds(100,150,200,50);
		ListBySalary.setBackground(new Color(169, 207, 203));
		ListBySalary.setForeground(new Color(5, 43, 40));
		ListBySalary.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				listContactsBySalary=new ListContactsBySalary();
				listContactsBySalary.setVisible(true);
			}
		});	
		panel1.add(ListBySalary);
		
		ListByBirthday=new JButton("List By Birthday");
		ListByBirthday.setFont(new Font("",1,20));
		ListByBirthday.setBounds(100,220,200,50);
		ListByBirthday.setBackground(new Color(169, 207, 203));
		ListByBirthday.setForeground(new Color(5, 43, 40));
		ListByBirthday.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){				
					listContactsByBirthday=new ListContactsByBirthday();
					listContactsByBirthday.setVisible(true);
			}	
		});	
		panel1.add(ListByBirthday);
		
		add(panel1);
		
	}
}
