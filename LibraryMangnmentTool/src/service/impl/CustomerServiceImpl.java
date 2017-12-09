package service.impl;

import java.util.List;

import dao.impl.CustomerDaoImpl;
import model.CustomerModel;
import model.StudentHistoryModel;
import service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	
	private CustomerDaoImpl customerDaoImpl;
	
	public CustomerDaoImpl getCustomerDaoImpl() {
		return customerDaoImpl;
	}
	public void setCustomerDaoImpl(CustomerDaoImpl customerDaoImpl) {
		this.customerDaoImpl = customerDaoImpl;
	}
	@Override
	public boolean saveCustomerDetail(CustomerModel customerModel){
		return  customerDaoImpl.saveCustomerDetail(customerModel);
	}
	
	@Override
	public boolean deleteCustomerDetail(int customerId){
		return  customerDaoImpl.deleteCustomerDetail(customerId);
	}
	@Override
	public List<CustomerModel> getAllCustomerDetail() {
		return customerDaoImpl.getAllCustomerDetail();
	}
	
	@Override
	public List<StudentHistoryModel> viewHistory(String id) {
		return customerDaoImpl.viewHistory(id);
	}

}
