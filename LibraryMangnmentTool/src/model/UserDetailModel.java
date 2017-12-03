package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mst_user")
public class UserDetailModel {
	@Id
	int user_id; 
	String user_name; 
	int user_roleId;
	String user_mobile; 
	String user_idNo; 
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
	public int getUser_roleId() {
		return user_roleId;
	}
	public void setUser_roleId(int user_roleId) {
		this.user_roleId = user_roleId;
	}
	public String getUser_mobile() {
		return user_mobile;
	}
	public void setUser_mobile(String user_mobile) {
		this.user_mobile = user_mobile;
	}
	public String getUser_idNo() {
		return user_idNo;
	}
	public void setUser_idNo(String user_idNo) {
		this.user_idNo = user_idNo;
	}
	public String getUser_addr() {
		return user_addr;
	}
	public void setUser_addr(String user_addr) {
		this.user_addr = user_addr;
	}
	String user_addr;
	

}
