package page;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegistrationPage {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	public void registrationPage(JPanel panel_1) {
		/////////////////////////////////////////////////////////////////
		JPanel Reg_panel = new JPanel();
		Reg_panel.setBounds(177, 25, 867, 538);
		Reg_panel.setBorder(BorderFactory.createTitledBorder(""));
		Reg_panel.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 26));
		panel_1.add(Reg_panel);
		Reg_panel.setLayout(null);

		JLabel lblStudentRegistration = new JLabel("Student Registration");
		lblStudentRegistration.setBounds(316, 11, 214, 32);
		lblStudentRegistration.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 26));
		Reg_panel.add(lblStudentRegistration);

		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(84, 71, 45, 22);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Reg_panel.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(434, 75, 242, 20);
		Reg_panel.add(textField);
		textField.setColumns(10);

		JLabel lblMobileNumber = new JLabel("Mobile Number");
		lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMobileNumber.setBounds(84, 135, 135, 14);
		Reg_panel.add(lblMobileNumber);

		textField_1 = new JTextField();
		textField_1.setBounds(434, 135, 242, 20);
		Reg_panel.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblEmainId = new JLabel("Emain Id");
		lblEmainId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmainId.setBounds(84, 196, 119, 22);
		Reg_panel.add(lblEmainId);

		textField_2 = new JTextField();
		textField_2.setBounds(434, 200, 242, 20);
		Reg_panel.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblStudentId = new JLabel("Student Id");
		lblStudentId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStudentId.setBounds(84, 251, 119, 32);
		Reg_panel.add(lblStudentId);

		textField_3 = new JTextField();
		textField_3.setBounds(434, 260, 242, 20);
		Reg_panel.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblBalanceAmount = new JLabel("Balance Amt");
		lblBalanceAmount.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBalanceAmount.setBounds(84, 332, 119, 20);
		Reg_panel.add(lblBalanceAmount);

		textField_4 = new JTextField();
		textField_4.setBounds(434, 335, 242, 20);
		Reg_panel.add(textField_4);
		textField_4.setColumns(10);

		JButton btnNewButton_6 = new JButton("Save");
		btnNewButton_6.setBounds(175, 428, 89, 23);
		Reg_panel.add(btnNewButton_6);

		JButton btnNewButton_7 = new JButton("Cancel");
		btnNewButton_7.setBounds(394, 428, 89, 23);
		Reg_panel.add(btnNewButton_7);
		/////////////////////////////////////////////////

	}
}