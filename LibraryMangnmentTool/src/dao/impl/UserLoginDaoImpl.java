package dao.impl;

import java.util.List;

import org.hibernate.Session;

import common.service.Factory;
import dao.UserLoginDao;
import model.UserModel;

public class UserLoginDaoImpl implements UserLoginDao {

	@Override
	public UserModel getUserDetail(String userName) {
		List<UserModel> list = getAllUser();
		for(UserModel m:list ){
			if(m.getUser_name().trim().equals(userName))
				return m;
		}
		return null;
	}

	@Override
	public boolean validateUserName(String username, String password) {
		UserModel userModel = getUserDetail(username);
		if(userModel != null){
			if(userModel.getUser_passwprd().equals(password))
				return true;
			else
				return false;
		}else
			return false;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserModel> getAllUser() {
		Session seession = Factory.sessionfactory.openSession();
		seession.beginTransaction();
		List<UserModel> list = seession.createCriteria(UserModel.class).list();
		seession.close();
		return list;
	}
	
	

}
