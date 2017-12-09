package service;

import java.util.List;

import model.BookModel;
import model.BookTypeModel;
import model.StudentHistoryModel;

public interface BookService {
	public List<BookModel> getBookaList();
	public boolean addBook(BookModel bookModel);
	public boolean editBook(BookModel bookModel);
	public boolean delteBook(BookModel bookModel);
	
	public List<BookTypeModel> getAllBookType();
	public BookTypeModel getBookType(String name);
	public boolean deleteBookType(BookTypeModel model);
	public boolean addBookType(BookTypeModel model);
	
	public boolean issueBook(StudentHistoryModel model);
	

}
