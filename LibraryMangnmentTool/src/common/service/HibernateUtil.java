package common.service;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

private static SessionFactory sessionFactory =null;

public static SessionFactory buildSessionFactory() {
    try {

        Properties dbConnectionProperties = new Properties();
        try {
           // dbConnectionProperties.load(HibernateUtil.class.getClassLoader().getSystemClassLoader().getResourceAsStream("hibernate.properties"));
        	File hbProperty = new File("config"+File.separator+"db"+File.separator+"hibernate.properties");
        	FileInputStream in = new FileInputStream(hbProperty);
            dbConnectionProperties.load(in);
        } catch(Exception e) {
            e.printStackTrace();
            DialogService.showErrorMgs(Factory.getMainFrame(), "Configuration file not loading please try again!!!!", "Error");
        }           
        sessionFactory=new AnnotationConfiguration().mergeProperties(dbConnectionProperties).configure("hibernate.cfg.xml").buildSessionFactory();
        return sessionFactory;          


    } catch (Throwable ex) {
        ex.printStackTrace();
        if(sessionFactory==null)
        	DialogService.showErrorMgs(Factory.getMainFrame(), "Connection not opening with database check LAN connection!!!!", "Error");

    }
    return null;
}

public static SessionFactory getSessionFactory() {
    return sessionFactory;
}

}