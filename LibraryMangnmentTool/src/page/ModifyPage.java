package page;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import common.service.DialogService;
import common.service.Factory;
import model.CustomerModel;
import service.CustomerService;

public class ModifyPage implements ActionListener {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JPanel parent;

	public void modifyPage(JPanel panel_1) {
		/////////////////////////////////////////////////////////////////
		this.parent = panel_1;
		JPanel Reg_panel = new JPanel();
		Reg_panel.setBounds(177, 25, 867, 538);
		Reg_panel.setBackground(new Color(0,0,0,0));
		Reg_panel.setBorder(BorderFactory.createTitledBorder(""));
		Reg_panel.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 26));
		panel_1.add(Reg_panel);
		Reg_panel.setLayout(null);

		JLabel lblStudentRegistration = new JLabel("Student Registration");
		lblStudentRegistration.setBounds(316, 11, 214, 32);
		lblStudentRegistration.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 26));
		Reg_panel.add(lblStudentRegistration);

		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(84, 120, 65, 22);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Reg_panel.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(434, 124, 242, 20);
		Reg_panel.add(textField);
		textField.setColumns(10);

		JLabel lblMobileNumber = new JLabel("Mobile Number");
		lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMobileNumber.setBounds(84, 176, 135, 14);
		Reg_panel.add(lblMobileNumber);

		textField_1 = new JTextField();
		textField_1.setBounds(434, 176, 242, 20);
		Reg_panel.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblEmainId = new JLabel("Emain Id");
		lblEmainId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmainId.setBounds(84, 230, 119, 22);
		Reg_panel.add(lblEmainId);

		textField_2 = new JTextField();
		textField_2.setBounds(434, 234, 242, 20);
		Reg_panel.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblStudentId = new JLabel("Student Id");
		lblStudentId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStudentId.setBounds(84, 279, 119, 32);
		Reg_panel.add(lblStudentId);

		textField_3 = new JTextField();
		textField_3.setBounds(434, 288, 242, 20);
		Reg_panel.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblBalanceAmount = new JLabel("Balance Amt");
		lblBalanceAmount.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBalanceAmount.setBounds(84, 352, 119, 20);
		Reg_panel.add(lblBalanceAmount);

		textField_4 = new JTextField();
		textField_4.setBounds(434, 352, 242, 20);
		Reg_panel.add(textField_4);
		textField_4.setColumns(10);

		JButton btnNewButton_6 = new JButton("Save");
		btnNewButton_6.setBackground(new Color(0, 153, 102));
		btnNewButton_6.setBounds(541, 471, 135, 40);
		Reg_panel.add(btnNewButton_6);
		btnNewButton_6.addActionListener(this);
		

		JButton btnNewButton_7 = new JButton("Cancel");
		btnNewButton_7.setBackground(new Color(255, 51, 0));
		btnNewButton_7.setBounds(686, 471, 135, 40);
		Reg_panel.add(btnNewButton_7);
		btnNewButton_7.addActionListener(this);
		
		JLabel lblLibraryIdNo = new JLabel("Library Id No");
		lblLibraryIdNo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLibraryIdNo.setBounds(84, 71, 135, 24);
		Reg_panel.add(lblLibraryIdNo);
		
		textField_5 = new JTextField();
		textField_5.setBounds(434, 76, 242, 20);
		Reg_panel.add(textField_5);
		textField_5.setColumns(10);
		/////////////////////////////////////////////////

	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}

	public JTextField getTextField_2() {
		return textField_2;
	}

	public void setTextField_2(JTextField textField_2) {
		this.textField_2 = textField_2;
	}

	public JTextField getTextField_3() {
		return textField_3;
	}

	public void setTextField_3(JTextField textField_3) {
		this.textField_3 = textField_3;
	}

	public JTextField getTextField_4() {
		return textField_4;
	}

	public void setTextField_4(JTextField textField_4) {
		this.textField_4 = textField_4;
	}

	public JTextField getTextField_5() {
		return textField_5;
	}

	public void setTextField_5(JTextField textField_5) {
		this.textField_5 = textField_5;
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
				parent.removeAll();
				CustomerService customerService = (CustomerService) Factory.getContext().getBean("customerService");
				List<CustomerModel> status = customerService.getAllCustomerDetail();
			     CustomerList customerList=new CustomerList();
		        customerList.customerList(parent,status);
			}
		});
			break;
			
		default:
			break;
		}
		Factory.refresh();
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
				model.setCustomer_balance(Integer.parseInt(amount));
			return model;
		}
		
		
		
		return null;
	}
	
	
	
	
}
