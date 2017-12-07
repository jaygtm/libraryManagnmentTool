package page;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JPanel;

import common.service.Factory;
import model.BookModel;
import service.BookService;

public class StudentHistoryPage extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	public StudentHistoryPage() {
		setBounds(20, 79, 1099, 481);
		setBackground(Color.WHITE);
		setLayout(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	public String[] columnName() {
		String columnName[] = { "Book_Name","Book issue date", "Book Submit date", "Charge", "Book Rant per day", "Book Authour","publication","Available","Total"};
		return columnName;
	}
	
	public String[][] getRowData(){
		BookService bookService = (BookService) Factory.getContext().getBean("bookService");
		List<BookModel> list = bookService.getBookaList();
		String rowData[][] =new String[list.size()][9]; ;
		Iterator<BookModel> itr =  list.iterator();
		int i=0;
		while (itr.hasNext()) {
			BookModel book = (BookModel) itr.next();
			System.out.println("name Book"+book.getBook_name());
			rowData[i][0] = ""+book.getBook_id();
			rowData[i][1] = ""+book.getBook_name();
			rowData[i][2] = ""+book.getBook_mrp();
			rowData[i][3] = ""+book.getBook_rent();
			rowData[i][4] = ""+book.getBook_rentPerDay();
			rowData[i][5] = ""+book.getBook_aurthor();
			rowData[i][6] = ""+book.getBook_publication();
			rowData[i][7] = ""+book.getBook_aval();
			rowData[i][8] = ""+book.getBook_Total();
			i++;
		}
		return rowData;
	}

}
