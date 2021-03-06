package page;

import java.awt.Dimension;
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
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;

import common.service.DialogService;
import common.service.Factory;
import model.BookModel;
import model.BookTypeModel;
import service.BookService;
import service.CustomerService;

@SuppressWarnings("serial")
public class BookListPage extends JPanel implements ActionListener {
	
	
	JTable table;
	JTextField textField;
	@SuppressWarnings("rawtypes")
	JComboBox comboBox;
	private JScrollPane scrollBar;
	private List<BookTypeModel> bookTypeList;
	private List<BookModel> list;
	public JButton btnNewButton_8;
	public JButton btnNewButton_9;
	public JButton btnNewButton_10;
	public JButton btnNewButton_11;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BookListPage() {
		
		setBounds(10, 11, 1129, 571);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book List");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(469, 10, 100, 14);
		add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 30, 1109, 8);
		add(separator);
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 497, 1109, 8);
		add(separator_1);

		JLabel lblNewLabel_1 = new JLabel("Search By");
		lblNewLabel_1.setBounds(10, 47, 73, 14);
		add(lblNewLabel_1);
		
		comboBox = new JComboBox(new String[]{"Name","Aurther","Publication"});
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
		btnNewButton_6.addActionListener(this);
		add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Clear");
		btnNewButton_7.setBounds(620, 43, 89, 23);
		btnNewButton_7.addActionListener(this);
		add(btnNewButton_7);
		
		scrollBar = new JScrollPane();
		scrollBar.setBounds(10, 75, 1109, 420);
		add(scrollBar);
		
		table = new JTable(getBookList(null,null),columnName());
		table.setBounds(163, 235, 1, 1);
		scrollBar.getViewport ().add(table);
		
		btnNewButton_8 = new JButton("Add");
		btnNewButton_8.setBackground(Factory.saveBtnColor);
		btnNewButton_8.setBounds(10, 514, 109, 34);
		btnNewButton_8.setForeground(Factory.buttonTextColor);
		btnNewButton_8.addActionListener(this);
		add(btnNewButton_8);
		
		
		
		btnNewButton_9 = new JButton("Modify");
		btnNewButton_9.setBackground(Factory.modifyBtnColor);
		btnNewButton_9.setBounds(750, 514, 109, 34);
		btnNewButton_9.setForeground(Factory.buttonTextColor);
		btnNewButton_9.addActionListener(this);
		add(btnNewButton_9);
		
		btnNewButton_10 = new JButton("Delete");
		btnNewButton_10.setBackground(Factory.deleteBtnColor);
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
		case "Modify":
			EventQueue.invokeLater(new Runnable() {
				

				@Override
				public void run() {

					int row = table.getSelectedRow();
					if (row == -1) {
						DialogService.showErrorMgs(Factory.getMainFrame(), "Please select Row First", "Alert");
					} else {
						BookModel bookModel = list.get(row);
						Factory.getBodyPanal().removeAll();
						Factory.getBodyPanal().add(new AddBookPage(true, bookModel));
						Factory.refresh();
					}

				}
			});
			break;

		case "Delete":
			EventQueue.invokeLater(new Runnable() {
				

				@Override
				public void run() {
					int row = table.getSelectedRow();
					if (row == -1) {
						DialogService.showErrorMgs(Factory.getMainFrame(), "Please select Row First", "Alert");
					} else {
						BookModel bookModel = list.get(row);
						if(bookModel.getBook_Total() == bookModel.getBook_aval()){
							BookService bookService = (BookService) Factory.getContext().getBean("bookService");
							boolean status =bookService.delteBook(bookModel);
							DialogService.showMgs(Factory.getMainFrame(), "Book Delete Successfully..!", "Book Delete Action");
							Factory.getBodyPanal().removeAll();
							Factory.getBodyPanal().add(new BookListPage());
							Factory.refresh();
							
						}else{
							DialogService.showErrorMgs(Factory.getMainFrame(), "You Can't Delete Book Because Book Issued Some one..!", "Alert");
						}
						
					}
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
		case "Search":
			EventQueue.invokeLater(new Runnable() {

				@Override
				public void run() {
					String columnType=comboBox.getSelectedItem().toString();
					String columnValue=textField.getText();
					if(columnValue.equals("") || columnValue==null) {
						DialogService.showErrorMgs(Factory.getMainFrame(), "Please fill search Content", "Alert");
						scrollBar.remove(table);
						table = new JTable(getBookList(null, null),columnName());
						table.setBounds(163, 235, 1, 1);
						scrollBar.getViewport ().add(table);
					}else{
						String[][]  list=getBookList(columnType, columnValue);
						if(list.length==0){
							DialogService.showErrorMgs(Factory.getMainFrame(), "No record found", "Alert");
						}else{
							scrollBar.remove(table);
							table = new JTable(list,columnName());
							table.setBounds(163, 235, 1, 1);
							scrollBar.getViewport ().add(table);
						}
					}
					Factory.refresh();
				}
			});
			break;
		case "Clear":
			EventQueue.invokeLater(new Runnable() {

				@Override
				public void run() {
					textField.setText("");
					comboBox.setSelectedIndex(0);
					table = new JTable(getBookList(null, null),columnName());
					table.setBounds(163, 235, 1, 1);
					scrollBar.getViewport ().add(table);
					Factory.refresh();
				}
			});
			break;

		case "Add":
			EventQueue.invokeLater(new Runnable() {

				@Override
				public void run() {
					Factory.homePage();
					AddBookPage addbook = new AddBookPage(true,null);
					Factory.getBodyPanal().add(addbook);
					Factory.refresh();
				}
			});
			break;
		

		default:
			break;
		}
	}
	public String[] columnName() {
		String columnName[] = { "Book_id","Book Name","Book Type", "Book Mrp", "Book Rent", "Book Rant per day", "Book Authour","publication","Available","Total"};
		return columnName;
	}
	
	public String[][] getBookList(String searchBy, String value){
		BookService bookService = (BookService) Factory.getContext().getBean("bookService");
		list = new ArrayList<BookModel>();
		if(searchBy!=null && value!=null)
			list = bookService.getSearchBookList(searchBy, value);
		else
			list = bookService.getBookaList();
		String rowData[][] =new String[list.size()][10]; ;
		Iterator<BookModel> itr =  list.iterator();
		int i=0;
		while (itr.hasNext()) {
			BookModel book = (BookModel) itr.next();
			System.out.println("name Book"+book.getBook_name());
			rowData[i][0] = ""+book.getBook_id();
			rowData[i][1] = ""+book.getBook_name();
			rowData[i][2] = ""+getBookType(book.getBook_typeId());
			rowData[i][3] = ""+book.getBook_mrp();
			rowData[i][4] = ""+book.getBook_rent();
			rowData[i][5] = ""+book.getBook_rentPerDay();
			rowData[i][6] = ""+book.getBook_aurthor();
			rowData[i][7] = ""+book.getBook_publication();
			rowData[i][8] = ""+book.getBook_aval();
			rowData[i][9] = ""+book.getBook_Total();
			i++;
		}
		return rowData;
	}
	
	private String getBookType(int bookTypeId){
		if(bookTypeList == null){
			BookService bookService = (BookService) Factory.getContext().getBean("bookService");
			bookTypeList = bookService.getAllBookType();
		}
		
		for(BookTypeModel m :bookTypeList){
			if(m.getBookType_id() == bookTypeId)
				return m.getBookType_code();
		}
		
		return "";
	}
	
	
}
