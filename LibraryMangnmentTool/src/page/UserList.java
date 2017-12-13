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
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;

import common.service.DialogService;
import common.service.Factory;
import model.BookModel;
import model.CustomerModel;
import model.LoginUserDetail;
import model.UserModel;
import service.BookService;
import service.CustomerService;
import service.UserLoginService;

public class UserList extends JPanel implements ActionListener {
	
	
	JTable table;
	JTextField textField;
	@SuppressWarnings("rawtypes")
	JComboBox comboBox;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public UserList() {
		
		setBounds(10, 11, 1129, 571);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User List");
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
		scrollBar.setBounds(10, 75, 1109, 420);
		add(scrollBar);
		
		table = new JTable(getRowData(),columnName());
		table.setBounds(163, 235, 1, 1);
		scrollBar.getViewport ().add(table);
		
		JButton btnNewButton_8 = new JButton("Add");
		btnNewButton_8.setBounds(10, 514, 109, 34);
		btnNewButton_8.addActionListener(this);
		add(btnNewButton_8);
		
		JButton btnNewButton_12 = new JButton("View");
		btnNewButton_12.setBounds(632, 514, 109, 34);
		btnNewButton_12.setBackground(Factory.viewBtnColor);
		btnNewButton_12.addActionListener(this);
		add(btnNewButton_12);
		
		JButton btnNewButton_9 = new JButton("Modify");
		btnNewButton_9.setBackground(Factory.modifyBtnColor);
		btnNewButton_9.setBounds(750, 514, 109, 34);
		btnNewButton_9.addActionListener(this);
		add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("Delete");
		btnNewButton_10.setBackground(Factory.deleteBtnColor);
		btnNewButton_10.setBounds(865, 514, 109, 34);
		btnNewButton_10.addActionListener(this);
		add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("Cancel");
		btnNewButton_11.setBackground(Factory.cancleBtnColor);
		btnNewButton_11.setBounds(979, 514, 109, 34);
		btnNewButton_11.addActionListener(this);
		add(btnNewButton_11);
		
	}
	
	public String[] columnName() {
		String columnName[] = {"User Name", "User Mobile", "Addhar/Id No.", "User Address", "User Role","User UserId"};
		return columnName;
	}
	
	
	public String[][] getRowData(){
		UserLoginService userLoginService = (UserLoginService) Factory.getContext().getBean("loginService");
		List<LoginUserDetail> list = userLoginService.getAllUser();
		String rowData[][] =new String[list.size()][columnName().length]; ;
		Iterator<LoginUserDetail> itr =  list.iterator();
		int i=0;
		while (itr.hasNext()) {
			LoginUserDetail loginUserDetail = (LoginUserDetail) itr.next();
			rowData[i][0] = ""+loginUserDetail.getUser_name();
			rowData[i][1] = loginUserDetail.getUser_mobile();
			rowData[i][2] = loginUserDetail.getUser_idNo();
			rowData[i][3] = loginUserDetail.getUser_addr();
			rowData[i][4] = loginUserDetail.getUsrRole().getRole_name();
			rowData[i][5] = ""+loginUserDetail.getIdPass().getUser_name();
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
						Factory.getBodyPanal().add(new UserList());
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
						StudentDetail studentDeatil  =  new StudentDetail();
						studentDeatil.setStudentNameAndId(name, student_id, value+"");
						Factory.getBodyPanal().add(studentDeatil);
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
