package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mst_book")
public class BookModel {

	@Id@GeneratedValue
	private int book_id; 
	private String book_name;
	private int book_typeId;
	private int  book_mrp;
	private int  book_rent;
	private int book_rentPerDay;
	private String book_aurthor;
	private String book_publication;
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public int getBook_typeId() {
		return book_typeId;
	}
	public void setBook_typeId(int book_typeId) {
		this.book_typeId = book_typeId;
	}
	public int getBook_mrp() {
		return book_mrp;
	}
	public void setBook_mrp(int book_mrp) {
		this.book_mrp = book_mrp;
	}
	public int getBook_rent() {
		return book_rent;
	}
	public void setBook_rent(int book_rent) {
		this.book_rent = book_rent;
	}
	public int getBook_rentPerDay() {
		return book_rentPerDay;
	}
	public void setBook_rentPerDay(int book_rentPerDay) {
		this.book_rentPerDay = book_rentPerDay;
	}
	public String getBook_aurthor() {
		return book_aurthor;
	}
	public void setBook_aurthor(String book_aurthor) {
		this.book_aurthor = book_aurthor;
	}
	public String getBook_publication() {
		return book_publication;
	}
	public void setBook_publication(String book_publication) {
		this.book_publication = book_publication;
	}
	public int getBook_Total() {
		return book_Total;
	}
	public void setBook_Total(int book_Total) {
		this.book_Total = book_Total;
	}
	public int getBook_aval() {
		return book_aval;
	}
	public void setBook_aval(int book_aval) {
		this.book_aval = book_aval;
	}
	private int book_Total; 
	private int book_aval;
	
	
}
