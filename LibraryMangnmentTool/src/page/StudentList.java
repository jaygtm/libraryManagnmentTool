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

import common.service.DialogService;
import common.service.Factory;
import model.BookModel;
import model.CustomerModel;
import service.BookService;
import service.CustomerService;

public class StudentList extends JPanel implements ActionListener {
	
	
	JTable table;
	JTextField textField;
	@SuppressWarnings("rawtypes")
	JComboBox comboBox;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public StudentList() {
		
		setBounds(93, 28, 1020, 529);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student List");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(469, 21, 89, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Search By");
		lblNewLabel_1.setBounds(10, 47, 73, 14);
		add(lblNewLabel_1);
		
		comboBox = new JComboBox(new String[]{"-Select-","Name","Mobile","Email"});
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
		
		JButton btnNewButton_8 = new JButton("Add");
		btnNewButton_8.setBounds(10, 475, 107, 43);
		btnNewButton_8.addActionListener(this);
		add(btnNewButton_8);
		
		JButton btnNewButton_12 = new JButton("View");
		btnNewButton_12.setBounds(550, 475, 114, 43);
		btnNewButton_12.addActionListener(this);
		add(btnNewButton_12);
		
		JButton btnNewButton_9 = new JButton("Modify");
		btnNewButton_9.setBounds(664, 475, 114, 43);
		btnNewButton_9.addActionListener(this);
		add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("Delete");
		btnNewButton_10.setBounds(788, 475, 101, 43);
		btnNewButton_10.addActionListener(this);
		add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("Cancel");
		btnNewButton_11.setBounds(899, 475, 100, 43);
		btnNewButton_11.addActionListener(this);
		add(btnNewButton_11);
		
	}
	
	public String[] columnName() {
		String columnName[] = { "Library Id No","Student Name", "Student Mobile", "Student email", "Student Id", "Student Balance"};
		return columnName;
	}
	
	
	public String[][] getRowData(){
		CustomerService customerService = (CustomerService) Factory.getContext().getBean("customerService");
		List<CustomerModel> list = customerService.getAllCustomerDetail();
		String rowData[][] =new String[list.size()][8]; ;
		Iterator<CustomerModel> itr =  list.iterator();
		int i=0;
		while (itr.hasNext()) {
			CustomerModel customer = (CustomerModel) itr.next();
			rowData[i][0] = ""+customer.getCustomer_id();
			rowData[i][1] = customer.getCustomer_name();
			rowData[i][2] = customer.getCustomer_mobile();
			rowData[i][3] = customer.getCustomer_email();
			rowData[i][4] = customer.getCustomer_cId();
			rowData[i][5] = ""+customer.getCustomer_balance();
			i++;
		}
		return rowData;
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
						DialogService.showErrorMgs(Factory.getMainFrame(), "Please select one row", "Alert");
					} else {
						int value = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
						String name = table.getModel().getValueAt(row, 1).toString();
						String mobile = table.getModel().getValueAt(row, 2).toString();
						String email = table.getModel().getValueAt(row, 3).toString();
						String student_id = table.getModel().getValueAt(row, 4).toString();
						String Balence = table.getModel().getValueAt(row, 5).toString();
						Factory.getBodyPanal().removeAll();
						ModifyPage modifyPage = new ModifyPage();
						modifyPage.modifyPage(Factory.getBodyPanal());
						modifyPage.getTextField_5().setText("" + value);
						modifyPage.getTextField().setText(name);
						modifyPage.getTextField_1().setText(mobile);
						modifyPage.getTextField_2().setText(email);
						modifyPage.getTextField_3().setText(student_id);
						modifyPage.getTextField_4().setText(Balence);
						modifyPage.getTextField_5().enable(false);
						Factory.refresh();
					}

				}
			});
			break;

		case "Delete":
			EventQueue.invokeLater(new Runnable() {
				

				@Override
				public void run() {

					CustomerService customerService = (CustomerService) Factory.getContext().getBean("customerService");
					int row = table.getSelectedRow();

					if (row == -1) {
						DialogService.showErrorMgs(Factory.getMainFrame(), "Please select one row", "Alert");
					} else {
						int value = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
						customerService.deleteCustomerDetail(value);
						Factory.getBodyPanal().removeAll();
						Factory.getBodyPanal().add(new StudentList());
						Factory.refresh();
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
		case "Add":
			EventQueue.invokeLater(new Runnable() {

				@Override
				public void run() {
					Factory.homePage();
					RegistrationPage registrationPage=new RegistrationPage();
					registrationPage.registrationPage(Factory.getBodyPanal());
					Factory.refresh();
				}
			});
			break;
		case "View":
			EventQueue.invokeLater(new Runnable() {

				@Override
				public void run() {
					int row = table.getSelectedRow();
					if (row == -1) {
						DialogService.showErrorMgs(Factory.getMainFrame(), "Please select one row", "Alert");
					} else {
						int value = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
						String name = table.getModel().getValueAt(row, 1).toString();
						String mobile = table.getModel().getValueAt(row, 2).toString();
						String email = table.getModel().getValueAt(row, 3).toString();
						String student_id = table.getModel().getValueAt(row, 4).toString();
						String Balence = table.getModel().getValueAt(row, 5).toString();
						Factory.getBodyPanal().removeAll();
						//Factory.getBodyPanal().add(new IssueBookPage());
						Factory.getBodyPanal().add(new StudentDetail());
						Factory.refresh();
					}
				}
			});
			break;

		default:
			break;
		}
	}
	

	
	

}
