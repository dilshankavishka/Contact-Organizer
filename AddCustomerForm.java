import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

class AddCustomerForm extends JFrame{
	private JButton Add;
	private JButton Cancel;
	private JButton Home;
	
	private JTextField Id;
	private JTextField Name;
	private JTextField Salary;
	private JTextField Birthday;
	private JTextField Company;
	private JTextField PhoNumber;
	
	private JLabel Title;
	
	AddCustomerForm(){
		setSize(800,500);
		setTitle("Add Details");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBounds(0,0,800,500);
		panel1.setBackground(new Color(78, 133, 130));
		
		Title=new JLabel("Add Contact Details", SwingConstants.CENTER);
		Title.setBounds(0,0,800,50);
		Title.setFont(new Font("",1,25));
		Title.setForeground(new Color(8, 8, 8));
		Title.setBackground(new Color(20, 66, 87));
		panel1.add(Title);
				
		JLabel ID=new JLabel("Contact ID");
		ID.setBounds(25,60,200,40);
		ID.setFont(new Font("",1,25));
		ID.setForeground(new Color(17, 56, 74));
		ID.setBackground(new Color(78, 133, 130));
		panel1.add(ID);
		
		Id= new JTextField();
		Id.setBounds(300,65,250,30);
		Id.setFont(new Font("",1,25));
		Id.setText(ContactsController.generateId());

		panel1.add(Id);
		
		JLabel NAME=new JLabel("Name");
		NAME.setBounds(25,100,200,40);
		NAME.setFont(new Font("",1,25));
		NAME.setForeground(new Color(17, 56, 74));
		NAME.setBackground(new Color(78, 133, 130));
		panel1.add(NAME);
		
		Name =new JTextField();
		Name.setBounds(300,105,250,30);
		Name.setFont(new Font("",1,25));
		panel1.add(Name);
		
		JLabel NUM=new JLabel("Contact Number");
		NUM.setBounds(25,140,200,40);
		NUM.setFont(new Font("",1,25));
		NUM.setForeground(new Color(17, 56, 74));
		NUM.setBackground(new Color(78, 133, 130));		
		panel1.add(NUM);
		
		PhoNumber=new JTextField();
		PhoNumber.setBounds(300,145,250,30);
		PhoNumber.setFont(new Font("",1,25));
		panel1.add(PhoNumber);
		
		JLabel COM=new JLabel("Company Name");
		COM.setBounds(25,180,200,40);
		COM.setFont(new Font("",1,25));
		COM.setForeground(new Color(17, 56, 74));
		COM.setBackground(new Color(78, 133, 130));
		panel1.add(COM);
		
		Company = new JTextField();
		Company.setBounds(300,185,250,30);
		Company.setFont(new Font("",1,25));
		panel1.add(Company);
		
		JLabel SAL=new JLabel("Salary");
		SAL.setBounds(25,220,200,40);
		SAL.setFont(new Font("",1,25));
		SAL.setForeground(new Color(17, 56, 74));
		SAL.setBackground(new Color(78, 133, 130));
		panel1.add(SAL);
		
		Salary = new JTextField();
		Salary.setBounds(300,225,250,30);
		Salary.setFont(new Font("",1,25));
		panel1.add(Salary);
		
		JLabel BOD=new JLabel("Birthday");
		BOD.setBounds(25,260,200,40);
		BOD.setFont(new Font("",1,25));
		BOD.setForeground(new Color(17, 56, 74));
		BOD.setBackground(new Color(78, 133, 130));
		panel1.add(BOD);
		
		Birthday = new JTextField();
		Birthday.setBounds(300,265,250,30);
		Birthday.setFont(new Font("",1,25));
		
		panel1.add(Birthday);
		
		Add = new JButton("Add");
		Add.setFont(new Font("",1,20));
		Add.setBounds(500,350,75,40);
		Add.setBackground(new Color(169, 207, 203));
		Add.setForeground(new Color(5, 43, 40));
		Add.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if (Name.getText().isEmpty() || PhoNumber.getText().isEmpty() || Company.getText().isEmpty() || Salary.getText().isEmpty() || 
					Birthday.getText().isEmpty()) {
                   
                    JOptionPane.showMessageDialog(null, "All fields must be filled out", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
				String date=Birthday.getText();
				boolean valid = ContactsController.isValidBirthday(date);
				if(!valid){
					int option=JOptionPane.showConfirmDialog(null,"Invalid Birthday...Do you want to input again?","confirm box",JOptionPane.YES_NO_OPTION);
					if(option==JOptionPane.YES_OPTION){
						Birthday.setText("");
						Birthday.requestFocus();
					}else if(option==JOptionPane.NO_OPTION){
						String txt=ContactsController.generateId();
						Id.setText(txt);
						Name.setText("");
						PhoNumber.setText("");
						Company.setText("");
						Salary.setText("");
						Birthday.setText("");
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
						String txt=ContactsController.generateId();
						Id.setText(txt);
						Name.setText("");
						PhoNumber.setText("");
						Company.setText("");
						Salary.setText("");
						Birthday.setText("");
						dispose();
					}						
			}
										
				String id=Id.getText();
				String name=Name.getText();
				String number=PhoNumber.getText();
				String company=Company.getText();
				Double salary=Double.parseDouble(Salary.getText());
				String bod=Birthday.getText();	
				
				if(valid1 && valid){
				
					ArrayList<Contact>contactList = DBConnection.getInstance().getContactList()	;
					Contact c1 =new Contact(id,name,number	,company,salary,bod);
					contactList.add(c1);	
					
					JOptionPane.showMessageDialog(null,"Contact Added successfully","Success",JOptionPane.INFORMATION_MESSAGE);
									
					String txt=ContactsController.generateId();
					Id.setText(txt);
					Name.setText("");
					PhoNumber.setText("");
					Company.setText("");
					Salary.setText("");
					Birthday.setText("");
				}		
		}
		});
		panel1.add(Add);
		
		Cancel = new JButton("Cancel");
		Cancel.setFont(new Font("",1,20));
		Cancel.setBounds(600,350,100,40);
		Cancel.setBackground(new Color(169, 207, 203));
		Cancel.setForeground(new Color(5, 43, 40));
		Cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){							
				String txt=ContactsController.generateId();
				Id.setText(txt);
				Name.setText("");
				PhoNumber.setText("");
				Company.setText("");
				Salary.setText("");
				Birthday.setText("");		
		}
		});
		panel1.add(Cancel);
		
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
