package dao.impl;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

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
		Session session = Factory.sessionfactory.openSession();
		try{
			session.beginTransaction();
			session.update(bookModel);
			session.beginTransaction().commit();
			return true;
		}catch(HibernateException e){
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}
	}

	@Override
	public boolean delteBook(BookModel bookModel) {
		Session session = Factory.sessionfactory.openSession();
		BookModel deletbook=(BookModel) session.load(BookModel.class,new Integer(bookModel.getBook_id()));
		Transaction tx = session.beginTransaction();
		session.delete(deletbook);
        System.out.println("Object Deleted successfully.....!!");
        tx.commit();
        session.close();
		
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
	public boolean issueBook(List<StudentHistoryModel> model) {
		for(StudentHistoryModel m :model){
			Session session = Factory.sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			try{
				session.save(m);
				tx.commit();
				System.out.println("Issue Book Commit is done");
				
			}catch(Exception e){
				e.printStackTrace();
				tx.rollback();
				return false;
			}finally{
				session.close();
			}
		}
		return true;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BookModel> getAvailableBookList() {
		Session seession = Factory.sessionfactory.openSession();
		seession.beginTransaction();
		Criteria c = seession.createCriteria(BookModel.class);
		c.add(Restrictions.gt("book_aval", 0));
		List<BookModel> list = c.list();
		seession.close();
		return list;
	}

	@Override
	public List<BookModel> getAlotedBookList() {
		Session seession = Factory.sessionfactory.openSession();
		seession.beginTransaction();
		Criteria c = seession.createCriteria(BookModel.class);
		c.add(Restrictions.gt("book_aval", 0));
		List<BookModel> list = c.list();
		seession.close();
		return list;
	}
	
	@Override
	public List<BookModel> getSearchBookList(String searchBy,String value) {
		String columnName="";
		List<BookModel> list=new LinkedList<BookModel>();
		if(searchBy.equals("Name")){
			columnName="book_name";
		}else if(searchBy.equals("Aurther")){
			columnName="book_aurthor";
		}else if(searchBy.equals("Publication")){
			columnName="book_publication";
		}
		if(columnName.equals("")){
			return list;
		}
		Session seession = Factory.sessionfactory.openSession();
		seession.beginTransaction();
		Criteria c = seession.createCriteria(BookModel.class);
		c.add(Restrictions.gt(columnName, value));
		list = c.list();
		seession.close();
		return list;
	}

}
