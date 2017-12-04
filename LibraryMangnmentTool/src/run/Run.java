package run;


import java.awt.EventQueue;

import db.DBConfig;
import newobject.UseFactory;
import page.DashboardPage;

public class Run {

	public static void main(String[] args) {
		UseFactory factory =  new UseFactory();
		new DBConfig();
		
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new DashboardPage("LibraryManagnmentTool");
			}
		});
	}

}

/*
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
public class Run extends JFrame
{
    public Run()
    {
        //headers for the table
        String[] columns = new String[] {
            "Id", "Name", "Hourly Rate", "Part Time"
        };
         
        //actual data for the table in a 2d array
        Object[][] data = new Object[][] {
            {1, "John", 40.0, false },
            {2, "Rambo", 70.0, false },
            {3, "Zorro", 60.0, true },
        };
        //create table with data
        JTable table = new JTable(data, columns);
         
        //add the table to the frame
        this.add(new JScrollPane(table));
         
        this.setTitle("Table Example");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        this.pack();
        this.setVisible(true);
    }
     
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Run();
            }
        });
    }   
}*/