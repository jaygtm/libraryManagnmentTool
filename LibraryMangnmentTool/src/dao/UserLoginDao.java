package dao;

import java.util.List;

import model.LoginUserDetail;
import model.UserModel;

public interface UserLoginDao {
	public boolean validateUserName(String username ,String password);
	public UserModel getUserDetail(String userName);
	public List<LoginUserDetail> getAllUser();
	LoginUserDetail getUsrAllDetail(String username);
}
