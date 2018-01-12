package common.service;




import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.UserLoginModel;

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
	public static UserLoginModel UserLoginModel=null;
	public static boolean lockModeOn=false;
	
	{
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("Spring Factory Ready...!");
		try{
			sessionfactory=HibernateUtil.buildSessionFactory();
			if(sessionfactory==null)
	        	DialogService.showErrorMgs(Factory.getMainFrame(), "Connection not opening with database check LAN connection!!!!", "Error");
			//sessionfactory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
			System.out.println("HB Factory Ready...!");
			
		}
		catch(Exception e){
			System.out.println("Exception At HB Config");
			System.out.println(e.getMessage());
		}
	}
	
	public Factory(){
		
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
	
	public static long dateDifference(Date toDate,Date fromDate) {
	    long daysBetween = 0;
	    try {
	        long diff = fromDate.getTime() - toDate.getTime();
	        daysBetween = (TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	   return daysBetween;
	}
	
	public static  void exportDataInExcel(String[] columnName,String[][] data,String sheetName,String fileName ){
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setSelectedFile(new File(fileName+".xlsx"));
		if(fileChooser.showSaveDialog(Factory.getMainFrame()) == JFileChooser.APPROVE_OPTION){
			File file = fileChooser.getSelectedFile();
			
			XSSFWorkbook workbook = new XSSFWorkbook();
	        XSSFSheet sheet = workbook.createSheet(sheetName);
	        
	        
	        
	        Row row_c = sheet.createRow(0);
	        CellStyle style = workbook.createCellStyle();
	        style.setFillBackgroundColor(IndexedColors.AQUA.getIndex());
	        row_c.setRowStyle(style);
            int colNum = 0;
            for (String field : columnName) {
                Cell cell = row_c.createCell(colNum++);
                cell.setCellValue(field);
            }
	        
	        
	        
	        int rowNum = 1;
	        System.out.println("Creating excel");

	        for (String[] rowData : data) {
	            Row row = sheet.createRow(rowNum++);
	            colNum = 0;
	            for (String field : rowData) {
	                Cell cell = row.createCell(colNum++);
	                cell.setCellValue(field);
	            }
	        }

	        try {
	            FileOutputStream outputStream = new FileOutputStream(file);
	            workbook.write(outputStream);
	            DialogService.showMgs(mainFrame, "Your File Export Successfully..!", "Export");
	            workbook.close();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	            DialogService.showErrorMgs(mainFrame, "Error to Export ..!", "Export");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
		
		
		
	}
	
		public static boolean validateNumber(String number){
		
		try{
			Double.parseDouble(number);
			return true;
		}catch(Exception e){
			e.getMessage();
			return false;
		}
		
	}	
	
		public static boolean WriteProperties(String userType,String ipAddress,String port) {
			File f=null;
			try {
				Properties properties=new Properties();
				if(userType.equals("Admin"))
					properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/librartmanagement?createDatabaseIfNotExist=true");
				else
					properties.setProperty("hibernate.connection.url", "jdbc:mysql://"+ipAddress+":"+port+"/librartmanagement");
				properties.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
				properties.setProperty("hibernate.connection.username", "root");
				properties.setProperty("hibernate.connection.password", "root");
				
				
				File folder = new File("config"+File.separator+"db");
				if(!folder.exists())
					folder.mkdirs();
				File hbProperty = new File("config"+File.separator+"db"+File.separator+"hibernate.properties");
				if(!hbProperty.exists())
					hbProperty.createNewFile();
				
				FileOutputStream out = new FileOutputStream(hbProperty);
					
				properties.store(out, "Dynamic Connection");
				out.close();
					
				
				
				return true;
			} catch (FileNotFoundException e) {
				if(f!=null)
					f.delete();
				e.printStackTrace();
				return false;
			} catch (IOException e) {
				if(f!=null)
					f.delete();
				e.printStackTrace();
				return false;
			}
		}
		public static boolean getFirstTimeDetails(){
			File current = new File("config");
			System.out.println(current.getAbsolutePath());
			
			File hbProperty = new File("config"+File.separator+"db"+File.separator+"hibernate.properties");
			if(hbProperty.exists()){
					return false;
			}else
				return true;
		}
		public static boolean setLogFile(){
			File current = new File("config"+File.separator+"log");
			System.out.println(current.getAbsolutePath());
			try{
				File log = new File("config"+File.separator+"log"+File.separator+"log.txt");
				File error = new File("config"+File.separator+"log"+File.separator+"logErrorlog.txt");
				if(!current.exists()){
					current.mkdirs();
					error.createNewFile();
					log.createNewFile();
				}else{
					if(!log.exists())
						log.createNewFile();
					if(!error.exists())
						error.createNewFile();
				}
				FileOutputStream outLog = new FileOutputStream(log);
				FileOutputStream outErrorLog = new FileOutputStream(error);
				System.setOut(new PrintStream(outLog));
				System.setErr(new PrintStream(outErrorLog));
			}catch(IOException e){
				e.printStackTrace();
			}
			return true;
		}	
		
		
	
	
}
