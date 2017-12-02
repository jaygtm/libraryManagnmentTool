package model;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import db.DBConfig;

public class UserModel {

	public static void main(String[] args) {
		
		Session session = DBConfig.sessionfactory.openSession();
		LoginModel m = new LoginModel();
		m.setUser_id(2);
		m.setUser_name("admin");
		m.setUser_passwprd("1234");
		m.setUser_lastLogin(new Date());
		session.beginTransaction();
		session.save(m);
		
		session.beginTransaction().commit();
		
		System.out.println("done..!");
		
		session.beginTransaction();
		LoginModel m4 = (LoginModel) session.get(LoginModel.class, "admin");
		
		System.out.println(m4.getUser_name());
		
		
		
		
	}
}
