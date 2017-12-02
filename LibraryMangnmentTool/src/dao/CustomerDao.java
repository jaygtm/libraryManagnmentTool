package dao;

import model.CustomerModel;

public interface CustomerDao {
	
	public boolean saveCustomerDetail(CustomerModel customerModel);
	public CustomerModel getCustomerDetail(int customerId);

}
