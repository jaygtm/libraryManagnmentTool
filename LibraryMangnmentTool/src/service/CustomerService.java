package service;

import java.util.List;

import model.CustomerModel;

public interface CustomerService {

	boolean saveCustomerDetail(CustomerModel customerModel);

	boolean deleteCustomerDetail(int customerId);
	public List<CustomerModel> getAllCustomerDetail();

}
