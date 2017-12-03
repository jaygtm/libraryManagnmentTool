package page;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import newobject.UseFactory;

public class DashboardPage implements ActionListener {
	final JFrame MainFrame;
	
	public DashboardPage(String ProjectName){
		MainFrame = new JFrame(ProjectName);
		try{
			MainFrame.setSize(700, 600);
			MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			MainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			//final JButton btnLogin = new JButton("Click to login");
			MainFrame.setLayout(new FlowLayout());
			URL fileUrl = getClass().getResource("..//img//books_vintage_paper_cards_notebook_retro_74362_2560x1600.jpg");
			if(fileUrl != null){
				ImageIcon img = new ImageIcon(fileUrl);
				MainFrame.setContentPane(new JLabel(img));
			}
			LoginDialog loginDialog = new LoginDialog(MainFrame);
			MainFrame.setVisible(true);
			loginDialog.setVisible(true);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		//MainFrame.getContentPane().add(btnLogin);
		//btnLogin.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new LoginDialog(MainFrame);
		
	}

}


