package run;


import java.awt.EventQueue;

import common.service.Factory;
import page.DashboardPage;

public class Run {

	public static void main(String[] args) {
		Factory factory =  new Factory();
		
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new DashboardPage("LibraryManagnmentTool");
			}
		});
	}

}
