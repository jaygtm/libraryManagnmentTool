package page;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import common.service.Factory;


public class DashboardPage implements ActionListener {
	final JFrame MainFrame;
	
	public DashboardPage(String ProjectName){
		MainFrame = new JFrame(ProjectName);
		try{
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

			int width = (int) screenSize.getWidth();

			int height = (int) screenSize.getHeight();
			MainFrame.setSize(width, height);
			MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			MainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			URL fileUrl = DashboardPage.class.getResource("/books_vintage_paper_cards_notebook_retro_74362_2560x1600.jpg");
			if(fileUrl != null){
				ImageIcon img = new ImageIcon(fileUrl);
				MainFrame.setContentPane(new JLabel(img));
			}
			FirstTimeDbConfig loginDialog = new FirstTimeDbConfig(MainFrame);
			MainFrame.getContentPane().setLayout(null);
			MainFrame.setJMenuBar(getMenuBar());
			MainFrame.setVisible(true);
			loginDialog.setVisible(true);
			Factory.setMainFrame(MainFrame);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
				
	}
	private JMenuBar getMenuBar() {
		String menu[] = {"Books Menu","Student","User","Action","Security","More","AboutUs"};
		String menuItemArray[][] = {{"Add Book","Edit Book Details","Delete Book","View Books","View Issue Book","View Available Book","View Book History"},
									{"Add Student","Edit Student Details","Delete Student","ShowAll Student","View Student Books History"},
									{"User Creation","User Delete","User Right Asgin","User Modify","View All User"},
									{"Issue Book","Submit Book"},
									{"Add Privacy","Remove Privacy"},
									{"Add Memo","View Memo","Delte Memo"},
									{"About Company"}
								   } ;
		
		JMenuBar menubar = new JMenuBar();
		for (int i = 0; i < menu.length; i++) {
			JMenu jmenu = new JMenu(menu[i]);
			for (int j = 0; j < menuItemArray[i].length; j++) {
				JMenuItem item = new JMenuItem(menuItemArray[i][j]);
				item.addActionListener(this);
				
				jmenu.add(item);
			}
			menubar.add(jmenu);
		}
		return menubar;
	}
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		new LoginDialog(MainFrame);
		
	}

}


