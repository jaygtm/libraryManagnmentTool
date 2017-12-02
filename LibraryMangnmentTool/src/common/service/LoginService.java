package common.service;

public class LoginService {
	
	public static boolean validateUserNamePassword(String username,String password){
		if(username.equals("admin") && password.equals("123"))
			return true;
		else
			return false;
	}

}
