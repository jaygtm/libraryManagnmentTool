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
import model.CustomerModel;
import model.UserLoginModel;
import model.UserRole;

public class UserLoginDaoImpl implements UserLoginDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<UserLoginModel> getUserDetail(String userName,String password) {

		List<UserLoginModel> list=new LinkedList<UserLoginModel>();
		Session seession = Factory.sessionfactory.openSession();
		seession.beginTransaction();
		Criteria c = seession.createCriteria(UserLoginModel.class);
		c.add(Restrictions.eq("user_name", userName));
		c.add(Restrictions.eq("user_passwprd", password));
		list = c.list();
		seession.close();
		return list;
			
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UserLoginModel> getUserDetail(String userName) {

		List<UserLoginModel> list=new LinkedList<UserLoginModel>();
		Session seession = Factory.sessionfactory.openSession();
		seession.beginTransaction();
		Criteria c = seession.createCriteria(UserLoginModel.class);
		c.add(Restrictions.eq("user_name", userName));
		list = c.list();
		seession.close();
		return list;
			
	}

	@Override
	public boolean saveUser(UserLoginModel loginUserDetail) {
		Session session = Factory.sessionfactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(loginUserDetail);
		session.beginTransaction().commit();
		System.out.println("done..!");
			return true;
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
		UserLoginModel deletcustomerId=(UserLoginModel) session.load(UserLoginModel.class,new Integer(value));
		Transaction tx = session.beginTransaction();
		session.delete(deletcustomerId);
        System.out.println("UserLoginModel Object Deleted successfully.....!!");
        tx.commit();
        session.close();
		return true;
	
	}
	/*

	@Override
	public UserModel getUserDetail(String userName) {
		UserLoginModel detail= getUsrAllDetail(userName);
		if(detail != null){
			if(detail.getIdPass().getUser_name().equals(userName))
				return detail.getIdPass();
			else
				return null;
		}else
			return null;
	}

	@Override
	public boolean validateUserName(String username, String password) {
		UserModel userModel = getUserDetail(username);
	//	LoginUserDetail LoginUserDetail=getUsrAllDetail(username);
		if(userModel != null){
			if(userModel.getUser_passwprd().equals(password)){
				Factory.loginUserDetail= getUsrAllDetail(username);
				return true;
			}
			else
				return false;
		}else
			return false;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LoginUserDetail> getAllUser() {
		Session seession = Factory.sessionfactory.openSession();
		seession.beginTransaction();
		List<LoginUserDetail> list = seession.createCriteria(LoginUserDetail.class).list();
		seession.close();
		return list;
	}
	
	@Override
	public List<LoginUserDetail> getSearchUserList(String searchBy,String value) {
		String columnName="";
		List<LoginUserDetail> list=new LinkedList<LoginUserDetail>();
		if(searchBy.equals("Name")){
			columnName="user_name";
		}else if(searchBy.equals("Mobile")){
			columnName="user_mobile";
		}
		
		if(columnName.equals("")){
			return list;
		}
		Session seession = Factory.sessionfactory.openSession();
		seession.beginTransaction();
		Criteria c = seession.createCriteria(LoginUserDetail.class);
		c.add(Restrictions.eq(columnName, value));
		list = c.list();
		seession.close();
		return list;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public LoginUserDetail getUsrAllDetail(String username){
		Session session = Factory.sessionfactory.openSession();
		Transaction tx = null;
		List<LoginUserDetail> list=new ArrayList<LoginUserDetail>();
		int id=getUserId(username);
		if(id!=0){
	     try {
	         tx = session.beginTransaction(); 
	         Criteria c=session.createCriteria(LoginUserDetail.class);  
	         c.add(Restrictions.eq("user_id", id));//salary is the propertyname  
	         list=c.list();  

	     } catch (HibernateException ex) {
	         if (tx != null) {
	             tx.rollback();
	         }            
	         ex.printStackTrace(System.err);
	     } finally {
	    	 session.close(); 
	     }
	    
	     if(list.isEmpty())
	    	 return null;
	     else
	    	 return list.get(0);
		}else
			return null;
	}
	private int getUserId(String username){

		Session session = Factory.sessionfactory.openSession();
		Transaction tx = null;
		List<UserModel> list=new ArrayList<UserModel>();
		
		
	     try {
	         tx = session.beginTransaction(); 
	         Criteria c=session.createCriteria(UserModel.class);  
	         c.add(Restrictions.eq("user_name", username));//salary is the propertyname  
	         list=c.list();  

	     } catch (HibernateException ex) {
	         if (tx != null) {
	             tx.rollback();
	         }            
	         ex.printStackTrace(System.err);
	     } finally {
	    	 session.close(); 
	     }
	     if(list.size()==0)
	    	 return 0;
	     else
	    	 return list.get(0).getUser_id_info();
		
	}

	@Override
	public LoginUserDetail userLoginDao(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveUser(LoginUserDetail loginUserDetail) {
		Session session = Factory.sessionfactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(loginUserDetail);
		session.beginTransaction().commit();
		System.out.println("done..!");
			return true;
	}

	@Override
	public List<UserRole> getUserRoleList() {

		Session session = Factory.sessionfactory.openSession();
		Transaction tx = null;
		List<UserRole> list=new ArrayList<UserRole>();
	     try {
	         tx = session.beginTransaction(); 
	         Criteria c=session.createCriteria(UserRole.class);  
	         list=c.list();  
	     } catch (HibernateException ex) {
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

*/

	}
