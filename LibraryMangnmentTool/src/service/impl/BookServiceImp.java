package service.impl;

import java.util.List;

import dao.BookDao;
import dao.impl.BookDaoImp;
import model.BookModel;
import model.BookTypeModel;
import model.StudentHistoryModel;
import service.BookService;

public class BookServiceImp implements BookService {
	
	private BookDao bookDao ;
	

	public BookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public List<BookModel> getBookaList() {
		return bookDao.getBookaList();
	}

	@Override
	public boolean addBook(BookModel bookModel) {
		return bookDao.addBook(bookModel);
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

	@Override
	public List<BookTypeModel> getAllBookType() {
		return bookDao.getAllBookType();
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
		return bookDao.issueBook(model);
	}

}
