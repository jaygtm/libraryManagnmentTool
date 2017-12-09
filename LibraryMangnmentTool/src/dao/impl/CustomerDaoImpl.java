package dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import common.service.Factory;
import dao.CustomerDao;
import model.CustomerModel;
import model.StudentHistoryModel;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public boolean saveCustomerDetail(CustomerModel customerModel) {
		Session session = Factory.sessionfactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(customerModel);
		session.beginTransaction().commit();
		System.out.println("done..!");
		//if(id!=null)
			return true;
		/*else
			return true;*/
	}

	@Override
	public CustomerModel getCustomerDetail(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteCustomerDetail(int customerId) {
		Session session = Factory.sessionfactory.openSession();
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
		Session session = Factory.sessionfactory.openSession();
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
	
	@SuppressWarnings("unchecked")
	@Override
	public List<StudentHistoryModel> viewHistory(String id){
		Session session = Factory.sessionfactory.openSession();
		List<StudentHistoryModel> list=new ArrayList<>();
		session.beginTransaction();
		Criteria criteria  = session.createCriteria(StudentHistoryModel.class);
		list=criteria.add(Restrictions.eq("customer_id", 8)).list();
	    session.close(); 
	   
		return list;
		
	}
}
