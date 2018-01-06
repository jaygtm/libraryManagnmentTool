package page;

import java.awt.Dimension;
import java.awt.EventQueue;
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
import javax.swing.JPanel;

import org.hibernate.Session;

import common.service.DialogService;
import common.service.Factory;


public class DashboardPage implements ActionListener {
	final JFrame MainFrame;
	
	public DashboardPage(String ProjectName,String newUser){
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
			
			try{
				Session seession = Factory.sessionfactory.openSession();
				seession.beginTransaction();
				MainFrame.getContentPane().setLayout(null);
				MainFrame.setJMenuBar(getMenuBar());
				MainFrame.setVisible(true);
				if(newUser.equals("newUser")){
					FirstTimeDbConfig loginDialog = new FirstTimeDbConfig(MainFrame);
					loginDialog.setVisible(true);
					Factory.setMainFrame(MainFrame);
				}else{
					LoginDialog loginDialog = new LoginDialog(MainFrame);
					loginDialog.setVisible(true);
					Factory.setMainFrame(MainFrame);
				}
			}catch(Exception e){
				e.printStackTrace();
				MainFrame.getContentPane().setLayout(null);
				MainFrame.setJMenuBar(getMenuBar());
				MainFrame.setVisible(true);
				DialogService.showErrorMgs(Factory.getMainFrame(), "Check your lan connection try again", "Error");
				MainFrame.dispose();
			}
			
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
		String cmd = e.getActionCommand();
		DashboardPage d= this;
		JPanel bodyPanel=Factory.getBodyPanal();
		switch(cmd){
				case "Add Book":	EventQueue.invokeLater( new Runnable() {
					public void run() {
						bodyPanel.removeAll();
						AddBookPage addbook=new AddBookPage(false,null);
						bodyPanel.add(addbook);	
						Factory.refresh();						
					}
				});
				break;
				case "Edit Book Details":	EventQueue.invokeLater( new Runnable() {
					public void run() {
						bodyPanel.removeAll();
						BookListPage booklist=new BookListPage();
						bodyPanel.add(booklist);
						booklist.btnNewButton_8.setEnabled(false);
						booklist.btnNewButton_10.setEnabled(false);
						Factory.refresh();
					}
				});
				break;
				case "Delete Book":	EventQueue.invokeLater( new Runnable() {
					public void run() {
						bodyPanel.removeAll();
						BookListPage booklist=new BookListPage();
						bodyPanel.add(booklist);
						booklist.btnNewButton_8.setEnabled(false);
						booklist.btnNewButton_9.setEnabled(false);
						Factory.refresh();
					}
				});
				break;
				case "View Books":	EventQueue.invokeLater( new Runnable() {
					public void run() {
						bodyPanel.removeAll();
						BookListPage booklist=new BookListPage();
						bodyPanel.add(booklist);
						booklist.btnNewButton_8.setEnabled(false);
						booklist.btnNewButton_10.setEnabled(false);
						booklist.btnNewButton_9.setEnabled(false);
						Factory.refresh();
					}
				});
				break;
				case "View Issue Book":	EventQueue.invokeLater( new Runnable() {
					public void run() {
						
					}
				});
				break;
				case "View Available Book":	EventQueue.invokeLater( new Runnable() {
					public void run() {
						
					}
				});
				break;
				case "View Book History":	EventQueue.invokeLater( new Runnable() {
					public void run() {
						
					}
				});
				break;
				case "Add Student":	EventQueue.invokeLater( new Runnable() {
					public void run() {
						bodyPanel.removeAll();
						RegistrationPage registrationPage=new RegistrationPage();
						registrationPage.registrationPage(bodyPanel);
						Factory.refresh();
					}
				});
				break;
				case "Edit Student Details":	EventQueue.invokeLater( new Runnable() {
					public void run() {
						bodyPanel.removeAll();
						bodyPanel.add(new StudentList());
						Factory.refresh();
					}
				});
				break;
				case "Delete Student":	EventQueue.invokeLater( new Runnable() {
					public void run() {
						bodyPanel.removeAll();
						bodyPanel.add(new StudentList());
						Factory.refresh();
					}
				});
				break;
				case "ShowAll Student":	EventQueue.invokeLater( new Runnable() {
					public void run() {
						bodyPanel.removeAll();
						bodyPanel.add(new StudentList());
						Factory.refresh();
					}
				});
				break;
				case "User Delete":	EventQueue.invokeLater( new Runnable() {
					public void run() {
						UserList uslist=new UserList();
						bodyPanel.removeAll();
						bodyPanel.add(uslist);
						uslist.btnNewButton_9.setEnabled(false);
						uslist.btnNewButton_8.setEnabled(false);
						Factory.refresh();
					}
				});
				break;
				case "User Creation":	EventQueue.invokeLater( new Runnable() {
					public void run() {
						Factory.homePage();
						UserRegistrationPage registrationPage=new UserRegistrationPage();
						Factory.getBodyPanal().removeAll();
						Factory.getBodyPanal().add(registrationPage);
						Factory.refresh();
					}
				});
				break;
				case "User Modify":	EventQueue.invokeLater( new Runnable() {
					public void run() {
						UserList uslist=new UserList();
						bodyPanel.removeAll();
						bodyPanel.add(uslist);
						uslist.btnNewButton_10.setEnabled(false);
						uslist.btnNewButton_8.setEnabled(false);
						Factory.refresh();
					}
				});
				break;
				case "View All User":	EventQueue.invokeLater( new Runnable() {
					public void run() {
						UserList uslist=new UserList();
						bodyPanel.removeAll();
						bodyPanel.add(uslist);
						uslist.btnNewButton_9.setEnabled(false);
						uslist.btnNewButton_8.setEnabled(false);
						uslist.btnNewButton_10.setEnabled(false);
						Factory.refresh();
					}
				});
				break;
		
	}
		
	}

}


