package common.service;




import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

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
	
	public Factory(){
		/*File errorFile = new File(getClass().getResource("..//extra//errorLog.txt").getPath());
		File logFile = new File(getClass().getResource("..//extra//Log.txt").getPath());
		try {
			if(!errorFile.exists())
				errorFile.createNewFile();
			if(!logFile.exists())
				logFile.createNewFile();
			System.setErr(new PrintStream(errorFile));
			System.setOut(new PrintStream(logFile));
			System.out.println("Error File And Log File Make Done");
		} catch ( IOException e) {
			e.printStackTrace();
		}*/
	}
	
	public static ApplicationContext getContext() {
		return context;
	}
	public static void setContext(ApplicationContext context) {
		Factory.context = context;
	}
	
	public static void refresh(){
		if(mainFrame != null){
			mainFrame.revalidate();
			mainFrame.repaint();
		}else
			System.err.println("Main Frame is null and request for refesh");
		
	}
	public static void setMainFrame(JFrame mainFrame){
		Factory.mainFrame = mainFrame;
		System.out.println("Main Frame Set Successfully..!");
	}
	
	public static JFrame getMainFrame(){
		return mainFrame;
	}

	public static JPanel getBodyPanal() {
		return bodyPanal;
	}
	public static void setBodyPanal(JPanel bodyPanal) {
		Factory.bodyPanal = bodyPanal;
		System.out.println("Body Panel Set Successfully..!");
	}
	public static void homePage(){
		if(bodyPanal != null)
			bodyPanal.removeAll();
		else
			System.err.println("Body Panel Is null");
	}
	
	
}
