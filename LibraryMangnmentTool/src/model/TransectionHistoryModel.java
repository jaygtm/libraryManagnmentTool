package model;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="txn_amount_his")
public class TransectionHistoryModel {
	@Id@GeneratedValue
	private int idtxn_amount_his;
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="submited_by")
	private CustomerModel customerModel;
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="Recived_by")
	private UserModel userModel;
	private Date txn_date ;
	private String txn_type;
	private Double amount;
	
	public CustomerModel getCustomerModel() {
		return customerModel;
	}
	public void setCustomerModel(CustomerModel customerModel) {
		this.customerModel = customerModel;
	}
	
	public UserModel getUserModel() {
		return userModel;
	}
	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
	public int getIdtxn_amount_his() {
		return idtxn_amount_his;
	}
	public void setIdtxn_amount_his(int idtxn_amount_his) {
		this.idtxn_amount_his = idtxn_amount_his;
	}
	
	public Date getTxn_date() {
		return txn_date;
	}
	public void setTxn_date(Date txn_date) {
		this.txn_date = txn_date;
	}
	public String getTxn_type() {
		return txn_type;
	}
	public void setTxn_type(String txn_type) {
		this.txn_type = txn_type;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	 
}
