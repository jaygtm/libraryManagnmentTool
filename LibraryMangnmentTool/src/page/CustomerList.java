package page;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import newobject.UseFactory;
import service.CustomerService;

public class CustomerList  implements ActionListener{
	
	private JPanel gridpanel;
	private JPanel parent;
	public void customerList(JPanel panel_1,JTable table){

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
		gridpanel.setBounds(30, 73, 810, 435);
		gridpanel.setBackground(new Color(0,0,0,10));
			    
		gridpanel.getViewport ().add(table);
		List_panel.add(gridpanel);
		List_panel.setVisible(true);
		gridpanel.repaint();

		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand().trim();
		System.out.println(""+action);
		switch (action) {
		case "Save":EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
					CustomerService customerService = (CustomerService) UseFactory.getContext().getBean("customerService");
					
			
			}
		});
			break;

		default:
			break;
		}
		
	}
}
