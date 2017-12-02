package service;

import model.CustomerModel;

public interface CustomerService {

	boolean saveCustomerDetail(CustomerModel customerModel);

	boolean deleteCustomerDetail(int customerId);

}
