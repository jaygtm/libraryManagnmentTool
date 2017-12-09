package page;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;

import common.service.DialogService;
import common.service.Factory;
import model.BookModel;
import model.StudentHistoryModel;
import service.BookService;

public class IssueBookPage extends JPanel implements ActionListener {
	
	private JTextField authour_1,authour_2,authour_3,authour_4,authour_5,publication_1,publication_2,publication_3,publication_4,publication_5;
	private JComboBox<String> Book_1,book_2,book_3,book_4,book_5;
	private JComboBox<String> day_1,day_2,day_3,day_4,day_5;
	private String booklist[];
	private String authorList[];
	private String publicationList[];
	private int bookId [];
	private int noOfBookAvilabe ;
	private int customerId;
	private JButton btnIssue;
	
	private String noOfDays[] = new String[]{"-Select-","1","3","5","7","10","15","30","45"};
	
	
	
	
	
	{
		setBookList();
		noOfBookAvilabe = 2;
		
	}
	
	
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

		Book_1 = new JComboBox<String>(booklist);
		Book_1.setBounds(84, 82, 219, 20);
		Book_1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				int a = Book_1.getSelectedIndex();
				authour_1.setText(authorList[a]);
				publication_1.setText(publicationList[a]);

			}
		});
		add(Book_1);

		book_2 = new JComboBox<String>(booklist);
		// book_2.setVisible(false);
		book_2.setBounds(84, 126, 219, 20);
		book_2.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				int a = book_2.getSelectedIndex();
				authour_2.setText(authorList[a]);
				publication_2.setText(publicationList[a]);
			}
		});
		add(book_2);

		book_3 = new JComboBox<String>(booklist);
		book_3.setBounds(84, 169, 219, 20);
		book_3.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				int a = book_3.getSelectedIndex();
				authour_3.setText(authorList[a]);
				publication_3.setText(publicationList[a]);
			}
		});
		add(book_3);

		book_4 = new JComboBox<String>(booklist);
		book_4.setBounds(84, 211, 219, 20);
		book_4.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				int a = book_4.getSelectedIndex();
				authour_4.setText(authorList[a]);
				publication_4.setText(publicationList[a]);
			}
		});
		add(book_4);

		book_5 = new JComboBox<String>(booklist);
		book_5.setBounds(84, 254, 219, 20);
		book_5.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				int a = book_5.getSelectedIndex();
				authour_5.setText(authorList[a]);
				publication_5.setText(publicationList[a]);
			}
		});
		add(book_5);

		JLabel lblNewLabel_3 = new JLabel("No Of Days");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_3.setBounds(473, 57, 106, 14);
		add(lblNewLabel_3);

		day_1 = new JComboBox<String>(noOfDays);
		day_1.setBounds(434, 82, 143, 20);

		add(day_1);

		day_2 = new JComboBox<String>(noOfDays);
		day_2.setBounds(434, 126, 143, 20);
		add(day_2);

		day_3 = new JComboBox<String>(noOfDays);
		day_3.setBounds(434, 169, 143, 20);
		add(day_3);

		day_4 = new JComboBox<String>(noOfDays);
		day_4.setBounds(434, 211, 143, 20);
		add(day_4);

		day_5 = new JComboBox<String>(noOfDays);
		day_5.setBounds(436, 254, 143, 20);
		add(day_5);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(34, 318, 925, 8);
		add(separator_1);

		btnIssue = new JButton("Issue");
		btnIssue.setBounds(243, 337, 106, 34);
		btnIssue.addActionListener(this);
		add(btnIssue);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(406, 337, 113, 34);
		btnCancel.addActionListener(this);
		add(btnCancel);

		JLabel lblNewLabel = new JLabel("Authour");
		lblNewLabel.setBounds(689, 57, 46, 14);
		add(lblNewLabel);

		authour_1 = new JTextField();
		authour_1.setBounds(658, 82, 106, 20);
		authour_1.setEditable(false);
		add(authour_1);
		authour_1.setColumns(10);

		authour_2 = new JTextField();
		authour_2.setBounds(658, 126, 106, 20);
		authour_2.setEditable(false);
		add(authour_2);
		authour_2.setColumns(10);

		authour_3 = new JTextField();
		authour_3.setBounds(658, 169, 106, 20);
		authour_3.setEditable(false);
		add(authour_3);
		authour_3.setColumns(10);

		authour_4 = new JTextField();
		authour_4.setBounds(658, 211, 106, 20);
		authour_4.setEditable(false);
		add(authour_4);
		authour_4.setColumns(10);

		authour_5 = new JTextField();
		authour_5.setBounds(658, 254, 106, 20);
		authour_5.setEditable(false);
		add(authour_5);
		authour_5.setColumns(10);

		JLabel lblPublication = new JLabel("Publication");
		lblPublication.setBounds(850, 59, 81, 14);
		add(lblPublication);

		publication_1 = new JTextField();
		publication_1.setBounds(826, 82, 121, 20);
		publication_1.setEditable(false);
		add(publication_1);
		publication_1.setColumns(10);

		publication_2 = new JTextField();
		publication_2.setBounds(826, 126, 121, 20);
		publication_2.setEditable(false);
		add(publication_2);
		publication_2.setColumns(10);

		publication_3 = new JTextField();
		publication_3.setBounds(826, 169, 121, 20);
		publication_3.setEditable(false);
		add(publication_3);
		publication_3.setColumns(10);

		publication_4 = new JTextField();
		publication_4.setBounds(826, 211, 121, 20);
		publication_4.setEditable(false);
		add(publication_4);
		publication_4.setColumns(10);

		publication_5 = new JTextField();
		publication_5.setBounds(826, 254, 121, 20);
		publication_5.setEditable(false);
		add(publication_5);
		publication_5.setColumns(10);

		switch (noOfBookAvilabe) {
		case 0:
			Book_1.setVisible(false);
			authour_1.setVisible(false);
			publication_1.setVisible(false);
			day_1.setVisible(false);

			book_2.setVisible(false);
			authour_2.setVisible(false);
			publication_2.setVisible(false);
			day_2.setVisible(false);

			book_3.setVisible(false);
			authour_3.setVisible(false);
			publication_3.setVisible(false);
			day_3.setVisible(false);

			book_4.setVisible(false);
			authour_4.setVisible(false);
			publication_4.setVisible(false);
			day_4.setVisible(false);

			book_5.setVisible(false);
			authour_5.setVisible(false);
			publication_5.setVisible(false);
			day_5.setVisible(false);
			
			btnIssue.setEnabled(false);

			DialogService.showErrorMgs(Factory.getMainFrame(), "Max Book Has Alloted..! Please Submit First..!",
					"Maximum Book Issue");

			break;
		case 1:
			book_2.setVisible(false);
			authour_2.setVisible(false);
			publication_2.setVisible(false);
			day_2.setVisible(false);

			book_3.setVisible(false);
			authour_3.setVisible(false);
			publication_3.setVisible(false);
			day_3.setVisible(false);

			book_4.setVisible(false);
			authour_4.setVisible(false);
			publication_4.setVisible(false);
			day_4.setVisible(false);

			book_5.setVisible(false);
			authour_5.setVisible(false);
			publication_5.setVisible(false);
			day_5.setVisible(false);
			break;
		case 2:
			book_3.setVisible(false);
			authour_3.setVisible(false);
			publication_3.setVisible(false);
			day_3.setVisible(false);

			book_4.setVisible(false);
			authour_4.setVisible(false);
			publication_4.setVisible(false);
			day_4.setVisible(false);

			book_5.setVisible(false);
			authour_5.setVisible(false);
			publication_5.setVisible(false);
			day_5.setVisible(false);
			break;
		case 3:
			book_4.setVisible(false);
			authour_4.setVisible(false);
			publication_4.setVisible(false);
			day_4.setVisible(false);

			book_5.setVisible(false);
			authour_5.setVisible(false);
			publication_5.setVisible(false);
			day_5.setVisible(false);
			break;
		case 4:
			book_5.setVisible(false);
			authour_5.setVisible(false);
			publication_5.setVisible(false);
			day_5.setVisible(false);
			break;

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand().trim();
		System.out.println("Action " + action+" At "+getClass().toString());
		JPanel self = this;
		switch (action) {
		case "Issue":EventQueue.invokeLater(new Runnable() {
			
												@Override
												public void run() {
												btnIssue.setEnabled(false);
												validationAndSave();
													
													
													
												}
											});
			
			
		break;
		case "Cancel":EventQueue.invokeLater(new Runnable() {
			
												@Override
												public void run() {
												self.getParent().remove(self);
												Factory.refresh();
												}
											});
			break;
		
		}
		
		
		
		
	}
	
	private boolean validationAndSave(){
		boolean flagNoBook = true;
		
		if(!Book_1.getSelectedItem().toString().equals("-Select-")){
			flagNoBook = false;
			if(!day_1.getSelectedItem().toString().equals("-Select-")){
				int a = Book_1.getSelectedIndex();
				try {
				StudentHistoryModel smodel = new StudentHistoryModel();
				
				smodel.setBook_id(bookId[a-1]);
				smodel.setCustomer_id(this.customerId);
				smodel.setItm_status_flag("I");
				smodel.setItm_isu_dt(new Date());
				
				smodel.setItm_sub_dt(Factory.addNextDay(day_1.getSelectedItem().toString()));
					
				BookService bookService = (BookService) Factory.getContext().getBean("bookService");
				
				if(bookService.issueBook(smodel)){
					DialogService.showMgs(Factory.getMainFrame(), "Book Issued Successfully..!", "Success");
					Factory.homePage();
					Factory.getBodyPanal().add(new StudentList());
					Factory.refresh();
				}else
					DialogService.showErrorMgs(Factory.getMainFrame(), "Error To Issue Book ..!", "Error");
					
				} catch (Exception e) {
						e.printStackTrace();
						DialogService.showErrorMgs(Factory.getMainFrame(), "StackError"+e.getMessage(), "Error Developer Side");
				}   
				
				
				
			}else{
				DialogService.showErrorMgs(Factory.getMainFrame(),"Please Select day of Book 1", "Error");
				btnIssue.setEnabled(true);
			}
			
		}
		if(!book_2.getSelectedItem().toString().equals("-Select-")){
			flagNoBook = false;
			if(!day_2.getSelectedItem().toString().equals("-Select-")){
				int a = book_2.getSelectedIndex();
				
				
			}else{
				DialogService.showErrorMgs(Factory.getMainFrame(),"Please Select day of Book 2", "Error");
				btnIssue.setEnabled(true);
			}
			
		}
		if(!book_3.getSelectedItem().toString().equals("-Select-")){
			flagNoBook = false;
			if(!day_3.getSelectedItem().toString().equals("-Select-")){
				int a = book_3.getSelectedIndex();
				
				
			}else{
				DialogService.showErrorMgs(Factory.getMainFrame(),"Please Select day of Book 3", "Error");
				btnIssue.setEnabled(true);
			}
			
		}
		if(!book_4.getSelectedItem().toString().equals("-Select-")){
			flagNoBook = false;
			if(!day_4.getSelectedItem().toString().equals("-Select-")){
				int a = book_4.getSelectedIndex();
				
				
			}else{
				DialogService.showErrorMgs(Factory.getMainFrame(),"Please Select day of Book 4", "Error");
				btnIssue.setEnabled(true);
			}
			
		}
		if(!book_5.getSelectedItem().toString().equals("-Select-")){
			flagNoBook = false;
			if(!day_5.getSelectedItem().toString().equals("-Select-")){
				int a = book_5.getSelectedIndex();
				
				
			}else{
				DialogService.showErrorMgs(Factory.getMainFrame(),"Please Select day of Book 5", "Error");
				btnIssue.setEnabled(true);
			}
			
		}
		if(flagNoBook){
			DialogService.showErrorMgs(Factory.getMainFrame(),"Please Select Book..!", "Error");
			btnIssue.setEnabled(true);
		}
		
		
		return false;
		
	}
	//customerId / studentId
	public boolean setStudentNameAndId(String customerId){
		this.customerId = Integer.parseInt(customerId);
		return true;
	}
	
	
	
	
	
	
	private void setBookList(){
		BookService bookService 	= (BookService) Factory.getContext().getBean("bookService");
		List<BookModel> list 		= bookService.getBookaList();
		Collections.sort(list);  
		
		this.booklist 			= new String[list.size()+1];
		this.authorList 		= new String[list.size()+1];
		this.publicationList	= new String[list.size()+1];
		this.bookId				= new int[list.size()];
		this.booklist[0] 	= "-Select-";
		this.authorList[0]	= "";
		this.publicationList[0] = "";
		
		int i=1;
		for(BookModel book :list){
			this.booklist[i] 	= book.getBook_name();
			this.authorList[i]	= book.getBook_aurthor();
			this.publicationList[i] = book.getBook_publication();
			bookId[i-1] = book.getBook_id();
			i++;
		}
	}
}
