package dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
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

	@SuppressWarnings({ "unchecked",  "null" })
	@Override
	public List<CustomerModel> getAllCustomerDetail() {
		Session session = DBConfig.sessionfactory.openSession();
		Transaction tx = null;
		List<CustomerModel> list=new ArrayList<CustomerModel>();
		
		
	     try {
	         tx = session.beginTransaction();        
	         list = session.createCriteria(CustomerModel.class).list();
	         tx.commit();

	     } catch (HibernateException ex) {
	         if (tx != null) {
	             tx.rollback();
	         }            
	         ex.printStackTrace(System.err);
	     } finally {
	    	 session.close(); 
	     }
		return list;
	}
}
