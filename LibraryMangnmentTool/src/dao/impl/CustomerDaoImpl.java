package dao.impl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.CustomerDao;
import db.DBConfig;
import model.CustomerModel;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public boolean saveCustomerDetail(CustomerModel customerModel) {
		Session session = DBConfig.sessionfactory.openSession();
		session.beginTransaction();
		Serializable id=session.save(customerModel);
		session.beginTransaction().commit();
		System.out.println("done..!");
		if(id!=null)
			return true;
		else
			return true;
	}

	@Override
	public CustomerModel getCustomerDetail(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteCustomerDetail(int customerId) {
		Session session = DBConfig.sessionfactory.openSession();
		CustomerModel deletcustomerId=(CustomerModel) session.load(CustomerModel.class,new Integer(customerId));
		Transaction tx = session.beginTransaction();
		session.delete(deletcustomerId);
        System.out.println("Object Deleted successfully.....!!");
        tx.commit();
        session.close();
		return true;
	}
}
