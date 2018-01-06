
package page;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import common.service.DialogService;
import common.service.Factory;


public class FirstTimeDbConfig extends JDialog implements ActionListener {
	 
    private JTextField pfPassword;
    private JTextField port;
    private JLabel UserType;
    private JLabel AdminIp;
    private JLabel AdminPort;
    private JButton Submit;
    private JButton btnCancel;
    private JFrame parent;
    private JComboBox cb;
 
    public FirstTimeDbConfig(JFrame parent) {
        super(parent, "Database Configuration", true);
        this.parent = parent; 
      
        InetAddress localhost = null;
      		try {
      			localhost = InetAddress.getLocalHost();
      		} catch (UnknownHostException e1) {
      			e1.printStackTrace();
      		}
              System.out.println("System IP Address : " +
                            (localhost.getHostAddress()).trim());
        JPanel panel = new JPanel(new GridBagLayout());
        JPanel panel0 = new JPanel();
        GridBagConstraints cs = new GridBagConstraints();
 
        cs.fill = GridBagConstraints.HORIZONTAL;
 
        UserType = new JLabel("User Type: ");
        UserType.setAlignmentX(0);
        panel0.add(UserType);
 
        
        String type[]={"Admin","User"};        
        cb=new JComboBox(type);    
        cb.setPreferredSize(new Dimension(200,25));
        cb.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				int a = cb.getSelectedIndex();
				if(a==1){
					pfPassword.setText("");
					pfPassword.setEditable(true);
				}else if(a==0){
					 InetAddress localhost2 = null;
			      		try {
			      			localhost2 = InetAddress.getLocalHost();
			      		} catch (UnknownHostException e1) {
			      			e1.printStackTrace();
			      		}
					pfPassword.setText((localhost2.getHostAddress()).trim());
					pfPassword.setEditable(false);
				}
					
					
			}
		});
        panel0.add(cb);
 
      
        
        AdminIp = new JLabel("Admin Ip Adderss: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(AdminIp, cs);
 
        pfPassword = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        pfPassword.setEditable(false);
        pfPassword.setText((localhost.getHostAddress()).trim());
        panel.add(pfPassword, cs);
        
        AdminPort = new JLabel("Admin Port No: ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(AdminPort, cs);
 
        port = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        port.setText("3306");
        panel.add(port, cs);
        panel.setBorder(new LineBorder(Color.GRAY));
 
        Submit = new JButton("Submit");
        Submit.setBackground(Factory.loginBtnColor);
        Submit.addActionListener(this);
        
        btnCancel = new JButton("Cancel");
    	btnCancel.setBackground(Factory.cancleBtnColor);
        btnCancel.addActionListener(this);
        JPanel bp = new JPanel();
        bp.add(Submit);
        Submit.addKeyListener(new KeyListener() {
			
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
				submitProcess();
			}
		});
        
        
        bp.add(btnCancel);
        getContentPane().add(panel0, BorderLayout.PAGE_START);
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
    }
 
    public String getPassword() {
        return new String(pfPassword.getText());
    }
 
  
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		System.out.println("Action for "+cmd);
		FirstTimeDbConfig d= this;
		switch(cmd){
			case "Submit":	EventQueue.invokeLater( new Runnable() {
				public void run() {
					boolean status=Factory.WriteProperties(d.cb.getSelectedItem().toString(),d.getPassword(),d.port.getText());
					if(status)
						DialogService.showMgs(Factory.getMainFrame(), "Configuration Successfully please start software again", "Success");	
					else
						DialogService.showErrorMgs(Factory.getMainFrame(), "Configuration UnSuccessfully please try again", "Error");
					parent.dispose();
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
	
	
	private void submitProcess(){
		FirstTimeDbConfig d= this;
		EventQueue.invokeLater( new Runnable() {
			public void run() {
				boolean status=Factory.WriteProperties(d.cb.getSelectedItem().toString(),d.getPassword(),d.port.getText());
				if(status)
					DialogService.showMgs(Factory.getMainFrame(), "Configuration Successfully please start software again", "Success");	
				else
					DialogService.showErrorMgs(Factory.getMainFrame(), "Configuration UnSuccessfully please try again", "Error");
				parent.dispose();
				
			}
		});
	}
}
