package service;

import java.util.List;

import model.LoginUserDetail;
import model.UserModel;

public interface UserLoginService {
	public boolean validateUserName(String username ,String password);
	public LoginUserDetail getUserDetail(String userName);
	public List<LoginUserDetail> getAllUser();
	List<LoginUserDetail> getSearchStudentList(String searchBy, String value);
}
