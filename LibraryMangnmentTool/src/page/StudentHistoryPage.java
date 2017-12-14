package page;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

import common.service.DialogService;
import common.service.Factory;
import model.GetStudentModel;
import service.CustomerService;

public class StudentHistoryPage extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTable table;
	
	
	public StudentHistoryPage(String customer_id,boolean flag) {
		setBounds(20, 79, 1099, 481);
		setBackground(Color.WHITE);
		setLayout(null);
		
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
													int dialogButton= JOptionPane.YES_NO_OPTION;
													DialogService.confirmPopup(Factory.getMainFrame(), "DO You Want Submit Book ?", "Submit Confirmation", dialogButton);
													
													if(dialogButton == JOptionPane.YES_OPTION){
														int row = table.getSelectedRow();
														
														if (row == -1) {
															DialogService.showErrorMgs(Factory.getMainFrame(), "Please select one row", "Alert");
														} else {
															String value =table.getModel().getValueAt(row, 0).toString();
															String name = table.getModel().getValueAt(row, 1).toString();
															String mobile = table.getModel().getValueAt(row, 2).toString();
															String email = table.getModel().getValueAt(row, 3).toString();
															String student_id = table.getModel().getValueAt(row, 4).toString();
															String Balence = table.getModel().getValueAt(row, 5).toString();
															System.out.println(value+"  "+name+"  "+email +"  "+student_id+"  "+ Balence);
														}
													}
												}
											});
		break;
		
		}
		
		
		
		
	
	}
	public String[] columnName() {
		String columnName[] = { "Book Name","Aurther","Publication","Book issue date", "Book Submit date", "Charge","Status"};
		return columnName;
	}
	
	public String[][] getRowData(String id ,boolean flag){
		CustomerService customerService = (CustomerService) Factory.getContext().getBean("customerService");
		List<GetStudentModel> list=null;	
			if(!flag){
				list = customerService.viewHistory(id);
			}else{
				 list = customerService.viewAlloted(id,"A");	
				}
				String rowData[][] =new String[list.size()][7];
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
						rowData[i][5] = (book.getTxn_charge()!=null)?""+book.getTxn_charge():"";
						rowData[i][6] = (book.getItm_status_flag().equals("A"))?"Issued":"Submitted";
						i++;
				}
			
		return rowData;
	}

}
