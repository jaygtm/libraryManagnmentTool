package page;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import common.service.Factory;


public class Licence extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Create the dialog.
	 */
	public Licence(){

		setBounds(100, 100, 573, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.activeCaption);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblYourProductIs = new JLabel("Your product is not Licenced.");
			lblYourProductIs.setHorizontalAlignment(SwingConstants.CENTER);
			lblYourProductIs.setForeground(SystemColor.activeCaptionText);
			lblYourProductIs.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
			lblYourProductIs.setBounds(54, 11, 493, 31);
			contentPanel.add(lblYourProductIs);
		}
		
		JLabel lblPleaseEnterProduct = new JLabel("Please Enter product key for Make it Licence.");
		lblPleaseEnterProduct.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseEnterProduct.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblPleaseEnterProduct.setForeground(SystemColor.desktop);
		lblPleaseEnterProduct.setBounds(10, 53, 537, 31);
		contentPanel.add(lblPleaseEnterProduct);
		
		JLabel lblLicenceKey = new JLabel("Licence Key  :-");
		lblLicenceKey.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblLicenceKey.setBounds(10, 126, 121, 31);
		contentPanel.add(lblLicenceKey);
		
		textField = new JTextField();
		textField.setBounds(129, 133, 382, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(10, 11, 537, 90);
		contentPanel.add(panel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.activeCaption);
			buttonPane.setBounds(0, 202, 557, 36);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton btnResendProductKey = new JButton("Resend Key");
				btnResendProductKey.setBounds(10, 5, 129, 28);
				btnResendProductKey.setBackground(Factory.saveBtnColor);
				btnResendProductKey.setForeground(Factory.buttonTextColor);
				buttonPane.add(btnResendProductKey);
			}
			{
				JButton btnSubmit = new JButton("Submit");
				btnSubmit.setBounds(288, 5, 129, 28);
				btnSubmit.setBackground(Factory.saveBtnColor);
				btnSubmit.setForeground(Factory.buttonTextColor);
				buttonPane.add(btnSubmit);
			}
			{
				JButton okButton = new JButton("Show Leter");
				okButton.setBounds(149, 5, 129, 28);
				okButton.setActionCommand("OK");
				okButton.setBackground(Factory.saveBtnColor);
				okButton.setForeground(Factory.buttonTextColor);
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setBounds(427, 5, 125, 28);
				cancelButton.setActionCommand("Cancel");
				cancelButton.setBackground(Factory.cancleBtnColor);
				cancelButton.setForeground(Factory.buttonTextColor);
				buttonPane.add(cancelButton);
			}
		}
	
	}
}
