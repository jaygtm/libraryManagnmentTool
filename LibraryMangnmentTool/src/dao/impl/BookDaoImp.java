package dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

import common.service.Factory;
import dao.BookDao;
import model.BookModel;
import model.BookTypeModel;
import model.StudentHistoryModel;

public class BookDaoImp implements BookDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<BookModel> getBookaList() {
		Session seession = Factory.sessionfactory.openSession();
		seession.beginTransaction();
		List<BookModel> list = seession.createCriteria(BookModel.class).list();
		seession.close();
		return list;
	}

	@Override
	public boolean addBook(BookModel bookModel) {
		Session session = Factory.sessionfactory.openSession();
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

	@SuppressWarnings("unchecked")
	@Override
	public List<BookTypeModel> getAllBookType() {
		Session seession = Factory.sessionfactory.openSession();
		seession.beginTransaction();
		List<BookTypeModel> list = seession.createCriteria(BookTypeModel.class).list();
		seession.close();
		return list;
	}

	@Override
	public BookTypeModel getBookType(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteBookType(BookTypeModel model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addBookType(BookTypeModel model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean issueBook(StudentHistoryModel model) {
		Session session = Factory.sessionfactory.openSession();
		session.beginTransaction();
		Serializable id= session.save(model);
		session.beginTransaction().commit();
		session.close();
		
		System.out.println("Issue Book Commit is done");
		if(id !=null)
			return true;
		else
			return false;
	}

}
