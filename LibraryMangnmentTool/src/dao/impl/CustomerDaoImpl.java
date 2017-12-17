package dao.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import common.service.Factory;
import dao.CustomerDao;
import model.CustomerModel;
import model.GetStudentModel;

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

	@SuppressWarnings({ "unchecked"})
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
	public List<GetStudentModel> viewHistory(String id){
		Session session = Factory.sessionfactory.openSession();
		Transaction tx = null;
		List<GetStudentModel> list=new ArrayList<GetStudentModel>();
		
		
	     try {
	         tx = session.beginTransaction(); 
	         Criteria c=session.createCriteria(GetStudentModel.class);  
	         c.add(Restrictions.eq("customer_id",Integer.parseInt(id)));//salary is the propertyname  
	         list=c.list();  

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

	@Override
	public List<GetStudentModel> viewAlloted(String id, String string) {
		Session session = Factory.sessionfactory.openSession();
		Transaction tx = null;
		List<GetStudentModel> list=new ArrayList<GetStudentModel>();
		
		
	     try {
	         tx = session.beginTransaction(); 
	         Criteria c=session.createCriteria(GetStudentModel.class);  
	         c.add(Restrictions.eq("customer_id",Integer.parseInt(id)));
	         c.add(Restrictions.eq("itm_status_flag",string));
	         list=c.list();  

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
	@Override
	public List<CustomerModel> getSearchStudentList(String searchBy,String value) {
		String columnName="";
		List<CustomerModel> list=new LinkedList<CustomerModel>();
		if(searchBy.equals("Name")){
			columnName="customer_name";
		}else if(searchBy.equals("Mobile")){
			columnName="customer_mobile";
		}else if(searchBy.equals("Email")){
			columnName="customer_email";
		}
		if(columnName.equals("")){
			return list;
		}
		Session seession = Factory.sessionfactory.openSession();
		seession.beginTransaction();
		Criteria c = seession.createCriteria(CustomerModel.class);
		c.add(Restrictions.eq(columnName, value));
		list = c.list();
		seession.close();
		return list;
	}

}
