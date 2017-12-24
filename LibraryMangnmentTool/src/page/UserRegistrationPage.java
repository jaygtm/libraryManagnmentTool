package page;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import common.service.DialogService;
import common.service.Factory;
import model.UserLoginModel;
import model.UserModel;
import model.UserRole;
import service.impl.UserLoginServiceImpl;

public class UserRegistrationPage extends JPanel implements ActionListener {

	private JTextField name;
	private JTextField mobile;
	private JTextField aadhar;
	private JTextField address;
	private List<UserRole> roleobject=new ArrayList<>();
	private UserLoginModel UserLoginModelobj;
	
	public UserLoginModel getUserLoginModelobj() {
		return UserLoginModelobj;
	}

	public void setUserLoginModelobj(UserLoginModel userLoginModelobj) {
		UserLoginModelobj = userLoginModelobj;
	}
	String[] userRolelist;
	
	{
		userRolelist = getUserRoleList();
		
	}
	
	private String[] getUserRoleList(){
		UserLoginServiceImpl userLoginServiceImpl = (UserLoginServiceImpl) Factory.getContext().getBean("loginService");
		roleobject=userLoginServiceImpl.getUserRoleList();
		String[] roles=new String[roleobject.size()];
		for(int i=0;i<roleobject.size();i++){
			UserRole rl=(UserRole)roleobject.get(i);
			roles[i]=rl.getRole_name();
		}
		return roles;
	}

	public List<UserRole> getRole() {
		return roleobject;
	}

	public void setRole(List<UserRole> role) {
		this.roleobject = role;
	}

	public JTextField getTextField() {
		return name;
	}
	public void setTextField(JTextField textField) {
		this.name = textField;
	}
	public JTextField getTextField_1() {
		return mobile;
	}
	public void setTextField_1(JTextField textField_1) {
		this.mobile = textField_1;
	}
	public JTextField getTextField_2() {
		return aadhar;
	}
	public void setTextField_2(JTextField textField_2) {
		this.aadhar = textField_2;
	}
	public JTextField getTextField_3() {
		return address;
	}
	public void setTextField_3(JTextField textField_3) {
		this.address = textField_3;
	}
	public JTextField getTextField_4() {
		return loginId;
	}
	public void setTextField_4(JTextField textField_4) {
		this.loginId = textField_4;
	}
	public JTextField getTextField_9() {
		return userLoginId;
	}
	public void setTextField_9(JTextField textField_9) {
		this.userLoginId = textField_9;
	}
	public JTextField getTextField_5() {
		return password;
	}
	public void setTextField_5(JTextField textField_5) {
		this.password = textField_5;
	}
	private JTextField loginId;
	private JTextField userLoginId;
	private JTextField password;
	private JComboBox role;
	public UserRegistrationPage(){
		setBounds(10, 11, 1129, 571);
		setLayout(null);
	JLabel lblUserResistrationForm = new JLabel("User Resistration Form");
	lblUserResistrationForm.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
	lblUserResistrationForm.setBounds(489, 11, 243, 34);
	add(lblUserResistrationForm);
	
	JSeparator separator = new JSeparator();
	separator.setBounds(10, 50, 1109, 8);
	add(separator);
	
	JSeparator separator_1 = new JSeparator();
	separator_1.setBounds(10, 497, 1109, 8);
	add(separator_1);

	JButton btnNewButton_9 = new JButton("Save");
	btnNewButton_9.setBackground(Factory.modifyBtnColor);
	btnNewButton_9.setBounds(850, 516, 115, 32);
	btnNewButton_9.setForeground(Factory.buttonTextColor);
	btnNewButton_9.addActionListener(this);
	add(btnNewButton_9);
	
	JButton btnNewButton_11 = new JButton("Cancel");
	btnNewButton_11.setBackground(Factory.cancleBtnColor);
	btnNewButton_11.setBounds(979, 514, 109, 34);
	btnNewButton_11.setForeground(Factory.buttonTextColor);
	btnNewButton_11.addActionListener(this);
	add(btnNewButton_11);
	JLabel lblName = new JLabel("Name:-");
	lblName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
	lblName.setBounds(126, 110, 98, 17);
	add(lblName);
	
	name = new JTextField();
	name.setBounds(274, 110, 243, 20);
	add(name);
	name.setColumns(10);
	
	
	JLabel lblUserRole = new JLabel("User Role:-");
	lblUserRole.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
	lblUserRole.setBounds(581, 187, 99, 14);
	add(lblUserRole);
	
	role = new JComboBox(userRolelist);
	role.setBounds(722, 186, 243, 20);
	role.setSelectedItem("1");
	
	add(role);
	
	JLabel lblUserMobile = new JLabel("User Mobile:-");
	lblUserMobile.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
	lblUserMobile.setBounds(126, 186, 98, 17);
	add(lblUserMobile);
	
	mobile = new JTextField();
	mobile.setBounds(274, 186, 244, 20);
	add(mobile);
	mobile.setColumns(10);
	
	JLabel lblAdharid = new JLabel("Adhar/Id No.:-");
	lblAdharid.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
	lblAdharid.setBounds(578, 254, 115, 20);
	add(lblAdharid);
	
	aadhar = new JTextField();
	aadhar.setBounds(722, 256, 243, 20);
	add(aadhar);
	aadhar.setColumns(10);
	
	JLabel lblAddress = new JLabel("Address:-");
	lblAddress.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
	lblAddress.setBounds(126, 256, 115, 17);
	add(lblAddress);
	
	address = new JTextField();
	address.setBounds(275, 257, 243, 17);
	add(address);
	address.setColumns(10);
	
	JLabel lblUserIdany = new JLabel("Login Id(any):-");
	lblUserIdany.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
	lblUserIdany.setBounds(578, 326, 125, 17);
	add(lblUserIdany);
	
	loginId = new JTextField();
	loginId.setBounds(722, 326, 243, 20);
	add(loginId);
	loginId.setColumns(10);
	
	JLabel lblPassword = new JLabel("PassWord :-");
	lblPassword.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
	lblPassword.setBounds(126, 327, 98, 14);
	add(lblPassword);
	
	password = new JTextField();
	password.setBounds(275, 326, 243, 20);
	add(password);
	password.setColumns(10);
	
	JLabel lblUserId = new JLabel("User Id:-");
	lblUserId.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
	lblUserId.setBounds(581, 113, 71, 14);
	add(lblUserId);
	
	userLoginId = new JTextField();
	userLoginId.setEditable(false);
	userLoginId.setBounds(722, 110, 243, 20);
	add(userLoginId);
	userLoginId.setColumns(10);
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand().trim();
		System.out.println(""+action);
		UserRegistrationPage self=this;
		switch (action) {
		case "Save":EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				UserLoginModel loginUserDetail =validateForm();
				if(loginUserDetail != null){
					UserLoginServiceImpl userLoginServiceImpl = (UserLoginServiceImpl) Factory.getContext().getBean("loginService");
					boolean status = userLoginServiceImpl.saveUser(loginUserDetail);
					System.out.println("Status of Save");
					if(status){
						DialogService.showMgs(Factory.getMainFrame(), "Save Successfully..!", "Success");
						Factory.getBodyPanal().removeAll();
						Factory.getBodyPanal().add(new UserList());
						Factory.refresh();
					}else
						DialogService.showErrorMgs(Factory.getMainFrame(), "Error to Save ..!", "Error");
				}
			}
		});
			break;

		case "Cancel":EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				Factory.getBodyPanal().removeAll();
				Factory.getBodyPanal().add(new UserList());
				Factory.refresh();
				
				
			}
		});
			break;

		default:
			break;
		}
		
	}
	
	private UserLoginModel validateForm(){
		
			if(!address.getText().equals("") && !name.getText().equals("") && !mobile.getText().equals("") && !loginId.getText().equals("")
					&& Factory.validateNumber(mobile.getText())	&& !aadhar.getText().equals("") && !password.getText().equals("")){
					UserRole roleSelected=null;
					for(int j=0;j<this.getRole().size();j++){
						UserRole rool=(this.getRole()).get(j);
						if(rool.getRole_name().equals(role.getSelectedItem())){
							roleSelected=rool;
						}
					}
					UserModel user=new UserModel();
					user.setUser_addr(address.getText());
					user.setUser_name(name.getText());
					user.setUser_mobile(mobile.getText());
					user.setUser_idNo(aadhar.getText());
					if(UserLoginModelobj!=null)
						user.setUser_id(UserLoginModelobj.getUser().getUser_id());
					user.setRole(roleSelected);
					
					UserLoginModel loginUserDetail=new UserLoginModel();
					if(!(userLoginId.getText()).equals(""))
						loginUserDetail.setUser_id(Integer.parseInt(userLoginId.getText()));
					loginUserDetail.setUser_passwprd(password.getText());
					loginUserDetail.setUser_lastLogin(new Date());
					loginUserDetail.setUser_name(loginId.getText());
					loginUserDetail.setUser(user);
					return loginUserDetail; 
			}else{
				DialogService.showErrorMgs(Factory.getMainFrame(), "please fill data properly", "Error");
				return null;
			}
	}
	
}
