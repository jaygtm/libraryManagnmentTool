package page;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import common.service.Factory;
import model.BookModel;
import service.BookService;

public class IssueBookPage extends JPanel implements ActionListener {
	
	
	JTable table;
	JTextField textField;
	@SuppressWarnings("rawtypes")
	JComboBox comboBox;
	private JTextField textField_1,textField_2;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public IssueBookPage() {
		setBounds(63, 30, 1021, 505);
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Student Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(34, 48, 93, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Issue Books");
		lblNewLabel.setBounds(473, 5, 126, 22);
		lblNewLabel.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 17));
		add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Student Id");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(364, 49, 60, 14);
		add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(137, 47, 194, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(434, 47, 113, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(34, 101, 925, 8);
		add(separator);
		
		JLabel lblBookName = new JLabel("Book Name");
		lblBookName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblBookName.setBounds(158, 117, 81, 14);
		add(lblBookName);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(84, 150, 219, 20);
		add(comboBox);
		
		JLabel lblNewLabel_3 = new JLabel("No Of Days");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_3.setBounds(481, 119, 106, 14);
		add(lblNewLabel_3);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(444, 150, 143, 20);
		add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(84, 200, 219, 20);
		add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(84, 254, 219, 20);
		add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(84, 309, 219, 20);
		add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(84, 363, 219, 20);
		add(comboBox_5);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setBounds(444, 200, 143, 20);
		add(comboBox_6);
		
		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setBounds(444, 254, 143, 20);
		add(comboBox_7);
		
		JComboBox comboBox_8 = new JComboBox();
		comboBox_8.setBounds(444, 309, 143, 20);
		add(comboBox_8);
		
		JComboBox comboBox_9 = new JComboBox();
		comboBox_9.setBounds(444, 363, 143, 20);
		add(comboBox_9);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(34, 426, 925, 8);
		add(separator_1);
		
		JButton btnIssue = new JButton("Issue");
		btnIssue.setBounds(284, 445, 106, 34);
		add(btnIssue);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(434, 445, 113, 34);
		add(btnCancel);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	

	
	

}
