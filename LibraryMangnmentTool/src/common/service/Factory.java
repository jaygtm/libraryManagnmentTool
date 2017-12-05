package common.service;




import javax.swing.JFrame;
import javax.swing.JPanel;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Factory {
	private static  ApplicationContext context;
	public static SessionFactory sessionfactory;
	private static JFrame mainFrame;
	private static JPanel bodyPanal;
	
	static {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("Spring Factory Ready...!");
		try{
			sessionfactory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
			System.out.println("HB Factory Ready...!");
		}
		catch(Exception e){
			System.out.println("Exception At HB Config");
			System.out.println(e.getMessage());
		}
	}
	
	
	
	static{
		
	}
	
	public Factory(){
		System.out.println("use factory constructor");
	}
	
	
	
	
	public static ApplicationContext getContext() {
		return context;
	}
	public static void setContext(ApplicationContext context) {
		Factory.context = context;
	}
	
	public static void refresh(){
		mainFrame.revalidate();
		mainFrame.repaint();
	}
	public static void setMainFrame(JFrame mainFrame){
		Factory.mainFrame = mainFrame;
	}
	
	public static JFrame getMainFrame(){
		return mainFrame;
	}

	public static JPanel getBodyPanal() {
		return bodyPanal;
	}
	public static void setBodyPanal(JPanel bodyPanal) {
		Factory.bodyPanal = bodyPanal;
	}
	
	
}
