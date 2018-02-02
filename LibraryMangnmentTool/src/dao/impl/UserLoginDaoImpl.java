package dao.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import common.service.Factory;
import dao.UserLoginDao;
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
		Criteria c = seession.createCriteria(UserLoginModel.class)
					.createAlias("user.role", "role", Criteria.INNER_JOIN);
		if(criteriaflag)
			c.add(Restrictions.eq(columnName, value));
		if(Factory.UserLoginModel.getUser().getRole().getRole_id()==1)
			c.add(Restrictions.ne("role.role_id", 1));
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

}
