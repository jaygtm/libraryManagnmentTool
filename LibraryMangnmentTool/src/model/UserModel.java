package model;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import db.DBConfig;
import newobject.UseFactory;
import service.BookService;
import service.impl.BookServiceImp;

public class UserModel {

	public static void main(String[] args) {
		
		/*BookService bookService = new BookServiceImp();
		BookModel book 	= new BookModel();*/
		BookService bookService = (BookService) UseFactory.getContext().getBean("bookService");
		BookModel book 	= (BookModel)UseFactory.getContext().getBean("bookModel");
		
		book.setBook_name("modren physics");
		book.setBook_aurthor("Jai Ram");
		book.setBook_mrp(350);
		book.setBook_publication("N.k");
		book.setBook_rent(30);
		book.setBook_rentPerDay(30);
		book.setBook_Total(1);
		book.setBook_aval(1);
		book.setBook_typeId(1);
		
		bookService.addBook(book);
		
		
		
		
	}
}
