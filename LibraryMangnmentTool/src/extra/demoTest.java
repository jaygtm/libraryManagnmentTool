package extra;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JSeparator;



public class demoTest {

	private JFrame frame;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					demoTest window = new demoTest();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public demoTest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		frame.setBounds(208, 63, 1400, 748);;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		URL fileUrl = getClass().getResource("..//img//books_vintage_paper_cards_notebook_retro_74362_2560x1600.jpg");
		if(fileUrl != null){
			ImageIcon img = new ImageIcon(fileUrl);
			frame.setContentPane(new JLabel(img));
		}
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setForeground(Color.WHITE);
		panel.setBounds(10, 63, 188, 593);
		frame.getContentPane().add(panel);
		
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
		panel.add(btnNewButton);
		
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(208, 63, 1149, 593);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(63, 30, 1021, 505);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Student Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(34, 48, 93, 14);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Issue Books");
		lblNewLabel.setBounds(473, 5, 126, 22);
		lblNewLabel.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 17));
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Student Id");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(364, 49, 60, 14);
		panel_2.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(137, 47, 194, 20);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(434, 47, 113, 20);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(34, 101, 925, 8);
		panel_2.add(separator);
		
		JLabel lblBookName = new JLabel("Book Name");
		lblBookName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblBookName.setBounds(158, 117, 81, 14);
		panel_2.add(lblBookName);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(84, 150, 219, 20);
		panel_2.add(comboBox);
		
		JLabel lblNewLabel_3 = new JLabel("No Of Days");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_3.setBounds(481, 119, 106, 14);
		panel_2.add(lblNewLabel_3);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(444, 150, 143, 20);
		panel_2.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(84, 200, 219, 20);
		panel_2.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(84, 254, 219, 20);
		panel_2.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(84, 309, 219, 20);
		panel_2.add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(84, 363, 219, 20);
		panel_2.add(comboBox_5);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setBounds(444, 200, 143, 20);
		panel_2.add(comboBox_6);
		
		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setBounds(444, 254, 143, 20);
		panel_2.add(comboBox_7);
		
		JComboBox comboBox_8 = new JComboBox();
		comboBox_8.setBounds(444, 309, 143, 20);
		panel_2.add(comboBox_8);
		
		JComboBox comboBox_9 = new JComboBox();
		comboBox_9.setBounds(444, 363, 143, 20);
		panel_2.add(comboBox_9);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(34, 426, 925, 8);
		panel_2.add(separator_1);
		
		JButton btnIssue = new JButton("Issue");
		btnIssue.setBounds(284, 445, 106, 34);
		panel_2.add(btnIssue);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(434, 445, 113, 34);
		panel_2.add(btnCancel);
		
		
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
		frame.getContentPane().add(lblTilakPublicSenior);
		
		/*JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(10, 24, 46, 14);
		lblNewLabel_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("../img/java_jar.gif")));
		frame.getContentPane().add(lblNewLabel_1);*/
	}
}
