import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

class SearchContacts extends JFrame{
	private JButton Search;
	private JButton Cancel;
	private JButton Home;
	
	private JTextField Id;
	private JTextField Name;
	private JTextField Salary;
	private JTextField Birthday;
	private JTextField Company;
	private JTextField PhoNumber;
	private JTextField SearchField;
	
	private JLabel Title;
	
	SearchContacts(){
		setSize(800,500);
		setTitle("Search Contacts");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBounds(0,0,800,500);
		panel1.setBackground(new Color(78, 133, 130));
		
		Title=new JLabel("Search Contact Details", SwingConstants.CENTER);
		Title.setBounds(0,0,800,50);
		Title.setFont(new Font("",1,25));
		Title.setForeground(new Color(8, 8, 8));
		Title.setBackground(new Color(20, 66, 87));
		panel1.add(Title);
		
		SearchField = new JTextField();
		SearchField.setBounds(25,60,350,40);
		SearchField.setFont(new Font("",1,25));
		panel1.add(SearchField);
		
		Search = new JButton("Search");
		Search.setFont(new Font("",1,20));
		Search.setBounds(500,60,150,40);
		Search.setBackground(new Color(169, 207, 203));
		Search.setForeground(new Color(5, 43, 40));
		Search.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){							
				String txtSearch = SearchField.getText();
				int index = ContactsController.searchFunction(txtSearch);
				
				if(index==-1){
					
					JOptionPane.showMessageDialog(null, "Invalid input...try again", "Error", JOptionPane.ERROR_MESSAGE);
                    SearchField.setText("");
					SearchField.requestFocus();
                    return;
				}
				
				Contact c1 = DBConnection.getInstance().getContactList().get(index);
				Id.setText(c1.getcusId());
				Name.setText(c1.getName());
				PhoNumber.setText(c1.getNumber());
				Company.setText(c1.getCompany());
				Salary.setText(Double.toString(c1.getSalary()));
				Birthday.setText(c1.getBirthday());									
			}
		});
		panel1.add(Search);
		
		Cancel = new JButton("Clear");
		Cancel.setFont(new Font("",1,20));
		Cancel.setBounds(675,60,100,40);
		Cancel.setBackground(new Color(169, 207, 203));
		Cancel.setForeground(new Color(5, 43, 40));
		Cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				SearchField.setText("");
				Id.setText("");
				Name.setText("");
				PhoNumber.setText("");
				Company.setText("");
				Salary.setText("");
				Birthday.setText("");
		}
		});
		panel1.add(Cancel);
				
		JLabel ID=new JLabel("Contact ID");
		ID.setBounds(25,140,200,40);
		ID.setFont(new Font("",1,25));
		ID.setForeground(new Color(17, 56, 74));
		ID.setBackground(new Color(78, 133, 130));
		panel1.add(ID);
		
		Id= new JTextField();
		Id.setBounds(300,145,250,30);
		Id.setFont(new Font("",1,25));
		panel1.add(Id);
		
		JLabel NAME=new JLabel("Name");
		NAME.setBounds(25,180,200,40);
		NAME.setFont(new Font("",1,25));
		NAME.setForeground(new Color(17, 56, 74));
		NAME.setBackground(new Color(78, 133, 130));
		panel1.add(NAME);
		
		Name =new JTextField();
		Name.setBounds(300,185,250,30);
		Name.setFont(new Font("",1,25));
		panel1.add(Name);
		
		JLabel NUM=new JLabel("Contact Number");
		NUM.setBounds(25,220,200,40);
		NUM.setFont(new Font("",1,25));
		NUM.setForeground(new Color(17, 56, 74));
		NUM.setBackground(new Color(78, 133, 130));
		panel1.add(NUM);
		
		PhoNumber=new JTextField();
		PhoNumber.setBounds(300,225,250,30);
		PhoNumber.setFont(new Font("",1,25));
		panel1.add(PhoNumber);
		
		JLabel COM=new JLabel("Company Name");
		COM.setBounds(25,260,200,40);
		COM.setFont(new Font("",1,25));
		COM.setForeground(new Color(17, 56, 74));
		COM.setBackground(new Color(78, 133, 130));
		panel1.add(COM);
		
		Company = new JTextField();
		Company.setBounds(300,265,250,30);
		Company.setFont(new Font("",1,25));
		panel1.add(Company);
		
		JLabel SAL=new JLabel("Salary");
		SAL.setBounds(25,300,200,40);
		SAL.setFont(new Font("",1,25));
		SAL.setForeground(new Color(17, 56, 74));
		SAL.setBackground(new Color(78, 133, 130));
		panel1.add(SAL);
		
		Salary = new JTextField();
		Salary.setBounds(300,305,250,30);
		Salary.setFont(new Font("",1,25));
		panel1.add(Salary);
		
		JLabel BOD=new JLabel("Birthday");
		BOD.setBounds(25,340,200,40);
		BOD.setFont(new Font("",1,25));
		BOD.setForeground(new Color(17, 56, 74));
		BOD.setBackground(new Color(78, 133, 130));
		panel1.add(BOD);
		
		Birthday = new JTextField();
		Birthday.setBounds(300,345,250,30);
		Birthday.setFont(new Font("",1,25));
		panel1.add(Birthday);
						
		Home = new JButton("Back to HomePage");
		Home.setFont(new Font("",1,18));
		Home.setBounds(500,400,200,40);
		Home.setBackground(new Color(169, 207, 203));
		Home.setForeground(new Color(5, 43, 40));
		Home.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){							
						dispose();		
		}
		});
		panel1.add(Home);
		
		add(panel1);
		
	}
}
