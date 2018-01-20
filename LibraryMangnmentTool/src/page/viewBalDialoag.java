package page;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import common.service.Factory;
import page.WithdrawalAndDeposit;
import model.TransactionType;
import model.ViewBalanceModel;
import service.ViewBalanceService;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JSeparator;

public class viewBalDialoag extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel openingBalance,widhral,deposit,late_charge,bookCharge,availableBalance;
	Integer studentId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			viewBalDialoag dialog = new viewBalDialoag();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the dialog.
	 */
	public viewBalDialoag() {
		super(Factory.getMainFrame(), true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblBalanceDetails = new JLabel("Balance Details");
		lblBalanceDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblBalanceDetails.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBalanceDetails.setBounds(117, 11, 157, 14);
		contentPanel.add(lblBalanceDetails);
		
		JLabel lblNewLabel = new JLabel("Opening Balance                :-");
		lblNewLabel.setBounds(31, 47, 180, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Book Charge                      :-");
		lblNewLabel_1.setBounds(31, 72, 180, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Late Charge                       :-");
		lblNewLabel_2.setBounds(31, 97, 180, 14);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Deposit                               :-");
		lblNewLabel_3.setBounds(30, 122, 181, 14);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Widhral                               :-");
		lblNewLabel_4.setBounds(31, 150, 180, 14);
		contentPanel.add(lblNewLabel_4);
		
		openingBalance = new JLabel("New label");
		openingBalance.setBounds(239, 47, 166, 14);
		contentPanel.add(openingBalance);
		
		bookCharge = new JLabel("New label");
		bookCharge.setBounds(239, 72, 166, 14);
		contentPanel.add(bookCharge);
		
		late_charge = new JLabel("New label");
		late_charge.setBounds(239, 97, 166, 14);
		contentPanel.add(late_charge);
		
		deposit = new JLabel("New label");
		deposit.setBounds(239, 122, 166, 14);
		contentPanel.add(deposit);
		
		widhral = new JLabel("New label");
		widhral.setBounds(239, 150, 166, 14);
		contentPanel.add(widhral);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 175, 414, 8);
		contentPanel.add(separator);
		
		JLabel availableBalanceLable = new JLabel("Available balance               :-");
		availableBalanceLable.setBounds(31, 187, 161, 23);
		contentPanel.add(availableBalanceLable);
		
		availableBalance = new JLabel("New label");
		availableBalance.setBounds(243, 194, 162, 14);
		contentPanel.add(availableBalance);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			JButton btnNewButton_1 = new JButton("Deposit");
			btnNewButton_1.addActionListener(this);
			buttonPane.add(btnNewButton_1);
			
			JButton btnNewButton = new JButton("Withdrawal");
			btnNewButton.addActionListener(this);
			buttonPane.add(btnNewButton);
		}
	}
	public viewBalDialoag(Integer studentId){
		this();
		this.studentId = studentId;
		setBalance();
	}
	private void setBalance(){
		ViewBalanceService viewBalanceService =  (ViewBalanceService) Factory.getContext().getBean("viewBalanceService");
		ViewBalanceModel dataModel = viewBalanceService.getViewBalance(studentId);
		openingBalance.setText(dataModel.getOpening_balance().toString());
		bookCharge.setText(dataModel.getCharge().toString());
		late_charge.setText(dataModel.getLate_charge().toString());
		deposit.setText(dataModel.getDeposit().toString());
		widhral.setText(dataModel.getWidhral().toString());
		Float balance  = (dataModel.getOpening_balance()+dataModel.getDeposit()-dataModel.getCharge()-dataModel.getLate_charge()-dataModel.getWidhral());
		availableBalance.setText(balance.toString());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand().trim();
		System.out.println(""+action);
		JDialog balanceDailog = this;
		switch (action) {
			case "Deposit" :EventQueue.invokeLater(new Runnable() {
														
														@Override
														public void run() {
															balanceDailog.dispose();
															WithdrawalAndDeposit dialog = new WithdrawalAndDeposit(TransactionType.Deposit,studentId,null);
															dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
															dialog.setVisible(true);
														}
															
													});
			break;
			case "Withdrawal" :EventQueue.invokeLater(new Runnable() {
				
														@Override
														public void run() {
															balanceDailog.dispose();
															Double avlableBal = Double.parseDouble(availableBalance.getText());
															WithdrawalAndDeposit dialog = new WithdrawalAndDeposit(TransactionType.Withdrawal,studentId,avlableBal);
															dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
															dialog.setVisible(true);
														}
															
													});
			break;
		}
	
		
	}
}
