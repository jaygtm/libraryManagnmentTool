package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="txn_usr_login")
public class UserModel {
	@Id
	private int user_id;
	private String user_name;
	private String user_passwprd;
	private Date user_lastLogin;
	private int user_id_info;
	public int getUser_id_info() {
		return user_id_info;
	}
	public void setUser_id_info(int user_id_info) {
		this.user_id_info = user_id_info;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_passwprd() {
		return user_passwprd;
	}
	public void setUser_passwprd(String user_passwprd) {
		this.user_passwprd = user_passwprd;
	}
	public Date getUser_lastLogin() {
		return user_lastLogin;
	}
	public void setUser_lastLogin(Date user_lastLogin) {
		this.user_lastLogin = user_lastLogin;
	}
	
	
}
