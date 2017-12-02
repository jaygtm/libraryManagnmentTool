package common.service;

import java.awt.Component;

import javax.swing.JOptionPane;

public class DialogService {
	
	public static void showMgs(Component parant,String mgs,String title){
		JOptionPane.showMessageDialog(parant,mgs,title,JOptionPane.INFORMATION_MESSAGE);
	}
	public static void showErrorMgs(Component parant,String mgs,String title){
		JOptionPane.showMessageDialog(parant,mgs,title,JOptionPane.ERROR_MESSAGE);
	}
	

}
