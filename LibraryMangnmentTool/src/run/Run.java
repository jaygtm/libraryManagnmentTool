package run;


import java.awt.EventQueue;
import common.service.Factory;
import page.DashboardPage;
import page.FirstTimeDbConfig;

public class Run {

	public static void main(String[] args) {
		Factory.setLogFile();
	
		Boolean firstTime = Factory.getFirstTimeDetails();
		if (firstTime == true) {
			// Its First time then
			EventQueue.invokeLater(new Runnable() {
				@Override
				public void run() {
					new DashboardPage("LibraryManagnmentTool", "newUser");
				}
			});
		} else {
			new Factory();
			boolean statusCreate=true;
			if(FirstTimeDbConfig.getUserRoleList().isEmpty())
				 statusCreate=FirstTimeDbConfig.createMaster();
			if(statusCreate)
			EventQueue.invokeLater(new Runnable() {
				@Override
				public void run() {
					new DashboardPage("LibraryManagnmentTool", "");
				}
			});
		}
	}

}
