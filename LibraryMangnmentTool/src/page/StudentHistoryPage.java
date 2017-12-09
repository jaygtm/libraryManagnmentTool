package page;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

import common.service.Factory;
import model.BookModel;
import model.StudentHistoryModel;
import service.BookService;
import service.CustomerService;

public class StudentHistoryPage extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTable table;
	public StudentHistoryPage() {
		setBounds(20, 79, 1099, 481);
		setBackground(Color.WHITE);
		setLayout(null);
		
		JScrollPane gridpanel = new JScrollPane();
		gridpanel.setBounds(0, 0, 1099, 450);
		gridpanel.setBackground(new Color(0,0,0,10));
			    
		table = new JTable(getRowData("1"),columnName());
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(false);
        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.LIGHT_GRAY);
        
		gridpanel.getViewport ().add(table);
		add(gridpanel);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	public String[] columnName() {
		String columnName[] = { "Book Name","Book issue date", "Book Submit date", "Charge"};
		return columnName;
	}
	
	public String[][] getRowData(String id){
		CustomerService customerService = (CustomerService) Factory.getContext().getBean("customerService");
		List<StudentHistoryModel> list = customerService.viewHistory("8");
		String rowData[][] =new String[list.size()][4]; ;
		Iterator<StudentHistoryModel> itr =  list.iterator();
		int i=0;
		while (itr.hasNext()) {
			StudentHistoryModel book = (StudentHistoryModel) itr.next();
			//System.out.println("name Book"+book.toString());
			rowData[i][0] = ""+book.getBookmodel().getBook_name();
			rowData[i][1] = ""+book.getItm_isu_dt();
			rowData[i][2] = ""+book.getItm_isu_dt();
			rowData[i][3] = ""+book.getTxn_charge();
			i++;
		}
		return rowData;
	}

}
