package service.impl;

import java.util.List;

import dao.CustomerDao;
import model.CustomerModel;
import model.GetStudentModel;
import service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	
	private CustomerDao customerDao;
	
	public CustomerDao getCustomerDaoImpl() {
		return customerDao;
	}
	public void setCustomerDaoImpl(CustomerDao customerDaoImpl) {
		this.customerDao = customerDaoImpl;
	}
	@Override
	public boolean saveCustomerDetail(CustomerModel customerModel){
		return  customerDao.saveCustomerDetail(customerModel);
	}
	
	@Override
	public boolean deleteCustomerDetail(int customerId){
		return  customerDao.deleteCustomerDetail(customerId);
	}
	@Override
	public List<CustomerModel> getAllCustomerDetail() {
		return customerDao.getAllCustomerDetail();
	}
	
	@Override
	public List<GetStudentModel> viewHistory(String id) {
		return customerDao.viewHistory(id);
	}
	@Override
	public List<GetStudentModel> viewAlloted(String id, String string) {
		// TODO Auto-generated method stub
		return customerDao.viewAlloted(id,string);
	}
	@Override
	public List<CustomerModel> getSearchStudentList(String searchBy, String value){
		return customerDao.getSearchStudentList(searchBy, value);
	}
	@Override
	public boolean modifyDeatils(GetStudentModel model) {
		
		return customerDao.modifyDeatils(model);
	}

}
