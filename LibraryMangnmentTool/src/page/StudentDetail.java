package page;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class StudentDetail extends JPanel implements ActionListener  {
	
	private static final long serialVersionUID = 1L;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	public StudentDetail() {
		JLabel lblNewLabel = new JLabel("Student Name:-");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(20, 11, 122, 23);
		add(lblNewLabel);
		
		textField_6 = new JTextField();
		textField_6.setBounds(148, 14, 212, 20);
		add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblStudentLibraryId = new JLabel("Student Library Id:-");
		lblStudentLibraryId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStudentLibraryId.setBounds(412, 11, 147, 23);
		add(lblStudentLibraryId);
		
		textField_7 = new JTextField();
		textField_7.setBounds(569, 14, 147, 20);
		add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblStudentSession = new JLabel("Student Session:-");
		lblStudentSession.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStudentSession.setBounds(769, 11, 129, 23);
		add(lblStudentSession);
		
		textField_8 = new JTextField();
		textField_8.setBounds(907, 14, 178, 20);
		add(textField_8);
		textField_8.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 45, 1099, 2);
		add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(20, 72, 1099, 2);
		add(separator_1);
		
		JButton btnNewButton_6 = new JButton("Issue Book");
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_6.setBounds(20, 45, 122, 29);
		add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Alloted Book");
		btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_7.setBounds(148, 45, 129, 29);
		add(btnNewButton_7);
		
		JButton btnViewHistory = new JButton("View History");
		btnViewHistory.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnViewHistory.setBounds(285, 45, 111, 29);
		add(btnViewHistory);
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
