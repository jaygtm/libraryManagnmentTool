package page;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import common.service.Factory;

public class UserRegistrationPage extends JPanel implements ActionListener {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	public UserRegistrationPage(){
		setBounds(10, 11, 1129, 571);
		setLayout(null);
	JLabel lblUserResistrationForm = new JLabel("User Resistration Form");
	lblUserResistrationForm.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
	lblUserResistrationForm.setBounds(489, 11, 243, 34);
	add(lblUserResistrationForm);
	
	JSeparator separator = new JSeparator();
	separator.setBounds(10, 50, 1109, 8);
	add(separator);
	
	JSeparator separator_1 = new JSeparator();
	separator_1.setBounds(10, 497, 1109, 8);
	add(separator_1);

	JButton btnNewButton_9 = new JButton("Save");
	btnNewButton_9.setBackground(Factory.modifyBtnColor);
	btnNewButton_9.setBounds(850, 516, 115, 32);
	//btnNewButton_9.addActionListener(this);
	add(btnNewButton_9);
	
	JButton btnNewButton_11 = new JButton("Cancel");
	btnNewButton_11.setBackground(Factory.cancleBtnColor);
	btnNewButton_11.setBounds(979, 514, 109, 34);
	//btnNewButton_11.addActionListener(this);
	add(btnNewButton_11);
	
	JLabel lblName = new JLabel("Name:-");
	lblName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
	lblName.setBounds(126, 110, 98, 17);
	add(lblName);
	
	textField = new JTextField();
	textField.setBounds(274, 110, 243, 20);
	add(textField);
	textField.setColumns(10);
	
	JLabel lblUserRole = new JLabel("User Role:-");
	lblUserRole.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
	lblUserRole.setBounds(578, 111, 99, 14);
	add(lblUserRole);
	
	JComboBox comboBox = new JComboBox();
	comboBox.setBounds(706, 110, 243, 20);
	add(comboBox);
	
	JLabel lblUserMobile = new JLabel("User Mobile:-");
	lblUserMobile.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
	lblUserMobile.setBounds(126, 186, 98, 17);
	add(lblUserMobile);
	
	textField_1 = new JTextField();
	textField_1.setBounds(274, 186, 244, 20);
	add(textField_1);
	textField_1.setColumns(10);
	
	JLabel lblAdharid = new JLabel("Adhar/Id No.:-");
	lblAdharid.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
	lblAdharid.setBounds(578, 184, 115, 20);
	add(lblAdharid);
	
	textField_2 = new JTextField();
	textField_2.setBounds(706, 186, 243, 20);
	add(textField_2);
	textField_2.setColumns(10);
	
	JLabel lblAddress = new JLabel("Address:-");
	lblAddress.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
	lblAddress.setBounds(126, 256, 115, 17);
	add(lblAddress);
	
	textField_3 = new JTextField();
	textField_3.setBounds(275, 257, 243, 17);
	add(textField_3);
	textField_3.setColumns(10);
	
	JLabel lblUserIdany = new JLabel("Login Id(any):-");
	lblUserIdany.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
	lblUserIdany.setBounds(578, 257, 125, 17);
	add(lblUserIdany);
	
	textField_4 = new JTextField();
	textField_4.setBounds(706, 256, 243, 20);
	add(textField_4);
	textField_4.setColumns(10);
	
	JLabel lblPassword = new JLabel("PassWord :-");
	lblPassword.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
	lblPassword.setBounds(126, 327, 98, 14);
	add(lblPassword);
	
	textField_5 = new JTextField();
	textField_5.setBounds(275, 326, 243, 20);
	add(textField_5);
	textField_5.setColumns(10);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
