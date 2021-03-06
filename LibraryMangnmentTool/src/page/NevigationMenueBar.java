package page;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.JTableHeader;

import common.service.Factory;
import model.CustomerModel;
import service.CustomerService;

public class NevigationMenueBar implements ActionListener {
	private JPanel panel;
	private JPanel bodyPanel ;
	private JFrame mainframe;
	private List<JButton> butt =new ArrayList();
	String userName="";
	public NevigationMenueBar(String userName){
		this.userName=userName;
	}
	public void manueBar(JFrame mainframe){
		this.mainframe=mainframe;
		panel = new JPanel();
		panel.setBackground(new Color(105, 105, 105));
		panel.setForeground(Color.WHITE);
		panel.setLayout(null);
		panel.setBounds(10, 63, 195, 593);
		mainframe.getContentPane().add(panel);
		
		//JButton btnNewButton_1 = new JButton("Add Book                            ");
		JButton btnNewButton_1 = new JButton("Add Book");
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		//btnNewButton_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("../img/java_jar.gif")));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnNewButton_1.setBackground(Factory.backGroundColor);
		btnNewButton_1.setBounds(0, 4, 205, 44);
		//btnNewButton_1.setBorder(null);
		btnNewButton_1.addActionListener(this);
		panel.add(btnNewButton_1);
		
		//JButton viewBookBtn = new JButton("Book List                            ");
		JButton viewBookBtn = new JButton("Book List");
		viewBookBtn.setHorizontalAlignment(SwingConstants.LEFT);
		viewBookBtn.setForeground(Color.WHITE);
		viewBookBtn.setBackground(Factory.backGroundColor);
		viewBookBtn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		viewBookBtn.setBounds(0, 47, 205, 44);
		viewBookBtn.addActionListener(this);
		panel.add(viewBookBtn);
		
		
		
		//JButton btnNewButton = new JButton("Add Student                      ");
		JButton btnNewButton = new JButton("Add Student");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Factory.backGroundColor);
		btnNewButton.setBounds(0, 88, 205, 44);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnNewButton.addActionListener(this);
		panel.add(btnNewButton);
		
		//JButton StudentlistButton = new JButton("Student List                      ");
		JButton StudentlistButton = new JButton("Student List");
		StudentlistButton.setHorizontalAlignment(SwingConstants.LEFT);
		StudentlistButton.setForeground(Color.WHITE);
		StudentlistButton.setBackground(Factory.backGroundColor);
		StudentlistButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		StudentlistButton.addActionListener(this);
		StudentlistButton.setBounds(0, 131, 205, 44);
		panel.add(StudentlistButton);
		
		//JButton btnNewButton_4 = new JButton("User Creation                   ");
		JButton btnNewButton_4 = new JButton("User Creation");
		btnNewButton_4.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setBackground(Factory.backGroundColor);
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnNewButton_4.addActionListener(this);
		btnNewButton_4.setBounds(0, 173, 205, 44);
		panel.add(btnNewButton_4);
		
		//JButton transection = new JButton("View transection               ");
		JButton transection = new JButton("View transection");
		transection.setHorizontalAlignment(SwingConstants.LEFT);
		transection.setForeground(Color.WHITE);
		transection.setBackground(Factory.backGroundColor);
		transection.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		transection.addActionListener(this);
		transection.setBounds(0, 216, 205, 44);
		panel.add(transection);
		
		JButton Contact = new JButton("Contact us");
		//JButton Contact = new JButton("Contact us                           ");
		Contact.setHorizontalAlignment(SwingConstants.LEFT);
		Contact.setForeground(Color.WHITE);
		Contact.setBackground(Factory.backGroundColor);
		Contact.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		Contact.addActionListener(this);
		Contact.setBounds(0, 259, 205, 44);
		panel.add(Contact);
		
	//	JButton btnNewButton_3 = new JButton("Lock                                    ");
		JButton btnNewButton_3 = new JButton("Lock");
		//btnNewButton_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lock.ico")));
		btnNewButton_3.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(Factory.backGroundColor);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		//btnNewButton_3.setBorder(null);
		btnNewButton_3.setBounds(0, 302, 205, 44);
		btnNewButton_3.addActionListener(this);
		panel.add(btnNewButton_3);
		
		//JButton btnNewButton_2 = new JButton("Exit                                     ");
		JButton btnNewButton_2 = new JButton("Exit");
		//btnNewButton_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/exit2.png")));
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Factory.backGroundColor);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnNewButton_2.setBounds(0, 345, 205, 44);
		btnNewButton_2.addActionListener(this);
		panel.add(btnNewButton_2);
		
		/*JButton btnNewButton_5 = new JButton("Submit Book                     ");
		btnNewButton_5.setForeground(Color.WHITE);
		btnNewButton_5.setBackground(new Color(105, 105, 105));
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		//btnNewButton_5.setBorder(null);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnNewButton_5);
		
	*/	bodyPanel = new JPanel();
		bodyPanel.setBounds(208, 63, 1149, 593);
		//bodyPanel.setBackground(new Color(213, 134, 145, 100));
		bodyPanel.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.5f));
		mainframe.getContentPane().add(bodyPanel);
		bodyPanel.setLayout(null);
		Factory.setBodyPanal(bodyPanel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 11, 1342, 41);
		mainframe.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(1229, 11, 103, 23);
		btnLogout.addActionListener(this);
		panel_3.add(btnLogout);
		
		JLabel lblNewLabel_1 = new JLabel(userName);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(1086, 15, 133, 14);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblPatnaCentralSchool = new JLabel(Factory.organizationName);
		lblPatnaCentralSchool.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblPatnaCentralSchool.setBounds(543, 11, 318, 18);
		panel_3.add(lblPatnaCentralSchool);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 667, 1347, 27);
		mainframe.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JLabel version = new JLabel("Version :- "+Factory.version);
		version.setHorizontalAlignment(SwingConstants.CENTER);
		version.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		version.setBounds(10, 0, 110, 25);
		panel_4.add(version);
		
		JLabel lblDate = new JLabel("Date :");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblDate.setBounds(963, 0, 101, 25);
		panel_4.add(lblDate);
		
		JLabel lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setBounds(1090, 7, 213, 14);
		panel_4.add(lblNewLabel_2);
		
		new timeUpdate(lblNewLabel_2).start();
		butt.add(btnNewButton_1);
		butt.add(viewBookBtn);
		butt.add(btnNewButton);
		butt.add(StudentlistButton);
		butt.add(btnNewButton_4);
		butt.add(transection);
		butt.add(Contact);
		butt.add(btnNewButton_3);
		butt.add(btnNewButton_2);
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand().trim();
		System.out.println(""+action);
		
		for(int i=0;i<butt.size();i++){
				if(butt.get(i).getActionCommand().trim()==action){
					butt.get(i).setBackground(Factory.onClickColor);
				}else{
					butt.get(i).setBackground(Factory.backGroundColor);
				}
				
			}
		switch (action) {
		case "Add Student":EventQueue.invokeLater(new Runnable() {
														
														@Override
														public void run() {
															bodyPanel.removeAll();
															RegistrationPage registrationPage=new RegistrationPage();
															registrationPage.registrationPage(bodyPanel);
															Factory.refresh();
														}
													});
			break;
			
		case "Student List":EventQueue.invokeLater(new Runnable() {
			
														@Override
														public void run() {
															bodyPanel.removeAll();
															bodyPanel.add(new StudentList());
															Factory.refresh();
														}
													});
			break;
			
		case "Add Book":EventQueue.invokeLater(new Runnable() {
			
													@Override
													public void run() {
														bodyPanel.removeAll();
														AddBookPage addbook=new AddBookPage(false,null);
														bodyPanel.add(addbook);	
														Factory.refresh();
													}
												});
			break;
		case "Book List" :EventQueue.invokeLater(new Runnable() {
													
													@Override
													public void run() {
														bodyPanel.removeAll();
														bodyPanel.add(new BookListPage());
														Factory.refresh();
													}
												});
		break; 
		case "Issue Books" :EventQueue.invokeLater(new Runnable() {
					
														@Override
														public void run() {
															bodyPanel.removeAll();
															bodyPanel.add(new SelectStudentForIssue());
															Factory.refresh();
														}
													});
		break;
		case "Logout" :EventQueue.invokeLater(new Runnable() {
			
														@Override
														public void run() {
															mainframe.dispose();
															Factory.lockModeOn=false;
															new DashboardPage("LibraryManagnmentTool","");
															
														}
													});
		break;
		case "User Creation" :EventQueue.invokeLater(new Runnable() {
			
													@Override
													public void run() {
														bodyPanel.removeAll();
														bodyPanel.add(new UserList());
														Factory.refresh();
													}
												});
		break;
		case "Exit" :EventQueue.invokeLater(new Runnable() {
					
													@Override
													public void run() {
														mainframe.dispose();
													}
												});
		break;
		case "Contact us" :EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				bodyPanel.removeAll();
				bodyPanel.add(new Email());
				Factory.refresh();			}
		});
		break;
		
		case "View transection" :EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				bodyPanel.removeAll();
				bodyPanel.add(new TransectionHistory());
				Factory.refresh();	
			}
		});
		break;
		case "Lock" :EventQueue.invokeLater(new Runnable() {
			
												@Override
												public void run() {
													Factory.lockModeOn=true;
													LoginDialog loginDialog= new LoginDialog(Factory.getMainFrame());
													Factory.refresh();
									
												}
											});
			break;
			

		default: bodyPanel.removeAll();
			break;
		}
		
	}
	
	
	class timeUpdate extends Thread {
		private JLabel timeLabal ;
		public timeUpdate(JLabel timeLabal) {
			this.timeLabal = timeLabal;
		}
		
		public void run(){
			while(true){
				this.timeLabal.setText(new Date().toString());
				Factory.refresh();
				try {
					currentThread().sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
		
		
		
	}
	
	

}
