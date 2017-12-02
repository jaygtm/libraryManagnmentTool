package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mst_customer")

public class CustomerModel {

	@Id
	@GeneratedValue
	private int customer_id;
	@Column
	private String customer_name;
	@Column
	private String customer_mobile;
	@Column
	private String customer_email;
	@Column
	private String customer_cId;
	@Column
	private double customer_balance;
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getCustomer_mobile() {
		return customer_mobile;
	}
	public void setCustomer_mobile(String customer_mobile) {
		this.customer_mobile = customer_mobile;
	}
	public String getCustomer_email() {
		return customer_email;
	}
	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}
	public String getCustomer_cId() {
		return customer_cId;
	}
	public void setCustomer_cId(String customer_cId) {
		this.customer_cId = customer_cId;
	}
	public double getCustomer_balance() {
		return customer_balance;
	}
	public void setCustomer_balance(double customer_balance) {
		this.customer_balance = customer_balance;
	}
}
