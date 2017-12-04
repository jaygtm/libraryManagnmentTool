package page;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

import model.CustomerModel;
import newobject.UseFactory;
import service.CustomerService;

public class NevigationMenueBar implements ActionListener {
	private JPanel panel;
	private JPanel bodyPanel ;
	public void manueBar(JFrame mainframe){

		panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setForeground(Color.WHITE);
		panel.setBounds(10, 63, 188, 593);
		mainframe.getContentPane().add(panel);
		
		JButton btnNewButton_1 = new JButton("Add Book                            ");
		btnNewButton_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("../img/java_jar.gif")));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(SystemColor.textHighlight);
		//btnNewButton_1.setBorder(null);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Add Student                              ");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(SystemColor.textHighlight);
		//btnNewButton.setBorder(null);
		btnNewButton.addActionListener(this);
		panel.add(btnNewButton);
		
		JButton StudentlistButton = new JButton("Student List                             ");
		StudentlistButton.setForeground(Color.WHITE);
		StudentlistButton.setBackground(SystemColor.textHighlight);
		StudentlistButton.addActionListener(this);
		panel.add(StudentlistButton);
		
		JButton btnNewButton_4 = new JButton("User Creation                            ");
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setBackground(SystemColor.textHighlight);
		//btnNewButton_4.setBorder(null);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_3 = new JButton("Issue Books                              ");
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(SystemColor.textHighlight);
		//btnNewButton_3.setBorder(null);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton("View Issue Detail                       ");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(SystemColor.textHighlight);
		//btnNewButton_2.setBorder(null);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_5 = new JButton("Submit Book                               ");
		btnNewButton_5.setForeground(Color.WHITE);
		btnNewButton_5.setBackground(SystemColor.textHighlight);
		//btnNewButton_5.setBorder(null);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnNewButton_5);
		
		bodyPanel = new JPanel();
		bodyPanel.setBounds(208, 63, 1149, 593);
		//bodyPanel.setBackground(new Color(213, 134, 145, 100));
		bodyPanel.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.5f));
		mainframe.getContentPane().add(bodyPanel);
		bodyPanel.setLayout(null);
		////////////////////////////////////////////////////////////////
		/*AddBookPage addBookPage = new AddBookPage();
		addBookPage.addBookPage(panel_1);*/
		//////////////////////////////////////////
		//////////////////////////////////////////////
		/*RegistrationPage registrationPage=new RegistrationPage();
		registrationPage.registrationPage(panel_1);*/
		
		
		//////////////////////////////////////////////
		
		JLabel lblTilakPublicSenior = new JLabel("TILAK PUBLIC SENIOR SECONDARY SCHOOL ");
		lblTilakPublicSenior.setForeground(new Color(204, 0, 0));
		lblTilakPublicSenior.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 22));
		lblTilakPublicSenior.setBounds(432, 11, 925, 41);
		mainframe.getContentPane().add(lblTilakPublicSenior);
		
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand().trim();
		System.out.println(""+action);
		
		switch (action) {
		case "Add Student":EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				bodyPanel.removeAll();
				RegistrationPage registrationPage=new RegistrationPage();
				registrationPage.registrationPage(bodyPanel);
			}
		});
			break;
			
		case "Student List":EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				bodyPanel.removeAll();
				CustomerService customerService = (CustomerService) UseFactory.getContext().getBean("customerService");
				List<CustomerModel> status = customerService.getAllCustomerDetail();
			     CustomerList customerList=new CustomerList();
		        customerList.customerList(bodyPanel,status);
			}
		});
			break;
			
		case "Add Book":EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				bodyPanel.removeAll();
				AddBookPage addbook=new AddBookPage();
				addbook.addBookPage(bodyPanel);
			}
		});
			break;

		default:
			break;
		}
		UseFactory.refresh();
	}
	
	

}
