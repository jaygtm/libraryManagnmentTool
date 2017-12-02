package page;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;



import newobject.UseFactory;

public class DashboardPage implements ActionListener {
	final JFrame MainFrame;
	
	public DashboardPage(String ProjectName){
		MainFrame = new JFrame(ProjectName);
		MainFrame.setSize(700, 600);
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//final JButton btnLogin = new JButton("Click to login");
		MainFrame.setLayout(new FlowLayout());
		
		LoginDialog loginDialog = new LoginDialog(MainFrame);
		MainFrame.setVisible(true);
		loginDialog.setVisible(true);
		
		//MainFrame.getContentPane().add(btnLogin);
		//btnLogin.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new LoginDialog(MainFrame);
		
	}

}


