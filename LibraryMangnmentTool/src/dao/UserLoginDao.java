package dao;

import java.util.Date;
import java.util.List;

import model.TransectionHistoryModel;
import model.UserLoginModel;
import model.UserRole;

public interface UserLoginDao {

	List<UserLoginModel> getUserDetail(String userName, String password);

	boolean saveUser(UserLoginModel loginUserDetail);

	List<UserLoginModel> getSearchUserList(String searchBy, String value);

	List<UserRole> getUserRoleList();

	List<UserLoginModel> getUserDetail(String userName);

	boolean deleteCustomerDetail(int value);

	List<TransectionHistoryModel> getTxnhistoryList(Date fromDate, Date toDate);}
