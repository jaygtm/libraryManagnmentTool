package page;

import java.awt.Dimension;
import java.awt.EventQueue;
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
import javax.swing.JTable;
import javax.swing.JTextField;

import common.service.Factory;
import model.BookModel;
import service.BookService;

public class SelectStudentForIssue extends JPanel implements ActionListener {
	
	
	JTable table;
	JTextField textField;
	@SuppressWarnings("rawtypes")
	JComboBox comboBox;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SelectStudentForIssue() {
		
		setBounds(93, 28, 1020, 529);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select Student ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(469, 21, 189, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Search By");
		lblNewLabel_1.setBounds(10, 47, 73, 14);
		add(lblNewLabel_1);
		
		comboBox = new JComboBox(new String[]{"-Select-","Name","Authour","Publication","Id"});
		comboBox.setBounds(73, 44, 175, 20);
		comboBox.setPreferredSize(new Dimension(350, 30));
		add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Search");
		lblNewLabel_2.setBounds(271, 47, 46, 14);
		add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(327, 44, 167, 20);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_6 = new JButton("Search");
		btnNewButton_6.setBounds(521, 43, 89, 23);
		add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Clear");
		btnNewButton_7.setBounds(620, 43, 89, 23);
		add(btnNewButton_7);
		
		JScrollPane scrollBar = new JScrollPane();
		scrollBar.setBounds(10, 75, 989, 377);
		add(scrollBar);
		
		table = new JTable(getRowData(),columnName());
		table.setBounds(163, 235, 1, 1);
		scrollBar.getViewport ().add(table);
		
		JButton btnNewButton_10 = new JButton("Issue");
		btnNewButton_10.setBounds(788, 475, 101, 43);
		btnNewButton_10.addActionListener(this);
		add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("Cancel");
		btnNewButton_11.setBackground(Factory.cancleBtnColor);
		btnNewButton_11.setBounds(899, 475, 100, 43);
		add(btnNewButton_11);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand().trim();
		System.out.println(""+action);
		 switch (action) {
		case "Issue":EventQueue.invokeLater(new Runnable() {
			
											@Override
											public void run() {
												Factory.getBodyPanal().removeAll();
												//Factory.getBodyPanal().add(new IssueBookPage());
												Factory.refresh();
											}
										});
			
			break;

		default:
			break;
		}
		
		
	}
	public String[] columnName() {
		String columnName[] = { "Book_id","Book Name", "Book Mrp", "Book Rent", "Book Rant per day", "Book Authour","publication","Available","Total"};
		return columnName;
	}
	
	public String[][] getRowData(){
		BookService bookService = (BookService) Factory.getContext().getBean("bookService");
		List<BookModel> list = bookService.getBookaList();
		String rowData[][] =new String[list.size()][9]; ;
		Iterator<BookModel> itr =  list.iterator();
		int i=0;
		while (itr.hasNext()) {
			BookModel book = (BookModel) itr.next();
			System.out.println("name Book"+book.getBook_name());
			rowData[i][0] = ""+book.getBook_id();
			rowData[i][1] = ""+book.getBook_name();
			rowData[i][2] = ""+book.getBook_mrp();
			rowData[i][3] = ""+book.getBook_rent();
			rowData[i][4] = ""+book.getBook_rentPerDay();
			rowData[i][5] = ""+book.getBook_aurthor();
			rowData[i][6] = ""+book.getBook_publication();
			rowData[i][7] = ""+book.getBook_aval();
			rowData[i][8] = ""+book.getBook_Total();
			i++;
		}
		return rowData;
	}

	
	

}
