package service;

import java.util.List;

import model.UserLoginModel;
import model.UserRole;

public interface UserLoginService {
	public List<UserLoginModel> getUserDetail(String userName, String password);
	public List<UserLoginModel> getUserDetail(String userName);
	boolean saveUser(UserLoginModel loginUserDetail);
	List<UserRole> getUserRoleList();
	List<UserLoginModel> getSearchUserList(String searchBy, String value);
	public boolean deleteCustomerDetail(int value);
}
