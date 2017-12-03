package dao;

import model.LoginModel;

public interface UserLoginDao {

	public boolean validateUserName();
	public LoginModel getUserDetail(String userName);
}
