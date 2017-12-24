package service.impl;

import java.util.List;

import dao.UserLoginDao;
import model.UserLoginModel;
import model.UserRole;
import service.UserLoginService;
public class UserLoginServiceImpl implements UserLoginService {
	
	private UserLoginDao userLoginDao;

	public UserLoginDao getUserLoginDao() {
		return userLoginDao;
	}

	public void setUserLoginDao(UserLoginDao userLoginDao) {
		this.userLoginDao = userLoginDao;
	}

	@Override
	public List<UserLoginModel> getUserDetail(String userName, String password) {
		return userLoginDao.getUserDetail(userName, password);
	}

	@Override
	public List<UserLoginModel> getSearchUserList(String searchBy, String value){
		return userLoginDao.getSearchUserList(searchBy, value);
	}
	
	@Override
	public boolean saveUser(UserLoginModel loginUserDetail){
		return userLoginDao.saveUser(loginUserDetail);
	}
	
	@Override
	public List<UserRole> getUserRoleList(){
		return userLoginDao.getUserRoleList();
	}

	@Override
	public List<UserLoginModel> getUserDetail(String userName) {
		return userLoginDao.getUserDetail(userName);
	}

	@Override
	public boolean deleteCustomerDetail(int value) {
		return userLoginDao.deleteCustomerDetail(value);
		
	}
	
}
