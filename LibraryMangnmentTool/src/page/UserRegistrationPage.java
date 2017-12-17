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
import model.LoginUserDetail;
import model.UserModel;
import model.UserRole;
import service.impl.UserLoginServiceImpl;

public class UserRegistrationPage extends JPanel implements ActionListener {

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private List<UserRole> roleobject=new ArrayList<>();
	
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
		return textField;
	}
	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
	public JTextField getTextField_1() {
		return textField_1;
	}
	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}
	public JTextField getTextField_2() {
		return textField_2;
	}
	public void setTextField_2(JTextField textField_2) {
		this.textField_2 = textField_2;
	}
	public JTextField getTextField_3() {
		return textField_3;
	}
	public void setTextField_3(JTextField textField_3) {
		this.textField_3 = textField_3;
	}
	public JTextField getTextField_4() {
		return textField_4;
	}
	public void setTextField_4(JTextField textField_4) {
		this.textField_4 = textField_4;
	}
	public JTextField getTextField_9() {
		return textField_9;
	}
	public void setTextField_9(JTextField textField_9) {
		this.textField_9 = textField_9;
	}
	public JTextField getTextField_5() {
		return textField_5;
	}
	public void setTextField_5(JTextField textField_5) {
		this.textField_5 = textField_5;
	}
	private JTextField textField_4;
	private JTextField textField_9;
	private JTextField textField_5;
	private JComboBox comboBox;
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
	
	textField = new JTextField();
	textField.setBounds(274, 110, 243, 20);
	add(textField);
	textField.setColumns(10);
	
	
	JLabel lblUserRole = new JLabel("User Role:-");
	lblUserRole.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
	lblUserRole.setBounds(581, 187, 99, 14);
	add(lblUserRole);
	
	comboBox = new JComboBox(userRolelist);
	comboBox.setBounds(722, 186, 243, 20);
	comboBox.setSelectedItem("1");
	
	add(comboBox);
	
	JLabel lblUserMobile = new JLabel("User Mobile:-");
	lblUserMobile.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
	lblUserMobile.setBounds(126, 186, 98, 17);
	add(lblUserMobile);
	
	textField_1 = new JTextField();
	textField_1.setBounds(274, 186, 244, 20);
	add(textField_1);
	textField_1.setColumns(10);
	
	JLabel lblAdharid = new JLabel("Adhar/Id No.:-");
	lblAdharid.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
	lblAdharid.setBounds(578, 254, 115, 20);
	add(lblAdharid);
	
	textField_2 = new JTextField();
	textField_2.setBounds(722, 256, 243, 20);
	add(textField_2);
	textField_2.setColumns(10);
	
	JLabel lblAddress = new JLabel("Address:-");
	lblAddress.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
	lblAddress.setBounds(126, 256, 115, 17);
	add(lblAddress);
	
	textField_3 = new JTextField();
	textField_3.setBounds(275, 257, 243, 17);
	add(textField_3);
	textField_3.setColumns(10);
	
	JLabel lblUserIdany = new JLabel("Login Id(any):-");
	lblUserIdany.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
	lblUserIdany.setBounds(578, 326, 125, 17);
	add(lblUserIdany);
	
	textField_4 = new JTextField();
	textField_4.setBounds(722, 326, 243, 20);
	add(textField_4);
	textField_4.setColumns(10);
	
	JLabel lblPassword = new JLabel("PassWord :-");
	lblPassword.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
	lblPassword.setBounds(126, 327, 98, 14);
	add(lblPassword);
	
	textField_5 = new JTextField();
	textField_5.setBounds(275, 326, 243, 20);
	add(textField_5);
	textField_5.setColumns(10);
	
	JLabel lblUserId = new JLabel("User Id:-");
	lblUserId.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
	lblUserId.setBounds(581, 113, 71, 14);
	add(lblUserId);
	
	textField_9 = new JTextField();
	textField_9.setEditable(false);
	textField_9.setBounds(722, 110, 243, 20);
	add(textField_9);
	textField_9.setColumns(10);
	
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
				//UserRegistrationPage model =validateAndGetData();
				//if(model != null){
				LoginUserDetail loginUserDetail=new LoginUserDetail();
				UserRole role=new UserRole();
				UserModel mod=new UserModel();
				loginUserDetail.setUser_addr(textField_3.getText());
				loginUserDetail.setUser_name(textField.getText());
				loginUserDetail.setUser_mobile(textField_1.getText());
				loginUserDetail.setUser_idNo(textField_2.getText());
				mod.setUser_name(textField_9.getText());
				mod.setUser_passwprd(textField_5.getText());
				mod.setUser_lastLogin(new Date());
				loginUserDetail.setIdPass(mod);
				UserRole roleSelected=null;
				for(int j=0;j<self.getRole().size();j++){
					UserRole rool=(self.getRole()).get(j);
					if(rool.getRole_name().equals(comboBox.getSelectedItem())){
						roleSelected=rool;
					}
					
				}
				loginUserDetail.setUsrRole(roleSelected);
				//loginUserDetail.se);
					UserLoginServiceImpl userLoginServiceImpl = (UserLoginServiceImpl) Factory.getContext().getBean("loginService");
					boolean status = userLoginServiceImpl.saveUser(loginUserDetail);
					System.out.println("Status of Save");
					if(status)
						DialogService.showMgs(Factory.getMainFrame(), "Save Successfully..!", "Success");
					else
						DialogService.showErrorMgs(Factory.getMainFrame(), "Error to Save ..!", "Error");
				//}
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
	
}
