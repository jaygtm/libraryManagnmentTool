package run;


import newobject.UseFactory;
import page.DashboardPage;

public class Run {

	public static void main(String[] args) {
		UseFactory.getContext().getBean("MainFrame");
		
		//new DashboardPage("Library");
		
	}

}
