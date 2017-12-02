package dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

import dao.BookDao;
import db.DBConfig;
import model.BookModel;

public class BookDaoImp implements BookDao {

	@Override
	public List<BookModel> getBookaList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addBook(BookModel bookModel) {
		Session session = DBConfig.sessionfactory.openSession();
		session.beginTransaction();
		Serializable id= session.save(bookModel);
		session.beginTransaction().commit();
		session.close();
		
		System.out.println("Commit done");
		if(id !=null)
			return true;
		else
			return false;
	}

	@Override
	public boolean editBook(BookModel bookModel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delteBook(BookModel bookModel) {
		// TODO Auto-generated method stub
		return false;
	}

}
