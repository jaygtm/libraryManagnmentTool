package service;

import java.util.List;

import model.CustomerModel;
import model.StudentHistoryModel;

public interface CustomerService {

	boolean saveCustomerDetail(CustomerModel customerModel);

	boolean deleteCustomerDetail(int customerId);
	public List<CustomerModel> getAllCustomerDetail();

	List<StudentHistoryModel> viewHistory(String id);

}
