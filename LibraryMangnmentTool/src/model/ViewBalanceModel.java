package model;

public class ViewBalanceModel {
	
	String customer_name ;
	Float opening_balance;
	Float charge=0.0F;
	Float late_charge=0.0F;
	Float deposit=0.0F;
	Float widhral=0.0F;
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public Float getOpening_balance() {
		return opening_balance;
	}
	public void setOpening_balance(Float opening_balance) {
		this.opening_balance = opening_balance;
	}
	public Float getCharge() {
		return charge;
	}
	public void setCharge(Float charge) {
		this.charge = charge;
	}
	public Float getLate_charge() {
		return late_charge;
	}
	public void setLate_charge(Float late_charge) {
		this.late_charge = late_charge;
	}
	public Float getDeposit() {
		return deposit;
	}
	public void setDeposit(Float deposit) {
		this.deposit = deposit;
	}
	public Float getWidhral() {
		return widhral;
	}
	public void setWidhral(Float widhral) {
		this.widhral = widhral;
	}

	

}
