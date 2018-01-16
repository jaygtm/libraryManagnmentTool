package service;

import java.io.Serializable;
import java.util.List;

import model.BookModel;
import model.BookTypeModel;
import model.StudentHistoryModel;

public interface BookService {
	public List<BookModel> getBookaList();
	public BookModel getBook(int bookId);
	public Serializable addBook(BookModel bookModel);
	public boolean editBook(BookModel bookModel);
	public boolean delteBook(BookModel bookModel);
	public List<BookModel> getAvailableBookList();
	public List<BookModel> getAlotedBookList();
	
	public List<BookTypeModel> getAllBookType();
	public BookTypeModel getBookType(String name);
	public boolean deleteBookType(BookTypeModel model);
	public boolean addBookType(BookTypeModel model);
	
	public boolean issueBook(List<StudentHistoryModel> model);
	List<BookModel> getSearchBookList(String searchBy, String value);
}
