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

import page.AddBookPage;
import page.RegistrationPage;

public class extra {

	private JFrame frame;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					extra window = new extra();
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
	public extra() {
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
