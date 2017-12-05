package page;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import common.service.DialogService;
import common.service.Factory;
import model.BookModel;
import model.BookTypeModel;
import service.BookService;

public class AddBookPage implements ActionListener {
	private BookService bookService;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JComboBox comboBox;
	public void addBookPage(JPanel panel_1) {
		JPanel add_Book = new JPanel();
		add_Book.setBounds(177, 25, 867, 538);
		//add_Book.setBackground(new Color(0,0,0,0));
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
		
		comboBox = new JComboBox<String>(getBookType());
		comboBox.setBounds(432, 160, 261, 20);
		//comboBox.setBackground(new Color(0,0,0,0));
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
		
		JButton btnNewButton_6 = new JButton("Save");
		btnNewButton_6.setBounds(630, 448, 100, 35);
		btnNewButton_6.addActionListener(this);
		add_Book.add(btnNewButton_6);
		
		JButton btnSave = new JButton("Cancel");
		btnSave.setBounds(750, 448, 100, 35);
		btnSave.addActionListener(this);
		add_Book.add(btnSave);
		
	}
	public AddBookPage(){
		bookService = (BookService) Factory.getContext().getBean("bookService");
	}
	
	private String[] getBookType(){
		List<BookTypeModel> list = bookService.getAllBookType();
		String arr[] = new String[list.size()+1];
		arr[0] = "-Select-";
		for (int i = 0; i < list.size(); i++) {
			arr[i+1] = list.get(i).getBookType_code(); 
		}
		return arr;
	}
	private Integer getBookId(String bookCode){
		List<BookTypeModel> list = bookService.getAllBookType();
		for(BookTypeModel m : list)
			if(m.getBookType_code().equals(bookCode))
				return m.getBookType_id();
		return null;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		System.out.println("Action in Add Book"+action);
		
		switch (action) {
		case "Save":EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
					String bookName = textField.getText();
					String mrp = textField_1.getText();
					String rent = textField_2.getText();
					String rentprdat = textField_3.getText();
					String authour = textField_4.getText();
					String publication = textField_5.getText();
					String type = comboBox.getSelectedItem().toString();
					
					if(checkBlank(new String[]{bookName,mrp,rent,rentprdat,authour,publication,type})){
						DialogService.showErrorMgs(textField, "Please Fill All Field", "Error");
						
					}else{
						BookModel m = new BookModel();
						m.setBook_name(bookName);
						m.setBook_aurthor(authour);
						m.setBook_publication(publication);
						m.setBook_mrp(Integer.parseInt(mrp));
						m.setBook_rent(Integer.parseInt(rent));
						m.setBook_rentPerDay(Integer.parseInt(rentprdat));
						m.setBook_typeId(getBookId(type));
						m.setBook_Total(1);
						m.setBook_aval(1);
						
						
						boolean status = bookService.addBook(m);
						
						DialogService.showMgs(comboBox, "Book Add Successfully", "Success");
						
					}
					
					
					
			}
		});
			
			
			break;
		default:
			break;
		}
		
		
		
	}
	private boolean checkBlank(String[] arr){
		for(String s :arr){
			if(s.trim().equals(""))
				return true;
		}
		
		return false;
	}
	

}
