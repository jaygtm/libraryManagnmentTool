package db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import model.UserModel;

public class DBConfig {
	
	public static SessionFactory sessionfactory;
	
	static{
		try{
		sessionfactory = new AnnotationConfiguration().configure().buildSessionFactory();
			
		}
		catch(Exception e){
			System.out.println("Exception");
			System.out.println(e.getMessage());
		}
	}
	
	public boolean saveUserDetail(UserModel userModel){
		return true;
	}	
}
