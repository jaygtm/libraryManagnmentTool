package service.impl;

import dao.UserLoginDao;
import service.UserLoginService;

public class UserLoginServiceImpl implements UserLoginService {
	
	private UserLoginDao userLoginDao;

	@Override
	public boolean validateLogin(String username, String password) {
		return false;
	}

	
}
