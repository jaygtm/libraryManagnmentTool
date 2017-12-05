package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mst_booktype")
public class BookTypeModel {
	@Id@GeneratedValue
	int bookType_id;
	String bookType_code;
	public int getBookType_id() {
		return bookType_id;
	}
	public void setBookType_id(int bookType_id) {
		this.bookType_id = bookType_id;
	}
	public String getBookType_code() {
		return bookType_code;
	}
	public void setBookType_code(String bookType_code) {
		this.bookType_code = bookType_code;
	}
	
	
}
