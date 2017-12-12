package service;

import java.util.List;

import model.LoginUserDetail;
import model.UserModel;

public interface UserLoginService {
	public boolean validateUserName(String username ,String password);
	public LoginUserDetail getUserDetail(String userName);
	public List<UserModel> getAllUser();
}
