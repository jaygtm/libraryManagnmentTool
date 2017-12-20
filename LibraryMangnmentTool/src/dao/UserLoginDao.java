package dao;

import java.util.List;

import model.UserLoginModel;
import model.UserRole;

public interface UserLoginDao {

	List<UserLoginModel> getUserDetail(String userName, String password);

	boolean saveUser(UserLoginModel loginUserDetail);

	List<UserLoginModel> getSearchUserList(String searchBy, String value);

	List<UserRole> getUserRoleList();

	List<UserLoginModel> getUserDetail(String userName);}
