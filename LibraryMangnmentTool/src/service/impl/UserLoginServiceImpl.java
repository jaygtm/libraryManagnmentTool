package service.impl;

import java.util.List;

import dao.UserLoginDao;
import model.LoginUserDetail;
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
	public boolean validateUserName(String username, String password) {
		return userLoginDao.validateUserName(username, password);
	}

	@Override
	public LoginUserDetail getUserDetail(String userName) {
		// TODO Auto-generated method stub
		return userLoginDao.getUsrAllDetail(userName);
	}

	@Override
	public List<LoginUserDetail> getAllUser() {
		return userLoginDao.getAllUser();
	}

	

	
}
