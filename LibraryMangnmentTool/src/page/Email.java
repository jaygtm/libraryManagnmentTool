
package page;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;

import common.service.DialogService;
import common.service.Factory;
import model.BookModel;
import model.BookTypeModel;
import service.BookService;

@SuppressWarnings("serial")
public class Email extends JPanel implements ActionListener {
	
	
	JTable table;
	JTextField textField;
	public JButton btnNewButton_10;
	public JButton btnNewButton_11;
	private JTextField to;
	private JTextField from;
	private JTextField subject;
	private JTextField composemain;
	public Email() {
		
		setBounds(10, 11, 1129, 571);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Contact Us");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(469, 10, 100, 14);
		add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 30, 1109, 8);
		add(separator);
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 497, 1109, 8);
		add(separator_1);
		
		JLabel lblSendTo = new JLabel("From:-");
		lblSendTo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblSendTo.setBounds(101, 50, 108, 35);
		add(lblSendTo);
		
		from = new JTextField();
		from.setBounds(338, 50, 672, 30);
		add(from);
		from.setColumns(10);
		
		JLabel lblTo = new JLabel("To:-");
		lblTo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblTo.setBounds(101, 103, 108, 25);
		add(lblTo);
		
		to = new JTextField();
		to.setBounds(338, 102, 672, 30);
		to.setEditable(false);
		to.setText("kumar0112avinash@gmail.com");
		add(to);
		to.setColumns(10);
		
		JLabel lblSubject = new JLabel("Subject:-");
		lblSubject.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblSubject.setBounds(101, 164, 108, 25);
		add(lblSubject);
		
		subject = new JTextField();
		subject.setBounds(338, 159, 672, 30);
		add(subject);
		subject.setColumns(10);
		
		JLabel lblComposeEmail = new JLabel("Compose email:-");
		lblComposeEmail.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblComposeEmail.setBounds(101, 225, 209, 25);
		add(lblComposeEmail);
		
		composemain = new JTextField();
		composemain.setBounds(338, 224, 672, 270);
		add(composemain);
		composemain.setColumns(10);
		
		btnNewButton_10 = new JButton("Send");
		btnNewButton_10.setBackground(Factory.saveBtnColor);
		btnNewButton_10.setBounds(865, 514, 109, 34);
		btnNewButton_10.addActionListener(this);
		btnNewButton_10.setForeground(Factory.buttonTextColor);
		add(btnNewButton_10);
		
		btnNewButton_11 = new JButton("Cancel");
		btnNewButton_11.setBackground(Factory.cancleBtnColor);
		btnNewButton_11.setBounds(979, 514, 109, 34);
		btnNewButton_11.addActionListener(this);
		btnNewButton_11.setForeground(Factory.buttonTextColor);
		add(btnNewButton_11);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand().trim();
		System.out.println("Action " + action+"At Class "+getClass().toString());
		switch (action) {
		case "Send":
			EventQueue.invokeLater(new Runnable() {
				

				@Override
				public void run() {
					
				}
			});
			break;

		case "Cancel":
			EventQueue.invokeLater(new Runnable() {

				@Override
				public void run() {
					Factory.homePage();
					Factory.refresh();
				}
			});
			break;

		default:
			break;
		}
	}
	
}
