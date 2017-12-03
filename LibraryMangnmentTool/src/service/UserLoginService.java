package service;

import java.util.List;

import model.UserModel;

public interface UserLoginService {
	public boolean validateUserName(String username ,String password);
	public UserModel getUserDetail(String userName);
	public List<UserModel> getAllUser();
}
