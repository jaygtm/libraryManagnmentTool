package model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="mst_user")
public class LoginUserDetail {
	@Id
	@GeneratedValue
     private int user_id;
    // private int user_roleId;
     private String user_mobile, user_idNo, user_addr,user_name;
     @OneToOne(fetch = FetchType.EAGER)
 	 @JoinColumn(name="user_roleId")
     private UserRole usrRole;
     @OneToOne(cascade = CascadeType.ALL)
 	@JoinTable(name = "txn_usr_login", joinColumns = { @JoinColumn(name = "user_id_info") }, inverseJoinColumns = { @JoinColumn(name = "user_id") })
     private UserModel idPass;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
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
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public UserRole getUsrRole() {
		return usrRole;
	}
	public void setUsrRole(UserRole usrRole) {
		this.usrRole = usrRole;
	}
	public UserModel getIdPass() {
		return idPass;
	}
	public void setIdPass(UserModel idPass) {
		this.idPass = idPass;
	}
}
