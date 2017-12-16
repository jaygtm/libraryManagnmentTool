package service;

import java.util.List;

import model.CustomerModel;
import model.GetStudentModel;

public interface CustomerService {

	boolean saveCustomerDetail(CustomerModel customerModel);

	boolean deleteCustomerDetail(int customerId);
	public List<CustomerModel> getAllCustomerDetail();

	List<GetStudentModel> viewHistory(String id);

	List<GetStudentModel> viewAlloted(String id, String string);

	List<CustomerModel> getSearchStudentList(String searchBy, String value);

}
