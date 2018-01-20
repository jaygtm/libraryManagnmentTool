package page;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import common.service.DialogService;
import common.service.Factory;
import common.service.Validation;
import model.CustomerModel;
import service.CustomerService;

public class RegistrationPage implements ActionListener {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPanel parent;

	public void registrationPage(JPanel panel_1) {
		/////////////////////////////////////////////////////////////////
		this.parent = panel_1;
		JPanel Reg_panel = new JPanel();
		//Reg_panel.setBounds(177, 25, 867, 538);
		Reg_panel.setBounds(10, 11, 1129, 571);
		//Reg_panel.setBackground(new Color(0,0,0,0));
		Reg_panel.setBorder(BorderFactory.createTitledBorder(""));
		Reg_panel.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 26));
		panel_1.add(Reg_panel);
		Reg_panel.setLayout(null);
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 497, 1109, 8);
		Reg_panel.add(separator_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 50, 1109, 8);
		Reg_panel.add(separator);

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
		Validation.validateString(textField);

		JLabel lblMobileNumber = new JLabel("Mobile Number");
		lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMobileNumber.setBounds(84, 135, 135, 14);
		Reg_panel.add(lblMobileNumber);

		textField_1 = new JTextField();
		textField_1.setBounds(434, 135, 242, 20);
		Reg_panel.add(textField_1);
		textField_1.setColumns(10);
		Validation.validateMobileNumber(textField_1);

		JLabel lblEmainId = new JLabel("Emain Id");
		lblEmainId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmainId.setBounds(84, 196, 119, 22);
		Reg_panel.add(lblEmainId);

		textField_2 = new JTextField();
		textField_2.setBounds(434, 200, 242, 20);
		Reg_panel.add(textField_2);
		textField_2.setColumns(10);
		Validation.validateEmail(textField_2);

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
		Validation.validateDecimal(textField_4);

		JButton btnNewButton_6 = new JButton("Save");
		btnNewButton_6.setForeground(Factory.buttonTextColor);
		btnNewButton_6.setBounds(850, 516, 115, 34);
		btnNewButton_6.setBackground(Factory.saveBtnColor);
		Reg_panel.add(btnNewButton_6);
		btnNewButton_6.addActionListener(this);
		

		JButton btnNewButton_7 = new JButton("Cancel");
		btnNewButton_7.setBounds(979, 514, 109, 34);
		btnNewButton_7.setForeground(Factory.buttonTextColor);
		btnNewButton_7.setBackground(Factory.cancleBtnColor);
		btnNewButton_7.addActionListener(this);
		Reg_panel.add(btnNewButton_7);
		/////////////////////////////////////////////////

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand().trim();
		System.out.println(""+action);
		switch (action) {
		case "Save":EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				CustomerModel model =validateAndGetData();
				if(model != null){
					CustomerService customerService = (CustomerService) Factory.getContext().getBean("customerService");
					boolean status = customerService.saveCustomerDetail(model);
					System.out.println("Status of Save");
					if(status)
						DialogService.showMgs(parent, "Save Successfully..!", "Success");
					else
						DialogService.showErrorMgs(parent, "Error to Save ..!", "Error");
				}
			}
		});
			break;
		case "Cancel":EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				Factory.homePage();
				
			}
		});
			break;

		default:
			break;
		}
		
	}
	public CustomerModel validateAndGetData(){
		String name 	= textField.getText();
		String mobileNo = textField_1.getText();
		String email 	= textField_2.getText();
		String studentId = textField_3.getText();
		String amount 	= textField_4.getText();
		
		if(name.trim().equals("") || mobileNo.trim().equals("") || email.trim().equals("") || studentId.trim().equals("") ){
			DialogService.showErrorMgs(parent, "Field Can't be Blank..!", "Invaild User");
		}else{
			CustomerModel model = (CustomerModel) Factory.getContext().getBean("customerModel");
			model.setCustomer_name(name);
			model.setCustomer_mobile(mobileNo);
			model.setCustomer_email(email);
			model.setCustomer_cId(studentId);
			if(!amount.trim().equals(""))
				model.setCustomer_balance(Double.parseDouble(amount));
			return model;
		}
		
		
		
		return null;
	}
	
	
	
	
}
