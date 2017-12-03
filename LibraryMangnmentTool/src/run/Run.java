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
