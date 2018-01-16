package service.impl;

import java.io.Serializable;
import java.util.List;

import dao.BookDao;
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
	public Serializable addBook(BookModel bookModel) {
		return bookDao.addBook(bookModel);
	}

	@Override
	public boolean editBook(BookModel bookModel) {
		return bookDao.editBook(bookModel);
	}

	@Override
	public boolean delteBook(BookModel bookModel) {
		return bookDao.delteBook(bookModel);
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
	public boolean issueBook(List<StudentHistoryModel> model) {
		return bookDao.issueBook(model);
	}

	@Override
	public List<BookModel> getAvailableBookList() {
		return bookDao.getAvailableBookList();
	}

	@Override
	public List<BookModel> getAlotedBookList() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<BookModel> getSearchBookList(String searchBy,String value){
		return bookDao.getSearchBookList(searchBy, value);
	}

	@Override
	public BookModel getBook(int bookId) {
		return bookDao.getBook(bookId);
	}
}
