package service.impl;

import dao.impl.CustomerDaoImpl;
import model.CustomerModel;
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

}
