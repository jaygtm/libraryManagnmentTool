package page;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;

import com.toedter.calendar.JDateChooser;

import common.service.Factory;
import model.BookModel;
import model.BookTypeModel;
import service.BookService;

@SuppressWarnings("serial")
public class TransectionHistory extends JPanel implements ActionListener {
	
	int total=0;
	JTable table;
	JDateChooser to;
	JDateChooser from;
	private JScrollPane scrollBar;
	private List<BookTypeModel> bookTypeList;
	private List<BookModel> list;
	public JButton btnNewButton_8;
	public JButton btnNewButton_9;
	public JButton btnNewButton_10;
	public JButton btnNewButton_11;
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
		
		table = new JTable(getBookList(null,null),columnName());
		table.setBounds(163, 235, 1, 1);
		scrollBar.getViewport ().add(table);
		
		JLabel totalLabel = new JLabel("Total:- "+total);
		totalLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		totalLabel.setBounds(10, 514, 109, 34);
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
				public void run() {/*
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
				*/}
			});
			break;
		case "Clear":
			EventQueue.invokeLater(new Runnable() {

				@Override
				public void run() {
					from.setCalendar(null);
					to.setCalendar(null);
					table = new JTable(getBookList(null, null),columnName());
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
		String columnName[] = { "Serial no.","Student Name","Receiver Name","Date", "Amount Received"};
		return columnName;
	}
	
	public String[][] getBookList(String searchBy, String value){
		BookService bookService = (BookService) Factory.getContext().getBean("bookService");
		list = new ArrayList<BookModel>();
		if(searchBy!=null && value!=null)
			list = bookService.getSearchBookList(searchBy, value);
		else
			list = bookService.getBookaList();
		String rowData[][] =new String[list.size()][4]; ;
		Iterator<BookModel> itr =  list.iterator();
		int i=0;
		while (itr.hasNext()) {
			rowData[i][0] = ""+i;
			rowData[i][1] = "";
			rowData[i][2] = "";
			rowData[i][3] = "";
			rowData[i][4] = "";
			rowData[i][5] = "";
			total=total+0;//rowData[i][4] 
			i++;
		}
		return rowData;
	}
	
	
}
