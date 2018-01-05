package common.service;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

private static final SessionFactory sessionFactory = buildSessionFactory();

private static SessionFactory buildSessionFactory() {
    try {

        Properties dbConnectionProperties = new Properties();
        try {
            dbConnectionProperties.load(HibernateUtil.class.getClassLoader().getSystemClassLoader().getResourceAsStream("hibernate.properties"));
        } catch(Exception e) {
            e.printStackTrace();
        }           

        return new AnnotationConfiguration().mergeProperties(dbConnectionProperties).configure("hibernate.cfg.xml").buildSessionFactory();          


    } catch (Throwable ex) {
        ex.printStackTrace();
    }
    return null;
}

public static SessionFactory getSessionFactory() {
    return sessionFactory;
}

}