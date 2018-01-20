package page;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;

import com.toedter.calendar.JDateChooser;

import common.service.DialogService;
import common.service.Factory;
import model.TransectionHistoryModel;
import service.ViewBalanceService;
import service.impl.UserLoginServiceImpl;

@SuppressWarnings("serial")
public class TransectionHistory extends JPanel implements ActionListener {
	
	Double total=0.00;
	JTable table;
	JDateChooser to;
	JDateChooser from;
	private JScrollPane scrollBar;
	private List<TransectionHistoryModel> list;
	public JButton btnNewButton_8;
	public JButton btnNewButton_9;
	public JButton btnNewButton_10;
	public JButton btnNewButton_11;
	public JLabel totalLabel;
	public TransectionHistory() {
		
		setBounds(10, 11, 1129, 571);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("View Transection");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(469, 10, 300, 14);
		add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 30, 1109, 8);
		add(separator);
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 497, 1109, 8);
		add(separator_1);

		JLabel lblNewLabel_1 = new JLabel("From");
		lblNewLabel_1.setBounds(10, 47, 73, 14);
		add(lblNewLabel_1);
		
		from = new JDateChooser();
		from.setBounds(73, 44, 175, 20);
	    add(from);
	    
		
		JLabel lblNewLabel_2 = new JLabel("To");
		lblNewLabel_2.setBounds(271, 47, 46, 14);
		add(lblNewLabel_2);
		
		to = new JDateChooser();
	    to.setBounds(327, 44, 167, 20);
	    add(to);
		
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
		
		table = new JTable(new String[0][7],columnName());
		table.setBounds(163, 235, 1, 1);
		scrollBar.getViewport ().add(table);
		
		totalLabel = new JLabel("Total = "+total);
		totalLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		totalLabel.setBounds(10, 500, 159, 60);
		add(totalLabel);
		
		/*btnNewButton_8 = new JButton("Add");
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
	*/	
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
					 
					if(from.getDate()==null || from.getDate().equals("") || to.getDate()==null ||  to.getDate().equals("") ) {
						DialogService.showErrorMgs(Factory.getMainFrame(), "Please fill search Content", "Alert");
						table = new JTable(new String[0][7],columnName());
						table.setBounds(163, 235, 1, 1);
						scrollBar.getViewport ().add(table);
						Factory.refresh();
					}else{
						String[][]  list=getBookList(from.getDate(), to.getDate());
						if(list.length==0){
							DialogService.showErrorMgs(Factory.getMainFrame(), "No record found", "Alert");
							table = new JTable(list,columnName());
							table.setBounds(163, 235, 1, 1);
							scrollBar.getViewport ().add(table);
							Factory.refresh();
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
					from.setCalendar(null);
					to.setCalendar(null);
					table = new JTable(new String[0][7],columnName());
					table.setBounds(163, 235, 1, 1);
					scrollBar.getViewport ().add(table);
					Factory.refresh();
				}
			});
			break;

				

		default:
			break;
		}
	}
	public String[] columnName() {
		String columnName[] = { "Serial no.","Student Id","Student Name","Receiver Id","Receiver Name","Date", "Amount Received" ,"Transection Type"};
		return columnName;
	}
	
	public String[][] getBookList(Date fromDate, Date toDate){
		total=0.00;
		ViewBalanceService viewBalanceService =  (ViewBalanceService) Factory.getContext().getBean("viewBalanceService");
		list = new ArrayList<TransectionHistoryModel>();
		if(fromDate!=null && toDate!=null)
			list = viewBalanceService.getTxnhistoryList(fromDate, toDate);
		String rowData[][] =new String[list.size()][8] ;
		
		for(int i=0;i<list.size();i++){
			TransectionHistoryModel transectionHistoryModel=(TransectionHistoryModel) list.get(i);
			rowData[i][0] = ""+(i+1);
			rowData[i][1] = ""+transectionHistoryModel.getCustomerModel().getCustomer_id();
			rowData[i][2] = ""+transectionHistoryModel.getCustomerModel().getCustomer_name();
			rowData[i][3] = ""+transectionHistoryModel.getUserModel().getUser_id();
			rowData[i][4] = ""+transectionHistoryModel.getUserModel().getUser_name();
			rowData[i][5] = ""+transectionHistoryModel.getTxn_date();
			rowData[i][6] = ""+transectionHistoryModel.getAmount();
			rowData[i][7] = ""+transectionHistoryModel.getTxn_type();
			if(transectionHistoryModel.getTxn_type().equals("W"))
				total=total-transectionHistoryModel.getAmount();
			else
				total=total+transectionHistoryModel.getAmount();
			
			 
		}
		totalLabel.setText("Total = "+total);
		return rowData;
	}
	
	
}
