package page;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import common.service.DialogService;
import common.service.Factory;
import common.service.Validation;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import model.BookModel;
import model.BookTypeModel;
import service.BookService;

public class AddBookPage extends JPanel implements ActionListener {
	private BookService bookService;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JComboBox comboBox;
	JButton btnNewButton_6;//Save Button
	JButton downloadTemplet,imports;
	BookModel bookModel;
	private boolean backOnList =true;
	
	{
		bookService = (BookService) Factory.getContext().getBean("bookService");
	}
	
	public  AddBookPage() {
		setBounds(10, 11, 1129, 571);
		// setBackground(new Color(0,0,0,0));
		 setBorder(BorderFactory.createTitledBorder(""));
		 setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 26));
		 setLayout(null);
		
		JLabel lblStudentRegistration = new JLabel("Add Book");
		lblStudentRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentRegistration.setBounds(363, 11, 214, 32);
		lblStudentRegistration.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 26));
		 add(lblStudentRegistration);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(148, 108, 128, 32);
		 add(lblNewLabel);
		
		JLabel lblBookTypeId = new JLabel("Type Name");
		lblBookTypeId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBookTypeId.setHorizontalAlignment(SwingConstants.LEFT);
		lblBookTypeId.setBounds(148, 151, 140, 32);
		 add(lblBookTypeId);
		
		JLabel lblBookMrp = new JLabel("MRP");
		lblBookMrp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBookMrp.setBounds(148, 194, 128, 32);
		 add(lblBookMrp);
		
		JLabel lblBookRent = new JLabel("Rent");
		lblBookRent.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBookRent.setBounds(148, 237, 125, 32);
		 add(lblBookRent);
		
		JLabel lblBookRentPer = new JLabel("Rent Per Day");
		lblBookRentPer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBookRentPer.setBounds(148, 280, 140, 32);
		 add(lblBookRentPer);
		
		JLabel lblBookAurthor = new JLabel("Book Aurthor");
		lblBookAurthor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBookAurthor.setBounds(148, 323, 128, 32);
		 add(lblBookAurthor);
		
		JLabel lblPublication = new JLabel("Publication");
		lblPublication.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPublication.setBounds(148, 366, 112, 32);
		 add(lblPublication);
		
		textField = new JTextField();
		textField.setBounds(432, 117, 261, 20);
		 add(textField);
		textField.setColumns(10);
		Validation.validateString(textField);
		
		comboBox = new JComboBox<String>(getBookType());
		comboBox.setBounds(432, 160, 261, 20);
		//comboBox.setBackground(new Color(0,0,0,0));
		 add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setBounds(432, 203, 262, 20);
		 add(textField_1);
		textField_1.setColumns(10);
		Validation.validateDecimal(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(432, 246, 261, 20);
		 add(textField_2);
		textField_2.setColumns(10);
		Validation.validateNumber(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(432, 289, 261, 20);
		 add(textField_3);
		textField_3.setColumns(10);
		Validation.validateNumber(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(432, 331, 261, 23);
		 add(textField_4);
		textField_4.setColumns(10);
		Validation.validateString(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setBounds(432, 374, 261, 23);
		 add(textField_5);
		textField_5.setColumns(10);
		Validation.validateString(textField_5);
		
		btnNewButton_6 = new JButton("Save");
		btnNewButton_6.setBounds(850, 516, 115, 32);
		btnNewButton_6.setBackground(Factory.saveBtnColor);
		btnNewButton_6.addActionListener(this);
		btnNewButton_6.setForeground(Factory.buttonTextColor);
		 add(btnNewButton_6);
		 
		 downloadTemplet = new JButton("Download Template");
		 downloadTemplet.setBounds(10, 516, 180, 32);
		 downloadTemplet.setBackground(Factory.saveBtnColor);
		 downloadTemplet.addActionListener(this);
		 downloadTemplet.setForeground(Factory.buttonTextColor);
			 add(downloadTemplet);
		
		imports = new JButton("Import Excel");
		imports.setBounds(200, 516, 115, 32);
		imports.setBackground(Factory.saveBtnColor);
		imports.addActionListener(this);
		imports.setForeground(Factory.buttonTextColor);
				 add(imports);
		
		JButton btnSave = new JButton("Cancel");
		btnSave.setBackground(Factory.cancleBtnColor);
		btnSave.setBounds(979, 514, 109, 34);
		btnSave.setForeground(Factory.buttonTextColor);
		btnSave.addActionListener(this);
		 add(btnSave);
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 497, 1109, 8);
		 add(separator_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 50, 1109, 8);
		 add(separator);
		 
		setVisible(true);
		
	}
	
	public AddBookPage(boolean backOnList,BookModel model){
		this();
		this.backOnList =backOnList;
		if(model != null){
			setModel(model);
			this.bookModel = model;
		}
			
	}
	private void setModel(BookModel model){
		textField.setText(model.getBook_name());
		textField_1.setText(""+model.getBook_mrp());
		textField_2.setText(""+model.getBook_rent());
		textField_3.setText(""+model.getBook_rentPerDay());
		textField_4.setText(""+model.getBook_aurthor());
		textField_5.setText(model.getBook_publication());
		comboBox.setSelectedIndex(getIndexOfBookType(model.getBook_typeId())+1);
		btnNewButton_6.setText("Update");
	}
	private int getIndexOfBookType(int bookTypeId){
		List<BookTypeModel> list = bookService.getAllBookType();
		int i=0;
		for(BookTypeModel model : list){
			if(model.getBookType_id() == bookTypeId)
				return i;
			i++;
		}
		return 0;
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
						DialogService.showErrorMgs(Factory.getMainFrame(), "Please Fill All Field", "Error");
						
					}else{
						if(!type.equals("-Select-")){
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
							
							
							Serializable status = bookService.addBook(m);
							if(status!=null)
								DialogService.showMgs(Factory.getMainFrame(), "Book Add Successfully your book id :: "+status, "Success");
							else
								DialogService.showErrorMgs(Factory.getMainFrame(), "Error While saving book please try again", "Error");
						}else
							DialogService.showErrorMgs(Factory.getMainFrame(), "Please Select Book Type", "Error");
					}
					
					
					
			}
		});
		
		break;
		
		case "Cancel": EventQueue.invokeLater(new Runnable() {
			
							@Override
							public void run() {
								if(backOnList){
									Factory.getBodyPanal().removeAll();
									Factory.getBodyPanal().add(new BookListPage());
								}else
									Factory.getBodyPanal().removeAll();
								Factory.refresh();
							}
						});
			break;
			
		case "Download Template": EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				try {
					URL fileUrl = DashboardPage.class.getResource("/AddBook.xlsx");
					String home = System.getProperty("user.home");
					Factory.downloadUsingNIO(fileUrl, home+"/Desktop/AddBook.xlsx");
					DialogService.showMgs(Factory.getMainFrame(), "Book Add Template Download Successfully on Desktop", "Success");
				} catch (IOException e) {
					e.printStackTrace();
					DialogService.showErrorMgs(Factory.getMainFrame(), "Error While Download please try again", "Error");
				}
			}
		});
		break;
		
		case "Import Excel": EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
			}
		});
		break;
		case "Update": EventQueue.invokeLater(new Runnable() {
							
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
									DialogService.showErrorMgs(Factory.getMainFrame(), "Please Fill All Field", "Error");
									
								}else{
									if(!type.equals("-Select-")){
										BookModel m = bookModel;
										m.setBook_name(bookName);
										m.setBook_aurthor(authour);
										m.setBook_publication(publication);
										m.setBook_mrp(Integer.parseInt(mrp));
										m.setBook_rent(Integer.parseInt(rent));
										m.setBook_rentPerDay(Integer.parseInt(rentprdat));
										m.setBook_typeId(getBookId(type));
										
										boolean status = bookService.editBook(m);
										
										DialogService.showMgs(Factory.getMainFrame(), "Book Modify Successfully", "Success");
										
										Factory.getBodyPanal().removeAll();
										Factory.getBodyPanal().add(new BookListPage());
										Factory.refresh();
									}else
										DialogService.showErrorMgs(Factory.getMainFrame(), "Please Select Book Type", "Error");
								}
								
								
								
								
								
								if(backOnList){
									Factory.getBodyPanal().removeAll();
									Factory.getBodyPanal().add(new BookListPage());
								}else
									Factory.getBodyPanal().removeAll();
								Factory.refresh();
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
