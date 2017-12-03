package page;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AddBookPage {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	public void addBookPage(JPanel panel_1) {
		JPanel add_Book = new JPanel();
		add_Book.setBounds(177, 25, 867, 538);
		add_Book.setBorder(BorderFactory.createTitledBorder(""));
		add_Book.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 26));
		panel_1.add(add_Book);
		add_Book.setLayout(null);
		
		JLabel lblStudentRegistration = new JLabel("Add Book");
		lblStudentRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentRegistration.setBounds(363, 11, 214, 32);
		lblStudentRegistration.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 26));
		add_Book.add(lblStudentRegistration);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(148, 108, 128, 32);
		add_Book.add(lblNewLabel);
		
		JLabel lblBookTypeId = new JLabel("Type Name");
		lblBookTypeId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBookTypeId.setHorizontalAlignment(SwingConstants.LEFT);
		lblBookTypeId.setBounds(148, 151, 140, 32);
		add_Book.add(lblBookTypeId);
		
		JLabel lblBookMrp = new JLabel("MRP");
		lblBookMrp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBookMrp.setBounds(148, 194, 128, 32);
		add_Book.add(lblBookMrp);
		
		JLabel lblBookRent = new JLabel("Rent");
		lblBookRent.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBookRent.setBounds(148, 237, 125, 32);
		add_Book.add(lblBookRent);
		
		JLabel lblBookRentPer = new JLabel("Rent Per Day");
		lblBookRentPer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBookRentPer.setBounds(148, 280, 140, 32);
		add_Book.add(lblBookRentPer);
		
		JLabel lblBookAurthor = new JLabel("Book Aurthor");
		lblBookAurthor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBookAurthor.setBounds(148, 323, 128, 32);
		add_Book.add(lblBookAurthor);
		
		JLabel lblPublication = new JLabel("Publication");
		lblPublication.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPublication.setBounds(148, 366, 112, 32);
		add_Book.add(lblPublication);
		
		textField = new JTextField();
		textField.setBounds(432, 117, 261, 20);
		add_Book.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(432, 160, 261, 20);
		add_Book.add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setBounds(432, 203, 262, 20);
		add_Book.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(432, 246, 261, 20);
		add_Book.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(432, 289, 261, 20);
		add_Book.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(432, 331, 261, 23);
		add_Book.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(432, 374, 261, 23);
		add_Book.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton_6 = new JButton("Cancel");
		btnNewButton_6.setBounds(246, 448, 89, 23);
		add_Book.add(btnNewButton_6);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(508, 448, 89, 23);
		add_Book.add(btnSave);
		
	}

}
