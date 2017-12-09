package page;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;

import common.service.Factory;
import model.BookModel;
import service.BookService;

public class IssueBookPage extends JPanel implements ActionListener {
	
	
	JTable table;
	JTextField textField;
	@SuppressWarnings("rawtypes")
	JComboBox comboBox;
	private JTextField textField_1,textField_2;
	
	
	private String booklist[] = getBookList();
	
	private String noOfDays[] = new String[]{"1","3","5","7","10","15","30","45"};
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public IssueBookPage() {
		setBounds(20, 79, 1099, 481);
		setLayout(null);
		
		setBorder(BorderFactory.createTitledBorder("Issue Book"));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(34, 38, 925, 8);
		 add(separator);
		
		JLabel lblBookName = new JLabel("Book Name");
		lblBookName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblBookName.setBounds(150, 57, 81, 14);
		 add(lblBookName);
		
		JComboBox comboBox = new JComboBox<String>(booklist);
		comboBox.setBounds(84, 82, 219, 20);
		 add(comboBox);
		
		JLabel lblNewLabel_3 = new JLabel("No Of Days");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_3.setBounds(473, 57, 106, 14);
		 add(lblNewLabel_3);
		
		
		
		JComboBox comboBox_2 = new JComboBox<String>(booklist);
		comboBox_2.setBounds(84, 211, 219, 20);
		 add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox<String>(booklist);
		comboBox_3.setBounds(84, 254, 219, 20);
		 add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox<String>(booklist);
		comboBox_4.setBounds(84, 169, 219, 20);
		 add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox<String>(booklist);
		comboBox_5.setBounds(84, 126, 219, 20);
		add(comboBox_5);
		 
		JComboBox comboBox_1 = new JComboBox<String>(noOfDays);
		comboBox_1.setBounds(434, 82, 143, 20);
		add(comboBox_1);
		 
		JComboBox comboBox_6 = new JComboBox<String>(noOfDays);
		comboBox_6.setBounds(434, 126, 143, 20);
		 add(comboBox_6);
		
		JComboBox comboBox_7 = new JComboBox<String>(noOfDays);
		comboBox_7.setBounds(434, 169, 143, 20);
		 add(comboBox_7);
		
		JComboBox comboBox_8 = new JComboBox<String>(noOfDays);
		comboBox_8.setBounds(434, 211, 143, 20);
		 add(comboBox_8);
		
		JComboBox comboBox_9 = new JComboBox<String>(noOfDays);
		comboBox_9.setBounds(436, 254, 143, 20);
		 add(comboBox_9);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(34, 318, 925, 8);
		 add(separator_1);
		
		JButton btnIssue = new JButton("Issue");
		btnIssue.setBounds(243, 337, 106, 34);
		 add(btnIssue);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(406, 337, 113, 34);
		 add(btnCancel);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	private String[] getBookList(){
		BookService bookService = (BookService) Factory.getContext().getBean("bookService");
		List<BookModel> list = bookService.getBookaList();
		String bookList[] = new String[list.size()];
		int i=0;
		for(BookModel book :list){
			bookList[i] = book.getBook_name();
			i++;
		}
		
		return bookList;
	}
	
	

}
