package page;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import common.service.DialogService;
import common.service.Factory;
import model.LoginUserDetail;
import service.UserLoginService;


public class LoginDialog extends JDialog implements ActionListener {
	 
    private JTextField tfUsername;
    private JPasswordField pfPassword;
    private JLabel lbUsername;
    private JLabel lbPassword;
    private JButton btnLogin;
    private JButton btnCancel;
    private boolean succeeded;
    private JFrame parent;
 
    public LoginDialog(JFrame parent) {
        super(parent, "Login", true);
        //
        this.parent = parent; 
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();
 
        cs.fill = GridBagConstraints.HORIZONTAL;
 
        lbUsername = new JLabel("Username: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(lbUsername, cs);
 
        tfUsername = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(tfUsername, cs);
 
        lbPassword = new JLabel("Password: ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(lbPassword, cs);
 
        pfPassword = new JPasswordField(20);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        panel.add(pfPassword, cs);
        panel.setBorder(new LineBorder(Color.GRAY));
 
        btnLogin = new JButton("Login");
        btnLogin.setBackground(Factory.loginBtnColor);
        btnLogin.addActionListener(this);
        
        btnCancel = new JButton("Cancel");
    	btnCancel.setBackground(Factory.cancleBtnColor);
        btnCancel.addActionListener(this);
        JPanel bp = new JPanel();
        bp.add(btnLogin);
        btnLogin.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("key Code"+e.getKeyCode());
				loginProcess();
			}
		});
        
        
        bp.add(btnCancel);
 
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.PAGE_END);
 
        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
        
        this.addWindowListener(new WindowAdapter() {
        	@Override
        	public void windowClosing(WindowEvent e) {
        		super.windowClosing(e);
        		System.exit(1);
        	}
        	
		});
        lockMode();
    }
 
    public String getUsername() {
        return tfUsername.getText().trim();
    }
 
    public String getPassword() {
        return new String(pfPassword.getPassword());
    }
 
    public boolean isSucceeded() {
        return succeeded;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		System.out.println("Action for "+cmd);
		LoginDialog d= this;
		switch(cmd){
			case "Login":	EventQueue.invokeLater( new Runnable() {
				public void run() {
					String uname = getUsername();
					String pass = getPassword();
					if(uname.trim().equals("") || pass.trim().equals("")){
						DialogService.showErrorMgs(Factory.getMainFrame(), "Username and Password can't be blank..!", "Invaild User");
					}else{
						UserLoginService userLoginService = (UserLoginService) Factory.getContext().getBean("loginService");
						boolean result = userLoginService.validateUserName(uname,pass);
						//LoginUserDetail name=userLoginService.getUserDetail(uname);
						//Factory.loginUserDetail=userLoginService.getUserDetail(uname);
						if(result){
							if(!Factory.lockModeOn){
								Factory.lockModeOn=false;
								NevigationMenueBar n =new NevigationMenueBar(Factory.loginUserDetail.getUser_name());
								n.manueBar(parent);
								parent.revalidate();
								parent.repaint();
							}
							dispose();
						}else
							DialogService.showErrorMgs(Factory.getMainFrame(), "Please Enter valid Username and password .!", "Invaild User");
					}
					
				}
			});
				
							
				break;
			case "Cancel":
				EventQueue.invokeLater( new Runnable() {
					@Override
					public void run() {
						parent.dispose();
					}
				});
				break;
		}
		
	}
	
	
	private void loginProcess(){
		EventQueue.invokeLater( new Runnable() {
			public void run() {
				String uname = getUsername();
				String pass = getPassword();
				if(uname.trim().equals("") || pass.trim().equals("")){
					DialogService.showErrorMgs(Factory.getMainFrame(), "Username and Password can't be blank..!", "Invaild User");
				}else{
					UserLoginService userLoginService = (UserLoginService) Factory.getContext().getBean("loginService");
					boolean result = userLoginService.validateUserName(uname,pass);
					LoginUserDetail name=userLoginService.getUserDetail(uname);
					if(result){
						NevigationMenueBar n =new NevigationMenueBar(name.getUser_name());
						n.manueBar(parent);
						parent.revalidate();
						parent.repaint();
						dispose();
					}else
						DialogService.showErrorMgs(Factory.getMainFrame(), "Please Enter valid Username and password .!", "Invaild User");
				}
				
			}
		});
	}
	public void lockMode(){
		if(Factory.lockModeOn){
        	btnCancel.setEnabled(false);
			tfUsername.setText(Factory.loginUserDetail.getIdPass().getUser_name());
			tfUsername.setEditable(false);
			setVisible(true);
        }
	}
}
