package dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import common.service.Factory;
import dao.UserLoginDao;
import model.TransectionHistoryModel;
import model.UserLoginModel;
import model.UserRole;

public class UserLoginDaoImpl implements UserLoginDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<UserLoginModel> getUserDetail(String userName,String password) {

		List<UserLoginModel> list=new LinkedList<UserLoginModel>();
		Session session = Factory.sessionfactory.openSession();
		try{

			session.beginTransaction();
			Criteria c = session.createCriteria(UserLoginModel.class);
			c.add(Restrictions.eq("user_name", userName));
			c.add(Restrictions.eq("user_passwprd", password));
			list = c.list();
			return list;
		}catch(Exception e){
			return list;
		}finally{
			session.close();
		}
			
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UserLoginModel> getUserDetail(String userName) {

		List<UserLoginModel> list=new LinkedList<UserLoginModel>();
		Session session = Factory.sessionfactory.openSession();
		try{
			session.beginTransaction();
			Criteria c = session.createCriteria(UserLoginModel.class);
			c.add(Restrictions.eq("user_name", userName));
			list = c.list();
			return list;
		}catch(Exception e){
			return list;
		}finally{
			session.close();
		}
			
	}

	@Override
	public boolean saveUser(UserLoginModel loginUserDetail) {
		Session session = Factory.sessionfactory.openSession();
		Transaction tx = null;
		try{
			tx=session.beginTransaction();
			session.saveOrUpdate(loginUserDetail);
			session.beginTransaction().commit();
			System.out.println("done..!");
			return true;
		}catch(Exception e){
			if(tx!=null)
				tx.rollback();
			return false;
		}finally{
			session.close();
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserLoginModel> getSearchUserList(String searchBy, String value) {
		String columnName="";
		boolean criteriaflag =true;
		List<UserLoginModel> list=new LinkedList<UserLoginModel>();
		if(searchBy.equals("Name"))
			columnName="user_name";
		else if(searchBy.equals("Mobile"))
			columnName="user_mobile";
		else{
			criteriaflag=false;
			columnName="d";
		}
		
		if(columnName.equals("")){
			return list;
		}
		Session seession = Factory.sessionfactory.openSession();
		seession.beginTransaction();
		Criteria c = seession.createCriteria(UserLoginModel.class);
		if(criteriaflag)
			c.add(Restrictions.eq(columnName, value));
		list = c.list();
		seession.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserRole> getUserRoleList() {

		Session session = Factory.sessionfactory.openSession();
		Transaction tx = null;
		List<UserRole> list=new ArrayList<UserRole>();
	     try {
	         tx = session.beginTransaction(); 
	         Criteria c=session.createCriteria(UserRole.class);  
	         list=c.list();  
	     } catch (Exception ex) {
	         if (tx != null) {
	             tx.rollback();
	         }            
	         ex.printStackTrace(System.err);
	         return list;
	     } finally {
	    	 session.close(); 
	     }
	   return list;	
	   }
	
	@Override
	public boolean deleteCustomerDetail(int value) {
		Session session = Factory.sessionfactory.openSession();
		Transaction tx = null;
		try{
			UserLoginModel deletcustomerId=(UserLoginModel) session.load(UserLoginModel.class,new Integer(value));
			tx = session.beginTransaction();
			session.delete(deletcustomerId);
	        System.out.println("UserLoginModel Object Deleted successfully.....!!");
	        tx.commit();
			return true;
		}catch(Exception e){
			if(tx!=null)
				tx.rollback();
			return false;
		}finally{
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TransectionHistoryModel> getTxnhistoryList(Date fromDate, Date toDate) {
		List<TransectionHistoryModel> transectionHistoryObject=new ArrayList();
		Session session = Factory.sessionfactory.openSession();
		Transaction tx = null;
		try{
			tx=session.beginTransaction();
			Criteria c=session.createCriteria(TransectionHistoryModel.class); 
			//c.add(Restrictions.between("txn_date", fromDate, toDate));
			c.add(Restrictions.ge("txn_date", Factory.getNextDate(fromDate))); 
			c.add(Restrictions.lt("txn_date", toDate));
			System.out.println(fromDate+"   "+Factory.getNextDate(toDate));
			transectionHistoryObject=c.list();  
		/*transectionHistoryObject = session.createSQLQuery("select idtxn_amount_his,txn_amount_his.submited_by,mst_customer.customer_name"
								+ " ,txn_amount_his.Recived_by,mst_user.user_name,txn_amount_his.txn_date ,"
								+ " txn_amount_his.txn_type, txn_amount_his.amount  "
								+ " from txn_amount_his"
								+ " inner join mst_customer on mst_customer.customer_id=txn_amount_his.submited_by "
								+ " inner join mst_user on mst_user.user_id=txn_amount_his.Recived_by "
								+ " where (txn_amount_his.txn_date BETWEEN '"+fromDate+"'AND '"+toDate+"') ").list();*/
			return transectionHistoryObject;
		}catch(Exception e){
			e.printStackTrace();
			return transectionHistoryObject;
		}finally{
			session.close();
		}
	}
}
