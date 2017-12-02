package service.impl;

import java.util.List;

import dao.BookDao;
import dao.impl.BookDaoImp;
import model.BookModel;
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
		// TODO Auto-generated method stub
		return null;
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

}
