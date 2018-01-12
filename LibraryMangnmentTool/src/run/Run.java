package run;


import java.awt.EventQueue;
import common.service.Factory;
import common.service.Splash;
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
			boolean statusCreate=true;
			Splash splash=new Splash();
			splash.setVisible(true);
	        Thread thrad=Thread.currentThread();
	        try {
	        	new Factory();
	        	if(FirstTimeDbConfig.getUserRoleList().isEmpty())
					 statusCreate=FirstTimeDbConfig.createMaster();
	        	thrad.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	        splash.dispose();
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
