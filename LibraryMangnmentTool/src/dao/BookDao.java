package dao;

import java.util.List;

import model.BookModel;

public interface BookDao {
	public List<BookModel> getBookaList();
	public boolean addBook(BookModel bookModel);
	public boolean editBook(BookModel bookModel);
	public boolean delteBook(BookModel bookModel);

}
