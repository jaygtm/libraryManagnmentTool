package common.service;




import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.LoginUserDetail;

public class Factory {
	private static  ApplicationContext context;
	public static SessionFactory sessionfactory;
	private static JFrame mainFrame;
	private static JPanel bodyPanal;
	public static final Color cancleBtnColor= new Color(255, 51, 0);
	public static final Color deleteBtnColor= new Color(178, 34, 34);
	public static final Color modifyBtnColor= new Color(51, 153, 102);
	public static final Color saveBtnColor	= new Color(51, 153, 102);
	public static final Color viewBtnColor	= new Color(51, 153, 102);
	public static final Color backBtnColor	= new Color(51, 153, 102);
	public static final Color loginBtnColor	= new Color(0, 153, 204);
	public static final Color buttonTextColor	= Color.white;
	public static LoginUserDetail loginUserDetail=null;
	//login user
	//height 35,width 135
	
	
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
		refresh();
	}
	public static Date addNextDay(String noOfDay) throws Exception{
		DateFormat sysDate= new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		 Date date = new Date();
	    String strsysDate=sysDate.format(date);
		
		SimpleDateFormat addedDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(addedDate.parse(strsysDate));
		c.add(Calendar.DATE,Integer.parseInt(noOfDay));
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date startDate = df.parse(addedDate.format(c.getTime()));
		return startDate;
	}
}
