package dao;

import java.util.List;

import model.CustomerModel;

public interface CustomerDao {
	
	public boolean saveCustomerDetail(CustomerModel customerModel);
	public CustomerModel getCustomerDetail(int customerId);
	boolean deleteCustomerDetail(int customerId);
	public List<CustomerModel> getAllCustomerDetail();

}
