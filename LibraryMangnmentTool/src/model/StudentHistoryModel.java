package model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="txn_item_his")
public class StudentHistoryModel {
	@Id
	private int itm_his_id;
	private int  book_id;
	private int customer_id;
	private Date itm_isu_dt;
	private Date itm_sub_dt;
	private String itm_status_flag;
	private Double txn_charge;
		
	public int getItm_his_id() {
		return itm_his_id;
	}
	public void setItm_his_id(int itm_his_id) {
		this.itm_his_id = itm_his_id;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public Date getItm_isu_dt() {
		return itm_isu_dt;
	}
	public void setItm_isu_dt(Date itm_isu_dt) {
		this.itm_isu_dt = itm_isu_dt;
	}
	public Date getItm_sub_dt() {
		return itm_sub_dt;
	}
	public void setItm_sub_dt(Date itm_sub_dt) {
		this.itm_sub_dt = itm_sub_dt;
	}
	public String getItm_status_flag() {
		return itm_status_flag;
	}
	public void setItm_status_flag(String itm_status_flag) {
		this.itm_status_flag = itm_status_flag;
	}
	public Double getTxn_charge() {
		return txn_charge;
	}
	public void setTxn_charge(Double txn_charge) {
		this.txn_charge = txn_charge;
	}
	
}
