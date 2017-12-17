package page;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.JTableHeader;

import common.service.DialogService;
import common.service.Factory;
import model.BookModel;
import model.GetStudentModel;
import service.BookService;
import service.CustomerService;

public class StudentHistoryPage extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTable table;
	int latefee = 10; 
	
	public StudentHistoryPage(String customer_id,boolean flag) {
		setBounds(20, 79, 1099, 481);
		setBackground(Color.WHITE);
		setLayout(null);
		if(flag)
			setBorder(BorderFactory.createTitledBorder("Alloted Book"));
		else
			setBorder(BorderFactory.createTitledBorder("Book History"));
		
		JScrollPane gridpanel = new JScrollPane();
		gridpanel.setBounds(0, 0, 1099, 450);
		gridpanel.setBackground(new Color(0,0,0,10));
			    
		table = new JTable(getRowData(customer_id,flag),columnName());
        table.setRowSelectionAllowed(true);
        table.setSelectionMode(1);
        table.setColumnSelectionAllowed(false);
        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.LIGHT_GRAY);
        
		gridpanel.getViewport ().add(table);
		add(gridpanel);
		if(flag){
			JButton submitBook = new JButton("Submit Book");
			submitBook.setBackground(Factory.backBtnColor);
			submitBook.setBounds(530, 450, 120, 30);
			submitBook.setForeground(Factory.buttonTextColor);
			submitBook.addActionListener(this);
			add(submitBook);
			
		}
		
		
		JButton btnNewButton_9 = new JButton("Print as Excel");
		btnNewButton_9.setBackground(Factory.backBtnColor);
		btnNewButton_9.setForeground(Factory.buttonTextColor);
		btnNewButton_9.setBounds(660, 450, 120, 30);
		btnNewButton_9.addActionListener(this);
		add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("Back");
		btnNewButton_10.setBackground(Factory.backBtnColor);
		btnNewButton_10.setBounds(790, 450, 120, 30);
		btnNewButton_10.setForeground(Factory.buttonTextColor);
		btnNewButton_10.addActionListener(this);
		btnNewButton_10.setForeground(Factory.buttonTextColor);
		add(btnNewButton_10);
		JButton btnNewButton_11 = new JButton("Cancel");
		btnNewButton_11.setBackground(Factory.cancleBtnColor);
		btnNewButton_11.setBounds(920, 450, 120, 30);
		btnNewButton_11.addActionListener(this);
		btnNewButton_11.setForeground(Factory.buttonTextColor);
		add(btnNewButton_11);
		setVisible(true);
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {


		String action = e.getActionCommand().trim();
		System.out.println("Action " + action+" At "+getClass().toString());
		JPanel self = this;
		switch (action) {
		case "Back":EventQueue.invokeLater(new Runnable() {
			
												@Override
												public void run() {
													self.getParent().remove(self);
													Factory.refresh();
												}
											});
			
			
		break;
		case "Cancel":EventQueue.invokeLater(new Runnable() {
			
												@Override
												public void run() {
												Factory.getBodyPanal().removeAll();
												Factory.getBodyPanal().add(new StudentList());
												Factory.refresh();
												}
											});
			break;
		case "Submit Book":EventQueue.invokeLater(new Runnable() {
												
												@Override
												public void run() {
													int row = table.getSelectedRow();
													
													if (row == -1) {
														DialogService.showErrorMgs(Factory.getMainFrame(), "Please select one row", "Alert");
													} else {
														int dialogButton= JOptionPane.YES_NO_OPTION;
														DialogService.confirmPopup(Factory.getMainFrame(), "DO You Want Submit Book ?", "Submit Confirmation", dialogButton);
														
														if(dialogButton == JOptionPane.YES_OPTION){
															GetStudentModel modal = list.get(row);	
															Date issueDate = modal.getItm_isu_dt();
															Date submitDate = modal.getItm_sub_dt();
															
															BookModel bookModel =  modal.getBook_id();
															
															int dayPr = bookModel.getBook_rentPerDay();
															int rent = bookModel.getBook_rent();
															//long day = Factory.dateDifference(issueDate,submitDate);
															
															
															Long charge =  0l;
															Long late_submit_charge =0l; 
															
															long day = Factory.dateDifference(submitDate, new Date());
															if(day >0){
																//over Date fine or none issued 
																long totalIssueDay 	= Factory.dateDifference(issueDate,submitDate);
																long overDay 		= Factory.dateDifference(submitDate,new Date());
																
																charge 				= ((rent/dayPr)*totalIssueDay);
																late_submit_charge 	= overDay*latefee ;
																
															}if(day == 0){
																long totalDay = Factory.dateDifference(issueDate,submitDate);
																charge = (rent/dayPr)*totalDay;
															}if(day < 0){
																long totalDay = Factory.dateDifference(issueDate,new Date());
																charge = (rent/dayPr)*totalDay;
															}
															
															bookModel.setBook_aval(bookModel.getBook_aval()+1);
															
															modal.setTxn_item_eq_submit_dt(new Date());
															modal.setTxn_charge(Double.parseDouble(charge.toString()));
															modal.setTxn_item_late_submit_charge(Double.parseDouble(late_submit_charge.toString()));
															modal.setItm_status_flag("S");
															modal.setBook_id(bookModel);
															CustomerService customerService = (CustomerService) Factory.getContext().getBean("customerService");
															customerService.modifyDeatils(modal);
															BookService bookService = (BookService) Factory.getContext().getBean("bookService");
															bookService.editBook(bookModel);
															DialogService.showMgs(Factory.getMainFrame(), "Successfully Submit", "Done");
														}
														
													}
													
													
													
												}
											});
		break;
		
		}
		
		
		
		
	
	}
	public String[] columnName() {
		String columnName[] = { "Book Name","Aurther","Publication","Book issue date", "Book Submit date","Submit Date", "Charge","Late Submit Charge","Status"};
		return columnName;
	}
	private List<GetStudentModel> list;
	public String[][] getRowData(String id ,boolean flag){
		CustomerService customerService = (CustomerService) Factory.getContext().getBean("customerService");
		list = null;	
			if(!flag){
				list = customerService.viewHistory(id);
			}else{
				 list = customerService.viewAlloted(id,"A");	
				}
				String rowData[][] =new String[list.size()][9];
				Iterator<GetStudentModel> itr =  list.iterator();
				int i=0;
				while (itr.hasNext()) {
						GetStudentModel book = (GetStudentModel) itr.next();
						//System.out.println("name Book"+book.toString());
						rowData[i][0] = ""+book.getBook_id().getBook_name();
						rowData[i][1] = ""+book.getBook_id().getBook_aurthor();
						rowData[i][2] = ""+book.getBook_id().getBook_publication();
						rowData[i][3] = ""+book.getItm_isu_dt();
						rowData[i][4] = ""+book.getItm_sub_dt();
						rowData[i][5] = (book.getTxn_item_eq_submit_dt()!=null)?""+book.getTxn_item_eq_submit_dt():"";
						rowData[i][6] = (book.getTxn_charge()!=null)?""+book.getTxn_charge():"";
						rowData[i][7] = (book.getTxn_item_late_submit_charge() != null )?book.getTxn_item_late_submit_charge().toString():"";
						rowData[i][8] = (book.getItm_status_flag().equals("A"))?"Issued":"Submitted";
						i++;
				}
			
		return rowData;
	}

}
