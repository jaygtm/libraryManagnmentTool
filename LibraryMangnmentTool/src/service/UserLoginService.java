package service;

import java.util.List;

import model.LoginUserDetail;
import model.UserModel;
import model.UserRole;

public interface UserLoginService {
	public boolean validateUserName(String username ,String password);
	public LoginUserDetail getUserDetail(String userName);
	public List<LoginUserDetail> getAllUser();
	boolean saveUser(LoginUserDetail loginUserDetail);
	List<UserRole> getUserRoleList();
	List<LoginUserDetail> getSearchUserList(String searchBy, String value);
}
