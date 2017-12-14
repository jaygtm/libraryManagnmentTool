package dao;

import java.util.List;

import model.CustomerModel;
import model.GetStudentModel;
import model.StudentHistoryModel;

public interface CustomerDao {
	
	public boolean saveCustomerDetail(CustomerModel customerModel);
	public CustomerModel getCustomerDetail(int customerId);
	boolean deleteCustomerDetail(int customerId);
	public List<CustomerModel> getAllCustomerDetail();
	List<GetStudentModel> viewHistory(String id);
	List<GetStudentModel> viewAlloted(String id, String string);

}
