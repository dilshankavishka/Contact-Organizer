import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

class Window extends JFrame{
		
	private JButton AddContact;
	private JButton SearchContact;
	private JButton DeleteContact;
	private JButton ViewContact;
	private JButton UpdateContact;
	private JButton Exit;
	
	private JLabel title;
	private JLabel head;
	
	private AddCustomerForm addCustomerForm;
	private ViewCustomerForm viewCustomerForm;
	private SearchContacts searchContact;
	private UpdateContacts updateContact;
	private DeleteContacts deleteContact;

	Window(){
		setSize(900,550);
		setTitle("iFriend Contact Organizer");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		
		JPanel panel= new JPanel();
		panel.setBounds(0,0,400,550);
		panel.setBackground(new Color(24, 97, 86));
		
		
		head = new JLabel("iFriend Contact\n Organizer", SwingConstants.CENTER);
		head.setBounds(50,0,300,150);
		head.setFont(new Font("",1,30));
		head.setForeground(new Color(8, 8, 8));
		panel.add(head);
		
		ImageIcon imageIcon = new ImageIcon("img\\1.jpeg");
        JLabel imageLabel = new JLabel(imageIcon);
        panel.add(imageLabel);
		add(panel);
		
		JPanel panel1= new JPanel();
		panel1.setLayout(null);
		panel1.setBounds(400,0,500,550);
		panel1.setBackground(new Color(50, 168, 157));
		
		title=new JLabel("HOMEPAGE", SwingConstants.CENTER);//
		title.setBounds(50,10,400,50);
		title.setFont(new Font("",1,25));
		title.setForeground(new Color(8, 8, 8));
		panel1.add(title);
		
		AddContact=new JButton("Add New Contacts");
		AddContact.setFont(new Font("",1,20));
		AddContact.setBounds(125,70,250,50);
		AddContact.setBackground(new Color(169, 207, 203));
		AddContact.setForeground(new Color(5, 43, 40));
		AddContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(addCustomerForm==null){
					addCustomerForm=new AddCustomerForm();
				}
				addCustomerForm.setVisible(true);
			}
		});					
		panel1.add(AddContact);
		
		UpdateContact=new JButton("Update Contacts");
		UpdateContact.setFont(new Font("",1,20));
		UpdateContact.setBounds(125,130,250,50);
		UpdateContact.setBackground(new Color(169, 207, 203));
		UpdateContact.setForeground(new Color(5, 43, 40));
		UpdateContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(updateContact==null){
					updateContact=new UpdateContacts();
				}
				updateContact.setVisible(true);
			}
		});
		panel1.add(UpdateContact);
		
		SearchContact=new JButton("Search Contacts");
		SearchContact.setFont(new Font("",1,20));
		SearchContact.setBounds(125,190,250,50);
		SearchContact.setBackground(new Color(169, 207, 203));
		SearchContact.setForeground(new Color(5, 43, 40));
		SearchContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(searchContact==null){
					searchContact=new SearchContacts();
				}
				searchContact.setVisible(true);
			}
		});
		panel1.add(SearchContact);
		
		DeleteContact=new JButton("Delete Contacts");
		DeleteContact.setFont(new Font("",1,20));
		DeleteContact.setBounds(125,250,250,50);
		DeleteContact.setBackground(new Color(169, 207, 203));
		DeleteContact.setForeground(new Color(5, 43, 40));
		DeleteContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(deleteContact==null){
					deleteContact=new DeleteContacts();
				}
				deleteContact.setVisible(true);
			}
		});
		panel1.add(DeleteContact);
		
		ViewContact=new JButton("View Contacts");
		ViewContact.setFont(new Font("",1,20));
		ViewContact.setBounds(125,310,250,50);
		ViewContact.setBackground(new Color(169, 207, 203));
		ViewContact.setForeground(new Color(5, 43, 40));
		ViewContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(viewCustomerForm==null){
					viewCustomerForm=new ViewCustomerForm();
				}
				viewCustomerForm.setVisible(true);
			}
		});	
		panel1.add(ViewContact);
		
		Exit=new JButton("Exit");
		Exit.setFont(new Font("",1,20));
		Exit.setBounds(325,400,125,50);
		Exit.setBackground(new Color(169, 207, 203));
		Exit.setForeground(new Color(5, 43, 40));
		Exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				System.exit(0);
			}
		});	
		panel1.add(Exit);
		
		add(panel1);
	
	}	
}
class MainWindow{
	public static void main(String args[]){
		new Window().setVisible(true);
	}
}
