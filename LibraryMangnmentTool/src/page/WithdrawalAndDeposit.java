package page;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import common.service.DialogService;
import common.service.Factory;
import common.service.Validation;
import model.CustomerModel;
import model.TransactionType;
import model.TransectionHistoryModel;
import service.CustomerService;
import service.TransactionService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class WithdrawalAndDeposit extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	JLabel DialogType;
	TransactionType requestType;
	Integer studentId;
	Double avilableAmount;
	JLabel By;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			WithdrawalAndDeposit dialog = new WithdrawalAndDeposit();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public WithdrawalAndDeposit(TransactionType reqType,Integer studentId,Double avilableAmount){
		this();
		this.requestType = reqType;
		this.studentId = studentId;
		this.avilableAmount = avilableAmount;
		DialogType.setText(reqType.toString());
		if(reqType == TransactionType.Deposit)
			By.setText("Recived By");
		else if(reqType == TransactionType.Withdrawal)
			By.setText("Gived By");
		textField_1.setText(Factory.UserLoginModel.getUser().getUser_name());
		
	}
	

	/**
	 * Create the dialog.
	 */
	public WithdrawalAndDeposit() {
		super(Factory.getMainFrame(),true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		DialogType = new JLabel("Deposit");
		DialogType.setHorizontalAlignment(SwingConstants.CENTER);
		DialogType.setFont(new Font("Tahoma", Font.BOLD, 18));
		DialogType.setBounds(63, 11, 278, 27);
		contentPanel.add(DialogType);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAmount.setBounds(26, 53, 63, 28);
		contentPanel.add(lblAmount);
		
		textField = new JTextField();
		Validation.validateDecimal(textField);
		textField.setBounds(117, 57, 204, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		By = new JLabel("Recived By");
		By.setBounds(26, 112, 81, 20);
		contentPanel.add(By);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(117, 112, 204, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(26, 169, 81, 14);
		contentPanel.add(lblNewLabel_2);
		
		textField_2 = new JPasswordField();
		textField_2.setBounds(117, 166, 204, 20);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addActionListener(this);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(this);
				buttonPane.add(cancelButton);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand().trim();
		System.out.println(""+action);
		JDialog withDDailog = this;
		switch (action) {
			case "OK" :EventQueue.invokeLater(new Runnable() {
														
														@Override
														public void run() {
															if(validateAndSaveTrnsation())
																DialogService.showMgs(Factory.getMainFrame(), "Request Procesed Successfully..! ", "Success");
														}
															
													});
			break;
			case "Cancel" :EventQueue.invokeLater(new Runnable() {
				
														@Override
														public void run() {
															int dialogButton= JOptionPane.YES_NO_OPTION;
															DialogService.confirmPopup(Factory.getMainFrame(), "Do You Realy Want TO Close This Process..!", "confirm", dialogButton);
															if(dialogButton == JOptionPane.YES_OPTION){
																withDDailog.dispose();
															}
														}
															
													});
			break;
		}
	}
	
	private boolean validateAndSaveTrnsation(){
		String amount 	= textField.getText().trim();
		String by 		= textField_1.getText().trim();
		String password = textField_2.getText().trim();
		Double amt = null;
		
		if(amount.equals("") ){
			DialogService.showErrorMgs(Factory.getMainFrame(), "Amount Can't Blank", "Error");
			return false;
		}else if(password.equals("")){
			DialogService.showErrorMgs(Factory.getMainFrame(), "Password Can't Blank", "Error");
			return false;
		}else{
			amt = Double.parseDouble(amount);
			if(amt <= 0){
				DialogService.showErrorMgs(Factory.getMainFrame(), "Amount Can't Be 0 and Less Then 0 ", "Error");
				return false;
			}
			if(!password.equals(Factory.UserLoginModel.getUser_passwprd())){
				DialogService.showErrorMgs(Factory.getMainFrame(), "Password IS Wrong ..! \nUser Login Password is required For This Action..!  ", "Error");
				return false;
			}
		}
		
		TransectionHistoryModel model = new TransectionHistoryModel();
		
		model.setUserModel(Factory.UserLoginModel.getUser());
		model.setAmount(amt);
		model.setTxn_date(new Date());
		if(requestType == TransactionType.Deposit)
			model.setTxn_type("D");
		else if(requestType == TransactionType.Withdrawal){
			model.setTxn_type("W");
			if(amt > avilableAmount){
				DialogService.showErrorMgs(Factory.getMainFrame(), "You Can't Withdrawal More Then Available Balance..!\nYou Available Balance is "+avilableAmount, "Error");
				return false;
			}
		}
			
		
		CustomerService cservice = (CustomerService) Factory.getContext().getBean("customerService");
		CustomerModel cmodel = cservice.getCustomerDetail(studentId);
		
		model.setCustomerModel(cmodel);
		
		TransactionService service = (TransactionService) Factory.getContext().getBean("transactionService");
		if(!service.saveTransection(model)){
			DialogService.showErrorMgs(Factory.getMainFrame(), "Error While Transaction ...!\nPlease Try Again..!", "Error");
			return false;
		}
		this.dispose();
		return true;
	}
}
