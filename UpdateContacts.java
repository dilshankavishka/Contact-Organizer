import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

class UpdateContacts extends JFrame{
	private JButton Search;
	private JButton Cancel;
	private JButton Home;
	private JButton Update;
	
	private JTextField Id;
	private JTextField Name;
	private JTextField Salary;
	private JTextField Birthday;
	private JTextField Company;
	private JTextField PhoNumber;
	private JTextField SearchField;
	
	private JLabel Title;
	
	private int index;
	
	UpdateContacts(){
		setSize(800,500);
		setTitle("Update Contacts");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBounds(0,0,800,500);
		panel1.setBackground(new Color(78, 133, 130));
		
		Title=new JLabel("Update Contact Details", SwingConstants.CENTER);
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
				index = ContactsController.searchFunction(txtSearch);
				
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
		
		Update= new JButton("Update");
		Update.setFont(new Font("",1,18));
		Update.setBounds(400,400,125,40);
		Update.setBackground(new Color(169, 207, 203));
		Update.setForeground(new Color(5, 43, 40));
		Update.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){											
				String date=Birthday.getText();
				boolean valid = ContactsController.isValidBirthday(date);
				if(!valid){
					int option=JOptionPane.showConfirmDialog(null,"Invalid Birthday...Do you want to input again?","confirm box",JOptionPane.YES_NO_OPTION);
					if(option==JOptionPane.YES_OPTION){
						Birthday.setText("");
						Birthday.requestFocus();
					}else if(option==JOptionPane.NO_OPTION){
						dispose();
					}						
			}
			
			String number1=PhoNumber.getText();
				boolean valid1 = ContactsController.phoneNumberCheck(number1);
				if(!valid1){
					int option=JOptionPane.showConfirmDialog(null,"Invalid phone number...Do you want to input again?","confirm box",JOptionPane.YES_NO_OPTION);
					if(option==JOptionPane.YES_OPTION){
						PhoNumber.setText("");
						PhoNumber.requestFocus();
					}else if(option==JOptionPane.NO_OPTION){
						dispose();
					}						
			}
										
				String id=Id.getText();
				String name=Name.getText();
				//String number=PhoNumber.getText();
				String company=Company.getText();
				Double salary=Double.parseDouble(Salary.getText());
				//String bod=Birthday.getText();	
				
				if(valid1 && valid){
					
					Contact c1 = DBConnection.getInstance().getContactList().get(index);
					c1.setcusId(id);
					c1.setName(name);
					c1.setNumber(number1);
					c1.setCompany(company);
					c1.setSalary(salary);
					c1.setBirthday(date);	
				
					Id.setText("");
					Name.setText("");
					PhoNumber.setText("");
					Company.setText("");
					Salary.setText("");
					Birthday.setText("");
				
				JOptionPane.showMessageDialog(null,"Contact Updated successfully","Success",JOptionPane.INFORMATION_MESSAGE);
				}										
			}
		});
		panel1.add(Update);
		
		Home = new JButton("Back to HomePage");
		Home.setFont(new Font("",1,18));
		Home.setBounds(550,400,200,40);
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
