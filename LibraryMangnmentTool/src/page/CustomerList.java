package page;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

import common.service.DialogService;
import model.CustomerModel;
import newobject.UseFactory;
import service.CustomerService;

public class CustomerList  implements ActionListener{
	
	private JPanel gridpanel;
	private JPanel parent;
	private JTable table;
	public void customerList(JPanel panel_1,List<CustomerModel> status){

		this.parent = panel_1;
		JPanel List_panel = new JPanel();
		List_panel.setBounds(177, 25, 867, 538);
		List_panel.setBackground(new Color(0,0,0,0));
		List_panel.setBorder(BorderFactory.createTitledBorder(""));
		List_panel.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 26));
		panel_1.add(List_panel);
		List_panel.setLayout(null);
		
		JLabel lblStudentList = new JLabel("Student List");
		lblStudentList.setBounds(316, 11, 214, 32);
		lblStudentList.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 26));
		List_panel.add(lblStudentList);
		
		JScrollPane gridpanel = new JScrollPane();
		gridpanel.setBounds(30, 73, 810, 390);
		gridpanel.setBackground(new Color(0,0,0,10));
			    
		table = new JTable(getRowData(status),columnName());
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(false);
        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.LIGHT_GRAY);
        
		gridpanel.getViewport ().add(table);
		List_panel.add(gridpanel);
		List_panel.setVisible(true);
				
		JButton btnModifyDetail = new JButton("Modify Detail");
		btnModifyDetail.setBackground(new Color(0, 204, 0));
		btnModifyDetail.setBounds(449, 495, 138, 32);
		btnModifyDetail.addActionListener(this);
		List_panel.add(btnModifyDetail);
		
		JButton btnDeleteDetail = new JButton("Delete Detail");
		btnDeleteDetail.setBackground(new Color(204, 51, 51));
		btnDeleteDetail.setBounds(589, 495, 125, 32);
		btnDeleteDetail.addActionListener(this);
		List_panel.add(btnDeleteDetail);
		
		JButton btnNewButton_6 = new JButton("Cancel");
		btnNewButton_6.setBackground(new Color(204, 51, 51));
		btnNewButton_6.setBounds(716, 495, 124, 32);
		btnNewButton_6.addActionListener(this);
		List_panel.add(btnNewButton_6);
		
		gridpanel.repaint();

		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand().trim();
		System.out.println(""+action);
		switch (action) {
		case "Modify Detail":EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
					CustomerService customerService = (CustomerService) UseFactory.getContext().getBean("customerService");
			}
		});
			break;
			
		case "Delete Detail":EventQueue.invokeLater(new Runnable() {
			JPanel d= parent;
			@Override
			public void run() {
				
					CustomerService customerService = (CustomerService) UseFactory.getContext().getBean("customerService");
					int row = table.getSelectedRow();
					
					if(row==-1){
						DialogService.showErrorMgs(d, "Please select one row", "Alert");
					}else{
						int value = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
						customerService.deleteCustomerDetail(value);
						parent.removeAll();
						List<CustomerModel> status = customerService.getAllCustomerDetail();
						customerList(parent,status);
					}
			}
		});
			break;
		case "Cancel":EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
					parent.removeAll();
			}
		});
			break;

		default:
			break;
		}
		UseFactory.refresh();
	}
	public String[] columnName() {
		String columnName[] = { "Library Id No","Student Name", "Student Mobile", "Student email", "Student Id", "Student Balance"};
		return columnName;
	}
	
	public String[][] getRowData(List<CustomerModel> list){
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

}
