package newobject;




import javax.swing.JFrame;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseFactory {
	private static  ApplicationContext context;
	private static JFrame mainFrame;
	public UseFactory(){
		System.out.println("use factory constructor");
	}
	static {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	public static ApplicationContext getContext() {
		return context;
	}
	public static void setContext(ApplicationContext context) {
		UseFactory.context = context;
	}
	
	public static void refresh(){
		mainFrame.revalidate();
		mainFrame.repaint();
	}
	public static void setMainFrame(JFrame mainFrame){
		UseFactory.mainFrame = mainFrame;
	}
	
	public static JFrame getMainFrame(){
		return mainFrame;
	}
	
	
}
